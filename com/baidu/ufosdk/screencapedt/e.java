package com.baidu.ufosdk.screencapedt;

import android.content.Intent;
import android.view.View;
/* loaded from: classes5.dex */
public final class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f22554a;

    public e(ScreenCapEditActivity screenCapEditActivity) {
        this.f22554a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        z = this.f22554a.I;
        if (z) {
            z2 = this.f22554a.K;
            if (z2) {
                this.f22554a.setResult(-77, new Intent());
            }
        }
        this.f22554a.finish();
    }
}
