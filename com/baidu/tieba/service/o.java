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
    ad AO;
    final /* synthetic */ TiebaSyncService bPa;

    private o(TiebaSyncService tiebaSyncService) {
        this.bPa = tiebaSyncService;
        this.AO = null;
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
            this.AO = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_SYNC_ADDRESS);
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
            str = TiebaSyncService.mStatistics;
            if (str != null) {
                ad adVar = this.AO;
                str2 = TiebaSyncService.mStatistics;
                adVar.o("_msg_type", str2);
            }
            String packageName = TbadkCoreApplication.m255getInst().getPackageName();
            this.AO.o("package", packageName);
            this.AO.o("versioncode", new StringBuilder(String.valueOf(TbadkCoreApplication.m255getInst().getVersionCode())).toString());
            this.AO.o("signmd5", bh.b(TbadkCoreApplication.m255getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.AO.o("md5", be.getTiebaApkMd5());
            String or = this.AO.or();
            if (this.AO.oV()) {
                TbadkCoreApplication.m255getInst().clearActiveVersion();
            }
            if (this.AO.oS().qa().lT()) {
                gVar = new com.baidu.tbadk.coreExtra.c.g();
                try {
                    gVar.parserJson(or);
                    if (TbadkCoreApplication.getClientId() == null && gVar.sA().getClientId() != null && gVar.sA().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(this.bPa, gVar.sA().getClientId());
                        TbadkCoreApplication.setClientId(gVar.sA().getClientId());
                    }
                    if (gVar.sw() != null) {
                        com.baidu.tbadk.core.sharedPref.b.oc().putInt("aladin_port", gVar.sw().rF());
                        com.baidu.tbadk.core.sharedPref.b.oc().putInt("crash_limit_count", gVar.sw().rE());
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
        this.bPa.mSyncTask = null;
        if (this.AO != null) {
            this.AO.dJ();
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
        this.bPa.mSyncTask = null;
        if (gVar != null) {
            com.baidu.tbadk.util.a.zB().zC();
            this.bPa.mModel = gVar;
            gVar2 = this.bPa.mModel;
            if (gVar2.sz().hasNewVer()) {
                TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
                gVar5 = this.bPa.mModel;
                m255getInst.setVersionData(gVar5.sz());
                this.bPa.broadcastNewVersion();
                gVar6 = this.bPa.mModel;
                if (gVar6.sz().forceUpdate()) {
                    gVar11 = this.bPa.mModel;
                    if (gVar11.sw() != null && TbadkCoreApplication.m255getInst().getResumeNum() > 0) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Application app = TbadkCoreApplication.m255getInst().getApp();
                        gVar12 = this.bPa.mModel;
                        VersionData sz = gVar12.sz();
                        gVar13 = this.bPa.mModel;
                        messageManager.sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(app, sz, gVar13.sy())));
                    }
                } else if (Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(TbadkCoreApplication.m255getInst().getUpdateNotifyTime()).longValue() > 86400000) {
                    gVar7 = this.bPa.mModel;
                    if (gVar7.sz().getStrategy() == 0) {
                        gVar8 = this.bPa.mModel;
                        if (gVar8.sw() != null && TbadkCoreApplication.m255getInst().getResumeNum() > 0) {
                            MessageManager messageManager2 = MessageManager.getInstance();
                            Application app2 = TbadkCoreApplication.m255getInst().getApp();
                            gVar9 = this.bPa.mModel;
                            VersionData sz2 = gVar9.sz();
                            gVar10 = this.bPa.mModel;
                            messageManager2.sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(app2, sz2, gVar10.sy())));
                        }
                    }
                }
            }
            TbadkCoreApplication.m255getInst().loadLcsSwitchStratgy();
            int nextInt = new Random().nextInt(TbConfig.BIG_IMAGE_MIN_CAPACITY) + 1;
            int rD = gVar.sw().rD();
            if (rD > 0 && nextInt % rD == 0 && (performSampleCount = TbadkCoreApplication.m255getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.m255getInst().setPerformSampleCount(performSampleCount + 1);
            }
            gVar3 = this.bPa.mModel;
            String sx = gVar3.sx();
            if (!StringUtils.isNull(sx)) {
                TbadkCoreApplication.m255getInst().setConfigVersion(sx);
            }
            this.bPa.stopSelf();
            gVar4 = this.bPa.mModel;
            com.baidu.tbadk.coreExtra.data.k sB = gVar4.sB();
            if (sB != null) {
                av.po().j(sB.rM(), sB.rN(), sB.rO());
                return;
            }
            return;
        }
        TiebaSyncService tiebaSyncService = this.bPa;
        i = tiebaSyncService.mHaveRetry;
        tiebaSyncService.mHaveRetry = i + 1;
        i2 = this.bPa.mHaveRetry;
        if (i2 < 10) {
            handler = this.bPa.mHandler;
            runnable = this.bPa.mRunnable;
            handler.removeCallbacks(runnable);
            handler2 = this.bPa.mHandler;
            runnable2 = this.bPa.mRunnable;
            handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
            return;
        }
        this.bPa.stopSelf();
    }
}
