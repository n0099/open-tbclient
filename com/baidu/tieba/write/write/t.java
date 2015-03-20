package com.baidu.tieba.write.write;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<Object, s, s> {
    private com.baidu.tbadk.core.util.aa Oi;
    final /* synthetic */ s cwS;

    private t(s sVar) {
        this.cwS = sVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(s sVar, t tVar) {
        this(sVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: E */
    public s doInBackground(Object... objArr) {
        WriteActivity writeActivity;
        String obj = objArr[0].toString();
        this.Oi = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
        this.Oi.o("kw", obj);
        String rO = this.Oi.rO();
        if (this.Oi.sp().tq().pv()) {
            writeActivity = this.cwS.cwR;
            s sVar = new s(writeActivity);
            sVar.parserJson(rO);
            return sVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(s sVar) {
        com.baidu.adp.base.i iVar;
        super.onPostExecute(sVar);
        this.cwS.cwP = null;
        iVar = this.cwS.mLoadDataCallBack;
        iVar.c(sVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.cwS.cwP = null;
        if (this.Oi != null) {
            this.Oi.hh();
        }
    }
}
