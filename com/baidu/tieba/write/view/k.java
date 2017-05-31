package com.baidu.tieba.write.view;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements j.a {
    final /* synthetic */ PostCategoryView fXW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PostCategoryView postCategoryView) {
        this.fXW = postCategoryView;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void ok() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void ol() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.fXW.QG;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.fXW.QG;
            morePopupWindow2.dismiss();
        }
    }
}
