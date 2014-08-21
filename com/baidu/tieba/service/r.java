package com.baidu.tieba.service;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.plugins.Hao123Plugin;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.ai;
import com.baidu.tieba.az;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.be;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<String, Integer, be> {
    ae a;
    final /* synthetic */ TiebaSyncService b;

    private r(TiebaSyncService tiebaSyncService) {
        this.b = tiebaSyncService;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(TiebaSyncService tiebaSyncService, r rVar) {
        this(tiebaSyncService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public be doInBackground(String... strArr) {
        be beVar;
        Exception e;
        String str;
        String str2;
        try {
            this.a = new ae(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.j.b(ai.c().d())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.j.c(ai.c().d())));
            this.a.a("_phone_screen", stringBuffer.toString());
            this.a.a("scr_w", String.valueOf(com.baidu.adp.lib.util.j.b(ai.c().d())));
            this.a.a("scr_h", String.valueOf(com.baidu.adp.lib.util.j.c(ai.c().d())));
            this.a.a("scr_dip", String.valueOf(com.baidu.adp.lib.util.j.d(ai.c().d())));
            if (TbadkApplication.m252getInst().getMsgFrequency() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            }
            String C = ai.c().C();
            if (C != null) {
                if (C.length() < 1) {
                    C = "0";
                }
                this.a.a("_active", C);
            }
            this.a.a("_pic_quality", String.valueOf(TbadkApplication.m252getInst().getViewImageQuality()));
            str = TiebaSyncService.mStatistics;
            if (str != null) {
                ae aeVar = this.a;
                str2 = TiebaSyncService.mStatistics;
                aeVar.a("_msg_type", str2);
            }
            String packageName = TbadkApplication.m252getInst().getPackageName();
            this.a.a("package", packageName);
            this.a.a("versioncode", new StringBuilder(String.valueOf(TbadkApplication.m252getInst().getVersionCode())).toString());
            this.a.a("signmd5", UtilHelper.creatSignInt(TbadkApplication.m252getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.a.a("md5", az.a());
            String h = this.a.h();
            if (this.a.b()) {
                ai.c().E();
            }
            if (this.a.a().b().b()) {
                beVar = new be();
                try {
                    beVar.a(h);
                    if (TbadkApplication.getClientId() == null && beVar.d().a() != null && beVar.d().a().length() > 0) {
                        TbadkApplication.saveClientId(this.b, beVar.d().a());
                        TbadkApplication.setClientId(beVar.d().a());
                    }
                    if (beVar.a() != null) {
                        com.baidu.tbadk.core.sharedPref.b.a().b("aladin_port", beVar.a().c());
                        com.baidu.tbadk.core.sharedPref.b.a().b("crash_limit_count", beVar.a().b());
                    }
                    TiebaSyncService.mStatistics = null;
                    return beVar;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    return beVar;
                }
            }
            return null;
        } catch (Exception e3) {
            beVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.mSyncTask = null;
        if (this.a != null) {
            this.a.f();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(be beVar) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        be beVar2;
        Hao123Plugin hao123Plugin;
        int x;
        be beVar3;
        be beVar4;
        be beVar5;
        be beVar6;
        be beVar7;
        be beVar8;
        be beVar9;
        be beVar10;
        be beVar11;
        super.onPostExecute(beVar);
        this.b.mSyncTask = null;
        if (beVar != null) {
            com.baidu.tbadk.b.a.a().b();
            this.b.mModel = beVar;
            beVar2 = this.b.mModel;
            if (beVar2.c().hasNewVer()) {
                ai c = ai.c();
                beVar3 = this.b.mModel;
                c.a(beVar3.c());
                this.b.broadcastNewVersion();
                beVar4 = this.b.mModel;
                if (beVar4.c().forceUpdate()) {
                    beVar9 = this.b.mModel;
                    if (beVar9.a() != null) {
                        Application d = ai.c().d();
                        beVar10 = this.b.mModel;
                        VersionData c2 = beVar10.c();
                        beVar11 = this.b.mModel;
                        UpdateDialog.a(d, c2, beVar11.b());
                    }
                } else if (Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(TbadkApplication.m252getInst().getUpdateNotifyTime()).longValue() > 86400000) {
                    beVar5 = this.b.mModel;
                    if (beVar5.c().getStrategy() == 0) {
                        beVar6 = this.b.mModel;
                        if (beVar6.a() != null) {
                            Application d2 = ai.c().d();
                            beVar7 = this.b.mModel;
                            VersionData c3 = beVar7.c();
                            beVar8 = this.b.mModel;
                            UpdateDialog.a(d2, c3, beVar8.b());
                        }
                    }
                }
            }
            ai.c().F();
            int nextInt = new Random().nextInt(TbConfig.BIG_IMAGE_MIN_CAPACITY) + 1;
            int a = beVar.a().a();
            if (a > 0 && nextInt % a == 0 && (x = ai.c().x()) < 10) {
                ai.c().d(x + 1);
                com.baidu.tieba.util.r.a(this.b);
            }
            if (!TbadkApplication.m252getInst().isHao123HelperShouldOpen() && TbadkApplication.m252getInst().isTiebaHelperOpen()) {
                TbadkApplication.m252getInst().setTiebaHelperOpen(false);
                com.baidu.tbadk.pluginArch.c a2 = com.baidu.tbadk.pluginArch.d.a().a("hao123");
                if (a2 != null && (hao123Plugin = (Hao123Plugin) a2.a(Hao123Plugin.class)) != null) {
                    hao123Plugin.closeFloating(this.b);
                }
            }
            this.b.stopSelf();
            return;
        }
        TiebaSyncService tiebaSyncService = this.b;
        i = tiebaSyncService.mHaveRetry;
        tiebaSyncService.mHaveRetry = i + 1;
        i2 = this.b.mHaveRetry;
        if (i2 < 10) {
            handler = this.b.mHandler;
            runnable = this.b.mRunnable;
            handler.removeCallbacks(runnable);
            handler2 = this.b.mHandler;
            runnable2 = this.b.mRunnable;
            handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
            return;
        }
        this.b.stopSelf();
    }
}
