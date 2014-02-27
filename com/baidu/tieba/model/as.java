package com.baidu.tieba.model;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class as extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.af> {
    final /* synthetic */ ar a;
    private volatile com.baidu.tieba.util.ba b;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.data.af a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.data.af afVar) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        String str;
        com.baidu.tieba.data.af afVar2 = afVar;
        this.a.d = null;
        if (afVar2 == null && this.b != null) {
            this.a.mErrorCode = this.b.e();
            this.a.mErrorString = this.b.i();
            str = this.a.mErrorString;
            com.baidu.adp.lib.util.e.e("LikeModel", "onPostExecute", str);
        }
        gVar = this.a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(afVar2);
        }
    }

    private as(ar arVar) {
        this.a = arVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ as(ar arVar, byte b) {
        this(arVar);
    }

    private com.baidu.tieba.data.af d() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        try {
            this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/forum/like");
            StringBuilder sb = new StringBuilder("mForumName:");
            str = this.a.a;
            StringBuilder append = sb.append(str).append(" mForumid:");
            str2 = this.a.b;
            com.baidu.adp.lib.util.e.e("LikeModel", "doInBackground", append.append(str2).toString());
            com.baidu.tieba.util.ba baVar = this.b;
            str3 = this.a.a;
            baVar.a("kw", str3);
            com.baidu.tieba.util.ba baVar2 = this.b;
            str4 = this.a.b;
            baVar2.a("fid", str4);
            com.baidu.tieba.util.ba baVar3 = this.b;
            str5 = this.a.e;
            baVar3.a("st_type", str5);
            str6 = this.a.c;
            if (!TextUtils.isEmpty(str6)) {
                com.baidu.tieba.util.ba baVar4 = this.b;
                str8 = this.a.c;
                baVar4.a("pagefrom", str8);
            }
            this.b.e(true);
            String l = this.b.l();
            com.baidu.adp.lib.util.e.e("LikeModel", "doInBackground", "data:" + l);
            if (this.b.c() && l != null) {
                com.baidu.tieba.data.af afVar = new com.baidu.tieba.data.af();
                afVar.b(l);
                str7 = this.a.b;
                afVar.a(str7);
                return afVar;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        com.baidu.adp.a.g gVar;
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        this.a.d = null;
        super.cancel(true);
        gVar = this.a.mLoadDataCallBack;
        gVar.a(null);
    }
}
