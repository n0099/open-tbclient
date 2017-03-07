package com.baidu.tieba.write.view;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j.a {
    final /* synthetic */ PostCategoryView fNQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PostCategoryView postCategoryView) {
        this.fNQ = postCategoryView;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oo() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void op() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.fNQ.Ri;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.fNQ.Ri;
            morePopupWindow2.dismiss();
        }
    }
}
