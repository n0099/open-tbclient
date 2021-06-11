package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class ChooseColorView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f19685e;

    /* renamed from: f  reason: collision with root package name */
    public int f19686f;

    /* renamed from: g  reason: collision with root package name */
    public float f19687g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f19688h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f19689i;
    public int j;
    public boolean k;
    public Bitmap l;

    public ChooseColorView(Context context) {
        this(context, null);
    }

    public final void a() {
        Paint paint = new Paint();
        this.f19689i = paint;
        paint.setAntiAlias(true);
        this.f19689i.setColor(this.f19685e);
        Paint paint2 = new Paint();
        this.f19688h = paint2;
        paint2.setColor(this.f19686f);
        this.f19688h.setAntiAlias(true);
        this.f19688h.setStyle(Paint.Style.STROKE);
        this.f19688h.setStrokeWidth(this.f19687g);
        this.l = BitmapFactory.decodeResource(getResources(), R.drawable.icon_select_n);
    }

    public int getChooseColor() {
        return this.f19685e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.j, this.f19689i);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.j, this.f19688h);
        if (this.k) {
            canvas.drawBitmap(this.l, getWidth() - this.l.getWidth(), 0.0f, (Paint) null);
        }
    }

    public void setChooseColor(int i2) {
        this.f19685e = i2;
        this.f19689i.setColor(i2);
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
        this.f19685e = -16777216;
        this.f19686f = -1;
        this.f19687g = getResources().getDimensionPixelSize(R.dimen.ds4);
        a();
    }
}
