package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements k.a {
    final /* synthetic */ FillUProfileActivity cdd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FillUProfileActivity fillUProfileActivity) {
        this.cdd = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.k.a
    public void i(AccountData accountData) {
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, this.cdd.getPageContext().getPageActivity());
        this.cdd.adU();
    }
}
