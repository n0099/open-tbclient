package com.baidu.tieba.service;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.plugins.Hao123Plugin;
import com.baidu.tieba.bb;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.c.g> {
    ad AR;
    final /* synthetic */ TiebaSyncService bNr;

    private p(TiebaSyncService tiebaSyncService) {
        this.bNr = tiebaSyncService;
        this.AR = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(TiebaSyncService tiebaSyncService, p pVar) {
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
            this.AR.o("signmd5", bc.b(TbadkCoreApplication.m255getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.AR.o("md5", bb.getTiebaApkMd5());
            String ov = this.AR.ov();
            if (this.AR.oZ()) {
                TbadkCoreApplication.m255getInst().clearActiveVersion();
            }
            if (this.AR.oW().pW().ma()) {
                gVar = new com.baidu.tbadk.coreExtra.c.g();
                try {
                    gVar.parserJson(ov);
                    if (TbadkCoreApplication.getClientId() == null && gVar.sq().getClientId() != null && gVar.sq().getClientId().length() > 0) {
                        TbadkCoreApplication.saveClientId(this.bNr, gVar.sq().getClientId());
                        TbadkCoreApplication.setClientId(gVar.sq().getClientId());
                    }
                    if (gVar.sm() != null) {
                        com.baidu.tbadk.core.sharedPref.b.og().putInt("aladin_port", gVar.sm().ry());
                        com.baidu.tbadk.core.sharedPref.b.og().putInt("crash_limit_count", gVar.sm().getCrashLimitCount());
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
        this.bNr.mSyncTask = null;
        if (this.AR != null) {
            this.AR.dL();
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
        int performSampleCount;
        com.baidu.tbadk.coreExtra.c.g gVar3;
        com.baidu.tbadk.coreExtra.c.g gVar4;
        com.baidu.tbadk.coreExtra.c.g gVar5;
        com.baidu.tbadk.coreExtra.c.g gVar6;
        com.baidu.tbadk.coreExtra.c.g gVar7;
        com.baidu.tbadk.coreExtra.c.g gVar8;
        com.baidu.tbadk.coreExtra.c.g gVar9;
        com.baidu.tbadk.coreExtra.c.g gVar10;
        com.baidu.tbadk.coreExtra.c.g gVar11;
        super.onPostExecute(gVar);
        this.bNr.mSyncTask = null;
        if (gVar != null) {
            com.baidu.tbadk.util.a.zq().zr();
            this.bNr.mModel = gVar;
            gVar2 = this.bNr.mModel;
            if (gVar2.sp().hasNewVer()) {
                TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
                gVar3 = this.bNr.mModel;
                m255getInst.setVersionData(gVar3.sp());
                this.bNr.broadcastNewVersion();
                gVar4 = this.bNr.mModel;
                if (gVar4.sp().forceUpdate()) {
                    gVar9 = this.bNr.mModel;
                    if (gVar9.sm() != null && TbadkCoreApplication.m255getInst().getResumeNum() > 0) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Application app = TbadkCoreApplication.m255getInst().getApp();
                        gVar10 = this.bNr.mModel;
                        VersionData sp = gVar10.sp();
                        gVar11 = this.bNr.mModel;
                        messageManager.sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(app, sp, gVar11.so())));
                    }
                } else if (Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(TbadkCoreApplication.m255getInst().getUpdateNotifyTime()).longValue() > 86400000) {
                    gVar5 = this.bNr.mModel;
                    if (gVar5.sp().getStrategy() == 0) {
                        gVar6 = this.bNr.mModel;
                        if (gVar6.sm() != null && TbadkCoreApplication.m255getInst().getResumeNum() > 0) {
                            MessageManager messageManager2 = MessageManager.getInstance();
                            Application app2 = TbadkCoreApplication.m255getInst().getApp();
                            gVar7 = this.bNr.mModel;
                            VersionData sp2 = gVar7.sp();
                            gVar8 = this.bNr.mModel;
                            messageManager2.sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(app2, sp2, gVar8.so())));
                        }
                    }
                }
            }
            TbadkCoreApplication.m255getInst().loadLcsSwitchStratgy();
            int nextInt = new Random().nextInt(TbConfig.BIG_IMAGE_MIN_CAPACITY) + 1;
            int rx = gVar.sm().rx();
            if (rx > 0 && nextInt % rx == 0 && (performSampleCount = TbadkCoreApplication.m255getInst().getPerformSampleCount()) < 10) {
                TbadkCoreApplication.m255getInst().setPerformSampleCount(performSampleCount + 1);
            }
            if (!TbadkCoreApplication.m255getInst().isHao123HelperShouldOpen() && TbadkCoreApplication.m255getInst().isTiebaHelperOpen()) {
                TbadkCoreApplication.m255getInst().setTiebaHelperOpen(false);
                Hao123Plugin hao123Plugin = (Hao123Plugin) PluginCenter.gX().hc();
                if (hao123Plugin != null) {
                    hao123Plugin.closeFloating(this.bNr);
                    return;
                }
                return;
            }
            return;
        }
        TiebaSyncService tiebaSyncService = this.bNr;
        i = tiebaSyncService.mHaveRetry;
        tiebaSyncService.mHaveRetry = i + 1;
        i2 = this.bNr.mHaveRetry;
        if (i2 < 10) {
            handler = this.bNr.mHandler;
            runnable = this.bNr.mRunnable;
            handler.removeCallbacks(runnable);
            handler2 = this.bNr.mHandler;
            runnable2 = this.bNr.mRunnable;
            handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
        }
    }
}
