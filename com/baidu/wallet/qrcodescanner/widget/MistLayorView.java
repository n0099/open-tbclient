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
    public final Paint f27264a;

    /* renamed from: b  reason: collision with root package name */
    public final int f27265b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f27266c;

    public MistLayorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27266c = new Rect();
        this.f27264a = new Paint();
        this.f27265b = Color.argb(127, 0, 0, 0);
    }

    public Rect getFocusFrame() {
        return this.f27266c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.f27264a.setColor(this.f27265b);
        if (this.f27266c.width() == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.f27264a);
            return;
        }
        float f2 = width;
        canvas.drawRect(0.0f, 0.0f, f2, this.f27266c.top, this.f27264a);
        Rect rect = this.f27266c;
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f27264a);
        Rect rect2 = this.f27266c;
        canvas.drawRect(rect2.right + 1, rect2.top, f2, rect2.bottom + 1, this.f27264a);
        canvas.drawRect(0.0f, this.f27266c.bottom + 1, f2, height, this.f27264a);
    }

    public void setFocusFrame(Rect rect) {
        this.f27266c = rect;
        invalidate();
    }
}
