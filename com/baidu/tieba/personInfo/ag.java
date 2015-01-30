package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.core.view.v {
    final /* synthetic */ ae bLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar) {
        this.bLY = aeVar;
    }

    @Override // com.baidu.tbadk.core.view.v
    public void lx() {
        MorePopupWindow morePopupWindow;
        PersonInfoActivity personInfoActivity;
        morePopupWindow = this.bLY.bLW;
        personInfoActivity = this.bLY.bJZ;
        com.baidu.adp.lib.g.k.a(morePopupWindow, personInfoActivity.getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.v
    public void ly() {
        MorePopupWindow morePopupWindow;
        PersonInfoActivity personInfoActivity;
        morePopupWindow = this.bLY.bLW;
        personInfoActivity = this.bLY.bJZ;
        com.baidu.adp.lib.g.k.a(morePopupWindow, personInfoActivity.getPageContext().getPageActivity());
    }
}
