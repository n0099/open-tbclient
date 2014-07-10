package com.baidu.tieba.model;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.ab> {
    final /* synthetic */ ae a;
    private volatile com.baidu.tbadk.core.util.aq b;

    private af(ae aeVar) {
        this.a = aeVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ af(ae aeVar, af afVar) {
        this(aeVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public com.baidu.tieba.data.ab doInBackground(Object... objArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        try {
            this.b = new com.baidu.tbadk.core.util.aq(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/like");
            com.baidu.tbadk.core.util.aq aqVar = this.b;
            str = this.a.a;
            aqVar.a("kw", str);
            com.baidu.tbadk.core.util.aq aqVar2 = this.b;
            str2 = this.a.b;
            aqVar2.a("fid", str2);
            com.baidu.tbadk.core.util.aq aqVar3 = this.b;
            str3 = this.a.e;
            aqVar3.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str3);
            str4 = this.a.c;
            if (!TextUtils.isEmpty(str4)) {
                com.baidu.tbadk.core.util.aq aqVar4 = this.b;
                str8 = this.a.c;
                aqVar4.a("pagefrom", str8);
            }
            this.b.a().a().a = true;
            String i = this.b.i();
            if (this.b.a().b().b() && i != null) {
                com.baidu.tieba.data.ab abVar = new com.baidu.tieba.data.ab();
                abVar.b(i);
                str5 = this.a.b;
                abVar.a(str5);
                str6 = this.a.b;
                str7 = this.a.a;
                Hao123Model.addLikeData(str6, str7, abVar.b());
                return abVar;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.data.ab abVar) {
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        this.a.d = null;
        if (abVar == null && this.b != null) {
            this.a.mErrorCode = this.b.d();
            this.a.mErrorString = this.b.f();
        }
        hVar = this.a.mLoadDataCallBack;
        if (hVar != null) {
            hVar2 = this.a.mLoadDataCallBack;
            hVar2.a(abVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.h hVar;
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
