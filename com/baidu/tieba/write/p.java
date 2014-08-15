package com.baidu.tieba.write;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<Object, o, o> {
    final /* synthetic */ o a;
    private com.baidu.tbadk.core.util.ae b;

    private p(o oVar) {
        this.a = oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(o oVar, p pVar) {
        this(oVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public o doInBackground(Object... objArr) {
        String obj = objArr[0].toString();
        this.b = new com.baidu.tbadk.core.util.ae(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
        this.b.a("kw", obj);
        String h = this.b.h();
        if (!this.b.a().b().b()) {
            return null;
        }
        o oVar = new o();
        oVar.b(h);
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(o oVar) {
        com.baidu.adp.base.h hVar;
        super.onPostExecute(oVar);
        this.a.a = null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(oVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.a.a = null;
        if (this.b != null) {
            this.b.f();
        }
    }
}
