package com.baidu.tieba.write.write;

import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnFocusChangeListener {
    final /* synthetic */ AtListActivity cxb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AtListActivity atListActivity) {
        this.cxb = atListActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.util.n.c(this.cxb.getPageContext().getPageActivity(), view);
        } else {
            com.baidu.adp.lib.util.n.d(this.cxb.getPageContext().getPageActivity(), view);
        }
    }
}
