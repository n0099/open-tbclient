package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.FileHelper;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.DragImageView;
/* loaded from: classes.dex */
public class UrlDragImageView extends RelativeLayout {
    private GetDataCallback mCallback;
    protected Context mContext;
    protected DragImageView mImageView;
    protected ProgressBar mProgressBar;
    private ImageAsyncTask mTask;

    /* loaded from: classes.dex */
    public interface GetDataCallback {
        void callback(String str, byte[] bArr);
    }

    public void setCallback(GetDataCallback callback) {
        this.mCallback = callback;
    }

    public UrlDragImageView(Context ctx) {
        super(ctx);
        this.mProgressBar = null;
        this.mImageView = null;
        this.mTask = null;
        this.mContext = null;
        this.mCallback = null;
        this.mContext = ctx;
        init();
    }

    public UrlDragImageView(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        this.mProgressBar = null;
        this.mImageView = null;
        this.mTask = null;
        this.mContext = null;
        this.mCallback = null;
        this.mContext = ctx;
        init();
    }

    public DragImageView getImageView() {
        return this.mImageView;
    }

    public void setGifSetListener(DragImageView.OnGifSetListener listener) {
        this.mImageView.setGifSetListener(listener);
    }

    public void setImageOnClickListener(View.OnClickListener click) {
        this.mImageView.setImageOnClickListener(click);
    }

    public void setOnSizeChangedListener(DragImageView.OnSizeChangedListener listener) {
        this.mImageView.setOnSizeChangedListener(listener);
    }

    public void zoomInBitmap() {
        this.mImageView.zoomInBitmap();
    }

    public void zoomOutBitmap() {
        this.mImageView.zoomOutBitmap();
    }

    protected void init() {
        this.mImageView = new DragImageView(this.mContext);
        this.mImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.mImageView);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-2, -2);
        params.addRule(13);
        this.mProgressBar.setLayoutParams(params);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
    }

    public void setUrl(String imageUrl) {
        this.mImageView.setTag(imageUrl);
        NetWorkCore.NetworkStateInfo info = NetWorkCore.getStatusInfo(getContext());
        if (info == NetWorkCore.NetworkStateInfo.WIFI || info == NetWorkCore.NetworkStateInfo.ThreeG) {
            if (this.mTask != null) {
                this.mTask.cancel();
            }
            if (imageUrl != null) {
                this.mTask = new ImageAsyncTask(imageUrl);
                this.mTask.execute(new String[0]);
            }
        }
    }

    public void setGifMaxUseableMem(int mem) {
        this.mImageView.setGifMaxUseableMem(mem);
    }

    public void destroyTask() {
        if (this.mTask != null) {
            this.mTask.cancel();
            this.mTask = null;
        }
    }

    public void onDestroy() {
        destroyTask();
        if (this.mImageView != null) {
            this.mImageView.onDestroy();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        destroyTask();
        if (this.mImageView != null) {
            this.mImageView.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void stopGif() {
        if (this.mImageView != null && this.mImageView.getImageType() == 1) {
            this.mImageView.stop();
        }
    }

    public void checkImage() {
        String url;
        if (this.mImageView != null && (url = (String) this.mImageView.getTag()) != null && this.mImageView != null && this.mTask == null) {
            if (this.mImageView.getImageType() == 1) {
                if (this.mImageView.getGifCache() == null) {
                    this.mTask = new ImageAsyncTask(url);
                    this.mTask.execute(new String[0]);
                }
            } else if (this.mImageView.getImageType() == 2) {
                if (NetWorkCore.getNetworkState(getContext()) != NetWorkCore.NetworkState.UNAVAIL) {
                    this.mTask = new ImageAsyncTask(url);
                    this.mTask.execute(new String[0]);
                }
            } else if (this.mImageView.getImageBitmap() == null) {
                this.mTask = new ImageAsyncTask(url);
                this.mTask.execute(new String[0]);
            }
        }
    }

    public int getImageType() {
        if (this.mImageView != null) {
            return this.mImageView.getImageType();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ImageAsyncTask extends AsyncTask<String, Integer, ImageData> {
        private String mFileName;
        private NetWork mNetwork = null;
        private String mUrl;

        ImageAsyncTask(String url) {
            this.mUrl = null;
            this.mFileName = null;
            this.mUrl = url;
            this.mFileName = StringHelper.getNameMd5FromUrl(url);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public ImageData doInBackground(String... params) {
            String url;
            ImageData im = null;
            if (this.mUrl == null || this.mFileName == null) {
                return null;
            }
            String url2 = String.valueOf(this.mUrl) + "&imgtype=0";
            if (TiebaApplication.app.getViewImageQuality() == 1) {
                url = String.valueOf(url2) + "&qulity=" + String.valueOf(80);
            } else {
                url = String.valueOf(url2) + "&qulity=" + String.valueOf(45);
            }
            String url3 = String.valueOf(url) + "&ispv=1";
            Bitmap bm = null;
            try {
                byte[] data = UrlDragImageView.this.mImageView.getImageData();
                if (data != null) {
                    bm = BitmapHelper.Bytes2Bitmap(data);
                }
                if (bm == null && (data = FileHelper.GetFileData(Config.TMP_PIC_DIR_NAME, this.mFileName)) != null) {
                    bm = BitmapHelper.Bytes2Bitmap(data);
                }
                if (bm == null) {
                    String fullUrl = Config.IMAGE_ADDRESS + url3;
                    this.mNetwork = new NetWork(fullUrl);
                    this.mNetwork.setIsBDImage(true);
                    data = this.mNetwork.getNetData();
                    if (this.mNetwork.isRequestSuccess()) {
                        bm = BitmapHelper.Bytes2Bitmap(data);
                    }
                    FileHelper.SaveFile(Config.TMP_PIC_DIR_NAME, this.mFileName, data);
                }
                ImageData im2 = new ImageData(UrlDragImageView.this, null);
                try {
                    im2.url = this.mUrl;
                    im2.data = data;
                    im2.bitmap = bm;
                    im = im2;
                } catch (Exception e) {
                    ex = e;
                    im = im2;
                    TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
                    return im;
                }
            } catch (Exception e2) {
                ex = e2;
            }
            return im;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(ImageData data) {
            UrlDragImageView.this.mProgressBar.setVisibility(8);
            UrlDragImageView.this.mTask = null;
            if (data != null) {
                if (UrlDragImageView.this.mCallback != null) {
                    UrlDragImageView.this.mCallback.callback(data.url, data.data);
                }
                Bitmap bm = data.bitmap;
                if (bm == null) {
                    UrlDragImageView.this.mImageView.setDefaultBitmap();
                    return;
                }
                boolean isGif = UtilHelper.isGif(data.data);
                if (isGif) {
                    UrlDragImageView.this.mImageView.setGifData(data.data, bm);
                    return;
                }
                UrlDragImageView.this.mImageView.setImageBitmap(bm);
                UrlDragImageView.this.mImageView.setImageData(data.data);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            UrlDragImageView.this.mImageView.setImageBitmap(null);
            UrlDragImageView.this.mProgressBar.setVisibility(0);
            super.onPreExecute();
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            UrlDragImageView.this.mImageView.setVisibility(0);
            UrlDragImageView.this.mProgressBar.setVisibility(8);
            UrlDragImageView.this.mTask = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ImageData {
        public Bitmap bitmap;
        public byte[] data;
        public String url;

        private ImageData() {
        }

        /* synthetic */ ImageData(UrlDragImageView urlDragImageView, ImageData imageData) {
            this();
        }
    }
}
