package com.baidu.tieba.kn.pk.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.Scroller;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f1298a;
    public int b;
    public Bitmap c;
    public int d;
    public int e;
    public boolean f;
    public Scroller g;
    public int h;
    public int i = LocationClientOption.MIN_SCAN_SPAN;
    Rect j = new Rect();
    Rect k = new Rect();

    public void a(int i) {
        int i2 = i - this.f1298a;
        this.g.startScroll(this.f1298a, 0, i2, 0, (Math.abs(i2) * this.i) / this.h);
    }

    public void a(Canvas canvas) {
        if (this.g.computeScrollOffset()) {
            this.f1298a = this.g.getCurrX();
        }
        this.j.set(0, 0, this.d, this.e);
        this.k.set(this.f1298a - (this.d / 2), this.b - (this.e / 2), this.f1298a + (this.d / 2), this.b + (this.e / 2));
        canvas.drawBitmap(this.c, this.j, this.k, (Paint) null);
    }
}
