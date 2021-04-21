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
    public final /* synthetic */ ScreenCapEditActivity f22675a;

    public d(ScreenCapEditActivity screenCapEditActivity) {
        this.f22675a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        HashMap hashMap;
        Button button;
        boolean z;
        int i;
        boolean z2;
        int i2;
        Canvas canvas;
        Paint paint;
        this.f22675a.a(false);
        hashMap = this.f22675a.t;
        for (Map.Entry entry : hashMap.entrySet()) {
            canvas = this.f22675a.m;
            float b2 = ((a) entry.getValue()).b();
            float c2 = ((a) entry.getValue()).c();
            float d2 = ((a) entry.getValue()).d();
            float e2 = ((a) entry.getValue()).e();
            paint = this.f22675a.n;
            canvas.drawRect(b2, c2, d2, e2, paint);
        }
        button = this.f22675a.T;
        button.setClickable(false);
        z = this.f22675a.I;
        if (!z) {
            ScreenCapEditActivity.j(this.f22675a);
            ScreenCapEditActivity screenCapEditActivity = this.f22675a;
            i = screenCapEditActivity.M;
            ScreenCapEditActivity.a(screenCapEditActivity, i);
            return;
        }
        z2 = this.f22675a.L;
        if (!z2) {
            ScreenCapEditActivity.i(this.f22675a);
            return;
        }
        ScreenCapEditActivity.j(this.f22675a);
        ScreenCapEditActivity screenCapEditActivity2 = this.f22675a;
        i2 = screenCapEditActivity2.M;
        ScreenCapEditActivity.a(screenCapEditActivity2, i2);
    }
}
