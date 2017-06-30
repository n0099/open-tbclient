package com.baidu.tieba.write.view;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements j.a {
    final /* synthetic */ PostCategoryView giW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PostCategoryView postCategoryView) {
        this.giW = postCategoryView;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void og() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oh() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.giW.QA;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.giW.QA;
            morePopupWindow2.dismiss();
        }
    }
}
