package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class u extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ t flo;
    private final /* synthetic */ com.baidu.adp.widget.e flp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, com.baidu.adp.widget.e eVar) {
        this.flo = tVar;
        this.flp = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        s sVar;
        s sVar2;
        com.baidu.tbadk.widget.richText.a aVar2;
        super.a((u) aVar, str, i);
        if (aVar != null && aVar.jb()) {
            sVar = this.flo.fll;
            this.flp.setDrawable(sVar.h(aVar));
            sVar2 = this.flo.fll;
            aVar2 = sVar2.dkG;
            aVar2.aFn = true;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
        }
    }
}
