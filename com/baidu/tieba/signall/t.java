package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t extends BdAsyncTask<String, Integer, p> {
    final /* synthetic */ r a;
    private f b = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ p a(String... strArr) {
        p pVar;
        p pVar2 = null;
        String[] strArr2 = strArr;
        this.b = new f();
        com.baidu.tieba.r.c();
        if (UtilHelper.d(com.baidu.tieba.r.d().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
            r rVar = this.a;
            String a = this.b.a(strArr2[0]);
            if (this.b.b()) {
                pVar2 = new p();
                pVar2.a(a);
            }
            rVar.c = pVar2;
            pVar = this.a.c;
            return pVar;
        }
        return null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(p pVar) {
        s sVar;
        p pVar2;
        s sVar2;
        s sVar3;
        p pVar3;
        this.a.a = false;
        this.a.b = null;
        sVar = this.a.d;
        if (sVar != null) {
            pVar2 = this.a.c;
            if (pVar2 != null) {
                sVar3 = this.a.d;
                pVar3 = this.a.c;
                sVar3.a(pVar3);
                return;
            }
            String c = this.b != null ? this.b.c() : null;
            sVar2 = this.a.d;
            sVar2.a(c);
        }
    }

    public t(r rVar) {
        this.a = rVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        super.c();
        this.a.a = true;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel();
        this.b.a();
        this.b = null;
        this.a.b = null;
        this.a.a = false;
    }
}
