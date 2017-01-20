package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class a implements a.InterfaceC0032a {
    final /* synthetic */ FillUProfileActivity ecd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FillUProfileActivity fillUProfileActivity) {
        this.ecd = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0032a
    public void cf(String str) {
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0032a
    public void a(AccountData accountData) {
        if (accountData.getAccount() != null && !"".equals(accountData.getAccount())) {
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setCurrentAccount(accountData, this.ecd.getPageContext().getPageActivity());
            this.ecd.aIY();
            return;
        }
        this.ecd.k(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0032a
    public void b(String str, int i, String str2) {
        this.ecd.showToast(str2);
    }
}
