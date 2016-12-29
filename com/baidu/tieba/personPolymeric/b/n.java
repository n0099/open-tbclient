package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements j.a {
    final /* synthetic */ h ety;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(h hVar) {
        this.ety = hVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void og() {
        MorePopupWindow morePopupWindow;
        TbPageContext tbPageContext;
        morePopupWindow = this.ety.etp;
        tbPageContext = this.ety.GO;
        com.baidu.adp.lib.h.j.a(morePopupWindow, tbPageContext.getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oh() {
        MorePopupWindow morePopupWindow;
        TbPageContext tbPageContext;
        morePopupWindow = this.ety.etp;
        tbPageContext = this.ety.GO;
        com.baidu.adp.lib.h.j.a(morePopupWindow, tbPageContext.getPageActivity());
    }
}
