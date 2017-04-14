package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
class m implements s.a {
    final /* synthetic */ l aQj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.aQj = lVar;
    }

    @Override // com.baidu.tieba.s.a
    public void onCompleted() {
        LogoActivity logoActivity;
        LogoActivity logoActivity2;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        LogoActivity logoActivity5;
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            logoActivity4 = this.aQj.aQg;
            logoActivity5 = this.aQj.aQg;
            logoActivity4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(logoActivity5.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 2)));
        } else {
            logoActivity = this.aQj.aQg;
            logoActivity2 = this.aQj.aQg;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(logoActivity2.getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        logoActivity3 = this.aQj.aQg;
        logoActivity3.finish();
    }
}
