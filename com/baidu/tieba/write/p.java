package com.baidu.tieba.write;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<Object, o, o> {
    final /* synthetic */ o bTc;
    private com.baidu.tbadk.core.util.ac mNetWork;

    private p(o oVar) {
        this.bTc = oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(o oVar, p pVar) {
        this(oVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: A */
    public o doInBackground(Object... objArr) {
        Context context;
        String obj = objArr[0].toString();
        this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
        this.mNetWork.k("kw", obj);
        String lA = this.mNetWork.lA();
        if (this.mNetWork.mc().nb().jq()) {
            context = this.bTc.mContext;
            o oVar = new o(context);
            oVar.parserJson(lA);
            return oVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(o oVar) {
        com.baidu.adp.base.h hVar;
        super.onPostExecute(oVar);
        this.bTc.bTa = null;
        hVar = this.bTc.mLoadDataCallBack;
        hVar.a(oVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.bTc.bTa = null;
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
    }
}
