package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class dq implements View.OnClickListener {
    final /* synthetic */ WebActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.c.reload();
    }
}
