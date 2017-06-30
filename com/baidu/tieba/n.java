package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
class n implements s.a {
    final /* synthetic */ m aRZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aRZ = mVar;
    }

    @Override // com.baidu.tieba.s.a
    public void onCompleted() {
        LogoActivity logoActivity;
        boolean JA;
        LogoActivity logoActivity2;
        LogoActivity.a aVar;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        logoActivity = this.aRZ.aRW;
        JA = logoActivity.JA();
        if (JA) {
            MessageManager messageManager = MessageManager.getInstance();
            logoActivity3 = this.aRZ.aRW;
            messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_OPEN, logoActivity3.getPageContext()));
            logoActivity4 = this.aRZ.aRW;
            logoActivity4.finish();
            return;
        }
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        logoActivity2 = this.aRZ.aRW;
        aVar = logoActivity2.aRQ;
        fR.post(aVar);
    }
}
