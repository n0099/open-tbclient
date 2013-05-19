package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.c.bo;
import com.baidu.tieba.d.ad;
import com.baidu.tieba.d.ae;
import com.baidu.tieba.d.ag;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.adp.lib.a.a {
    com.baidu.tieba.d.t a;
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
    @Override // com.baidu.adp.lib.a.a
    public bo a(String... strArr) {
        bo boVar;
        Exception e;
        try {
            this.a = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(ag.a(TiebaApplication.d())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(ag.b(TiebaApplication.d())));
            this.a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.d().N() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", "1");
            }
            this.a.a("_pic_quality", String.valueOf(TiebaApplication.d().ae()));
            String i = this.a.i();
            if (!this.a.b()) {
                return null;
            }
            boVar = new bo();
            try {
                boVar.a(i);
                if (TiebaApplication.L() == null && boVar.c().a() != null && boVar.c().a().length() > 0) {
                    TiebaApplication.a(this.b, boVar.c().a());
                    TiebaApplication.i(boVar.c().a());
                    return boVar;
                }
                return boVar;
            } catch (Exception e2) {
                e = e2;
                ae.b(getClass().getName(), "doInBackground", e.getMessage());
                return boVar;
            }
        } catch (Exception e3) {
            boVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        this.b.a = null;
        if (this.a != null) {
            this.a.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(bo boVar) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        bo boVar2;
        bo boVar3;
        int ak;
        bo boVar4;
        bo boVar5;
        bo boVar6;
        bo boVar7;
        bo boVar8;
        bo boVar9;
        bo boVar10;
        super.a((Object) boVar);
        this.b.a = null;
        if (boVar != null) {
            this.b.c = boVar;
            boVar2 = this.b.c;
            if (boVar2.a() != null) {
                boVar9 = this.b.c;
                if (boVar9.a().b() != null) {
                    Intent intent = new Intent("com.baidu.tieba.broadcast.lottery");
                    boVar10 = this.b.c;
                    intent.putExtra("lottery", boVar10.a().b());
                    TiebaApplication.d().sendBroadcast(intent);
                }
            }
            boVar3 = this.b.c;
            if (boVar3.b().e() == 1) {
                TiebaApplication d = TiebaApplication.d();
                boVar4 = this.b.c;
                d.a(boVar4.b());
                this.b.b();
                boVar5 = this.b.c;
                if (boVar5.b().b() != 1) {
                    boVar6 = this.b.c;
                    String c = boVar6.b().c();
                    if (ad.a(c, TiebaApplication.d().H()) > 0) {
                        TiebaApplication.d().g(c);
                        TiebaApplication d2 = TiebaApplication.d();
                        boVar7 = this.b.c;
                        UpdateDialog.a(d2, boVar7.b());
                    }
                } else {
                    TiebaApplication d3 = TiebaApplication.d();
                    boVar8 = this.b.c;
                    UpdateDialog.a(d3, boVar8.b());
                }
            }
            int abs = (Math.abs(new Random().nextInt()) % 10000) + 1;
            int a = boVar.a().a();
            if (a > 0 && abs % a == 0 && (ak = TiebaApplication.d().ak()) < 10) {
                TiebaApplication.d().k(ak + 1);
                ag.e(this.b);
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
