package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class a implements a.InterfaceC0042a {
    final /* synthetic */ FillUProfileActivity cGm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FillUProfileActivity fillUProfileActivity) {
        this.cGm = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void cj(String str) {
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void a(AccountData accountData) {
        if (accountData.getAccount() != null && !"".equals(accountData.getAccount())) {
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setCurrentAccount(accountData, this.cGm.getPageContext().getPageActivity());
            this.cGm.anL();
            return;
        }
        this.cGm.j(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void c(String str, int i, String str2) {
        this.cGm.showToast(str2);
    }
}
