package com.baidu.ufosdk.screencapedt;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.ufosdk.f.m;
/* loaded from: classes5.dex */
public final class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f22674a;

    public c(ScreenCapEditActivity screenCapEditActivity) {
        this.f22674a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ScreenCapEditActivity screenCapEditActivity = this.f22674a;
        z = screenCapEditActivity.H;
        screenCapEditActivity.H = !z;
        z2 = this.f22674a.H;
        if (z2) {
            relativeLayout = this.f22674a.Q;
            relativeLayout.setBackgroundColor(-16777216);
            return;
        }
        relativeLayout2 = this.f22674a.Q;
        this.f22674a.getApplicationContext();
        relativeLayout2.setBackgroundDrawable(m.a(-16777216));
    }
}
