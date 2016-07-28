package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.q;
/* loaded from: classes.dex */
class k implements q.a {
    final /* synthetic */ j aIn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aIn = jVar;
    }

    @Override // com.baidu.tieba.q.a
    public void onCompleted() {
        LogoActivity logoActivity;
        LogoActivity logoActivity2;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        LogoActivity logoActivity5;
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            logoActivity = this.aIn.aIj;
            logoActivity2 = this.aIn.aIj;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(logoActivity2.getPageContext().getPageActivity()).createNormalCfg(1)));
        } else {
            boolean z = com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("has_shown_app_guide", false);
            logoActivity4 = this.aIn.aIj;
            logoActivity5 = this.aIn.aIj;
            logoActivity4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(logoActivity5.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, z ? 1 : 3)));
        }
        logoActivity3 = this.aIn.aIj;
        logoActivity3.finish();
    }
}
