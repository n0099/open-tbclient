package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
/* loaded from: classes5.dex */
public final class i extends View {

    /* renamed from: a  reason: collision with root package name */
    public Paint f23277a;

    /* renamed from: b  reason: collision with root package name */
    public Path f23278b;

    public i(Context context) {
        super(context);
        Paint paint = new Paint(1);
        this.f23277a = paint;
        paint.setColor(-3355444);
        this.f23277a.setStyle(Paint.Style.STROKE);
        this.f23277a.setStrokeWidth(3.0f);
        this.f23278b = new Path();
        this.f23277a.setPathEffect(new DashPathEffect(new float[]{15.0f, 5.0f}, 0.0f));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        this.f23278b.reset();
        this.f23278b.moveTo(0.0f, 0.0f);
        this.f23278b.lineTo(getWidth(), 0.0f);
        canvas.drawPath(this.f23278b, this.f23277a);
    }
}
