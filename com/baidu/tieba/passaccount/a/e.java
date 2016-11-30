package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d epc;
    private final /* synthetic */ AccountData epd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, AccountData accountData) {
        this.epc = dVar;
        this.epd = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.epd != null) {
            com.baidu.tbadk.core.a.b.b(this.epd);
            com.baidu.tbadk.core.a.b.c(this.epd);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.epd, this.epd.getBDUSS(), this.epd.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.epd, TbadkCoreApplication.m9getInst().getApp());
        }
        return null;
    }
}
