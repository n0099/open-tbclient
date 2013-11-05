package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<Object, Integer, r> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BarFolderSecondDirActivity f2370a;
    private com.baidu.tieba.util.ag b;

    private n(BarFolderSecondDirActivity barFolderSecondDirActivity) {
        this.f2370a = barFolderSecondDirActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(BarFolderSecondDirActivity barFolderSecondDirActivity, m mVar) {
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
        oVar = this.f2370a.k;
        r a2 = oVar.a();
        try {
            this.b = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/f/forum/seconddir");
            com.baidu.tieba.util.ag agVar = this.b;
            str = this.f2370a.n;
            agVar.a("menu_name", str);
            com.baidu.tieba.util.ag agVar2 = this.b;
            str2 = this.f2370a.o;
            agVar2.a("menu_type", str2);
            com.baidu.tieba.util.ag agVar3 = this.b;
            str3 = this.f2370a.p;
            agVar3.a("menu_id", str3);
            String j = this.b.j();
            if (this.b.c()) {
                a2.b(j);
            } else {
                a2.a(this.b.g());
            }
        } catch (Exception e) {
            a2.a(e.getMessage());
            be.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(r rVar) {
        this.f2370a.a(rVar, false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f2370a.a((r) null, true);
    }
}
