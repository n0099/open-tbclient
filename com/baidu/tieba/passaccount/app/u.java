package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends AuthorizationListener {
    final /* synthetic */ SapiFastRegActivity eoq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SapiFastRegActivity sapiFastRegActivity) {
        this.eoq = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_success", 0, "", new Object[0]);
        this.eoq.aLz();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_fail", i, str, new Object[0]);
        if (str != null && !"".equals(str)) {
            this.eoq.showToast(str);
        } else {
            this.eoq.showToast(w.l.data_load_error);
        }
        this.eoq.finish();
    }
}
