package com.baidu.tieba.pb;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.w;
import java.io.File;
/* loaded from: classes.dex */
public class FileDownloader extends Service {
    public static final int FILE_EXIST = 1;
    private static final String TAG_FILE = "file";
    private static final String TAG_INFO = "info";
    private static final String TAG_URL = "url";
    private String mInfo = null;
    private a mDowndingTask = null;
    private int progress = 0;
    private String schedule = null;
    private final Handler handler = new c(this);

    public static void download(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, FileDownloader.class);
        intent.putExtra(TAG_FILE, str2);
        intent.putExtra("url", str);
        intent.putExtra("info", str3);
        context.startService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeMessages(TbConfig.NET_MSG_GETLENTH);
        if (this.mDowndingTask != null) {
            this.mDowndingTask.cancel();
        }
        NotificationHelper.cancelNotification(getBaseContext(), 10);
        NotificationHelper.cancelNotification(getBaseContext(), 14);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        String fileOfUrl;
        if (intent != null) {
            this.mInfo = intent.getStringExtra("info");
            String stringExtra = intent.getStringExtra("url");
            if (intent.getStringExtra(TAG_FILE) != null) {
                fileOfUrl = intent.getStringExtra(TAG_FILE);
            } else {
                fileOfUrl = getFileOfUrl(stringExtra);
            }
            if (n.dm(fileOfUrl) != null) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, fileOfUrl), 100L);
            } else if (this.mDowndingTask == null) {
                this.mDowndingTask = new a(stringExtra, fileOfUrl);
                this.mDowndingTask.execute(new String[0]);
                NotificationHelper.showProgressNotification(getBaseContext(), 10, null, 0, "0/0", this.mInfo, true);
            } else {
                k.showToast(getApplicationContext(), w.l.downloading_tip);
            }
        }
        super.onStart(intent, i);
    }

    private String getFileOfUrl(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        String[] split = str.split("/");
        return split[split.length - 1];
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<String, Integer, Boolean> {
        private final String mFile;
        private final String mUrl;
        private ab mNetWork = null;
        private volatile boolean mCanceled = false;

        public a(String str, String str2) {
            this.mUrl = str;
            this.mFile = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            File dp;
            Boolean bool = false;
            while (!this.mCanceled) {
                try {
                    this.mNetWork = new ab(this.mUrl);
                    bool = Boolean.valueOf(this.mNetWork.a(String.valueOf(this.mFile) + ".tmp", FileDownloader.this.handler, TbConfig.NET_MSG_GETLENTH));
                    if (bool.booleanValue() || this.mNetWork.uZ() == -2) {
                        break;
                    } else if (!this.mNetWork.uV().vS().fs()) {
                        try {
                            Thread.sleep(10000L);
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                }
            }
            if (bool.booleanValue()) {
                n.du(this.mFile);
                File dm = n.dm(String.valueOf(this.mFile) + ".tmp");
                if (dm != null && (dp = n.dp(this.mFile)) != null) {
                    dm.renameTo(dp);
                }
            }
            return bool;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            FileDownloader.this.mDowndingTask = null;
            this.mCanceled = true;
            if (this.mNetWork != null) {
                this.mNetWork.fr();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            FileDownloader.this.mDowndingTask = null;
            if (bool.booleanValue()) {
                NotificationHelper.cancelNotification(FileDownloader.this.getBaseContext(), 10);
                FileDownloader.this.handler.sendMessageDelayed(FileDownloader.this.handler.obtainMessage(1, this.mFile), 100L);
                return;
            }
            NotificationHelper.showProgressNotification(FileDownloader.this.getBaseContext(), 10, null, FileDownloader.this.progress, this.mUrl, FileDownloader.this.getString(w.l.error_sd_error), false);
            FileDownloader.this.stopSelf();
        }
    }
}
