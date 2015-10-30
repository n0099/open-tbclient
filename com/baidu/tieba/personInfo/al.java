package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements h.a {
    final /* synthetic */ aj cuW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar) {
        this.cuW = ajVar;
    }

    @Override // com.baidu.tbadk.core.view.h.a
    public void qt() {
        MorePopupWindow morePopupWindow;
        PersonInfoActivity personInfoActivity;
        morePopupWindow = this.cuW.cuU;
        personInfoActivity = this.cuW.cqE;
        com.baidu.adp.lib.g.j.a(morePopupWindow, personInfoActivity.getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.h.a
    public void qu() {
        MorePopupWindow morePopupWindow;
        PersonInfoActivity personInfoActivity;
        morePopupWindow = this.cuW.cuU;
        personInfoActivity = this.cuW.cqE;
        com.baidu.adp.lib.g.j.a(morePopupWindow, personInfoActivity.getPageContext().getPageActivity());
    }
}
