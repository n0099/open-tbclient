package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class ep implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f2172a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ep(WebActivity webActivity) {
        this.f2172a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f2172a.f2056a.canGoBack()) {
            this.f2172a.f2056a.goBack();
        }
    }
}
