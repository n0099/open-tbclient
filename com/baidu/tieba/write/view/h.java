package com.baidu.tieba.write.view;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements i.a {
    final /* synthetic */ PostCategoryView dOh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PostCategoryView postCategoryView) {
        this.dOh = postCategoryView;
    }

    @Override // com.baidu.tbadk.core.view.i.a
    public void qG() {
    }

    @Override // com.baidu.tbadk.core.view.i.a
    public void qH() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.dOh.mPopWindow;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.dOh.mPopWindow;
            morePopupWindow2.dismiss();
        }
    }
}
