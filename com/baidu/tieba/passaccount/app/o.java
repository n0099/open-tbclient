package com.baidu.tieba.passaccount.app;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.InterfaceC0037a {
    final /* synthetic */ QALoginActivity eom;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(QALoginActivity qALoginActivity) {
        this.eom = qALoginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0037a
    public void cl(String str) {
        if (this.eom.getLoadingDialog() == null || !this.eom.getLoadingDialog().isShowing()) {
            this.eom.showLoadingDialog(this.eom.getPageContext().getString(w.l.sapi_logining), new p(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0037a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.eom.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.eom.showToast("用户名为空");
            return;
        }
        q(accountData);
        i = this.eom.mFrom;
        if (i == 4) {
            this.eom.KI();
        } else {
            this.eom.aLv();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0037a
    public void b(String str, int i, String str2) {
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.eom.closeLoadingDialog();
        this.eom.showToast(str2);
        this.eom.finish();
    }

    private void q(AccountData accountData) {
        com.baidu.adp.lib.g.k.fS().e(new q(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.eom.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.g.ar(TbadkCoreApplication.m9getInst());
    }
}
