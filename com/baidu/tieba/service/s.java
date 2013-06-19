package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.c.br;
import com.baidu.tieba.d.ad;
import com.baidu.tieba.d.ae;
import com.baidu.tieba.d.ag;
import java.util.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.lib.a.a {
    com.baidu.tieba.d.t a;
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
    @Override // com.baidu.adp.lib.a.a
    public br a(String... strArr) {
        br brVar;
        Exception e;
        try {
            this.a = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(ag.a(TiebaApplication.e())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(ag.b(TiebaApplication.e())));
            this.a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.e().Q() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", "1");
            }
            this.a.a("_pic_quality", String.valueOf(TiebaApplication.e().an()));
            String i = this.a.i();
            if (!this.a.b()) {
                return null;
            }
            brVar = new br();
            try {
                brVar.a(i);
                if (TiebaApplication.O() == null && brVar.c().a() != null && brVar.c().a().length() > 0) {
                    TiebaApplication.a(this.b, brVar.c().a());
                    TiebaApplication.i(brVar.c().a());
                    return brVar;
                }
                return brVar;
            } catch (Exception e2) {
                e = e2;
                ae.b(getClass().getName(), "doInBackground", e.getMessage());
                return brVar;
            }
        } catch (Exception e3) {
            brVar = null;
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
    public void a(br brVar) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        br brVar2;
        br brVar3;
        int au;
        br brVar4;
        br brVar5;
        br brVar6;
        br brVar7;
        br brVar8;
        br brVar9;
        br brVar10;
        super.a((Object) brVar);
        this.b.a = null;
        if (brVar != null) {
            this.b.c = brVar;
            brVar2 = this.b.c;
            if (brVar2.a() != null) {
                brVar9 = this.b.c;
                if (brVar9.a().b() != null) {
                    Intent intent = new Intent("com.baidu.tieba.broadcast.lottery");
                    brVar10 = this.b.c;
                    intent.putExtra("lottery", brVar10.a().b());
                    TiebaApplication.e().sendBroadcast(intent);
                }
            }
            brVar3 = this.b.c;
            if (brVar3.b().e() == 1) {
                TiebaApplication e = TiebaApplication.e();
                brVar4 = this.b.c;
                e.a(brVar4.b());
                this.b.b();
                brVar5 = this.b.c;
                if (brVar5.b().b() != 1) {
                    brVar6 = this.b.c;
                    String c = brVar6.b().c();
                    if (ad.a(c, TiebaApplication.e().K()) > 0) {
                        TiebaApplication.e().g(c);
                        TiebaApplication e2 = TiebaApplication.e();
                        brVar7 = this.b.c;
                        UpdateDialog.a(e2, brVar7.b());
                    }
                } else {
                    TiebaApplication e3 = TiebaApplication.e();
                    brVar8 = this.b.c;
                    UpdateDialog.a(e3, brVar8.b());
                }
            }
            int nextInt = new Random().nextInt(VersionUtils.CUR_DEVELOPMENT) + 1;
            int a = brVar.a().a();
            if (a > 0 && nextInt % a == 0 && (au = TiebaApplication.e().au()) < 10) {
                TiebaApplication.e().m(au + 1);
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
