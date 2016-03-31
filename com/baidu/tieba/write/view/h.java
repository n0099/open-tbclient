package com.baidu.tieba.write.view;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements j.a {
    final /* synthetic */ PostCategoryView eKu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PostCategoryView postCategoryView) {
        this.eKu = postCategoryView;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void qb() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void qc() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.eKu.PS;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.eKu.PS;
            morePopupWindow2.dismiss();
        }
    }
}
