package com.baidu.tieba.write.view;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements PopupWindow.OnDismissListener {
    private final /* synthetic */ PostCategoryView eqA;
    final /* synthetic */ PostCategoryView eqz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
        this.eqz = postCategoryView;
        this.eqA = postCategoryView2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.eqA != null) {
            this.eqA.aTY();
        }
    }
}
