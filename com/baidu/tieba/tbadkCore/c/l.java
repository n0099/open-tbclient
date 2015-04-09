package com.baidu.tieba.tbadkCore.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.p;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class l extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ TbPageContext Np;
    final /* synthetic */ k cou;
    private final /* synthetic */ p cov;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, p pVar, TbPageContext tbPageContext) {
        this.cou = kVar;
        this.cov = pVar;
        this.Np = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        j jVar;
        super.onLoaded((l) aVar, str, i);
        if (aVar != null && aVar.mA()) {
            jVar = this.cou.cos;
            this.cov.setDrawable(jVar.f(aVar));
            MessageManager.getInstance().sendMessage(new CustomMessage(2004005, this.Np));
        }
    }
}
