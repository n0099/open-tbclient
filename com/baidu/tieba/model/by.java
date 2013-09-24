package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.bb> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bx f1432a;
    private volatile com.baidu.tieba.util.z b;

    private by(bx bxVar) {
        this.f1432a = bxVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ by(bx bxVar, by byVar) {
        this(bxVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.bb a(Object... objArr) {
        com.baidu.tieba.data.bb bbVar;
        Exception e;
        String str;
        String str2;
        try {
            this.b = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/forum/sign");
            com.baidu.tieba.util.z zVar = this.b;
            str = this.f1432a.f1431a;
            zVar.a("kw", str);
            com.baidu.tieba.util.z zVar2 = this.b;
            str2 = this.f1432a.b;
            zVar2.a("fid", str2);
            this.b.e(true);
            String j = this.b.j();
            if (!this.b.d() || !this.b.c()) {
                return null;
            }
            bbVar = new com.baidu.tieba.data.bb();
            try {
                bbVar.a(j);
                return bbVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", e.getMessage());
                return bbVar;
            }
        } catch (Exception e3) {
            bbVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.b != null) {
            this.b.h();
        }
        this.f1432a.c = null;
        super.cancel(true);
        eVar = this.f1432a.mLoadDataCallBack;
        eVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.bb bbVar) {
        com.baidu.adp.a.e eVar;
        this.f1432a.c = null;
        if (bbVar == null && this.b != null) {
            this.f1432a.mErrorCode = this.b.e();
            this.f1432a.mErrorString = this.b.g();
        }
        eVar = this.f1432a.mLoadDataCallBack;
        eVar.a(bbVar);
    }
}
