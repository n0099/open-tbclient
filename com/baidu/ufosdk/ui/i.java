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
    private Paint f5600a;

    /* renamed from: b  reason: collision with root package name */
    private Path f5601b;

    public i(Context context) {
        super(context);
        this.f5600a = new Paint(1);
        this.f5600a.setColor(-3355444);
        this.f5600a.setStyle(Paint.Style.STROKE);
        this.f5600a.setStrokeWidth(3.0f);
        this.f5601b = new Path();
        this.f5600a.setPathEffect(new DashPathEffect(new float[]{15.0f, 5.0f}, 0.0f));
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        this.f5601b.reset();
        this.f5601b.moveTo(0.0f, 0.0f);
        this.f5601b.lineTo(getWidth(), 0.0f);
        canvas.drawPath(this.f5601b, this.f5600a);
    }
}
