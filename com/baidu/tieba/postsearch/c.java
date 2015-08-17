package com.baidu.tieba.postsearch;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnFocusChangeListener {
    final /* synthetic */ a coI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.coI = aVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        PostSearchActivity postSearchActivity;
        if (!z) {
            postSearchActivity = this.coI.coG;
            com.baidu.adp.lib.util.k.c(postSearchActivity.getPageContext().getPageActivity(), view);
            return;
        }
        this.coI.ahS();
        this.coI.ahR();
    }
}
