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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.ao;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.c.g> {
    aa Oi;
    final /* synthetic */ TiebaSyncService bZd;

    private l(TiebaSyncService tiebaSyncService) {
        this.bZd = tiebaSyncService;
        this.Oi = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(TiebaSyncService tiebaSyncService, l lVar) {
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
            this.Oi = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
            this.Oi.o("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst().getApp())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getApp())));
            this.Oi.o("_phone_screen", stringBuffer.toString());
            this.Oi.o("scr_w", String.valueOf(com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst().getApp())));
            this.Oi.o("scr_h", String.valueOf(com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getApp())));
            this.Oi.o("scr_dip", String.valueOf(com.baidu.adp.lib.util.n.O(TbadkCoreApplication.m411getInst().getApp())));
            if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vt() > 0) {
                this.Oi.o("_msg_status", GameInfoData.NOT_FROM_DETAIL);
            } else {
                this.Oi.o("_msg_status", "1");
            }
            String activeVersion = TbadkCoreApplication.m411getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = GameInfoData.NOT_FROM_DETAIL;
                }
                this.Oi.o("_active", activeVersion);
            }
            this.Oi.o("_pic_quality", String.valueOf(TbadkCoreApplication.m411getInst().getViewImageQuality()));
            str = TiebaSyncService.mStatistics;
            if (str != null) {
                aa aaVar = this.Oi;
                str2 = TiebaSyncService.mStatistics;
                aaVar.o("_msg_type", str2);
            }
            String packageName = TbadkCoreApplication.m411getInst().getPackageName();
            this.Oi.o("package", packageName);
            this.Oi.o("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m411getInst().getVersionCode())).toString());
            this.Oi.o("signmd5", bf.b(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.Oi.o("md5", ao.getTiebaApkMd5());
            String rO = this.Oi.rO();
            if (this.Oi.ss()) {
                TbadkCoreApplication.m411getInst().clearActiveVersion();
            }
            if (this.Oi.sp().tq().pv()) {
                gVar = new com.baidu.tbadk.coreExtra.c.g();
                try {
                    gVar.parserJson(rO);
                    if (TbadkCoreApplication.getClientId() == null && gVar.vW().getClientId() != null && gVar.vW().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(this.bZd, gVar.vW().getClientId());
                        TbadkCoreApplication.setClientId(gVar.vW().getClientId());
                    }
                    if (gVar.vS() != null) {
                        com.baidu.tbadk.core.sharedPref.b.rB().putInt("aladin_port", gVar.vS().uB());
                        com.baidu.tbadk.core.sharedPref.b.rB().putInt("crash_limit_count", gVar.vS().getCrashLimitCount());
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
        this.bZd.mSyncTask = null;
        if (this.Oi != null) {
            this.Oi.hh();
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
        com.baidu.tbadk.coreExtra.c.g gVar5;
        com.baidu.tbadk.coreExtra.c.g gVar6;
        com.baidu.tbadk.coreExtra.c.g gVar7;
        int performSampleCount;
        com.baidu.tbadk.coreExtra.c.g gVar8;
        com.baidu.tbadk.coreExtra.c.g gVar9;
        com.baidu.tbadk.coreExtra.c.g gVar10;
        com.baidu.tbadk.coreExtra.c.g gVar11;
        com.baidu.tbadk.coreExtra.c.g gVar12;
        com.baidu.tbadk.coreExtra.c.g gVar13;
        com.baidu.tbadk.coreExtra.c.g gVar14;
        com.baidu.tbadk.coreExtra.c.g gVar15;
        com.baidu.tbadk.coreExtra.c.g gVar16;
        super.onPostExecute(gVar);
        this.bZd.mSyncTask = null;
        if (gVar != null) {
            com.baidu.tbadk.util.a.CV().CW();
            this.bZd.mModel = gVar;
            gVar2 = this.bZd.mModel;
            if (gVar2.vV().hasNewVer()) {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                gVar8 = this.bZd.mModel;
                m411getInst.setVersionData(gVar8.vV());
                this.bZd.broadcastNewVersion();
                gVar9 = this.bZd.mModel;
                if (gVar9.vV().forceUpdate()) {
                    gVar14 = this.bZd.mModel;
                    if (gVar14.vS() != null && TbadkCoreApplication.m411getInst().getResumeNum() > 0) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Application app = TbadkCoreApplication.m411getInst().getApp();
                        gVar15 = this.bZd.mModel;
                        VersionData vV = gVar15.vV();
                        gVar16 = this.bZd.mModel;
                        messageManager.sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(app, vV, gVar16.vU())));
                    }
                } else {
                    Long valueOf = Long.valueOf(TbadkCoreApplication.m411getInst().getUpdateNotifyTime());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if (valueOf2.longValue() - valueOf.longValue() > 86400000) {
                        gVar10 = this.bZd.mModel;
                        if (gVar10.vV().getStrategy() == 0) {
                            gVar11 = this.bZd.mModel;
                            if (gVar11.vS() != null && TbadkCoreApplication.m411getInst().getResumeNum() > 0) {
                                MessageManager messageManager2 = MessageManager.getInstance();
                                Application app2 = TbadkCoreApplication.m411getInst().getApp();
                                gVar12 = this.bZd.mModel;
                                VersionData vV2 = gVar12.vV();
                                gVar13 = this.bZd.mModel;
                                messageManager2.sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(app2, vV2, gVar13.vU())));
                                TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf2.longValue());
                            }
                        }
                    }
                }
            }
            TbadkCoreApplication.m411getInst().loadLcsSwitchStratgy();
            int nextInt = new Random().nextInt(10000) + 1;
            int uA = gVar.vS().uA();
            if (uA > 0 && nextInt % uA == 0 && (performSampleCount = TbadkCoreApplication.m411getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.m411getInst().setPerformSampleCount(performSampleCount + 1);
            }
            gVar3 = this.bZd.mModel;
            String vT = gVar3.vT();
            if (!StringUtils.isNull(vT)) {
                TbadkCoreApplication.m411getInst().setConfigVersion(vT);
            }
            gVar4 = this.bZd.mModel;
            com.baidu.tbadk.coreExtra.data.l vX = gVar4.vX();
            if (vX != null) {
                at.sL().c(vX.uL(), vX.uM(), vX.uN(), vX.uO(), vX.uP());
                String uK = vX.uK();
                com.baidu.tbadk.core.sharedPref.b rB = com.baidu.tbadk.core.sharedPref.b.rB();
                if (uK == null) {
                    uK = "";
                }
                rB.putString("apply_vip_live_room_pid", uK);
            }
            this.bZd.stopSelf();
            gVar5 = this.bZd.mModel;
            if (gVar5.vS() != null) {
                gVar6 = this.bZd.mModel;
                if (gVar6.vS().uC() != null) {
                    TbadkCoreApplication m411getInst2 = TbadkCoreApplication.m411getInst();
                    gVar7 = this.bZd.mModel;
                    m411getInst2.setCheckUrl(gVar7.vS().uC().uH());
                    return;
                }
                return;
            }
            return;
        }
        TiebaSyncService tiebaSyncService = this.bZd;
        i = tiebaSyncService.mHaveRetry;
        tiebaSyncService.mHaveRetry = i + 1;
        i2 = this.bZd.mHaveRetry;
        if (i2 < 10) {
            handler = this.bZd.mHandler;
            runnable = this.bZd.mRunnable;
            handler.removeCallbacks(runnable);
            handler2 = this.bZd.mHandler;
            runnable2 = this.bZd.mRunnable;
            handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
            return;
        }
        this.bZd.stopSelf();
    }
}
