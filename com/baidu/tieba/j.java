package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class j implements n.a {
    final /* synthetic */ i aLQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aLQ = iVar;
    }

    @Override // com.baidu.tieba.n.a
    public void onCompleted() {
        LogoActivity logoActivity;
        boolean Jf;
        LogoActivity logoActivity2;
        LogoActivity.a aVar;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        logoActivity = this.aLQ.aLM;
        Jf = logoActivity.Jf();
        if (Jf) {
            MessageManager messageManager = MessageManager.getInstance();
            logoActivity3 = this.aLQ.aLM;
            messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_OPEN, logoActivity3.getPageContext()));
            logoActivity4 = this.aLQ.aLM;
            logoActivity4.finish();
            return;
        }
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        logoActivity2 = this.aLQ.aLM;
        aVar = logoActivity2.aLG;
        eG.post(aVar);
    }
}
