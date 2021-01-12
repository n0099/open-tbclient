package com.baidu.ufosdk.screencapedt;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.Button;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
final class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScreenCapEditActivity f5399a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ScreenCapEditActivity screenCapEditActivity) {
        this.f5399a = screenCapEditActivity;
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
        this.f5399a.a(false);
        hashMap = this.f5399a.t;
        for (Map.Entry entry : hashMap.entrySet()) {
            canvas = this.f5399a.m;
            float b2 = ((a) entry.getValue()).b();
            float c = ((a) entry.getValue()).c();
            float d = ((a) entry.getValue()).d();
            float e = ((a) entry.getValue()).e();
            paint = this.f5399a.n;
            canvas.drawRect(b2, c, d, e, paint);
        }
        button = this.f5399a.T;
        button.setClickable(false);
        z = this.f5399a.I;
        if (!z) {
            ScreenCapEditActivity.j(this.f5399a);
            ScreenCapEditActivity screenCapEditActivity = this.f5399a;
            i = this.f5399a.M;
            ScreenCapEditActivity.a(screenCapEditActivity, i);
            return;
        }
        z2 = this.f5399a.L;
        if (!z2) {
            ScreenCapEditActivity.i(this.f5399a);
            return;
        }
        ScreenCapEditActivity.j(this.f5399a);
        ScreenCapEditActivity screenCapEditActivity2 = this.f5399a;
        i2 = this.f5399a.M;
        ScreenCapEditActivity.a(screenCapEditActivity2, i2);
    }
}
