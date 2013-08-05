package com.baidu.tieba.service;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.ca;
import com.baidu.tieba.util.aj;
import com.baidu.tieba.util.am;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.u f1713a;
    final /* synthetic */ TiebaSyncService b;

    private s(TiebaSyncService tiebaSyncService) {
        this.b = tiebaSyncService;
        this.f1713a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(TiebaSyncService tiebaSyncService, s sVar) {
        this(tiebaSyncService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ca a(String... strArr) {
        ca caVar;
        Exception e;
        String str;
        String str2;
        try {
            this.f1713a = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/s/sync");
            this.f1713a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(am.a(TiebaApplication.f())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(am.b(TiebaApplication.f())));
            this.f1713a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.f().S() > 0) {
                this.f1713a.a("_msg_status", "0");
            } else {
                this.f1713a.a("_msg_status", "1");
            }
            String aN = TiebaApplication.f().aN();
            if (aN != null) {
                if (aN.length() < 1) {
                    aN = "0";
                }
                this.f1713a.a("_active", aN);
            }
            this.f1713a.a("_pic_quality", String.valueOf(TiebaApplication.f().ap()));
            str = TiebaSyncService.f1693a;
            if (str != null) {
                com.baidu.tieba.util.u uVar = this.f1713a;
                str2 = TiebaSyncService.f1693a;
                uVar.a("_msg_type", str2);
            }
            String k = this.f1713a.k();
            if (this.f1713a.e()) {
                TiebaApplication.f().aO();
            }
            if (this.f1713a.d()) {
                caVar = new ca();
                try {
                    caVar.a(k);
                    if (TiebaApplication.Q() == null && caVar.d().a() != null && caVar.d().a().length() > 0) {
                        TiebaApplication.a(this.b, caVar.d().a());
                        TiebaApplication.k(caVar.d().a());
                    }
                    TiebaSyncService.f1693a = null;
                    return caVar;
                } catch (Exception e2) {
                    e = e2;
                    aj.b(getClass().getName(), "doInBackground", e.getMessage());
                    return caVar;
                }
            }
            return null;
        } catch (Exception e3) {
            caVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.b = null;
        if (this.f1713a != null) {
            this.f1713a.i();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ca caVar) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        ca caVar2;
        int aw;
        ca caVar3;
        ca caVar4;
        ca caVar5;
        ca caVar6;
        ca caVar7;
        ca caVar8;
        super.a((Object) caVar);
        this.b.b = null;
        if (caVar != null) {
            this.b.d = caVar;
            caVar2 = this.b.d;
            if (caVar2.c().getHas_new_ver() == 1) {
                TiebaApplication f = TiebaApplication.f();
                caVar3 = this.b.d;
                f.a(caVar3.c());
                this.b.c();
                caVar4 = this.b.d;
                if (caVar4.c().getForce_update() == 1) {
                    TiebaApplication f2 = TiebaApplication.f();
                    caVar7 = this.b.d;
                    VersionData c = caVar7.c();
                    caVar8 = this.b.d;
                    UpdateDialog.a(f2, c, caVar8.b());
                } else {
                    Long valueOf = Long.valueOf(TiebaApplication.f().L());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if (valueOf2.longValue() - valueOf.longValue() > Util.MILLSECONDS_OF_DAY) {
                        TiebaApplication.f().b(valueOf2.longValue());
                        TiebaApplication f3 = TiebaApplication.f();
                        caVar5 = this.b.d;
                        VersionData c2 = caVar5.c();
                        caVar6 = this.b.d;
                        UpdateDialog.a(f3, c2, caVar6.b());
                    }
                }
            }
            int nextInt = new Random().nextInt(VersionUtils.CUR_DEVELOPMENT) + 1;
            int a2 = caVar.a().a();
            if (a2 > 0 && nextInt % a2 == 0 && (aw = TiebaApplication.f().aw()) < 10) {
                TiebaApplication.f().k(aw + 1);
                am.e(this.b);
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
            handler2.postDelayed(runnable2, Util.MILLSECONDS_OF_MINUTE);
            return;
        }
        this.b.stopSelf();
    }
}
