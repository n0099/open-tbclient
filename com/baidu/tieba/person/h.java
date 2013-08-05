package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f1604a;
    private com.baidu.tieba.util.u b;

    private h(EditBarActivity editBarActivity) {
        this.f1604a = editBarActivity;
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
        progressBar = this.f1604a.f;
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
            this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/f/forum/like");
            str = this.f1604a.o;
            if (str != null) {
                com.baidu.tieba.util.u uVar = this.b;
                str2 = this.f1604a.o;
                uVar.a("uid", str2);
            }
            String k = this.b.k();
            if (!this.b.d()) {
                return null;
            }
            bVar = new com.baidu.tieba.model.b();
            try {
                bVar.a(k);
                return bVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
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
        progressBar = this.f1604a.f;
        progressBar.setVisibility(8);
        this.f1604a.g = null;
        if (this.b != null) {
            if (this.b.d() && bVar != null) {
                bVar2 = this.f1604a.f1552a;
                bVar2.a(bVar.a());
                jVar = this.f1604a.e;
                if (jVar == null) {
                    return;
                }
                this.f1604a.k();
                jVar2 = this.f1604a.e;
                jVar2.notifyDataSetChanged();
                return;
            }
            this.f1604a.a(this.b.h());
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.i();
            this.b = null;
        }
        progressBar = this.f1604a.f;
        progressBar.setVisibility(8);
        this.f1604a.g = null;
        super.cancel(true);
    }
}
