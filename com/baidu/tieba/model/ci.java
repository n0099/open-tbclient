package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci extends BdAsyncTask<Object, Integer, SignData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f1936a;
    private volatile com.baidu.tieba.util.ag b;

    private ci(cg cgVar) {
        this.f1936a = cgVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public SignData a(Object... objArr) {
        SignData signData;
        Exception e;
        String str;
        String str2;
        try {
            this.b = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/c/forum/sign");
            com.baidu.tieba.util.ag agVar = this.b;
            str = this.f1936a.f1935a;
            agVar.a("kw", str);
            com.baidu.tieba.util.ag agVar2 = this.b;
            str2 = this.f1936a.b;
            agVar2.a("fid", str2);
            this.b.e(true);
            String j = this.b.j();
            if (!this.b.d() || !this.b.c()) {
                return null;
            }
            signData = new SignData();
            try {
                signData.parserJson(j);
                return signData;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.getMessage());
                return signData;
            }
        } catch (Exception e3) {
            signData = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        if (this.b != null) {
            this.b.h();
        }
        this.f1936a.c = null;
        super.cancel(true);
        gVar = this.f1936a.mLoadDataCallBack;
        gVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(SignData signData) {
        com.baidu.adp.a.g gVar;
        this.f1936a.c = null;
        if (signData == null && this.b != null) {
            this.f1936a.mErrorCode = this.b.e();
            this.f1936a.mErrorString = this.b.g();
        }
        gVar = this.f1936a.mLoadDataCallBack;
        gVar.a(signData);
    }
}
