package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements h.a {
    final /* synthetic */ aj cuL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar) {
        this.cuL = ajVar;
    }

    @Override // com.baidu.tbadk.core.view.h.a
    public void qw() {
        MorePopupWindow morePopupWindow;
        PersonInfoActivity personInfoActivity;
        morePopupWindow = this.cuL.cuJ;
        personInfoActivity = this.cuL.cqt;
        com.baidu.adp.lib.g.j.a(morePopupWindow, personInfoActivity.getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.h.a
    public void qx() {
        MorePopupWindow morePopupWindow;
        PersonInfoActivity personInfoActivity;
        morePopupWindow = this.cuL.cuJ;
        personInfoActivity = this.cuL.cqt;
        com.baidu.adp.lib.g.j.a(morePopupWindow, personInfoActivity.getPageContext().getPageActivity());
    }
}
