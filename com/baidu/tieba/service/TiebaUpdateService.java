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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.i;
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
    private final Handler mMainApkHandler = new c(this, null);
    private final Handler mOtherApkHandler = new d(this, null);

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
                    this.mMainApkFileName = String.valueOf(getString(i.h.app_name)) + TbadkCoreApplication.m411getInst().getVersionName() + ".apk";
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
                        string = getString(i.h.tieba_downloading);
                    } else {
                        string = getString(i.h.as_downloading);
                    }
                    downloadMainApk(string);
                    if (this.mHasOther) {
                        downloadOtherApk();
                    }
                } else {
                    this.info = getString(i.h.downloading);
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
        String cH = n.cH(this.mMainApkFileName);
        if (cH != null && (packageArchiveInfo = getPackageManager().getPackageArchiveInfo(cH, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                File cI = n.cI(this.mMainApkFileName);
                if (!this.mHasAs) {
                    z2 = cI == null || !cI.exists();
                } else {
                    z2 = (cI != null && cI.exists() && z) ? false : true;
                }
                if (z2) {
                    this.mMainApkHandler.sendMessageDelayed(this.mMainApkHandler.obtainMessage(1, null), 300L);
                    return;
                }
                k.showToast(this, i.h.download_begin_tip);
                if (cI != null) {
                    cI.delete();
                }
                if (this.mDowndMainApkTask == null) {
                    this.mDowndMainApkTask = new a(this, null);
                    this.mDowndMainApkTask.execute(new String[0]);
                    this.info = str;
                    NotificationHelper.showProgressNotification(this, 10, null, 0, null, str, true);
                    return;
                }
                return;
            }
        }
        z = false;
        File cI2 = n.cI(this.mMainApkFileName);
        if (!this.mHasAs) {
        }
        if (z2) {
        }
    }

    private void downloadOtherApk() {
        if (n.cI(this.mOtherApkFileName) != null) {
            this.mHasOther = false;
            this.mOtherApkHandler.sendMessageDelayed(this.mOtherApkHandler.obtainMessage(2, null), 300L);
        } else if (this.mDowndOtherApkTask == null) {
            this.mHasOther = true;
            this.mDowndOtherApkTask = new b(this, null);
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
        private w Th;
        private volatile boolean aOz;

        private a() {
            this.aOz = false;
        }

        /* synthetic */ a(TiebaUpdateService tiebaUpdateService, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            Boolean bool;
            Exception e;
            Boolean bool2 = false;
            while (!this.aOz) {
                try {
                    this.Th = new w(TiebaUpdateService.this.mMainApkUrl);
                    bool2 = Boolean.valueOf(this.Th.a(String.valueOf(TiebaUpdateService.this.mMainApkFileName) + ".tmp", TiebaUpdateService.this.mMainApkHandler, 0));
                    if (!bool2.booleanValue()) {
                        if (this.Th.ul() != -2) {
                            if (!this.Th.uh().uY().gK()) {
                                try {
                                    Thread.sleep(10000L);
                                } catch (Exception e2) {
                                }
                            }
                            if (TiebaUpdateService.sHasStart && System.currentTimeMillis() - TiebaUpdateService.this.mMainTaskWaitingTimestamp > TiebaUpdateService.MAX_WAIT_MILLS) {
                                TiebaUpdateService.this.downloadError();
                                bool = bool2;
                                break;
                            }
                        } else {
                            bool = bool2;
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Exception e3) {
                    bool = bool2;
                    e = e3;
                }
            }
            bool = bool2;
            try {
                if (bool.booleanValue()) {
                    TiebaUpdateService.this.renameFile(TiebaUpdateService.this.mMainApkFileName);
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
            TiebaUpdateService.this.mDowndMainApkTask = null;
            this.aOz = true;
            if (this.Th != null) {
                this.Th.gJ();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            TiebaUpdateService.this.mDowndMainApkTask = null;
            try {
                if (bool.booleanValue()) {
                    TiebaUpdateService.this.mIsMainApkDone = true;
                    TiebaUpdateService.this.mMainApkHandler.sendMessageDelayed(TiebaUpdateService.this.mMainApkHandler.obtainMessage(1, TiebaUpdateService.this.mMainApkFileName), 300L);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        private w Th;
        private volatile boolean aOz;

        private b() {
            this.Th = null;
            this.aOz = false;
        }

        /* synthetic */ b(TiebaUpdateService tiebaUpdateService, b bVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0096, code lost:
            if (r7.cKE.mHasTieba != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x009e, code lost:
            if (r7.cKE.mHasAs == false) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00a6, code lost:
            if (r7.cKE.mIsMainApkDone == false) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00a8, code lost:
            r7.cKE.downloadError();
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00ad, code lost:
            r0 = r1;
         */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Boolean doInBackground(String... strArr) {
            Boolean bool;
            Exception e;
            Boolean bool2 = false;
            while (true) {
                try {
                    if (!this.aOz) {
                        this.Th = new w(TiebaUpdateService.this.mOtherApkUrl);
                        bool2 = Boolean.valueOf(this.Th.a(String.valueOf(TiebaUpdateService.this.mOtherApkFileName) + ".tmp", TiebaUpdateService.this.mOtherApkHandler, 0));
                        if (!bool2.booleanValue()) {
                            if (this.Th.ul() != -2) {
                                if (!this.Th.uh().uY().gK()) {
                                    try {
                                        Thread.sleep(10000L);
                                    } catch (Exception e2) {
                                    }
                                }
                                if (TiebaUpdateService.sHasStart && System.currentTimeMillis() - TiebaUpdateService.this.mOtherTaskWaitingTimestamp > TiebaUpdateService.MAX_WAIT_MILLS) {
                                    break;
                                }
                            } else {
                                bool = bool2;
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Exception e3) {
                    bool = bool2;
                    e = e3;
                }
            }
            bool = bool2;
            try {
                if (bool.booleanValue()) {
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
            this.aOz = true;
            if (this.Th != null) {
                this.Th.gJ();
            }
            if (!TiebaUpdateService.this.mHasTieba && !TiebaUpdateService.this.mHasAs) {
                TiebaUpdateService.sHasStart = false;
                TiebaUpdateService.this.stopSelf();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            TiebaUpdateService.this.mDowndOtherApkTask = null;
            if (bool.booleanValue()) {
                TiebaUpdateService.this.mOtherTaskWaitingTimestamp = System.currentTimeMillis();
            }
            if (!TiebaUpdateService.this.mHasTieba && !TiebaUpdateService.this.mHasAs) {
                TiebaUpdateService.sHasStart = false;
                TiebaUpdateService.this.stopSelf();
            } else if (!TiebaUpdateService.this.mMainApkInstallEnable) {
                TiebaUpdateService.this.mMainApkInstallEnable = true;
            } else {
                TiebaUpdateService.this.mOtherApkHandler.sendMessageDelayed(TiebaUpdateService.this.mOtherApkHandler.obtainMessage(2, null), 300L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renameFile(String str) {
        File cL;
        n.cQ(str);
        File cI = n.cI(String.valueOf(str) + ".tmp");
        if (cI != null && (cL = n.cL(str)) != null && !cI.renameTo(cL)) {
            TiebaStatic.file("renameTo erro", "TiebaUpdateService.DownLoadingOtherAsyncTask");
        }
    }

    /* loaded from: classes.dex */
    private class c extends Handler {
        private c() {
        }

        /* synthetic */ c(TiebaUpdateService tiebaUpdateService, c cVar) {
            this();
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
                            if (TiebaUpdateService.this.mHasOther) {
                                return;
                            }
                            TiebaUpdateService.this.updateProgress(TiebaUpdateService.this.mMainApkCurSize, TiebaUpdateService.this.mMainApkSize);
                            TiebaUpdateService.this.sendBroadcast(i);
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
                    if (TiebaUpdateService.this.mProgressAfter <= TiebaUpdateService.this.mProgressBefore) {
                        return;
                    }
                    TiebaUpdateService.this.updateProgress(TiebaUpdateService.this.mMainApkCurSize + TiebaUpdateService.this.mOtherApkCurSize, TiebaUpdateService.this.mMainApkSize + TiebaUpdateService.this.mOtherApkSize);
                    TiebaUpdateService.this.sendBroadcast(TiebaUpdateService.this.mProgressAfter);
                    TiebaUpdateService.this.mProgressBefore = TiebaUpdateService.this.mProgressAfter;
                }
            } else if (message.what == 1) {
                if (TiebaUpdateService.this.mMainApkInstallEnable) {
                    if (TiebaUpdateService.this.mHasAs) {
                        TiebaUpdateService.this.startAsInstallService();
                    }
                    UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), TiebaUpdateService.this.mMainApkFileName);
                    TiebaUpdateService.this.finishDownload();
                    return;
                }
                TiebaUpdateService.this.mMainApkInstallEnable = true;
            } else if (message.what == 3) {
                k.showToast(TbadkCoreApplication.m411getInst(), i.h.update_app_error);
            }
        }
    }

    /* loaded from: classes.dex */
    private class d extends Handler {
        private d() {
        }

        /* synthetic */ d(TiebaUpdateService tiebaUpdateService, d dVar) {
            this();
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
                        if ((!TiebaUpdateService.this.mHasTieba && !TiebaUpdateService.this.mHasAs) || TiebaUpdateService.this.mMainApkSize != TiebaUpdateService.this.mMainApkCurSize || TiebaUpdateService.this.mProgressAfter <= TiebaUpdateService.this.mProgressBefore) {
                            return;
                        }
                        TiebaUpdateService.this.updateProgress(TiebaUpdateService.this.mMainApkCurSize + TiebaUpdateService.this.mOtherApkCurSize, TiebaUpdateService.this.mMainApkSize + TiebaUpdateService.this.mOtherApkSize);
                        TiebaUpdateService.this.sendBroadcast(TiebaUpdateService.this.mProgressAfter);
                        TiebaUpdateService.this.mProgressBefore = TiebaUpdateService.this.mProgressAfter;
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
            TbadkCoreApplication.m411getInst().setInstallOtherApp(this.mOtherApkFileName);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadError() {
        this.mMainApkHandler.sendMessage(this.mMainApkHandler.obtainMessage(3));
        NotificationHelper.cancelNotification(this, 10);
        sHasStart = false;
        stopSelf();
    }
}
