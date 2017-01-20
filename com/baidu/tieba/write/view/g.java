package com.baidu.tieba.write.view;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class g implements PopupWindow.OnDismissListener {
    final /* synthetic */ PostCategoryView fJx;
    private final /* synthetic */ PostCategoryView fJy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
        this.fJx = postCategoryView;
        this.fJy = postCategoryView2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.fJy != null) {
            this.fJy.bnV();
        }
    }
}
