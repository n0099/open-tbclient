package com.baidu.tieba.passaccount.app;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SocialLoginActivityConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    final /* synthetic */ LoginActivity efm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LoginActivity loginActivity) {
        this.efm = loginActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == SocialType.WEIXIN.getType()) {
            com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_weixin_start", 0, "", new Object[0]);
            this.efm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WXEntryActivityConfig(this.efm.getPageContext().getPageActivity(), 230016)));
            return;
        }
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_qq_start", 0, "", new Object[0]);
        this.efm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SocialLoginActivityConfig(this.efm.getPageContext().getPageActivity(), SocialType.getSocialType(message.what), 230012)));
    }
}
