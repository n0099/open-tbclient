package com.baidu.tieba.write;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<Object, s, s> {
    final /* synthetic */ s a;
    private com.baidu.tieba.util.ba b;

    private t(s sVar) {
        this.a = sVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(s sVar, t tVar) {
        this(sVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public s a(Object... objArr) {
        String obj = objArr[0].toString();
        this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/frs/toplist");
        this.b.a("kw", obj);
        String m = this.b.m();
        if (!this.b.d()) {
            return null;
        }
        s sVar = new s();
        sVar.b(m);
        return sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(s sVar) {
        com.baidu.adp.a.g gVar;
        super.a((t) sVar);
        this.a.a = null;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(sVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.a.a = null;
        if (this.b != null) {
            this.b.k();
        }
    }
}
