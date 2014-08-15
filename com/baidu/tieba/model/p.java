package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.o> {
    final /* synthetic */ n a;
    private com.baidu.tieba.a.a b = null;
    private int c;

    public p(n nVar, int i) {
        this.a = nVar;
        this.c = 1;
        this.c = i;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public com.baidu.tieba.data.o doInBackground(Object... objArr) {
        boolean z;
        com.baidu.tieba.data.o oVar = new com.baidu.tieba.data.o();
        this.b = new com.baidu.tieba.a.a();
        z = this.a.c;
        if (!z) {
            oVar.b(true);
            return oVar;
        }
        int i = this.c;
        if (i == 0) {
            com.baidu.tieba.data.o b = b();
            BdLog.d("EnterForumTask,TYPE_DB,data.isEmpty=" + b.j());
            return b;
        } else if (i == 1) {
            if (UtilHelper.getNetStatusInfo(com.baidu.tieba.ai.c().d().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                com.baidu.tieba.data.o a = a();
                BdLog.d("EnterForumTask,TYPE_NET,netData.isEmpty=" + a.j());
                return a;
            }
            com.baidu.tieba.data.o b2 = b();
            BdLog.d("EnterForumTask,TYPE_NET,localData.isEmpty=" + b2.j());
            return b2;
        } else {
            return oVar;
        }
    }

    private com.baidu.tieba.data.o a() {
        com.baidu.tieba.data.o oVar = new com.baidu.tieba.data.o();
        this.a.e = System.currentTimeMillis();
        String g = this.b.g();
        this.a.f = this.b.h();
        this.a.g = this.b.i();
        this.a.h = System.currentTimeMillis();
        if (this.b.c()) {
            oVar.a(g);
            a(g);
        }
        return oVar;
    }

    private com.baidu.tieba.data.o b() {
        boolean z;
        com.baidu.tieba.data.o oVar = new com.baidu.tieba.data.o();
        oVar.a(true);
        String str = null;
        z = this.a.c;
        if (z) {
            str = com.baidu.tieba.util.k.a();
        }
        if (str != null) {
            oVar.a(str);
            if (oVar.h() && !oVar.i()) {
                oVar.g().c();
            }
        }
        return oVar;
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
    public void onPostExecute(com.baidu.tieba.data.o oVar) {
        q qVar;
        q qVar2;
        com.baidu.tieba.data.o oVar2;
        q qVar3;
        com.baidu.tieba.data.o oVar3;
        q qVar4;
        this.a.a = null;
        this.a.b = oVar;
        o oVar4 = new o(this.a);
        oVar4.c = this.c;
        qVar = this.a.d;
        if (qVar != null) {
            if (this.c != 0 && (this.b == null || !this.b.c())) {
                oVar2 = this.a.b;
                if (oVar2 != null) {
                    oVar3 = this.a.b;
                    if (oVar3.h()) {
                        oVar4.b = true;
                        oVar4.d = oVar;
                        qVar4 = this.a.d;
                        qVar4.a(oVar4);
                        return;
                    }
                }
                String d = this.b != null ? this.b.d() : null;
                oVar4.b = false;
                oVar4.a = d;
                oVar4.d = oVar;
                qVar3 = this.a.d;
                qVar3.a(oVar4);
                return;
            }
            oVar4.b = true;
            oVar4.d = oVar;
            qVar2 = this.a.d;
            qVar2.a(oVar4);
        }
    }
}
