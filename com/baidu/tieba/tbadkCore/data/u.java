package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class u extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ t eqj;
    private final /* synthetic */ com.baidu.adp.widget.e eqk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, com.baidu.adp.widget.e eVar) {
        this.eqj = tVar;
        this.eqk = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        s sVar;
        super.a((u) aVar, str, i);
        if (aVar != null && aVar.mL()) {
            sVar = this.eqj.eqg;
            this.eqk.setDrawable(sVar.g(aVar));
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
        }
    }
}
