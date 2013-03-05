package com.baidu.tieba.service;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.b.x;
import com.baidu.tieba.c.af;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.c.ai;
import com.baidu.tieba.c.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends AsyncTask {
    t a;
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
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public x doInBackground(String... strArr) {
        x xVar;
        Exception e;
        try {
            this.a = new t("http://c.tieba.baidu.com/c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(ai.a(TiebaApplication.b())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(ai.b(TiebaApplication.b())));
            this.a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.b().L() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", "1");
            }
            this.a.a("_pic_quality", String.valueOf(TiebaApplication.b().ac()));
            String i = this.a.i();
            if (!this.a.b()) {
                return null;
            }
            xVar = new x();
            try {
                xVar.a(i);
                if (TiebaApplication.J() == null && xVar.c().a() != null && xVar.c().a().length() > 0) {
                    TiebaApplication.a(this.b, xVar.c().a());
                    TiebaApplication.i(xVar.c().a());
                    return xVar;
                }
                return xVar;
            } catch (Exception e2) {
                e = e2;
                ag.b(getClass().getName(), "doInBackground", e.getMessage());
                return xVar;
            }
        } catch (Exception e3) {
            xVar = null;
            e = e3;
        }
    }

    public void a() {
        this.b.a = null;
        if (this.a != null) {
            this.a.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(x xVar) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        x xVar2;
        x xVar3;
        x xVar4;
        x xVar5;
        x xVar6;
        x xVar7;
        x xVar8;
        x xVar9;
        x xVar10;
        super.onPostExecute(xVar);
        this.b.a = null;
        if (xVar != null) {
            this.b.c = xVar;
            xVar2 = this.b.c;
            if (xVar2.a() != null) {
                xVar9 = this.b.c;
                if (xVar9.a().a() != null) {
                    Intent intent = new Intent("com.baidu.tieba.broadcast.lottery");
                    xVar10 = this.b.c;
                    intent.putExtra("lottery", xVar10.a().a());
                    TiebaApplication.b().sendBroadcast(intent);
                }
            }
            xVar3 = this.b.c;
            if (xVar3.b().e() == 1) {
                TiebaApplication b = TiebaApplication.b();
                xVar4 = this.b.c;
                b.a(xVar4.b());
                this.b.b();
                xVar5 = this.b.c;
                if (xVar5.b().b() != 1) {
                    xVar6 = this.b.c;
                    String c = xVar6.b().c();
                    if (af.a(c, TiebaApplication.b().F()) > 0) {
                        TiebaApplication.b().g(c);
                        TiebaApplication b2 = TiebaApplication.b();
                        xVar7 = this.b.c;
                        UpdateDialog.a(b2, xVar7.b());
                    }
                } else {
                    TiebaApplication b3 = TiebaApplication.b();
                    xVar8 = this.b.c;
                    UpdateDialog.a(b3, xVar8.b());
                }
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
