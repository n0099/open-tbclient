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
    final /* synthetic */ LoginActivity cwm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LoginActivity loginActivity) {
        this.cwm = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void ci(String str) {
        if (this.cwm.getLoadingDialog() == null || !this.cwm.getLoadingDialog().isShowing()) {
            this.cwm.showLoadingDialog(this.cwm.getPageContext().getString(n.i.sapi_logining), new l(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.cwm.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            p(accountData);
            this.cwm.GX();
            i = this.cwm.mFrom;
            if (i != 4) {
                this.cwm.aiI();
                return;
            } else {
                this.cwm.GY();
                return;
            }
        }
        this.cwm.n(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void c(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.cwm.closeLoadingDialog();
        this.cwm.showToast(str2);
        if (com.baidu.adp.lib.util.i.iP()) {
            sapiWebView = this.cwm.cwe;
            if (sapiWebView != null) {
                sapiWebView2 = this.cwm.cwe;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void p(AccountData accountData) {
        com.baidu.adp.lib.h.k.hk().b(new m(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.cwm.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.W(TbadkCoreApplication.m411getInst());
    }
}
