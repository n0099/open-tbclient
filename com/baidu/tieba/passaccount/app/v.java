package com.baidu.tieba.passaccount.app;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements a.InterfaceC0033a {
    final /* synthetic */ QALoginActivity eiT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(QALoginActivity qALoginActivity) {
        this.eiT = qALoginActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void cf(String str) {
        if (this.eiT.getLoadingDialog() == null || !this.eiT.getLoadingDialog().isShowing()) {
            this.eiT.showLoadingDialog(this.eiT.getPageContext().getString(r.j.sapi_logining), new w(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        int i;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
        this.eiT.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.eiT.showToast("用户名为空");
            return;
        }
        q(accountData);
        i = this.eiT.mFrom;
        if (i == 4) {
            this.eiT.Mh();
        } else {
            this.eiT.aLq();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
        this.eiT.closeLoadingDialog();
        this.eiT.showToast(str2);
        this.eiT.finish();
    }

    private void q(AccountData accountData) {
        com.baidu.adp.lib.h.k.eH().e(new x(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.eiT.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.R(TbadkCoreApplication.m9getInst());
    }
}
