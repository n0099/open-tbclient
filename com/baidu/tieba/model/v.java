package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ s a;
    private com.baidu.tieba.util.ba b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        this.b = new com.baidu.tieba.util.ba(strArr[0]);
        this.b.a("day", this.g);
        this.b.a("un", this.f);
        this.b.a("fid", this.c);
        this.b.a("word", this.d);
        this.b.a("z", this.e);
        this.b.a("ntn", "banid");
        this.b.e(true);
        this.b.l();
        if (this.b.c()) {
            return null;
        }
        return this.b.i();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        String str2 = str;
        super.a((v) str2);
        this.a.b = null;
        if (this.b == null) {
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(null);
            return;
        }
        w wVar = new w(this.a);
        if (str2 == null) {
            wVar.a = true;
        } else {
            wVar.a = false;
            wVar.b = str2;
        }
        gVar = this.a.mLoadDataCallBack;
        gVar.a(wVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        com.baidu.adp.a.g gVar;
        if (this.b != null) {
            this.b.j();
        }
        this.a.b = null;
        super.cancel(true);
        gVar = this.a.mLoadDataCallBack;
        gVar.a(null);
    }
}
