package com.baidu.tieba.service;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.b.y;
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
    public y doInBackground(String... strArr) {
        y yVar;
        Exception e;
        try {
            this.a = new t("http://c.tieba.baidu.com/c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(ai.a(TiebaApplication.b())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(ai.b(TiebaApplication.b())));
            this.a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.b().M() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", "1");
            }
            this.a.a("_pic_quality", String.valueOf(TiebaApplication.b().ad()));
            String i = this.a.i();
            if (!this.a.b()) {
                return null;
            }
            yVar = new y();
            try {
                yVar.a(i);
                if (TiebaApplication.K() == null && yVar.c().a() != null && yVar.c().a().length() > 0) {
                    TiebaApplication.a(this.b, yVar.c().a());
                    TiebaApplication.i(yVar.c().a());
                    return yVar;
                }
                return yVar;
            } catch (Exception e2) {
                e = e2;
                ag.b(getClass().getName(), "doInBackground", e.getMessage());
                return yVar;
            }
        } catch (Exception e3) {
            yVar = null;
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
    public void onPostExecute(y yVar) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        y yVar2;
        y yVar3;
        y yVar4;
        y yVar5;
        y yVar6;
        y yVar7;
        y yVar8;
        y yVar9;
        y yVar10;
        super.onPostExecute(yVar);
        this.b.a = null;
        if (yVar != null) {
            this.b.c = yVar;
            yVar2 = this.b.c;
            if (yVar2.a() != null) {
                yVar9 = this.b.c;
                if (yVar9.a().a() != null) {
                    Intent intent = new Intent("com.baidu.tieba.broadcast.lottery");
                    yVar10 = this.b.c;
                    intent.putExtra("lottery", yVar10.a().a());
                    TiebaApplication.b().sendBroadcast(intent);
                }
            }
            yVar3 = this.b.c;
            if (yVar3.b().e() == 1) {
                TiebaApplication b = TiebaApplication.b();
                yVar4 = this.b.c;
                b.a(yVar4.b());
                this.b.b();
                yVar5 = this.b.c;
                if (yVar5.b().b() != 1) {
                    yVar6 = this.b.c;
                    String c = yVar6.b().c();
                    if (af.a(c, TiebaApplication.b().G()) > 0) {
                        TiebaApplication.b().g(c);
                        TiebaApplication b2 = TiebaApplication.b();
                        yVar7 = this.b.c;
                        UpdateDialog.a(b2, yVar7.b());
                    }
                } else {
                    TiebaApplication b3 = TiebaApplication.b();
                    yVar8 = this.b.c;
                    UpdateDialog.a(b3, yVar8.b());
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
