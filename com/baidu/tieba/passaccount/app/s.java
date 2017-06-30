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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class s implements a.InterfaceC0037a {
    final /* synthetic */ SapiFastRegActivity eoq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SapiFastRegActivity sapiFastRegActivity) {
        this.eoq = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0037a
    public void cl(String str) {
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0037a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_cslogin_success", 0, "", new Object[0]);
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            this.eoq.eoo = RegisterActivityConfig.LOGIN_USER;
            this.eoq.r(accountData);
            return;
        }
        this.eoq.k(accountData);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.passaccount.app.SapiFastRegActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.a.a.InterfaceC0037a
    public void b(String str, int i, String str2) {
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_cslogin_fail", i, str2, new Object[0]);
        this.eoq.showToast(w.l.register_retry);
        TbadkCoreApplication.m9getInst().login(this.eoq.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.eoq.getPageContext().getPageActivity(), (String) null, true, 11003)));
        this.eoq.finish();
    }
}
