package com.baidu.tieba.passaccount.app;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements a.InterfaceC0031a {
    final /* synthetic */ QALoginActivity eeM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(QALoginActivity qALoginActivity) {
        this.eeM = qALoginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0031a
    public void bY(String str) {
        if (this.eeM.getLoadingDialog() == null || !this.eeM.getLoadingDialog().isShowing()) {
            this.eeM.showLoadingDialog(this.eeM.getPageContext().getString(w.l.sapi_logining), new v(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0031a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.eeM.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.eeM.showToast("用户名为空");
            return;
        }
        q(accountData);
        i = this.eeM.mFrom;
        if (i == 4) {
            this.eeM.LA();
        } else {
            this.eeM.aIp();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0031a
    public void b(String str, int i, String str2) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.eeM.closeLoadingDialog();
        this.eeM.showToast(str2);
        this.eeM.finish();
    }

    private void q(AccountData accountData) {
        com.baidu.adp.lib.g.k.fN().e(new w(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.eeM.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.ap(TbadkCoreApplication.m9getInst());
    }
}
