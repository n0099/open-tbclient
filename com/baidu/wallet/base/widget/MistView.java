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
    public static final long f23540a = 100;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f23541b;

    /* renamed from: c  reason: collision with root package name */
    public int f23542c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f23543d;

    public MistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23543d = new Rect();
        this.f23541b = new Paint();
        this.f23542c = MASK_COLOR_DEFAULT_TRANSPARENT;
    }

    public Rect getFocusFrame() {
        return this.f23543d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.f23541b.setColor(this.f23542c);
        if (this.f23543d.width() == 0) {
            return;
        }
        float f2 = width;
        canvas.drawRect(0.0f, 0.0f, f2, this.f23543d.top, this.f23541b);
        Rect rect = this.f23543d;
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom, this.f23541b);
        Rect rect2 = this.f23543d;
        canvas.drawRect(rect2.right, rect2.top, f2, rect2.bottom, this.f23541b);
        canvas.drawRect(0.0f, this.f23543d.bottom, f2, height, this.f23541b);
        Rect rect3 = this.f23543d;
        postInvalidateDelayed(100L, rect3.left, rect3.top, rect3.right, rect3.bottom);
    }

    public void setMistColor(int i2) {
        this.f23542c = i2;
        postInvalidate();
    }
}
