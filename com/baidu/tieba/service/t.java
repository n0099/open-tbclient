package com.baidu.tieba.service;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.Hao123Plugin;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.aj;
import com.baidu.tieba.bl;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.bb;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<String, Integer, bb> {
    final /* synthetic */ TiebaSyncService bJg;
    ac mNetWork;

    private t(TiebaSyncService tiebaSyncService) {
        this.bJg = tiebaSyncService;
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
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.m.n(aj.wm().getApp())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.m.o(aj.wm().getApp())));
            this.mNetWork.k("_phone_screen", stringBuffer.toString());
            this.mNetWork.k("scr_w", String.valueOf(com.baidu.adp.lib.util.m.n(aj.wm().getApp())));
            this.mNetWork.k("scr_h", String.valueOf(com.baidu.adp.lib.util.m.o(aj.wm().getApp())));
            this.mNetWork.k("scr_dip", String.valueOf(com.baidu.adp.lib.util.m.p(aj.wm().getApp())));
            if (TbadkApplication.m251getInst().getMsgFrequency() > 0) {
                this.mNetWork.k("_msg_status", "0");
            } else {
                this.mNetWork.k("_msg_status", "1");
            }
            String wM = aj.wm().wM();
            if (wM != null) {
                if (wM.length() < 1) {
                    wM = "0";
                }
                this.mNetWork.k("_active", wM);
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
            this.mNetWork.k("signmd5", com.baidu.tbadk.core.util.bb.a(TbadkApplication.m251getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.mNetWork.k("md5", bl.xc());
            String lA = this.mNetWork.lA();
            if (this.mNetWork.mf()) {
                aj.wm().wO();
            }
            if (this.mNetWork.mc().nb().jq()) {
                bbVar = new bb();
                try {
                    bbVar.parserJson(lA);
                    if (TbadkApplication.getClientId() == null && bbVar.Ue().getClientId() != null && bbVar.Ue().getClientId().length() > 0) {
                        TbadkApplication.saveClientId(this.bJg, bbVar.Ue().getClientId());
                        TbadkApplication.setClientId(bbVar.Ue().getClientId());
                    }
                    if (bbVar.Ua() != null) {
                        com.baidu.tbadk.core.sharedPref.b.lk().putInt("aladin_port", bbVar.Ua().yD());
                        com.baidu.tbadk.core.sharedPref.b.lk().putInt("crash_limit_count", bbVar.Ua().yC());
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
        this.bJg.mSyncTask = null;
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
        int wH;
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
        this.bJg.mSyncTask = null;
        if (bbVar != null) {
            com.baidu.tbadk.util.a.uT().uU();
            this.bJg.mModel = bbVar;
            bbVar2 = this.bJg.mModel;
            if (bbVar2.Ud().hasNewVer()) {
                aj wm = aj.wm();
                bbVar3 = this.bJg.mModel;
                wm.a(bbVar3.Ud());
                this.bJg.broadcastNewVersion();
                bbVar4 = this.bJg.mModel;
                if (bbVar4.Ud().forceUpdate()) {
                    bbVar9 = this.bJg.mModel;
                    if (bbVar9.Ua() != null) {
                        Application app = aj.wm().getApp();
                        bbVar10 = this.bJg.mModel;
                        VersionData Ud = bbVar10.Ud();
                        bbVar11 = this.bJg.mModel;
                        UpdateDialog.a(app, Ud, bbVar11.Uc());
                    }
                } else if (Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(TbadkApplication.m251getInst().getUpdateNotifyTime()).longValue() > 86400000) {
                    bbVar5 = this.bJg.mModel;
                    if (bbVar5.Ud().getStrategy() == 0) {
                        bbVar6 = this.bJg.mModel;
                        if (bbVar6.Ua() != null) {
                            Application app2 = aj.wm().getApp();
                            bbVar7 = this.bJg.mModel;
                            VersionData Ud2 = bbVar7.Ud();
                            bbVar8 = this.bJg.mModel;
                            UpdateDialog.a(app2, Ud2, bbVar8.Uc());
                        }
                    }
                }
            }
            aj.wm().wP();
            int nextInt = new Random().nextInt(TbConfig.BIG_IMAGE_MIN_CAPACITY) + 1;
            int yB = bbVar.Ua().yB();
            if (yB > 0 && nextInt % yB == 0 && (wH = aj.wm().wH()) < 10) {
                aj.wm().dC(wH + 1);
                com.baidu.tieba.util.q.ak(this.bJg);
            }
            if (!TbadkApplication.m251getInst().isHao123HelperShouldOpen() && TbadkApplication.m251getInst().isTiebaHelperOpen()) {
                TbadkApplication.m251getInst().setTiebaHelperOpen(false);
                Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_HAO123);
                if (pluginByName != null && (hao123Plugin = (Hao123Plugin) pluginByName.getClassInstance(Hao123Plugin.class)) != null) {
                    hao123Plugin.closeFloating(this.bJg);
                    return;
                }
                return;
            }
            return;
        }
        TiebaSyncService tiebaSyncService = this.bJg;
        i = tiebaSyncService.mHaveRetry;
        tiebaSyncService.mHaveRetry = i + 1;
        i2 = this.bJg.mHaveRetry;
        if (i2 < 10) {
            handler = this.bJg.mHandler;
            runnable = this.bJg.mRunnable;
            handler.removeCallbacks(runnable);
            handler2 = this.bJg.mHandler;
            runnable2 = this.bJg.mRunnable;
            handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
        }
    }
}
