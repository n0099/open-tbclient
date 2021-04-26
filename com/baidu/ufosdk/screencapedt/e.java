package com.baidu.ufosdk.screencapedt;

import android.content.Intent;
import android.view.View;
/* loaded from: classes5.dex */
public final class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f23380a;

    public e(ScreenCapEditActivity screenCapEditActivity) {
        this.f23380a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        z = this.f23380a.I;
        if (z) {
            z2 = this.f23380a.K;
            if (z2) {
                this.f23380a.setResult(-77, new Intent());
            }
        }
        this.f23380a.finish();
    }
}
