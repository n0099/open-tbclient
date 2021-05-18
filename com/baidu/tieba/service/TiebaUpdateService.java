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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.k0.k;
import java.io.File;
/* loaded from: classes5.dex */
public class TiebaUpdateService extends BdBaseService {
    public static final int INSTALL_DELAY = 300;
    public static final long MAX_WAIT_MILLS = 20000;
    public static final int MSG_DOWNLOAD_PROCESS = 0;
    public static final int MSG_MAIN_APK_EXIST = 1;
    public static final int MSG_OTHER_APK_EXIST = 2;
    public static final int MSG_SHOW_ERROR_TOAST = 3;
    public static boolean sHasStart = false;
    public String info;
    public b mDowndMainApkTask;
    public c mDowndOtherApkTask;
    public boolean mHasAs;
    public boolean mHasOther;
    public boolean mHasTieba;
    public boolean mIsMainApkDone;
    public long mMainApkCurSize;
    public String mMainApkFileName;
    public boolean mMainApkInstallEnable;
    public String mMainApkMd5RSA;
    public long mMainApkSize;
    public String mMainApkUrl;
    public long mMainTaskWaitingTimestamp;
    public long mOtherApkCurSize;
    public String mOtherApkFileName;
    public String mOtherApkMd5RSA;
    public long mOtherApkSize;
    public String mOtherApkUrl;
    public long mOtherTaskWaitingTimestamp;
    public int mProgressAfter;
    public int mProgressBefore;
    public VersionData mVersionData;
    public final Handler mMainApkHandler = new d();
    public final Handler mOtherApkHandler = new e();

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20428a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f20429b;

        public b() {
            this.f20429b = false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            TiebaUpdateService.this.mDowndMainApkTask = null;
            this.f20429b = true;
            NetWork netWork = this.f20428a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            Boolean bool = Boolean.FALSE;
            while (true) {
                try {
                    if (!this.f20429b) {
                        this.f20428a = new NetWork(TiebaUpdateService.this.mMainApkUrl);
                        bool = Boolean.valueOf(this.f20428a.downloadFile(FileHelper.CreateFileIfNotFound(TiebaUpdateService.this.mMainApkFileName + ".tmp").getAbsolutePath(), TiebaUpdateService.this.mMainApkHandler, 0, 5, 100, true));
                        if (!bool.booleanValue() && this.f20428a.getServerErrorCode() != -2) {
                            if (!this.f20428a.getNetContext().getResponse().isFileSegSuccess()) {
                                try {
                                    Thread.sleep(10000L);
                                } catch (Exception unused) {
                                }
                            }
                            if (TiebaUpdateService.sHasStart && System.currentTimeMillis() - TiebaUpdateService.this.mMainTaskWaitingTimestamp > 20000) {
                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.UPDATE_TIEFA_DOWNLOAD_FAILED).param("obj_param1", this.f20428a.getErrorString()));
                                TiebaUpdateService.this.downloadError();
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            if (bool.booleanValue()) {
                if (!k.a(TiebaUpdateService.this.mMainApkMd5RSA, FileHelper.GetFile(TiebaUpdateService.this.mMainApkFileName + ".tmp"))) {
                    bool = Boolean.FALSE;
                    FileHelper.DelFile(TiebaUpdateService.this.mMainApkFileName + ".tmp");
                    FileHelper.DelFile(TiebaUpdateService.this.mMainApkFileName);
                }
                TiebaUpdateService.this.renameFile(TiebaUpdateService.this.mMainApkFileName);
            }
            return bool;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((b) bool);
            TiebaUpdateService.this.mDowndMainApkTask = null;
            try {
                if (bool.booleanValue()) {
                    TiebaUpdateService.this.mIsMainApkDone = true;
                    TiebaUpdateService.this.mMainApkHandler.sendMessageDelayed(TiebaUpdateService.this.mMainApkHandler.obtainMessage(1, TiebaUpdateService.this.mMainApkFileName), 300L);
                    return;
                }
                TiebaUpdateService.this.downloadError();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20431a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f20432b;

        public c() {
            this.f20431a = null;
            this.f20432b = false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            TiebaUpdateService.this.mDowndOtherApkTask = null;
            this.f20432b = true;
            NetWork netWork = this.f20431a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            if (TiebaUpdateService.this.mHasTieba || TiebaUpdateService.this.mHasAs) {
                return;
            }
            boolean unused = TiebaUpdateService.sHasStart = false;
            TiebaUpdateService.this.stopSelf();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            Boolean bool = Boolean.FALSE;
            while (true) {
                try {
                    if (!this.f20432b) {
                        NetWork netWork = new NetWork(TiebaUpdateService.this.mOtherApkUrl);
                        this.f20431a = netWork;
                        bool = Boolean.valueOf(netWork.downloadFile(TiebaUpdateService.this.mOtherApkFileName + ".tmp", TiebaUpdateService.this.mOtherApkHandler, 0));
                        if (bool.booleanValue() || this.f20431a.getServerErrorCode() == -2) {
                            break;
                        }
                        if (!this.f20431a.getNetContext().getResponse().isFileSegSuccess()) {
                            try {
                                Thread.sleep(10000L);
                            } catch (Exception unused) {
                            }
                        }
                        if (TiebaUpdateService.sHasStart && System.currentTimeMillis() - TiebaUpdateService.this.mOtherTaskWaitingTimestamp > 20000) {
                            if ((TiebaUpdateService.this.mHasTieba || TiebaUpdateService.this.mHasAs) && TiebaUpdateService.this.mIsMainApkDone) {
                                TiebaUpdateService.this.downloadError();
                            }
                        }
                    } else {
                        break;
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            if (bool.booleanValue()) {
                if (!k.a(TiebaUpdateService.this.mOtherApkMd5RSA, FileHelper.GetFile(TiebaUpdateService.this.mOtherApkFileName + ".tmp"))) {
                    bool = Boolean.FALSE;
                    FileHelper.DelFile(TiebaUpdateService.this.mOtherApkFileName + ".tmp");
                    FileHelper.DelFile(TiebaUpdateService.this.mOtherApkFileName);
                }
                TiebaUpdateService.this.renameFile(TiebaUpdateService.this.mOtherApkFileName);
            }
            return bool;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((c) bool);
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
            if (bool.booleanValue()) {
                return;
            }
            TiebaUpdateService.this.downloadError();
        }
    }

    /* loaded from: classes5.dex */
    public class d extends Handler {
        public d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 3) {
                        l.L(TbadkCoreApplication.getInst(), R.string.update_app_error);
                    }
                } else if (TiebaUpdateService.this.mMainApkInstallEnable) {
                    if (TiebaUpdateService.this.mHasAs) {
                        TiebaUpdateService.this.startAsInstallService();
                    }
                    UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), TiebaUpdateService.this.mMainApkFileName);
                    TiebaUpdateService.this.finishDownload();
                } else {
                    TiebaUpdateService.this.mMainApkInstallEnable = true;
                }
            } else if (message.arg2 > 0) {
                TiebaUpdateService.this.mMainApkCurSize = message.arg1;
                TiebaUpdateService.this.mMainApkSize = message.arg2;
                if (TiebaUpdateService.this.mMainApkSize > TiebaUpdateService.this.mMainApkCurSize) {
                    TiebaUpdateService.this.mMainTaskWaitingTimestamp = System.currentTimeMillis();
                }
                if (TiebaUpdateService.this.mMainApkSize <= TiebaUpdateService.this.mMainApkCurSize) {
                    TiebaUpdateService.this.mIsMainApkDone = true;
                }
                int i3 = (int) ((TiebaUpdateService.this.mMainApkCurSize * 100) / TiebaUpdateService.this.mMainApkSize);
                if (!TiebaUpdateService.this.mHasOther || TiebaUpdateService.this.mOtherApkSize == 0) {
                    if (!TiebaUpdateService.this.mHasOther || TiebaUpdateService.this.mOtherApkSize != 0) {
                        if (TiebaUpdateService.this.mHasOther) {
                            return;
                        }
                        TiebaUpdateService tiebaUpdateService = TiebaUpdateService.this;
                        tiebaUpdateService.updateProgress(tiebaUpdateService.mMainApkCurSize, TiebaUpdateService.this.mMainApkSize);
                        TiebaUpdateService.this.sendBroadcast(i3);
                        return;
                    }
                    if (i3 < 60) {
                        TiebaUpdateService tiebaUpdateService2 = TiebaUpdateService.this;
                        tiebaUpdateService2.updateProgress(tiebaUpdateService2.mMainApkCurSize, TiebaUpdateService.this.mMainApkSize);
                        TiebaUpdateService.this.sendBroadcast(i3);
                    }
                    TiebaUpdateService.this.mProgressBefore = i3;
                    return;
                }
                TiebaUpdateService tiebaUpdateService3 = TiebaUpdateService.this;
                tiebaUpdateService3.mProgressAfter = (int) (((tiebaUpdateService3.mMainApkCurSize + TiebaUpdateService.this.mOtherApkCurSize) * 100) / (TiebaUpdateService.this.mMainApkSize + TiebaUpdateService.this.mOtherApkSize));
                if (TiebaUpdateService.this.mProgressAfter > TiebaUpdateService.this.mProgressBefore) {
                    TiebaUpdateService tiebaUpdateService4 = TiebaUpdateService.this;
                    tiebaUpdateService4.updateProgress(tiebaUpdateService4.mMainApkCurSize + TiebaUpdateService.this.mOtherApkCurSize, TiebaUpdateService.this.mMainApkSize + TiebaUpdateService.this.mOtherApkSize);
                    TiebaUpdateService tiebaUpdateService5 = TiebaUpdateService.this;
                    tiebaUpdateService5.sendBroadcast(tiebaUpdateService5.mProgressAfter);
                    TiebaUpdateService tiebaUpdateService6 = TiebaUpdateService.this;
                    tiebaUpdateService6.mProgressBefore = tiebaUpdateService6.mProgressAfter;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 == 2) {
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
            } else if (message.arg2 > 0) {
                TiebaUpdateService.this.mOtherApkCurSize = message.arg1;
                TiebaUpdateService.this.mOtherApkSize = message.arg2;
                if (TiebaUpdateService.this.mOtherApkSize > TiebaUpdateService.this.mOtherApkCurSize) {
                    TiebaUpdateService.this.mOtherTaskWaitingTimestamp = System.currentTimeMillis();
                }
                TiebaUpdateService tiebaUpdateService = TiebaUpdateService.this;
                tiebaUpdateService.mProgressAfter = (int) (((tiebaUpdateService.mMainApkCurSize + TiebaUpdateService.this.mOtherApkCurSize) * 100) / (TiebaUpdateService.this.mMainApkSize + TiebaUpdateService.this.mOtherApkSize));
                if (TiebaUpdateService.this.mHasOther) {
                    if ((TiebaUpdateService.this.mHasTieba || TiebaUpdateService.this.mHasAs) && TiebaUpdateService.this.mMainApkSize == TiebaUpdateService.this.mMainApkCurSize && TiebaUpdateService.this.mProgressAfter > TiebaUpdateService.this.mProgressBefore) {
                        TiebaUpdateService tiebaUpdateService2 = TiebaUpdateService.this;
                        tiebaUpdateService2.updateProgress(tiebaUpdateService2.mMainApkCurSize + TiebaUpdateService.this.mOtherApkCurSize, TiebaUpdateService.this.mMainApkSize + TiebaUpdateService.this.mOtherApkSize);
                        TiebaUpdateService tiebaUpdateService3 = TiebaUpdateService.this;
                        tiebaUpdateService3.sendBroadcast(tiebaUpdateService3.mProgressAfter);
                        TiebaUpdateService tiebaUpdateService4 = TiebaUpdateService.this;
                        tiebaUpdateService4.mProgressBefore = tiebaUpdateService4.mProgressAfter;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadError() {
        Handler handler = this.mMainApkHandler;
        handler.sendMessage(handler.obtainMessage(3));
        NotificationHelper.cancelNotification(this, 10);
        sHasStart = false;
        stopSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void downloadMainApk(String str) {
        boolean z;
        File GetFile;
        PackageInfo packageArchiveInfo;
        String fileDireciory = FileHelper.getFileDireciory(this.mMainApkFileName);
        if (fileDireciory != null && (packageArchiveInfo = getPackageManager().getPackageArchiveInfo(fileDireciory, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                GetFile = FileHelper.GetFile(this.mMainApkFileName);
                if (this.mHasAs ? !(GetFile != null && GetFile.exists() && z) : GetFile == null || !GetFile.exists()) {
                    Handler handler = this.mMainApkHandler;
                    handler.sendMessageDelayed(handler.obtainMessage(1, null), 300L);
                    return;
                }
                l.L(this, R.string.download_begin_tip);
                if (GetFile != null) {
                    GetFile.delete();
                }
                if (this.mDowndMainApkTask == null) {
                    b bVar = new b();
                    this.mDowndMainApkTask = bVar;
                    bVar.execute(new String[0]);
                    this.info = str;
                    NotificationHelper.showProgressNotification(this, 10, null, 0, null, str, true);
                    return;
                }
                return;
            }
        }
        z = false;
        GetFile = FileHelper.GetFile(this.mMainApkFileName);
        if (this.mHasAs ? !(GetFile != null && GetFile.exists() && z) : GetFile == null || !GetFile.exists()) {
        }
    }

    private void downloadOtherApk() {
        if (FileHelper.GetFile(this.mOtherApkFileName) != null) {
            this.mHasOther = false;
            Handler handler = this.mOtherApkHandler;
            handler.sendMessageDelayed(handler.obtainMessage(2, null), 300L);
        } else if (this.mDowndOtherApkTask == null) {
            this.mHasOther = true;
            c cVar = new c();
            this.mDowndOtherApkTask = cVar;
            cVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishDownload() {
        sendBroadcast("action_update_complete", true);
        NotificationHelper.cancelNotification(this, 10);
        String str = this.mOtherApkFileName;
        if (str != null && str.length() > 4) {
            TbadkCoreApplication.getInst().setInstallOtherApp(this.mOtherApkFileName);
        }
        stopSelf();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void renameFile(String str) {
        File FileObject;
        FileHelper.DelFile(str);
        File GetFile = FileHelper.GetFile(str + ".tmp");
        if (GetFile == null || (FileObject = FileHelper.FileObject(str)) == null || GetFile.renameTo(FileObject)) {
            return;
        }
        TiebaStatic.file("renameTo erro", "TiebaUpdateService.DownLoadingOtherAsyncTask");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAsInstallService() {
        Intent intent = new Intent();
        intent.setClass(this, AsInstallService.class);
        VersionData versionData = this.mVersionData;
        if (versionData != null) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, versionData);
            startService(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(long j, long j2) {
        if (j2 <= 0) {
            return;
        }
        int i2 = (int) ((100 * j) / j2);
        StringBuffer stringBuffer = new StringBuffer(20);
        stringBuffer.append(String.valueOf(j / 1000));
        stringBuffer.append("K/");
        stringBuffer.append(String.valueOf(j2 / 1000));
        stringBuffer.append("K");
        NotificationHelper.showProgressNotification(this, 10, null, i2, i2 + "%", this.info, true);
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
        b bVar = this.mDowndMainApkTask;
        if (bVar != null) {
            bVar.cancel();
        }
        c cVar = this.mDowndOtherApkTask;
        if (cVar != null) {
            cVar.cancel();
        }
        NotificationHelper.cancelNotification(this, 10);
        sHasStart = false;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        String string;
        if (intent == null) {
            return;
        }
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
                String stringExtra = intent.getStringExtra(UpdateDialogConfig.KEY_AS_APK_URL);
                this.mMainApkUrl = stringExtra;
                if (URLUtil.isNetworkUrl(stringExtra) && !TextUtils.isEmpty(this.mMainApkMd5RSA)) {
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
                stopSelf(i2);
            } else if (!this.mHasTieba && !this.mHasAs) {
                this.info = getString(R.string.downloading);
                downloadOtherApk();
            } else {
                if (this.mHasTieba) {
                    string = getString(R.string.tieba_downloading);
                } else {
                    string = getString(R.string.as_downloading);
                }
                downloadMainApk(string);
                if (this.mHasOther) {
                    downloadOtherApk();
                }
            }
        }
    }

    public void sendBroadcast(int i2) {
        Intent intent = new Intent();
        intent.setAction(TbConfig.APP_UPDATE_ACTION);
        intent.putExtra("action_update_download_progress", i2);
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
}
