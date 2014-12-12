package com.baidu.tieba.service;

import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Integer, com.baidu.tieba.model.u> {
    ad AR;
    final /* synthetic */ SyncLoginService bNo;

    private k(SyncLoginService syncLoginService) {
        this.bNo = syncLoginService;
        this.AR = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(SyncLoginService syncLoginService, k kVar) {
        this(syncLoginService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: z */
    public com.baidu.tieba.model.u doInBackground(String... strArr) {
        com.baidu.tieba.model.u uVar;
        Exception e;
        String str;
        String str2;
        try {
            this.AR = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/switch");
            this.AR.o("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst().getApp())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getApp())));
            this.AR.o("_phone_screen", stringBuffer.toString());
            this.AR.o("scr_w", String.valueOf(com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst().getApp())));
            this.AR.o("scr_h", String.valueOf(com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getApp())));
            this.AR.o("scr_dip", String.valueOf(com.baidu.adp.lib.util.l.O(TbadkCoreApplication.m255getInst().getApp())));
            if (TbadkCoreApplication.m255getInst().getMsgFrequency() > 0) {
                this.AR.o("_msg_status", "0");
            } else {
                this.AR.o("_msg_status", "1");
            }
            String activeVersion = TbadkCoreApplication.m255getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                this.AR.o("_active", activeVersion);
            }
            this.AR.o("_pic_quality", String.valueOf(TbadkCoreApplication.m255getInst().getViewImageQuality()));
            str = SyncLoginService.mStatistics;
            if (str != null) {
                ad adVar = this.AR;
                str2 = SyncLoginService.mStatistics;
                adVar.o("_msg_type", str2);
            }
            String packageName = TbadkCoreApplication.m255getInst().getPackageName();
            this.AR.o("package", packageName);
            this.AR.o("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m255getInst().getVersionCode())).toString());
            this.AR.o("signmd5", bc.d(TbadkCoreApplication.m255getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.AR.o("md5", bb.getTiebaApkMd5());
            String ov = this.AR.ov();
            if (this.AR.oW().pW().ma()) {
                uVar = new com.baidu.tieba.model.u();
                try {
                    uVar.parserJson(ov);
                    SyncLoginService.mStatistics = null;
                    return uVar;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    return uVar;
                }
            }
            return null;
        } catch (Exception e3) {
            uVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bNo.mSyncTask = null;
        if (this.AR != null) {
            this.AR.dL();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.model.u uVar) {
        super.onPostExecute(uVar);
        this.bNo.mSyncTask = null;
    }
}
