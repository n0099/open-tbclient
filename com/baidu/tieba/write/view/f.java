package com.baidu.tieba.write.view;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ PostCategoryView geV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PostCategoryView postCategoryView) {
        this.geV = postCategoryView;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void od() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oe() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.geV.MU;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.geV.MU;
            morePopupWindow2.dismiss();
        }
    }
}
