package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ v a;
    private com.baidu.tbadk.core.util.ak b;
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
        this.b = new com.baidu.tbadk.core.util.ak(strArr[0]);
        this.b.a("day", this.g);
        this.b.a(PersonInfoActivity.TAG_ID, this.f);
        this.b.a("fid", this.c);
        this.b.a("word", this.d);
        this.b.a("z", this.e);
        this.b.a("ntn", "banid");
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
        super.a((y) str2);
        this.a.b = null;
        if (this.b == null) {
            hVar2 = this.a.mLoadDataCallBack;
            hVar2.a(null);
            return;
        }
        z zVar = new z(this.a);
        if (str2 == null) {
            zVar.a = true;
        } else {
            zVar.a = false;
            zVar.b = str2;
        }
        hVar = this.a.mLoadDataCallBack;
        hVar.a(zVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        com.baidu.adp.a.h hVar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.b = null;
        super.cancel(true);
        hVar = this.a.mLoadDataCallBack;
        hVar.a(null);
    }
}
