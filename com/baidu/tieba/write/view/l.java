package com.baidu.tieba.write.view;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class l implements PopupWindow.OnDismissListener {
    final /* synthetic */ PostCategoryView giW;
    private final /* synthetic */ PostCategoryView giX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
        this.giW = postCategoryView;
        this.giX = postCategoryView2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.giX != null) {
            this.giX.bts();
        }
    }
}
