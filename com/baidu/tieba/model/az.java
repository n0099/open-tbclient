package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.af> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ax f1887a;
    private volatile com.baidu.tieba.util.ap b;

    private az(ax axVar) {
        this.f1887a = axVar;
        this.b = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.af a(Object... objArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        try {
            this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1201a + "c/c/forum/like");
            StringBuilder append = new StringBuilder().append("mForumName:");
            str = this.f1887a.f1886a;
            StringBuilder append2 = append.append(str).append(" mForumid:");
            str2 = this.f1887a.b;
            com.baidu.tieba.util.bg.e("LikeModel", "doInBackground", append2.append(str2).toString());
            com.baidu.tieba.util.ap apVar = this.b;
            str3 = this.f1887a.f1886a;
            apVar.a("kw", str3);
            com.baidu.tieba.util.ap apVar2 = this.b;
            str4 = this.f1887a.b;
            apVar2.a("fid", str4);
            com.baidu.tieba.util.ap apVar3 = this.b;
            str5 = this.f1887a.d;
            apVar3.a("st_type", str5);
            this.b.e(true);
            String j = this.b.j();
            com.baidu.tieba.util.bg.e("LikeModel", "doInBackground", "data:" + j);
            if (this.b.c() && j != null) {
                com.baidu.tieba.data.af afVar = new com.baidu.tieba.data.af();
                afVar.a(j);
                return afVar;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.af afVar) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        String str;
        this.f1887a.c = null;
        if (afVar == null && this.b != null) {
            this.f1887a.mErrorCode = this.b.e();
            this.f1887a.mErrorString = this.b.g();
            str = this.f1887a.mErrorString;
            com.baidu.tieba.util.bg.e("LikeModel", "onPostExecute", str);
        }
        gVar = this.f1887a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.f1887a.mLoadDataCallBack;
            gVar2.a(afVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1887a.c = null;
        super.cancel(true);
        gVar = this.f1887a.mLoadDataCallBack;
        gVar.a(null);
    }
}
