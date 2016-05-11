package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements j.a {
    final /* synthetic */ bj dHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bj bjVar) {
        this.dHR = bjVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void nx() {
        MorePopupWindow morePopupWindow;
        f fVar;
        morePopupWindow = this.dHR.dHM;
        fVar = this.dHR.dxd;
        com.baidu.adp.lib.h.j.a(morePopupWindow, fVar.getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void ny() {
        MorePopupWindow morePopupWindow;
        f fVar;
        morePopupWindow = this.dHR.dHM;
        fVar = this.dHR.dxd;
        com.baidu.adp.lib.h.j.a(morePopupWindow, fVar.getPageContext().getPageActivity());
    }
}
