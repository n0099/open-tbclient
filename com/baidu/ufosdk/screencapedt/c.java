package com.baidu.ufosdk.screencapedt;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.ufosdk.f.m;
/* loaded from: classes22.dex */
final class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScreenCapEditActivity f3726a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ScreenCapEditActivity screenCapEditActivity) {
        this.f3726a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ScreenCapEditActivity screenCapEditActivity = this.f3726a;
        z = this.f3726a.H;
        screenCapEditActivity.H = !z;
        z2 = this.f3726a.H;
        if (z2) {
            relativeLayout = this.f3726a.Q;
            relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            return;
        }
        relativeLayout2 = this.f3726a.Q;
        this.f3726a.getApplicationContext();
        relativeLayout2.setBackgroundDrawable(m.a((int) ViewCompat.MEASURED_STATE_MASK));
    }
}
