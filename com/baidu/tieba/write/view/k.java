package com.baidu.tieba.write.view;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements j.a {
    final /* synthetic */ PostCategoryView fQa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PostCategoryView postCategoryView) {
        this.fQa = postCategoryView;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void os() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void ot() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.fQa.QU;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.fQa.QU;
            morePopupWindow2.dismiss();
        }
    }
}
