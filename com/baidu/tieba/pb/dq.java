package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class dq implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f2130a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(WebActivity webActivity) {
        this.f2130a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f2130a.f2035a.canGoForward()) {
            this.f2130a.f2035a.goForward();
        }
    }
}
