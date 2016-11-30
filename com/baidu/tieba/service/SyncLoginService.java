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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.af;
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
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.model.g> {
        z Ob;

        private a() {
            this.Ob = null;
        }

        /* synthetic */ a(SyncLoginService syncLoginService, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.model.g doInBackground(String... strArr) {
            com.baidu.tieba.model.g gVar;
            Exception e;
            try {
                this.Ob = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/switch");
                this.Ob.n("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.K(TbadkCoreApplication.m9getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.L(TbadkCoreApplication.m9getInst().getApp())));
                this.Ob.n("_phone_screen", stringBuffer.toString());
                this.Ob.n("scr_w", String.valueOf(k.K(TbadkCoreApplication.m9getInst().getApp())));
                this.Ob.n("scr_h", String.valueOf(k.L(TbadkCoreApplication.m9getInst().getApp())));
                this.Ob.n("scr_dip", String.valueOf(k.M(TbadkCoreApplication.m9getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.zh().zk() > 0) {
                    this.Ob.n("_msg_status", "0");
                } else {
                    this.Ob.n("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.m9getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.Ob.n("_active", activeVersion);
                }
                this.Ob.n("_pic_quality", String.valueOf(TbadkCoreApplication.m9getInst().getViewImageQuality()));
                if (SyncLoginService.mStatistics != null) {
                    this.Ob.n("_msg_type", SyncLoginService.mStatistics);
                }
                String packageName = TbadkCoreApplication.m9getInst().getPackageName();
                this.Ob.n("package", packageName);
                this.Ob.n("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m9getInst().getVersionCode())).toString());
                this.Ob.n("signmd5", az.d(TbadkCoreApplication.m9getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.Ob.n("md5", af.getTiebaApkMd5());
                String uy = this.Ob.uy();
                if (this.Ob.uW().vS().oH()) {
                    gVar = new com.baidu.tieba.model.g();
                    try {
                        gVar.parserJson(uy);
                        SyncLoginService.mStatistics = null;
                        return gVar;
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        return gVar;
                    }
                }
                return null;
            } catch (Exception e3) {
                gVar = null;
                e = e3;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            SyncLoginService.this.mSyncTask = null;
            if (this.Ob != null) {
                this.Ob.eg();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.model.g gVar) {
            super.onPostExecute(gVar);
            SyncLoginService.this.mSyncTask = null;
        }
    }
}
