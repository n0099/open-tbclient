package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class a implements a.InterfaceC0031a {
    final /* synthetic */ FillUProfileActivity eex;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FillUProfileActivity fillUProfileActivity) {
        this.eex = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0031a
    public void bY(String str) {
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0031a
    public void a(AccountData accountData) {
        if (accountData.getAccount() != null && !"".equals(accountData.getAccount())) {
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setCurrentAccount(accountData, this.eex.getPageContext().getPageActivity());
            this.eex.aIp();
            return;
        }
        this.eex.k(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0031a
    public void b(String str, int i, String str2) {
        this.eex.showToast(str2);
    }
}
