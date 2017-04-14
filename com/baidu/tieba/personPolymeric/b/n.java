package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements j.a {
    final /* synthetic */ h eEQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(h hVar) {
        this.eEQ = hVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oL() {
        MorePopupWindow morePopupWindow;
        TbPageContext tbPageContext;
        morePopupWindow = this.eEQ.eEH;
        tbPageContext = this.eEQ.ajT;
        com.baidu.adp.lib.g.j.a(morePopupWindow, tbPageContext.getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oM() {
        MorePopupWindow morePopupWindow;
        TbPageContext tbPageContext;
        morePopupWindow = this.eEQ.eEH;
        tbPageContext = this.eEQ.ajT;
        com.baidu.adp.lib.g.j.a(morePopupWindow, tbPageContext.getPageActivity());
    }
}
