package com.baidu.tieba.passaccount.app;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements a.InterfaceC0032a {
    final /* synthetic */ QALoginActivity ecr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(QALoginActivity qALoginActivity) {
        this.ecr = qALoginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0032a
    public void cf(String str) {
        if (this.ecr.getLoadingDialog() == null || !this.ecr.getLoadingDialog().isShowing()) {
            this.ecr.showLoadingDialog(this.ecr.getPageContext().getString(r.l.sapi_logining), new v(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0032a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.ecr.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.ecr.showToast("用户名为空");
            return;
        }
        q(accountData);
        i = this.ecr.mFrom;
        if (i == 4) {
            this.ecr.KV();
        } else {
            this.ecr.aIY();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0032a
    public void b(String str, int i, String str2) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.ecr.closeLoadingDialog();
        this.ecr.showToast(str2);
        this.ecr.finish();
    }

    private void q(AccountData accountData) {
        com.baidu.adp.lib.g.k.eF().e(new w(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.ecr.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.R(TbadkCoreApplication.m9getInst());
    }
}
