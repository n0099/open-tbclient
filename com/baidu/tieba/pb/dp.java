package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class dp implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f1613a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(WebActivity webActivity) {
        this.f1613a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1613a.f1518a.reload();
    }
}
