package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends BdAsyncTask {
    final /* synthetic */ bn a;
    private volatile com.baidu.tieba.util.r b;

    private bo(bn bnVar) {
        this.a = bnVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bo(bn bnVar, bo boVar) {
        this(bnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.av a(Object... objArr) {
        com.baidu.tieba.data.av avVar;
        Exception e;
        String str;
        String str2;
        try {
            this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/c/forum/sign");
            com.baidu.tieba.util.r rVar = this.b;
            str = this.a.a;
            rVar.a("kw", str);
            com.baidu.tieba.util.r rVar2 = this.b;
            str2 = this.a.b;
            rVar2.a("fid", str2);
            this.b.d(true);
            String j = this.b.j();
            if (!this.b.d() || !this.b.c()) {
                return null;
            }
            avVar = new com.baidu.tieba.data.av();
            try {
                avVar.a(j);
                return avVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
                return avVar;
            }
        } catch (Exception e3) {
            avVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.b != null) {
            this.b.h();
        }
        this.a.c = null;
        super.cancel(true);
        eVar = this.a.mLoadDataCallBack;
        eVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.av avVar) {
        com.baidu.adp.a.e eVar;
        this.a.c = null;
        if (avVar == null && this.b != null) {
            this.a.mErrorCode = this.b.e();
            this.a.mErrorString = this.b.g();
        }
        eVar = this.a.mLoadDataCallBack;
        eVar.a(avVar);
    }
}
