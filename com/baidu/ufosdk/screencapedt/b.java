package com.baidu.ufosdk.screencapedt;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.ufosdk.f.m;
/* loaded from: classes21.dex */
final class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScreenCapEditActivity f3725a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ScreenCapEditActivity screenCapEditActivity) {
        this.f3725a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ScreenCapEditActivity screenCapEditActivity = this.f3725a;
        z = this.f3725a.H;
        screenCapEditActivity.H = !z;
        z2 = this.f3725a.H;
        if (z2) {
            relativeLayout2 = this.f3725a.Q;
            relativeLayout2.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            return;
        }
        relativeLayout = this.f3725a.Q;
        this.f3725a.getApplicationContext();
        relativeLayout.setBackgroundDrawable(m.a((int) ViewCompat.MEASURED_STATE_MASK));
    }
}
