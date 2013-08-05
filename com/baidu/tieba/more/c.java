package com.baidu.tieba.more;

import android.os.Build;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.ca;
import com.baidu.tieba.util.am;
import com.slidingmenu.lib.R;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.u f1409a;
    final /* synthetic */ AboutActivity b;

    private c(AboutActivity aboutActivity) {
        this.b = aboutActivity;
        this.f1409a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(AboutActivity aboutActivity, c cVar) {
        this(aboutActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        super.b();
        progressBar = this.b.j;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ca a(String... strArr) {
        ca caVar;
        Exception e;
        try {
            this.f1409a = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/s/sync");
            this.f1409a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(am.a(TiebaApplication.f())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(am.b(TiebaApplication.f())));
            this.f1409a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.f().S() > 0) {
                this.f1409a.a("_msg_status", "0");
            } else {
                this.f1409a.a("_msg_status", "1");
            }
            String k = this.f1409a.k();
            if (!this.f1409a.d()) {
                return null;
            }
            caVar = new ca();
            try {
                caVar.a(k);
                if (TiebaApplication.Q() == null && caVar.d().a() != null && caVar.d().a().length() > 0) {
                    TiebaApplication.a(this.b, caVar.d().a());
                    TiebaApplication.k(caVar.d().a());
                    return caVar;
                }
                return caVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
                return caVar;
            }
        } catch (Exception e3) {
            caVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.b.e = null;
        if (this.f1409a != null) {
            this.f1409a.i();
        }
        super.cancel(true);
        progressBar = this.b.j;
        progressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ca caVar) {
        ProgressBar progressBar;
        ca caVar2;
        ca caVar3;
        ca caVar4;
        ca caVar5;
        ca caVar6;
        ca caVar7;
        ca caVar8;
        super.a((Object) caVar);
        progressBar = this.b.j;
        progressBar.setVisibility(8);
        this.b.e = null;
        if (caVar != null) {
            this.b.f = caVar;
            TiebaApplication f = TiebaApplication.f();
            caVar2 = this.b.f;
            f.a(caVar2.c());
            TiebaApplication.f().v(false);
            caVar3 = this.b.f;
            if (caVar3.c().getHas_new_ver() == 1) {
                caVar4 = this.b.f;
                if (caVar4.c().getForce_update() == 1) {
                    TiebaApplication f2 = TiebaApplication.f();
                    caVar7 = this.b.f;
                    VersionData c = caVar7.c();
                    caVar8 = this.b.f;
                    UpdateDialog.a(f2, c, caVar8.b());
                    return;
                }
                TiebaApplication.f().b(Long.valueOf(new Date().getTime()).longValue());
                TiebaApplication f3 = TiebaApplication.f();
                caVar5 = this.b.f;
                VersionData c2 = caVar5.c();
                caVar6 = this.b.f;
                UpdateDialog.a(f3, c2, caVar6.b());
                return;
            }
            this.b.a(this.b.getResources().getString(R.string.neednot_update));
            return;
        }
        this.b.a(this.b.getResources().getString(R.string.neterror));
    }
}
