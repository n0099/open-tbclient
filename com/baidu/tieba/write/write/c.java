package com.baidu.tieba.write.write;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnFocusChangeListener {
    final /* synthetic */ AtListActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AtListActivity atListActivity) {
        this.dqn = atListActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.util.k.c(this.dqn.getPageContext().getPageActivity(), view);
        } else {
            com.baidu.adp.lib.util.k.d(this.dqn.getPageContext().getPageActivity(), view);
        }
    }
}
