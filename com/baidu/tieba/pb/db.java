package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class db implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f1272a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(WebActivity webActivity) {
        this.f1272a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f1272a.f1190a.canGoBack()) {
            this.f1272a.f1190a.goBack();
        }
    }
}
