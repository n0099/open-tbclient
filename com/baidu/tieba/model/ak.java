package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends BdAsyncTask<Boolean, Integer, Boolean> {
    private com.baidu.tieba.data.at boo;
    private boolean bpi;
    final /* synthetic */ aj bpj;
    private com.baidu.tbadk.core.util.ac mNetWork = null;

    public ak(aj ajVar, boolean z) {
        this.bpj = ajVar;
        this.bpi = true;
        this.boo = null;
        this.bpi = z;
        this.boo = new com.baidu.tieba.data.at();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Boolean... boolArr) {
        MarkData markData;
        MarkData markData2;
        MarkData markData3;
        if (this.bpi) {
            this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/addstore");
            j jVar = new j();
            markData3 = this.bpj.bpf;
            jVar.a(markData3);
            this.mNetWork.k("data", jVar.T(0, 1));
        } else {
            this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/rmstore");
            com.baidu.tbadk.core.util.ac acVar = this.mNetWork;
            markData = this.bpj.bpf;
            acVar.k(com.baidu.tbadk.core.frameworkData.a.USER_ID, markData.getAccount());
            com.baidu.tbadk.core.util.ac acVar2 = this.mNetWork;
            markData2 = this.bpj.bpf;
            acVar2.k("tid", markData2.getId());
        }
        this.boo.parserJson(this.mNetWork.lA());
        boolean z = this.boo.getErrorCode() == 0;
        if (this.mNetWork.mc().nb().jq() && z) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        this.bpj.bpg = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        al alVar;
        al alVar2;
        al alVar3;
        al alVar4;
        al alVar5;
        try {
            if (bool.booleanValue()) {
                alVar4 = this.bpj.bph;
                if (alVar4 != null) {
                    alVar5 = this.bpj.bph;
                    alVar5.a(true, this.bpi, null);
                }
            } else {
                alVar = this.bpj.bph;
                if (alVar != null) {
                    if (this.mNetWork == null || this.mNetWork.mc().nb().jq()) {
                        alVar2 = this.bpj.bph;
                        alVar2.a(false, this.bpi, this.boo.getErrorString());
                    } else {
                        alVar3 = this.bpj.bph;
                        alVar3.a(false, this.bpi, this.mNetWork.getErrorString());
                    }
                }
            }
            this.bpj.bpg = null;
        } catch (Throwable th) {
            BdLog.e(th.toString());
        }
    }
}
