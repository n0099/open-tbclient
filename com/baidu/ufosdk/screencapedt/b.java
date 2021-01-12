package com.baidu.ufosdk.screencapedt;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.baidu.ufosdk.f.m;
/* loaded from: classes7.dex */
final class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScreenCapEditActivity f5397a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ScreenCapEditActivity screenCapEditActivity) {
        this.f5397a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ScreenCapEditActivity screenCapEditActivity = this.f5397a;
        z = this.f5397a.H;
        screenCapEditActivity.H = !z;
        z2 = this.f5397a.H;
        if (z2) {
            relativeLayout2 = this.f5397a.Q;
            relativeLayout2.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            return;
        }
        relativeLayout = this.f5397a.Q;
        this.f5397a.getApplicationContext();
        relativeLayout.setBackgroundDrawable(m.a((int) ViewCompat.MEASURED_STATE_MASK));
    }
}
