package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ v a;
    private com.baidu.tbadk.core.util.an b;
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
        this.b = new com.baidu.tbadk.core.util.an(strArr[0]);
        this.b.a("day", this.g);
        this.b.a("un", this.f);
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

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.e eVar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.b = null;
        super.cancel(true);
        eVar = this.a.mLoadDataCallBack;
        eVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        com.baidu.adp.base.e eVar;
        com.baidu.adp.base.e eVar2;
        super.onPostExecute(str);
        this.a.b = null;
        if (this.b == null) {
            eVar2 = this.a.mLoadDataCallBack;
            eVar2.a(null);
            return;
        }
        z zVar = new z(this.a);
        if (str == null) {
            zVar.a = true;
        } else {
            zVar.a = false;
            zVar.b = str;
        }
        eVar = this.a.mLoadDataCallBack;
        eVar.a(zVar);
    }
}
