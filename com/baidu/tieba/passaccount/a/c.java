package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.passaccount.a.f;
/* loaded from: classes.dex */
class c extends BdAsyncTask<Void, Void, AccountData> {
    final /* synthetic */ b cZP;
    private final /* synthetic */ String cZQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.cZP = bVar;
        this.cZQ = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public AccountData doInBackground(Void... voidArr) {
        return com.baidu.tbadk.core.a.b.ci(this.cZQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public void onPostExecute(AccountData accountData) {
        a aVar;
        f.a aVar2;
        super.onPostExecute(accountData);
        if (accountData != null && !ay.isEmpty(accountData.getPassword())) {
            String account = accountData.getAccount();
            String password = accountData.getPassword();
            aVar = this.cZP.cZO;
            aVar2 = aVar.cZN;
            f.a(account, password, aVar2);
        }
    }
}
