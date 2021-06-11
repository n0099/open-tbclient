package com.baidu.ufosdk.screencapedt;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.ufosdk.f.m;
/* loaded from: classes5.dex */
public final class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f22654a;

    public b(ScreenCapEditActivity screenCapEditActivity) {
        this.f22654a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ScreenCapEditActivity screenCapEditActivity = this.f22654a;
        z = screenCapEditActivity.H;
        screenCapEditActivity.H = !z;
        z2 = this.f22654a.H;
        if (z2) {
            relativeLayout2 = this.f22654a.Q;
            relativeLayout2.setBackgroundColor(-16777216);
            return;
        }
        relativeLayout = this.f22654a.Q;
        this.f22654a.getApplicationContext();
        relativeLayout.setBackgroundDrawable(m.a(-16777216));
    }
}
