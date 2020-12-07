package com.baidu.ufosdk.screencapedt;

import android.content.Intent;
import android.view.View;
/* loaded from: classes22.dex */
final class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScreenCapEditActivity f3731a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ScreenCapEditActivity screenCapEditActivity) {
        this.f3731a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        z = this.f3731a.I;
        if (z) {
            z2 = this.f3731a.K;
            if (z2) {
                this.f3731a.setResult(-77, new Intent());
            }
        }
        this.f3731a.finish();
    }
}
