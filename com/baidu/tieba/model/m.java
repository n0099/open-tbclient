package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.s> {
    final /* synthetic */ k a;
    private com.baidu.tieba.b.c b = null;
    private int c;

    public m(k kVar, int i) {
        this.a = kVar;
        this.c = 1;
        this.c = i;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.s a(Object... objArr) {
        boolean z;
        com.baidu.tieba.data.s sVar = new com.baidu.tieba.data.s();
        this.b = new com.baidu.tieba.b.c();
        z = this.a.c;
        if (!z) {
            sVar.b(true);
            return sVar;
        }
        int i = this.c;
        if (i == 0) {
            return f();
        }
        if (i == 1) {
            if (UtilHelper.h(TiebaApplication.g().b().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                return e();
            }
            return f();
        }
        return sVar;
    }

    private com.baidu.tieba.data.s e() {
        com.baidu.tieba.data.s sVar = new com.baidu.tieba.data.s();
        String g = this.b.g();
        if (this.b.c()) {
            sVar.a(g);
            a(g);
        }
        return sVar;
    }

    private com.baidu.tieba.data.s f() {
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

    private void a(String str) {
        boolean z;
        z = this.a.c;
        if (z) {
            DatabaseService.c(str);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.a.a = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.s sVar) {
        n nVar;
        n nVar2;
        com.baidu.tieba.data.s sVar2;
        n nVar3;
        com.baidu.tieba.data.s sVar3;
        n nVar4;
        this.a.a = null;
        this.a.b = sVar;
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
                        lVar.d = sVar;
                        nVar4 = this.a.d;
                        nVar4.a(lVar);
                        return;
                    }
                }
                String d = this.b != null ? this.b.d() : null;
                lVar.b = false;
                lVar.a = d;
                lVar.d = sVar;
                nVar3 = this.a.d;
                nVar3.a(lVar);
                return;
            }
            lVar.b = true;
            lVar.d = sVar;
            nVar2 = this.a.d;
            nVar2.a(lVar);
        }
    }
}
