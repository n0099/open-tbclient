package com.baidu.tieba.service;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.c.t;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends AsyncTask {
    t a;
    final /* synthetic */ TiebaSyncService b;

    private n(TiebaSyncService tiebaSyncService) {
        this.b = tiebaSyncService;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(TiebaSyncService tiebaSyncService, n nVar) {
        this(tiebaSyncService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.t doInBackground(String... strArr) {
        com.baidu.tieba.b.t tVar;
        Exception e;
        try {
            this.a = new t("http://c.tieba.baidu.com/c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(ag.a(TiebaApplication.a())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(ag.b(TiebaApplication.a())));
            this.a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.a().G() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", "1");
            }
            String i = this.a.i();
            if (this.a.b()) {
                tVar = new com.baidu.tieba.b.t();
                try {
                    tVar.a(i);
                    if (TiebaApplication.E() != null || tVar.b().a() == null || tVar.b().a().length() <= 0) {
                        return tVar;
                    }
                    TiebaApplication.a(this.b, tVar.b().a());
                    TiebaApplication.h(tVar.b().a());
                    return tVar;
                } catch (Exception e2) {
                    e = e2;
                    ae.b(getClass().getName(), "doInBackground", e.getMessage());
                    return tVar;
                }
            }
            return null;
        } catch (Exception e3) {
            tVar = null;
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
    public void onPostExecute(com.baidu.tieba.b.t tVar) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        com.baidu.tieba.b.t tVar2;
        com.baidu.tieba.b.t tVar3;
        com.baidu.tieba.b.t tVar4;
        com.baidu.tieba.b.t tVar5;
        super.onPostExecute(tVar);
        this.b.a = null;
        if (tVar == null) {
            TiebaSyncService tiebaSyncService = this.b;
            i = tiebaSyncService.b;
            tiebaSyncService.b = i + 1;
            i2 = this.b.b;
            if (i2 >= 10) {
                this.b.stopSelf();
                return;
            }
            handler = this.b.d;
            runnable = this.b.e;
            handler.removeCallbacks(runnable);
            handler2 = this.b.d;
            runnable2 = this.b.e;
            handler2.postDelayed(runnable2, 60000L);
            return;
        }
        this.b.c = tVar;
        tVar2 = this.b.c;
        if (tVar2.a().e() == 1) {
            tVar3 = this.b.c;
            if (tVar3.a().b() == 1) {
                TiebaApplication a = TiebaApplication.a();
                tVar5 = this.b.c;
                UpdateDialog.a(a, tVar5.a());
            } else {
                Long valueOf = Long.valueOf(TiebaApplication.a().A());
                Long valueOf2 = Long.valueOf(new Date().getTime());
                if (valueOf2.longValue() - valueOf.longValue() > 86400000) {
                    TiebaApplication.a().c(valueOf2.longValue());
                    TiebaApplication a2 = TiebaApplication.a();
                    tVar4 = this.b.c;
                    UpdateDialog.a(a2, tVar4.a());
                }
            }
        }
        this.b.stopSelf();
    }
}
