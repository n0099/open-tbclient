package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class eq implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f2173a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eq(WebActivity webActivity) {
        this.f2173a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f2173a.f2056a.canGoForward()) {
            this.f2173a.f2056a.goForward();
        }
    }
}
