package com.baidu.tieba.write.view;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ PostCategoryView fPz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PostCategoryView postCategoryView) {
        this.fPz = postCategoryView;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oL() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oM() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.fPz.RA;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.fPz.RA;
            morePopupWindow2.dismiss();
        }
    }
}
