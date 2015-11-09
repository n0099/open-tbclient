package com.baidu.tieba.postsearch;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnFocusChangeListener {
    final /* synthetic */ a cFu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cFu = aVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        PostSearchActivity postSearchActivity;
        if (!z) {
            postSearchActivity = this.cFu.cFs;
            com.baidu.adp.lib.util.k.c(postSearchActivity.getPageContext().getPageActivity(), view);
            return;
        }
        this.cFu.aoJ();
        this.cFu.aoI();
    }
}
