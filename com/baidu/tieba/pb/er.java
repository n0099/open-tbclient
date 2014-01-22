package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class er implements View.OnClickListener {
    final /* synthetic */ WebActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public er(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.a.canGoForward()) {
            this.a.a.goForward();
        }
    }
}
