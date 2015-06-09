package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.p;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class l extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ TbPageContext NC;
    final /* synthetic */ k cst;
    private final /* synthetic */ p csu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, p pVar, TbPageContext tbPageContext) {
        this.cst = kVar;
        this.csu = pVar;
        this.NC = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        j jVar;
        super.a((l) aVar, str, i);
        if (aVar != null && aVar.mT()) {
            jVar = this.cst.csr;
            this.csu.setDrawable(jVar.f(aVar));
            MessageManager.getInstance().sendMessage(new CustomMessage(2004005, this.NC));
        }
    }
}
