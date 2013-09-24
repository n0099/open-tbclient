package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.ag> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ as f1406a;
    private volatile com.baidu.tieba.util.z b;

    private at(as asVar) {
        this.f1406a = asVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ at(as asVar, at atVar) {
        this(asVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.ag a(Object... objArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        try {
            this.b = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/forum/like");
            StringBuilder sb = new StringBuilder("mForumName:");
            str = this.f1406a.f1405a;
            StringBuilder append = sb.append(str).append(" mForumid:");
            str2 = this.f1406a.b;
            com.baidu.tieba.util.av.e("LikeModel", "doInBackground", append.append(str2).toString());
            com.baidu.tieba.util.z zVar = this.b;
            str3 = this.f1406a.f1405a;
            zVar.a("kw", str3);
            com.baidu.tieba.util.z zVar2 = this.b;
            str4 = this.f1406a.b;
            zVar2.a("fid", str4);
            com.baidu.tieba.util.z zVar3 = this.b;
            str5 = this.f1406a.d;
            zVar3.a("st_type", str5);
            this.b.e(true);
            String j = this.b.j();
            com.baidu.tieba.util.av.e("LikeModel", "doInBackground", "data:" + j);
            if (this.b.c() && j != null) {
                com.baidu.tieba.data.ag agVar = new com.baidu.tieba.data.ag();
                agVar.a(j);
                return agVar;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.ag agVar) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        String str;
        this.f1406a.c = null;
        if (agVar == null && this.b != null) {
            this.f1406a.mErrorCode = this.b.e();
            this.f1406a.mErrorString = this.b.g();
            str = this.f1406a.mErrorString;
            com.baidu.tieba.util.av.e("LikeModel", "onPostExecute", str);
        }
        eVar = this.f1406a.mLoadDataCallBack;
        if (eVar != null) {
            eVar2 = this.f1406a.mLoadDataCallBack;
            eVar2.a(agVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1406a.c = null;
        super.cancel(true);
        eVar = this.f1406a.mLoadDataCallBack;
        eVar.a(null);
    }
}
