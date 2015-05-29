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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.aj;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.c.g> {
    aa OE;
    final /* synthetic */ TiebaSyncService cdE;

    private l(TiebaSyncService tiebaSyncService) {
        this.cdE = tiebaSyncService;
        this.OE = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(TiebaSyncService tiebaSyncService, l lVar) {
        this(tiebaSyncService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: y */
    public com.baidu.tbadk.coreExtra.c.g doInBackground(String... strArr) {
        com.baidu.tbadk.coreExtra.c.g gVar;
        Exception e;
        String str;
        String str2;
        try {
            this.OE = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
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
            str = TiebaSyncService.mStatistics;
            if (str != null) {
                aa aaVar = this.OE;
                str2 = TiebaSyncService.mStatistics;
                aaVar.o("_msg_type", str2);
            }
            String packageName = TbadkCoreApplication.m411getInst().getPackageName();
            this.OE.o("package", packageName);
            this.OE.o("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m411getInst().getVersionCode())).toString());
            this.OE.o("signmd5", bd.b(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.OE.o("md5", aj.getTiebaApkMd5());
            String sw = this.OE.sw();
            if (this.OE.ta()) {
                TbadkCoreApplication.m411getInst().clearActiveVersion();
            }
            if (this.OE.sX().tT().qa()) {
                gVar = new com.baidu.tbadk.coreExtra.c.g();
                try {
                    gVar.parserJson(sw);
                    if (TbadkCoreApplication.getClientId() == null && gVar.wM().getClientId() != null && gVar.wM().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(this.cdE, gVar.wM().getClientId());
                        TbadkCoreApplication.setClientId(gVar.wM().getClientId());
                    }
                    if (gVar.wI() != null) {
                        com.baidu.tbadk.core.sharedPref.b.sl().putInt("aladin_port", gVar.wI().vk());
                        com.baidu.tbadk.core.sharedPref.b.sl().putInt("crash_limit_count", gVar.wI().getCrashLimitCount());
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
        this.cdE.mSyncTask = null;
        if (this.OE != null) {
            this.OE.gS();
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
        this.cdE.mSyncTask = null;
        if (gVar != null) {
            com.baidu.tbadk.util.a.DP().DQ();
            this.cdE.mModel = gVar;
            gVar2 = this.cdE.mModel;
            if (gVar2.wL().hasNewVer()) {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                gVar8 = this.cdE.mModel;
                m411getInst.setVersionData(gVar8.wL());
                this.cdE.broadcastNewVersion();
                gVar9 = this.cdE.mModel;
                if (gVar9.wL().forceUpdate()) {
                    gVar14 = this.cdE.mModel;
                    if (gVar14.wI() != null && TbadkCoreApplication.m411getInst().getResumeNum() > 0) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Application app = TbadkCoreApplication.m411getInst().getApp();
                        gVar15 = this.cdE.mModel;
                        VersionData wL = gVar15.wL();
                        gVar16 = this.cdE.mModel;
                        messageManager.sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(app, wL, gVar16.wK())));
                    }
                } else {
                    Long valueOf = Long.valueOf(TbadkCoreApplication.m411getInst().getUpdateNotifyTime());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if (valueOf2.longValue() - valueOf.longValue() > 86400000) {
                        gVar10 = this.cdE.mModel;
                        if (gVar10.wL().getStrategy() == 0) {
                            gVar11 = this.cdE.mModel;
                            if (gVar11.wI() != null && TbadkCoreApplication.m411getInst().getResumeNum() > 0) {
                                MessageManager messageManager2 = MessageManager.getInstance();
                                Application app2 = TbadkCoreApplication.m411getInst().getApp();
                                gVar12 = this.cdE.mModel;
                                VersionData wL2 = gVar12.wL();
                                gVar13 = this.cdE.mModel;
                                messageManager2.sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(app2, wL2, gVar13.wK())));
                                TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf2.longValue());
                            }
                        }
                    }
                }
            }
            TbadkCoreApplication.m411getInst().loadLcsSwitchStratgy();
            int nextInt = new Random().nextInt(10000) + 1;
            int vj = gVar.wI().vj();
            if (vj > 0 && nextInt % vj == 0 && (performSampleCount = TbadkCoreApplication.m411getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.m411getInst().setPerformSampleCount(performSampleCount + 1);
            }
            gVar3 = this.cdE.mModel;
            String wJ = gVar3.wJ();
            if (!StringUtils.isNull(wJ)) {
                TbadkCoreApplication.m411getInst().setConfigVersion(wJ);
            }
            gVar4 = this.cdE.mModel;
            com.baidu.tbadk.coreExtra.data.m wN = gVar4.wN();
            if (wN != null) {
                TbadkCoreApplication.m411getInst().getListItemRule().dB(wN.vD());
                TbadkCoreApplication.m411getInst().getListItemRule().dD(wN.vF());
                TbadkCoreApplication.m411getInst().getListItemRule().dC(wN.vE());
                aq.to().c(wN.vy(), wN.vz(), wN.vA(), wN.vB(), wN.vC());
                String vx = wN.vx();
                com.baidu.tbadk.core.sharedPref.b sl = com.baidu.tbadk.core.sharedPref.b.sl();
                if (vx == null) {
                    vx = "";
                }
                sl.putString("apply_vip_live_room_pid", vx);
            }
            this.cdE.stopSelf();
            gVar5 = this.cdE.mModel;
            if (gVar5.wI() != null) {
                gVar6 = this.cdE.mModel;
                if (gVar6.wI().vl() != null) {
                    TbadkCoreApplication m411getInst2 = TbadkCoreApplication.m411getInst();
                    gVar7 = this.cdE.mModel;
                    m411getInst2.setCheckUrl(gVar7.wI().vl().vu());
                    return;
                }
                return;
            }
            return;
        }
        TiebaSyncService tiebaSyncService = this.cdE;
        i = tiebaSyncService.mHaveRetry;
        tiebaSyncService.mHaveRetry = i + 1;
        i2 = this.cdE.mHaveRetry;
        if (i2 < 10) {
            handler = this.cdE.mHandler;
            runnable = this.cdE.mRunnable;
            handler.removeCallbacks(runnable);
            handler2 = this.cdE.mHandler;
            runnable2 = this.cdE.mRunnable;
            handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
            return;
        }
        this.cdE.stopSelf();
    }
}
