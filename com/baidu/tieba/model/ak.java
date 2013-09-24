package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends BdAsyncTask<Void, Void, com.baidu.tieba.data.az> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aj f1398a;
    private String b;
    private com.baidu.tieba.a.h c;

    public ak(aj ajVar, String str) {
        this.f1398a = ajVar;
        setPriority(3);
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        al alVar;
        al alVar2;
        super.b();
        alVar = this.f1398a.b;
        if (alVar != null) {
            alVar2 = this.f1398a.b;
            alVar2.a();
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
    public com.baidu.tieba.data.az a(Void... voidArr) {
        this.c = new com.baidu.tieba.a.h();
        return new com.baidu.tieba.data.az().d(this.c.a(this.b));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.az azVar) {
        al alVar;
        al alVar2;
        super.a((ak) azVar);
        alVar = this.f1398a.b;
        if (alVar != null) {
            alVar2 = this.f1398a.b;
            alVar2.a(azVar);
        }
    }
}
