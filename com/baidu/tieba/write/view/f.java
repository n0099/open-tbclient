package com.baidu.tieba.write.view;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ PostCategoryView fBc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PostCategoryView postCategoryView) {
        this.fBc = postCategoryView;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void og() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oh() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.fBc.MS;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.fBc.MS;
            morePopupWindow2.dismiss();
        }
    }
}
