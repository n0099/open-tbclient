package com.baidu.tieba.write.view;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class i implements PopupWindow.OnDismissListener {
    final /* synthetic */ PostCategoryView fGP;
    private final /* synthetic */ PostCategoryView fGQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
        this.fGP = postCategoryView;
        this.fGQ = postCategoryView2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.fGQ != null) {
            this.fGQ.blo();
        }
    }
}
