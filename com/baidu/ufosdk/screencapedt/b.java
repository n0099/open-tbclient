package com.baidu.ufosdk.screencapedt;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.baidu.ufosdk.f.m;
/* loaded from: classes8.dex */
final class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScreenCapEditActivity f5679a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ScreenCapEditActivity screenCapEditActivity) {
        this.f5679a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ScreenCapEditActivity screenCapEditActivity = this.f5679a;
        z = this.f5679a.H;
        screenCapEditActivity.H = !z;
        z2 = this.f5679a.H;
        if (z2) {
            relativeLayout2 = this.f5679a.Q;
            relativeLayout2.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            return;
        }
        relativeLayout = this.f5679a.Q;
        this.f5679a.getApplicationContext();
        relativeLayout.setBackgroundDrawable(m.a((int) ViewCompat.MEASURED_STATE_MASK));
    }
}
