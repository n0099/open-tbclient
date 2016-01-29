package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class t extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ s dXy;
    private final /* synthetic */ com.baidu.adp.widget.e dXz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.adp.widget.e eVar) {
        this.dXy = sVar;
        this.dXz = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        r rVar;
        super.a((t) aVar, str, i);
        if (aVar != null && aVar.mT()) {
            rVar = this.dXy.dXv;
            this.dXz.setDrawable(rVar.g(aVar));
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
        }
    }
}
