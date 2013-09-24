package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Object, String, com.baidu.tieba.model.d> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f1693a;
    private com.baidu.tieba.util.z b;

    private g(EditBarActivity editBarActivity) {
        this.f1693a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(EditBarActivity editBarActivity, g gVar) {
        this(editBarActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.model.d a(Object... objArr) {
        com.baidu.tieba.model.d dVar;
        Exception e;
        String str;
        String str2;
        String str3;
        String str4;
        com.baidu.adp.lib.cache.q<String> i;
        String a2;
        try {
            str = this.f1693a.o;
            if (str == null && (i = com.baidu.tieba.b.a.a().i()) != null && (a2 = i.a(TiebaApplication.C())) != null) {
                c((Object[]) new String[]{a2});
            }
            this.b = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/f/forum/like");
            str2 = this.f1693a.o;
            if (str2 != null) {
                com.baidu.tieba.util.z zVar = this.b;
                str4 = this.f1693a.o;
                zVar.a("uid", str4);
            }
            String j = this.b.j();
            if (!this.b.c()) {
                return null;
            }
            dVar = new com.baidu.tieba.model.d();
            try {
                dVar.a(j);
                str3 = this.f1693a.o;
                if (str3 == null) {
                    a(j);
                    return dVar;
                }
                return dVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", e.getMessage());
                return dVar;
            }
        } catch (Exception e3) {
            dVar = null;
            e = e3;
        }
    }

    private void a(String str) {
        com.baidu.adp.lib.cache.q<String> i;
        String C = TiebaApplication.C();
        if (C != null && (i = com.baidu.tieba.b.a.a().i()) != null) {
            i.a(C, str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(String... strArr) {
        com.baidu.tieba.model.d dVar;
        i iVar;
        i iVar2;
        ProgressBar progressBar;
        super.b((Object[]) strArr);
        String str = strArr[0];
        com.baidu.tieba.model.d dVar2 = new com.baidu.tieba.model.d();
        dVar2.a(str);
        dVar = this.f1693a.f1638a;
        dVar.a(dVar2.a());
        iVar = this.f1693a.f;
        if (iVar == null) {
            return;
        }
        this.f1693a.e();
        iVar2 = this.f1693a.f;
        iVar2.notifyDataSetChanged();
        progressBar = this.f1693a.g;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.d dVar) {
        ProgressBar progressBar;
        com.baidu.tieba.model.d dVar2;
        i iVar;
        i iVar2;
        progressBar = this.f1693a.g;
        progressBar.setVisibility(8);
        this.f1693a.j = null;
        if (this.b != null) {
            if (this.b.c() && dVar != null) {
                dVar2 = this.f1693a.f1638a;
                dVar2.a(dVar.a());
                iVar = this.f1693a.f;
                if (iVar == null) {
                    return;
                }
                this.f1693a.e();
                iVar2 = this.f1693a.f;
                iVar2.notifyDataSetChanged();
                return;
            }
            this.f1693a.a(this.b.g());
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        progressBar = this.f1693a.g;
        progressBar.setVisibility(8);
        this.f1693a.j = null;
        super.cancel(true);
    }
}
