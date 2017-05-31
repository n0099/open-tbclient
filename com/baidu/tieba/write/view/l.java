package com.baidu.tieba.write.view;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class l implements PopupWindow.OnDismissListener {
    final /* synthetic */ PostCategoryView fXW;
    private final /* synthetic */ PostCategoryView fXX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
        this.fXW = postCategoryView;
        this.fXX = postCategoryView2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.fXX != null) {
            this.fXX.boU();
        }
    }
}
