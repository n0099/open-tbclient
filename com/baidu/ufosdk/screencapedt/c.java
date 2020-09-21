package com.baidu.ufosdk.screencapedt;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.ufosdk.f.m;
/* loaded from: classes21.dex */
final class c implements View.OnClickListener {
    final /* synthetic */ ScreenCapEditActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ScreenCapEditActivity screenCapEditActivity) {
        this.a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ScreenCapEditActivity screenCapEditActivity = this.a;
        z = this.a.H;
        screenCapEditActivity.H = !z;
        z2 = this.a.H;
        if (z2) {
            relativeLayout = this.a.Q;
            relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            return;
        }
        relativeLayout2 = this.a.Q;
        this.a.getApplicationContext();
        relativeLayout2.setBackgroundDrawable(m.a((int) ViewCompat.MEASURED_STATE_MASK));
    }
}
