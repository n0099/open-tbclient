package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class k extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ j cRv;
    private final /* synthetic */ com.baidu.adp.widget.e cRw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, com.baidu.adp.widget.e eVar) {
        this.cRv = jVar;
        this.cRw = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        i iVar;
        super.a((k) aVar, str, i);
        if (aVar != null && aVar.na()) {
            iVar = this.cRv.cRs;
            this.cRw.setDrawable(iVar.f(aVar));
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
        }
    }
}
