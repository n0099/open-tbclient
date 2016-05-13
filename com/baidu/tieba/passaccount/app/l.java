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
public class l implements a.InterfaceC0033a {
    final /* synthetic */ LoginActivity dbZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LoginActivity loginActivity) {
        this.dbZ = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void ce(String str) {
        if (this.dbZ.getLoadingDialog() == null || !this.dbZ.getLoadingDialog().isShowing()) {
            this.dbZ.showLoadingDialog(this.dbZ.getPageContext().getString(t.j.sapi_logining), new m(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.dbZ.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            p(accountData);
            this.dbZ.Ic();
            i = this.dbZ.mFrom;
            if (i != 4) {
                this.dbZ.auI();
                return;
            } else {
                this.dbZ.Id();
                return;
            }
        }
        this.dbZ.j(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.dbZ.closeLoadingDialog();
        this.dbZ.showToast(str2);
        if (com.baidu.adp.lib.util.i.fq()) {
            sapiWebView = this.dbZ.dbR;
            if (sapiWebView != null) {
                sapiWebView2 = this.dbZ.dbR;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void p(AccountData accountData) {
        com.baidu.adp.lib.h.k.dM().b(new n(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.dbZ.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.I(TbadkCoreApplication.m11getInst());
    }
}
