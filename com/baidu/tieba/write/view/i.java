package com.baidu.tieba.write.view;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements PopupWindow.OnDismissListener {
    final /* synthetic */ PostCategoryView dOh;
    private final /* synthetic */ PostCategoryView dOi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
        this.dOh = postCategoryView;
        this.dOi = postCategoryView2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.dOi != null) {
            this.dOi.aII();
        }
    }
}
