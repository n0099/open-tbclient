package com.baidu.tieba.service;

import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, com.baidu.tieba.a.j> {
    aa OE;
    final /* synthetic */ SyncLoginService cdB;

    private h(SyncLoginService syncLoginService) {
        this.cdB = syncLoginService;
        this.OE = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(SyncLoginService syncLoginService, h hVar) {
        this(syncLoginService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: x */
    public com.baidu.tieba.a.j doInBackground(String... strArr) {
        com.baidu.tieba.a.j jVar;
        Exception e;
        String str;
        String str2;
        try {
            this.OE = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/switch");
            this.OE.o("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst().getApp())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getApp())));
            this.OE.o("_phone_screen", stringBuffer.toString());
            this.OE.o("scr_w", String.valueOf(com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst().getApp())));
            this.OE.o("scr_h", String.valueOf(com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getApp())));
            this.OE.o("scr_dip", String.valueOf(com.baidu.adp.lib.util.n.O(TbadkCoreApplication.m411getInst().getApp())));
            if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wj() > 0) {
                this.OE.o("_msg_status", GameInfoData.NOT_FROM_DETAIL);
            } else {
                this.OE.o("_msg_status", "1");
            }
            String activeVersion = TbadkCoreApplication.m411getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = GameInfoData.NOT_FROM_DETAIL;
                }
                this.OE.o("_active", activeVersion);
            }
            this.OE.o("_pic_quality", String.valueOf(TbadkCoreApplication.m411getInst().getViewImageQuality()));
            str = SyncLoginService.mStatistics;
            if (str != null) {
                aa aaVar = this.OE;
                str2 = SyncLoginService.mStatistics;
                aaVar.o("_msg_type", str2);
            }
            String packageName = TbadkCoreApplication.m411getInst().getPackageName();
            this.OE.o("package", packageName);
            this.OE.o("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m411getInst().getVersionCode())).toString());
            this.OE.o("signmd5", bd.d(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.OE.o("md5", aj.getTiebaApkMd5());
            String sw = this.OE.sw();
            if (this.OE.sX().tT().qa()) {
                jVar = new com.baidu.tieba.a.j();
                try {
                    jVar.parserJson(sw);
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
        this.cdB.mSyncTask = null;
        if (this.OE != null) {
            this.OE.gS();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.j jVar) {
        super.onPostExecute(jVar);
        this.cdB.mSyncTask = null;
    }
}
