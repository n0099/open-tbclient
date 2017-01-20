package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.widget.richText.TbRichText;
/* loaded from: classes.dex */
class r extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ q fqs;
    private final /* synthetic */ com.baidu.adp.widget.e fqt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, com.baidu.adp.widget.e eVar) {
        this.fqs = qVar;
        this.fqt = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        p pVar;
        p pVar2;
        TbRichText tbRichText;
        super.onLoaded((r) aVar, str, i);
        if (aVar != null && aVar.jU()) {
            pVar = this.fqs.fqp;
            this.fqt.setDrawable(pVar.g(aVar));
            pVar2 = this.fqs.fqp;
            tbRichText = pVar2.dnz;
            tbRichText.isChanged = true;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
        }
    }
}
