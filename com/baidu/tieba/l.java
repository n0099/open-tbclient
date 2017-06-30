package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
class l implements s.a {
    final /* synthetic */ k aRY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.aRY = kVar;
    }

    @Override // com.baidu.tieba.s.a
    public void onCompleted() {
        LogoActivity logoActivity;
        LogoActivity logoActivity2;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        LogoActivity logoActivity5;
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            logoActivity4 = this.aRY.aRW;
            logoActivity5 = this.aRY.aRW;
            logoActivity4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(logoActivity5.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 2)));
        } else {
            logoActivity = this.aRY.aRW;
            logoActivity2 = this.aRY.aRW;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(logoActivity2.getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        logoActivity3 = this.aRY.aRW;
        logoActivity3.finish();
    }
}
