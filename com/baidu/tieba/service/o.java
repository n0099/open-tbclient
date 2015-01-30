package com.baidu.tieba.service;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.be;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.c.g> {
    ad AR;
    final /* synthetic */ TiebaSyncService bPb;

    private o(TiebaSyncService tiebaSyncService) {
        this.bPb = tiebaSyncService;
        this.AR = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(TiebaSyncService tiebaSyncService, o oVar) {
        this(tiebaSyncService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: x */
    public com.baidu.tbadk.coreExtra.c.g doInBackground(String... strArr) {
        com.baidu.tbadk.coreExtra.c.g gVar;
        Exception e;
        String str;
        String str2;
        try {
            this.AR = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
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
            str = TiebaSyncService.mStatistics;
            if (str != null) {
                ad adVar = this.AR;
                str2 = TiebaSyncService.mStatistics;
                adVar.o("_msg_type", str2);
            }
            String packageName = TbadkCoreApplication.m255getInst().getPackageName();
            this.AR.o("package", packageName);
            this.AR.o("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m255getInst().getVersionCode())).toString());
            this.AR.o("signmd5", bh.b(TbadkCoreApplication.m255getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.AR.o("md5", be.getTiebaApkMd5());
            String oy = this.AR.oy();
            if (this.AR.pc()) {
                TbadkCoreApplication.m255getInst().clearActiveVersion();
            }
            if (this.AR.oZ().qh().ma()) {
                gVar = new com.baidu.tbadk.coreExtra.c.g();
                try {
                    gVar.parserJson(oy);
                    if (TbadkCoreApplication.getClientId() == null && gVar.sG().getClientId() != null && gVar.sG().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(this.bPb, gVar.sG().getClientId());
                        TbadkCoreApplication.setClientId(gVar.sG().getClientId());
                    }
                    if (gVar.sC() != null) {
                        com.baidu.tbadk.core.sharedPref.b.oj().putInt("aladin_port", gVar.sC().rL());
                        com.baidu.tbadk.core.sharedPref.b.oj().putInt("crash_limit_count", gVar.sC().rK());
                    }
                    TiebaSyncService.mStatistics = null;
                    return gVar;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.detailException(e);
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
        this.bPb.mSyncTask = null;
        if (this.AR != null) {
            this.AR.dJ();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.coreExtra.c.g gVar) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        com.baidu.tbadk.coreExtra.c.g gVar2;
        com.baidu.tbadk.coreExtra.c.g gVar3;
        com.baidu.tbadk.coreExtra.c.g gVar4;
        int performSampleCount;
        com.baidu.tbadk.coreExtra.c.g gVar5;
        com.baidu.tbadk.coreExtra.c.g gVar6;
        com.baidu.tbadk.coreExtra.c.g gVar7;
        com.baidu.tbadk.coreExtra.c.g gVar8;
        com.baidu.tbadk.coreExtra.c.g gVar9;
        com.baidu.tbadk.coreExtra.c.g gVar10;
        com.baidu.tbadk.coreExtra.c.g gVar11;
        com.baidu.tbadk.coreExtra.c.g gVar12;
        com.baidu.tbadk.coreExtra.c.g gVar13;
        super.onPostExecute(gVar);
        this.bPb.mSyncTask = null;
        if (gVar != null) {
            com.baidu.tbadk.util.a.zH().zI();
            this.bPb.mModel = gVar;
            gVar2 = this.bPb.mModel;
            if (gVar2.sF().hasNewVer()) {
                TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
                gVar5 = this.bPb.mModel;
                m255getInst.setVersionData(gVar5.sF());
                this.bPb.broadcastNewVersion();
                gVar6 = this.bPb.mModel;
                if (gVar6.sF().forceUpdate()) {
                    gVar11 = this.bPb.mModel;
                    if (gVar11.sC() != null && TbadkCoreApplication.m255getInst().getResumeNum() > 0) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Application app = TbadkCoreApplication.m255getInst().getApp();
                        gVar12 = this.bPb.mModel;
                        VersionData sF = gVar12.sF();
                        gVar13 = this.bPb.mModel;
                        messageManager.sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(app, sF, gVar13.sE())));
                    }
                } else if (Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(TbadkCoreApplication.m255getInst().getUpdateNotifyTime()).longValue() > 86400000) {
                    gVar7 = this.bPb.mModel;
                    if (gVar7.sF().getStrategy() == 0) {
                        gVar8 = this.bPb.mModel;
                        if (gVar8.sC() != null && TbadkCoreApplication.m255getInst().getResumeNum() > 0) {
                            MessageManager messageManager2 = MessageManager.getInstance();
                            Application app2 = TbadkCoreApplication.m255getInst().getApp();
                            gVar9 = this.bPb.mModel;
                            VersionData sF2 = gVar9.sF();
                            gVar10 = this.bPb.mModel;
                            messageManager2.sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(app2, sF2, gVar10.sE())));
                        }
                    }
                }
            }
            TbadkCoreApplication.m255getInst().loadLcsSwitchStratgy();
            int nextInt = new Random().nextInt(TbConfig.BIG_IMAGE_MIN_CAPACITY) + 1;
            int rJ = gVar.sC().rJ();
            if (rJ > 0 && nextInt % rJ == 0 && (performSampleCount = TbadkCoreApplication.m255getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.m255getInst().setPerformSampleCount(performSampleCount + 1);
            }
            gVar3 = this.bPb.mModel;
            String sD = gVar3.sD();
            if (!StringUtils.isNull(sD)) {
                TbadkCoreApplication.m255getInst().setConfigVersion(sD);
            }
            this.bPb.stopSelf();
            gVar4 = this.bPb.mModel;
            com.baidu.tbadk.coreExtra.data.k sH = gVar4.sH();
            if (sH != null) {
                av.pv().j(sH.rS(), sH.rT(), sH.rU());
                return;
            }
            return;
        }
        TiebaSyncService tiebaSyncService = this.bPb;
        i = tiebaSyncService.mHaveRetry;
        tiebaSyncService.mHaveRetry = i + 1;
        i2 = this.bPb.mHaveRetry;
        if (i2 < 10) {
            handler = this.bPb.mHandler;
            runnable = this.bPb.mRunnable;
            handler.removeCallbacks(runnable);
            handler2 = this.bPb.mHandler;
            runnable2 = this.bPb.mRunnable;
            handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
            return;
        }
        this.bPb.stopSelf();
    }
}
