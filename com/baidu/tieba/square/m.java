package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.aj;
import com.baidu.tieba.util.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BarFolderSecondDirActivity f1729a;
    private u b;

    private m(BarFolderSecondDirActivity barFolderSecondDirActivity) {
        this.f1729a = barFolderSecondDirActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(BarFolderSecondDirActivity barFolderSecondDirActivity, m mVar) {
        this(barFolderSecondDirActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public q a(Object... objArr) {
        n nVar;
        String str;
        String str2;
        String str3;
        nVar = this.f1729a.k;
        q a2 = nVar.a();
        try {
            this.b = new u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/f/forum/seconddir");
            u uVar = this.b;
            str = this.f1729a.n;
            uVar.a("menu_name", str);
            u uVar2 = this.b;
            str2 = this.f1729a.o;
            uVar2.a("menu_type", str2);
            u uVar3 = this.b;
            str3 = this.f1729a.p;
            uVar3.a("menu_id", str3);
            String k = this.b.k();
            if (this.b.d()) {
                a2.b(k);
            } else {
                a2.a(this.b.h());
            }
        } catch (Exception e) {
            a2.a(e.getMessage());
            aj.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(q qVar) {
        this.f1729a.a(qVar, false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.i();
            this.b = null;
        }
        this.f1729a.a((q) null, true);
    }
}
