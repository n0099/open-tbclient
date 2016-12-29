package com.baidu.tieba.write.view;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements PopupWindow.OnDismissListener {
    final /* synthetic */ PostCategoryView fBc;
    private final /* synthetic */ PostCategoryView fBd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
        this.fBc = postCategoryView;
        this.fBd = postCategoryView2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.fBd != null) {
            this.fBd.bmx();
        }
    }
}
