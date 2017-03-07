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
public class l implements a.InterfaceC0031a {
    final /* synthetic */ LoginActivity eeH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LoginActivity loginActivity) {
        this.eeH = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0031a
    public void bY(String str) {
        if (this.eeH.getLoadingDialog() == null || !this.eeH.getLoadingDialog().isShowing()) {
            this.eeH.showLoadingDialog(this.eeH.getPageContext().getString(w.l.sapi_logining), new m(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0031a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.eeH.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            q(accountData);
            this.eeH.aIs();
            i = this.eeH.mFrom;
            if (i != 4) {
                this.eeH.aIp();
                return;
            } else {
                this.eeH.LA();
                return;
            }
        }
        this.eeH.k(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0031a
    public void b(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.eeH.closeLoadingDialog();
        this.eeH.showToast(str2);
        if (com.baidu.adp.lib.util.i.he()) {
            sapiWebView = this.eeH.eez;
            if (sapiWebView != null) {
                sapiWebView2 = this.eeH.eez;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void q(AccountData accountData) {
        com.baidu.adp.lib.g.k.fN().e(new n(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.eeH.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.ap(TbadkCoreApplication.m9getInst());
    }
}
