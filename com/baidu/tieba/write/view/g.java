package com.baidu.tieba.write.view;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class g implements PopupWindow.OnDismissListener {
    private final /* synthetic */ PostCategoryView fPA;
    final /* synthetic */ PostCategoryView fPz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
        this.fPz = postCategoryView;
        this.fPA = postCategoryView2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.fPA != null) {
            this.fPA.bos();
        }
    }
}
