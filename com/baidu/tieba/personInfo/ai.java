package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements p.a {
    final /* synthetic */ ag cnY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.cnY = agVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void qD() {
        MorePopupWindow morePopupWindow;
        PersonInfoActivity personInfoActivity;
        morePopupWindow = this.cnY.cnW;
        personInfoActivity = this.cnY.cjU;
        com.baidu.adp.lib.g.j.a(morePopupWindow, personInfoActivity.getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void qE() {
        MorePopupWindow morePopupWindow;
        PersonInfoActivity personInfoActivity;
        morePopupWindow = this.cnY.cnW;
        personInfoActivity = this.cnY.cjU;
        com.baidu.adp.lib.g.j.a(morePopupWindow, personInfoActivity.getPageContext().getPageActivity());
    }
}
