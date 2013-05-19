package com.baidu.tieba.more;

import android.os.Build;
import android.widget.ProgressBar;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.c.bo;
import com.slidingmenu.lib.R;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.a {
    com.baidu.tieba.d.t a;
    final /* synthetic */ AboutActivity b;

    private c(AboutActivity aboutActivity) {
        this.b = aboutActivity;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(AboutActivity aboutActivity, c cVar) {
        this(aboutActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        ProgressBar progressBar;
        super.b();
        progressBar = this.b.j;
        progressBar.setVisibility(0);
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
            stringBuffer.append(String.valueOf(com.baidu.tieba.d.ag.a(TiebaApplication.d())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.tieba.d.ag.b(TiebaApplication.d())));
            this.a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.d().N() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", "1");
            }
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
                com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                return boVar;
            }
        } catch (Exception e3) {
            boVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
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
    @Override // com.baidu.adp.lib.a.a
    public void a(bo boVar) {
        ProgressBar progressBar;
        bo boVar2;
        bo boVar3;
        bo boVar4;
        bo boVar5;
        bo boVar6;
        super.a((Object) boVar);
        progressBar = this.b.j;
        progressBar.setVisibility(8);
        this.b.g = null;
        if (boVar != null) {
            this.b.h = boVar;
            TiebaApplication d = TiebaApplication.d();
            boVar2 = this.b.h;
            d.a(boVar2.b());
            TiebaApplication.d().s(false);
            boVar3 = this.b.h;
            if (boVar3.b().e() == 1) {
                boVar4 = this.b.h;
                if (boVar4.b().b() == 1) {
                    TiebaApplication d2 = TiebaApplication.d();
                    boVar6 = this.b.h;
                    UpdateDialog.a(d2, boVar6.b());
                    return;
                }
                TiebaApplication.d().c(Long.valueOf(new Date().getTime()).longValue());
                TiebaApplication d3 = TiebaApplication.d();
                boVar5 = this.b.h;
                UpdateDialog.a(d3, boVar5.b());
                return;
            }
            this.b.a(this.b.getResources().getString(R.string.neednot_update));
            return;
        }
        this.b.a(this.b.getResources().getString(R.string.neterror));
    }
}
