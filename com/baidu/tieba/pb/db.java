package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class db implements View.OnClickListener {
    final /* synthetic */ WebActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.c.canGoBack()) {
            this.a.c.goBack();
        }
    }
}
