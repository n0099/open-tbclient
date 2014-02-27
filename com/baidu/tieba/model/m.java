package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.s> {
    final /* synthetic */ k a;
    private com.baidu.tieba.b.c b = null;
    private int c;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.data.s a(Object... objArr) {
        boolean z;
        boolean z2;
        com.baidu.tieba.data.s sVar = new com.baidu.tieba.data.s();
        this.b = new com.baidu.tieba.b.c();
        z = this.a.c;
        if (!z) {
            sVar.b(true);
            return sVar;
        }
        int i = this.c;
        if (i != 0) {
            if (i != 1) {
                return sVar;
            }
            if (UtilHelper.h(TiebaApplication.g().b().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                com.baidu.tieba.data.s sVar2 = new com.baidu.tieba.data.s();
                this.a.e = System.currentTimeMillis();
                String g = this.b.g();
                this.a.f = this.b.h();
                this.a.g = this.b.i();
                this.a.h = System.currentTimeMillis();
                if (this.b.c()) {
                    sVar2.a(g);
                    z2 = this.a.c;
                    if (z2) {
                        DatabaseService.b(g);
                        return sVar2;
                    }
                    return sVar2;
                }
                return sVar2;
            }
        }
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.data.s sVar) {
        n nVar;
        n nVar2;
        com.baidu.tieba.data.s sVar2;
        n nVar3;
        com.baidu.tieba.data.s sVar3;
        n nVar4;
        com.baidu.tieba.data.s sVar4 = sVar;
        this.a.a = null;
        this.a.b = sVar4;
        l lVar = new l(this.a);
        lVar.c = this.c;
        nVar = this.a.d;
        if (nVar != null) {
            if (this.c != 0 && (this.b == null || !this.b.c())) {
                sVar2 = this.a.b;
                if (sVar2 != null) {
                    sVar3 = this.a.b;
                    if (sVar3.f()) {
                        lVar.b = true;
                        lVar.d = sVar4;
                        nVar4 = this.a.d;
                        nVar4.a(lVar);
                        return;
                    }
                }
                String d = this.b != null ? this.b.d() : null;
                lVar.b = false;
                lVar.a = d;
                lVar.d = sVar4;
                nVar3 = this.a.d;
                nVar3.a(lVar);
                return;
            }
            lVar.b = true;
            lVar.d = sVar4;
            nVar2 = this.a.d;
            nVar2.a(lVar);
        }
    }

    public m(k kVar, int i) {
        this.a = kVar;
        this.c = 1;
        this.c = i;
        setPriority(3);
    }

    private com.baidu.tieba.data.s d() {
        boolean z;
        com.baidu.tieba.data.s sVar = new com.baidu.tieba.data.s();
        sVar.a(true);
        String str = null;
        z = this.a.c;
        if (z) {
            str = DatabaseService.b();
        }
        if (str != null) {
            sVar.a(str);
            if (sVar.f() && !sVar.g()) {
                sVar.e().c();
            }
        }
        return sVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel();
        this.a.a = null;
    }
}
