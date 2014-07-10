package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<Integer, com.baidu.tieba.data.q, com.baidu.tieba.data.q> {
    final /* synthetic */ q a;
    private com.baidu.tieba.a.b b = null;

    public r(q qVar) {
        this.a = qVar;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public com.baidu.tieba.data.q doInBackground(Integer... numArr) {
        try {
            if (this.b == null) {
                this.b = new com.baidu.tieba.a.b();
            }
            String num = numArr[0].toString();
            if (numArr.length > 1 ? numArr[1].intValue() == 1 : false) {
                publishProgress(this.a.h());
                if (numArr[1].intValue() == 1) {
                    return null;
                }
            }
            String b = this.b.b(num);
            if (!this.b.c() || b == null) {
                return null;
            }
            com.baidu.tieba.data.q qVar = new com.baidu.tieba.data.q();
            qVar.a(b);
            if (num.equals(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK) && this.b.e() == 0 && qVar.g() == 0) {
                a(b);
            }
            return qVar;
        } catch (Exception e) {
            this.a.g = 0;
            BdLog.e(e.getMessage().toString());
            return null;
        }
    }

    private void a(String str) {
        com.baidu.adp.lib.cache.s<String> k;
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && (k = com.baidu.tbadk.core.a.b.a().k()) != null) {
            k.a("home_forumfeed_" + currentAccount, str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(com.baidu.tieba.data.q... qVarArr) {
        com.baidu.adp.base.h hVar;
        super.onProgressUpdate(qVarArr);
        s sVar = new s(this.a);
        sVar.b = 3;
        sVar.a = qVarArr.length > 0 ? qVarArr[0] : null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(sVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.data.q qVar) {
        int i;
        com.baidu.adp.base.h hVar;
        com.baidu.tieba.data.q qVar2;
        com.baidu.tieba.data.q qVar3;
        int i2;
        com.baidu.tieba.data.q qVar4;
        com.baidu.adp.base.h hVar2;
        this.b.a();
        if (b(qVar)) {
            hVar2 = this.a.mLoadDataCallBack;
            hVar2.a(null);
        } else {
            i = this.a.f;
            if (i != 1) {
                qVar3 = this.a.d;
                if (qVar3 != null) {
                    i2 = this.a.f;
                    if (i2 == 2) {
                        if (this.a.a()) {
                            this.a.d = qVar;
                        } else {
                            qVar4 = this.a.d;
                            qVar4.a(qVar, true);
                        }
                    }
                    hVar = this.a.mLoadDataCallBack;
                    qVar2 = this.a.d;
                    hVar.a(qVar2);
                }
            }
            this.a.d = qVar;
            hVar = this.a.mLoadDataCallBack;
            qVar2 = this.a.d;
            hVar.a(qVar2);
        }
        this.a.g = 0;
    }

    private boolean b(com.baidu.tieba.data.q qVar) {
        if (qVar == null || this.b.e() != 0) {
            this.a.setErrorCode(this.b.e());
            this.a.setErrorString(this.b.f());
            return true;
        } else if (qVar != null && qVar.g() != 0) {
            this.a.setErrorCode(qVar.g());
            this.a.setErrorString(qVar.h());
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
        if (this.b != null) {
            this.b.a();
        }
    }
}
