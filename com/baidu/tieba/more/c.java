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
    public com.baidu.tieba.b.x doInBackground(String... strArr) {
        com.baidu.tieba.b.x xVar;
        Exception e;
        try {
            this.a = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.tieba.c.ai.a(TiebaApplication.b())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.tieba.c.ai.b(TiebaApplication.b())));
            this.a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.b().L() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", "1");
            }
            String i = this.a.i();
            if (!this.a.b()) {
                return null;
            }
            xVar = new com.baidu.tieba.b.x();
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
                com.baidu.tieba.c.ag.b(getClass().getName(), "doInBackground", e.getMessage());
                return xVar;
            }
        } catch (Exception e3) {
            xVar = null;
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
    public void onPostExecute(com.baidu.tieba.b.x xVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.x xVar2;
        com.baidu.tieba.b.x xVar3;
        com.baidu.tieba.b.x xVar4;
        com.baidu.tieba.b.x xVar5;
        com.baidu.tieba.b.x xVar6;
        super.onPostExecute(xVar);
        progressBar = this.b.j;
        progressBar.setVisibility(8);
        this.b.g = null;
        if (xVar != null) {
            this.b.h = xVar;
            TiebaApplication b = TiebaApplication.b();
            xVar2 = this.b.h;
            b.a(xVar2.b());
            TiebaApplication.b().r(false);
            xVar3 = this.b.h;
            if (xVar3.b().e() == 1) {
                xVar4 = this.b.h;
                if (xVar4.b().b() == 1) {
                    TiebaApplication b2 = TiebaApplication.b();
                    xVar6 = this.b.h;
                    UpdateDialog.a(b2, xVar6.b());
                    return;
                }
                TiebaApplication.b().d(Long.valueOf(new Date().getTime()).longValue());
                TiebaApplication b3 = TiebaApplication.b();
                xVar5 = this.b.h;
                UpdateDialog.a(b3, xVar5.b());
                return;
            }
            this.b.b(this.b.getResources().getString(R.string.neednot_update));
            return;
        }
        this.b.b(this.b.getResources().getString(R.string.neterror));
    }
}
