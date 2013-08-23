package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class dg implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f1562a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(WebActivity webActivity) {
        this.f1562a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f1562a.f1475a.canGoForward()) {
            this.f1562a.f1475a.goForward();
        }
    }
}
