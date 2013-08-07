package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f1603a;
    private com.baidu.tieba.util.u b;

    private i(EditBarActivity editBarActivity) {
        this.f1603a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(EditBarActivity editBarActivity, i iVar) {
        this(editBarActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(com.baidu.tieba.data.v... vVarArr) {
        com.baidu.tieba.data.v vVar = vVarArr[0];
        if (vVar != null) {
            try {
                if (vVar.a() != null && vVar.b() != null) {
                    this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/c/forum/unfavolike");
                    this.b.a("fid", vVar.a());
                    this.b.a("kw", vVar.b());
                    this.b.a("favo_type", String.valueOf(vVar.l()));
                    this.b.e(true);
                    this.b.k();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        com.baidu.tieba.model.b bVar;
        int i;
        int i2;
        int i3;
        j jVar;
        j jVar2;
        super.a((Object) str);
        this.f1603a.k = null;
        progressBar = this.f1603a.f;
        progressBar.setVisibility(8);
        if (this.b != null) {
            if (this.b.d()) {
                bVar = this.f1603a.f1550a;
                ArrayList a2 = bVar.a();
                if (a2 != null) {
                    i = this.f1603a.j;
                    if (i >= 0) {
                        i2 = this.f1603a.j;
                        if (i2 < a2.size()) {
                            i3 = this.f1603a.j;
                            a2.remove(i3);
                            jVar = this.f1603a.e;
                            if (jVar != null) {
                                this.f1603a.k();
                                jVar2 = this.f1603a.e;
                                jVar2.notifyDataSetChanged();
                            }
                        }
                    }
                }
                TiebaApplication.f().j(true);
                this.f1603a.a(this.f1603a.getString(R.string.success));
                return;
            }
            this.f1603a.a(this.b.h());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        progressBar = this.f1603a.f;
        progressBar.setVisibility(0);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.i();
            this.b = null;
        }
        progressBar = this.f1603a.f;
        progressBar.setVisibility(8);
        this.f1603a.k = null;
        super.cancel(true);
    }
}
