package com.baidu.tieba.passaccount.app;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.InterfaceC0035a {
    final /* synthetic */ QALoginActivity efr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(QALoginActivity qALoginActivity) {
        this.efr = qALoginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0035a
    public void cf(String str) {
        if (this.efr.getLoadingDialog() == null || !this.efr.getLoadingDialog().isShowing()) {
            this.efr.showLoadingDialog(this.efr.getPageContext().getString(w.l.sapi_logining), new p(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0035a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.efr.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.efr.showToast("用户名为空");
            return;
        }
        q(accountData);
        i = this.efr.mFrom;
        if (i == 4) {
            this.efr.Kk();
        } else {
            this.efr.aHC();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0035a
    public void b(String str, int i, String str2) {
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.efr.closeLoadingDialog();
        this.efr.showToast(str2);
        this.efr.finish();
    }

    private void q(AccountData accountData) {
        com.baidu.adp.lib.g.k.fT().e(new q(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.efr.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.ar(TbadkCoreApplication.m9getInst());
    }
}
