package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
class o implements s.a {
    final /* synthetic */ n aPU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aPU = nVar;
    }

    @Override // com.baidu.tieba.s.a
    public void onCompleted() {
        LogoActivity logoActivity;
        boolean Jr;
        LogoActivity logoActivity2;
        LogoActivity.a aVar;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        logoActivity = this.aPU.aPQ;
        Jr = logoActivity.Jr();
        if (Jr) {
            MessageManager messageManager = MessageManager.getInstance();
            logoActivity3 = this.aPU.aPQ;
            messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_OPEN, logoActivity3.getPageContext()));
            logoActivity4 = this.aPU.aPQ;
            logoActivity4.finish();
            return;
        }
        com.baidu.adp.lib.g.h fM = com.baidu.adp.lib.g.h.fM();
        logoActivity2 = this.aPU.aPQ;
        aVar = logoActivity2.aPK;
        fM.post(aVar);
    }
}
