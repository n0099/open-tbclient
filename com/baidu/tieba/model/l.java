package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1410a;
    private com.baidu.tieba.a.d b = null;
    private int c;

    public l(j jVar, int i) {
        this.f1410a = jVar;
        this.c = 1;
        this.c = i;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.q a(Object... objArr) {
        boolean z;
        com.baidu.tieba.data.q qVar = new com.baidu.tieba.data.q();
        this.b = new com.baidu.tieba.a.d();
        z = this.f1410a.c;
        if (!z) {
            qVar.a(true);
            return qVar;
        }
        int i = this.c;
        if (i == 0) {
            return f();
        }
        if (i == 1) {
            if (UtilHelper.i(TiebaApplication.g().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                return e();
            }
            return f();
        }
        return qVar;
    }

    private com.baidu.tieba.data.q e() {
        com.baidu.tieba.data.q qVar = new com.baidu.tieba.data.q();
        String g = this.b.g();
        if (this.b.c()) {
            qVar.a(g);
            a(g);
        }
        return qVar;
    }

    private com.baidu.tieba.data.q f() {
        boolean z;
        com.baidu.tieba.data.q qVar = new com.baidu.tieba.data.q();
        String str = null;
        z = this.f1410a.c;
        if (z) {
            str = DatabaseService.d();
        }
        if (str != null) {
            qVar.a(str);
            if (qVar.b() && !qVar.c()) {
                qVar.a().b();
            }
        }
        return qVar;
    }

    private void a(String str) {
        boolean z;
        z = this.f1410a.c;
        if (z) {
            DatabaseService.e(str);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.f1410a.f1408a = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.q qVar) {
        m mVar;
        m mVar2;
        com.baidu.tieba.data.q qVar2;
        m mVar3;
        com.baidu.tieba.data.q qVar3;
        m mVar4;
        this.f1410a.f1408a = null;
        this.f1410a.b = qVar;
        k kVar = new k(this.f1410a);
        kVar.c = this.c;
        mVar = this.f1410a.d;
        if (mVar != null) {
            if (this.c != 0 && (this.b == null || !this.b.c())) {
                qVar2 = this.f1410a.b;
                if (qVar2 != null) {
                    qVar3 = this.f1410a.b;
                    if (qVar3.b()) {
                        kVar.b = true;
                        kVar.d = qVar;
                        mVar4 = this.f1410a.d;
                        mVar4.a(kVar);
                        return;
                    }
                }
                String d = this.b != null ? this.b.d() : null;
                kVar.b = false;
                kVar.f1409a = d;
                kVar.d = qVar;
                mVar3 = this.f1410a.d;
                mVar3.a(kVar);
                return;
            }
            kVar.b = true;
            kVar.d = qVar;
            mVar2 = this.f1410a.d;
            mVar2.a(kVar);
        }
    }
}
