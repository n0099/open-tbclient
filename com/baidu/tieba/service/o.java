package com.baidu.tieba.service;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.b.v;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.af;
import com.baidu.tieba.c.ah;
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
    public v doInBackground(String... strArr) {
        v vVar;
        Exception e;
        try {
            this.a = new t("http://c.tieba.baidu.com/c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(ah.a(TiebaApplication.b())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(ah.b(TiebaApplication.b())));
            this.a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.b().K() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", "1");
            }
            String i = this.a.i();
            if (!this.a.b()) {
                return null;
            }
            vVar = new v();
            try {
                vVar.a(i);
                if (TiebaApplication.I() == null && vVar.c().a() != null && vVar.c().a().length() > 0) {
                    TiebaApplication.a(this.b, vVar.c().a());
                    TiebaApplication.i(vVar.c().a());
                    return vVar;
                }
                return vVar;
            } catch (Exception e2) {
                e = e2;
                af.b(getClass().getName(), "doInBackground", e.getMessage());
                return vVar;
            }
        } catch (Exception e3) {
            vVar = null;
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
    public void onPostExecute(v vVar) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        v vVar2;
        v vVar3;
        v vVar4;
        v vVar5;
        v vVar6;
        v vVar7;
        v vVar8;
        v vVar9;
        v vVar10;
        super.onPostExecute(vVar);
        this.b.a = null;
        if (vVar != null) {
            this.b.c = vVar;
            vVar2 = this.b.c;
            if (vVar2.b() != null) {
                vVar9 = this.b.c;
                if (vVar9.b().a() != null) {
                    Intent intent = new Intent("com.baidu.tieba.broadcast.lottery");
                    vVar10 = this.b.c;
                    intent.putExtra("lottery", vVar10.b().a());
                    TiebaApplication.b().sendBroadcast(intent);
                }
            }
            vVar3 = this.b.c;
            if (vVar3.a().e() == 1) {
                TiebaApplication b = TiebaApplication.b();
                vVar4 = this.b.c;
                b.a(vVar4.a());
                this.b.b();
                vVar5 = this.b.c;
                if (vVar5.a().b() != 1) {
                    vVar6 = this.b.c;
                    String c = vVar6.a().c();
                    if (ae.a(c, TiebaApplication.b().E()) > 0) {
                        TiebaApplication.b().g(c);
                        TiebaApplication b2 = TiebaApplication.b();
                        vVar7 = this.b.c;
                        UpdateDialog.a(b2, vVar7.a());
                    }
                } else {
                    TiebaApplication b3 = TiebaApplication.b();
                    vVar8 = this.b.c;
                    UpdateDialog.a(b3, vVar8.a());
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
