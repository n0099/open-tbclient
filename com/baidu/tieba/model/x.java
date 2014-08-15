package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ u a;
    private com.baidu.tbadk.core.util.ae b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        this.b = new com.baidu.tbadk.core.util.ae(strArr[0]);
        this.b.a("day", this.g);
        this.b.a("un", this.f);
        this.b.a("fid", this.c);
        this.b.a("word", this.d);
        this.b.a("z", this.e);
        this.b.a("ntn", "banid");
        this.b.a().a().a = true;
        this.b.h();
        if (this.b.a().b().b()) {
            return null;
        }
        return this.b.e();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.h hVar;
        if (this.b != null) {
            this.b.f();
        }
        this.a.b = null;
        super.cancel(true);
        hVar = this.a.mLoadDataCallBack;
        hVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        super.onPostExecute(str);
        this.a.b = null;
        if (this.b == null) {
            hVar2 = this.a.mLoadDataCallBack;
            hVar2.a(null);
            return;
        }
        y yVar = new y(this.a);
        if (str == null) {
            yVar.a = true;
        } else {
            yVar.a = false;
            yVar.b = str;
        }
        hVar = this.a.mLoadDataCallBack;
        hVar.a(yVar);
    }
}
