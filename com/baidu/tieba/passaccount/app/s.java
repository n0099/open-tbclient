package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements j.a {
    final /* synthetic */ LoginActivity egU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(LoginActivity loginActivity) {
        this.egU = loginActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public void j(AccountData accountData) {
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, this.egU.getPageContext().getPageActivity());
        this.egU.LC();
        this.egU.aKP();
    }
}
