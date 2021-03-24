package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
/* loaded from: classes5.dex */
public class MistView extends FrameLayout {
    public static final int MASK_COLOR_DEFAULT_TRANSPARENT = Color.argb(127, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public static final long f23871a = 100;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f23872b;

    /* renamed from: c  reason: collision with root package name */
    public int f23873c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f23874d;

    public MistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23874d = new Rect();
        this.f23872b = new Paint();
        this.f23873c = MASK_COLOR_DEFAULT_TRANSPARENT;
    }

    public Rect getFocusFrame() {
        return this.f23874d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.f23872b.setColor(this.f23873c);
        if (this.f23874d.width() == 0) {
            return;
        }
        float f2 = width;
        canvas.drawRect(0.0f, 0.0f, f2, this.f23874d.top, this.f23872b);
        Rect rect = this.f23874d;
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom, this.f23872b);
        Rect rect2 = this.f23874d;
        canvas.drawRect(rect2.right, rect2.top, f2, rect2.bottom, this.f23872b);
        canvas.drawRect(0.0f, this.f23874d.bottom, f2, height, this.f23872b);
        Rect rect3 = this.f23874d;
        postInvalidateDelayed(100L, rect3.left, rect3.top, rect3.right, rect3.bottom);
    }

    public void setMistColor(int i) {
        this.f23873c = i;
        postInvalidate();
    }
}
