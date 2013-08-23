package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aq f1369a;
    private volatile com.baidu.tieba.util.v b;

    private ar(aq aqVar) {
        this.f1369a = aqVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ar(aq aqVar, ar arVar) {
        this(aqVar);
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
            this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/forum/like");
            StringBuilder sb = new StringBuilder("mForumName:");
            str = this.f1369a.f1368a;
            StringBuilder append = sb.append(str).append(" mForumid:");
            str2 = this.f1369a.b;
            com.baidu.tieba.util.aq.e("LikeModel", "doInBackground", append.append(str2).toString());
            com.baidu.tieba.util.v vVar = this.b;
            str3 = this.f1369a.f1368a;
            vVar.a("kw", str3);
            com.baidu.tieba.util.v vVar2 = this.b;
            str4 = this.f1369a.b;
            vVar2.a("fid", str4);
            com.baidu.tieba.util.v vVar3 = this.b;
            str5 = this.f1369a.d;
            vVar3.a("st_type", str5);
            this.b.e(true);
            String j = this.b.j();
            com.baidu.tieba.util.aq.e("LikeModel", "doInBackground", "data:" + j);
            if (this.b.c() && j != null) {
                com.baidu.tieba.data.ag agVar = new com.baidu.tieba.data.ag();
                agVar.a(j);
                return agVar;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "doInBackground", e.getMessage());
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
        this.f1369a.c = null;
        if (agVar == null && this.b != null) {
            this.f1369a.mErrorCode = this.b.e();
            this.f1369a.mErrorString = this.b.g();
            str = this.f1369a.mErrorString;
            com.baidu.tieba.util.aq.e("LikeModel", "onPostExecute", str);
        }
        eVar = this.f1369a.mLoadDataCallBack;
        if (eVar != null) {
            eVar2 = this.f1369a.mLoadDataCallBack;
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
        this.f1369a.c = null;
        super.cancel(true);
        eVar = this.f1369a.mLoadDataCallBack;
        eVar.a(null);
    }
}
