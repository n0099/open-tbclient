package com.baidu.tieba.write.view;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements PopupWindow.OnDismissListener {
    final /* synthetic */ PostCategoryView geV;
    private final /* synthetic */ PostCategoryView geW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
        this.geV = postCategoryView;
        this.geW = postCategoryView2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.geW != null) {
            this.geW.bte();
        }
    }
}
