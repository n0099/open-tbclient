package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f1062a;
    private com.baidu.tieba.util.r b = null;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public r(o oVar, String str, String str2, String str3, String str4, String str5) {
        this.f1062a = oVar;
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
        this.b = new com.baidu.tieba.util.r(strArr[0]);
        this.b.a("day", this.g);
        this.b.a("un", this.f);
        this.b.a("fid", this.c);
        this.b.a("word", this.d);
        this.b.a("z", this.e);
        this.b.a("ntn", "banid");
        this.b.d(true);
        this.b.j();
        if (this.b.c()) {
            return null;
        }
        return this.b.g();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.b != null) {
            this.b.h();
        }
        this.f1062a.b = null;
        super.cancel(true);
        eVar = this.f1062a.mLoadDataCallBack;
        eVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) str);
        this.f1062a.b = null;
        if (this.b == null) {
            eVar2 = this.f1062a.mLoadDataCallBack;
            eVar2.a(null);
            return;
        }
        s sVar = new s(this.f1062a);
        if (str == null) {
            sVar.f1063a = true;
        } else {
            sVar.f1063a = false;
            sVar.b = str;
        }
        eVar = this.f1062a.mLoadDataCallBack;
        eVar.a(sVar);
    }
}
