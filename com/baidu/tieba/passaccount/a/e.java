package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d ceb;
    private final /* synthetic */ AccountData cec;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, AccountData accountData) {
        this.ceb = dVar;
        this.cec = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.cec != null) {
            com.baidu.tbadk.core.a.b.b(this.cec);
            com.baidu.tbadk.core.a.b.c(this.cec);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.cec, this.cec.getBDUSS(), this.cec.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.cec, TbadkCoreApplication.m411getInst().getApp());
        }
        return null;
    }
}
