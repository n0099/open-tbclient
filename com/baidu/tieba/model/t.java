package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<Integer, com.baidu.tieba.data.p, com.baidu.tieba.data.p> {
    private com.baidu.tieba.a.a boQ = null;
    private boolean boR = false;
    final /* synthetic */ s boS;

    public t(s sVar) {
        this.boS = sVar;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public com.baidu.tieba.data.p doInBackground(Integer... numArr) {
        boolean z = true;
        try {
            if (this.boQ == null) {
                this.boQ = new com.baidu.tieba.a.a();
            }
            String num = numArr[0].toString();
            if (numArr.length <= 1) {
                z = false;
            } else if (numArr[1].intValue() != 1) {
                z = false;
            }
            this.boR = z;
            if (this.boR) {
                publishProgress(this.boS.Tw());
                return null;
            }
            String ez = this.boQ.ez(num);
            if (!this.boQ.jq() || ez == null) {
                return null;
            }
            com.baidu.tieba.data.p pVar = new com.baidu.tieba.data.p();
            pVar.parserJson(ez);
            if (num.equals("1") && this.boQ.getErrorCode() == 0 && pVar.getErrorCode() == 0) {
                eS(ez);
            }
            return pVar;
        } catch (Exception e) {
            this.boS.status = 0;
            BdLog.e(e.getMessage().toString());
            return null;
        }
    }

    private void eS(String str) {
        com.baidu.adp.lib.cache.t<String> bd;
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && (bd = com.baidu.tbadk.core.a.a.kS().bd("tb.my_pages")) != null) {
            bd.a("home_forumfeed_" + currentAccount, str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(com.baidu.tieba.data.p... pVarArr) {
        com.baidu.adp.base.h hVar;
        super.onProgressUpdate(pVarArr);
        u uVar = new u(this.boS);
        uVar.boU = 3;
        uVar.boT = pVarArr.length > 0 ? pVarArr[0] : null;
        hVar = this.boS.mLoadDataCallBack;
        hVar.a(uVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(com.baidu.tieba.data.p pVar) {
        int i;
        com.baidu.adp.base.h hVar;
        com.baidu.tieba.data.p pVar2;
        com.baidu.tieba.data.p pVar3;
        int i2;
        com.baidu.tieba.data.p pVar4;
        com.baidu.adp.base.h hVar2;
        this.boQ.cancel();
        if (!this.boR) {
            if (d(pVar)) {
                hVar2 = this.boS.mLoadDataCallBack;
                hVar2.a(null);
            } else {
                i = this.boS.boP;
                if (i != 1) {
                    pVar3 = this.boS.ayk;
                    if (pVar3 != null) {
                        i2 = this.boS.boP;
                        if (i2 == 2) {
                            if (this.boS.Ts()) {
                                this.boS.ayk = pVar;
                            } else {
                                pVar4 = this.boS.ayk;
                                pVar4.a(pVar, true);
                            }
                        }
                        hVar = this.boS.mLoadDataCallBack;
                        pVar2 = this.boS.ayk;
                        hVar.a(pVar2);
                    }
                }
                this.boS.ayk = pVar;
                hVar = this.boS.mLoadDataCallBack;
                pVar2 = this.boS.ayk;
                hVar.a(pVar2);
            }
        }
        this.boS.status = 0;
    }

    private boolean d(com.baidu.tieba.data.p pVar) {
        if (pVar == null || this.boQ.getErrorCode() != 0) {
            this.boS.setErrorCode(this.boQ.getErrorCode());
            this.boS.setErrorString(this.boQ.getErrorMsg());
            return true;
        } else if (pVar != null && pVar.getErrorCode() != 0) {
            this.boS.setErrorCode(pVar.getErrorCode());
            this.boS.setErrorString(pVar.za());
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.boQ != null) {
            this.boQ.cancel();
        }
    }
}
