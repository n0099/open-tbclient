package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d dIS;
    private final /* synthetic */ AccountData dIT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, AccountData accountData) {
        this.dIS = dVar;
        this.dIT = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.dIT != null) {
            com.baidu.tbadk.core.a.b.b(this.dIT);
            com.baidu.tbadk.core.a.b.c(this.dIT);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.dIT, this.dIT.getBDUSS(), this.dIT.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.dIT, TbadkCoreApplication.m9getInst().getApp());
        }
        return null;
    }
}
