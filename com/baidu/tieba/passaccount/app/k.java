package com.baidu.tieba.passaccount.app;

import android.text.TextUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0041a {
    final /* synthetic */ LoginActivity czQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LoginActivity loginActivity) {
        this.czQ = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void ck(String str) {
        if (this.czQ.getLoadingDialog() == null || !this.czQ.getLoadingDialog().isShowing()) {
            this.czQ.showLoadingDialog(this.czQ.getPageContext().getString(n.j.sapi_logining), new l(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.czQ.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            p(accountData);
            this.czQ.GM();
            i = this.czQ.mFrom;
            if (i != 4) {
                this.czQ.ajO();
                return;
            } else {
                this.czQ.GN();
                return;
            }
        }
        this.czQ.n(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void c(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.czQ.closeLoadingDialog();
        this.czQ.showToast(str2);
        if (com.baidu.adp.lib.util.i.iQ()) {
            sapiWebView = this.czQ.czI;
            if (sapiWebView != null) {
                sapiWebView2 = this.czQ.czI;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void p(AccountData accountData) {
        com.baidu.adp.lib.h.k.hk().b(new m(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.czQ.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.W(TbadkCoreApplication.m411getInst());
    }
}
