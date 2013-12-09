package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.af> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ax f2000a;
    private volatile com.baidu.tieba.util.am b;

    private az(ax axVar) {
        this.f2000a = axVar;
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
            this.b = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/c/forum/like");
            StringBuilder append = new StringBuilder().append("mForumName:");
            str = this.f2000a.f1999a;
            StringBuilder append2 = append.append(str).append(" mForumid:");
            str2 = this.f2000a.b;
            com.baidu.tieba.util.bd.e("LikeModel", "doInBackground", append2.append(str2).toString());
            com.baidu.tieba.util.am amVar = this.b;
            str3 = this.f2000a.f1999a;
            amVar.a("kw", str3);
            com.baidu.tieba.util.am amVar2 = this.b;
            str4 = this.f2000a.b;
            amVar2.a("fid", str4);
            com.baidu.tieba.util.am amVar3 = this.b;
            str5 = this.f2000a.d;
            amVar3.a("st_type", str5);
            this.b.e(true);
            String l = this.b.l();
            com.baidu.tieba.util.bd.e("LikeModel", "doInBackground", "data:" + l);
            if (this.b.c() && l != null) {
                com.baidu.tieba.data.af afVar = new com.baidu.tieba.data.af();
                afVar.a(l);
                return afVar;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "doInBackground", e.getMessage());
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
        this.f2000a.c = null;
        if (afVar == null && this.b != null) {
            this.f2000a.mErrorCode = this.b.e();
            this.f2000a.mErrorString = this.b.i();
            str = this.f2000a.mErrorString;
            com.baidu.tieba.util.bd.e("LikeModel", "onPostExecute", str);
        }
        gVar = this.f2000a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.f2000a.mLoadDataCallBack;
            gVar2.a(afVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        this.f2000a.c = null;
        super.cancel(true);
        gVar = this.f2000a.mLoadDataCallBack;
        gVar.a(null);
    }
}
