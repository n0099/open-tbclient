package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ FillUProfileActivity dbP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FillUProfileActivity fillUProfileActivity) {
        this.dbP = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public void i(AccountData accountData) {
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, this.dbP.getPageContext().getPageActivity());
        this.dbP.auI();
    }
}
