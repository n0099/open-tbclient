package com.baidu.tieba.write.view;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ PostCategoryView gcL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PostCategoryView postCategoryView) {
        this.gcL = postCategoryView;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oc() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void od() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.gcL.MV;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.gcL.MV;
            morePopupWindow2.dismiss();
        }
    }
}
