package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.core.view.q {
    final /* synthetic */ ae bUi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar) {
        this.bUi = aeVar;
    }

    @Override // com.baidu.tbadk.core.view.q
    public void oY() {
        MorePopupWindow morePopupWindow;
        PersonInfoActivity personInfoActivity;
        morePopupWindow = this.bUi.bUg;
        personInfoActivity = this.bUi.bSi;
        com.baidu.adp.lib.g.k.a(morePopupWindow, personInfoActivity.getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.q
    public void oZ() {
        MorePopupWindow morePopupWindow;
        PersonInfoActivity personInfoActivity;
        morePopupWindow = this.bUi.bUg;
        personInfoActivity = this.bUi.bSi;
        com.baidu.adp.lib.g.k.a(morePopupWindow, personInfoActivity.getPageContext().getPageActivity());
    }
}
