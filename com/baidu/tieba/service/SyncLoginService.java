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
        ab QV;

        private a() {
            this.QV = null;
        }

        /* synthetic */ a(SyncLoginService syncLoginService, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public com.baidu.tieba.model.e doInBackground(String... strArr) {
            com.baidu.tieba.model.e eVar;
            Exception e;
            try {
                this.QV = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/switch");
                this.QV.p("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.B(TbadkCoreApplication.m411getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.C(TbadkCoreApplication.m411getInst().getApp())));
                this.QV.p("_phone_screen", stringBuffer.toString());
                this.QV.p("scr_w", String.valueOf(k.B(TbadkCoreApplication.m411getInst().getApp())));
                this.QV.p("scr_h", String.valueOf(k.C(TbadkCoreApplication.m411getInst().getApp())));
                this.QV.p("scr_dip", String.valueOf(k.D(TbadkCoreApplication.m411getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().zP() > 0) {
                    this.QV.p("_msg_status", "0");
                } else {
                    this.QV.p("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.m411getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.QV.p("_active", activeVersion);
                }
                this.QV.p("_pic_quality", String.valueOf(TbadkCoreApplication.m411getInst().getViewImageQuality()));
                if (SyncLoginService.mStatistics != null) {
                    this.QV.p("_msg_type", SyncLoginService.mStatistics);
                }
                String packageName = TbadkCoreApplication.m411getInst().getPackageName();
                this.QV.p("package", packageName);
                this.QV.p("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m411getInst().getVersionCode())).toString());
                this.QV.p("signmd5", ba.c(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.QV.p("md5", ag.getTiebaApkMd5());
                String vw = this.QV.vw();
                if (this.QV.vU().wP().qC()) {
                    eVar = new com.baidu.tieba.model.e();
                    try {
                        eVar.parserJson(vw);
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
            if (this.QV != null) {
                this.QV.gX();
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
