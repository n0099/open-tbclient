package com.baidu.ufosdk.screencapedt;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.ufosdk.f.m;
/* loaded from: classes5.dex */
public final class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f22665a;

    public b(ScreenCapEditActivity screenCapEditActivity) {
        this.f22665a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ScreenCapEditActivity screenCapEditActivity = this.f22665a;
        z = screenCapEditActivity.H;
        screenCapEditActivity.H = !z;
        z2 = this.f22665a.H;
        if (z2) {
            relativeLayout2 = this.f22665a.Q;
            relativeLayout2.setBackgroundColor(-16777216);
            return;
        }
        relativeLayout = this.f22665a.Q;
        this.f22665a.getApplicationContext();
        relativeLayout.setBackgroundDrawable(m.a(-16777216));
    }
}
