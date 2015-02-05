package com.baidu.tieba.service;

import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Integer, com.baidu.tieba.model.u> {
    ad AO;
    final /* synthetic */ SyncLoginService bOX;

    private k(SyncLoginService syncLoginService) {
        this.bOX = syncLoginService;
        this.AO = null;
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
            this.AO = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/switch");
            this.AO.o("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst().getApp())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getApp())));
            this.AO.o("_phone_screen", stringBuffer.toString());
            this.AO.o("scr_w", String.valueOf(com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst().getApp())));
            this.AO.o("scr_h", String.valueOf(com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getApp())));
            this.AO.o("scr_dip", String.valueOf(com.baidu.adp.lib.util.l.O(TbadkCoreApplication.m255getInst().getApp())));
            if (TbadkCoreApplication.m255getInst().getMsgFrequency() > 0) {
                this.AO.o("_msg_status", "0");
            } else {
                this.AO.o("_msg_status", "1");
            }
            String activeVersion = TbadkCoreApplication.m255getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                this.AO.o("_active", activeVersion);
            }
            this.AO.o("_pic_quality", String.valueOf(TbadkCoreApplication.m255getInst().getViewImageQuality()));
            str = SyncLoginService.mStatistics;
            if (str != null) {
                ad adVar = this.AO;
                str2 = SyncLoginService.mStatistics;
                adVar.o("_msg_type", str2);
            }
            String packageName = TbadkCoreApplication.m255getInst().getPackageName();
            this.AO.o("package", packageName);
            this.AO.o("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m255getInst().getVersionCode())).toString());
            this.AO.o("signmd5", bh.d(TbadkCoreApplication.m255getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.AO.o("md5", be.getTiebaApkMd5());
            String or = this.AO.or();
            if (this.AO.oS().qa().lT()) {
                uVar = new com.baidu.tieba.model.u();
                try {
                    uVar.parserJson(or);
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
        this.bOX.mSyncTask = null;
        if (this.AO != null) {
            this.AO.dJ();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.model.u uVar) {
        super.onPostExecute(uVar);
        this.bOX.mSyncTask = null;
    }
}
