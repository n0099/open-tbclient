package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class df implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f1561a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(WebActivity webActivity) {
        this.f1561a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f1561a.f1475a.canGoBack()) {
            this.f1561a.f1475a.goBack();
        }
    }
}
