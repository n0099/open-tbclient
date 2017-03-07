package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements j.a {
    final /* synthetic */ h eGU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(h hVar) {
        this.eGU = hVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oo() {
        MorePopupWindow morePopupWindow;
        TbPageContext tbPageContext;
        morePopupWindow = this.eGU.eGL;
        tbPageContext = this.eGU.ajF;
        com.baidu.adp.lib.g.j.a(morePopupWindow, tbPageContext.getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void op() {
        MorePopupWindow morePopupWindow;
        TbPageContext tbPageContext;
        morePopupWindow = this.eGU.eGL;
        tbPageContext = this.eGU.ajF;
        com.baidu.adp.lib.g.j.a(morePopupWindow, tbPageContext.getPageActivity());
    }
}
