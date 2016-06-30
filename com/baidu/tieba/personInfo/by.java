package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements j.a {
    final /* synthetic */ bs eqW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bs bsVar) {
        this.eqW = bsVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void ns() {
        MorePopupWindow morePopupWindow;
        f fVar;
        morePopupWindow = this.eqW.eqR;
        fVar = this.eqW.efz;
        com.baidu.adp.lib.h.j.a(morePopupWindow, fVar.getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void nt() {
        MorePopupWindow morePopupWindow;
        f fVar;
        morePopupWindow = this.eqW.eqR;
        fVar = this.eqW.efz;
        com.baidu.adp.lib.h.j.a(morePopupWindow, fVar.getPageContext().getPageActivity());
    }
}
