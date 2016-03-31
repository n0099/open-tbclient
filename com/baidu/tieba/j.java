package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
class j implements p.a {
    final /* synthetic */ i aKJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aKJ = iVar;
    }

    @Override // com.baidu.tieba.p.a
    public void Jv() {
        LogoActivity logoActivity;
        LogoActivity logoActivity2;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        LogoActivity logoActivity5;
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            logoActivity = this.aKJ.aKF;
            logoActivity2 = this.aKJ.aKF;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(logoActivity2.getPageContext().getPageActivity()).createNormalCfg(1)));
        } else {
            boolean z = com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("has_shown_app_guide", false);
            logoActivity4 = this.aKJ.aKF;
            logoActivity5 = this.aKJ.aKF;
            logoActivity4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(logoActivity5.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, z ? 1 : 3)));
        }
        logoActivity3 = this.aKJ.aKF;
        logoActivity3.finish();
    }
}
