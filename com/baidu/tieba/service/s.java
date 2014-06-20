package com.baidu.tieba.service;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.plugins.Hao123Plugin;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.ai;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.bc;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask<String, Integer, bc> {
    an a;
    final /* synthetic */ TiebaSyncService b;

    private s(TiebaSyncService tiebaSyncService) {
        this.b = tiebaSyncService;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(TiebaSyncService tiebaSyncService, s sVar) {
        this(tiebaSyncService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public bc doInBackground(String... strArr) {
        bc bcVar;
        Exception e;
        String str;
        String str2;
        try {
            this.a = new an(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.b(ai.c().d())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.c(ai.c().d())));
            this.a.a("_phone_screen", stringBuffer.toString());
            this.a.a("scr_w", String.valueOf(com.baidu.adp.lib.util.k.b(ai.c().d())));
            this.a.a("scr_h", String.valueOf(com.baidu.adp.lib.util.k.c(ai.c().d())));
            this.a.a("scr_dip", String.valueOf(com.baidu.adp.lib.util.k.d(ai.c().d())));
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
                an anVar = this.a;
                str2 = TiebaSyncService.mStatistics;
                anVar.a("_msg_type", str2);
            }
            String packageName = TbadkApplication.m252getInst().getPackageName();
            this.a.a("package", packageName);
            this.a.a("versioncode", new StringBuilder(String.valueOf(TbadkApplication.m252getInst().getVersionCode())).toString());
            this.a.a("signmd5", UtilHelper.creatSignInt(TbadkApplication.m252getInst().getPackageManager().getPackageInfo(packageName, 64)));
            this.a.a("md5", com.baidu.tieba.bc.a());
            String i = this.a.i();
            if (this.a.c()) {
                ai.c().F();
            }
            if (this.a.a().b().b()) {
                bcVar = new bc();
                try {
                    bcVar.a(i);
                    if (TbadkApplication.getClientId() == null && bcVar.d().a() != null && bcVar.d().a().length() > 0) {
                        TbadkApplication.saveClientId(this.b, bcVar.d().a());
                        TbadkApplication.setClientId(bcVar.d().a());
                    }
                    TiebaSyncService.mStatistics = null;
                    return bcVar;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
                    return bcVar;
                }
            }
            return null;
        } catch (Exception e3) {
            bcVar = null;
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
    public void onPostExecute(bc bcVar) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        bc bcVar2;
        int y;
        bc bcVar3;
        bc bcVar4;
        bc bcVar5;
        bc bcVar6;
        bc bcVar7;
        bc bcVar8;
        bc bcVar9;
        bc bcVar10;
        bc bcVar11;
        super.onPostExecute(bcVar);
        this.b.mSyncTask = null;
        if (bcVar != null) {
            com.baidu.tbadk.b.a.a().b();
            this.b.mModel = bcVar;
            bcVar2 = this.b.mModel;
            if (bcVar2.c().hasNewVer()) {
                ai c = ai.c();
                bcVar3 = this.b.mModel;
                c.a(bcVar3.c());
                this.b.broadcastNewVersion();
                bcVar4 = this.b.mModel;
                if (bcVar4.c().forceUpdate()) {
                    bcVar9 = this.b.mModel;
                    if (bcVar9.a() != null) {
                        Application d = ai.c().d();
                        bcVar10 = this.b.mModel;
                        VersionData c2 = bcVar10.c();
                        bcVar11 = this.b.mModel;
                        UpdateDialog.a(d, c2, bcVar11.b());
                    }
                } else if (Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(TbadkApplication.m252getInst().getUpdateNotifyTime()).longValue() > 86400000) {
                    bcVar5 = this.b.mModel;
                    if (bcVar5.c().getStrategy() == 0) {
                        bcVar6 = this.b.mModel;
                        if (bcVar6.a() != null) {
                            Application d2 = ai.c().d();
                            bcVar7 = this.b.mModel;
                            VersionData c3 = bcVar7.c();
                            bcVar8 = this.b.mModel;
                            UpdateDialog.a(d2, c3, bcVar8.b());
                        }
                    }
                }
            }
            ai.c().G();
            int nextInt = new Random().nextInt(TbConfig.BIG_IMAGE_MIN_CAPACITY) + 1;
            int a = bcVar.a().a();
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
