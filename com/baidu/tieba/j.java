package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
class j implements p.a {
    final /* synthetic */ i aHN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aHN = iVar;
    }

    @Override // com.baidu.tieba.p.a
    public void HZ() {
        LogoActivity logoActivity;
        LogoActivity logoActivity2;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        LogoActivity logoActivity5;
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            logoActivity4 = this.aHN.aHJ;
            logoActivity5 = this.aHN.aHJ;
            logoActivity4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(logoActivity5.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, true)));
        } else {
            logoActivity = this.aHN.aHJ;
            logoActivity2 = this.aHN.aHJ;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(logoActivity2.getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        logoActivity3 = this.aHN.aHJ;
        logoActivity3.finish();
    }
}
