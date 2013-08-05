package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ah f1328a;
    private String b;
    private com.baidu.tieba.a.e c;

    public ai(ah ahVar, String str) {
        this.f1328a = ahVar;
        setPriority(3);
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        aj ajVar;
        aj ajVar2;
        super.b();
        ajVar = this.f1328a.b;
        if (ajVar != null) {
            ajVar2 = this.f1328a.b;
            ajVar2.a();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.be a(Void... voidArr) {
        this.c = new com.baidu.tieba.a.e();
        return new com.baidu.tieba.data.be().d(this.c.a(this.b));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.be beVar) {
        aj ajVar;
        aj ajVar2;
        super.a((Object) beVar);
        ajVar = this.f1328a.b;
        if (ajVar != null) {
            ajVar2 = this.f1328a.b;
            ajVar2.a(beVar);
        }
    }
}
