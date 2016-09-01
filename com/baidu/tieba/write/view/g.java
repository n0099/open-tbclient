package com.baidu.tieba.write.view;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class g implements PopupWindow.OnDismissListener {
    final /* synthetic */ PostCategoryView gcL;
    private final /* synthetic */ PostCategoryView gcM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
        this.gcL = postCategoryView;
        this.gcM = postCategoryView2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.gcM != null) {
            this.gcM.bsy();
        }
    }
}
