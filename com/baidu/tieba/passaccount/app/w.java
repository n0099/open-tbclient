package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends AuthorizationListener {
    final /* synthetic */ SapiFastRegActivity cwr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SapiFastRegActivity sapiFastRegActivity) {
        this.cwr = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_success", 0, "", new Object[0]);
        this.cwr.aiM();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_fail", i, str, new Object[0]);
        if (str != null && !"".equals(str)) {
            this.cwr.showToast(str);
        } else {
            this.cwr.showToast(n.i.data_load_error);
        }
        this.cwr.finish();
    }
}
