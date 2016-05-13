package com.baidu.tieba.postsearch;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnFocusChangeListener {
    final /* synthetic */ a dVb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.dVb = aVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        PostSearchActivity postSearchActivity;
        if (!z) {
            postSearchActivity = this.dVb.dUY;
            com.baidu.adp.lib.util.k.a(postSearchActivity.getPageContext().getPageActivity(), view);
            return;
        }
        this.dVb.aKE();
        this.dVb.aKD();
    }
}
