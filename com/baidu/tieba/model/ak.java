package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aj f1017a;
    private volatile com.baidu.tieba.util.r b;

    private ak(aj ajVar) {
        this.f1017a = ajVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ak(aj ajVar, ak akVar) {
        this(ajVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.ac a(Object... objArr) {
        String str;
        String str2;
        try {
            this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/c/forum/like");
            com.baidu.tieba.util.r rVar = this.b;
            str = this.f1017a.f1016a;
            rVar.a("kw", str);
            com.baidu.tieba.util.r rVar2 = this.b;
            str2 = this.f1017a.b;
            rVar2.a("fid", str2);
            this.b.d(true);
            String j = this.b.j();
            if (this.b.c() && j != null) {
                com.baidu.tieba.data.ac acVar = new com.baidu.tieba.data.ac();
                acVar.a(j);
                return acVar;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.ac acVar) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        this.f1017a.c = null;
        if (acVar == null && this.b != null) {
            this.f1017a.mErrorCode = this.b.e();
            this.f1017a.mErrorString = this.b.g();
        }
        eVar = this.f1017a.mLoadDataCallBack;
        if (eVar != null) {
            eVar2 = this.f1017a.mLoadDataCallBack;
            eVar2.a(acVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1017a.c = null;
        super.cancel(true);
        eVar = this.f1017a.mLoadDataCallBack;
        eVar.a(null);
    }
}
