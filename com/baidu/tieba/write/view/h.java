package com.baidu.tieba.write.view;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements j.a {
    final /* synthetic */ PostCategoryView fGP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PostCategoryView postCategoryView) {
        this.fGP = postCategoryView;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void ns() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void nt() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.fGP.KJ;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.fGP.KJ;
            morePopupWindow2.dismiss();
        }
    }
}
