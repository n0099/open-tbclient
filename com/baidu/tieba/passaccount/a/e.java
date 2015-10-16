package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d cdA;
    private final /* synthetic */ AccountData cdB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, AccountData accountData) {
        this.cdA = dVar;
        this.cdB = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.cdB != null) {
            com.baidu.tbadk.core.a.b.b(this.cdB);
            com.baidu.tbadk.core.a.b.c(this.cdB);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.cdB, this.cdB.getBDUSS(), this.cdB.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.cdB, TbadkCoreApplication.m411getInst().getApp());
        }
        return null;
    }
}
