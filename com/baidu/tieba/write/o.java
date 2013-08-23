package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VcodeActivity f1939a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(VcodeActivity vcodeActivity) {
        this.f1939a = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1939a.finish();
    }
}
