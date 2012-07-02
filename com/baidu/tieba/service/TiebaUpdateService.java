package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.RemoteViews;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.util.FileHelper;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import java.io.File;
/* loaded from: classes.dex */
public class TiebaUpdateService extends Service {
    public static final String TAG_UPDATE = "update";
    public static final String TAG_VERSION = "version";
    private NotificationManager mNotificationManager = null;
    private Notification mNotify = null;
    private DownLoadingAsyncTask mDowndingTask = null;
    private Handler handler = new Handler() { // from class: com.baidu.tieba.service.TiebaUpdateService.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 900002) {
                if (TiebaUpdateService.this.mNotify != null && msg.arg2 > 0) {
                    int progress = (int) ((msg.arg1 * 100) / msg.arg2);
                    TiebaUpdateService.this.mNotify.contentView.setProgressBar(R.id.progress, 100, progress, false);
                    StringBuffer buffer = new StringBuffer(20);
                    buffer.append(String.valueOf(msg.arg1 / 1000));
                    buffer.append("K/");
                    buffer.append(String.valueOf(msg.arg2 / 1000));
                    buffer.append("K");
                    TiebaUpdateService.this.mNotify.contentView.setTextViewText(R.id.schedule, buffer);
                    TiebaUpdateService.this.mNotificationManager.notify(10, TiebaUpdateService.this.mNotify);
                }
            } else if (msg.what == 1) {
                VersionData data = (VersionData) msg.obj;
                if (data != null) {
                    UtilHelper.install_apk(TiebaApplication.app, data.getNew_file());
                }
                TiebaUpdateService.this.stopSelf();
            }
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mNotificationManager = (NotificationManager) getSystemService("notification");
        this.mNotify = getUpdateNotification();
        if (this.mNotificationManager == null) {
            stopSelf();
        }
    }

    public Notification getUpdateNotification() {
        PendingIntent intent = PendingIntent.getActivity(TiebaApplication.app, 0, new Intent(), 0);
        Notification notification = new Notification(17301633, null, System.currentTimeMillis());
        notification.contentView = new RemoteViews(TiebaApplication.app.getPackageName(), (int) R.layout.notify_item);
        notification.contentView.setProgressBar(R.id.progress, 100, 0, false);
        notification.contentIntent = intent;
        notification.flags = 32;
        return notification;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeMessages(Config.NET_MSG_GETLENTH);
        if (this.mDowndingTask != null) {
            this.mDowndingTask.cancel();
        }
        if (this.mNotificationManager != null) {
            this.mNotificationManager.cancel(10);
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int startId) {
        TiebaLog.i(getClass().getName(), "onStart", "onStart");
        if (intent.getBooleanExtra(TAG_UPDATE, false)) {
            VersionData data = (VersionData) intent.getSerializableExtra(TAG_VERSION);
            String info = String.format(getString(R.string.downloading), data.getNew_version());
            this.mNotify.contentView.setTextViewText(R.id.info, info);
            this.mNotify.contentView.setTextViewText(R.id.schedule, "0/0");
            File file = FileHelper.GetFile(data.getNew_file());
            if (file != null) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, data), 100L);
            } else if (data != null && this.mDowndingTask == null) {
                this.mDowndingTask = new DownLoadingAsyncTask(data);
                this.mDowndingTask.execute(new String[0]);
                this.mNotify.contentView.setProgressBar(R.id.progress, 100, 0, false);
                this.mNotificationManager.notify(10, this.mNotify);
            }
        }
        super.onStart(intent, startId);
    }

    /* loaded from: classes.dex */
    private class DownLoadingAsyncTask extends AsyncTask<String, Integer, Boolean> {
        private VersionData mData;
        private NetWork mNetWork = null;
        private volatile boolean mCanceled = false;

        public DownLoadingAsyncTask(VersionData data) {
            this.mData = null;
            this.mData = data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... arg0) {
            File to;
            Boolean ret = false;
            while (!this.mCanceled) {
                try {
                    this.mNetWork = new NetWork(this.mData.getUrl());
                    ret = this.mNetWork.downloadFile(String.valueOf(this.mData.getNew_file()) + ".tmp", TiebaUpdateService.this.handler);
                    if (ret.booleanValue() || this.mNetWork.getErrorCode() == -2) {
                        break;
                    } else if (!this.mNetWork.isFileSegSuccess()) {
                        try {
                            Thread.sleep(10000L);
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception ex) {
                    TiebaLog.e("DownLoadingAsyncTask", "doInBackground", ex.getMessage());
                }
            }
            if (ret.booleanValue()) {
                FileHelper.DelFile(this.mData.getNew_file());
                File file = FileHelper.GetFile(String.valueOf(this.mData.getNew_file()) + ".tmp");
                if (file != null && (to = FileHelper.FileObject(this.mData.getNew_file())) != null) {
                    file.renameTo(to);
                }
            }
            return ret;
        }

        public void cancel() {
            TiebaUpdateService.this.mDowndingTask = null;
            this.mCanceled = true;
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            super.onPostExecute((DownLoadingAsyncTask) result);
            TiebaUpdateService.this.mDowndingTask = null;
            try {
                if (result.booleanValue()) {
                    TiebaUpdateService.this.mNotificationManager.cancel(10);
                    UtilHelper.install_apk(TiebaApplication.app, this.mData.getNew_file());
                } else if (TiebaUpdateService.this.mNotify != null) {
                    TiebaUpdateService.this.mNotify.contentView.setTextViewText(R.id.info, TiebaUpdateService.this.getString(R.string.error_sd_error));
                    TiebaUpdateService.this.mNotify.flags = 16;
                    TiebaUpdateService.this.mNotificationManager.notify(10, TiebaUpdateService.this.mNotify);
                }
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "onPostExecute", ex.getMessage());
            }
            TiebaUpdateService.this.stopSelf();
        }
    }
}
