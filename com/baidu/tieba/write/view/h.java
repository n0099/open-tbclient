package com.baidu.tieba.write.view;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements j.a {
    final /* synthetic */ PostCategoryView fbk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PostCategoryView postCategoryView) {
        this.fbk = postCategoryView;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void nx() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void ny() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.fbk.KJ;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.fbk.KJ;
            morePopupWindow2.dismiss();
        }
    }
}
