package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<Object, Integer, t> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BarFolderSecondDirActivity f2531a;
    private com.baidu.tieba.util.am b;

    private p(BarFolderSecondDirActivity barFolderSecondDirActivity) {
        this.f2531a = barFolderSecondDirActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(BarFolderSecondDirActivity barFolderSecondDirActivity, o oVar) {
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
        qVar = this.f2531a.i;
        t a2 = qVar.a();
        try {
            this.b = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/f/forum/seconddir");
            com.baidu.tieba.util.am amVar = this.b;
            str = this.f2531a.l;
            amVar.a("menu_name", str);
            com.baidu.tieba.util.am amVar2 = this.b;
            str2 = this.f2531a.m;
            amVar2.a("menu_type", str2);
            com.baidu.tieba.util.am amVar3 = this.b;
            str3 = this.f2531a.n;
            amVar3.a("menu_id", str3);
            String l = this.b.l();
            if (this.b.c()) {
                a2.b(l);
            } else {
                a2.a(this.b.i());
            }
        } catch (Exception e) {
            a2.a(e.getMessage());
            com.baidu.tieba.util.bd.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(t tVar) {
        this.f2531a.a(tVar, false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        this.f2531a.a(null, true);
    }
}
