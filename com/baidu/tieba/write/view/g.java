package com.baidu.tieba.write.view;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements PopupWindow.OnDismissListener {
    final /* synthetic */ PostCategoryView fNQ;
    private final /* synthetic */ PostCategoryView fNR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
        this.fNQ = postCategoryView;
        this.fNR = postCategoryView2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.fNR != null) {
            this.fNR.bnI();
        }
    }
}
