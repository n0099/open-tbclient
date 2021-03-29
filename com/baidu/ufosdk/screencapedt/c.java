package com.baidu.ufosdk.screencapedt;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.ufosdk.f.m;
/* loaded from: classes5.dex */
public final class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f22981a;

    public c(ScreenCapEditActivity screenCapEditActivity) {
        this.f22981a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ScreenCapEditActivity screenCapEditActivity = this.f22981a;
        z = screenCapEditActivity.H;
        screenCapEditActivity.H = !z;
        z2 = this.f22981a.H;
        if (z2) {
            relativeLayout = this.f22981a.Q;
            relativeLayout.setBackgroundColor(-16777216);
            return;
        }
        relativeLayout2 = this.f22981a.Q;
        this.f22981a.getApplicationContext();
        relativeLayout2.setBackgroundDrawable(m.a(-16777216));
    }
}
