package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class du implements View.OnClickListener {
    final /* synthetic */ WebActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public du(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.c.canGoForward()) {
            this.a.c.goForward();
        }
    }
}
