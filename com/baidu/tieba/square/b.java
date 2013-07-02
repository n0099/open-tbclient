package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.r;
import com.baidu.tieba.util.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask {
    final /* synthetic */ BarFolderFirstDirActivity a;
    private r b;

    private b(BarFolderFirstDirActivity barFolderFirstDirActivity) {
        this.a = barFolderFirstDirActivity;
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
    public f a(Object... objArr) {
        c cVar;
        cVar = this.a.k;
        f a = cVar.a();
        try {
            this.b = new r(String.valueOf(com.baidu.tieba.data.g.a) + "c/f/forum/forumdir");
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
    public void a(f fVar) {
        this.a.a(fVar, false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.a.a((f) null, true);
    }
}
