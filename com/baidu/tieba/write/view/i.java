package com.baidu.tieba.write.view;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements PopupWindow.OnDismissListener {
    final /* synthetic */ PostCategoryView fbk;
    private final /* synthetic */ PostCategoryView fbl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
        this.fbk = postCategoryView;
        this.fbl = postCategoryView2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.fbl != null) {
            this.fbl.bcS();
        }
    }
}
