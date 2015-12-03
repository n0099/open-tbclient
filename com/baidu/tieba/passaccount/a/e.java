package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ AccountData cwA;
    final /* synthetic */ d cwz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, AccountData accountData) {
        this.cwz = dVar;
        this.cwA = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.cwA != null) {
            com.baidu.tbadk.core.a.b.b(this.cwA);
            com.baidu.tbadk.core.a.b.c(this.cwA);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.cwA, this.cwA.getBDUSS(), this.cwA.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.cwA, TbadkCoreApplication.m411getInst().getApp());
        }
        return null;
    }
}
