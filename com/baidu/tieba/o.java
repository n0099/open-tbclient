package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
class o implements s.a {
    final /* synthetic */ n aQF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aQF = nVar;
    }

    @Override // com.baidu.tieba.s.a
    public void onCompleted() {
        LogoActivity logoActivity;
        boolean Jf;
        LogoActivity logoActivity2;
        LogoActivity.a aVar;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        logoActivity = this.aQF.aQB;
        Jf = logoActivity.Jf();
        if (Jf) {
            MessageManager messageManager = MessageManager.getInstance();
            logoActivity3 = this.aQF.aQB;
            messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_OPEN, logoActivity3.getPageContext()));
            logoActivity4 = this.aQF.aQB;
            logoActivity4.finish();
            return;
        }
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        logoActivity2 = this.aQF.aQB;
        aVar = logoActivity2.aQv;
        fS.post(aVar);
    }
}
