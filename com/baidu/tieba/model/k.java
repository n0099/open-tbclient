package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask {
    final /* synthetic */ j a;
    private com.baidu.tieba.a.d b = null;
    private int c;

    public k(j jVar, int i) {
        this.a = jVar;
        this.c = 1;
        this.c = i;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.m a(Object... objArr) {
        String str;
        boolean z;
        boolean z2;
        String i;
        com.baidu.tieba.data.m mVar = null;
        this.b = new com.baidu.tieba.a.d();
        if (this.c == 0) {
            z2 = this.a.c;
            if (z2) {
                i = DatabaseService.e();
            } else {
                i = DatabaseService.i("0");
            }
            com.baidu.tieba.data.m mVar2 = new com.baidu.tieba.data.m();
            mVar2.a(i);
            if (!mVar2.e() || !mVar2.f()) {
                this.c = 1;
                str = i;
                mVar = mVar2;
            } else {
                return mVar2;
            }
        } else {
            str = null;
        }
        if (this.c == 1) {
            str = this.b.d();
        }
        if (this.b.b()) {
            mVar = new com.baidu.tieba.data.m();
            mVar.a(str);
            z = this.a.c;
            if (z) {
                DatabaseService.e(str);
            } else {
                DatabaseService.b(str, "0");
            }
        }
        return mVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.a.a = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.m mVar) {
        l lVar;
        l lVar2;
        l lVar3;
        this.a.a = null;
        this.a.b = mVar;
        lVar = this.a.d;
        if (lVar != null) {
            if (this.c == 0 || this.b.b()) {
                lVar2 = this.a.d;
                lVar2.a(true, null, mVar);
                return;
            }
            String c = this.b != null ? this.b.c() : null;
            lVar3 = this.a.d;
            lVar3.a(false, c, mVar);
        }
    }
}
