package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BarFolderSecondDirActivity f1749a;
    private com.baidu.tieba.util.v b;

    private n(BarFolderSecondDirActivity barFolderSecondDirActivity) {
        this.f1749a = barFolderSecondDirActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(BarFolderSecondDirActivity barFolderSecondDirActivity, n nVar) {
        this(barFolderSecondDirActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public r a(Object... objArr) {
        o oVar;
        String str;
        String str2;
        String str3;
        oVar = this.f1749a.k;
        r a2 = oVar.a();
        try {
            this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/f/forum/seconddir");
            com.baidu.tieba.util.v vVar = this.b;
            str = this.f1749a.n;
            vVar.a("menu_name", str);
            com.baidu.tieba.util.v vVar2 = this.b;
            str2 = this.f1749a.o;
            vVar2.a("menu_type", str2);
            com.baidu.tieba.util.v vVar3 = this.b;
            str3 = this.f1749a.p;
            vVar3.a("menu_id", str3);
            String j = this.b.j();
            if (this.b.c()) {
                a2.b(j);
            } else {
                a2.a(this.b.g());
            }
        } catch (Exception e) {
            a2.a(e.getMessage());
            aq.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(r rVar) {
        this.f1749a.a(rVar, false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1749a.a((r) null, true);
    }
}
