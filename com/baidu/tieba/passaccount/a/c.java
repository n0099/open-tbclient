package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.passaccount.a.f;
/* loaded from: classes.dex */
class c extends BdAsyncTask<Void, Void, AccountData> {
    final /* synthetic */ b cAb;
    private final /* synthetic */ String cAc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.cAb = bVar;
        this.cAc = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public AccountData doInBackground(Void... voidArr) {
        return com.baidu.tbadk.core.a.b.cm(this.cAc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public void onPostExecute(AccountData accountData) {
        a aVar;
        f.a aVar2;
        super.onPostExecute(accountData);
        if (accountData != null && !ax.isEmpty(accountData.getPassword())) {
            String account = accountData.getAccount();
            String password = accountData.getPassword();
            aVar = this.cAb.cAa;
            aVar2 = aVar.czZ;
            f.a(account, password, aVar2);
        }
    }
}
