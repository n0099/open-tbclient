package com.baidu.tieba.passaccount.app;

import android.text.TextUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0033a {
    final /* synthetic */ LoginActivity dTt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LoginActivity loginActivity) {
        this.dTt = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void ch(String str) {
        if (this.dTt.getLoadingDialog() == null || !this.dTt.getLoadingDialog().isShowing()) {
            this.dTt.showLoadingDialog(this.dTt.getPageContext().getString(r.j.sapi_logining), new m(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.dTt.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            q(accountData);
            this.dTt.aHn();
            i = this.dTt.mFrom;
            if (i != 4) {
                this.dTt.aHk();
                return;
            } else {
                this.dTt.Mg();
                return;
            }
        }
        this.dTt.k(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.dTt.closeLoadingDialog();
        this.dTt.showToast(str2);
        if (com.baidu.adp.lib.util.i.gm()) {
            sapiWebView = this.dTt.dTm;
            if (sapiWebView != null) {
                sapiWebView2 = this.dTt.dTm;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void q(AccountData accountData) {
        com.baidu.adp.lib.h.k.eH().e(new n(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.dTt.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.P(TbadkCoreApplication.m9getInst());
    }
}
