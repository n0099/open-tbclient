package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.widget.richText.TbRichText;
/* loaded from: classes.dex */
class q extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ p fMV;
    private final /* synthetic */ com.baidu.adp.widget.e fMW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, com.baidu.adp.widget.e eVar) {
        this.fMV = pVar;
        this.fMW = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        PostData postData;
        PostData postData2;
        TbRichText tbRichText;
        super.onLoaded((q) aVar, str, i);
        if (aVar != null && aVar.kQ()) {
            postData = this.fMV.fMS;
            this.fMW.setDrawable(postData.g(aVar));
            postData2 = this.fMV.fMS;
            tbRichText = postData2.dyV;
            tbRichText.isChanged = true;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
        }
    }
}
