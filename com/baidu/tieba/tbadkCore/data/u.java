package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class u extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ t eYl;
    private final /* synthetic */ com.baidu.adp.widget.e eYm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, com.baidu.adp.widget.e eVar) {
        this.eYl = tVar;
        this.eYm = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        s sVar;
        s sVar2;
        com.baidu.tbadk.widget.richText.a aVar2;
        super.a((u) aVar, str, i);
        if (aVar != null && aVar.jc()) {
            sVar = this.eYl.eYi;
            this.eYm.setDrawable(sVar.h(aVar));
            sVar2 = this.eYl.eYi;
            aVar2 = sVar2.dhI;
            aVar2.aEw = true;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
        }
    }
}
