package com.baidu.tieba.service;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.ad;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.bb;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BdAsyncTask<String, Integer, bb> {
    al a;
    final /* synthetic */ TiebaSyncService b;

    private o(TiebaSyncService tiebaSyncService) {
        this.b = tiebaSyncService;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(TiebaSyncService tiebaSyncService, o oVar) {
        this(tiebaSyncService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public bb doInBackground(String... strArr) {
        bb bbVar;
        Exception e;
        String str;
        String a;
        String str2;
        try {
            this.a = new al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.h.b(ad.c().d())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.h.c(ad.c().d())));
            this.a.a("_phone_screen", stringBuffer.toString());
            this.a.a("scr_w", String.valueOf(com.baidu.adp.lib.util.h.b(ad.c().d())));
            this.a.a("scr_h", String.valueOf(com.baidu.adp.lib.util.h.c(ad.c().d())));
            this.a.a("scr_dip", String.valueOf(com.baidu.adp.lib.util.h.d(ad.c().d())));
            if (TbadkApplication.m252getInst().getMsgFrequency() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            }
            String D = ad.c().D();
            if (D != null) {
                if (D.length() < 1) {
                    D = "0";
                }
                this.a.a("_active", D);
            }
            this.a.a("_pic_quality", String.valueOf(TbadkApplication.m252getInst().getViewImageQuality()));
            str = TiebaSyncService.a;
            if (str != null) {
                al alVar = this.a;
                str2 = TiebaSyncService.a;
                alVar.a("_msg_type", str2);
            }
            String packageName = TbadkApplication.m252getInst().getPackageName();
            this.a.a("package", packageName);
            int versionCode = TbadkApplication.m252getInst().getVersionCode();
            this.a.a("versioncode", new StringBuilder(String.valueOf(versionCode)).toString());
            this.a.a("signmd5", UtilHelper.creatSignInt(UtilHelper.getMd5(TbadkApplication.m252getInst().getPackageManager().getPackageInfo(packageName, 64))));
            a = this.b.a(versionCode);
            this.a.a("md5", a);
            String i = this.a.i();
            if (this.a.c()) {
                ad.c().F();
            }
            if (this.a.a().b().b()) {
                bbVar = new bb();
                try {
                    bbVar.a(i);
                    if (TbadkApplication.getClientId() == null && bbVar.d().a() != null && bbVar.d().a().length() > 0) {
                        TbadkApplication.saveClientId(this.b, bbVar.d().a());
                        TbadkApplication.setClientId(bbVar.d().a());
                    }
                    TiebaSyncService.a = null;
                    return bbVar;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
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
        this.b.b = null;
        if (this.a != null) {
            this.a.g();
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
        int y;
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
        this.b.b = null;
        if (bbVar != null) {
            this.b.d = bbVar;
            bbVar2 = this.b.d;
            if (bbVar2.c().hasNewVer()) {
                ad c = ad.c();
                bbVar3 = this.b.d;
                c.a(bbVar3.c());
                this.b.c();
                bbVar4 = this.b.d;
                if (bbVar4.c().forceUpdate()) {
                    bbVar9 = this.b.d;
                    if (bbVar9.a() != null) {
                        Application d = ad.c().d();
                        bbVar10 = this.b.d;
                        VersionData c2 = bbVar10.c();
                        bbVar11 = this.b.d;
                        UpdateDialog.a(d, c2, bbVar11.b());
                    }
                } else if (Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(TbadkApplication.m252getInst().getUpdateNotifyTime()).longValue() > 86400000) {
                    bbVar5 = this.b.d;
                    if (bbVar5.c().getStrategy() == 0) {
                        bbVar6 = this.b.d;
                        if (bbVar6.a() != null) {
                            Application d2 = ad.c().d();
                            bbVar7 = this.b.d;
                            VersionData c3 = bbVar7.c();
                            bbVar8 = this.b.d;
                            UpdateDialog.a(d2, c3, bbVar8.b());
                        }
                    }
                }
            }
            ad.c().G();
            int nextInt = new Random().nextInt(TbConfig.BIG_IMAGE_MIN_CAPACITY) + 1;
            int a = bbVar.a().a();
            if (a > 0 && nextInt % a == 0 && (y = ad.c().y()) < 10) {
                ad.c().d(y + 1);
                com.baidu.tieba.util.r.a(this.b);
            }
            this.b.stopSelf();
            return;
        }
        TiebaSyncService tiebaSyncService = this.b;
        i = tiebaSyncService.c;
        tiebaSyncService.c = i + 1;
        i2 = this.b.c;
        if (i2 < 10) {
            handler = this.b.e;
            runnable = this.b.f;
            handler.removeCallbacks(runnable);
            handler2 = this.b.e;
            runnable2 = this.b.f;
            handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
            return;
        }
        this.b.stopSelf();
    }
}
