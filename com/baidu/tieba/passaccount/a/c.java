package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.passaccount.a.f;
/* loaded from: classes.dex */
class c extends BdAsyncTask<Void, Void, AccountData> {
    final /* synthetic */ b cdZ;
    private final /* synthetic */ String cea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.cdZ = bVar;
        this.cea = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public AccountData doInBackground(Void... voidArr) {
        return com.baidu.tbadk.core.a.b.cd(this.cea);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public void onPostExecute(AccountData accountData) {
        a aVar;
        f.a aVar2;
        super.onPostExecute(accountData);
        if (accountData != null && !as.isEmpty(accountData.getPassword())) {
            String account = accountData.getAccount();
            String password = accountData.getPassword();
            aVar = this.cdZ.cdY;
            aVar2 = aVar.cdX;
            f.a(account, password, aVar2);
        }
    }
}
