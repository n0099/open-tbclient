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
    final /* synthetic */ EditBarActivity f1647a;
    private com.baidu.tieba.util.v b;

    private i(EditBarActivity editBarActivity) {
        this.f1647a = editBarActivity;
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
        String str;
        com.baidu.tieba.data.v vVar = vVarArr[0];
        if (vVar != null) {
            try {
                if (vVar.a() != null && vVar.b() != null) {
                    this.f1647a.k = vVar.b();
                    this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/forum/unfavolike");
                    this.b.a("fid", vVar.a());
                    com.baidu.tieba.util.v vVar2 = this.b;
                    str = this.f1647a.k;
                    vVar2.a("kw", str);
                    this.b.a("favo_type", String.valueOf(vVar.l()));
                    this.b.e(true);
                    this.b.j();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b(getClass().getName(), "doInBackground", e.getMessage());
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
        String str2;
        j jVar;
        j jVar2;
        super.a((Object) str);
        this.f1647a.l = null;
        progressBar = this.f1647a.f;
        progressBar.setVisibility(8);
        if (this.b != null) {
            if (this.b.c()) {
                bVar = this.f1647a.f1588a;
                ArrayList a2 = bVar.a();
                if (a2 != null) {
                    i = this.f1647a.j;
                    if (i >= 0) {
                        i2 = this.f1647a.j;
                        if (i2 < a2.size()) {
                            i3 = this.f1647a.j;
                            a2.remove(i3);
                            TiebaApplication g = TiebaApplication.g();
                            str2 = this.f1647a.k;
                            g.f(str2);
                            jVar = this.f1647a.e;
                            if (jVar != null) {
                                this.f1647a.k();
                                jVar2 = this.f1647a.e;
                                jVar2.notifyDataSetChanged();
                            }
                        }
                    }
                }
                this.f1647a.a(this.f1647a.getString(R.string.success));
                return;
            }
            this.f1647a.a(this.b.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        progressBar = this.f1647a.f;
        progressBar.setVisibility(0);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        progressBar = this.f1647a.f;
        progressBar.setVisibility(8);
        this.f1647a.l = null;
        super.cancel(true);
    }
}
