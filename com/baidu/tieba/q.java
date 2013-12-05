package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CommonWebviewActivity f2399a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(CommonWebviewActivity commonWebviewActivity) {
        this.f2399a = commonWebviewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2399a.finish();
    }
}
