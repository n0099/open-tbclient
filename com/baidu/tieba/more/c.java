package com.baidu.tieba.more;

import android.os.Build;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.model.cc;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.aq;
import com.slidingmenu.lib.R;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.v f1444a;
    final /* synthetic */ AboutActivity b;

    private c(AboutActivity aboutActivity) {
        this.b = aboutActivity;
        this.f1444a = null;
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
    public cc a(String... strArr) {
        cc ccVar;
        Exception e;
        try {
            this.f1444a = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/sync");
            this.f1444a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(UtilHelper.a(TiebaApplication.g())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(UtilHelper.b(TiebaApplication.g())));
            this.f1444a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.g().S() > 0) {
                this.f1444a.a("_msg_status", "0");
            } else {
                this.f1444a.a("_msg_status", "1");
            }
            String j = this.f1444a.j();
            if (!this.f1444a.c()) {
                return null;
            }
            ccVar = new cc();
            try {
                ccVar.a(j);
                if (TiebaApplication.Q() == null && ccVar.d().a() != null && ccVar.d().a().length() > 0) {
                    TiebaApplication.a(this.b, ccVar.d().a());
                    TiebaApplication.n(ccVar.d().a());
                    return ccVar;
                }
                return ccVar;
            } catch (Exception e2) {
                e = e2;
                aq.b(getClass().getName(), "doInBackground", e.getMessage());
                return ccVar;
            }
        } catch (Exception e3) {
            ccVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.b.e = null;
        if (this.f1444a != null) {
            this.f1444a.h();
        }
        super.cancel(true);
        progressBar = this.b.j;
        progressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(cc ccVar) {
        ProgressBar progressBar;
        cc ccVar2;
        cc ccVar3;
        cc ccVar4;
        cc ccVar5;
        cc ccVar6;
        cc ccVar7;
        cc ccVar8;
        super.a((Object) ccVar);
        progressBar = this.b.j;
        progressBar.setVisibility(8);
        this.b.e = null;
        if (ccVar != null) {
            this.b.f = ccVar;
            TiebaApplication g = TiebaApplication.g();
            ccVar2 = this.b.f;
            g.a(ccVar2.c());
            TiebaApplication.g().u(false);
            ccVar3 = this.b.f;
            if (ccVar3.c().getHas_new_ver() == 1) {
                ccVar4 = this.b.f;
                if (ccVar4.c().getForce_update() == 1) {
                    TiebaApplication g2 = TiebaApplication.g();
                    ccVar7 = this.b.f;
                    VersionData c = ccVar7.c();
                    ccVar8 = this.b.f;
                    UpdateDialog.a(g2, c, ccVar8.b());
                    return;
                }
                TiebaApplication.g().b(Long.valueOf(new Date().getTime()).longValue());
                TiebaApplication g3 = TiebaApplication.g();
                ccVar5 = this.b.f;
                VersionData c2 = ccVar5.c();
                ccVar6 = this.b.f;
                UpdateDialog.a(g3, c2, ccVar6.b());
                return;
            }
            this.b.a(this.b.getResources().getString(R.string.neednot_update));
            return;
        }
        this.b.a(this.b.getResources().getString(R.string.neterror));
    }
}
