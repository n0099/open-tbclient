package com.baidu.tieba.passaccount.app;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends AuthorizationListener {
    final /* synthetic */ LoginActivity cZE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(LoginActivity loginActivity) {
        this.cZE = loginActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_success", 0, "", new Object[0]);
        this.cZE.auA();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_fail", i, str, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            this.cZE.showToast(t.j.data_load_error);
        } else {
            this.cZE.showToast(str);
        }
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public boolean onForgetPwd() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_forgetpwd", 0, "", new Object[0]);
        this.cZE.startActivity(new Intent(this.cZE.getPageContext().getPageActivity(), ForgetPwdActivity.class));
        return true;
    }
}
