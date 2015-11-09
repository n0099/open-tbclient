package com.baidu.tieba.write.view;

import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements PopupWindow.OnDismissListener {
    final /* synthetic */ PostCategoryView dpd;
    private final /* synthetic */ PostCategoryView dpe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
        this.dpd = postCategoryView;
        this.dpe = postCategoryView2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.dpe != null) {
            this.dpe.aDl();
        }
    }
}
