package com.baidu.tieba.passaccount.app;

import android.text.TextUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.InterfaceC0035a {
    final /* synthetic */ LoginActivity dZQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LoginActivity loginActivity) {
        this.dZQ = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0035a
    public void cf(String str) {
        if (this.dZQ.getLoadingDialog() == null || !this.dZQ.getLoadingDialog().isShowing()) {
            this.dZQ.showLoadingDialog(this.dZQ.getPageContext().getString(w.l.sapi_logining), new g(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0035a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.dZQ.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            q(accountData);
            this.dZQ.aGI();
            i = this.dZQ.mFrom;
            if (i != 4) {
                this.dZQ.aGG();
                return;
            } else {
                this.dZQ.Lp();
                return;
            }
        }
        this.dZQ.k(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0035a
    public void b(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.dZQ.closeLoadingDialog();
        this.dZQ.showToast(str2);
        if (com.baidu.adp.lib.util.i.hk()) {
            sapiWebView = this.dZQ.dZI;
            if (sapiWebView != null) {
                sapiWebView2 = this.dZQ.dZI;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void q(AccountData accountData) {
        com.baidu.adp.lib.g.k.fT().e(new h(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.dZQ.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.ar(TbadkCoreApplication.m9getInst());
    }
}
