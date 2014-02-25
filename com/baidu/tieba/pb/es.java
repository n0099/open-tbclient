package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class es implements View.OnClickListener {
    final /* synthetic */ WebActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public es(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.a.canGoBack()) {
            this.a.a.goBack();
        }
    }
}
