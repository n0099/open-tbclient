package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d eeX;
    private final /* synthetic */ AccountData eeY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, AccountData accountData) {
        this.eeX = dVar;
        this.eeY = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.eeY != null) {
            com.baidu.tbadk.core.a.b.b(this.eeY);
            com.baidu.tbadk.core.a.b.c(this.eeY);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.eeY, this.eeY.getBDUSS(), this.eeY.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.eeY, TbadkCoreApplication.m9getInst().getApp());
        }
        return null;
    }
}
