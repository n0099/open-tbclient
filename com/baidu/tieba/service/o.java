package com.baidu.tieba.service;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.bb;
import com.baidu.tieba.util.UtilHelper;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o extends BdAsyncTask<String, Integer, bb> {
    ak a;
    final /* synthetic */ TiebaSyncService b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ bb a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(bb bbVar) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        bb bbVar2;
        int w;
        bb bbVar3;
        bb bbVar4;
        bb bbVar5;
        bb bbVar6;
        bb bbVar7;
        bb bbVar8;
        bb bbVar9;
        bb bbVar10 = bbVar;
        super.a((o) bbVar10);
        this.b.b = null;
        if (bbVar10 == null) {
            TiebaSyncService tiebaSyncService = this.b;
            i = tiebaSyncService.c;
            tiebaSyncService.c = i + 1;
            i2 = this.b.c;
            if (i2 >= 10) {
                this.b.stopSelf();
                return;
            }
            handler = this.b.e;
            runnable = this.b.f;
            handler.removeCallbacks(runnable);
            handler2 = this.b.e;
            runnable2 = this.b.f;
            handler2.postDelayed(runnable2, 60000L);
            return;
        }
        this.b.d = bbVar10;
        bbVar2 = this.b.d;
        if (bbVar2.c().getHas_new_ver() == 1) {
            com.baidu.tieba.r c = com.baidu.tieba.r.c();
            bbVar3 = this.b.d;
            c.a(bbVar3.c());
            TiebaSyncService.c(this.b);
            bbVar4 = this.b.d;
            if (bbVar4.c().getForce_update() == 1) {
                com.baidu.tieba.r.c();
                Application d = com.baidu.tieba.r.d();
                bbVar8 = this.b.d;
                VersionData c2 = bbVar8.c();
                bbVar9 = this.b.d;
                UpdateDialog.a(d, c2, bbVar9.b());
            } else {
                TbadkApplication.j();
                if (Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(TbadkApplication.ay()).longValue() > 86400000) {
                    bbVar5 = this.b.d;
                    if (bbVar5.c().getStrategy() == 0) {
                        com.baidu.tieba.r.c();
                        Application d2 = com.baidu.tieba.r.d();
                        bbVar6 = this.b.d;
                        VersionData c3 = bbVar6.c();
                        bbVar7 = this.b.d;
                        UpdateDialog.a(d2, c3, bbVar7.b());
                    }
                }
            }
        }
        com.baidu.tieba.r.c();
        com.baidu.tieba.r.I();
        int nextInt = new Random().nextInt(10000) + 1;
        int a = bbVar10.a().a();
        if (a > 0 && nextInt % a == 0 && (w = com.baidu.tieba.r.c().w()) < 10) {
            com.baidu.tieba.r.c().e(w + 1);
            UtilHelper.takePerformanceSample(this.b);
        }
        this.b.stopSelf();
    }

    private o(TiebaSyncService tiebaSyncService) {
        this.b = tiebaSyncService;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(TiebaSyncService tiebaSyncService, byte b) {
        this(tiebaSyncService);
    }

    private bb a() {
        bb bbVar;
        Exception e;
        String str;
        String str2;
        try {
            this.a = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            com.baidu.tieba.r.c();
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.i.b(com.baidu.tieba.r.d())));
            stringBuffer.append(",");
            com.baidu.tieba.r.c();
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.i.c(com.baidu.tieba.r.d())));
            this.a.a("_phone_screen", stringBuffer.toString());
            ak akVar = this.a;
            com.baidu.tieba.r.c();
            akVar.a("scr_w", String.valueOf(com.baidu.adp.lib.util.i.b(com.baidu.tieba.r.d())));
            ak akVar2 = this.a;
            com.baidu.tieba.r.c();
            akVar2.a("scr_h", String.valueOf(com.baidu.adp.lib.util.i.c(com.baidu.tieba.r.d())));
            ak akVar3 = this.a;
            com.baidu.tieba.r.c();
            akVar3.a("scr_dip", String.valueOf(com.baidu.adp.lib.util.i.d(com.baidu.tieba.r.d())));
            if (TbadkApplication.j().ag() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", "1");
            }
            com.baidu.tieba.r.c();
            String D = com.baidu.tieba.r.D();
            if (D != null) {
                if (D.length() <= 0) {
                    D = "0";
                }
                this.a.a("_active", D);
            }
            this.a.a("_pic_quality", String.valueOf(TbadkApplication.j().al()));
            str = TiebaSyncService.a;
            if (str != null) {
                ak akVar4 = this.a;
                str2 = TiebaSyncService.a;
                akVar4.a("_msg_type", str2);
            }
            String i = this.a.i();
            if (this.a.c()) {
                com.baidu.tieba.r.c();
                com.baidu.tieba.r.G();
            }
            if (this.a.a().b().b()) {
                bbVar = new bb();
                try {
                    bbVar.a(i);
                    if (TbadkApplication.B() == null && bbVar.d().a() != null && bbVar.d().a().length() > 0) {
                        TiebaSyncService tiebaSyncService = this.b;
                        TbadkApplication.b(bbVar.d().a());
                        TbadkApplication.c(bbVar.d().a());
                    }
                    TiebaSyncService.a = null;
                    return bbVar;
                } catch (Exception e2) {
                    e = e2;
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
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
    public final void cancel() {
        this.b.b = null;
        if (this.a != null) {
            this.a.g();
        }
        super.cancel(true);
    }
}
