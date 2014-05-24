package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.n> {
    final /* synthetic */ o a;
    private com.baidu.tieba.a.a b = null;
    private int c;

    public q(o oVar, int i) {
        this.a = oVar;
        this.c = 1;
        this.c = i;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public com.baidu.tieba.data.n doInBackground(Object... objArr) {
        boolean z;
        com.baidu.tieba.data.n nVar = new com.baidu.tieba.data.n();
        this.b = new com.baidu.tieba.a.a();
        z = this.a.c;
        if (!z) {
            nVar.b(true);
            return nVar;
        }
        int i = this.c;
        if (i == 0) {
            return b();
        }
        if (i == 1) {
            if (UtilHelper.getNetStatusInfo(com.baidu.tieba.ai.c().d().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                return a();
            }
            return b();
        }
        return nVar;
    }

    private com.baidu.tieba.data.n a() {
        com.baidu.tieba.data.n nVar = new com.baidu.tieba.data.n();
        this.a.e = System.currentTimeMillis();
        String g = this.b.g();
        this.a.f = this.b.h();
        this.a.g = this.b.i();
        this.a.h = System.currentTimeMillis();
        if (this.b.c()) {
            nVar.a(g);
            a(g);
        }
        return nVar;
    }

    private com.baidu.tieba.data.n b() {
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
            if (nVar.h() && !nVar.i()) {
                nVar.g().c();
            }
        }
        return nVar;
    }

    private void a(String str) {
        boolean z;
        z = this.a.c;
        if (z) {
            com.baidu.tieba.util.k.a(str);
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
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.data.n nVar) {
        r rVar;
        r rVar2;
        com.baidu.tieba.data.n nVar2;
        r rVar3;
        com.baidu.tieba.data.n nVar3;
        r rVar4;
        this.a.a = null;
        this.a.b = nVar;
        p pVar = new p(this.a);
        pVar.c = this.c;
        rVar = this.a.d;
        if (rVar != null) {
            if (this.c != 0 && (this.b == null || !this.b.c())) {
                nVar2 = this.a.b;
                if (nVar2 != null) {
                    nVar3 = this.a.b;
                    if (nVar3.h()) {
                        pVar.b = true;
                        pVar.d = nVar;
                        rVar4 = this.a.d;
                        rVar4.a(pVar);
                        return;
                    }
                }
                String d = this.b != null ? this.b.d() : null;
                pVar.b = false;
                pVar.a = d;
                pVar.d = nVar;
                rVar3 = this.a.d;
                rVar3.a(pVar);
                return;
            }
            pVar.b = true;
            pVar.d = nVar;
            rVar2 = this.a.d;
            rVar2.a(pVar);
        }
    }
}
