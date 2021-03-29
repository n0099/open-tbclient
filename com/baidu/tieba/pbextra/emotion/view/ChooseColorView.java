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
    public int f20197e;

    /* renamed from: f  reason: collision with root package name */
    public int f20198f;

    /* renamed from: g  reason: collision with root package name */
    public float f20199g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f20200h;
    public Paint i;
    public int j;
    public boolean k;
    public Bitmap l;

    public ChooseColorView(Context context) {
        this(context, null);
    }

    public final void a() {
        Paint paint = new Paint();
        this.i = paint;
        paint.setAntiAlias(true);
        this.i.setColor(this.f20197e);
        Paint paint2 = new Paint();
        this.f20200h = paint2;
        paint2.setColor(this.f20198f);
        this.f20200h.setAntiAlias(true);
        this.f20200h.setStyle(Paint.Style.STROKE);
        this.f20200h.setStrokeWidth(this.f20199g);
        this.l = BitmapFactory.decodeResource(getResources(), R.drawable.icon_select_n);
    }

    public int getChooseColor() {
        return this.f20197e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.j, this.i);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.j, this.f20200h);
        if (this.k) {
            canvas.drawBitmap(this.l, getWidth() - this.l.getWidth(), 0.0f, (Paint) null);
        }
    }

    public void setChooseColor(int i) {
        this.f20197e = i;
        this.i.setColor(i);
    }

    public void setIsChooseView(boolean z) {
        this.k = z;
        invalidate();
    }

    public void setRadius(int i) {
        this.j = i;
    }

    public ChooseColorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20197e = -16777216;
        this.f20198f = -1;
        this.f20199g = getResources().getDimensionPixelSize(R.dimen.ds4);
        a();
    }
}
