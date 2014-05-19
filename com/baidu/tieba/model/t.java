package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<Integer, com.baidu.tieba.data.p, com.baidu.tieba.data.p> {
    final /* synthetic */ s a;
    private com.baidu.tieba.a.b b = null;

    public t(s sVar) {
        this.a = sVar;
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
    public com.baidu.tieba.data.p doInBackground(Integer... numArr) {
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
            com.baidu.tieba.data.p pVar = new com.baidu.tieba.data.p();
            pVar.a(b);
            if (num.equals(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK) && this.b.e() == 0 && pVar.g() == 0) {
                a(b);
            }
            return pVar;
        } catch (Exception e) {
            this.a.g = 0;
            BdLog.e(s.class.getName(), "GetForumFeedTask.doInBackground", e.getMessage().toString());
            return null;
        }
    }

    private void a(String str) {
        com.baidu.adp.lib.cache.s<String> i;
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && (i = com.baidu.tbadk.core.a.b.a().i()) != null) {
            i.a("home_forumfeed_" + currentAccount, str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(com.baidu.tieba.data.p... pVarArr) {
        com.baidu.adp.base.g gVar;
        super.onProgressUpdate(pVarArr);
        u uVar = new u(this.a);
        uVar.b = 3;
        uVar.a = pVarArr.length > 0 ? pVarArr[0] : null;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(uVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.data.p pVar) {
        int i;
        com.baidu.adp.base.g gVar;
        com.baidu.tieba.data.p pVar2;
        com.baidu.tieba.data.p pVar3;
        int i2;
        com.baidu.tieba.data.p pVar4;
        com.baidu.adp.base.g gVar2;
        this.b.a();
        if (b(pVar)) {
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(null);
        } else {
            i = this.a.f;
            if (i != 1) {
                pVar3 = this.a.d;
                if (pVar3 != null) {
                    i2 = this.a.f;
                    if (i2 == 2) {
                        if (this.a.a()) {
                            this.a.d = pVar;
                        } else {
                            pVar4 = this.a.d;
                            pVar4.a(pVar, true);
                        }
                    }
                    gVar = this.a.mLoadDataCallBack;
                    pVar2 = this.a.d;
                    gVar.a(pVar2);
                }
            }
            this.a.d = pVar;
            gVar = this.a.mLoadDataCallBack;
            pVar2 = this.a.d;
            gVar.a(pVar2);
        }
        this.a.g = 0;
    }

    private boolean b(com.baidu.tieba.data.p pVar) {
        if (pVar == null || this.b.e() != 0) {
            this.a.setErrorCode(this.b.e());
            this.a.setErrorString(this.b.f());
            return true;
        } else if (pVar != null && pVar.g() != 0) {
            this.a.setErrorCode(pVar.g());
            this.a.setErrorString(pVar.h());
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
