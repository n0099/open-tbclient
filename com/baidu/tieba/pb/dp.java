package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class dp implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f2129a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(WebActivity webActivity) {
        this.f2129a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f2129a.f2035a.canGoBack()) {
            this.f2129a.f2035a.goBack();
        }
    }
}
