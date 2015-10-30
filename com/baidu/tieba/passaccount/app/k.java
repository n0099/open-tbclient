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
    final /* synthetic */ LoginActivity cdn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LoginActivity loginActivity) {
        this.cdn = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void cd(String str) {
        if (this.cdn.getLoadingDialog() == null || !this.cdn.getLoadingDialog().isShowing()) {
            this.cdn.showLoadingDialog(this.cdn.getPageContext().getString(i.h.sapi_logining), new l(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.cdn.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            p(accountData);
            this.cdn.FT();
            i = this.cdn.mFrom;
            if (i != 4) {
                this.cdn.adU();
                return;
            } else {
                this.cdn.FU();
                return;
            }
        }
        this.cdn.n(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void c(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.cdn.closeLoadingDialog();
        this.cdn.showToast(str2);
        if (com.baidu.adp.lib.util.i.iM()) {
            sapiWebView = this.cdn.cdf;
            if (sapiWebView != null) {
                sapiWebView2 = this.cdn.cdf;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void p(AccountData accountData) {
        com.baidu.adp.lib.g.k.hh().b(new m(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.cdn.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.g.W(TbadkCoreApplication.m411getInst());
    }
}
