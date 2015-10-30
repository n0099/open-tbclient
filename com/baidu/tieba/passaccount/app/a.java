package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class a implements a.InterfaceC0040a {
    final /* synthetic */ FillUProfileActivity cdd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FillUProfileActivity fillUProfileActivity) {
        this.cdd = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void cd(String str) {
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void a(AccountData accountData) {
        if (accountData.getAccount() != null && !"".equals(accountData.getAccount())) {
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setCurrentAccount(accountData, this.cdd.getPageContext().getPageActivity());
            this.cdd.adU();
            return;
        }
        this.cdd.n(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void c(String str, int i, String str2) {
        this.cdd.showToast(str2);
    }
}
