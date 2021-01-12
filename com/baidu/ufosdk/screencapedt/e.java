package com.baidu.ufosdk.screencapedt;

import android.content.Intent;
import android.view.View;
/* loaded from: classes7.dex */
final class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScreenCapEditActivity f5400a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ScreenCapEditActivity screenCapEditActivity) {
        this.f5400a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        z = this.f5400a.I;
        if (z) {
            z2 = this.f5400a.K;
            if (z2) {
                this.f5400a.setResult(-77, new Intent());
            }
        }
        this.f5400a.finish();
    }
}
