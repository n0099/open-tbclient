package com.baidu.tieba.service;

import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.ao;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, com.baidu.tieba.a.j> {
    aa Ok;
    final /* synthetic */ SyncLoginService bZp;

    private h(SyncLoginService syncLoginService) {
        this.bZp = syncLoginService;
        this.Ok = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(SyncLoginService syncLoginService, h hVar) {
        this(syncLoginService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: w */
    public com.baidu.tieba.a.j doInBackground(String... strArr) {
        com.baidu.tieba.a.j jVar;
        Exception e;
        String str;
        String str2;
        try {
            this.Ok = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/switch");
            this.Ok.o("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst().getApp())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getApp())));
            this.Ok.o("_phone_screen", stringBuffer.toString());
            this.Ok.o("scr_w", String.valueOf(com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst().getApp())));
            this.Ok.o("scr_h", String.valueOf(com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getApp())));
            this.Ok.o("scr_dip", String.valueOf(com.baidu.adp.lib.util.n.O(TbadkCoreApplication.m411getInst().getApp())));
            if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().vz() > 0) {
                this.Ok.o("_msg_status", GameInfoData.NOT_FROM_DETAIL);
            } else {
                this.Ok.o("_msg_status", "1");
            }
            String activeVersion = TbadkCoreApplication.m411getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = GameInfoData.NOT_FROM_DETAIL;
                }
                this.Ok.o("_active", activeVersion);
            }
            this.Ok.o("_pic_quality", String.valueOf(TbadkCoreApplication.m411getInst().getViewImageQuality()));
            str = SyncLoginService.mStatistics;
            if (str != null) {
                aa aaVar = this.Ok;
                str2 = SyncLoginService.mStatistics;
                aaVar.o("_msg_type", str2);
            }
            String packageName = TbadkCoreApplication.m411getInst().getPackageName();
            this.Ok.o("package", packageName);
            this.Ok.o("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m411getInst().getVersionCode())).toString());
            this.Ok.o("signmd5", bf.d(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.Ok.o("md5", ao.getTiebaApkMd5());
            String rO = this.Ok.rO();
            if (this.Ok.sp().tq().pv()) {
                jVar = new com.baidu.tieba.a.j();
                try {
                    jVar.parserJson(rO);
                    SyncLoginService.mStatistics = null;
                    return jVar;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    return jVar;
                }
            }
            return null;
        } catch (Exception e3) {
            jVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bZp.mSyncTask = null;
        if (this.Ok != null) {
            this.Ok.hh();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.j jVar) {
        super.onPostExecute(jVar);
        this.bZp.mSyncTask = null;
    }
}
