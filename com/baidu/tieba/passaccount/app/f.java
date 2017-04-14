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
public class f implements a.InterfaceC0030a {
    final /* synthetic */ LoginActivity ecR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LoginActivity loginActivity) {
        this.ecR = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0030a
    public void cf(String str) {
        if (this.ecR.getLoadingDialog() == null || !this.ecR.getLoadingDialog().isShowing()) {
            this.ecR.showLoadingDialog(this.ecR.getPageContext().getString(w.l.sapi_logining), new g(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0030a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.ecR.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            q(accountData);
            this.ecR.aIA();
            i = this.ecR.mFrom;
            if (i != 4) {
                this.ecR.aIy();
                return;
            } else {
                this.ecR.Mb();
                return;
            }
        }
        this.ecR.k(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0030a
    public void b(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.ecR.closeLoadingDialog();
        this.ecR.showToast(str2);
        if (com.baidu.adp.lib.util.i.hj()) {
            sapiWebView = this.ecR.ecJ;
            if (sapiWebView != null) {
                sapiWebView2 = this.ecR.ecJ;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void q(AccountData accountData) {
        com.baidu.adp.lib.g.k.fS().e(new h(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.ecR.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.ar(TbadkCoreApplication.m9getInst());
    }
}
