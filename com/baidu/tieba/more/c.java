package com.baidu.tieba.more;

import android.os.Build;
import android.widget.ProgressBar;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.c.br;
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
    public br a(String... strArr) {
        br brVar;
        Exception e;
        try {
            this.a = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.tieba.d.ag.a(TiebaApplication.e())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.tieba.d.ag.b(TiebaApplication.e())));
            this.a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.e().Q() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", "1");
            }
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
                com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                return brVar;
            }
        } catch (Exception e3) {
            brVar = null;
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
    public void a(br brVar) {
        ProgressBar progressBar;
        br brVar2;
        br brVar3;
        br brVar4;
        br brVar5;
        br brVar6;
        super.a((Object) brVar);
        progressBar = this.b.j;
        progressBar.setVisibility(8);
        this.b.g = null;
        if (brVar != null) {
            this.b.h = brVar;
            TiebaApplication e = TiebaApplication.e();
            brVar2 = this.b.h;
            e.a(brVar2.b());
            TiebaApplication.e().v(false);
            brVar3 = this.b.h;
            if (brVar3.b().e() == 1) {
                brVar4 = this.b.h;
                if (brVar4.b().b() == 1) {
                    TiebaApplication e2 = TiebaApplication.e();
                    brVar6 = this.b.h;
                    UpdateDialog.a(e2, brVar6.b());
                    return;
                }
                TiebaApplication.e().c(Long.valueOf(new Date().getTime()).longValue());
                TiebaApplication e3 = TiebaApplication.e();
                brVar5 = this.b.h;
                UpdateDialog.a(e3, brVar5.b());
                return;
            }
            this.b.a(this.b.getResources().getString(R.string.neednot_update));
            return;
        }
        this.b.a(this.b.getResources().getString(R.string.neterror));
    }
}
