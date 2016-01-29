package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements j.a {
    final /* synthetic */ bi dkc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bi biVar) {
        this.dkc = biVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void qK() {
        MorePopupWindow morePopupWindow;
        f fVar;
        morePopupWindow = this.dkc.djX;
        fVar = this.dkc.cZH;
        com.baidu.adp.lib.h.j.a(morePopupWindow, fVar.getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void qL() {
        MorePopupWindow morePopupWindow;
        f fVar;
        morePopupWindow = this.dkc.djX;
        fVar = this.dkc.cZH;
        com.baidu.adp.lib.h.j.a(morePopupWindow, fVar.getPageContext().getPageActivity());
    }
}
