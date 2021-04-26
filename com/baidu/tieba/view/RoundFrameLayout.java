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
    public Path f22526e;

    /* renamed from: f  reason: collision with root package name */
    public RectF f22527f;

    public RoundFrameLayout(Context context) {
        super(context);
        a();
    }

    public final void a() {
        setWillNotDraw(false);
        this.f22526e = new Path();
        this.f22527f = new RectF();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-1);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.dispatchDraw(canvas);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        canvas.drawPath(this.f22526e, paint);
        if (saveLayer >= 1 && saveLayer <= canvas.getSaveCount()) {
            canvas.restoreToCount(saveLayer);
        }
        paint.setXfermode(null);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f22527f.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        this.f22526e.addOval(this.f22527f, Path.Direction.CW);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
