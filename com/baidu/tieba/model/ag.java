package com.baidu.tieba.model;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ag extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.z> {
    final /* synthetic */ af a;
    private volatile com.baidu.tbadk.core.util.ak b;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ com.baidu.tieba.data.z a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.data.z zVar) {
        com.baidu.adp.a.h hVar;
        com.baidu.adp.a.h hVar2;
        String str;
        com.baidu.tieba.data.z zVar2 = zVar;
        this.a.d = null;
        if (zVar2 == null && this.b != null) {
            this.a.mErrorCode = this.b.d();
            this.a.mErrorString = this.b.f();
            str = this.a.mErrorString;
            com.baidu.adp.lib.util.f.e("LikeModel", "onPostExecute", str);
        }
        hVar = this.a.mLoadDataCallBack;
        if (hVar != null) {
            hVar2 = this.a.mLoadDataCallBack;
            hVar2.a(zVar2);
        }
    }

    private ag(af afVar) {
        this.a = afVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(af afVar, byte b) {
        this(afVar);
    }

    private com.baidu.tieba.data.z a() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        try {
            this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/forum/like");
            StringBuilder sb = new StringBuilder("mForumName:");
            str = this.a.a;
            StringBuilder append = sb.append(str).append(" mForumid:");
            str2 = this.a.b;
            com.baidu.adp.lib.util.f.e("LikeModel", "doInBackground", append.append(str2).toString());
            com.baidu.tbadk.core.util.ak akVar = this.b;
            str3 = this.a.a;
            akVar.a("kw", str3);
            com.baidu.tbadk.core.util.ak akVar2 = this.b;
            str4 = this.a.b;
            akVar2.a("fid", str4);
            com.baidu.tbadk.core.util.ak akVar3 = this.b;
            str5 = this.a.e;
            akVar3.a("st_type", str5);
            str6 = this.a.c;
            if (!TextUtils.isEmpty(str6)) {
                com.baidu.tbadk.core.util.ak akVar4 = this.b;
                str8 = this.a.c;
                akVar4.a("pagefrom", str8);
            }
            this.b.a().a().a = true;
            String i = this.b.i();
            com.baidu.adp.lib.util.f.e("LikeModel", "doInBackground", "data:" + i);
            if (this.b.a().b().b() && i != null) {
                com.baidu.tieba.data.z zVar = new com.baidu.tieba.data.z();
                zVar.b(i);
                str7 = this.a.b;
                zVar.a(str7);
                return zVar;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        com.baidu.adp.a.h hVar;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.d = null;
        super.cancel(true);
        hVar = this.a.mLoadDataCallBack;
        hVar.a(null);
    }
}
