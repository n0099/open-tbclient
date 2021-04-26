package com.baidu.ufosdk.screencapedt;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.Button;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f23379a;

    public d(ScreenCapEditActivity screenCapEditActivity) {
        this.f23379a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        HashMap hashMap;
        Button button;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        Canvas canvas;
        Paint paint;
        this.f23379a.a(false);
        hashMap = this.f23379a.t;
        for (Map.Entry entry : hashMap.entrySet()) {
            canvas = this.f23379a.m;
            float b2 = ((a) entry.getValue()).b();
            float c2 = ((a) entry.getValue()).c();
            float d2 = ((a) entry.getValue()).d();
            float e2 = ((a) entry.getValue()).e();
            paint = this.f23379a.n;
            canvas.drawRect(b2, c2, d2, e2, paint);
        }
        button = this.f23379a.T;
        button.setClickable(false);
        z = this.f23379a.I;
        if (!z) {
            ScreenCapEditActivity.j(this.f23379a);
            ScreenCapEditActivity screenCapEditActivity = this.f23379a;
            i2 = screenCapEditActivity.M;
            ScreenCapEditActivity.a(screenCapEditActivity, i2);
            return;
        }
        z2 = this.f23379a.L;
        if (!z2) {
            ScreenCapEditActivity.i(this.f23379a);
            return;
        }
        ScreenCapEditActivity.j(this.f23379a);
        ScreenCapEditActivity screenCapEditActivity2 = this.f23379a;
        i3 = screenCapEditActivity2.M;
        ScreenCapEditActivity.a(screenCapEditActivity2, i3);
    }
}
