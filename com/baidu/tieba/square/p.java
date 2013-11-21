package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<Object, Integer, t> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BarFolderSecondDirActivity f2414a;
    private com.baidu.tieba.util.ap b;

    private p(BarFolderSecondDirActivity barFolderSecondDirActivity) {
        this.f2414a = barFolderSecondDirActivity;
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
        qVar = this.f2414a.i;
        t a2 = qVar.a();
        try {
            this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1201a + "c/f/forum/seconddir");
            com.baidu.tieba.util.ap apVar = this.b;
            str = this.f2414a.l;
            apVar.a("menu_name", str);
            com.baidu.tieba.util.ap apVar2 = this.b;
            str2 = this.f2414a.m;
            apVar2.a("menu_type", str2);
            com.baidu.tieba.util.ap apVar3 = this.b;
            str3 = this.f2414a.n;
            apVar3.a("menu_id", str3);
            String j = this.b.j();
            if (this.b.c()) {
                a2.b(j);
            } else {
                a2.a(this.b.g());
            }
        } catch (Exception e) {
            a2.a(e.getMessage());
            com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(t tVar) {
        this.f2414a.a(tVar, false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f2414a.a(null, true);
    }
}
