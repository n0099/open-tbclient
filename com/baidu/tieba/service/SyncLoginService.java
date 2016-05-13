package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.ag;
/* loaded from: classes.dex */
public class SyncLoginService extends BdBaseService {
    private static String mStatistics = null;
    private a mSyncTask = null;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new e(this);

    public static void setMsgType(String str) {
        mStatistics = str;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPassV6Switch() {
        if (this.mSyncTask != null) {
            this.mSyncTask.cancel();
        }
        this.mSyncTask = new a(this, null);
        this.mSyncTask.execute(new String[0]);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.mSyncTask != null) {
            this.mSyncTask.cancel();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        checkPassV6Switch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.model.e> {
        ab LL;

        private a() {
            this.LL = null;
        }

        /* synthetic */ a(SyncLoginService syncLoginService, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.model.e doInBackground(String... strArr) {
            com.baidu.tieba.model.e eVar;
            Exception e;
            try {
                this.LL = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/switch");
                this.LL.n("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.B(TbadkCoreApplication.m11getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.C(TbadkCoreApplication.m11getInst().getApp())));
                this.LL.n("_phone_screen", stringBuffer.toString());
                this.LL.n("scr_w", String.valueOf(k.B(TbadkCoreApplication.m11getInst().getApp())));
                this.LL.n("scr_h", String.valueOf(k.C(TbadkCoreApplication.m11getInst().getApp())));
                this.LL.n("scr_dip", String.valueOf(k.D(TbadkCoreApplication.m11getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xG().xJ() > 0) {
                    this.LL.n("_msg_status", "0");
                } else {
                    this.LL.n("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.m11getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.LL.n("_active", activeVersion);
                }
                this.LL.n("_pic_quality", String.valueOf(TbadkCoreApplication.m11getInst().getViewImageQuality()));
                if (SyncLoginService.mStatistics != null) {
                    this.LL.n("_msg_type", SyncLoginService.mStatistics);
                }
                String packageName = TbadkCoreApplication.m11getInst().getPackageName();
                this.LL.n("package", packageName);
                this.LL.n("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m11getInst().getVersionCode())).toString());
                this.LL.n("signmd5", ba.c(TbadkCoreApplication.m11getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.LL.n("md5", ag.getTiebaApkMd5());
                String td = this.LL.td();
                if (this.LL.tB().uw().nZ()) {
                    eVar = new com.baidu.tieba.model.e();
                    try {
                        eVar.parserJson(td);
                        SyncLoginService.mStatistics = null;
                        return eVar;
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        return eVar;
                    }
                }
                return null;
            } catch (Exception e3) {
                eVar = null;
                e = e3;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            SyncLoginService.this.mSyncTask = null;
            if (this.LL != null) {
                this.LL.dl();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.model.e eVar) {
            super.onPostExecute(eVar);
            SyncLoginService.this.mSyncTask = null;
        }
    }
}
