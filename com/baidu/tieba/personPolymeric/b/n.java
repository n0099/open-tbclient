package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements j.a {
    final /* synthetic */ h eJA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(h hVar) {
        this.eJA = hVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void od() {
        MorePopupWindow morePopupWindow;
        TbPageContext tbPageContext;
        morePopupWindow = this.eJA.eJs;
        tbPageContext = this.eJA.GM;
        com.baidu.adp.lib.h.j.a(morePopupWindow, tbPageContext.getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oe() {
        MorePopupWindow morePopupWindow;
        TbPageContext tbPageContext;
        morePopupWindow = this.eJA.eJs;
        tbPageContext = this.eJA.GM;
        com.baidu.adp.lib.h.j.a(morePopupWindow, tbPageContext.getPageActivity());
    }
}
