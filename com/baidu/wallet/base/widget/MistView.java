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
    public static final long f23565a = 100;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f23566b;

    /* renamed from: c  reason: collision with root package name */
    public int f23567c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f23568d;

    public MistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23568d = new Rect();
        this.f23566b = new Paint();
        this.f23567c = MASK_COLOR_DEFAULT_TRANSPARENT;
    }

    public Rect getFocusFrame() {
        return this.f23568d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.f23566b.setColor(this.f23567c);
        if (this.f23568d.width() == 0) {
            return;
        }
        float f2 = width;
        canvas.drawRect(0.0f, 0.0f, f2, this.f23568d.top, this.f23566b);
        Rect rect = this.f23568d;
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom, this.f23566b);
        Rect rect2 = this.f23568d;
        canvas.drawRect(rect2.right, rect2.top, f2, rect2.bottom, this.f23566b);
        canvas.drawRect(0.0f, this.f23568d.bottom, f2, height, this.f23566b);
        Rect rect3 = this.f23568d;
        postInvalidateDelayed(100L, rect3.left, rect3.top, rect3.right, rect3.bottom);
    }

    public void setMistColor(int i) {
        this.f23567c = i;
        postInvalidate();
    }
}
