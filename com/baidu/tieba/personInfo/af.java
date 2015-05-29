package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tbadk.core.view.s {
    final /* synthetic */ ad bXe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ad adVar) {
        this.bXe = adVar;
    }

    @Override // com.baidu.tbadk.core.view.s
    public void pC() {
        MorePopupWindow morePopupWindow;
        PersonInfoActivity personInfoActivity;
        morePopupWindow = this.bXe.bXc;
        personInfoActivity = this.bXe.bVf;
        com.baidu.adp.lib.g.k.a(morePopupWindow, personInfoActivity.getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.s
    public void pD() {
        MorePopupWindow morePopupWindow;
        PersonInfoActivity personInfoActivity;
        morePopupWindow = this.bXe.bXc;
        personInfoActivity = this.bXe.bVf;
        com.baidu.adp.lib.g.k.a(morePopupWindow, personInfoActivity.getPageContext().getPageActivity());
    }
}
