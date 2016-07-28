package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements j.a {
    final /* synthetic */ bq eCH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bq bqVar) {
        this.eCH = bqVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void nh() {
        MorePopupWindow morePopupWindow;
        h hVar;
        morePopupWindow = this.eCH.eCC;
        hVar = this.eCH.epz;
        com.baidu.adp.lib.h.j.a(morePopupWindow, hVar.getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void ni() {
        MorePopupWindow morePopupWindow;
        h hVar;
        morePopupWindow = this.eCH.eCC;
        hVar = this.eCH.epz;
        com.baidu.adp.lib.h.j.a(morePopupWindow, hVar.getPageContext().getPageActivity());
    }
}
