package com.baidu.tieba.passaccount.app;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends AuthorizationListener {
    final /* synthetic */ LoginActivity ecR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LoginActivity loginActivity) {
        this.ecR = loginActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_success", 0, "", new Object[0]);
        this.ecR.aIz();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_fail", i, str, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            this.ecR.showToast(w.l.data_load_error);
        } else {
            this.ecR.showToast(str);
        }
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public boolean onForgetPwd() {
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_pass_forgetpwd", 0, "", new Object[0]);
        this.ecR.startActivity(new Intent(this.ecR.getPageContext().getPageActivity(), ForgetPwdActivity.class));
        return true;
    }
}
