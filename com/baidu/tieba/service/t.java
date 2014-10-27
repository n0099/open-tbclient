package com.baidu.tieba.service;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.Hao123Plugin;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.aj;
import com.baidu.tieba.bc;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.bb;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<String, Integer, bb> {
    final /* synthetic */ TiebaSyncService bIS;
    ac mNetWork;

    private t(TiebaSyncService tiebaSyncService) {
        this.bIS = tiebaSyncService;
        this.mNetWork = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(TiebaSyncService tiebaSyncService, t tVar) {
        this(tiebaSyncService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: x */
    public bb doInBackground(String... strArr) {
        bb bbVar;
        Exception e;
        String str;
        String str2;
        try {
            this.mNetWork = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/sync");
            this.mNetWork.k("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.m.n(aj.wk().getApp())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.m.o(aj.wk().getApp())));
            this.mNetWork.k("_phone_screen", stringBuffer.toString());
            this.mNetWork.k("scr_w", String.valueOf(com.baidu.adp.lib.util.m.n(aj.wk().getApp())));
            this.mNetWork.k("scr_h", String.valueOf(com.baidu.adp.lib.util.m.o(aj.wk().getApp())));
            this.mNetWork.k("scr_dip", String.valueOf(com.baidu.adp.lib.util.m.p(aj.wk().getApp())));
            if (TbadkApplication.m251getInst().getMsgFrequency() > 0) {
                this.mNetWork.k("_msg_status", "0");
            } else {
                this.mNetWork.k("_msg_status", "1");
            }
            String wK = aj.wk().wK();
            if (wK != null) {
                if (wK.length() < 1) {
                    wK = "0";
                }
                this.mNetWork.k("_active", wK);
            }
            this.mNetWork.k("_pic_quality", String.valueOf(TbadkApplication.m251getInst().getViewImageQuality()));
            str = TiebaSyncService.mStatistics;
            if (str != null) {
                ac acVar = this.mNetWork;
                str2 = TiebaSyncService.mStatistics;
                acVar.k("_msg_type", str2);
            }
            String packageName = TbadkApplication.m251getInst().getPackageName();
            this.mNetWork.k("package", packageName);
            this.mNetWork.k("versioncode", new StringBuilder(String.valueOf(TbadkApplication.m251getInst().getVersionCode())).toString());
            this.mNetWork.k("signmd5", ba.a(TbadkApplication.m251getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.mNetWork.k("md5", bc.xa());
            String lA = this.mNetWork.lA();
            if (this.mNetWork.mf()) {
                aj.wk().wM();
            }
            if (this.mNetWork.mc().nb().jq()) {
                bbVar = new bb();
                try {
                    bbVar.parserJson(lA);
                    if (TbadkApplication.getClientId() == null && bbVar.Ub().getClientId() != null && bbVar.Ub().getClientId().length() > 0) {
                        TbadkApplication.saveClientId(this.bIS, bbVar.Ub().getClientId());
                        TbadkApplication.setClientId(bbVar.Ub().getClientId());
                    }
                    if (bbVar.TX() != null) {
                        com.baidu.tbadk.core.sharedPref.b.lk().putInt("aladin_port", bbVar.TX().yB());
                        com.baidu.tbadk.core.sharedPref.b.lk().putInt("crash_limit_count", bbVar.TX().yA());
                    }
                    TiebaSyncService.mStatistics = null;
                    return bbVar;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    return bbVar;
                }
            }
            return null;
        } catch (Exception e3) {
            bbVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bIS.mSyncTask = null;
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(bb bbVar) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        bb bbVar2;
        Hao123Plugin hao123Plugin;
        int wF;
        bb bbVar3;
        bb bbVar4;
        bb bbVar5;
        bb bbVar6;
        bb bbVar7;
        bb bbVar8;
        bb bbVar9;
        bb bbVar10;
        bb bbVar11;
        super.onPostExecute(bbVar);
        this.bIS.mSyncTask = null;
        if (bbVar != null) {
            com.baidu.tbadk.util.a.uR().uS();
            this.bIS.mModel = bbVar;
            bbVar2 = this.bIS.mModel;
            if (bbVar2.Ua().hasNewVer()) {
                aj wk = aj.wk();
                bbVar3 = this.bIS.mModel;
                wk.a(bbVar3.Ua());
                this.bIS.broadcastNewVersion();
                bbVar4 = this.bIS.mModel;
                if (bbVar4.Ua().forceUpdate()) {
                    bbVar9 = this.bIS.mModel;
                    if (bbVar9.TX() != null) {
                        Application app = aj.wk().getApp();
                        bbVar10 = this.bIS.mModel;
                        VersionData Ua = bbVar10.Ua();
                        bbVar11 = this.bIS.mModel;
                        UpdateDialog.a(app, Ua, bbVar11.TZ());
                    }
                } else if (Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(TbadkApplication.m251getInst().getUpdateNotifyTime()).longValue() > 86400000) {
                    bbVar5 = this.bIS.mModel;
                    if (bbVar5.Ua().getStrategy() == 0) {
                        bbVar6 = this.bIS.mModel;
                        if (bbVar6.TX() != null) {
                            Application app2 = aj.wk().getApp();
                            bbVar7 = this.bIS.mModel;
                            VersionData Ua2 = bbVar7.Ua();
                            bbVar8 = this.bIS.mModel;
                            UpdateDialog.a(app2, Ua2, bbVar8.TZ());
                        }
                    }
                }
            }
            aj.wk().wN();
            int nextInt = new Random().nextInt(TbConfig.BIG_IMAGE_MIN_CAPACITY) + 1;
            int yz = bbVar.TX().yz();
            if (yz > 0 && nextInt % yz == 0 && (wF = aj.wk().wF()) < 10) {
                aj.wk().dC(wF + 1);
                com.baidu.tieba.util.q.ak(this.bIS);
            }
            if (!TbadkApplication.m251getInst().isHao123HelperShouldOpen() && TbadkApplication.m251getInst().isTiebaHelperOpen()) {
                TbadkApplication.m251getInst().setTiebaHelperOpen(false);
                Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_HAO123);
                if (pluginByName != null && (hao123Plugin = (Hao123Plugin) pluginByName.getClassInstance(Hao123Plugin.class)) != null) {
                    hao123Plugin.closeFloating(this.bIS);
                    return;
                }
                return;
            }
            return;
        }
        TiebaSyncService tiebaSyncService = this.bIS;
        i = tiebaSyncService.mHaveRetry;
        tiebaSyncService.mHaveRetry = i + 1;
        i2 = this.bIS.mHaveRetry;
        if (i2 < 10) {
            handler = this.bIS.mHandler;
            runnable = this.bIS.mRunnable;
            handler.removeCallbacks(runnable);
            handler2 = this.bIS.mHandler;
            runnable2 = this.bIS.mRunnable;
            handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
        }
    }
}
