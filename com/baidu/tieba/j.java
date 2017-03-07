package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
class j implements s.a {
    final /* synthetic */ i aPR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aPR = iVar;
    }

    @Override // com.baidu.tieba.s.a
    public void onCompleted() {
        LogoActivity logoActivity;
        LogoActivity logoActivity2;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        LogoActivity logoActivity5;
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            logoActivity = this.aPR.aPQ;
            logoActivity2 = this.aPR.aPQ;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(logoActivity2.getPageContext().getPageActivity()).createNormalCfg(1)));
        } else {
            boolean z = com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("has_shown_app_guide", false);
            logoActivity4 = this.aPR.aPQ;
            logoActivity5 = this.aPR.aPQ;
            logoActivity4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(logoActivity5.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, z ? 1 : 3)));
        }
        com.baidu.adp.lib.g.k.fN().f(new k(this));
        logoActivity3 = this.aPR.aPQ;
        logoActivity3.finish();
    }
}
