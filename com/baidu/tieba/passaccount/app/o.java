package com.baidu.tieba.passaccount.app;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.InterfaceC0030a {
    final /* synthetic */ QALoginActivity ecW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(QALoginActivity qALoginActivity) {
        this.ecW = qALoginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0030a
    public void cf(String str) {
        if (this.ecW.getLoadingDialog() == null || !this.ecW.getLoadingDialog().isShowing()) {
            this.ecW.showLoadingDialog(this.ecW.getPageContext().getString(w.l.sapi_logining), new p(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0030a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.ecW.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.ecW.showToast("用户名为空");
            return;
        }
        q(accountData);
        i = this.ecW.mFrom;
        if (i == 4) {
            this.ecW.Mb();
        } else {
            this.ecW.aIy();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0030a
    public void b(String str, int i, String str2) {
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.ecW.closeLoadingDialog();
        this.ecW.showToast(str2);
        this.ecW.finish();
    }

    private void q(AccountData accountData) {
        com.baidu.adp.lib.g.k.fS().e(new q(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.ecW.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.ar(TbadkCoreApplication.m9getInst());
    }
}
