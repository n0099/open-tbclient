package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ FillUProfileActivity dTk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FillUProfileActivity fillUProfileActivity) {
        this.dTk = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public void j(AccountData accountData) {
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, this.dTk.getPageContext().getPageActivity());
        this.dTk.aHk();
    }
}
