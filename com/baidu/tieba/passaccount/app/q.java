package com.baidu.tieba.passaccount.app;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.VoiceCheckActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements SapiWebView.VoiceLoginHandler {
    final /* synthetic */ LoginActivity dIF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(LoginActivity loginActivity) {
        this.dIF = loginActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.VoiceLoginHandler
    public void handleVoiceLogin() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_voice_start", 0, "", new Object[0]);
        this.dIF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VoiceCheckActivityConfig(this.dIF.getPageContext().getPageActivity())));
    }
}
