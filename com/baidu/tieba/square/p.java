package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<Object, Integer, t> {
    final /* synthetic */ BarFolderSecondDirActivity a;
    private com.baidu.tieba.util.ba b;

    private p(BarFolderSecondDirActivity barFolderSecondDirActivity) {
        this.a = barFolderSecondDirActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(BarFolderSecondDirActivity barFolderSecondDirActivity, p pVar) {
        this(barFolderSecondDirActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public t a(Object... objArr) {
        q qVar;
        String str;
        String str2;
        String str3;
        qVar = this.a.i;
        t a = qVar.a();
        try {
            this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/forum/seconddir");
            com.baidu.tieba.util.ba baVar = this.b;
            str = this.a.l;
            baVar.a("menu_name", str);
            com.baidu.tieba.util.ba baVar2 = this.b;
            str2 = this.a.m;
            baVar2.a("menu_type", str2);
            com.baidu.tieba.util.ba baVar3 = this.b;
            str3 = this.a.n;
            baVar3.a("menu_id", str3);
            String m = this.b.m();
            if (this.b.d()) {
                a.b(m);
            } else {
                a.a(this.b.j());
            }
        } catch (Exception e) {
            a.a(e.getMessage());
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(t tVar) {
        this.a.a(tVar, false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.k();
            this.b = null;
        }
        this.a.a(null, true);
    }
}
