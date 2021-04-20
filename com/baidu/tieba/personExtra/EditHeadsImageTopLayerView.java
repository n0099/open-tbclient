package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f19987e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f19988f;

    /* renamed from: g  reason: collision with root package name */
    public int f19989g;

    /* renamed from: h  reason: collision with root package name */
    public int f19990h;
    public float i;
    public float j;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.f19987e = null;
        this.f19988f = null;
        this.f19989g = 0;
        this.f19990h = 0;
        this.i = 0.42857143f;
        this.j = 1.0f;
        a();
    }

    public final void a() {
        Paint paint = new Paint();
        this.f19987e = paint;
        paint.setColor(-16777216);
        this.f19987e.setAlpha(153);
        Paint paint2 = new Paint();
        this.f19988f = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f19988f.setColor(-1);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.f19989g, this.f19987e);
        canvas.drawRect(0.0f, getHeight() - this.f19990h, getWidth(), getHeight(), this.f19987e);
        canvas.drawRect(1.0f, this.f19989g, getWidth() - 1, getHeight() - this.f19990h, this.f19988f);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.j * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        float f2 = (i4 - i2) - width;
        float f3 = this.i;
        this.f19989g = (int) (f2 * f3);
        this.f19990h = (int) (f2 * (1.0f - f3));
    }

    public void setLinePaintColor(int i) {
        Paint paint = this.f19988f;
        if (paint != null) {
            paint.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        Paint paint = this.f19988f;
        if (paint != null) {
            paint.setStrokeWidth(i);
        }
        invalidate();
    }

    public void setmCutHeightScale(float f2) {
        this.j = f2;
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19987e = null;
        this.f19988f = null;
        this.f19989g = 0;
        this.f19990h = 0;
        this.i = 0.42857143f;
        this.j = 1.0f;
        a();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19987e = null;
        this.f19988f = null;
        this.f19989g = 0;
        this.f19990h = 0;
        this.i = 0.42857143f;
        this.j = 1.0f;
        a();
    }
}
