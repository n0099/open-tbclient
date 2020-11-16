package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
/* loaded from: classes21.dex */
public final class i extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f3879a;
    private Path b;

    public i(Context context) {
        super(context);
        this.f3879a = new Paint(1);
        this.f3879a.setColor(-3355444);
        this.f3879a.setStyle(Paint.Style.STROKE);
        this.f3879a.setStrokeWidth(3.0f);
        this.b = new Path();
        this.f3879a.setPathEffect(new DashPathEffect(new float[]{15.0f, 5.0f}, 0.0f));
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        this.b.reset();
        this.b.moveTo(0.0f, 0.0f);
        this.b.lineTo(getWidth(), 0.0f);
        canvas.drawPath(this.b, this.f3879a);
    }
}
