package com.baidu.tieba.write.view;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements h.a {
    final /* synthetic */ PostCategoryView dpd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PostCategoryView postCategoryView) {
        this.dpd = postCategoryView;
    }

    @Override // com.baidu.tbadk.core.view.h.a
    public void qu() {
    }

    @Override // com.baidu.tbadk.core.view.h.a
    public void qv() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.dpd.mPopWindow;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.dpd.mPopWindow;
            morePopupWindow2.dismiss();
        }
    }
}
