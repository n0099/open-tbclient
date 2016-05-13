package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class a implements a.InterfaceC0033a {
    final /* synthetic */ FillUProfileActivity dbP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FillUProfileActivity fillUProfileActivity) {
        this.dbP = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void ce(String str) {
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        if (accountData.getAccount() != null && !"".equals(accountData.getAccount())) {
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setCurrentAccount(accountData, this.dbP.getPageContext().getPageActivity());
            this.dbP.auI();
            return;
        }
        this.dbP.j(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        this.dbP.showToast(str2);
    }
}
