package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.ag> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ba f1911a;
    private volatile com.baidu.tieba.util.ag b;

    private bc(ba baVar) {
        this.f1911a = baVar;
        this.b = null;
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
            this.b = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/c/forum/like");
            StringBuilder append = new StringBuilder().append("mForumName:");
            str = this.f1911a.f1910a;
            StringBuilder append2 = append.append(str).append(" mForumid:");
            str2 = this.f1911a.b;
            com.baidu.tieba.util.be.e("LikeModel", "doInBackground", append2.append(str2).toString());
            com.baidu.tieba.util.ag agVar = this.b;
            str3 = this.f1911a.f1910a;
            agVar.a("kw", str3);
            com.baidu.tieba.util.ag agVar2 = this.b;
            str4 = this.f1911a.b;
            agVar2.a("fid", str4);
            com.baidu.tieba.util.ag agVar3 = this.b;
            str5 = this.f1911a.d;
            agVar3.a("st_type", str5);
            this.b.e(true);
            String j = this.b.j();
            com.baidu.tieba.util.be.e("LikeModel", "doInBackground", "data:" + j);
            if (this.b.c() && j != null) {
                com.baidu.tieba.data.ag agVar4 = new com.baidu.tieba.data.ag();
                agVar4.a(j);
                return agVar4;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.ag agVar) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        String str;
        this.f1911a.c = null;
        if (agVar == null && this.b != null) {
            this.f1911a.mErrorCode = this.b.e();
            this.f1911a.mErrorString = this.b.g();
            str = this.f1911a.mErrorString;
            com.baidu.tieba.util.be.e("LikeModel", "onPostExecute", str);
        }
        gVar = this.f1911a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.f1911a.mLoadDataCallBack;
            gVar2.a(agVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1911a.c = null;
        super.cancel(true);
        gVar = this.f1911a.mLoadDataCallBack;
        gVar.a(null);
    }
}
