package com.baidu.tieba.passaccount.app;

import android.text.TextUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0033a {
    final /* synthetic */ LoginActivity dIF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LoginActivity loginActivity) {
        this.dIF = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void cd(String str) {
        if (this.dIF.getLoadingDialog() == null || !this.dIF.getLoadingDialog().isShowing()) {
            this.dIF.showLoadingDialog(this.dIF.getPageContext().getString(u.j.sapi_logining), new m(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.dIF.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            p(accountData);
            this.dIF.Jb();
            i = this.dIF.mFrom;
            if (i != 4) {
                this.dIF.aCN();
                return;
            } else {
                this.dIF.Jc();
                return;
            }
        }
        this.dIF.j(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.dIF.closeLoadingDialog();
        this.dIF.showToast(str2);
        if (com.baidu.adp.lib.util.i.fr()) {
            sapiWebView = this.dIF.dIy;
            if (sapiWebView != null) {
                sapiWebView2 = this.dIF.dIy;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void p(AccountData accountData) {
        com.baidu.adp.lib.h.k.dN().b(new n(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.dIF.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.H(TbadkCoreApplication.m9getInst());
    }
}
