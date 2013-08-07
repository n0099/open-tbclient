package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class de implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f1523a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(WebActivity webActivity) {
        this.f1523a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f1523a.f1438a.canGoBack()) {
            this.f1523a.f1438a.goBack();
        }
    }
}
