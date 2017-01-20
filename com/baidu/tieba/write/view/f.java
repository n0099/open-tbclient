package com.baidu.tieba.write.view;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ PostCategoryView fJx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PostCategoryView postCategoryView) {
        this.fJx = postCategoryView;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oa() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void ob() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.fJx.Mf;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.fJx.Mf;
            morePopupWindow2.dismiss();
        }
    }
}
