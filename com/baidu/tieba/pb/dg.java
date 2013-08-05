package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class dg implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f1527a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(WebActivity webActivity) {
        this.f1527a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1527a.f1440a.reload();
    }
}
