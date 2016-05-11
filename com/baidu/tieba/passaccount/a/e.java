package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d dcm;
    private final /* synthetic */ AccountData dcn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, AccountData accountData) {
        this.dcm = dVar;
        this.dcn = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.dcn != null) {
            com.baidu.tbadk.core.a.b.b(this.dcn);
            com.baidu.tbadk.core.a.b.c(this.dcn);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.dcn, this.dcn.getBDUSS(), this.dcn.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.dcn, TbadkCoreApplication.m11getInst().getApp());
        }
        return null;
    }
}
