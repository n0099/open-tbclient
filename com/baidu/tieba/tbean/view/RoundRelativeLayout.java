package com.baidu.tieba.tbean.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class RoundRelativeLayout extends RelativeLayout {
    public static final int l = R.color.black_alpha4;

    /* renamed from: e  reason: collision with root package name */
    public float f21474e;

    /* renamed from: f  reason: collision with root package name */
    public Shape f21475f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f21476g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f21477h;
    public RectF i;
    public Paint j;
    public int k;

    public RoundRelativeLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.save();
        RectF rectF = this.i;
        float f2 = this.f21474e;
        canvas.drawRoundRect(rectF, f2, f2, this.j);
        super.dispatchDraw(canvas);
        Shape shape = this.f21475f;
        if (shape != null) {
            shape.draw(canvas, this.f21476g);
        }
        RectF rectF2 = this.i;
        float f3 = this.f21474e;
        canvas.drawRoundRect(rectF2, f3, f3, this.f21477h);
        if (saveCount < 1 || saveCount > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(saveCount);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.f21475f == null) {
                float[] fArr = new float[8];
                Arrays.fill(fArr, 0.0f);
                float dimension = ((float) getPaddingLeft()) <= getResources().getDimension(R.dimen.tbds8) ? getResources().getDimension(R.dimen.tbds8) : getPaddingLeft();
                float dimension2 = ((float) getPaddingRight()) <= getResources().getDimension(R.dimen.tbds8) ? getResources().getDimension(R.dimen.tbds8) : getPaddingRight();
                float paddingTop = getPaddingTop() <= 0 ? 1.0f : getPaddingTop();
                float dimension3 = ((float) getPaddingBottom()) <= getResources().getDimension(R.dimen.tbds8) ? getResources().getDimension(R.dimen.tbds8) : getPaddingBottom();
                RectF rectF = new RectF(dimension, paddingTop, dimension2, dimension3);
                float[] fArr2 = new float[8];
                Arrays.fill(fArr2, this.f21474e);
                this.f21475f = new RoundRectShape(fArr, rectF, fArr2);
                this.i.set(dimension, paddingTop, getWidth() - dimension2, getHeight() - dimension3);
            }
            this.f21475f.resize(getWidth(), getHeight());
        }
    }

    public void setBgColorRes(int i) {
        this.k = i;
        if (i != 0) {
            this.j.setColor(getContext().getResources().getColor(this.k));
            invalidate();
        }
    }

    public void setRadius(float f2) {
        this.f21474e = f2;
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21474e = 0.0f;
        setLayerType(1, null);
        Paint paint = new Paint();
        this.f21476g = paint;
        paint.setAntiAlias(true);
        this.f21476g.setColor(-1);
        this.f21476g.setStyle(Paint.Style.FILL);
        this.f21476g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.f21477h = paint2;
        paint2.setAntiAlias(true);
        this.f21477h.setColor(0);
        this.f21477h.setStyle(Paint.Style.FILL);
        this.f21477h.setShadowLayer(getResources().getDimension(R.dimen.tbds5), 0.0f, getResources().getDimension(R.dimen.tbds8), getResources().getColor(l));
        this.f21477h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.i = new RectF();
        Paint paint3 = new Paint();
        this.j = paint3;
        paint3.setAntiAlias(true);
        this.j.setColor(-1);
        this.f21476g.setStyle(Paint.Style.FILL);
    }
}
