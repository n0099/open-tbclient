package com.baidu.tieba.more;

import android.os.AsyncTask;
import android.os.Build;
import android.widget.ProgressBar;
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

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        super.onPreExecute();
        progressBar = this.b.j;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.v doInBackground(String... strArr) {
        com.baidu.tieba.b.v vVar;
        Exception e;
        try {
            this.a = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.tieba.c.ah.a(TiebaApplication.b())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.tieba.c.ah.b(TiebaApplication.b())));
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
            vVar = new com.baidu.tieba.b.v();
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
                com.baidu.tieba.c.af.b(getClass().getName(), "doInBackground", e.getMessage());
                return vVar;
            }
        } catch (Exception e3) {
            vVar = null;
            e = e3;
        }
    }

    public void a() {
        ProgressBar progressBar;
        this.b.g = null;
        if (this.a != null) {
            this.a.g();
        }
        super.cancel(true);
        progressBar = this.b.j;
        progressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.v vVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.v vVar2;
        com.baidu.tieba.b.v vVar3;
        com.baidu.tieba.b.v vVar4;
        com.baidu.tieba.b.v vVar5;
        com.baidu.tieba.b.v vVar6;
        super.onPostExecute(vVar);
        progressBar = this.b.j;
        progressBar.setVisibility(8);
        this.b.g = null;
        if (vVar != null) {
            this.b.h = vVar;
            TiebaApplication b = TiebaApplication.b();
            vVar2 = this.b.h;
            b.a(vVar2.a());
            TiebaApplication.b().r(false);
            vVar3 = this.b.h;
            if (vVar3.a().e() == 1) {
                vVar4 = this.b.h;
                if (vVar4.a().b() == 1) {
                    TiebaApplication b2 = TiebaApplication.b();
                    vVar6 = this.b.h;
                    UpdateDialog.a(b2, vVar6.a());
                    return;
                }
                TiebaApplication.b().c(Long.valueOf(new Date().getTime()).longValue());
                TiebaApplication b3 = TiebaApplication.b();
                vVar5 = this.b.h;
                UpdateDialog.a(b3, vVar5.a());
                return;
            }
            this.b.b(this.b.getResources().getString(R.string.neednot_update));
            return;
        }
        this.b.b(this.b.getResources().getString(R.string.neterror));
    }
}
