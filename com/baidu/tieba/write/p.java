package com.baidu.tieba.write;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<Object, o, o> {
    private com.baidu.tbadk.core.util.ad AO;
    final /* synthetic */ o cfH;

    private p(o oVar) {
        this.cfH = oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(o oVar, p pVar) {
        this(oVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: E */
    public o doInBackground(Object... objArr) {
        WriteActivity writeActivity;
        String obj = objArr[0].toString();
        this.AO = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
        this.AO.o("kw", obj);
        String or = this.AO.or();
        if (this.AO.oS().qa().lT()) {
            writeActivity = this.cfH.cfG;
            o oVar = new o(writeActivity);
            oVar.parserJson(or);
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
        this.cfH.cfE = null;
        iVar = this.cfH.mLoadDataCallBack;
        iVar.c(oVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.cfH.cfE = null;
        if (this.AO != null) {
            this.AO.dJ();
        }
    }
}
