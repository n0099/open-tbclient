package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Object, String, com.baidu.tieba.model.h> {
    final /* synthetic */ EditBarActivity a;
    private com.baidu.tieba.util.an b;

    private g(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
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
    public com.baidu.tieba.model.h a(Object... objArr) {
        com.baidu.tieba.model.h hVar;
        Exception e;
        String str;
        String str2;
        String str3;
        String str4;
        com.baidu.adp.lib.cache.s<String> n;
        try {
            str = this.a.o;
            if (str == null && (n = com.baidu.tieba.b.a.a().n()) != null) {
                c((Object[]) new String[]{n.a(TiebaApplication.B())});
            }
            this.b = new com.baidu.tieba.util.an(com.baidu.tieba.data.h.a + "c/f/forum/like");
            str2 = this.a.o;
            if (str2 != null) {
                com.baidu.tieba.util.an anVar = this.b;
                str4 = this.a.o;
                anVar.a("uid", str4);
            }
            String l = this.b.l();
            if (!this.b.c()) {
                return null;
            }
            hVar = new com.baidu.tieba.model.h();
            try {
                hVar.a(l);
                str3 = this.a.o;
                if (str3 == null) {
                    a(l);
                    return hVar;
                }
                return hVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.getMessage());
                return hVar;
            }
        } catch (Exception e3) {
            hVar = null;
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
        com.baidu.tieba.model.h hVar;
        i iVar;
        i iVar2;
        ProgressBar progressBar;
        super.b((Object[]) strArr);
        String str = strArr[0];
        com.baidu.tieba.model.h hVar2 = new com.baidu.tieba.model.h();
        hVar2.a(str);
        hVar = this.a.a;
        hVar.a(hVar2.a());
        iVar = this.a.f;
        if (iVar != null) {
            this.a.a(false);
            iVar2 = this.a.f;
            iVar2.notifyDataSetChanged();
            progressBar = this.a.g;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.h hVar) {
        ProgressBar progressBar;
        com.baidu.tieba.model.h hVar2;
        i iVar;
        i iVar2;
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        this.a.h = null;
        if (this.b != null) {
            if (!this.b.c() || hVar == null) {
                this.a.a(true);
                this.a.showToast(this.b.i());
                return;
            }
            hVar2 = this.a.a;
            hVar2.a(hVar.a());
            iVar = this.a.f;
            if (iVar != null) {
                this.a.a(true);
                iVar2 = this.a.f;
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
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        this.a.h = null;
        super.cancel(true);
    }
}
