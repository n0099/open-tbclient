package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d eje;
    private final /* synthetic */ AccountData ejf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, AccountData accountData) {
        this.eje = dVar;
        this.ejf = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.ejf != null) {
            com.baidu.tbadk.core.a.b.b(this.ejf);
            com.baidu.tbadk.core.a.b.c(this.ejf);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.ejf, this.ejf.getBDUSS(), this.ejf.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.ejf, TbadkCoreApplication.m9getInst().getApp());
        }
        return null;
    }
}
