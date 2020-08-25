package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.g;
import com.baidu.tieba.model.d;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
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
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, d> {
        aa bDY;

        private a() {
            this.bDY = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: N */
        public d doInBackground(String... strArr) {
            d dVar;
            Exception e;
            try {
                this.bDY = new aa(TbConfig.SERVER_ADDRESS + Config.SYNC_LOGIN);
                this.bDY.addPostData("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                this.bDY.addPostData("_phone_screen", stringBuffer.toString());
                this.bDY.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                this.bDY.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                this.bDY.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(TbadkCoreApplication.getInst().getApp())));
                if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boB() > 0) {
                    this.bDY.addPostData("_msg_status", "0");
                } else {
                    this.bDY.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.bDY.addPostData("_active", activeVersion);
                }
                this.bDY.addPostData("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (SyncLoginService.mStatistics != null) {
                    this.bDY.addPostData("_msg_type", SyncLoginService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.bDY.addPostData("package", packageName);
                this.bDY.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.bDY.addPostData("signmd5", av.getAPKMd5(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.bDY.addPostData("md5", g.getTiebaApkMd5());
                String postNetData = this.bDY.postNetData();
                if (this.bDY.biQ().bjw().isRequestSuccess()) {
                    dVar = new d();
                    try {
                        dVar.parserJson(postNetData);
                        String unused = SyncLoginService.mStatistics = null;
                        return dVar;
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        return dVar;
                    }
                }
                return null;
            } catch (Exception e3) {
                dVar = null;
                e = e3;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            SyncLoginService.this.mSyncTask = null;
            if (this.bDY != null) {
                this.bDY.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(d dVar) {
            super.onPostExecute(dVar);
            SyncLoginService.this.mSyncTask = null;
        }
    }
}
