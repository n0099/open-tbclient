package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements k.a {
    final /* synthetic */ FillUProfileActivity cdE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FillUProfileActivity fillUProfileActivity) {
        this.cdE = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.k.a
    public void i(AccountData accountData) {
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, this.cdE.getPageContext().getPageActivity());
        this.cdE.aep();
    }
}
