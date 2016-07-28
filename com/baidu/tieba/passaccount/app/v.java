package com.baidu.tieba.passaccount.app;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class v implements a.InterfaceC0033a {
    final /* synthetic */ SapiFastRegActivity dUT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SapiFastRegActivity sapiFastRegActivity) {
        this.dUT = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void ce(String str) {
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_cslogin_success", 0, "", new Object[0]);
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            this.dUT.dUR = RegisterActivityConfig.LOGIN_USER;
            this.dUT.q(accountData);
            return;
        }
        this.dUT.j(accountData);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.passaccount.app.SapiFastRegActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_cslogin_fail", i, str2, new Object[0]);
        this.dUT.showToast(u.j.register_retry);
        TbadkCoreApplication.m10getInst().login(this.dUT.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.dUT.getPageContext().getPageActivity(), (String) null, true, 11003)));
        this.dUT.finish();
    }
}
