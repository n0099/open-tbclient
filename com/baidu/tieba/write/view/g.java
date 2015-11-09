package com.baidu.tieba.write.view;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ PostCategoryView dpd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PostCategoryView postCategoryView) {
        this.dpd = postCategoryView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dpd.aDm();
    }
}
