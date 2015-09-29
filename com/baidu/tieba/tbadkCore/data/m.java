package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class m extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ l cYZ;
    private final /* synthetic */ com.baidu.adp.widget.e cZa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, com.baidu.adp.widget.e eVar) {
        this.cYZ = lVar;
        this.cZa = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        k kVar;
        super.a((m) aVar, str, i);
        if (aVar != null && aVar.nb()) {
            kVar = this.cYZ.cYW;
            this.cZa.setDrawable(kVar.g(aVar));
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
        }
    }
}
