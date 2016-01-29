package com.baidu.tieba.write.write;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnFocusChangeListener {
    final /* synthetic */ AtListActivity erI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AtListActivity atListActivity) {
        this.erI = atListActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.util.k.c(this.erI.getPageContext().getPageActivity(), view);
        } else {
            com.baidu.adp.lib.util.k.d(this.erI.getPageContext().getPageActivity(), view);
        }
    }
}
