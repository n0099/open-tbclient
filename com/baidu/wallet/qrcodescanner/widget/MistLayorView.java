package com.baidu.wallet.qrcodescanner.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes5.dex */
public class MistLayorView extends View {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f26449a;

    /* renamed from: b  reason: collision with root package name */
    public final int f26450b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f26451c;

    public MistLayorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26451c = new Rect();
        this.f26449a = new Paint();
        this.f26450b = Color.argb(127, 0, 0, 0);
    }

    public Rect getFocusFrame() {
        return this.f26451c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.f26449a.setColor(this.f26450b);
        if (this.f26451c.width() == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.f26449a);
            return;
        }
        float f2 = width;
        canvas.drawRect(0.0f, 0.0f, f2, this.f26451c.top, this.f26449a);
        Rect rect = this.f26451c;
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f26449a);
        Rect rect2 = this.f26451c;
        canvas.drawRect(rect2.right + 1, rect2.top, f2, rect2.bottom + 1, this.f26449a);
        canvas.drawRect(0.0f, this.f26451c.bottom + 1, f2, height, this.f26449a);
    }

    public void setFocusFrame(Rect rect) {
        this.f26451c = rect;
        invalidate();
    }
}
