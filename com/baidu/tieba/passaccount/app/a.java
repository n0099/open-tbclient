package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class a implements a.InterfaceC0040a {
    final /* synthetic */ FillUProfileActivity cdE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FillUProfileActivity fillUProfileActivity) {
        this.cdE = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void cb(String str) {
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void a(AccountData accountData) {
        if (accountData.getAccount() != null && !"".equals(accountData.getAccount())) {
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setCurrentAccount(accountData, this.cdE.getPageContext().getPageActivity());
            this.cdE.aep();
            return;
        }
        this.cdE.n(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void c(String str, int i, String str2) {
        this.cdE.showToast(str2);
    }
}
