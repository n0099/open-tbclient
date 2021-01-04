package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
/* loaded from: classes8.dex */
public final class i extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f5880a;

    /* renamed from: b  reason: collision with root package name */
    private Path f5881b;

    public i(Context context) {
        super(context);
        this.f5880a = new Paint(1);
        this.f5880a.setColor(-3355444);
        this.f5880a.setStyle(Paint.Style.STROKE);
        this.f5880a.setStrokeWidth(3.0f);
        this.f5881b = new Path();
        this.f5880a.setPathEffect(new DashPathEffect(new float[]{15.0f, 5.0f}, 0.0f));
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        this.f5881b.reset();
        this.f5881b.moveTo(0.0f, 0.0f);
        this.f5881b.lineTo(getWidth(), 0.0f);
        canvas.drawPath(this.f5881b, this.f5880a);
    }
}
