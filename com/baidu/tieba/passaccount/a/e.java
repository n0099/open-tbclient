package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d dTJ;
    private final /* synthetic */ AccountData dTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, AccountData accountData) {
        this.dTJ = dVar;
        this.dTK = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.dTK != null) {
            com.baidu.tbadk.core.a.b.b(this.dTK);
            com.baidu.tbadk.core.a.b.c(this.dTK);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.dTK, this.dTK.getBDUSS(), this.dTK.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.dTK, TbadkCoreApplication.m9getInst().getApp());
        }
        return null;
    }
}
