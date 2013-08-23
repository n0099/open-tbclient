package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class dh implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f1563a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(WebActivity webActivity) {
        this.f1563a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1563a.f1475a.reload();
    }
}
