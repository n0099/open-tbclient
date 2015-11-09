package com.baidu.tieba.passaccount.app;

import android.text.TextUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0040a {
    final /* synthetic */ LoginActivity cdO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LoginActivity loginActivity) {
        this.cdO = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void cb(String str) {
        if (this.cdO.getLoadingDialog() == null || !this.cdO.getLoadingDialog().isShowing()) {
            this.cdO.showLoadingDialog(this.cdO.getPageContext().getString(i.h.sapi_logining), new l(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.cdO.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            p(accountData);
            this.cdO.FQ();
            i = this.cdO.mFrom;
            if (i != 4) {
                this.cdO.aep();
                return;
            } else {
                this.cdO.FR();
                return;
            }
        }
        this.cdO.n(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void c(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.cdO.closeLoadingDialog();
        this.cdO.showToast(str2);
        if (com.baidu.adp.lib.util.i.iN()) {
            sapiWebView = this.cdO.cdG;
            if (sapiWebView != null) {
                sapiWebView2 = this.cdO.cdG;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void p(AccountData accountData) {
        com.baidu.adp.lib.g.k.hi().b(new m(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.cdO.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.g.W(TbadkCoreApplication.m411getInst());
    }
}
