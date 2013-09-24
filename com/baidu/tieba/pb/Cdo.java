package com.baidu.tieba.pb;

import android.view.View;
/* renamed from: com.baidu.tieba.pb.do  reason: invalid class name */
/* loaded from: classes.dex */
class Cdo implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f1612a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(WebActivity webActivity) {
        this.f1612a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f1612a.f1518a.canGoForward()) {
            this.f1612a.f1518a.goForward();
        }
    }
}
