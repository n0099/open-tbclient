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
    final /* synthetic */ QALoginActivity efm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(QALoginActivity qALoginActivity) {
        this.efm = qALoginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0030a
    public void cf(String str) {
        if (this.efm.getLoadingDialog() == null || !this.efm.getLoadingDialog().isShowing()) {
            this.efm.showLoadingDialog(this.efm.getPageContext().getString(w.l.sapi_logining), new p(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0030a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.efm.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.efm.showToast("用户名为空");
            return;
        }
        q(accountData);
        i = this.efm.mFrom;
        if (i == 4) {
            this.efm.Mb();
        } else {
            this.efm.aJz();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0030a
    public void b(String str, int i, String str2) {
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.efm.closeLoadingDialog();
        this.efm.showToast(str2);
        this.efm.finish();
    }

    private void q(AccountData accountData) {
        com.baidu.adp.lib.g.k.fT().e(new q(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.efm.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.ar(TbadkCoreApplication.m9getInst());
    }
}
