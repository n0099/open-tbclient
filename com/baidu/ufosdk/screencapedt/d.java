package com.baidu.ufosdk.screencapedt;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.Button;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes21.dex */
final class d implements View.OnClickListener {
    final /* synthetic */ ScreenCapEditActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ScreenCapEditActivity screenCapEditActivity) {
        this.a = screenCapEditActivity;
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
        this.a.a(false);
        hashMap = this.a.t;
        for (Map.Entry entry : hashMap.entrySet()) {
            canvas = this.a.m;
            float b = ((a) entry.getValue()).b();
            float c = ((a) entry.getValue()).c();
            float d = ((a) entry.getValue()).d();
            float e = ((a) entry.getValue()).e();
            paint = this.a.n;
            canvas.drawRect(b, c, d, e, paint);
        }
        button = this.a.T;
        button.setClickable(false);
        z = this.a.I;
        if (!z) {
            ScreenCapEditActivity.j(this.a);
            ScreenCapEditActivity screenCapEditActivity = this.a;
            i = this.a.M;
            ScreenCapEditActivity.a(screenCapEditActivity, i);
            return;
        }
        z2 = this.a.L;
        if (!z2) {
            ScreenCapEditActivity.i(this.a);
            return;
        }
        ScreenCapEditActivity.j(this.a);
        ScreenCapEditActivity screenCapEditActivity2 = this.a;
        i2 = this.a.M;
        ScreenCapEditActivity.a(screenCapEditActivity2, i2);
    }
}
