package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class dw implements View.OnClickListener {
    final /* synthetic */ WebActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dw(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.c.canGoForward()) {
            this.a.c.goForward();
        }
    }
}
