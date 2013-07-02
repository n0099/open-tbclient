package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.r;
import com.baidu.tieba.util.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask {
    final /* synthetic */ BarFolderSecondDirActivity a;
    private r b;

    private l(BarFolderSecondDirActivity barFolderSecondDirActivity) {
        this.a = barFolderSecondDirActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(BarFolderSecondDirActivity barFolderSecondDirActivity, l lVar) {
        this(barFolderSecondDirActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public p a(Object... objArr) {
        m mVar;
        String str;
        String str2;
        String str3;
        mVar = this.a.k;
        p a = mVar.a();
        try {
            this.b = new r(String.valueOf(com.baidu.tieba.data.g.a) + "c/f/forum/seconddir");
            r rVar = this.b;
            str = this.a.n;
            rVar.a("menu_name", str);
            r rVar2 = this.b;
            str2 = this.a.o;
            rVar2.a("menu_type", str2);
            r rVar3 = this.b;
            str3 = this.a.p;
            rVar3.a("menu_id", str3);
            String j = this.b.j();
            if (this.b.c()) {
                a.b(j);
            } else {
                a.a(this.b.g());
            }
        } catch (Exception e) {
            a.a(e.getMessage());
            z.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(p pVar) {
        this.a.a(pVar, false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.a.a((p) null, true);
    }
}
