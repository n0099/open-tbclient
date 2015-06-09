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
    final /* synthetic */ TiebaSyncService cdF;

    private l(TiebaSyncService tiebaSyncService) {
        this.cdF = tiebaSyncService;
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
                    if (TbadkCoreApplication.getClientId() == null && gVar.wN().getClientId() != null && gVar.wN().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(this.cdF, gVar.wN().getClientId());
                        TbadkCoreApplication.setClientId(gVar.wN().getClientId());
                    }
                    if (gVar.wJ() != null) {
                        com.baidu.tbadk.core.sharedPref.b.sl().putInt("aladin_port", gVar.wJ().vk());
                        com.baidu.tbadk.core.sharedPref.b.sl().putInt("crash_limit_count", gVar.wJ().getCrashLimitCount());
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
        this.cdF.mSyncTask = null;
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
        this.cdF.mSyncTask = null;
        if (gVar != null) {
            com.baidu.tbadk.util.a.DQ().DR();
            this.cdF.mModel = gVar;
            gVar2 = this.cdF.mModel;
            if (gVar2.wM().hasNewVer()) {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                gVar8 = this.cdF.mModel;
                m411getInst.setVersionData(gVar8.wM());
                this.cdF.broadcastNewVersion();
                gVar9 = this.cdF.mModel;
                if (gVar9.wM().forceUpdate()) {
                    gVar14 = this.cdF.mModel;
                    if (gVar14.wJ() != null && TbadkCoreApplication.m411getInst().getResumeNum() > 0) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Application app = TbadkCoreApplication.m411getInst().getApp();
                        gVar15 = this.cdF.mModel;
                        VersionData wM = gVar15.wM();
                        gVar16 = this.cdF.mModel;
                        messageManager.sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(app, wM, gVar16.wL())));
                    }
                } else {
                    Long valueOf = Long.valueOf(TbadkCoreApplication.m411getInst().getUpdateNotifyTime());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if (valueOf2.longValue() - valueOf.longValue() > 86400000) {
                        gVar10 = this.cdF.mModel;
                        if (gVar10.wM().getStrategy() == 0) {
                            gVar11 = this.cdF.mModel;
                            if (gVar11.wJ() != null && TbadkCoreApplication.m411getInst().getResumeNum() > 0) {
                                MessageManager messageManager2 = MessageManager.getInstance();
                                Application app2 = TbadkCoreApplication.m411getInst().getApp();
                                gVar12 = this.cdF.mModel;
                                VersionData wM2 = gVar12.wM();
                                gVar13 = this.cdF.mModel;
                                messageManager2.sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(app2, wM2, gVar13.wL())));
                                TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf2.longValue());
                            }
                        }
                    }
                }
            }
            TbadkCoreApplication.m411getInst().loadLcsSwitchStratgy();
            int nextInt = new Random().nextInt(10000) + 1;
            int vj = gVar.wJ().vj();
            if (vj > 0 && nextInt % vj == 0 && (performSampleCount = TbadkCoreApplication.m411getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.m411getInst().setPerformSampleCount(performSampleCount + 1);
            }
            gVar3 = this.cdF.mModel;
            String wK = gVar3.wK();
            if (!StringUtils.isNull(wK)) {
                TbadkCoreApplication.m411getInst().setConfigVersion(wK);
            }
            gVar4 = this.cdF.mModel;
            com.baidu.tbadk.coreExtra.data.m wO = gVar4.wO();
            if (wO != null) {
                TbadkCoreApplication.m411getInst().getListItemRule().dB(wO.vD());
                TbadkCoreApplication.m411getInst().getListItemRule().dD(wO.vF());
                TbadkCoreApplication.m411getInst().getListItemRule().dC(wO.vE());
                aq.to().c(wO.vy(), wO.vz(), wO.vA(), wO.vB(), wO.vC());
                String vx = wO.vx();
                com.baidu.tbadk.core.sharedPref.b sl = com.baidu.tbadk.core.sharedPref.b.sl();
                if (vx == null) {
                    vx = "";
                }
                sl.putString("apply_vip_live_room_pid", vx);
            }
            this.cdF.stopSelf();
            gVar5 = this.cdF.mModel;
            if (gVar5.wJ() != null) {
                gVar6 = this.cdF.mModel;
                if (gVar6.wJ().vl() != null) {
                    TbadkCoreApplication m411getInst2 = TbadkCoreApplication.m411getInst();
                    gVar7 = this.cdF.mModel;
                    m411getInst2.setCheckUrl(gVar7.wJ().vl().vu());
                    return;
                }
                return;
            }
            return;
        }
        TiebaSyncService tiebaSyncService = this.cdF;
        i = tiebaSyncService.mHaveRetry;
        tiebaSyncService.mHaveRetry = i + 1;
        i2 = this.cdF.mHaveRetry;
        if (i2 < 10) {
            handler = this.cdF.mHandler;
            runnable = this.cdF.mRunnable;
            handler.removeCallbacks(runnable);
            handler2 = this.cdF.mHandler;
            runnable2 = this.cdF.mRunnable;
            handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
            return;
        }
        this.cdF.stopSelf();
    }
}
