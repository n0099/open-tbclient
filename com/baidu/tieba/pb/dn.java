package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class dn implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f1611a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(WebActivity webActivity) {
        this.f1611a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f1611a.f1518a.canGoBack()) {
            this.f1611a.f1518a.goBack();
        }
    }
}
