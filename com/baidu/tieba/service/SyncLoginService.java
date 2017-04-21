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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.aj;
/* loaded from: classes.dex */
public class SyncLoginService extends BdBaseService {
    private static String mStatistics = null;
    private a mSyncTask = null;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new d(this);

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
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.model.f> {
        z mNetWork;

        private a() {
            this.mNetWork = null;
        }

        /* synthetic */ a(SyncLoginService syncLoginService, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public com.baidu.tieba.model.f doInBackground(String... strArr) {
            com.baidu.tieba.model.f fVar;
            Exception e;
            try {
                this.mNetWork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/switch");
                this.mNetWork.n("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(k.af(TbadkCoreApplication.m9getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(k.ag(TbadkCoreApplication.m9getInst().getApp())));
                this.mNetWork.n("_phone_screen", stringBuffer.toString());
                this.mNetWork.n("scr_w", String.valueOf(k.af(TbadkCoreApplication.m9getInst().getApp())));
                this.mNetWork.n("scr_h", String.valueOf(k.ag(TbadkCoreApplication.m9getInst().getApp())));
                this.mNetWork.n("scr_dip", String.valueOf(k.ah(TbadkCoreApplication.m9getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.zG().zJ() > 0) {
                    this.mNetWork.n("_msg_status", "0");
                } else {
                    this.mNetWork.n("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.m9getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.mNetWork.n("_active", activeVersion);
                }
                this.mNetWork.n("_pic_quality", String.valueOf(TbadkCoreApplication.m9getInst().getViewImageQuality()));
                if (SyncLoginService.mStatistics != null) {
                    this.mNetWork.n("_msg_type", SyncLoginService.mStatistics);
                }
                String packageName = TbadkCoreApplication.m9getInst().getPackageName();
                this.mNetWork.n("package", packageName);
                this.mNetWork.n("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m9getInst().getVersionCode())).toString());
                this.mNetWork.n("signmd5", aw.d(TbadkCoreApplication.m9getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.mNetWork.n("md5", aj.getTiebaApkMd5());
                String uY = this.mNetWork.uY();
                if (this.mNetWork.vw().wq().isRequestSuccess()) {
                    fVar = new com.baidu.tieba.model.f();
                    try {
                        fVar.parserJson(uY);
                        SyncLoginService.mStatistics = null;
                        return fVar;
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        return fVar;
                    }
                }
                return null;
            } catch (Exception e3) {
                fVar = null;
                e = e3;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            SyncLoginService.this.mSyncTask = null;
            if (this.mNetWork != null) {
                this.mNetWork.fs();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.model.f fVar) {
            super.onPostExecute(fVar);
            SyncLoginService.this.mSyncTask = null;
        }
    }
}
