package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
/* loaded from: classes7.dex */
public final class i extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f5598a;

    /* renamed from: b  reason: collision with root package name */
    private Path f5599b;

    public i(Context context) {
        super(context);
        this.f5598a = new Paint(1);
        this.f5598a.setColor(-3355444);
        this.f5598a.setStyle(Paint.Style.STROKE);
        this.f5598a.setStrokeWidth(3.0f);
        this.f5599b = new Path();
        this.f5598a.setPathEffect(new DashPathEffect(new float[]{15.0f, 5.0f}, 0.0f));
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        this.f5599b.reset();
        this.f5599b.moveTo(0.0f, 0.0f);
        this.f5599b.lineTo(getWidth(), 0.0f);
        canvas.drawPath(this.f5599b, this.f5598a);
    }
}
