package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements j.a {
    final /* synthetic */ LoginActivity dTt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(LoginActivity loginActivity) {
        this.dTt = loginActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public void j(AccountData accountData) {
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, this.dTt.getPageContext().getPageActivity());
        this.dTt.aHn();
        this.dTt.aHk();
    }
}
