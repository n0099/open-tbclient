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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class u implements a.InterfaceC0041a {
    final /* synthetic */ SapiFastRegActivity czV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SapiFastRegActivity sapiFastRegActivity) {
        this.czV = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void ck(String str) {
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_cslogin_success", 0, "", new Object[0]);
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            this.czV.czT = RegisterActivityConfig.LOGIN_USER;
            this.czV.q(accountData);
            return;
        }
        this.czV.n(accountData);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.passaccount.app.SapiFastRegActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void c(String str, int i, String str2) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_cslogin_fail", i, str2, new Object[0]);
        this.czV.showToast(n.j.register_retry);
        TbadkCoreApplication.m411getInst().login(this.czV.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.czV.getPageContext().getPageActivity(), (String) null, true, 11003)));
        this.czV.finish();
    }
}
