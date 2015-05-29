package com.baidu.tieba.write.write;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BdAsyncTask<Object, t, t> {
    private com.baidu.tbadk.core.util.aa OE;
    final /* synthetic */ t cBD;

    private u(t tVar) {
        this.cBD = tVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(t tVar, u uVar) {
        this(tVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: H */
    public t doInBackground(Object... objArr) {
        WriteActivity writeActivity;
        String obj = objArr[0].toString();
        this.OE = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
        this.OE.o("kw", obj);
        String sw = this.OE.sw();
        if (this.OE.sX().tT().qa()) {
            writeActivity = this.cBD.cBC;
            t tVar = new t(writeActivity);
            tVar.parserJson(sw);
            return tVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(t tVar) {
        com.baidu.adp.base.i iVar;
        super.onPostExecute(tVar);
        this.cBD.cBA = null;
        iVar = this.cBD.mLoadDataCallBack;
        iVar.c(tVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.cBD.cBA = null;
        if (this.OE != null) {
            this.OE.gS();
        }
    }
}
