package com.baidu.tieba.write;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<Object, s, s> {
    final /* synthetic */ s a;
    private com.baidu.tbadk.core.util.al b;

    private t(s sVar) {
        this.a = sVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(s sVar, t tVar) {
        this(sVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public s doInBackground(Object... objArr) {
        String obj = objArr[0].toString();
        this.b = new com.baidu.tbadk.core.util.al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
        this.b.a("kw", obj);
        String i = this.b.i();
        if (!this.b.a().b().b()) {
            return null;
        }
        s sVar = new s();
        sVar.b(i);
        return sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(s sVar) {
        com.baidu.adp.base.e eVar;
        super.onPostExecute(sVar);
        this.a.a = null;
        eVar = this.a.mLoadDataCallBack;
        eVar.a(sVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.a.a = null;
        if (this.b != null) {
            this.b.g();
        }
    }
}
