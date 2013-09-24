package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.q> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f1451a;
    private com.baidu.tieba.a.f b = null;
    private int c;

    public n(l lVar, int i) {
        this.f1451a = lVar;
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
        this.b = new com.baidu.tieba.a.f();
        z = this.f1451a.c;
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
        z = this.f1451a.c;
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
        z = this.f1451a.c;
        if (z) {
            DatabaseService.e(str);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.f1451a.f1449a = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.q qVar) {
        o oVar;
        o oVar2;
        com.baidu.tieba.data.q qVar2;
        o oVar3;
        com.baidu.tieba.data.q qVar3;
        o oVar4;
        this.f1451a.f1449a = null;
        this.f1451a.b = qVar;
        m mVar = new m(this.f1451a);
        mVar.c = this.c;
        oVar = this.f1451a.d;
        if (oVar != null) {
            if (this.c != 0 && (this.b == null || !this.b.c())) {
                qVar2 = this.f1451a.b;
                if (qVar2 != null) {
                    qVar3 = this.f1451a.b;
                    if (qVar3.b()) {
                        mVar.b = true;
                        mVar.d = qVar;
                        oVar4 = this.f1451a.d;
                        oVar4.a(mVar);
                        return;
                    }
                }
                String d = this.b != null ? this.b.d() : null;
                mVar.b = false;
                mVar.f1450a = d;
                mVar.d = qVar;
                oVar3 = this.f1451a.d;
                oVar3.a(mVar);
                return;
            }
            mVar.b = true;
            mVar.d = qVar;
            oVar2 = this.f1451a.d;
            oVar2.a(mVar);
        }
    }
}
