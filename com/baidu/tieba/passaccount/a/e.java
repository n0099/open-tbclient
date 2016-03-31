package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d cZR;
    private final /* synthetic */ AccountData cZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, AccountData accountData) {
        this.cZR = dVar;
        this.cZS = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.cZS != null) {
            com.baidu.tbadk.core.a.b.b(this.cZS);
            com.baidu.tbadk.core.a.b.c(this.cZS);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.cZS, this.cZS.getBDUSS(), this.cZS.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.cZS, TbadkCoreApplication.m411getInst().getApp());
        }
        return null;
    }
}
