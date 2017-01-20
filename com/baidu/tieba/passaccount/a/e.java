package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d ecC;
    private final /* synthetic */ AccountData ecD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, AccountData accountData) {
        this.ecC = dVar;
        this.ecD = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.ecD != null) {
            com.baidu.tbadk.core.a.b.b(this.ecD);
            com.baidu.tbadk.core.a.b.c(this.ecD);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.ecD, this.ecD.getBDUSS(), this.ecD.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.ecD, TbadkCoreApplication.m9getInst().getApp());
        }
        return null;
    }
}
