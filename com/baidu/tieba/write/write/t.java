package com.baidu.tieba.write.write;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<Object, s, s> {
    private com.baidu.tbadk.core.util.aa Ok;
    final /* synthetic */ s cxl;

    private t(s sVar) {
        this.cxl = sVar;
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
        this.Ok = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
        this.Ok.o("kw", obj);
        String rO = this.Ok.rO();
        if (this.Ok.sp().tq().pv()) {
            writeActivity = this.cxl.cxk;
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
        this.cxl.cxi = null;
        iVar = this.cxl.mLoadDataCallBack;
        iVar.c(sVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.cxl.cxi = null;
        if (this.Ok != null) {
            this.Ok.hh();
        }
    }
}
