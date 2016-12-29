package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class j implements n.a {
    final /* synthetic */ i aLh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aLh = iVar;
    }

    @Override // com.baidu.tieba.n.a
    public void onCompleted() {
        LogoActivity logoActivity;
        boolean IA;
        LogoActivity logoActivity2;
        LogoActivity.a aVar;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        logoActivity = this.aLh.aLd;
        IA = logoActivity.IA();
        if (IA) {
            MessageManager messageManager = MessageManager.getInstance();
            logoActivity3 = this.aLh.aLd;
            messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_OPEN, logoActivity3.getPageContext()));
            logoActivity4 = this.aLh.aLd;
            logoActivity4.finish();
            return;
        }
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        logoActivity2 = this.aLh.aLd;
        aVar = logoActivity2.aKX;
        eG.post(aVar);
    }
}
