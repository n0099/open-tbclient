package com.baidu.tieba.passaccount.app;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements a.InterfaceC0033a {
    final /* synthetic */ QALoginActivity dTy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(QALoginActivity qALoginActivity) {
        this.dTy = qALoginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void ch(String str) {
        if (this.dTy.getLoadingDialog() == null || !this.dTy.getLoadingDialog().isShowing()) {
            this.dTy.showLoadingDialog(this.dTy.getPageContext().getString(r.j.sapi_logining), new v(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.dTy.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.dTy.showToast("用户名为空");
            return;
        }
        q(accountData);
        i = this.dTy.mFrom;
        if (i == 4) {
            this.dTy.Mg();
        } else {
            this.dTy.aHk();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.dTy.closeLoadingDialog();
        this.dTy.showToast(str2);
        this.dTy.finish();
    }

    private void q(AccountData accountData) {
        com.baidu.adp.lib.h.k.eH().e(new w(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.dTy.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.P(TbadkCoreApplication.m9getInst());
    }
}
