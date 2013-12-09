package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class er implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f2265a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public er(WebActivity webActivity) {
        this.f2265a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f2265a.f2147a.canGoBack()) {
            this.f2265a.f2147a.goBack();
        }
    }
}
