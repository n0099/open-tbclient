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
    final /* synthetic */ LoginActivity cdc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LoginActivity loginActivity) {
        this.cdc = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void cc(String str) {
        if (this.cdc.getLoadingDialog() == null || !this.cdc.getLoadingDialog().isShowing()) {
            this.cdc.showLoadingDialog(this.cdc.getPageContext().getString(i.h.sapi_logining), new l(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.cdc.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            p(accountData);
            this.cdc.FX();
            i = this.cdc.mFrom;
            if (i != 4) {
                this.cdc.adY();
                return;
            } else {
                this.cdc.FY();
                return;
            }
        }
        this.cdc.n(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void c(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.cdc.closeLoadingDialog();
        this.cdc.showToast(str2);
        if (com.baidu.adp.lib.util.i.iM()) {
            sapiWebView = this.cdc.ccU;
            if (sapiWebView != null) {
                sapiWebView2 = this.cdc.ccU;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void p(AccountData accountData) {
        com.baidu.adp.lib.g.k.hh().b(new m(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.cdc.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.g.W(TbadkCoreApplication.m411getInst());
    }
}
