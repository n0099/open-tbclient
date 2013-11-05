package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends BdAsyncTask<Void, Void, com.baidu.tieba.data.ay> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ar f1903a;
    private String b;
    private com.baidu.tieba.a.h c;

    public as(ar arVar, String str) {
        this.f1903a = arVar;
        setPriority(3);
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        at atVar;
        at atVar2;
        super.b();
        atVar = this.f1903a.b;
        if (atVar != null) {
            atVar2 = this.f1903a.b;
            atVar2.a();
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
    public com.baidu.tieba.data.ay a(Void... voidArr) {
        this.c = new com.baidu.tieba.a.h();
        return new com.baidu.tieba.data.ay().d(this.c.a(this.b));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.ay ayVar) {
        at atVar;
        at atVar2;
        super.a((as) ayVar);
        atVar = this.f1903a.b;
        if (atVar != null) {
            atVar2 = this.f1903a.b;
            atVar2.a(ayVar);
        }
    }
}
