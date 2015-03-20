package com.baidu.tieba.write.write;

import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnFocusChangeListener {
    final /* synthetic */ AtListActivity cwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AtListActivity atListActivity) {
        this.cwI = atListActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.util.n.c(this.cwI.getPageContext().getPageActivity(), view);
        } else {
            com.baidu.adp.lib.util.n.d(this.cwI.getPageContext().getPageActivity(), view);
        }
    }
}
