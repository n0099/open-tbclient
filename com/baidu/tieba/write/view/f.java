package com.baidu.tieba.write.view;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ PostCategoryView fSG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PostCategoryView postCategoryView) {
        this.fSG = postCategoryView;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void nh() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void ni() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.fSG.KI;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.fSG.KI;
            morePopupWindow2.dismiss();
        }
    }
}
