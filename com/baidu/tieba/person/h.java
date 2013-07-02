package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask {
    final /* synthetic */ EditBarActivity a;
    private com.baidu.tieba.util.r b;

    private h(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(EditBarActivity editBarActivity, h hVar) {
        this(editBarActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        progressBar = this.a.f;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.model.b a(Object... objArr) {
        com.baidu.tieba.model.b bVar;
        Exception e;
        String str;
        String str2;
        try {
            this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/f/forum/like");
            str = this.a.o;
            if (str != null) {
                com.baidu.tieba.util.r rVar = this.b;
                str2 = this.a.o;
                rVar.a("uid", str2);
            }
            String j = this.b.j();
            if (!this.b.c()) {
                return null;
            }
            bVar = new com.baidu.tieba.model.b();
            try {
                bVar.a(j);
                return bVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
                return bVar;
            }
        } catch (Exception e3) {
            bVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.b bVar) {
        ProgressBar progressBar;
        com.baidu.tieba.model.b bVar2;
        j jVar;
        j jVar2;
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        this.a.g = null;
        if (this.b != null) {
            if (this.b.c() && bVar != null) {
                bVar2 = this.a.a;
                bVar2.a(bVar.a());
                jVar = this.a.e;
                if (jVar == null) {
                    return;
                }
                this.a.m();
                jVar2 = this.a.e;
                jVar2.notifyDataSetChanged();
                return;
            }
            this.a.a(this.b.g());
        }
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
        this.a.g = null;
        super.cancel(true);
    }
}
