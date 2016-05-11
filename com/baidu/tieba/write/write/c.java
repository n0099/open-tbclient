package com.baidu.tieba.write.write;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnFocusChangeListener {
    final /* synthetic */ AtListActivity fcq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AtListActivity atListActivity) {
        this.fcq = atListActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.util.k.a(this.fcq.getPageContext().getPageActivity(), view);
        } else {
            com.baidu.adp.lib.util.k.b(this.fcq.getPageContext().getPageActivity(), view);
        }
    }
}
