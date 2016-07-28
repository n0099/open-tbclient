package com.baidu.tieba.write.view;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements PopupWindow.OnDismissListener {
    final /* synthetic */ PostCategoryView fSG;
    private final /* synthetic */ PostCategoryView fSH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
        this.fSG = postCategoryView;
        this.fSH = postCategoryView2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.fSH != null) {
            this.fSH.boj();
        }
    }
}
