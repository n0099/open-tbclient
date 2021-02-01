package com.baidu.ufosdk.screencapedt;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.Button;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
final class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScreenCapEditActivity f5401a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ScreenCapEditActivity screenCapEditActivity) {
        this.f5401a = screenCapEditActivity;
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
        this.f5401a.a(false);
        hashMap = this.f5401a.t;
        for (Map.Entry entry : hashMap.entrySet()) {
            canvas = this.f5401a.m;
            float b2 = ((a) entry.getValue()).b();
            float c = ((a) entry.getValue()).c();
            float d = ((a) entry.getValue()).d();
            float e = ((a) entry.getValue()).e();
            paint = this.f5401a.n;
            canvas.drawRect(b2, c, d, e, paint);
        }
        button = this.f5401a.T;
        button.setClickable(false);
        z = this.f5401a.I;
        if (!z) {
            ScreenCapEditActivity.j(this.f5401a);
            ScreenCapEditActivity screenCapEditActivity = this.f5401a;
            i = this.f5401a.M;
            ScreenCapEditActivity.a(screenCapEditActivity, i);
            return;
        }
        z2 = this.f5401a.L;
        if (!z2) {
            ScreenCapEditActivity.i(this.f5401a);
            return;
        }
        ScreenCapEditActivity.j(this.f5401a);
        ScreenCapEditActivity screenCapEditActivity2 = this.f5401a;
        i2 = this.f5401a.M;
        ScreenCapEditActivity.a(screenCapEditActivity2, i2);
    }
}
