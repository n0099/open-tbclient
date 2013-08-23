package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f1646a;
    private com.baidu.tieba.util.v b;

    private h(EditBarActivity editBarActivity) {
        this.f1646a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(EditBarActivity editBarActivity, h hVar) {
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
    public com.baidu.tieba.model.b a(Object... objArr) {
        com.baidu.tieba.model.b bVar;
        Exception e;
        String str;
        String str2;
        String str3;
        String str4;
        com.baidu.adp.lib.cache.q i;
        String str5;
        try {
            str = this.f1646a.p;
            if (str == null && (i = com.baidu.tieba.b.a.a().i()) != null && (str5 = (String) i.a(TiebaApplication.E())) != null) {
                c((Object[]) new String[]{str5});
            }
            this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/f/forum/like");
            str2 = this.f1646a.p;
            if (str2 != null) {
                com.baidu.tieba.util.v vVar = this.b;
                str4 = this.f1646a.p;
                vVar.a("uid", str4);
            }
            String j = this.b.j();
            if (!this.b.c()) {
                return null;
            }
            bVar = new com.baidu.tieba.model.b();
            try {
                bVar.a(j);
                str3 = this.f1646a.p;
                if (str3 == null) {
                    a(j);
                    return bVar;
                }
                return bVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.aq.b(getClass().getName(), "doInBackground", e.getMessage());
                return bVar;
            }
        } catch (Exception e3) {
            bVar = null;
            e = e3;
        }
    }

    private void a(String str) {
        com.baidu.adp.lib.cache.q i;
        String E = TiebaApplication.E();
        if (E != null && (i = com.baidu.tieba.b.a.a().i()) != null) {
            i.a(E, str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(String... strArr) {
        com.baidu.tieba.model.b bVar;
        j jVar;
        j jVar2;
        ProgressBar progressBar;
        super.b((Object[]) strArr);
        String str = strArr[0];
        com.baidu.tieba.model.b bVar2 = new com.baidu.tieba.model.b();
        bVar2.a(str);
        bVar = this.f1646a.f1588a;
        bVar.a(bVar2.a());
        jVar = this.f1646a.e;
        if (jVar == null) {
            return;
        }
        this.f1646a.k();
        jVar2 = this.f1646a.e;
        jVar2.notifyDataSetChanged();
        progressBar = this.f1646a.f;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.b bVar) {
        ProgressBar progressBar;
        com.baidu.tieba.model.b bVar2;
        j jVar;
        j jVar2;
        progressBar = this.f1646a.f;
        progressBar.setVisibility(8);
        this.f1646a.g = null;
        if (this.b != null) {
            if (this.b.c() && bVar != null) {
                bVar2 = this.f1646a.f1588a;
                bVar2.a(bVar.a());
                jVar = this.f1646a.e;
                if (jVar == null) {
                    return;
                }
                this.f1646a.k();
                jVar2 = this.f1646a.e;
                jVar2.notifyDataSetChanged();
                return;
            }
            this.f1646a.a(this.b.g());
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        progressBar = this.f1646a.f;
        progressBar.setVisibility(8);
        this.f1646a.g = null;
        super.cancel(true);
    }
}
