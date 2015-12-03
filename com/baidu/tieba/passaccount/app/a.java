package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class a implements a.InterfaceC0041a {
    final /* synthetic */ FillUProfileActivity cwc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FillUProfileActivity fillUProfileActivity) {
        this.cwc = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void ci(String str) {
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void a(AccountData accountData) {
        if (accountData.getAccount() != null && !"".equals(accountData.getAccount())) {
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setCurrentAccount(accountData, this.cwc.getPageContext().getPageActivity());
            this.cwc.aiI();
            return;
        }
        this.cwc.n(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void c(String str, int i, String str2) {
        this.cwc.showToast(str2);
    }
}
