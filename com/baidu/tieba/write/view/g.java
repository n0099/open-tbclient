package com.baidu.tieba.write.view;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class g implements PopupWindow.OnDismissListener {
    private final /* synthetic */ PostCategoryView gmA;
    final /* synthetic */ PostCategoryView gmz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
        this.gmz = postCategoryView;
        this.gmA = postCategoryView2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.gmA != null) {
            this.gmA.bvz();
        }
    }
}
