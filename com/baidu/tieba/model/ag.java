package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ad f1891a;
    private com.baidu.tieba.util.ag b = null;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public ag(ad adVar, String str, String str2, String str3, String str4, String str5) {
        this.f1891a = adVar;
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
        this.b = new com.baidu.tieba.util.ag(strArr[0]);
        this.b.a("day", this.g);
        this.b.a("un", this.f);
        this.b.a("fid", this.c);
        this.b.a("word", this.d);
        this.b.a("z", this.e);
        this.b.a("ntn", "banid");
        this.b.e(true);
        this.b.j();
        if (this.b.c()) {
            return null;
        }
        return this.b.g();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        if (this.b != null) {
            this.b.h();
        }
        this.f1891a.b = null;
        super.cancel(true);
        gVar = this.f1891a.mLoadDataCallBack;
        gVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.a((ag) str);
        this.f1891a.b = null;
        if (this.b == null) {
            gVar2 = this.f1891a.mLoadDataCallBack;
            gVar2.a(null);
            return;
        }
        ah ahVar = new ah(this.f1891a);
        if (str == null) {
            ahVar.f1892a = true;
        } else {
            ahVar.f1892a = false;
            ahVar.b = str;
        }
        gVar = this.f1891a.mLoadDataCallBack;
        gVar.a(ahVar);
    }
}
