package com.baidu.tieba.tblauncher;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements a.InterfaceC0042a {
    final /* synthetic */ aa etY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(aa aaVar) {
        this.etY = aaVar;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void cg(String str) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        MainTabActivity mainTabActivity3;
        MainTabActivity mainTabActivity4;
        mainTabActivity = this.etY.etM;
        if (mainTabActivity.getLoadingDialog() != null) {
            mainTabActivity4 = this.etY.etM;
            if (mainTabActivity4.getLoadingDialog().isShowing()) {
                return;
            }
        }
        mainTabActivity2 = this.etY.etM;
        mainTabActivity3 = this.etY.etM;
        mainTabActivity2.showLoadingDialog(mainTabActivity3.getPageContext().getString(t.j.sapi_logining), new ak(this));
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void a(AccountData accountData) {
        MainTabActivity mainTabActivity;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        mainTabActivity = this.etY.etM;
        mainTabActivity.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.etY.j(accountData);
        } else {
            this.etY.o(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void b(String str, int i, String str2) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        mainTabActivity = this.etY.etM;
        mainTabActivity.closeLoadingDialog();
        mainTabActivity2 = this.etY.etM;
        mainTabActivity2.showToast(str2);
    }
}
