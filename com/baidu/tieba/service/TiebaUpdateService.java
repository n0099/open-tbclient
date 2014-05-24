package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.RemoteViews;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.ai;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.y;
import java.io.File;
/* loaded from: classes.dex */
public class TiebaUpdateService extends Service {
    private static final long MAX_WAIT_MILLS = 20000;
    private static final int MSG_DOWNLOAD_PROCESS = 0;
    private static final int MSG_MAIN_APK_EXIST = 1;
    private static final int MSG_OTHER_APK_EXIST = 2;
    private static boolean sHasStart = false;
    private t mDowndMainApkTask;
    private u mDowndOtherApkTask;
    private boolean mHasAs;
    private boolean mHasOther;
    private boolean mHasTieba;
    private boolean mIsMainApkDone;
    private long mMainApkCurSize;
    private String mMainApkFileName;
    private boolean mMainApkInstallEnable;
    private long mMainApkSize;
    private String mMainApkUrl;
    private long mMainTaskWaitingTimestamp;
    private Notification mNotification;
    private NotificationManager mNotificationManager;
    private long mOtherApkCurSize;
    private String mOtherApkFileName;
    private long mOtherApkSize;
    private String mOtherApkUrl;
    private long mOtherTaskWaitingTimestamp;
    private int mProgressAfter;
    private int mProgressBefore;
    private VersionData mVersionData;
    private final Handler mMainApkHandler = new v(this, null);
    private final Handler mOtherApkHandler = new w(this, null);

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mNotificationManager = (NotificationManager) getSystemService("notification");
        this.mNotification = getUpdateNotification();
        if (this.mNotificationManager == null || this.mNotification == null) {
            stopSelf();
        }
    }

    private Notification getUpdateNotification() {
        PendingIntent activity = PendingIntent.getActivity(ai.c().d(), 0, new Intent(), 0);
        Notification notification = new Notification(17301633, null, System.currentTimeMillis());
        notification.contentView = new RemoteViews(ai.c().d().getPackageName(), com.baidu.tieba.w.notify_item);
        notification.contentView.setProgressBar(com.baidu.tieba.v.progress, 100, 0, false);
        notification.contentIntent = activity;
        notification.flags = 32;
        return notification;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        String string;
        if (intent != null && "action_stop".equals(intent.getAction()) && (this.mHasTieba || this.mHasAs)) {
            stopSelf();
            return;
        }
        BdLog.i(getClass().getName(), "onStart", "onStart");
        if (!sHasStart && intent != null) {
            sHasStart = true;
            this.mMainTaskWaitingTimestamp = System.currentTimeMillis();
            this.mOtherTaskWaitingTimestamp = System.currentTimeMillis();
            this.mMainApkUrl = intent.getStringExtra("key_tieba_apk_url");
            this.mVersionData = (VersionData) intent.getSerializableExtra("tieba_apk_data");
            if (URLUtil.isNetworkUrl(this.mMainApkUrl)) {
                this.mHasTieba = true;
                this.mMainApkFileName = String.valueOf(getString(y.app_name)) + TbadkApplication.m252getInst().getVersionName() + ".apk";
            } else {
                this.mMainApkUrl = intent.getStringExtra("as_apk_url");
                if (URLUtil.isNetworkUrl(this.mMainApkUrl)) {
                    this.mHasAs = true;
                    this.mMainApkFileName = getFileOfUrl(this.mMainApkUrl);
                }
            }
            this.mOtherApkUrl = intent.getStringExtra("other_apk_url");
            this.mOtherApkFileName = getFileOfUrl(this.mOtherApkUrl);
            if (URLUtil.isNetworkUrl(this.mOtherApkUrl) && this.mOtherApkFileName.length() >= 4) {
                this.mHasOther = true;
            } else {
                this.mMainApkInstallEnable = true;
            }
            if (!this.mHasTieba && !this.mHasAs && !this.mHasOther) {
                stopSelf(i);
            } else if (this.mNotificationManager == null || this.mNotification == null || this.mNotification.contentView == null) {
                stopSelf(i);
            } else {
                if (this.mHasTieba || this.mHasAs) {
                    if (this.mHasTieba) {
                        string = getString(y.tieba_downloading);
                    } else {
                        string = getString(y.as_downloading);
                    }
                    this.mNotification.contentView.setTextViewText(com.baidu.tieba.v.info, string);
                    this.mNotification.contentView.setTextViewText(com.baidu.tieba.v.schedule, "0/0");
                    sendBroadcast(0);
                    downloadMainApk();
                    if (this.mHasOther) {
                        downloadOtherApk();
                    }
                } else {
                    downloadOtherApk();
                }
                super.onStart(intent, i);
            }
        }
    }

    private void downloadMainApk() {
        if (x.d(this.mMainApkFileName) != null) {
            this.mMainApkHandler.sendMessageDelayed(this.mMainApkHandler.obtainMessage(1, null), 100L);
        } else if (this.mDowndMainApkTask == null) {
            this.mDowndMainApkTask = new t(this, null);
            this.mDowndMainApkTask.execute(new String[0]);
            this.mNotification.contentView.setProgressBar(com.baidu.tieba.v.progress, 100, 0, false);
            this.mNotificationManager.notify(10, this.mNotification);
        }
    }

    private void downloadOtherApk() {
        if (x.d(this.mOtherApkFileName) != null) {
            this.mHasOther = false;
            this.mOtherApkHandler.sendMessageDelayed(this.mOtherApkHandler.obtainMessage(2, null), 100L);
        } else if (this.mDowndOtherApkTask == null) {
            this.mHasOther = true;
            this.mDowndOtherApkTask = new u(this, null);
            this.mDowndOtherApkTask.execute(new String[0]);
        }
    }

    private String getFileOfUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        String[] split = str.split("/");
        return split[split.length - 1];
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mMainApkHandler.removeMessages(0);
        this.mOtherApkHandler.removeMessages(0);
        if (this.mDowndMainApkTask != null) {
            this.mDowndMainApkTask.cancel();
        }
        if (this.mDowndOtherApkTask != null) {
            this.mDowndOtherApkTask.cancel();
        }
        if (this.mNotificationManager != null) {
            this.mNotificationManager.cancel(10);
        }
        sHasStart = false;
    }

    public void renameFile(String str) {
        File e;
        x.j(str);
        File d = x.d(String.valueOf(str) + ".tmp");
        if (d != null && (e = x.e(str)) != null && !d.renameTo(e)) {
            BdLog.e(getClass().getName(), "doInBackground", "renameTo error");
            TiebaStatic.file("renameTo erro", "TiebaUpdateService.DownLoadingOtherAsyncTask");
        }
    }

    public void startAsInstallService() {
        Intent intent = new Intent();
        intent.setClass(this, AsInstallService.class);
        if (this.mVersionData != null) {
            intent.putExtra("tieba_apk_data", this.mVersionData);
            startService(intent);
        }
    }

    public void finishDownload() {
        sendBroadcast("action_update_complete", true);
        this.mNotificationManager.cancel(10);
        if (this.mOtherApkFileName != null && this.mOtherApkFileName.length() > 4) {
            TbadkApplication.m252getInst().setInstallOtherApp(this.mOtherApkFileName);
        }
        stopSelf();
    }

    public void updateProgress(long j, long j2) {
        if (j2 > 0) {
            this.mNotification.contentView.setProgressBar(com.baidu.tieba.v.progress, 100, (int) ((100 * j) / j2), false);
            StringBuffer stringBuffer = new StringBuffer(20);
            stringBuffer.append(String.valueOf(j / 1000));
            stringBuffer.append("K/");
            stringBuffer.append(String.valueOf(j2 / 1000));
            stringBuffer.append("K");
            this.mNotification.contentView.setTextViewText(com.baidu.tieba.v.schedule, stringBuffer);
            this.mNotificationManager.notify(10, this.mNotification);
        }
    }

    public void sendBroadcast(int i) {
        Intent intent = new Intent();
        intent.setAction(TbConfig.APP_UPDATE_ACTION);
        intent.putExtra("action_update_download_progress", i);
        sendBroadcast(intent);
    }

    public void sendBroadcast(String str, boolean z) {
        Intent intent = new Intent();
        intent.setAction(TbConfig.APP_UPDATE_ACTION);
        intent.putExtra(str, z);
        sendBroadcast(intent);
    }
}
