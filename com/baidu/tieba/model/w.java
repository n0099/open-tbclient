package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ v a;
    private com.baidu.tbadk.core.util.ak b = null;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;
    private boolean i;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        String str = com.baidu.tbadk.core.data.n.a;
        this.b = new com.baidu.tbadk.core.util.ak(this.g == 0 ? String.valueOf(str) + "c/c/bawu/delthread" : String.valueOf(str) + "c/c/bawu/delpost");
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
        if (this.h != 0 || this.i) {
            this.b.a("is_vipdel", "0");
        } else {
            this.b.a("is_vipdel", "1");
        }
        this.b.a().a().a = true;
        this.b.i();
        if (this.b.a().b().b()) {
            return null;
        }
        return this.b.f();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        com.baidu.adp.a.h hVar;
        com.baidu.adp.a.h hVar2;
        String str2 = str;
        super.a((w) str2);
        this.a.a = null;
        if (this.b == null) {
            hVar2 = this.a.mLoadDataCallBack;
            hVar2.a(null);
            return;
        }
        x xVar = new x(this.a);
        xVar.c = this.g;
        xVar.d = this.f;
        xVar.b = str2;
        if (str2 == null) {
            xVar.a = true;
        } else {
            xVar.a = false;
        }
        hVar = this.a.mLoadDataCallBack;
        hVar.a(xVar);
    }

    public w(v vVar, String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        this.a = vVar;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = i;
        this.h = i2;
        this.i = z;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        com.baidu.adp.a.h hVar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.a = null;
        super.cancel(true);
        hVar = this.a.mLoadDataCallBack;
        hVar.a(null);
    }
}
