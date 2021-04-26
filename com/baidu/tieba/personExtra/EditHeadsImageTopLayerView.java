package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes4.dex */
public class EditHeadsImageTopLayerView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f20501e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f20502f;

    /* renamed from: g  reason: collision with root package name */
    public int f20503g;

    /* renamed from: h  reason: collision with root package name */
    public int f20504h;

    /* renamed from: i  reason: collision with root package name */
    public float f20505i;
    public float j;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.f20501e = null;
        this.f20502f = null;
        this.f20503g = 0;
        this.f20504h = 0;
        this.f20505i = 0.42857143f;
        this.j = 1.0f;
        a();
    }

    public final void a() {
        Paint paint = new Paint();
        this.f20501e = paint;
        paint.setColor(-16777216);
        this.f20501e.setAlpha(153);
        Paint paint2 = new Paint();
        this.f20502f = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f20502f.setColor(-1);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.f20503g, this.f20501e);
        canvas.drawRect(0.0f, getHeight() - this.f20504h, getWidth(), getHeight(), this.f20501e);
        canvas.drawRect(1.0f, this.f20503g, getWidth() - 1, getHeight() - this.f20504h, this.f20502f);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        float width = this.j * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        float f2 = (i5 - i3) - width;
        float f3 = this.f20505i;
        this.f20503g = (int) (f2 * f3);
        this.f20504h = (int) (f2 * (1.0f - f3));
    }

    public void setLinePaintColor(int i2) {
        Paint paint = this.f20502f;
        if (paint != null) {
            paint.setColor(i2);
        }
        invalidate();
    }

    public void setLineWidth(int i2) {
        Paint paint = this.f20502f;
        if (paint != null) {
            paint.setStrokeWidth(i2);
        }
        invalidate();
    }

    public void setmCutHeightScale(float f2) {
        this.j = f2;
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20501e = null;
        this.f20502f = null;
        this.f20503g = 0;
        this.f20504h = 0;
        this.f20505i = 0.42857143f;
        this.j = 1.0f;
        a();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20501e = null;
        this.f20502f = null;
        this.f20503g = 0;
        this.f20504h = 0;
        this.f20505i = 0.42857143f;
        this.j = 1.0f;
        a();
    }
}
