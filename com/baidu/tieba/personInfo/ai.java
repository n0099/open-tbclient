package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements p.a {
    final /* synthetic */ ag coZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.coZ = agVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void qA() {
        MorePopupWindow morePopupWindow;
        PersonInfoActivity personInfoActivity;
        morePopupWindow = this.coZ.coX;
        personInfoActivity = this.coZ.ckP;
        com.baidu.adp.lib.g.j.a(morePopupWindow, personInfoActivity.getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void qB() {
        MorePopupWindow morePopupWindow;
        PersonInfoActivity personInfoActivity;
        morePopupWindow = this.coZ.coX;
        personInfoActivity = this.coZ.ckP;
        com.baidu.adp.lib.g.j.a(morePopupWindow, personInfoActivity.getPageContext().getPageActivity());
    }
}
