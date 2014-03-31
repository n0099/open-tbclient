package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p extends BdAsyncTask<Object, Integer, t> {
    final /* synthetic */ BarFolderSecondDirActivity a;
    private com.baidu.tbadk.core.util.ak b;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ t a(Object... objArr) {
        return a();
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

    private t a() {
        q qVar;
        String str;
        String str2;
        String str3;
        qVar = this.a.i;
        t a = qVar.a();
        try {
            this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/forum/seconddir");
            com.baidu.tbadk.core.util.ak akVar = this.b;
            str = this.a.k;
            akVar.a("menu_name", str);
            com.baidu.tbadk.core.util.ak akVar2 = this.b;
            str2 = this.a.l;
            akVar2.a("menu_type", str2);
            com.baidu.tbadk.core.util.ak akVar3 = this.b;
            str3 = this.a.m;
            akVar3.a("menu_id", str3);
            String i = this.b.i();
            if (this.b.a().b().b()) {
                a.b(i);
            } else {
                a.a(this.b.f());
            }
        } catch (Exception e) {
            a.a(e.getMessage());
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return a;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.a(null, true);
    }
}
