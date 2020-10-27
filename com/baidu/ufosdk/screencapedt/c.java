package com.baidu.ufosdk.screencapedt;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.ufosdk.f.m;
/* loaded from: classes22.dex */
final class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScreenCapEditActivity f3724a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ScreenCapEditActivity screenCapEditActivity) {
        this.f3724a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ScreenCapEditActivity screenCapEditActivity = this.f3724a;
        z = this.f3724a.H;
        screenCapEditActivity.H = !z;
        z2 = this.f3724a.H;
        if (z2) {
            relativeLayout = this.f3724a.Q;
            relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            return;
        }
        relativeLayout2 = this.f3724a.Q;
        this.f3724a.getApplicationContext();
        relativeLayout2.setBackgroundDrawable(m.a((int) ViewCompat.MEASURED_STATE_MASK));
    }
}
