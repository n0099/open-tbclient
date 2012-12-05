package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.FileHelper;
import com.baidu.tieba.write.WriteUtil;
/* loaded from: classes.dex */
public class TiebaPrepareImageService extends Service {
    public static volatile boolean IS_DECODING = false;
    private static final String MAX_SIZE = "max_size";
    private static final String REQUESTCODE = "request_code";
    private int mMaxSize;
    private int mRequestCode = 0;
    private Uri mUri = null;
    private PrepareImageTask mTask = null;
    private Handler mHandler = new Handler();
    private Runnable mStartRun = new Runnable() { // from class: com.baidu.tieba.service.TiebaPrepareImageService.1
        @Override // java.lang.Runnable
        public void run() {
            if (TiebaPrepareImageService.IS_DECODING) {
                TiebaPrepareImageService.this.mHandler.postDelayed(TiebaPrepareImageService.this.mStartRun, 1000L);
                return;
            }
            TiebaPrepareImageService.this.mTask = new PrepareImageTask(TiebaPrepareImageService.this.mRequestCode, TiebaPrepareImageService.this.mUri);
            TiebaPrepareImageService.this.mTask.execute(new Object[0]);
        }
    };

    public static void StartService(int requestCode, Uri uri, int max_size) {
        Intent intent = new Intent(TiebaApplication.app, TiebaPrepareImageService.class);
        intent.putExtra("request_code", requestCode);
        intent.putExtra(MAX_SIZE, max_size);
        intent.setData(uri);
        TiebaApplication.app.startService(intent);
    }

    public static void StopService() {
        Intent intent = new Intent(TiebaApplication.app, TiebaPrepareImageService.class);
        TiebaApplication.app.stopService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.mTask != null) {
            this.mTask.cancel();
        }
        this.mHandler.removeCallbacks(this.mStartRun);
        this.mTask = null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (intent != null) {
            startPrepareImage(intent);
        }
    }

    private void startPrepareImage(Intent intent) {
        if (this.mTask != null) {
            this.mTask.cancel();
        }
        this.mUri = intent.getData();
        this.mRequestCode = intent.getIntExtra("request_code", 0);
        this.mMaxSize = intent.getIntExtra(MAX_SIZE, 600);
        TiebaApplication.app.addRemoteActivity(null);
        if (!IS_DECODING) {
            this.mTask = new PrepareImageTask(this.mRequestCode, this.mUri);
            this.mTask.execute(new Object[0]);
            return;
        }
        this.mHandler.postDelayed(this.mStartRun, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PrepareImageTask extends AsyncTask<Object, Integer, Boolean> {
        String mError = null;
        int mRequestCode;
        Uri mUri;

        public PrepareImageTask(int requestCode, Uri uri) {
            this.mRequestCode = 0;
            this.mUri = null;
            this.mRequestCode = requestCode;
            this.mUri = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(Object... params) {
            boolean ret = false;
            TiebaPrepareImageService.IS_DECODING = true;
            try {
                Bitmap bm = WriteUtil.ImageResult(this.mRequestCode, TiebaPrepareImageService.this, this.mUri, TiebaPrepareImageService.this.mMaxSize);
                if (bm != null) {
                    if (FileHelper.SaveFile(null, Config.IMAGE_RESIZED_FILE, bm, 80) != null) {
                        Bitmap display = BitmapHelper.resizeBitmap(bm, 100);
                        if (display != null && FileHelper.SaveFile(null, Config.IMAGE_RESIZED_FILE_DISPLAY, display, 80) != null) {
                            ret = true;
                        } else {
                            this.mError = TiebaPrepareImageService.this.getString(R.string.error_sd_error);
                        }
                    } else {
                        this.mError = TiebaPrepareImageService.this.getString(R.string.error_sd_error);
                    }
                } else {
                    this.mError = TiebaPrepareImageService.this.getString(R.string.pic_parser_error);
                }
            } catch (Exception e) {
            } finally {
                TiebaPrepareImageService.IS_DECODING = false;
            }
            return Boolean.valueOf(ret);
        }

        public void cancel() {
            TiebaPrepareImageService.this.mTask = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            super.onPostExecute((PrepareImageTask) result);
            Intent intent = new Intent(Config.BROADCAST_IMAGE_RESIZED);
            intent.putExtra("result", result);
            if (this.mError != null) {
                intent.putExtra("error", this.mError);
            }
            TiebaPrepareImageService.this.sendBroadcast(intent);
        }
    }
}
