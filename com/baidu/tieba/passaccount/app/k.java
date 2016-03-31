package com.baidu.tieba.passaccount.app;

import android.text.TextUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0042a {
    final /* synthetic */ LoginActivity cZE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LoginActivity loginActivity) {
        this.cZE = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void cg(String str) {
        if (this.cZE.getLoadingDialog() == null || !this.cZE.getLoadingDialog().isShowing()) {
            this.cZE.showLoadingDialog(this.cZE.getPageContext().getString(t.j.sapi_logining), new l(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.cZE.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            p(accountData);
            this.cZE.JJ();
            i = this.cZE.mFrom;
            if (i != 4) {
                this.cZE.auz();
                return;
            } else {
                this.cZE.JK();
                return;
            }
        }
        this.cZE.j(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void b(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.cZE.closeLoadingDialog();
        this.cZE.showToast(str2);
        if (com.baidu.adp.lib.util.i.jf()) {
            sapiWebView = this.cZE.cZw;
            if (sapiWebView != null) {
                sapiWebView2 = this.cZE.cZw;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void p(AccountData accountData) {
        com.baidu.adp.lib.h.k.hy().b(new m(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.cZE.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.J(TbadkCoreApplication.m411getInst());
    }
}
