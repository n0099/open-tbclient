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
    public Paint f22928a;

    /* renamed from: b  reason: collision with root package name */
    public Path f22929b;

    public i(Context context) {
        super(context);
        Paint paint = new Paint(1);
        this.f22928a = paint;
        paint.setColor(-3355444);
        this.f22928a.setStyle(Paint.Style.STROKE);
        this.f22928a.setStrokeWidth(3.0f);
        this.f22929b = new Path();
        this.f22928a.setPathEffect(new DashPathEffect(new float[]{15.0f, 5.0f}, 0.0f));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        this.f22929b.reset();
        this.f22929b.moveTo(0.0f, 0.0f);
        this.f22929b.lineTo(getWidth(), 0.0f);
        canvas.drawPath(this.f22929b, this.f22928a);
    }
}
