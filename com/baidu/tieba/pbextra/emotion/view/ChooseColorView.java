package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ChooseColorView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f20398e;

    /* renamed from: f  reason: collision with root package name */
    public int f20399f;

    /* renamed from: g  reason: collision with root package name */
    public float f20400g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f20401h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f20402i;
    public int j;
    public boolean k;
    public Bitmap l;

    public ChooseColorView(Context context) {
        this(context, null);
    }

    public final void a() {
        Paint paint = new Paint();
        this.f20402i = paint;
        paint.setAntiAlias(true);
        this.f20402i.setColor(this.f20398e);
        Paint paint2 = new Paint();
        this.f20401h = paint2;
        paint2.setColor(this.f20399f);
        this.f20401h.setAntiAlias(true);
        this.f20401h.setStyle(Paint.Style.STROKE);
        this.f20401h.setStrokeWidth(this.f20400g);
        this.l = BitmapFactory.decodeResource(getResources(), R.drawable.icon_select_n);
    }

    public int getChooseColor() {
        return this.f20398e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.j, this.f20402i);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.j, this.f20401h);
        if (this.k) {
            canvas.drawBitmap(this.l, getWidth() - this.l.getWidth(), 0.0f, (Paint) null);
        }
    }

    public void setChooseColor(int i2) {
        this.f20398e = i2;
        this.f20402i.setColor(i2);
    }

    public void setIsChooseView(boolean z) {
        this.k = z;
        invalidate();
    }

    public void setRadius(int i2) {
        this.j = i2;
    }

    public ChooseColorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20398e = -16777216;
        this.f20399f = -1;
        this.f20400g = getResources().getDimensionPixelSize(R.dimen.ds4);
        a();
    }
}
