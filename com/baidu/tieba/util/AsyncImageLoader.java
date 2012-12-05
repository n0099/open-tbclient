package com.baidu.tieba.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class AsyncImageLoader {
    public static final String BIG = "_big";
    public static final String SMALL = "_small";
    public static final String WATER = "_water";
    private Context mContext;
    private boolean mIspv;
    private boolean mNoPrefix;
    private boolean mQualityLower;
    private String mSuffix;
    private boolean mSupportHoldUrl;
    private ArrayList<BasicNameValuePair> infos = null;
    private int mImageWidth = 0;
    private int mImageHeight = 0;
    private LinkedList<ImageAsyncTask> mTasks = new LinkedList<>();
    private LinkedList<HoldData> mHoldData = new LinkedList<>();

    /* loaded from: classes.dex */
    public interface ImageCallback {
        void imageLoaded(Bitmap bitmap, String str, boolean z);
    }

    public AsyncImageLoader(Context context) {
        this.mSupportHoldUrl = false;
        this.mIspv = false;
        this.mSuffix = null;
        this.mQualityLower = false;
        this.mNoPrefix = false;
        this.mContext = context;
        this.mSupportHoldUrl = false;
        this.mSuffix = null;
        this.mIspv = false;
        this.mQualityLower = false;
        this.mNoPrefix = false;
    }

    public void setSupportHoldUrl(boolean support) {
        this.mSupportHoldUrl = support;
        if (!this.mSupportHoldUrl) {
            this.mHoldData.clear();
        }
    }

    public void setExtraInfos(ArrayList<BasicNameValuePair> infos) {
        this.infos = infos;
    }

    public void setIsPv(boolean isPv) {
        this.mIspv = isPv;
    }

    public void setSuffix(String suffix) {
        this.mSuffix = suffix;
    }

    public void setQuality(boolean lower) {
        this.mQualityLower = lower;
    }

    public void clearHoldUrl() {
        this.mHoldData.clear();
    }

    public Bitmap getPhoto(String imageUrl) {
        SDRamImage sdramImage = TiebaApplication.app.getSdramImage();
        if (sdramImage == null) {
            return null;
        }
        Bitmap bitmap = sdramImage.getPhoto(imageUrl);
        return bitmap;
    }

    public Bitmap getPic(String imageUrl) {
        SDRamImage sdramImage = TiebaApplication.app.getSdramImage();
        if (sdramImage == null) {
            return null;
        }
        Bitmap bitmap = sdramImage.getPic(imageUrl);
        return bitmap;
    }

    public void removePhoto(String key) {
        SDRamImage sdramImage = TiebaApplication.app.getSdramImage();
        if (sdramImage != null) {
            sdramImage.deletePhoto(key);
        }
    }

    public Bitmap loadImage(String imageUrl, ImageCallback mImageCallback) {
        return loadBitmap(imageUrl, mImageCallback, 0, true);
    }

    public Bitmap loadFriendPhoto(String imageUrl, ImageCallback mImageCallback) {
        return loadBitmap(imageUrl, mImageCallback, 1, true);
    }

    public Bitmap loadFriendPhotoByNet(String imageUrl, ImageCallback mImageCallback) {
        return loadBitmap(imageUrl, mImageCallback, 1, false);
    }

    public Bitmap loadPbPhoto(String imageUrl, ImageCallback mImageCallback) {
        return loadBitmap(imageUrl, mImageCallback, 2, true);
    }

    public Bitmap loadHotspotImage(String imageUrl, ImageCallback mImageCallback) {
        return loadBitmap(imageUrl, mImageCallback, 3, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap loadBitmap(String imageUrl, ImageCallback mImageCallback, Integer type, boolean from_db) {
        if (imageUrl == null) {
            return null;
        }
        String cacheImageUrl = imageUrl;
        if (this.mSuffix != null) {
            cacheImageUrl = String.valueOf(cacheImageUrl) + this.mSuffix;
        }
        SDRamImage sdramImage = TiebaApplication.app.getSdramImage();
        if (sdramImage != null) {
            Bitmap bitmap = null;
            if (type.intValue() == 0) {
                bitmap = sdramImage.getPic(cacheImageUrl);
            } else if (type.intValue() != 3) {
                bitmap = sdramImage.getPhoto(cacheImageUrl);
            }
            if (bitmap != null) {
                return bitmap;
            }
        }
        try {
            int size = this.mTasks.size();
            for (int i = 0; i < size; i++) {
                if (this.mTasks.get(i).getUrl().equals(imageUrl)) {
                    return null;
                }
            }
            if (this.mSupportHoldUrl && this.mHoldData != null) {
                int size2 = this.mHoldData.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    if (this.mHoldData.get(i2).url != null && this.mHoldData.get(i2).url.equals(imageUrl)) {
                        return null;
                    }
                }
            }
            if (this.mTasks.size() >= 25) {
                if (!this.mSupportHoldUrl) {
                    ImageAsyncTask tmp = this.mTasks.get(0);
                    tmp.cancel();
                    this.mTasks.remove(0);
                    ImageAsyncTask task = new ImageAsyncTask(imageUrl, type.intValue(), mImageCallback, from_db);
                    this.mTasks.add(task);
                    task.execute(new String[0]);
                } else {
                    HoldData data = new HoldData(this, null);
                    data.callback = mImageCallback;
                    data.url = imageUrl;
                    data.type = type.intValue();
                    data.from_db = from_db;
                    this.mHoldData.add(data);
                }
            } else {
                ImageAsyncTask task2 = new ImageAsyncTask(imageUrl, type.intValue(), mImageCallback, from_db);
                this.mTasks.add(task2);
                task2.execute(new String[0]);
            }
        } catch (Exception ex) {
            TiebaLog.e("AsyncImageLoader", "loadBitmap", "error = " + ex.getMessage());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ImageAsyncTask extends AsyncTask<String, Integer, Bitmap> {
        private String cacheImageUrl;
        private boolean from_db;
        private volatile Bitmap mBitmap;
        private ImageCallback mImageCallback;
        private volatile int mType;
        private String mUrl;
        private volatile NetWork mNetWork = null;
        private boolean iscached = true;
        private volatile boolean mIsGif = false;

        public ImageAsyncTask(String url, int type, ImageCallback callback, boolean from_db) {
            this.mImageCallback = null;
            this.mUrl = null;
            this.mType = 0;
            this.mBitmap = null;
            this.from_db = false;
            this.cacheImageUrl = null;
            this.mUrl = url;
            this.mType = type;
            this.mImageCallback = callback;
            this.mBitmap = null;
            this.from_db = from_db;
            if (AsyncImageLoader.this.mSuffix != null) {
                this.cacheImageUrl = String.valueOf(url) + AsyncImageLoader.this.mSuffix;
            } else {
                this.cacheImageUrl = url;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String... params) {
            String fullUrl;
            SDRamImage sdramImage;
            SDRamImage sdramImage2;
            boolean need_cash = false;
            try {
                byte[] tmp = null;
                String name = StringHelper.getNameMd5FromUrl(this.mUrl);
                if (AsyncImageLoader.this.mSuffix != null) {
                    name = String.valueOf(name) + AsyncImageLoader.this.mSuffix;
                }
                if (this.from_db) {
                    if (this.mType == 1) {
                        this.mBitmap = DatabaseService.getFriendPhoto(this.cacheImageUrl);
                    } else if (this.mType == 2) {
                        this.mBitmap = DatabaseService.getPbPhoto(this.cacheImageUrl);
                    } else if (this.mType == 3) {
                        if (name != null) {
                            this.mBitmap = FileHelper.getImage(Config.TMP_HOTSPOT_DIR_NAME, name);
                        }
                    } else if (this.mType == 0 && name != null) {
                        if (FileHelper.CheckFile(Config.TMP_PIC_DIR_NAME, name) && (sdramImage2 = TiebaApplication.app.getSdramImage()) != null) {
                            sdramImage2.deletePic(Config.getPbImageSize());
                        }
                        this.mBitmap = FileHelper.getImage(Config.TMP_PIC_DIR_NAME, name);
                        if (this.mBitmap != null) {
                            this.mIsGif = FileHelper.isGif(Config.TMP_PIC_DIR_NAME, name);
                        }
                    }
                }
                if (this.mBitmap == null) {
                    this.iscached = false;
                    need_cash = true;
                    int pb_image_width = 0;
                    int pb_image_height = 0;
                    if (this.mType == 0) {
                        StringBuffer buffer = new StringBuffer(100);
                        buffer.append(Config.IMAGE_ADDRESS);
                        buffer.append("src=");
                        String encode = StringHelper.getUrlEncode(this.mUrl);
                        buffer.append(encode);
                        buffer.append("&width=");
                        if (AsyncImageLoader.this.mImageWidth == 0) {
                            pb_image_width = UtilHelper.dip2px(AsyncImageLoader.this.mContext, 105.0f);
                        } else {
                            pb_image_width = AsyncImageLoader.this.mImageWidth;
                        }
                        buffer.append(String.valueOf(pb_image_width));
                        buffer.append("&height=");
                        if (AsyncImageLoader.this.mImageHeight == 0) {
                            pb_image_height = UtilHelper.dip2px(AsyncImageLoader.this.mContext, 105.0f);
                        } else {
                            pb_image_height = AsyncImageLoader.this.mImageHeight;
                        }
                        buffer.append(String.valueOf(pb_image_height));
                        buffer.append("&imgtype=0");
                        if (AsyncImageLoader.this.mQualityLower) {
                            buffer.append("&qulity=" + String.valueOf(45));
                        } else if (TiebaApplication.app.getViewImageQuality() == 1) {
                            buffer.append("&qulity=" + String.valueOf(80));
                        } else {
                            buffer.append("&qulity=" + String.valueOf(45));
                        }
                        buffer.append("&first_gif=1");
                        if (AsyncImageLoader.this.mIspv) {
                            buffer.append("&ispv=1");
                        }
                        if (AsyncImageLoader.this.mNoPrefix) {
                            buffer.append("&no_prefix=1");
                        }
                        fullUrl = buffer.toString();
                    } else if (this.mType == 3) {
                        fullUrl = this.mUrl;
                    } else {
                        fullUrl = String.valueOf(Config.PHOTO_SMALL_ADDRESS) + this.mUrl;
                    }
                    this.mNetWork = new NetWork(AsyncImageLoader.this.mContext, fullUrl);
                    if (AsyncImageLoader.this.infos != null) {
                        for (int i = 0; i < AsyncImageLoader.this.infos.size(); i++) {
                            this.mNetWork.addPostData((BasicNameValuePair) AsyncImageLoader.this.infos.get(i));
                        }
                    }
                    if (this.mType == 0) {
                        this.mNetWork.setIsBDImage(true);
                    }
                    tmp = this.mNetWork.getNetData();
                    if (this.mNetWork.isRequestSuccess()) {
                        if (this.mType == 0 && (sdramImage = TiebaApplication.app.getSdramImage()) != null) {
                            sdramImage.deletePic(Config.getPbImageSize());
                        }
                        this.mBitmap = BitmapHelper.Bytes2Bitmap(tmp);
                        this.mIsGif = UtilHelper.isGif(tmp);
                        if (this.mBitmap != null) {
                            if (this.mType == 0) {
                                if (this.mBitmap.getWidth() > pb_image_width || this.mBitmap.getHeight() > pb_image_height) {
                                    TiebaLog.log_e(1, getClass().getName(), "doInBackground", "Pb_image_too_big:" + String.valueOf(String.valueOf(this.mBitmap.getWidth()) + "*" + String.valueOf(this.mBitmap.getHeight())));
                                    this.mBitmap = BitmapHelper.resizeBitmap(this.mBitmap, pb_image_width, pb_image_height);
                                }
                            } else if (this.mType != 3 && (this.mBitmap.getWidth() > 80 || this.mBitmap.getHeight() > 80)) {
                                TiebaLog.log_e(1, getClass().getName(), "doInBackground", "Pb_photo_too_big:" + String.valueOf(String.valueOf(this.mBitmap.getWidth()) + "*" + String.valueOf(this.mBitmap.getHeight())));
                                this.mBitmap = BitmapHelper.resizeBitmap(this.mBitmap, 80);
                            }
                        }
                    }
                }
                publishProgress(new Integer[0]);
                if (need_cash && this.mBitmap != null) {
                    if (this.mType == 1) {
                        DatabaseService.cashFriendPhoto(this.cacheImageUrl, this.mBitmap);
                    } else if (this.mType == 2) {
                        DatabaseService.cashPbPhoto(this.cacheImageUrl, this.mBitmap);
                    } else if (this.mType == 3) {
                        if (this.mBitmap != null && this.mUrl != null && name != null) {
                            FileHelper.SaveFile(Config.TMP_HOTSPOT_DIR_NAME, name, this.mBitmap, 100);
                        }
                    } else if (name != null && this.mBitmap != null && tmp != null) {
                        FileHelper.SaveFile(Config.TMP_PIC_DIR_NAME, name, tmp);
                    }
                }
            } catch (Exception ex) {
                TiebaLog.e("ImageAsyncTask", "doInBackground", "error = " + ex.getMessage());
            }
            return this.mBitmap;
        }

        public String getUrl() {
            return this.mUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Integer... values) {
            SDRamImage sdramImage = TiebaApplication.app.getSdramImage();
            if (sdramImage != null && this.mBitmap != null) {
                if (this.mType == 0) {
                    sdramImage.addPic(this.cacheImageUrl, this.mBitmap, this.mIsGif);
                } else if (this.mType == 1 || this.mType == 2) {
                    sdramImage.addPhoto(this.cacheImageUrl, this.mBitmap);
                }
            }
            if (this.mImageCallback != null) {
                this.mImageCallback.imageLoaded(this.mBitmap, this.mUrl, this.iscached);
            }
            super.onProgressUpdate((Object[]) values);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            AsyncImageLoader.this.mTasks.remove(this);
            if (AsyncImageLoader.this.mSupportHoldUrl && AsyncImageLoader.this.mHoldData.size() > 0) {
                HoldData data = (HoldData) AsyncImageLoader.this.mHoldData.remove(0);
                AsyncImageLoader.this.loadBitmap(data.url, data.callback, Integer.valueOf(data.type), data.from_db);
            }
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            if (AsyncImageLoader.this.mSupportHoldUrl && AsyncImageLoader.this.mHoldData.size() > 0) {
                HoldData data = (HoldData) AsyncImageLoader.this.mHoldData.remove(0);
                AsyncImageLoader.this.loadBitmap(data.url, data.callback, Integer.valueOf(data.type), data.from_db);
            }
            super.onCancelled();
        }

        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
            }
            super.cancel(true);
        }
    }

    public void cancelAllAsyncTask() {
        this.mHoldData.clear();
        for (int i = 0; i < this.mTasks.size(); i++) {
            ImageAsyncTask task = this.mTasks.get(i);
            if (task != null) {
                task.cancel();
            }
        }
        this.mTasks.clear();
    }

    public int getAsyncTaskNum() {
        return this.mTasks.size();
    }

    public void setImagesize(int imageWidth, int imageHeight) {
        this.mImageWidth = imageWidth;
        this.mImageHeight = imageHeight;
    }

    public void setNoPrefix(boolean noPrefix) {
        this.mNoPrefix = noPrefix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class HoldData {
        ImageCallback callback;
        boolean from_db;
        int type;
        String url;

        private HoldData() {
        }

        /* synthetic */ HoldData(AsyncImageLoader asyncImageLoader, HoldData holdData) {
            this();
        }
    }
}
