package com.baidu.tieba.service;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.baidu.adp.base.BdBaseService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.t;
import java.io.File;
/* loaded from: classes.dex */
public class TiebaUpdateService extends BdBaseService {
    private static final int INSTALL_DELAY = 300;
    private static final long MAX_WAIT_MILLS = 20000;
    private static final int MSG_DOWNLOAD_PROCESS = 0;
    private static final int MSG_MAIN_APK_EXIST = 1;
    private static final int MSG_OTHER_APK_EXIST = 2;
    private static final int MSG_SHOW_ERROR_TOAST = 3;
    private static boolean sHasStart = false;
    private String info;
    private m mDowndMainApkTask;
    private n mDowndOtherApkTask;
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
    private final Handler mMainApkHandler = new o(this, null);
    private final Handler mOtherApkHandler = new p(this, null);

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        String string;
        if (intent != null) {
            if ("action_stop".equals(intent.getAction()) && (this.mHasTieba || this.mHasAs)) {
                stopSelf();
            } else if (sHasStart) {
                sendBroadcast("action_background_downloading", true);
            } else {
                sHasStart = true;
                this.mMainTaskWaitingTimestamp = System.currentTimeMillis();
                this.mOtherTaskWaitingTimestamp = System.currentTimeMillis();
                this.mMainApkUrl = intent.getStringExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL);
                this.mVersionData = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                if (URLUtil.isNetworkUrl(this.mMainApkUrl)) {
                    this.mHasTieba = true;
                    this.mMainApkFileName = String.valueOf(getString(t.app_name)) + TbadkCoreApplication.m411getInst().getVersionName() + ".apk";
                } else {
                    this.mMainApkUrl = intent.getStringExtra(UpdateDialogConfig.KEY_AS_APK_URL);
                    if (URLUtil.isNetworkUrl(this.mMainApkUrl)) {
                        this.mHasAs = true;
                        this.mMainApkFileName = getFileOfUrl(this.mMainApkUrl);
                    }
                }
                this.mOtherApkUrl = intent.getStringExtra(UpdateDialogConfig.KEY_OTHER_APK_URL);
                this.mOtherApkFileName = getFileOfUrl(this.mOtherApkUrl);
                if (URLUtil.isNetworkUrl(this.mOtherApkUrl) && this.mOtherApkFileName.length() >= 4) {
                    this.mHasOther = true;
                } else {
                    this.mMainApkInstallEnable = true;
                }
                if (!this.mHasTieba && !this.mHasAs && !this.mHasOther) {
                    stopSelf(i);
                } else if (this.mHasTieba || this.mHasAs) {
                    if (this.mHasTieba) {
                        string = getString(t.tieba_downloading);
                    } else {
                        string = getString(t.as_downloading);
                    }
                    downloadMainApk(string);
                    if (this.mHasOther) {
                        downloadOtherApk();
                    }
                } else {
                    this.info = getString(t.downloading);
                    downloadOtherApk();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void downloadMainApk(String str) {
        boolean z;
        boolean z2;
        PackageInfo packageArchiveInfo;
        String cA = com.baidu.tbadk.core.util.o.cA(this.mMainApkFileName);
        if (cA != null && (packageArchiveInfo = getPackageManager().getPackageArchiveInfo(cA, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                File cB = com.baidu.tbadk.core.util.o.cB(this.mMainApkFileName);
                if (!this.mHasAs) {
                    z2 = cB == null || !cB.exists();
                } else {
                    z2 = (cB != null && cB.exists() && z) ? false : true;
                }
                if (z2) {
                    this.mMainApkHandler.sendMessageDelayed(this.mMainApkHandler.obtainMessage(1, null), 300L);
                    return;
                }
                com.baidu.adp.lib.util.n.showToast(this, t.download_begin_tip);
                if (cB != null) {
                    cB.delete();
                }
                if (this.mDowndMainApkTask == null) {
                    this.mDowndMainApkTask = new m(this, null);
                    this.mDowndMainApkTask.execute(new String[0]);
                    this.info = str;
                    NotificationHelper.showProgressNotification(this, 10, null, 0, null, str, true);
                    return;
                }
                return;
            }
        }
        z = false;
        File cB2 = com.baidu.tbadk.core.util.o.cB(this.mMainApkFileName);
        if (!this.mHasAs) {
        }
        if (z2) {
        }
    }

    private void downloadOtherApk() {
        if (com.baidu.tbadk.core.util.o.cB(this.mOtherApkFileName) != null) {
            this.mHasOther = false;
            this.mOtherApkHandler.sendMessageDelayed(this.mOtherApkHandler.obtainMessage(2, null), 300L);
        } else if (this.mDowndOtherApkTask == null) {
            this.mHasOther = true;
            this.mDowndOtherApkTask = new n(this, null);
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
        File cC;
        com.baidu.tbadk.core.util.o.cH(str);
        File cB = com.baidu.tbadk.core.util.o.cB(String.valueOf(str) + ".tmp");
        if (cB != null && (cC = com.baidu.tbadk.core.util.o.cC(str)) != null && !cB.renameTo(cC)) {
            TiebaStatic.file("renameTo erro", "TiebaUpdateService.DownLoadingOtherAsyncTask");
        }
    }

    public void startAsInstallService() {
        Intent intent = new Intent();
        intent.setClass(this, AsInstallService.class);
        if (this.mVersionData != null) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.mVersionData);
            startService(intent);
        }
    }

    public void finishDownload() {
        sendBroadcast("action_update_complete", true);
        NotificationHelper.cancelNotification(this, 10);
        if (this.mOtherApkFileName != null && this.mOtherApkFileName.length() > 4) {
            TbadkCoreApplication.m411getInst().setInstallOtherApp(this.mOtherApkFileName);
        }
        stopSelf();
    }

    public void updateProgress(long j, long j2) {
        if (j2 > 0) {
            int i = (int) ((100 * j) / j2);
            StringBuffer stringBuffer = new StringBuffer(20);
            stringBuffer.append(String.valueOf(j / 1000));
            stringBuffer.append("K/");
            stringBuffer.append(String.valueOf(j2 / 1000));
            stringBuffer.append("K");
            NotificationHelper.showProgressNotification(this, 10, null, i, String.valueOf(i) + "%", this.info, true);
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

    public void downloadError() {
        this.mMainApkHandler.sendMessage(this.mMainApkHandler.obtainMessage(3));
        NotificationHelper.cancelNotification(this, 10);
        sHasStart = false;
        stopSelf();
    }
}
