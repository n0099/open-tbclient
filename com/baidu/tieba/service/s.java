package com.baidu.tieba.service;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.br;
import com.baidu.tieba.util.ab;
import com.baidu.tieba.util.z;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.r f1421a;
    final /* synthetic */ TiebaSyncService b;

    private s(TiebaSyncService tiebaSyncService) {
        this.b = tiebaSyncService;
        this.f1421a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(TiebaSyncService tiebaSyncService, s sVar) {
        this(tiebaSyncService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public br a(String... strArr) {
        br brVar;
        Exception e;
        try {
            this.f1421a = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/s/sync");
            this.f1421a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(ab.a(TiebaApplication.f())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(ab.b(TiebaApplication.f())));
            this.f1421a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.f().R() > 0) {
                this.f1421a.a("_msg_status", "0");
            } else {
                this.f1421a.a("_msg_status", "1");
            }
            String aJ = TiebaApplication.f().aJ();
            if (aJ != null) {
                if (aJ.length() < 1) {
                    aJ = "0";
                }
                this.f1421a.a("_active", aJ);
            }
            this.f1421a.a("_pic_quality", String.valueOf(TiebaApplication.f().ao()));
            String j = this.f1421a.j();
            if (this.f1421a.d()) {
                TiebaApplication.f().aK();
            }
            if (!this.f1421a.c()) {
                return null;
            }
            brVar = new br();
            try {
                brVar.a(j);
                if (TiebaApplication.P() == null && brVar.d().a() != null && brVar.d().a().length() > 0) {
                    TiebaApplication.a(this.b, brVar.d().a());
                    TiebaApplication.k(brVar.d().a());
                    return brVar;
                }
                return brVar;
            } catch (Exception e2) {
                e = e2;
                z.b(getClass().getName(), "doInBackground", e.getMessage());
                return brVar;
            }
        } catch (Exception e3) {
            brVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.f1402a = null;
        if (this.f1421a != null) {
            this.f1421a.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(br brVar) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        br brVar2;
        int av;
        br brVar3;
        br brVar4;
        br brVar5;
        br brVar6;
        br brVar7;
        br brVar8;
        super.a((Object) brVar);
        this.b.f1402a = null;
        if (brVar != null) {
            this.b.c = brVar;
            brVar2 = this.b.c;
            if (brVar2.c().getHas_new_ver() == 1) {
                TiebaApplication f = TiebaApplication.f();
                brVar3 = this.b.c;
                f.a(brVar3.c());
                this.b.b();
                brVar4 = this.b.c;
                if (brVar4.c().getForce_update() == 1) {
                    TiebaApplication f2 = TiebaApplication.f();
                    brVar7 = this.b.c;
                    VersionData c = brVar7.c();
                    brVar8 = this.b.c;
                    UpdateDialog.a(f2, c, brVar8.b());
                } else {
                    Long valueOf = Long.valueOf(TiebaApplication.f().K());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if (valueOf2.longValue() - valueOf.longValue() > 86400000) {
                        TiebaApplication.f().c(valueOf2.longValue());
                        TiebaApplication f3 = TiebaApplication.f();
                        brVar5 = this.b.c;
                        VersionData c2 = brVar5.c();
                        brVar6 = this.b.c;
                        UpdateDialog.a(f3, c2, brVar6.b());
                    }
                }
            }
            int nextInt = new Random().nextInt(VersionUtils.CUR_DEVELOPMENT) + 1;
            int a2 = brVar.a().a();
            if (a2 > 0 && nextInt % a2 == 0 && (av = TiebaApplication.f().av()) < 10) {
                TiebaApplication.f().m(av + 1);
                ab.e(this.b);
            }
            this.b.stopSelf();
            return;
        }
        TiebaSyncService tiebaSyncService = this.b;
        i = tiebaSyncService.b;
        tiebaSyncService.b = i + 1;
        i2 = this.b.b;
        if (i2 < 10) {
            handler = this.b.d;
            runnable = this.b.e;
            handler.removeCallbacks(runnable);
            handler2 = this.b.d;
            runnable2 = this.b.e;
            handler2.postDelayed(runnable2, 60000L);
            return;
        }
        this.b.stopSelf();
    }
}
