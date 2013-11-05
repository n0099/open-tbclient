package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Object, String, com.baidu.tieba.model.e> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f2214a;
    private com.baidu.tieba.util.ag b;

    private g(EditBarActivity editBarActivity) {
        this.f2214a = editBarActivity;
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
        com.baidu.adp.lib.cache.s<String> j;
        String a2;
        try {
            str = this.f2214a.o;
            if (str == null && (j = com.baidu.tieba.b.a.a().j()) != null && (a2 = j.a(TiebaApplication.C())) != null) {
                c((Object[]) new String[]{a2});
            }
            this.b = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/f/forum/like");
            str2 = this.f2214a.o;
            if (str2 != null) {
                com.baidu.tieba.util.ag agVar = this.b;
                str4 = this.f2214a.o;
                agVar.a("uid", str4);
            }
            String j2 = this.b.j();
            if (!this.b.c()) {
                return null;
            }
            eVar = new com.baidu.tieba.model.e();
            try {
                eVar.a(j2);
                str3 = this.f2214a.o;
                if (str3 == null) {
                    a(j2);
                    return eVar;
                }
                return eVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.getMessage());
                return eVar;
            }
        } catch (Exception e3) {
            eVar = null;
            e = e3;
        }
    }

    private void a(String str) {
        com.baidu.adp.lib.cache.s<String> j;
        String C = TiebaApplication.C();
        if (C != null && (j = com.baidu.tieba.b.a.a().j()) != null) {
            j.a(C, str, 604800000L);
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
        eVar = this.f2214a.f2156a;
        eVar.a(eVar2.a());
        iVar = this.f2214a.f;
        if (iVar != null) {
            this.f2214a.e();
            iVar2 = this.f2214a.f;
            iVar2.notifyDataSetChanged();
            progressBar = this.f2214a.g;
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
        progressBar = this.f2214a.g;
        progressBar.setVisibility(8);
        this.f2214a.j = null;
        if (this.b != null) {
            if (this.b.c() && eVar != null) {
                eVar2 = this.f2214a.f2156a;
                eVar2.a(eVar.a());
                iVar = this.f2214a.f;
                if (iVar != null) {
                    this.f2214a.e();
                    iVar2 = this.f2214a.f;
                    iVar2.notifyDataSetChanged();
                    return;
                }
                return;
            }
            this.f2214a.a(this.b.g());
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        progressBar = this.f2214a.g;
        progressBar.setVisibility(8);
        this.f2214a.j = null;
        super.cancel(true);
    }
}
