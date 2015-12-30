package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d cAd;
    private final /* synthetic */ AccountData cAe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, AccountData accountData) {
        this.cAd = dVar;
        this.cAe = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.cAe != null) {
            com.baidu.tbadk.core.a.b.b(this.cAe);
            com.baidu.tbadk.core.a.b.c(this.cAe);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.cAe, this.cAe.getBDUSS(), this.cAe.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.cAe, TbadkCoreApplication.m411getInst().getApp());
        }
        return null;
    }
}
