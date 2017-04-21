package com.baidu.tieba.write.view;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class g implements PopupWindow.OnDismissListener {
    final /* synthetic */ PostCategoryView fRV;
    private final /* synthetic */ PostCategoryView fRW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
        this.fRV = postCategoryView;
        this.fRW = postCategoryView2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.fRW != null) {
            this.fRW.bpt();
        }
    }
}
