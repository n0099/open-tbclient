package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements k.a {
    final /* synthetic */ LoginActivity czQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(LoginActivity loginActivity) {
        this.czQ = loginActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.k.a
    public void i(AccountData accountData) {
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, this.czQ.getPageContext().getPageActivity());
        this.czQ.GM();
        this.czQ.ajO();
    }
}
