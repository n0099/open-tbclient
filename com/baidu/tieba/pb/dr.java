package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class dr implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f2131a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(WebActivity webActivity) {
        this.f2131a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2131a.f2035a.reload();
    }
}
