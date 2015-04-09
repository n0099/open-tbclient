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
    aa Ok;
    final /* synthetic */ TiebaSyncService bZs;

    private l(TiebaSyncService tiebaSyncService) {
        this.bZs = tiebaSyncService;
        this.Ok = null;
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
            this.Ok = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
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
            str = TiebaSyncService.mStatistics;
            if (str != null) {
                aa aaVar = this.Ok;
                str2 = TiebaSyncService.mStatistics;
                aaVar.o("_msg_type", str2);
            }
            String packageName = TbadkCoreApplication.m411getInst().getPackageName();
            this.Ok.o("package", packageName);
            this.Ok.o("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m411getInst().getVersionCode())).toString());
            this.Ok.o("signmd5", bf.b(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.Ok.o("md5", ao.getTiebaApkMd5());
            String rO = this.Ok.rO();
            if (this.Ok.ss()) {
                TbadkCoreApplication.m411getInst().clearActiveVersion();
            }
            if (this.Ok.sp().tq().pv()) {
                gVar = new com.baidu.tbadk.coreExtra.c.g();
                try {
                    gVar.parserJson(rO);
                    if (TbadkCoreApplication.getClientId() == null && gVar.wc().getClientId() != null && gVar.wc().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(this.bZs, gVar.wc().getClientId());
                        TbadkCoreApplication.setClientId(gVar.wc().getClientId());
                    }
                    if (gVar.vY() != null) {
                        com.baidu.tbadk.core.sharedPref.b.rB().putInt("aladin_port", gVar.vY().uB());
                        com.baidu.tbadk.core.sharedPref.b.rB().putInt("crash_limit_count", gVar.vY().getCrashLimitCount());
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
        this.bZs.mSyncTask = null;
        if (this.Ok != null) {
            this.Ok.hh();
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
        this.bZs.mSyncTask = null;
        if (gVar != null) {
            com.baidu.tbadk.util.a.Db().Dc();
            this.bZs.mModel = gVar;
            gVar2 = this.bZs.mModel;
            if (gVar2.wb().hasNewVer()) {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                gVar8 = this.bZs.mModel;
                m411getInst.setVersionData(gVar8.wb());
                this.bZs.broadcastNewVersion();
                gVar9 = this.bZs.mModel;
                if (gVar9.wb().forceUpdate()) {
                    gVar14 = this.bZs.mModel;
                    if (gVar14.vY() != null && TbadkCoreApplication.m411getInst().getResumeNum() > 0) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Application app = TbadkCoreApplication.m411getInst().getApp();
                        gVar15 = this.bZs.mModel;
                        VersionData wb = gVar15.wb();
                        gVar16 = this.bZs.mModel;
                        messageManager.sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(app, wb, gVar16.wa())));
                    }
                } else {
                    Long valueOf = Long.valueOf(TbadkCoreApplication.m411getInst().getUpdateNotifyTime());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if (valueOf2.longValue() - valueOf.longValue() > 86400000) {
                        gVar10 = this.bZs.mModel;
                        if (gVar10.wb().getStrategy() == 0) {
                            gVar11 = this.bZs.mModel;
                            if (gVar11.vY() != null && TbadkCoreApplication.m411getInst().getResumeNum() > 0) {
                                MessageManager messageManager2 = MessageManager.getInstance();
                                Application app2 = TbadkCoreApplication.m411getInst().getApp();
                                gVar12 = this.bZs.mModel;
                                VersionData wb2 = gVar12.wb();
                                gVar13 = this.bZs.mModel;
                                messageManager2.sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(app2, wb2, gVar13.wa())));
                                TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf2.longValue());
                            }
                        }
                    }
                }
            }
            TbadkCoreApplication.m411getInst().loadLcsSwitchStratgy();
            int nextInt = new Random().nextInt(10000) + 1;
            int uA = gVar.vY().uA();
            if (uA > 0 && nextInt % uA == 0 && (performSampleCount = TbadkCoreApplication.m411getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.m411getInst().setPerformSampleCount(performSampleCount + 1);
            }
            gVar3 = this.bZs.mModel;
            String vZ = gVar3.vZ();
            if (!StringUtils.isNull(vZ)) {
                TbadkCoreApplication.m411getInst().setConfigVersion(vZ);
            }
            gVar4 = this.bZs.mModel;
            com.baidu.tbadk.coreExtra.data.m wd = gVar4.wd();
            if (wd != null) {
                TbadkCoreApplication.m411getInst().getListItemRule().dk(wd.uT());
                TbadkCoreApplication.m411getInst().getListItemRule().dm(wd.uV());
                TbadkCoreApplication.m411getInst().getListItemRule().dl(wd.uU());
                at.sL().c(wd.uO(), wd.uP(), wd.uQ(), wd.uR(), wd.uS());
                String uN = wd.uN();
                com.baidu.tbadk.core.sharedPref.b rB = com.baidu.tbadk.core.sharedPref.b.rB();
                if (uN == null) {
                    uN = "";
                }
                rB.putString("apply_vip_live_room_pid", uN);
            }
            this.bZs.stopSelf();
            gVar5 = this.bZs.mModel;
            if (gVar5.vY() != null) {
                gVar6 = this.bZs.mModel;
                if (gVar6.vY().uC() != null) {
                    TbadkCoreApplication m411getInst2 = TbadkCoreApplication.m411getInst();
                    gVar7 = this.bZs.mModel;
                    m411getInst2.setCheckUrl(gVar7.vY().uC().uK());
                    return;
                }
                return;
            }
            return;
        }
        TiebaSyncService tiebaSyncService = this.bZs;
        i = tiebaSyncService.mHaveRetry;
        tiebaSyncService.mHaveRetry = i + 1;
        i2 = this.bZs.mHaveRetry;
        if (i2 < 10) {
            handler = this.bZs.mHandler;
            runnable = this.bZs.mRunnable;
            handler.removeCallbacks(runnable);
            handler2 = this.bZs.mHandler;
            runnable2 = this.bZs.mRunnable;
            handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
            return;
        }
        this.bZs.stopSelf();
    }
}
