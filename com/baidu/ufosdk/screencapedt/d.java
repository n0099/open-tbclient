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
    final /* synthetic */ ScreenCapEditActivity f3633a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ScreenCapEditActivity screenCapEditActivity) {
        this.f3633a = screenCapEditActivity;
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
        this.f3633a.a(false);
        hashMap = this.f3633a.t;
        for (Map.Entry entry : hashMap.entrySet()) {
            canvas = this.f3633a.m;
            float b = ((a) entry.getValue()).b();
            float c = ((a) entry.getValue()).c();
            float d = ((a) entry.getValue()).d();
            float e = ((a) entry.getValue()).e();
            paint = this.f3633a.n;
            canvas.drawRect(b, c, d, e, paint);
        }
        button = this.f3633a.T;
        button.setClickable(false);
        z = this.f3633a.I;
        if (!z) {
            ScreenCapEditActivity.j(this.f3633a);
            ScreenCapEditActivity screenCapEditActivity = this.f3633a;
            i = this.f3633a.M;
            ScreenCapEditActivity.a(screenCapEditActivity, i);
            return;
        }
        z2 = this.f3633a.L;
        if (!z2) {
            ScreenCapEditActivity.i(this.f3633a);
            return;
        }
        ScreenCapEditActivity.j(this.f3633a);
        ScreenCapEditActivity screenCapEditActivity2 = this.f3633a;
        i2 = this.f3633a.M;
        ScreenCapEditActivity.a(screenCapEditActivity2, i2);
    }
}
