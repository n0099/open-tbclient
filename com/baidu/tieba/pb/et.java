package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class et implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f2266a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public et(WebActivity webActivity) {
        this.f2266a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2266a.f2146a.reload();
    }
}
