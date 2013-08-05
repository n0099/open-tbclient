package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f1380a;
    private com.baidu.tieba.a.f b = null;

    public q(o oVar) {
        this.f1380a = oVar;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.ae a(Object... objArr) {
        try {
            this.b = new com.baidu.tieba.a.f();
            String g = this.b.g();
            if (this.b.c()) {
                com.baidu.tieba.data.ae aeVar = new com.baidu.tieba.data.ae();
                aeVar.a(g);
                return aeVar;
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.ae aeVar) {
        r rVar;
        r rVar2;
        com.baidu.tieba.data.ae aeVar2;
        int e = this.b.e();
        String f = this.b.f();
        this.f1380a.e = aeVar;
        if (aeVar != null) {
            rVar2 = this.f1380a.g;
            aeVar2 = this.f1380a.e;
            rVar2.a(aeVar2, e, f);
        } else {
            rVar = this.f1380a.g;
            rVar.a(null, e, f);
        }
        this.b.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.a();
        }
    }
}
