package com.baidu.tieba.tblauncher;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.InterfaceC0033a {
    final /* synthetic */ ab exg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ab abVar) {
        this.exg = abVar;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void ce(String str) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        MainTabActivity mainTabActivity3;
        MainTabActivity mainTabActivity4;
        mainTabActivity = this.exg.ewR;
        if (mainTabActivity.getLoadingDialog() != null) {
            mainTabActivity4 = this.exg.ewR;
            if (mainTabActivity4.getLoadingDialog().isShowing()) {
                return;
            }
        }
        mainTabActivity2 = this.exg.ewR;
        mainTabActivity3 = this.exg.ewR;
        mainTabActivity2.showLoadingDialog(mainTabActivity3.getPageContext().getString(t.j.sapi_logining), new ar(this));
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        MainTabActivity mainTabActivity;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        mainTabActivity = this.exg.ewR;
        mainTabActivity.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.exg.j(accountData);
        } else {
            this.exg.o(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        mainTabActivity = this.exg.ewR;
        mainTabActivity.closeLoadingDialog();
        mainTabActivity2 = this.exg.ewR;
        mainTabActivity2.showToast(str2);
    }
}
