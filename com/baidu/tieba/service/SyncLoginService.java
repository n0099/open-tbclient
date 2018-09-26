package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.h;
import com.baidu.tieba.model.c;
/* loaded from: classes.dex */
public class SyncLoginService extends BdBaseService {
    private static String mStatistics = null;
    private a mSyncTask = null;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.service.SyncLoginService.1
        @Override // java.lang.Runnable
        public void run() {
            SyncLoginService.this.checkPassV6Switch();
        }
    };

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
        this.mSyncTask = new a();
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
    public class a extends BdAsyncTask<String, Integer, c> {
        x mNetWork;

        private a() {
            this.mNetWork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public c doInBackground(String... strArr) {
            c cVar;
            Exception e;
            try {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + "c/s/switch");
                this.mNetWork.u("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.aO(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.aQ(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.u("_phone_screen", stringBuffer.toString());
                this.mNetWork.u("scr_w", String.valueOf(l.aO(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.u("scr_h", String.valueOf(l.aQ(TbadkCoreApplication.getInst().getApp())));
                this.mNetWork.u("scr_dip", String.valueOf(l.aR(TbadkCoreApplication.getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fi() > 0) {
                    this.mNetWork.u("_msg_status", "0");
                } else {
                    this.mNetWork.u("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.mNetWork.u("_active", activeVersion);
                }
                this.mNetWork.u("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (SyncLoginService.mStatistics != null) {
                    this.mNetWork.u("_msg_type", SyncLoginService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.mNetWork.u("package", packageName);
                this.mNetWork.u("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.mNetWork.u("signmd5", ar.f(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.mNetWork.u(ARResourceKey.HTTP_AR_MD5, h.getTiebaApkMd5());
                String zt = this.mNetWork.zt();
                if (this.mNetWork.zR().AQ().isRequestSuccess()) {
                    cVar = new c();
                    try {
                        cVar.parserJson(zt);
                        String unused = SyncLoginService.mStatistics = null;
                        return cVar;
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        return cVar;
                    }
                }
                return null;
            } catch (Exception e3) {
                cVar = null;
                e = e3;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            SyncLoginService.this.mSyncTask = null;
            if (this.mNetWork != null) {
                this.mNetWork.iT();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(c cVar) {
            super.onPostExecute(cVar);
            SyncLoginService.this.mSyncTask = null;
        }
    }
}
