package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class q extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ p dbj;
    private final /* synthetic */ com.baidu.adp.widget.e dbk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, com.baidu.adp.widget.e eVar) {
        this.dbj = pVar;
        this.dbk = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        o oVar;
        super.a((q) aVar, str, i);
        if (aVar != null && aVar.nc()) {
            oVar = this.dbj.dbg;
            this.dbk.setDrawable(oVar.g(aVar));
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
        }
    }
}
