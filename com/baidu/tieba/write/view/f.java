package com.baidu.tieba.write.view;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ PostCategoryView gmz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PostCategoryView postCategoryView) {
        this.gmz = postCategoryView;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void og() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oh() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.gmz.MV;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.gmz.MV;
            morePopupWindow2.dismiss();
        }
    }
}
