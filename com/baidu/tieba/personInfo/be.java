package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements i.a {
    final /* synthetic */ az cTD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(az azVar) {
        this.cTD = azVar;
    }

    @Override // com.baidu.tbadk.core.view.i.a
    public void qG() {
        MorePopupWindow morePopupWindow;
        d dVar;
        morePopupWindow = this.cTD.cTy;
        dVar = this.cTD.cLT;
        com.baidu.adp.lib.h.j.a(morePopupWindow, dVar.getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.i.a
    public void qH() {
        MorePopupWindow morePopupWindow;
        d dVar;
        morePopupWindow = this.cTD.cTy;
        dVar = this.cTD.cLT;
        com.baidu.adp.lib.h.j.a(morePopupWindow, dVar.getPageContext().getPageActivity());
    }
}
