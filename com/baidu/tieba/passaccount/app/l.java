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
    final /* synthetic */ LoginActivity egU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LoginActivity loginActivity) {
        this.egU = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void cf(String str) {
        if (this.egU.getLoadingDialog() == null || !this.egU.getLoadingDialog().isShowing()) {
            this.egU.showLoadingDialog(this.egU.getPageContext().getString(t.j.sapi_logining), new m(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.egU.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            q(accountData);
            this.egU.LC();
            i = this.egU.mFrom;
            if (i != 4) {
                this.egU.aKP();
                return;
            } else {
                this.egU.LD();
                return;
            }
        }
        this.egU.k(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.egU.closeLoadingDialog();
        this.egU.showToast(str2);
        if (com.baidu.adp.lib.util.i.gm()) {
            sapiWebView = this.egU.egN;
            if (sapiWebView != null) {
                sapiWebView2 = this.egU.egN;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void q(AccountData accountData) {
        com.baidu.adp.lib.h.k.eH().e(new n(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.egU.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.R(TbadkCoreApplication.m9getInst());
    }
}
