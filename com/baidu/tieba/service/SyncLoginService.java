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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.messageCenter.d;
import com.baidu.tieba.f;
import com.baidu.tieba.model.c;
import com.xiaomi.mipush.sdk.Constants;
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
        x bVP;

        private a() {
            this.bVP = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public c doInBackground(String... strArr) {
            c cVar;
            Exception e;
            try {
                this.bVP = new x(TbConfig.SERVER_ADDRESS + Config.SYNC_LOGIN);
                this.bVP.addPostData("_os_version", Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                this.bVP.addPostData("_phone_screen", stringBuffer.toString());
                this.bVP.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                this.bVP.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                this.bVP.addPostData("scr_dip", String.valueOf(l.getEquipmentDensity(TbadkCoreApplication.getInst().getApp())));
                if (d.ara().ard() > 0) {
                    this.bVP.addPostData("_msg_status", "0");
                } else {
                    this.bVP.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() < 1) {
                        activeVersion = "0";
                    }
                    this.bVP.addPostData("_active", activeVersion);
                }
                this.bVP.addPostData("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
                if (SyncLoginService.mStatistics != null) {
                    this.bVP.addPostData("_msg_type", SyncLoginService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.bVP.addPostData("package", packageName);
                this.bVP.addPostData("versioncode", TbadkCoreApplication.getInst().getVersionCode() + "");
                this.bVP.addPostData("signmd5", as.getAPKMd5(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.bVP.addPostData("md5", f.getTiebaApkMd5());
                String postNetData = this.bVP.postNetData();
                if (this.bVP.amr().amS().isRequestSuccess()) {
                    cVar = new c();
                    try {
                        cVar.parserJson(postNetData);
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
            if (this.bVP != null) {
                this.bVP.cancelNetConnect();
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
