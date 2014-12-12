package com.baidu.tieba.write;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<Object, o, o> {
    private com.baidu.tbadk.core.util.ad AR;
    final /* synthetic */ o cej;

    private p(o oVar) {
        this.cej = oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(o oVar, p pVar) {
        this(oVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: D */
    public o doInBackground(Object... objArr) {
        WriteActivity writeActivity;
        String obj = objArr[0].toString();
        this.AR = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
        this.AR.o("kw", obj);
        String ov = this.AR.ov();
        if (this.AR.oW().pW().ma()) {
            writeActivity = this.cej.cei;
            o oVar = new o(writeActivity);
            oVar.parserJson(ov);
            return oVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(o oVar) {
        com.baidu.adp.base.i iVar;
        super.onPostExecute(oVar);
        this.cej.ceg = null;
        iVar = this.cej.mLoadDataCallBack;
        iVar.c(oVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.cej.ceg = null;
        if (this.AR != null) {
            this.AR.dL();
        }
    }
}
