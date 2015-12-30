package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements j.a {
    final /* synthetic */ be cYp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(be beVar) {
        this.cYp = beVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void qp() {
        MorePopupWindow morePopupWindow;
        d dVar;
        morePopupWindow = this.cYp.cYk;
        dVar = this.cYp.cQj;
        com.baidu.adp.lib.h.j.a(morePopupWindow, dVar.getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void qq() {
        MorePopupWindow morePopupWindow;
        d dVar;
        morePopupWindow = this.cYp.cYk;
        dVar = this.cYp.cQj;
        com.baidu.adp.lib.h.j.a(morePopupWindow, dVar.getPageContext().getPageActivity());
    }
}
