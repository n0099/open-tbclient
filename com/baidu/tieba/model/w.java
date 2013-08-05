package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f1385a;
    private com.baidu.tieba.util.u b = null;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public w(t tVar, String str, String str2, String str3, String str4, String str5) {
        this.f1385a = tVar;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        this.b = new com.baidu.tieba.util.u(strArr[0]);
        this.b.a("day", this.g);
        this.b.a("un", this.f);
        this.b.a("fid", this.c);
        this.b.a("word", this.d);
        this.b.a("z", this.e);
        this.b.a("ntn", "banid");
        this.b.e(true);
        this.b.k();
        if (this.b.d()) {
            return null;
        }
        return this.b.h();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.b != null) {
            this.b.i();
        }
        this.f1385a.b = null;
        super.cancel(true);
        eVar = this.f1385a.mLoadDataCallBack;
        eVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) str);
        this.f1385a.b = null;
        if (this.b == null) {
            eVar2 = this.f1385a.mLoadDataCallBack;
            eVar2.a(null);
            return;
        }
        x xVar = new x(this.f1385a);
        if (str == null) {
            xVar.f1386a = true;
        } else {
            xVar.f1386a = false;
            xVar.b = str;
        }
        eVar = this.f1385a.mLoadDataCallBack;
        eVar.a(xVar);
    }
}
