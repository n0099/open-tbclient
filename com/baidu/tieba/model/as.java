package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ar f1337a;
    private volatile com.baidu.tieba.util.u b;

    private as(ar arVar) {
        this.f1337a = arVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ as(ar arVar, as asVar) {
        this(arVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.ak a(Object... objArr) {
        String str;
        String str2;
        try {
            this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/c/forum/like");
            com.baidu.tieba.util.u uVar = this.b;
            str = this.f1337a.f1336a;
            uVar.a("kw", str);
            com.baidu.tieba.util.u uVar2 = this.b;
            str2 = this.f1337a.b;
            uVar2.a("fid", str2);
            this.b.e(true);
            String k = this.b.k();
            if (this.b.d() && k != null) {
                com.baidu.tieba.data.ak akVar = new com.baidu.tieba.data.ak();
                akVar.a(k);
                return akVar;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.ak akVar) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        this.f1337a.c = null;
        if (akVar == null && this.b != null) {
            this.f1337a.mErrorCode = this.b.f();
            this.f1337a.mErrorString = this.b.h();
        }
        eVar = this.f1337a.mLoadDataCallBack;
        if (eVar != null) {
            eVar2 = this.f1337a.mLoadDataCallBack;
            eVar2.a(akVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.b != null) {
            this.b.i();
            this.b = null;
        }
        this.f1337a.c = null;
        super.cancel(true);
        eVar = this.f1337a.mLoadDataCallBack;
        eVar.a(null);
    }
}
