package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.ag> {
    final /* synthetic */ ax a;
    private volatile com.baidu.tieba.util.at b;

    private az(ax axVar) {
        this.a = axVar;
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
            this.b = new com.baidu.tieba.util.at(com.baidu.tieba.data.h.a + "c/c/forum/like");
            StringBuilder append = new StringBuilder().append("mForumName:");
            str = this.a.a;
            StringBuilder append2 = append.append(str).append(" mForumid:");
            str2 = this.a.b;
            com.baidu.tieba.util.bo.e("LikeModel", "doInBackground", append2.append(str2).toString());
            com.baidu.tieba.util.at atVar = this.b;
            str3 = this.a.a;
            atVar.a("kw", str3);
            com.baidu.tieba.util.at atVar2 = this.b;
            str4 = this.a.b;
            atVar2.a("fid", str4);
            com.baidu.tieba.util.at atVar3 = this.b;
            str5 = this.a.d;
            atVar3.a("st_type", str5);
            this.b.e(true);
            String l = this.b.l();
            com.baidu.tieba.util.bo.e("LikeModel", "doInBackground", "data:" + l);
            if (this.b.c() && l != null) {
                com.baidu.tieba.data.ag agVar = new com.baidu.tieba.data.ag();
                agVar.a(l);
                return agVar;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bo.b(getClass().getName(), "doInBackground", e.getMessage());
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
        this.a.c = null;
        if (agVar == null && this.b != null) {
            this.a.mErrorCode = this.b.e();
            this.a.mErrorString = this.b.i();
            str = this.a.mErrorString;
            com.baidu.tieba.util.bo.e("LikeModel", "onPostExecute", str);
        }
        gVar = this.a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(agVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        this.a.c = null;
        super.cancel(true);
        gVar = this.a.mLoadDataCallBack;
        gVar.a(null);
    }
}
