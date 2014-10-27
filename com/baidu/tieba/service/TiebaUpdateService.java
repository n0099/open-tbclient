package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.data.VersionData;
import java.io.File;
/* loaded from: classes.dex */
public class TiebaUpdateService extends Service {
    private static final long MAX_WAIT_MILLS = 20000;
    private static final int MSG_DOWNLOAD_PROCESS = 0;
    private static final int MSG_MAIN_APK_EXIST = 1;
    private static final int MSG_OTHER_APK_EXIST = 2;
    private static boolean sHasStart = false;
    private String info;
    private u mDowndMainApkTask;
    private v mDowndOtherApkTask;
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
    private long mOtherApkCurSize;
    private String mOtherApkFileName;
    private long mOtherApkSize;
    private String mOtherApkUrl;
    private long mOtherTaskWaitingTimestamp;
    private int mProgressAfter;
    private int mProgressBefore;
    private VersionData mVersionData;
    private final Handler mMainApkHandler = new w(this, null);
    private final Handler mOtherApkHandler = new x(this, null);

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        String string;
        if (intent != null && "action_stop".equals(intent.getAction()) && (this.mHasTieba || this.mHasAs)) {
            stopSelf();
        } else if (!sHasStart && intent != null) {
            sHasStart = true;
            this.mMainTaskWaitingTimestamp = System.currentTimeMillis();
            this.mOtherTaskWaitingTimestamp = System.currentTimeMillis();
            this.mMainApkUrl = intent.getStringExtra("key_tieba_apk_url");
            this.mVersionData = (VersionData) intent.getSerializableExtra("tieba_apk_data");
            if (URLUtil.isNetworkUrl(this.mMainApkUrl)) {
                this.mHasTieba = true;
                this.mMainApkFileName = String.valueOf(getString(com.baidu.tieba.y.app_name)) + TbadkApplication.m251getInst().getVersionName() + ".apk";
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
                return;
            }
            if (this.mHasTieba || this.mHasAs) {
                if (this.mHasTieba) {
                    string = getString(com.baidu.tieba.y.tieba_downloading);
                } else {
                    string = getString(com.baidu.tieba.y.as_downloading);
                }
                sendBroadcast(0);
                downloadMainApk(string);
                if (this.mHasOther) {
                    downloadOtherApk();
                }
            } else {
                downloadOtherApk();
            }
            super.onStart(intent, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void downloadMainApk(String str) {
        boolean z;
        File br;
        PackageInfo packageArchiveInfo;
        String bq = com.baidu.tbadk.core.util.s.bq(this.mMainApkFileName);
        if (bq != null && (packageArchiveInfo = getPackageManager().getPackageArchiveInfo(bq, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                br = com.baidu.tbadk.core.util.s.br(this.mMainApkFileName);
                if (br == null && br.exists() && z) {
                    this.mMainApkHandler.sendMessageDelayed(this.mMainApkHandler.obtainMessage(1, null), 100L);
                    return;
                }
                if (br != null) {
                    br.delete();
                }
                if (this.mDowndMainApkTask != null) {
                    this.mDowndMainApkTask = new u(this, null);
                    this.mDowndMainApkTask.execute(new String[0]);
                    this.info = str;
                    NotificationHelper.showProgressNotification(this, 10, null, 0, null, str, true);
                    return;
                }
                return;
            }
        }
        z = false;
        br = com.baidu.tbadk.core.util.s.br(this.mMainApkFileName);
        if (br == null) {
        }
        if (br != null) {
        }
        if (this.mDowndMainApkTask != null) {
        }
    }

    private void downloadOtherApk() {
        if (com.baidu.tbadk.core.util.s.br(this.mOtherApkFileName) != null) {
            this.mHasOther = false;
            this.mOtherApkHandler.sendMessageDelayed(this.mOtherApkHandler.obtainMessage(2, null), 100L);
        } else if (this.mDowndOtherApkTask == null) {
            this.mHasOther = true;
            this.mDowndOtherApkTask = new v(this, null);
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
        NotificationHelper.cancelNotification(this, 10);
        sHasStart = false;
    }

    public void renameFile(String str) {
        File bs;
        com.baidu.tbadk.core.util.s.bx(str);
        File br = com.baidu.tbadk.core.util.s.br(String.valueOf(str) + ".tmp");
        if (br != null && (bs = com.baidu.tbadk.core.util.s.bs(str)) != null && !br.renameTo(bs)) {
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
        NotificationHelper.cancelNotification(this, 10);
        if (this.mOtherApkFileName != null && this.mOtherApkFileName.length() > 4) {
            TbadkApplication.m251getInst().setInstallOtherApp(this.mOtherApkFileName);
        }
        stopSelf();
    }

    public void updateProgress(long j, long j2) {
        if (j2 > 0) {
            StringBuffer stringBuffer = new StringBuffer(20);
            stringBuffer.append(String.valueOf(j / 1000));
            stringBuffer.append("K/");
            stringBuffer.append(String.valueOf(j2 / 1000));
            stringBuffer.append("K");
            NotificationHelper.showProgressNotification(this, 10, null, (int) ((100 * j) / j2), stringBuffer.toString(), this.info, true);
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
