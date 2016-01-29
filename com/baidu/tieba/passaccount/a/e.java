package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d cGJ;
    private final /* synthetic */ AccountData cGK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, AccountData accountData) {
        this.cGJ = dVar;
        this.cGK = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.cGK != null) {
            com.baidu.tbadk.core.a.b.b(this.cGK);
            com.baidu.tbadk.core.a.b.c(this.cGK);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.cGK, this.cGK.getBDUSS(), this.cGK.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.cGK, TbadkCoreApplication.m411getInst().getApp());
        }
        return null;
    }
}
