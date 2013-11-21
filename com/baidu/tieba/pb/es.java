package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class es implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f2158a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public es(WebActivity webActivity) {
        this.f2158a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f2158a.f2039a.canGoForward()) {
            this.f2158a.f2039a.goForward();
        }
    }
}
