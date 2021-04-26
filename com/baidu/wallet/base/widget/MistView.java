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
    public static final long f24295a = 100;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f24296b;

    /* renamed from: c  reason: collision with root package name */
    public int f24297c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f24298d;

    public MistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24298d = new Rect();
        this.f24296b = new Paint();
        this.f24297c = MASK_COLOR_DEFAULT_TRANSPARENT;
    }

    public Rect getFocusFrame() {
        return this.f24298d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.f24296b.setColor(this.f24297c);
        if (this.f24298d.width() == 0) {
            return;
        }
        float f2 = width;
        canvas.drawRect(0.0f, 0.0f, f2, this.f24298d.top, this.f24296b);
        Rect rect = this.f24298d;
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom, this.f24296b);
        Rect rect2 = this.f24298d;
        canvas.drawRect(rect2.right, rect2.top, f2, rect2.bottom, this.f24296b);
        canvas.drawRect(0.0f, this.f24298d.bottom, f2, height, this.f24296b);
        Rect rect3 = this.f24298d;
        postInvalidateDelayed(100L, rect3.left, rect3.top, rect3.right, rect3.bottom);
    }

    public void setMistColor(int i2) {
        this.f24297c = i2;
        postInvalidate();
    }
}
