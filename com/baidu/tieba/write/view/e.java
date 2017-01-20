package com.baidu.tieba.write.view;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ PostCategoryView fJx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PostCategoryView postCategoryView) {
        this.fJx = postCategoryView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fJx.bnW();
    }
}
