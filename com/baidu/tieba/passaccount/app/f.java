package com.baidu.tieba.passaccount.app;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.InterfaceC0037a {
    final /* synthetic */ LoginActivity eoh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LoginActivity loginActivity) {
        this.eoh = loginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0037a
    public void cl(String str) {
        if (this.eoh.getLoadingDialog() == null || !this.eoh.getLoadingDialog().isShowing()) {
            this.eoh.showLoadingDialog(this.eoh.getPageContext().getString(w.l.sapi_logining), new g(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0037a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.eoh.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            q(accountData);
            this.eoh.aLx();
            i = this.eoh.mFrom;
            if (i != 4) {
                this.eoh.aLv();
                return;
            } else {
                this.eoh.KI();
                return;
            }
        }
        this.eoh.k(accountData);
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0037a
    public void b(String str, int i, String str2) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.eoh.closeLoadingDialog();
        this.eoh.showToast(str2);
        if (com.baidu.adp.lib.util.i.hj()) {
            sapiWebView = this.eoh.enY;
            if (sapiWebView != null) {
                sapiWebView2 = this.eoh.enY;
                sapiWebView2.loadLogin();
            }
        }
    }

    private void q(AccountData accountData) {
        com.baidu.adp.lib.g.k.fS().e(new h(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.eoh.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.g.ar(TbadkCoreApplication.m9getInst());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_WEBVIEW_LOGIN, true));
    }
}
