package com.baidu.tieba.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class AsyncImageLoader {
    private Context mContext;
    private LinkedList<ImageAsyncTask> mTasks = new LinkedList<>();

    /* loaded from: classes.dex */
    public interface ImageCallback {
        void imageLoaded(Bitmap bitmap, String str, boolean z);
    }

    public AsyncImageLoader(Context context) {
        this.mContext = context;
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

    private Bitmap loadBitmap(String imageUrl, ImageCallback mImageCallback, Integer type, boolean from_db) {
        Bitmap bitmap;
        SDRamImage sdramImage = TiebaApplication.app.getSdramImage();
        if (sdramImage != null) {
            if (type.intValue() == 0) {
                bitmap = sdramImage.getPic(imageUrl);
            } else {
                bitmap = sdramImage.getPhoto(imageUrl);
            }
            if (bitmap != null) {
                return bitmap;
            }
        }
        for (int i = 0; i < this.mTasks.size(); i++) {
            try {
                if (this.mTasks.get(i).getUrl().equals(imageUrl)) {
                    return null;
                }
            } catch (Exception ex) {
                TiebaLog.e("AsyncImageLoader", "loadBitmap", "error = " + ex.getMessage());
            }
        }
        ImageAsyncTask task = new ImageAsyncTask(imageUrl, type.intValue(), mImageCallback, from_db);
        this.mTasks.add(task);
        task.execute(new String[0]);
        if (this.mTasks.size() > 25) {
            ImageAsyncTask tmp = this.mTasks.get(0);
            tmp.cancel();
            this.mTasks.remove(0);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ImageAsyncTask extends AsyncTask<String, Integer, Bitmap> {
        private boolean from_db;
        private Bitmap mBitmap;
        private ImageCallback mImageCallback;
        private int mType;
        private String mUrl;
        private NetWork mNetWork = null;
        private boolean iscached = true;

        public ImageAsyncTask(String url, int type, ImageCallback callback, boolean from_db) {
            this.mImageCallback = null;
            this.mUrl = null;
            this.mType = 0;
            this.mBitmap = null;
            this.from_db = false;
            this.mUrl = url;
            this.mType = type;
            this.mImageCallback = callback;
            this.mBitmap = null;
            this.from_db = from_db;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String... params) {
            String fullUrl;
            boolean need_cash = false;
            try {
                if (this.from_db) {
                    if (this.mType == 1) {
                        this.mBitmap = DatabaseService.getFriendPhoto(this.mUrl);
                    } else if (this.mType == 2) {
                        this.mBitmap = DatabaseService.getPbPhoto(this.mUrl);
                    } else {
                        String name = StringHelper.getNameFromUrl(this.mUrl);
                        if (name != null) {
                            this.mBitmap = FileHelper.getImage(Config.TMP_PIC_DIR_NAME, name);
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
                        pb_image_width = UtilHelper.dip2px(AsyncImageLoader.this.mContext, 150.0f);
                        buffer.append(String.valueOf(pb_image_width));
                        buffer.append("&height=");
                        pb_image_height = UtilHelper.dip2px(AsyncImageLoader.this.mContext, 120.0f);
                        buffer.append(String.valueOf(pb_image_height));
                        fullUrl = buffer.toString();
                    } else {
                        fullUrl = Config.PHOTO_SMALL_ADDRESS + this.mUrl;
                    }
                    this.mNetWork = new NetWork(AsyncImageLoader.this.mContext, fullUrl);
                    if (this.mType == 0) {
                        this.mNetWork.setIsBDImage(true);
                    }
                    byte[] tmp = this.mNetWork.getNetData();
                    if (this.mNetWork.isRequestSuccess()) {
                        this.mBitmap = BitmapHelper.Bytes2Bitmap(tmp);
                        if (this.mBitmap != null) {
                            if (this.mType == 0) {
                                if (this.mBitmap.getWidth() > pb_image_width || this.mBitmap.getHeight() > pb_image_height) {
                                    TiebaLog.log_e(1, getClass().getName(), "doInBackground", "Pb_image_too_big:" + String.valueOf(this.mBitmap.getWidth() + "*" + String.valueOf(this.mBitmap.getHeight())));
                                    this.mBitmap = BitmapHelper.resizeBitmap(this.mBitmap, pb_image_width, pb_image_height);
                                }
                            } else if (this.mBitmap.getWidth() > 80 || this.mBitmap.getHeight() > 80) {
                                TiebaLog.log_e(1, getClass().getName(), "doInBackground", "Pb_photo_too_big:" + String.valueOf(this.mBitmap.getWidth() + "*" + String.valueOf(this.mBitmap.getHeight())));
                                this.mBitmap = BitmapHelper.resizeBitmap(this.mBitmap, 80);
                            }
                        }
                    }
                }
                SDRamImage sdramImage = TiebaApplication.app.getSdramImage();
                if (sdramImage != null && this.mBitmap != null) {
                    if (this.mType == 0) {
                        sdramImage.addPic(this.mUrl, this.mBitmap);
                    } else {
                        sdramImage.addPhoto(this.mUrl, this.mBitmap);
                    }
                }
                publishProgress(new Integer[0]);
                if (need_cash && this.mBitmap != null) {
                    if (this.mType == 1) {
                        DatabaseService.cashFriendPhoto(this.mUrl, this.mBitmap);
                    } else if (this.mType == 2) {
                        DatabaseService.cashPbPhoto(this.mUrl, this.mBitmap);
                    } else {
                        String name2 = StringHelper.getNameFromUrl(this.mUrl);
                        if (name2 != null) {
                            FileHelper.SaveFile(Config.TMP_PIC_DIR_NAME, name2, this.mBitmap, 80);
                        }
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
            if (this.mImageCallback != null && this.mBitmap != null) {
                this.mImageCallback.imageLoaded(this.mBitmap, this.mUrl, this.iscached);
            }
            super.onProgressUpdate((Object[]) values);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            AsyncImageLoader.this.mTasks.remove(this);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
        }

        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
            }
        }
    }

    public void cancelAllAsyncTask() {
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
}
