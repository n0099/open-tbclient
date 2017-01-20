package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class j implements n.a {
    final /* synthetic */ i aKj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aKj = iVar;
    }

    @Override // com.baidu.tieba.n.a
    public void onCompleted() {
        LogoActivity logoActivity;
        boolean IM;
        LogoActivity logoActivity2;
        LogoActivity.a aVar;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        logoActivity = this.aKj.aKf;
        IM = logoActivity.IM();
        if (IM) {
            MessageManager messageManager = MessageManager.getInstance();
            logoActivity3 = this.aKj.aKf;
            messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_OPEN, logoActivity3.getPageContext()));
            logoActivity4 = this.aKj.aKf;
            logoActivity4.finish();
            return;
        }
        com.baidu.adp.lib.g.h eE = com.baidu.adp.lib.g.h.eE();
        logoActivity2 = this.aKj.aKf;
        aVar = logoActivity2.aJZ;
        eE.post(aVar);
    }
}
