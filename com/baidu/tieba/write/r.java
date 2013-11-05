package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VcodeActivity f2669a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(VcodeActivity vcodeActivity) {
        this.f2669a = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2669a.finish();
    }
}
