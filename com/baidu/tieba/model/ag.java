package com.baidu.tieba.model;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.z> {
    final /* synthetic */ af a;
    private volatile com.baidu.tbadk.core.util.al b;

    private ag(af afVar) {
        this.a = afVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(af afVar, ag agVar) {
        this(afVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public com.baidu.tieba.data.z doInBackground(Object... objArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        try {
            this.b = new com.baidu.tbadk.core.util.al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/like");
            StringBuilder sb = new StringBuilder("mForumName:");
            str = this.a.a;
            StringBuilder append = sb.append(str).append(" mForumid:");
            str2 = this.a.b;
            BdLog.d("LikeModel", "doInBackground", append.append(str2).toString());
            com.baidu.tbadk.core.util.al alVar = this.b;
            str3 = this.a.a;
            alVar.a("kw", str3);
            com.baidu.tbadk.core.util.al alVar2 = this.b;
            str4 = this.a.b;
            alVar2.a("fid", str4);
            com.baidu.tbadk.core.util.al alVar3 = this.b;
            str5 = this.a.e;
            alVar3.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str5);
            str6 = this.a.c;
            if (!TextUtils.isEmpty(str6)) {
                com.baidu.tbadk.core.util.al alVar4 = this.b;
                str8 = this.a.c;
                alVar4.a("pagefrom", str8);
            }
            this.b.a().a().a = true;
            String i = this.b.i();
            BdLog.d("LikeModel", "doInBackground", "data:" + i);
            if (this.b.a().b().b() && i != null) {
                com.baidu.tieba.data.z zVar = new com.baidu.tieba.data.z();
                zVar.b(i);
                str7 = this.a.b;
                zVar.a(str7);
                return zVar;
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.data.z zVar) {
        com.baidu.adp.base.g gVar;
        com.baidu.adp.base.g gVar2;
        String str;
        this.a.d = null;
        if (zVar == null && this.b != null) {
            this.a.mErrorCode = this.b.d();
            this.a.mErrorString = this.b.f();
            str = this.a.mErrorString;
            BdLog.d("LikeModel", "onPostExecute", str);
        }
        gVar = this.a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(zVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.g gVar;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.d = null;
        super.cancel(true);
        gVar = this.a.mLoadDataCallBack;
        gVar.a(null);
    }
}
