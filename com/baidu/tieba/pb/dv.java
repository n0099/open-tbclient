package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class dv implements View.OnClickListener {
    final /* synthetic */ WebActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dv(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.c.reload();
    }
}
