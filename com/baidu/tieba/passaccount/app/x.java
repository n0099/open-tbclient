package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends AuthorizationListener {
    final /* synthetic */ SapiFastRegActivity dce;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SapiFastRegActivity sapiFastRegActivity) {
        this.dce = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_success", 0, "", new Object[0]);
        this.dce.auJ();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_fail", i, str, new Object[0]);
        if (str != null && !"".equals(str)) {
            this.dce.showToast(str);
        } else {
            this.dce.showToast(t.j.data_load_error);
        }
        this.dce.finish();
    }
}
