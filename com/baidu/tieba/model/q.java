package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.n> {
    final /* synthetic */ o a;
    private com.baidu.tieba.b.a b = null;
    private int c;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.data.n a(Object... objArr) {
        boolean z;
        boolean z2;
        com.baidu.tieba.data.n nVar = new com.baidu.tieba.data.n();
        this.b = new com.baidu.tieba.b.a();
        z = this.a.c;
        if (!z) {
            nVar.b(true);
            return nVar;
        }
        int i = this.c;
        if (i != 0) {
            if (i != 1) {
                return nVar;
            }
            com.baidu.tieba.p.c();
            if (UtilHelper.d(com.baidu.tieba.p.d().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                com.baidu.tieba.data.n nVar2 = new com.baidu.tieba.data.n();
                this.a.e = System.currentTimeMillis();
                String g = this.b.g();
                this.a.f = this.b.h();
                this.a.g = this.b.i();
                this.a.h = System.currentTimeMillis();
                if (this.b.c()) {
                    nVar2.a(g);
                    z2 = this.a.c;
                    if (z2) {
                        com.baidu.tieba.util.k.a(g);
                        return nVar2;
                    }
                    return nVar2;
                }
                return nVar2;
            }
        }
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.data.n nVar) {
        r rVar;
        r rVar2;
        com.baidu.tieba.data.n nVar2;
        r rVar3;
        com.baidu.tieba.data.n nVar3;
        r rVar4;
        com.baidu.tieba.data.n nVar4 = nVar;
        this.a.a = null;
        this.a.b = nVar4;
        p pVar = new p(this.a);
        pVar.c = this.c;
        rVar = this.a.d;
        if (rVar != null) {
            if (this.c != 0 && (this.b == null || !this.b.c())) {
                nVar2 = this.a.b;
                if (nVar2 != null) {
                    nVar3 = this.a.b;
                    if (nVar3.g()) {
                        pVar.b = true;
                        pVar.d = nVar4;
                        rVar4 = this.a.d;
                        rVar4.a(pVar);
                        return;
                    }
                }
                String d = this.b != null ? this.b.d() : null;
                pVar.b = false;
                pVar.a = d;
                pVar.d = nVar4;
                rVar3 = this.a.d;
                rVar3.a(pVar);
                return;
            }
            pVar.b = true;
            pVar.d = nVar4;
            rVar2 = this.a.d;
            rVar2.a(pVar);
        }
    }

    public q(o oVar, int i) {
        this.a = oVar;
        this.c = 1;
        this.c = i;
        setPriority(3);
    }

    private com.baidu.tieba.data.n a() {
        boolean z;
        com.baidu.tieba.data.n nVar = new com.baidu.tieba.data.n();
        nVar.a(true);
        String str = null;
        z = this.a.c;
        if (z) {
            str = com.baidu.tieba.util.k.a();
        }
        if (str != null) {
            nVar.a(str);
            if (nVar.g() && !nVar.h()) {
                nVar.f().c();
            }
        }
        return nVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel();
        this.a.a = null;
    }
}
