package com.baidu.tieba.passaccount.a;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class c extends BdAsyncTask<Void, Void, AccountData> {
    private final /* synthetic */ String dUi;
    final /* synthetic */ b efu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.efu = bVar;
        this.dUi = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public AccountData doInBackground(Void... voidArr) {
        return com.baidu.tbadk.core.a.b.ch(this.dUi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: o */
    public void onPostExecute(AccountData accountData) {
        super.onPostExecute(accountData);
        if (accountData != null && !TextUtils.isEmpty(accountData.getAccount())) {
            com.baidu.tbadk.core.a.b.cg(accountData.getAccount());
        }
    }
}
