package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class dd implements View.OnClickListener {
    final /* synthetic */ WebActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a.reload();
    }
}
