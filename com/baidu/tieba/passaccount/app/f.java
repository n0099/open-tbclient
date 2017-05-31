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
    final /* synthetic */ LoginActivity efm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LoginActivity loginActivity) {
        this.efm = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0035a
    public void cf(String str) {
        if (this.efm.getLoadingDialog() == null || !this.efm.getLoadingDialog().isShowing()) {
            this.efm.showLoadingDialog(this.efm.getPageContext().getString(w.l.sapi_logining), new g(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0035a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.efm.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            q(accountData);
            this.efm.aHE();
            i = this.efm.mFrom;
            if (i != 4) {
                this.efm.aHC();
                return;
            } else {
                this.efm.Kk();
                return;
            }
        }
        this.efm.k(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0035a
    public void b(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.efm.closeLoadingDialog();
        this.efm.showToast(str2);
        if (com.baidu.adp.lib.util.i.hk()) {
            sapiWebView = this.efm.efe;
            if (sapiWebView != null) {
                sapiWebView2 = this.efm.efe;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void q(AccountData accountData) {
        com.baidu.adp.lib.g.k.fT().e(new h(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.efm.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.ar(TbadkCoreApplication.m9getInst());
    }
}
