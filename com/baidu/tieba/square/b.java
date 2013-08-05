package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.aj;
import com.baidu.tieba.util.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BarFolderFirstDirActivity f1720a;
    private u b;

    private b(BarFolderFirstDirActivity barFolderFirstDirActivity) {
        this.f1720a = barFolderFirstDirActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(BarFolderFirstDirActivity barFolderFirstDirActivity, b bVar) {
        this(barFolderFirstDirActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public g a(Object... objArr) {
        c cVar;
        cVar = this.f1720a.k;
        g a2 = cVar.a();
        try {
            this.b = new u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/f/forum/forumdir");
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
    public void a(g gVar) {
        this.f1720a.a(gVar, false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.i();
            this.b = null;
        }
        this.f1720a.a((g) null, true);
    }
}
