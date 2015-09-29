package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d cdp;
    private final /* synthetic */ AccountData cdq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, AccountData accountData) {
        this.cdp = dVar;
        this.cdq = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.cdq != null) {
            com.baidu.tbadk.core.a.b.b(this.cdq);
            com.baidu.tbadk.core.a.b.c(this.cdq);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.cdq, this.cdq.getBDUSS(), this.cdq.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.cdq, TbadkCoreApplication.m411getInst().getApp());
        }
        return null;
    }
}
