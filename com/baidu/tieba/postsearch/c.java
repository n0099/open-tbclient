package com.baidu.tieba.postsearch;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnFocusChangeListener {
    final /* synthetic */ a dSj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.dSj = aVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        PostSearchActivity postSearchActivity;
        if (!z) {
            postSearchActivity = this.dSj.dSg;
            com.baidu.adp.lib.util.k.c(postSearchActivity.getPageContext().getPageActivity(), view);
            return;
        }
        this.dSj.aKx();
        this.dSj.aKw();
    }
}
