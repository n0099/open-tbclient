package com.baidu.tieba.tbadkCore.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class m extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ TbPageContext Mm;
    final /* synthetic */ l bXa;
    private final /* synthetic */ com.baidu.tbadk.widget.m bXb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, com.baidu.tbadk.widget.m mVar, TbPageContext tbPageContext) {
        this.bXa = lVar;
        this.bXb = mVar;
        this.Mm = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        k kVar;
        super.onLoaded((m) aVar, str, i);
        if (aVar != null && aVar.jj()) {
            kVar = this.bXa.bWY;
            this.bXb.setDrawable(kVar.f(aVar));
            MessageManager.getInstance().sendMessage(new CustomMessage(2004005, this.Mm));
        }
    }
}
