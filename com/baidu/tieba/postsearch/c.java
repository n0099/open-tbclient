package com.baidu.tieba.postsearch;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnFocusChangeListener {
    final /* synthetic */ a bXP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bXP = aVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        PostSearchActivity postSearchActivity;
        if (!z) {
            postSearchActivity = this.bXP.bXN;
            com.baidu.adp.lib.util.n.c(postSearchActivity.getPageContext().getPageActivity(), view);
            return;
        }
        this.bXP.afU();
        this.bXP.afT();
    }
}
