package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1373a;
    private com.baidu.tieba.a.d b = null;
    private int c;

    public k(j jVar, int i) {
        this.f1373a = jVar;
        this.c = 1;
        this.c = i;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.q a(Object... objArr) {
        String str;
        boolean z;
        boolean z2;
        String i;
        com.baidu.tieba.data.q qVar = null;
        this.b = new com.baidu.tieba.a.d();
        if (this.c == 0) {
            z2 = this.f1373a.c;
            if (z2) {
                i = DatabaseService.e();
            } else {
                i = DatabaseService.i("0");
            }
            com.baidu.tieba.data.q qVar2 = new com.baidu.tieba.data.q();
            qVar2.a(i);
            if (!qVar2.e() || !qVar2.f()) {
                this.c = 1;
                str = i;
                qVar = qVar2;
            } else {
                return qVar2;
            }
        } else {
            str = null;
        }
        if (this.c == 1) {
            str = this.b.g();
        }
        if (this.b.c()) {
            qVar = new com.baidu.tieba.data.q();
            qVar.a(str);
            z = this.f1373a.c;
            if (z) {
                DatabaseService.e(str);
            } else {
                DatabaseService.b(str, "0");
            }
        }
        return qVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.f1373a.f1372a = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.q qVar) {
        l lVar;
        l lVar2;
        l lVar3;
        this.f1373a.f1372a = null;
        this.f1373a.b = qVar;
        lVar = this.f1373a.d;
        if (lVar != null) {
            if (this.c == 0 || this.b.c()) {
                lVar2 = this.f1373a.d;
                lVar2.a(true, null, qVar);
                return;
            }
            String d = this.b.d();
            lVar3 = this.f1373a.d;
            lVar3.a(false, d, qVar);
        }
    }
}
