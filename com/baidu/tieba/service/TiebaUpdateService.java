package com.baidu.tieba.service;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.R;
import com.baidu.tieba.e;
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
    private a mDowndMainApkTask;
    private b mDowndOtherApkTask;
    private boolean mHasAs;
    private boolean mHasOther;
    private boolean mHasTieba;
    private boolean mIsMainApkDone;
    private long mMainApkCurSize;
    private String mMainApkFileName;
    private boolean mMainApkInstallEnable;
    private String mMainApkMd5RSA;
    private long mMainApkSize;
    private String mMainApkUrl;
    private long mMainTaskWaitingTimestamp;
    private long mOtherApkCurSize;
    private String mOtherApkFileName;
    private String mOtherApkMd5RSA;
    private long mOtherApkSize;
    private String mOtherApkUrl;
    private long mOtherTaskWaitingTimestamp;
    private int mProgressAfter;
    private int mProgressBefore;
    private VersionData mVersionData;
    private final Handler mMainApkHandler = new c();
    private final Handler mOtherApkHandler = new d();

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
                this.mMainApkMd5RSA = intent.getStringExtra("MD5_RSA_tieba_apk");
                this.mVersionData = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                if (URLUtil.isNetworkUrl(this.mMainApkUrl) && !TextUtils.isEmpty(this.mMainApkMd5RSA)) {
                    this.mHasTieba = true;
                    this.mMainApkFileName = getString(R.string.app_name) + TbadkCoreApplication.getInst().getVersionName() + ".apk";
                } else {
                    this.mMainApkMd5RSA = intent.getStringExtra("MD5_RSA_as_apk");
                    this.mMainApkUrl = intent.getStringExtra(UpdateDialogConfig.KEY_AS_APK_URL);
                    if (URLUtil.isNetworkUrl(this.mMainApkUrl) && !TextUtils.isEmpty(this.mMainApkMd5RSA)) {
                        this.mHasAs = true;
                        this.mMainApkFileName = getFileOfUrl(this.mMainApkUrl);
                    }
                }
                this.mOtherApkUrl = intent.getStringExtra(UpdateDialogConfig.KEY_OTHER_APK_URL);
                this.mOtherApkMd5RSA = intent.getStringExtra("MD5_RSA_other_apk");
                this.mOtherApkFileName = getFileOfUrl(this.mOtherApkUrl);
                if (URLUtil.isNetworkUrl(this.mOtherApkUrl) && this.mOtherApkFileName.length() >= 4 && !TextUtils.isEmpty(this.mOtherApkMd5RSA)) {
                    this.mHasOther = true;
                } else {
                    this.mMainApkInstallEnable = true;
                }
                if (!this.mHasTieba && !this.mHasAs && !this.mHasOther) {
                    stopSelf(i);
                } else if (this.mHasTieba || this.mHasAs) {
                    if (this.mHasTieba) {
                        string = getString(R.string.tieba_downloading);
                    } else {
                        string = getString(R.string.as_downloading);
                    }
                    downloadMainApk(string);
                    if (this.mHasOther) {
                        downloadOtherApk();
                    }
                } else {
                    this.info = getString(R.string.downloading);
                    downloadOtherApk();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void downloadMainApk(String str) {
        boolean z;
        boolean z2;
        PackageInfo packageArchiveInfo;
        String fileDireciory = m.getFileDireciory(this.mMainApkFileName);
        if (fileDireciory != null && (packageArchiveInfo = getPackageManager().getPackageArchiveInfo(fileDireciory, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                File GetFile = m.GetFile(this.mMainApkFileName);
                if (!this.mHasAs) {
                    z2 = GetFile == null || !GetFile.exists();
                } else {
                    z2 = (GetFile != null && GetFile.exists() && z) ? false : true;
                }
                if (z2) {
                    this.mMainApkHandler.sendMessageDelayed(this.mMainApkHandler.obtainMessage(1, null), 300L);
                    return;
                }
                l.showToast(this, (int) R.string.download_begin_tip);
                if (GetFile != null) {
                    GetFile.delete();
                }
                if (this.mDowndMainApkTask == null) {
                    this.mDowndMainApkTask = new a();
                    this.mDowndMainApkTask.execute(new String[0]);
                    this.info = str;
                    NotificationHelper.showProgressNotification(this, 10, null, 0, null, str, true);
                    return;
                }
                return;
            }
        }
        z = false;
        File GetFile2 = m.GetFile(this.mMainApkFileName);
        if (!this.mHasAs) {
        }
        if (z2) {
        }
    }

    private void downloadOtherApk() {
        if (m.GetFile(this.mOtherApkFileName) != null) {
            this.mHasOther = false;
            this.mOtherApkHandler.sendMessageDelayed(this.mOtherApkHandler.obtainMessage(2, null), 300L);
        } else if (this.mDowndOtherApkTask == null) {
            this.mHasOther = true;
            this.mDowndOtherApkTask = new b();
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private x bUY;
        private volatile boolean mCanceled;

        private a() {
            this.mCanceled = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            Exception e;
            Boolean bool;
            Boolean bool2;
            Boolean bool3 = false;
            while (true) {
                try {
                    if (this.mCanceled) {
                        bool = bool3;
                        break;
                    }
                    this.bUY = new x(TiebaUpdateService.this.mMainApkUrl);
                    Boolean valueOf = Boolean.valueOf(this.bUY.downloadFile(m.CreateFileIfNotFound(TiebaUpdateService.this.mMainApkFileName + ".tmp").getAbsolutePath(), TiebaUpdateService.this.mMainApkHandler, 0, 5, 100, true));
                    try {
                        if (valueOf.booleanValue()) {
                            bool = valueOf;
                            break;
                        } else if (this.bUY.getServerErrorCode() != -2) {
                            if (!this.bUY.amp().amQ().isFileSegSuccess()) {
                                try {
                                    Thread.sleep(10000L);
                                } catch (Exception e2) {
                                }
                            }
                            if (TiebaUpdateService.sHasStart && System.currentTimeMillis() - TiebaUpdateService.this.mMainTaskWaitingTimestamp > TiebaUpdateService.MAX_WAIT_MILLS) {
                                TiebaStatic.log(new an(TbadkCoreStatisticKey.UPDATE_TIEFA_DOWNLOAD_FAILED).bS("obj_param1", this.bUY.getErrorString()));
                                TiebaUpdateService.this.downloadError();
                                bool = valueOf;
                                break;
                            }
                            bool3 = valueOf;
                        } else {
                            bool = valueOf;
                            break;
                        }
                    } catch (Exception e3) {
                        bool = bool2;
                        e = e3;
                        BdLog.e(e.getMessage());
                        return bool;
                    }
                } catch (Exception e4) {
                    e = e4;
                    bool = bool3;
                }
            }
            try {
                if (bool.booleanValue()) {
                    if (!e.d(TiebaUpdateService.this.mMainApkMd5RSA, m.GetFile(TiebaUpdateService.this.mMainApkFileName + ".tmp"))) {
                        m.DelFile(TiebaUpdateService.this.mMainApkFileName + ".tmp");
                        m.DelFile(TiebaUpdateService.this.mMainApkFileName);
                        bool = false;
                    }
                    TiebaUpdateService.this.renameFile(TiebaUpdateService.this.mMainApkFileName);
                }
            } catch (Exception e5) {
                e = e5;
                BdLog.e(e.getMessage());
                return bool;
            }
            return bool;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            TiebaUpdateService.this.mDowndMainApkTask = null;
            this.mCanceled = true;
            if (this.bUY != null) {
                this.bUY.cancelNetConnect();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            TiebaUpdateService.this.mDowndMainApkTask = null;
            try {
                if (bool.booleanValue()) {
                    TiebaUpdateService.this.mIsMainApkDone = true;
                    TiebaUpdateService.this.mMainApkHandler.sendMessageDelayed(TiebaUpdateService.this.mMainApkHandler.obtainMessage(1, TiebaUpdateService.this.mMainApkFileName), 300L);
                } else {
                    TiebaUpdateService.this.downloadError();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        private x bUY;
        private volatile boolean mCanceled;

        private b() {
            this.bUY = null;
            this.mCanceled = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0116, code lost:
            r0 = r1;
         */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Boolean doInBackground(String... strArr) {
            Boolean bool;
            Exception e;
            Boolean bool2 = false;
            while (true) {
                try {
                    if (this.mCanceled) {
                        break;
                    }
                    this.bUY = new x(TiebaUpdateService.this.mOtherApkUrl);
                    bool2 = Boolean.valueOf(this.bUY.a(TiebaUpdateService.this.mOtherApkFileName + ".tmp", TiebaUpdateService.this.mOtherApkHandler, 0));
                    if (bool2.booleanValue()) {
                        break;
                    } else if (this.bUY.getServerErrorCode() == -2) {
                        bool = bool2;
                        break;
                    } else {
                        if (!this.bUY.amp().amQ().isFileSegSuccess()) {
                            try {
                                Thread.sleep(10000L);
                            } catch (Exception e2) {
                            }
                        }
                        if (TiebaUpdateService.sHasStart && System.currentTimeMillis() - TiebaUpdateService.this.mOtherTaskWaitingTimestamp > TiebaUpdateService.MAX_WAIT_MILLS) {
                            if ((TiebaUpdateService.this.mHasTieba || TiebaUpdateService.this.mHasAs) && TiebaUpdateService.this.mIsMainApkDone) {
                                TiebaUpdateService.this.downloadError();
                                bool = bool2;
                            }
                        }
                    }
                } catch (Exception e3) {
                    bool = bool2;
                    e = e3;
                }
            }
            try {
                if (bool.booleanValue()) {
                    if (!e.d(TiebaUpdateService.this.mOtherApkMd5RSA, m.GetFile(TiebaUpdateService.this.mOtherApkFileName + ".tmp"))) {
                        m.DelFile(TiebaUpdateService.this.mOtherApkFileName + ".tmp");
                        m.DelFile(TiebaUpdateService.this.mOtherApkFileName);
                        bool = false;
                    }
                    TiebaUpdateService.this.renameFile(TiebaUpdateService.this.mOtherApkFileName);
                }
            } catch (Exception e4) {
                e = e4;
                BdLog.e(e.getMessage());
                return bool;
            }
            return bool;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            TiebaUpdateService.this.mDowndOtherApkTask = null;
            this.mCanceled = true;
            if (this.bUY != null) {
                this.bUY.cancelNetConnect();
            }
            if (!TiebaUpdateService.this.mHasTieba && !TiebaUpdateService.this.mHasAs) {
                boolean unused = TiebaUpdateService.sHasStart = false;
                TiebaUpdateService.this.stopSelf();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((b) bool);
            TiebaUpdateService.this.mDowndOtherApkTask = null;
            if (bool.booleanValue()) {
                TiebaUpdateService.this.mOtherTaskWaitingTimestamp = System.currentTimeMillis();
            }
            if (TiebaUpdateService.this.mHasTieba || TiebaUpdateService.this.mHasAs) {
                if (!TiebaUpdateService.this.mMainApkInstallEnable) {
                    TiebaUpdateService.this.mMainApkInstallEnable = true;
                } else {
                    TiebaUpdateService.this.mOtherApkHandler.sendMessageDelayed(TiebaUpdateService.this.mOtherApkHandler.obtainMessage(2, null), 300L);
                }
            } else {
                boolean unused = TiebaUpdateService.sHasStart = false;
                TiebaUpdateService.this.stopSelf();
            }
            if (!bool.booleanValue()) {
                TiebaUpdateService.this.downloadError();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renameFile(String str) {
        File FileObject;
        m.DelFile(str);
        File GetFile = m.GetFile(str + ".tmp");
        if (GetFile != null && (FileObject = m.FileObject(str)) != null && !GetFile.renameTo(FileObject)) {
            TiebaStatic.file("renameTo erro", "TiebaUpdateService.DownLoadingOtherAsyncTask");
        }
    }

    /* loaded from: classes.dex */
    private class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                if (message.arg2 > 0) {
                    TiebaUpdateService.this.mMainApkCurSize = message.arg1;
                    TiebaUpdateService.this.mMainApkSize = message.arg2;
                    if (TiebaUpdateService.this.mMainApkSize > TiebaUpdateService.this.mMainApkCurSize) {
                        TiebaUpdateService.this.mMainTaskWaitingTimestamp = System.currentTimeMillis();
                    }
                    if (TiebaUpdateService.this.mMainApkSize <= TiebaUpdateService.this.mMainApkCurSize) {
                        TiebaUpdateService.this.mIsMainApkDone = true;
                    }
                    int i = (int) ((TiebaUpdateService.this.mMainApkCurSize * 100) / TiebaUpdateService.this.mMainApkSize);
                    if (!TiebaUpdateService.this.mHasOther || TiebaUpdateService.this.mOtherApkSize == 0) {
                        if (!TiebaUpdateService.this.mHasOther || TiebaUpdateService.this.mOtherApkSize != 0) {
                            if (!TiebaUpdateService.this.mHasOther) {
                                TiebaUpdateService.this.updateProgress(TiebaUpdateService.this.mMainApkCurSize, TiebaUpdateService.this.mMainApkSize);
                                TiebaUpdateService.this.sendBroadcast(i);
                                return;
                            }
                            return;
                        }
                        if (i < 60) {
                            TiebaUpdateService.this.updateProgress(TiebaUpdateService.this.mMainApkCurSize, TiebaUpdateService.this.mMainApkSize);
                            TiebaUpdateService.this.sendBroadcast(i);
                        }
                        TiebaUpdateService.this.mProgressBefore = i;
                        return;
                    }
                    TiebaUpdateService.this.mProgressAfter = (int) (((TiebaUpdateService.this.mMainApkCurSize + TiebaUpdateService.this.mOtherApkCurSize) * 100) / (TiebaUpdateService.this.mMainApkSize + TiebaUpdateService.this.mOtherApkSize));
                    if (TiebaUpdateService.this.mProgressAfter > TiebaUpdateService.this.mProgressBefore) {
                        TiebaUpdateService.this.updateProgress(TiebaUpdateService.this.mMainApkCurSize + TiebaUpdateService.this.mOtherApkCurSize, TiebaUpdateService.this.mMainApkSize + TiebaUpdateService.this.mOtherApkSize);
                        TiebaUpdateService.this.sendBroadcast(TiebaUpdateService.this.mProgressAfter);
                        TiebaUpdateService.this.mProgressBefore = TiebaUpdateService.this.mProgressAfter;
                    }
                }
            } else if (message.what == 1) {
                if (TiebaUpdateService.this.mMainApkInstallEnable) {
                    if (TiebaUpdateService.this.mHasAs) {
                        TiebaUpdateService.this.startAsInstallService();
                    }
                    UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), TiebaUpdateService.this.mMainApkFileName);
                    TiebaUpdateService.this.finishDownload();
                    return;
                }
                TiebaUpdateService.this.mMainApkInstallEnable = true;
            } else if (message.what == 3) {
                l.showToast(TbadkCoreApplication.getInst(), (int) R.string.update_app_error);
            }
        }
    }

    /* loaded from: classes.dex */
    private class d extends Handler {
        private d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                if (message.arg2 > 0) {
                    TiebaUpdateService.this.mOtherApkCurSize = message.arg1;
                    TiebaUpdateService.this.mOtherApkSize = message.arg2;
                    if (TiebaUpdateService.this.mOtherApkSize > TiebaUpdateService.this.mOtherApkCurSize) {
                        TiebaUpdateService.this.mOtherTaskWaitingTimestamp = System.currentTimeMillis();
                    }
                    TiebaUpdateService.this.mProgressAfter = (int) (((TiebaUpdateService.this.mMainApkCurSize + TiebaUpdateService.this.mOtherApkCurSize) * 100) / (TiebaUpdateService.this.mMainApkSize + TiebaUpdateService.this.mOtherApkSize));
                    if (TiebaUpdateService.this.mHasOther) {
                        if ((TiebaUpdateService.this.mHasTieba || TiebaUpdateService.this.mHasAs) && TiebaUpdateService.this.mMainApkSize == TiebaUpdateService.this.mMainApkCurSize && TiebaUpdateService.this.mProgressAfter > TiebaUpdateService.this.mProgressBefore) {
                            TiebaUpdateService.this.updateProgress(TiebaUpdateService.this.mMainApkCurSize + TiebaUpdateService.this.mOtherApkCurSize, TiebaUpdateService.this.mMainApkSize + TiebaUpdateService.this.mOtherApkSize);
                            TiebaUpdateService.this.sendBroadcast(TiebaUpdateService.this.mProgressAfter);
                            TiebaUpdateService.this.mProgressBefore = TiebaUpdateService.this.mProgressAfter;
                        }
                    }
                }
            } else if (message.what == 2) {
                if (TiebaUpdateService.this.mHasTieba || TiebaUpdateService.this.mHasAs) {
                    if (!TiebaUpdateService.this.mMainApkInstallEnable) {
                        TiebaUpdateService.this.mMainApkInstallEnable = true;
                        return;
                    } else {
                        TiebaUpdateService.this.mMainApkHandler.sendMessageDelayed(TiebaUpdateService.this.mMainApkHandler.obtainMessage(1, null), 300L);
                        return;
                    }
                }
                TiebaUpdateService.this.finishDownload();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAsInstallService() {
        Intent intent = new Intent();
        intent.setClass(this, AsInstallService.class);
        if (this.mVersionData != null) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.mVersionData);
            startService(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishDownload() {
        sendBroadcast("action_update_complete", true);
        NotificationHelper.cancelNotification(this, 10);
        if (this.mOtherApkFileName != null && this.mOtherApkFileName.length() > 4) {
            TbadkCoreApplication.getInst().setInstallOtherApp(this.mOtherApkFileName);
        }
        stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(long j, long j2) {
        if (j2 > 0) {
            int i = (int) ((100 * j) / j2);
            StringBuffer stringBuffer = new StringBuffer(20);
            stringBuffer.append(String.valueOf(j / 1000));
            stringBuffer.append("K/");
            stringBuffer.append(String.valueOf(j2 / 1000));
            stringBuffer.append("K");
            NotificationHelper.showProgressNotification(this, 10, null, i, i + "%", this.info, true);
        }
    }

    public void sendBroadcast(int i) {
        Intent intent = new Intent();
        intent.setAction(TbConfig.APP_UPDATE_ACTION);
        intent.putExtra("action_update_download_progress", i);
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
    }

    public void sendBroadcast(String str, boolean z) {
        Intent intent = new Intent();
        intent.setAction(TbConfig.APP_UPDATE_ACTION);
        intent.putExtra(str, z);
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadError() {
        this.mMainApkHandler.sendMessage(this.mMainApkHandler.obtainMessage(3));
        NotificationHelper.cancelNotification(this, 10);
        sHasStart = false;
        stopSelf();
    }
}
