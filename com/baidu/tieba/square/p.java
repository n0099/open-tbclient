package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p extends BdAsyncTask<Object, Integer, t> {
    final /* synthetic */ BarFolderSecondDirActivity a;
    private com.baidu.tieba.util.ba b;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ t a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(t tVar) {
        this.a.a(tVar, false);
    }

    private p(BarFolderSecondDirActivity barFolderSecondDirActivity) {
        this.a = barFolderSecondDirActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(BarFolderSecondDirActivity barFolderSecondDirActivity, byte b) {
        this(barFolderSecondDirActivity);
    }

    private t d() {
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
            String l = this.b.l();
            if (this.b.c()) {
                a.b(l);
            } else {
                a.a(this.b.i());
            }
        } catch (Exception e) {
            a.a(e.getMessage());
            com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return a;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        this.a.a(null, true);
    }
}
