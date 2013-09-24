package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VcodeActivity f2124a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(VcodeActivity vcodeActivity) {
        this.f2124a = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2124a.finish();
    }
}
