package com.baidu.tieba.write.view;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements j.a {
    final /* synthetic */ PostCategoryView eqz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PostCategoryView postCategoryView) {
        this.eqz = postCategoryView;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void qK() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void qL() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.eqz.Su;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.eqz.Su;
            morePopupWindow2.dismiss();
        }
    }
}
