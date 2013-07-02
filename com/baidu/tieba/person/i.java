package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask {
    final /* synthetic */ EditBarActivity a;
    private com.baidu.tieba.util.r b;

    private i(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(EditBarActivity editBarActivity, i iVar) {
        this(editBarActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(com.baidu.tieba.data.r... rVarArr) {
        com.baidu.tieba.data.r rVar = rVarArr[0];
        if (rVar != null) {
            try {
                if (rVar.a() != null && rVar.b() != null) {
                    this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/c/forum/unfavolike");
                    this.b.a("fid", rVar.a());
                    this.b.a("kw", rVar.b());
                    this.b.a("favo_type", String.valueOf(rVar.j()));
                    this.b.d(true);
                    this.b.j();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
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
        this.a.k = null;
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        if (this.b != null) {
            if (this.b.c()) {
                bVar = this.a.a;
                ArrayList a = bVar.a();
                if (a != null) {
                    i = this.a.j;
                    if (i >= 0) {
                        i2 = this.a.j;
                        if (i2 < a.size()) {
                            i3 = this.a.j;
                            a.remove(i3);
                            jVar = this.a.e;
                            if (jVar != null) {
                                this.a.m();
                                jVar2 = this.a.e;
                                jVar2.notifyDataSetChanged();
                            }
                        }
                    }
                }
                TiebaApplication.f().i(true);
                this.a.a(this.a.getString(R.string.success));
                return;
            }
            this.a.a(this.b.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        progressBar = this.a.f;
        progressBar.setVisibility(0);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        this.a.k = null;
        super.cancel(true);
    }
}
