package com.baidu.ufosdk.screencapedt;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.Button;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes22.dex */
final class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScreenCapEditActivity f3725a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ScreenCapEditActivity screenCapEditActivity) {
        this.f3725a = screenCapEditActivity;
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
        this.f3725a.a(false);
        hashMap = this.f3725a.t;
        for (Map.Entry entry : hashMap.entrySet()) {
            canvas = this.f3725a.m;
            float b = ((a) entry.getValue()).b();
            float c = ((a) entry.getValue()).c();
            float d = ((a) entry.getValue()).d();
            float e = ((a) entry.getValue()).e();
            paint = this.f3725a.n;
            canvas.drawRect(b, c, d, e, paint);
        }
        button = this.f3725a.T;
        button.setClickable(false);
        z = this.f3725a.I;
        if (!z) {
            ScreenCapEditActivity.j(this.f3725a);
            ScreenCapEditActivity screenCapEditActivity = this.f3725a;
            i = this.f3725a.M;
            ScreenCapEditActivity.a(screenCapEditActivity, i);
            return;
        }
        z2 = this.f3725a.L;
        if (!z2) {
            ScreenCapEditActivity.i(this.f3725a);
            return;
        }
        ScreenCapEditActivity.j(this.f3725a);
        ScreenCapEditActivity screenCapEditActivity2 = this.f3725a;
        i2 = this.f3725a.M;
        ScreenCapEditActivity.a(screenCapEditActivity2, i2);
    }
}
