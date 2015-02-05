package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.core.view.v {
    final /* synthetic */ ae bLX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar) {
        this.bLX = aeVar;
    }

    @Override // com.baidu.tbadk.core.view.v
    public void lq() {
        MorePopupWindow morePopupWindow;
        PersonInfoActivity personInfoActivity;
        morePopupWindow = this.bLX.bLV;
        personInfoActivity = this.bLX.bJY;
        com.baidu.adp.lib.g.k.a(morePopupWindow, personInfoActivity.getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.v
    public void lr() {
        MorePopupWindow morePopupWindow;
        PersonInfoActivity personInfoActivity;
        morePopupWindow = this.bLX.bLV;
        personInfoActivity = this.bLX.bJY;
        com.baidu.adp.lib.g.k.a(morePopupWindow, personInfoActivity.getPageContext().getPageActivity());
    }
}
