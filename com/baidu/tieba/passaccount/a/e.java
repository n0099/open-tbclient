package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d ehg;
    private final /* synthetic */ AccountData ehh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, AccountData accountData) {
        this.ehg = dVar;
        this.ehh = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.ehh != null) {
            com.baidu.tbadk.core.a.b.b(this.ehh);
            com.baidu.tbadk.core.a.b.c(this.ehh);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.ehh, this.ehh.getBDUSS(), this.ehh.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.ehh, TbadkCoreApplication.m9getInst().getApp());
        }
        return null;
    }
}
