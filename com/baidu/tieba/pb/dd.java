package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class dd implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f1274a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(WebActivity webActivity) {
        this.f1274a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1274a.f1190a.reload();
    }
}
