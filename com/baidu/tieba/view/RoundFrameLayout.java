package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
/* loaded from: classes5.dex */
public class RoundFrameLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Path f21864e;

    /* renamed from: f  reason: collision with root package name */
    public RectF f21865f;

    public RoundFrameLayout(Context context) {
        super(context);
        a();
    }

    public final void a() {
        setWillNotDraw(false);
        this.f21864e = new Path();
        this.f21865f = new RectF();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-1);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.dispatchDraw(canvas);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        canvas.drawPath(this.f21864e, paint);
        if (saveLayer >= 1 && saveLayer <= canvas.getSaveCount()) {
            canvas.restoreToCount(saveLayer);
        }
        paint.setXfermode(null);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f21865f.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        this.f21864e.addOval(this.f21865f, Path.Direction.CW);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
