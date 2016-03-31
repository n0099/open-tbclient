package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements j.a {
    final /* synthetic */ bi dEC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bi biVar) {
        this.dEC = biVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void qb() {
        MorePopupWindow morePopupWindow;
        f fVar;
        morePopupWindow = this.dEC.dEx;
        fVar = this.dEC.duk;
        com.baidu.adp.lib.h.j.a(morePopupWindow, fVar.getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void qc() {
        MorePopupWindow morePopupWindow;
        f fVar;
        morePopupWindow = this.dEC.dEx;
        fVar = this.dEC.duk;
        com.baidu.adp.lib.h.j.a(morePopupWindow, fVar.getPageContext().getPageActivity());
    }
}
