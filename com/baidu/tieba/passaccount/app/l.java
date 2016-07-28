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
    final /* synthetic */ LoginActivity dUO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LoginActivity loginActivity) {
        this.dUO = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void ce(String str) {
        if (this.dUO.getLoadingDialog() == null || !this.dUO.getLoadingDialog().isShowing()) {
            this.dUO.showLoadingDialog(this.dUO.getPageContext().getString(u.j.sapi_logining), new m(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.dUO.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            p(accountData);
            this.dUO.Ja();
            i = this.dUO.mFrom;
            if (i != 4) {
                this.dUO.aFX();
                return;
            } else {
                this.dUO.Jb();
                return;
            }
        }
        this.dUO.j(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.dUO.closeLoadingDialog();
        this.dUO.showToast(str2);
        if (com.baidu.adp.lib.util.i.fq()) {
            sapiWebView = this.dUO.dUH;
            if (sapiWebView != null) {
                sapiWebView2 = this.dUO.dUH;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void p(AccountData accountData) {
        com.baidu.adp.lib.h.k.dM().e(new n(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.dUO.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.H(TbadkCoreApplication.m10getInst());
    }
}
