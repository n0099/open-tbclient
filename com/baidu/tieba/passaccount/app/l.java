package com.baidu.tieba.passaccount.app;

import android.text.TextUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0032a {
    final /* synthetic */ LoginActivity ecm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LoginActivity loginActivity) {
        this.ecm = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0032a
    public void cf(String str) {
        if (this.ecm.getLoadingDialog() == null || !this.ecm.getLoadingDialog().isShowing()) {
            this.ecm.showLoadingDialog(this.ecm.getPageContext().getString(r.l.sapi_logining), new m(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0032a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.ecm.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            q(accountData);
            this.ecm.aJb();
            i = this.ecm.mFrom;
            if (i != 4) {
                this.ecm.aIY();
                return;
            } else {
                this.ecm.KV();
                return;
            }
        }
        this.ecm.k(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0032a
    public void b(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.ecm.closeLoadingDialog();
        this.ecm.showToast(str2);
        if (com.baidu.adp.lib.util.i.gk()) {
            sapiWebView = this.ecm.ecf;
            if (sapiWebView != null) {
                sapiWebView2 = this.ecm.ecf;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void q(AccountData accountData) {
        com.baidu.adp.lib.g.k.eF().e(new n(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.ecm.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.R(TbadkCoreApplication.m9getInst());
    }
}
