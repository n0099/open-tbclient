package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f1383a;
    private com.baidu.tieba.util.u b = null;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;
    private boolean i;

    public u(t tVar, String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        this.f1383a = tVar;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = i;
        this.h = i2;
        this.i = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        String str2 = com.baidu.tieba.data.g.f1013a;
        if (this.g == 0) {
            str = String.valueOf(str2) + "c/c/bawu/delthread";
        } else {
            str = String.valueOf(str2) + "c/c/bawu/delpost";
        }
        this.b = new com.baidu.tieba.util.u(str);
        this.b.a("fid", this.c);
        this.b.a("word", this.d);
        this.b.a("z", this.e);
        if (this.g == 0) {
            if (this.h == 0) {
                this.b.a("delete_my_thread", "1");
            }
        } else if (this.g == 1) {
            this.b.a("pid", this.f);
            this.b.a("isfloor", "0");
            this.b.a("src", "1");
            if (this.h == 0 && this.i) {
                this.b.a("delete_my_post", "1");
            }
        } else if (this.g == 2) {
            this.b.a("pid", this.f);
            this.b.a("isfloor", "1");
            this.b.a("src", "3");
            if (this.h == 0 && this.i) {
                this.b.a("delete_my_post", "1");
            }
        }
        if (this.h == 0 && !this.i) {
            this.b.a("is_vipdel", "1");
        } else {
            this.b.a("is_vipdel", "0");
        }
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
        this.f1383a.f1382a = null;
        super.cancel(true);
        eVar = this.f1383a.mLoadDataCallBack;
        eVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) str);
        this.f1383a.f1382a = null;
        if (this.b == null) {
            eVar2 = this.f1383a.mLoadDataCallBack;
            eVar2.a(null);
            return;
        }
        v vVar = new v(this.f1383a);
        vVar.c = this.g;
        vVar.d = this.f;
        vVar.b = str;
        if (str == null) {
            vVar.f1384a = true;
        } else {
            vVar.f1384a = false;
        }
        eVar = this.f1383a.mLoadDataCallBack;
        eVar.a(vVar);
    }
}
