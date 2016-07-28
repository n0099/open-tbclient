package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d dVb;
    private final /* synthetic */ AccountData dVc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, AccountData accountData) {
        this.dVb = dVar;
        this.dVc = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.dVc != null) {
            com.baidu.tbadk.core.a.b.b(this.dVc);
            com.baidu.tbadk.core.a.b.c(this.dVc);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.dVc, this.dVc.getBDUSS(), this.dVc.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.dVc, TbadkCoreApplication.m10getInst().getApp());
        }
        return null;
    }
}
