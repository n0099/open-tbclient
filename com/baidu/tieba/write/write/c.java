package com.baidu.tieba.write.write;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnFocusChangeListener {
    final /* synthetic */ AtListActivity fRd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AtListActivity atListActivity) {
        this.fRd = atListActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.util.k.b(this.fRd.getPageContext().getPageActivity(), view);
        } else {
            com.baidu.adp.lib.util.k.c(this.fRd.getPageContext().getPageActivity(), view);
        }
    }
}
