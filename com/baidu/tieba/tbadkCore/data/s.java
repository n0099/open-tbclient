package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class s extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ r fCZ;
    private final /* synthetic */ com.baidu.adp.widget.e fDa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, com.baidu.adp.widget.e eVar) {
        this.fCZ = rVar;
        this.fDa = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        q qVar;
        q qVar2;
        com.baidu.tbadk.widget.richText.a aVar2;
        super.a((s) aVar, str, i);
        if (aVar != null && aVar.jW()) {
            qVar = this.fCZ.fCW;
            this.fDa.setDrawable(qVar.h(aVar));
            qVar2 = this.fCZ.fCW;
            aVar2 = qVar2.dDs;
            aVar2.aIM = true;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
        }
    }
}
