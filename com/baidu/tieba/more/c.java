package com.baidu.tieba.more;

import android.os.Build;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.br;
import com.slidingmenu.lib.R;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask {
    com.baidu.tieba.util.r a;
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
    public br a(String... strArr) {
        br brVar;
        Exception e;
        try {
            this.a = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.tieba.util.ab.a(TiebaApplication.f())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.tieba.util.ab.b(TiebaApplication.f())));
            this.a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.f().R() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", "1");
            }
            String j = this.a.j();
            if (!this.a.c()) {
                return null;
            }
            brVar = new br();
            try {
                brVar.a(j);
                if (TiebaApplication.P() == null && brVar.d().a() != null && brVar.d().a().length() > 0) {
                    TiebaApplication.a(this.b, brVar.d().a());
                    TiebaApplication.k(brVar.d().a());
                    return brVar;
                }
                return brVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
                return brVar;
            }
        } catch (Exception e3) {
            brVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.b.e = null;
        if (this.a != null) {
            this.a.h();
        }
        super.cancel(true);
        progressBar = this.b.j;
        progressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(br brVar) {
        ProgressBar progressBar;
        br brVar2;
        br brVar3;
        br brVar4;
        br brVar5;
        br brVar6;
        br brVar7;
        br brVar8;
        super.a((Object) brVar);
        progressBar = this.b.j;
        progressBar.setVisibility(8);
        this.b.e = null;
        if (brVar != null) {
            this.b.f = brVar;
            TiebaApplication f = TiebaApplication.f();
            brVar2 = this.b.f;
            f.a(brVar2.c());
            TiebaApplication.f().v(false);
            brVar3 = this.b.f;
            if (brVar3.c().getHas_new_ver() == 1) {
                brVar4 = this.b.f;
                if (brVar4.c().getForce_update() == 1) {
                    TiebaApplication f2 = TiebaApplication.f();
                    brVar7 = this.b.f;
                    VersionData c = brVar7.c();
                    brVar8 = this.b.f;
                    UpdateDialog.a(f2, c, brVar8.b());
                    return;
                }
                TiebaApplication.f().c(Long.valueOf(new Date().getTime()).longValue());
                TiebaApplication f3 = TiebaApplication.f();
                brVar5 = this.b.f;
                VersionData c2 = brVar5.c();
                brVar6 = this.b.f;
                UpdateDialog.a(f3, c2, brVar6.b());
                return;
            }
            this.b.a(this.b.getResources().getString(R.string.neednot_update));
            return;
        }
        this.b.a(this.b.getResources().getString(R.string.neterror));
    }
}
