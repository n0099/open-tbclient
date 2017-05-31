package com.baidu.tieba.write.view;

import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ PostCategoryView fXW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PostCategoryView postCategoryView) {
        this.fXW = postCategoryView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fXW.boV();
    }
}
