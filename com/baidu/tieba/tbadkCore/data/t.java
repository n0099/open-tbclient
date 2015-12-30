package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class t extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ s dHB;
    private final /* synthetic */ com.baidu.adp.widget.e dHC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.adp.widget.e eVar) {
        this.dHB = sVar;
        this.dHC = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        r rVar;
        super.a((t) aVar, str, i);
        if (aVar != null && aVar.mF()) {
            rVar = this.dHB.dHy;
            this.dHC.setDrawable(rVar.g(aVar));
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
        }
    }
}
