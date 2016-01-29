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
    final /* synthetic */ LoginActivity cGw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LoginActivity loginActivity) {
        this.cGw = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void cj(String str) {
        if (this.cGw.getLoadingDialog() == null || !this.cGw.getLoadingDialog().isShowing()) {
            this.cGw.showLoadingDialog(this.cGw.getPageContext().getString(t.j.sapi_logining), new l(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.cGw.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            p(accountData);
            this.cGw.In();
            i = this.cGw.mFrom;
            if (i != 4) {
                this.cGw.anL();
                return;
            } else {
                this.cGw.Io();
                return;
            }
        }
        this.cGw.j(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void c(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.cGw.closeLoadingDialog();
        this.cGw.showToast(str2);
        if (com.baidu.adp.lib.util.i.iZ()) {
            sapiWebView = this.cGw.cGo;
            if (sapiWebView != null) {
                sapiWebView2 = this.cGw.cGo;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void p(AccountData accountData) {
        com.baidu.adp.lib.h.k.hs().b(new m(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.cGw.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.W(TbadkCoreApplication.m411getInst());
    }
}
