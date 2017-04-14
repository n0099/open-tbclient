package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
class o implements s.a {
    final /* synthetic */ n aQk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aQk = nVar;
    }

    @Override // com.baidu.tieba.s.a
    public void onCompleted() {
        LogoActivity logoActivity;
        boolean JR;
        LogoActivity logoActivity2;
        LogoActivity.a aVar;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        logoActivity = this.aQk.aQg;
        JR = logoActivity.JR();
        if (JR) {
            MessageManager messageManager = MessageManager.getInstance();
            logoActivity3 = this.aQk.aQg;
            messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_OPEN, logoActivity3.getPageContext()));
            logoActivity4 = this.aQk.aQg;
            logoActivity4.finish();
            return;
        }
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        logoActivity2 = this.aQk.aQg;
        aVar = logoActivity2.aQa;
        fR.post(aVar);
    }
}
