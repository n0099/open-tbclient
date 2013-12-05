package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Object, String, com.baidu.tieba.model.e> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f2353a;
    private com.baidu.tieba.util.am b;

    private g(EditBarActivity editBarActivity) {
        this.f2353a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(EditBarActivity editBarActivity, d dVar) {
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
    public com.baidu.tieba.model.e a(Object... objArr) {
        com.baidu.tieba.model.e eVar;
        Exception e;
        String str;
        String str2;
        String str3;
        String str4;
        com.baidu.adp.lib.cache.s<String> n;
        try {
            str = this.f2353a.o;
            if (str == null && (n = com.baidu.tieba.b.a.a().n()) != null) {
                c((Object[]) new String[]{n.a(TiebaApplication.B())});
            }
            this.b = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/f/forum/like");
            str2 = this.f2353a.o;
            if (str2 != null) {
                com.baidu.tieba.util.am amVar = this.b;
                str4 = this.f2353a.o;
                amVar.a("uid", str4);
            }
            String l = this.b.l();
            if (!this.b.c()) {
                return null;
            }
            eVar = new com.baidu.tieba.model.e();
            try {
                eVar.a(l);
                str3 = this.f2353a.o;
                if (str3 == null) {
                    a(l);
                    return eVar;
                }
                return eVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.bd.b(getClass().getName(), "doInBackground", e.getMessage());
                return eVar;
            }
        } catch (Exception e3) {
            eVar = null;
            e = e3;
        }
    }

    private void a(String str) {
        com.baidu.adp.lib.cache.s<String> n;
        String B = TiebaApplication.B();
        if (B != null && (n = com.baidu.tieba.b.a.a().n()) != null) {
            n.a(B, str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(String... strArr) {
        com.baidu.tieba.model.e eVar;
        i iVar;
        i iVar2;
        ProgressBar progressBar;
        super.b((Object[]) strArr);
        String str = strArr[0];
        com.baidu.tieba.model.e eVar2 = new com.baidu.tieba.model.e();
        eVar2.a(str);
        eVar = this.f2353a.f2290a;
        eVar.a(eVar2.a());
        iVar = this.f2353a.f;
        if (iVar != null) {
            this.f2353a.a(false);
            iVar2 = this.f2353a.f;
            iVar2.notifyDataSetChanged();
            progressBar = this.f2353a.g;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.e eVar) {
        ProgressBar progressBar;
        com.baidu.tieba.model.e eVar2;
        i iVar;
        i iVar2;
        progressBar = this.f2353a.g;
        progressBar.setVisibility(8);
        this.f2353a.h = null;
        if (this.b != null) {
            if (!this.b.c() || eVar == null) {
                this.f2353a.a(true);
                this.f2353a.showToast(this.b.i());
                return;
            }
            eVar2 = this.f2353a.f2290a;
            eVar2.a(eVar.a());
            iVar = this.f2353a.f;
            if (iVar != null) {
                this.f2353a.a(true);
                iVar2 = this.f2353a.f;
                iVar2.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        progressBar = this.f2353a.g;
        progressBar.setVisibility(8);
        this.f2353a.h = null;
        super.cancel(true);
    }
}
