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
    public com.baidu.tieba.b.y doInBackground(String... strArr) {
        com.baidu.tieba.b.y yVar;
        Exception e;
        try {
            this.a = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.tieba.c.ai.a(TiebaApplication.b())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.tieba.c.ai.b(TiebaApplication.b())));
            this.a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.b().M() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", "1");
            }
            String i = this.a.i();
            if (!this.a.b()) {
                return null;
            }
            yVar = new com.baidu.tieba.b.y();
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
                com.baidu.tieba.c.ag.b(getClass().getName(), "doInBackground", e.getMessage());
                return yVar;
            }
        } catch (Exception e3) {
            yVar = null;
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
    public void onPostExecute(com.baidu.tieba.b.y yVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.y yVar2;
        com.baidu.tieba.b.y yVar3;
        com.baidu.tieba.b.y yVar4;
        com.baidu.tieba.b.y yVar5;
        com.baidu.tieba.b.y yVar6;
        super.onPostExecute(yVar);
        progressBar = this.b.j;
        progressBar.setVisibility(8);
        this.b.g = null;
        if (yVar != null) {
            this.b.h = yVar;
            TiebaApplication b = TiebaApplication.b();
            yVar2 = this.b.h;
            b.a(yVar2.b());
            TiebaApplication.b().r(false);
            yVar3 = this.b.h;
            if (yVar3.b().e() == 1) {
                yVar4 = this.b.h;
                if (yVar4.b().b() == 1) {
                    TiebaApplication b2 = TiebaApplication.b();
                    yVar6 = this.b.h;
                    UpdateDialog.a(b2, yVar6.b());
                    return;
                }
                TiebaApplication.b().d(Long.valueOf(new Date().getTime()).longValue());
                TiebaApplication b3 = TiebaApplication.b();
                yVar5 = this.b.h;
                UpdateDialog.a(b3, yVar5.b());
                return;
            }
            this.b.b(this.b.getResources().getString(R.string.neednot_update));
            return;
        }
        this.b.b(this.b.getResources().getString(R.string.neterror));
    }
}
