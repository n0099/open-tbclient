package com.baidu.tieba.write.view;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements j.a {
    final /* synthetic */ PostCategoryView dVG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PostCategoryView postCategoryView) {
        this.dVG = postCategoryView;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void qp() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void qq() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.dVG.mPopWindow;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.dVG.mPopWindow;
            morePopupWindow2.dismiss();
        }
    }
}
