package com.baidu.tieba.write.view;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements PopupWindow.OnDismissListener {
    final /* synthetic */ PostCategoryView eKu;
    private final /* synthetic */ PostCategoryView eKv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
        this.eKu = postCategoryView;
        this.eKv = postCategoryView2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.eKv != null) {
            this.eKv.bay();
        }
    }
}
