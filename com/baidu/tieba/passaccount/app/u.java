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
    final /* synthetic */ QALoginActivity eoR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(QALoginActivity qALoginActivity) {
        this.eoR = qALoginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void cg(String str) {
        if (this.eoR.getLoadingDialog() == null || !this.eoR.getLoadingDialog().isShowing()) {
            this.eoR.showLoadingDialog(this.eoR.getPageContext().getString(r.j.sapi_logining), new v(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.eoR.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.eoR.showToast("用户名为空");
            return;
        }
        q(accountData);
        i = this.eoR.mFrom;
        if (i == 4) {
            this.eoR.MN();
        } else {
            this.eoR.aNj();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.eoR.closeLoadingDialog();
        this.eoR.showToast(str2);
        this.eoR.finish();
    }

    private void q(AccountData accountData) {
        com.baidu.adp.lib.h.k.eH().e(new w(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.eoR.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.R(TbadkCoreApplication.m9getInst());
    }
}
