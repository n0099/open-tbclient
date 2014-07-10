package com.baidu.tieba.service;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.plugins.Hao123Plugin;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.ai;
import com.baidu.tieba.bc;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.bd;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<String, Integer, bd> {
    aq a;
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
    public bd doInBackground(String... strArr) {
        bd bdVar;
        Exception e;
        String str;
        String str2;
        try {
            this.a = new aq(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/sync");
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
            String D = ai.c().D();
            if (D != null) {
                if (D.length() < 1) {
                    D = "0";
                }
                this.a.a("_active", D);
            }
            this.a.a("_pic_quality", String.valueOf(TbadkApplication.m252getInst().getViewImageQuality()));
            str = TiebaSyncService.mStatistics;
            if (str != null) {
                aq aqVar = this.a;
                str2 = TiebaSyncService.mStatistics;
                aqVar.a("_msg_type", str2);
            }
            String packageName = TbadkApplication.m252getInst().getPackageName();
            this.a.a("package", packageName);
            this.a.a("versioncode", new StringBuilder(String.valueOf(TbadkApplication.m252getInst().getVersionCode())).toString());
            this.a.a("signmd5", UtilHelper.creatSignInt(TbadkApplication.m252getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.a.a("md5", bc.a());
            String i = this.a.i();
            if (this.a.c()) {
                ai.c().F();
            }
            if (this.a.a().b().b()) {
                bdVar = new bd();
                try {
                    bdVar.a(i);
                    if (TbadkApplication.getClientId() == null && bdVar.d().a() != null && bdVar.d().a().length() > 0) {
                        TbadkApplication.saveClientId(this.b, bdVar.d().a());
                        TbadkApplication.setClientId(bdVar.d().a());
                    }
                    TiebaSyncService.mStatistics = null;
                    return bdVar;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    return bdVar;
                }
            }
            return null;
        } catch (Exception e3) {
            bdVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.mSyncTask = null;
        if (this.a != null) {
            this.a.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(bd bdVar) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        bd bdVar2;
        int y;
        bd bdVar3;
        bd bdVar4;
        bd bdVar5;
        bd bdVar6;
        bd bdVar7;
        bd bdVar8;
        bd bdVar9;
        bd bdVar10;
        bd bdVar11;
        super.onPostExecute(bdVar);
        this.b.mSyncTask = null;
        if (bdVar != null) {
            com.baidu.tbadk.b.a.a().b();
            this.b.mModel = bdVar;
            bdVar2 = this.b.mModel;
            if (bdVar2.c().hasNewVer()) {
                ai c = ai.c();
                bdVar3 = this.b.mModel;
                c.a(bdVar3.c());
                this.b.broadcastNewVersion();
                bdVar4 = this.b.mModel;
                if (bdVar4.c().forceUpdate()) {
                    bdVar9 = this.b.mModel;
                    if (bdVar9.a() != null) {
                        Application d = ai.c().d();
                        bdVar10 = this.b.mModel;
                        VersionData c2 = bdVar10.c();
                        bdVar11 = this.b.mModel;
                        UpdateDialog.a(d, c2, bdVar11.b());
                    }
                } else if (Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(TbadkApplication.m252getInst().getUpdateNotifyTime()).longValue() > 86400000) {
                    bdVar5 = this.b.mModel;
                    if (bdVar5.c().getStrategy() == 0) {
                        bdVar6 = this.b.mModel;
                        if (bdVar6.a() != null) {
                            Application d2 = ai.c().d();
                            bdVar7 = this.b.mModel;
                            VersionData c3 = bdVar7.c();
                            bdVar8 = this.b.mModel;
                            UpdateDialog.a(d2, c3, bdVar8.b());
                        }
                    }
                }
            }
            ai.c().G();
            int nextInt = new Random().nextInt(TbConfig.BIG_IMAGE_MIN_CAPACITY) + 1;
            int a = bdVar.a().a();
            if (a > 0 && nextInt % a == 0 && (y = ai.c().y()) < 10) {
                ai.c().d(y + 1);
                com.baidu.tieba.util.r.a(this.b);
            }
            if (!TbadkApplication.m252getInst().isHao123HelperShouldOpen() && TbadkApplication.m252getInst().isTiebaHelperOpen()) {
                TbadkApplication.m252getInst().setTiebaHelperOpen(false);
                Hao123Plugin hao123Plugin = (Hao123Plugin) com.baidu.tbadk.tbplugin.m.a().b(Hao123Plugin.class);
                if (hao123Plugin != null) {
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
