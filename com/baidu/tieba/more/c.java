package com.baidu.tieba.more;

import android.os.AsyncTask;
import android.os.Build;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends AsyncTask {
    com.baidu.tieba.c.t a;
    final /* synthetic */ AboutActivity b;

    private c(AboutActivity aboutActivity) {
        this.b = aboutActivity;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(AboutActivity aboutActivity, c cVar) {
        this(aboutActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.t doInBackground(String... strArr) {
        com.baidu.tieba.b.t tVar;
        Exception e;
        try {
            this.a = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.tieba.c.ag.a(TiebaApplication.a())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.tieba.c.ag.b(TiebaApplication.a())));
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
                    com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
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
        this.b.e = null;
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
        com.baidu.tieba.b.t tVar2;
        com.baidu.tieba.b.t tVar3;
        com.baidu.tieba.b.t tVar4;
        com.baidu.tieba.b.t tVar5;
        super.onPostExecute(tVar);
        this.b.e = null;
        if (tVar != null) {
            this.b.f = tVar;
            tVar2 = this.b.f;
            if (tVar2.a().e() != 1) {
                this.b.b(this.b.getResources().getString(R.string.neednot_update));
                return;
            }
            tVar3 = this.b.f;
            if (tVar3.a().b() == 1) {
                TiebaApplication a = TiebaApplication.a();
                tVar5 = this.b.f;
                UpdateDialog.a(a, tVar5.a());
                return;
            }
            TiebaApplication.a().c(Long.valueOf(new Date().getTime()).longValue());
            TiebaApplication a2 = TiebaApplication.a();
            tVar4 = this.b.f;
            UpdateDialog.a(a2, tVar4.a());
        }
    }
}
