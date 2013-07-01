package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class dc implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f1273a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(WebActivity webActivity) {
        this.f1273a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f1273a.f1190a.canGoForward()) {
            this.f1273a.f1190a.goForward();
        }
    }
}
