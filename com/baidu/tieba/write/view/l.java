package com.baidu.tieba.write.view;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements PopupWindow.OnDismissListener {
    final /* synthetic */ PostCategoryView fQa;
    private final /* synthetic */ PostCategoryView fQb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
        this.fQa = postCategoryView;
        this.fQb = postCategoryView2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.fQb != null) {
            this.fQb.bnv();
        }
    }
}
