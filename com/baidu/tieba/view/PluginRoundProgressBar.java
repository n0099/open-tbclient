package com.baidu.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import d.a.c.e.p.l;
import d.a.n0.n1.b;
import d.a.n0.n1.h;
/* loaded from: classes5.dex */
public class PluginRoundProgressBar extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f21691e;

    /* renamed from: f  reason: collision with root package name */
    public int f21692f;

    /* renamed from: g  reason: collision with root package name */
    public int f21693g;

    /* renamed from: h  reason: collision with root package name */
    public int f21694h;

    /* renamed from: i  reason: collision with root package name */
    public float f21695i;
    public float j;
    public int k;
    public int l;
    public boolean m;
    public int n;
    public RectF o;
    public a p;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i2);
    }

    public PluginRoundProgressBar(Context context) {
        this(context, null);
    }

    public synchronized int getMax() {
        return this.k;
    }

    public synchronized int getProgress() {
        return this.l;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f2 = width;
        int i3 = (int) ((f2 - (this.j / 2.0f)) - 5.0f);
        this.f21691e.setColor(this.f21692f);
        this.f21691e.setStyle(Paint.Style.STROKE);
        this.f21691e.setStrokeWidth(this.j);
        this.f21691e.setAntiAlias(true);
        canvas.drawCircle(f2, f2, i3, this.f21691e);
        this.f21691e.setStyle(Paint.Style.FILL);
        this.f21691e.setStrokeWidth(0.0f);
        this.f21691e.setColor(this.f21694h);
        this.f21691e.setTextSize(this.f21695i);
        int i4 = (int) ((this.l / this.k) * 100.0f);
        float measureText = this.f21691e.measureText(i4 + "%");
        if (this.m && this.n == 0) {
            if (i4 == 0) {
                i4 = 1;
            }
            canvas.drawText(i4 + "%", f2 - (measureText / 2.0f), f2 + (this.f21695i / 2.0f), this.f21691e);
        }
        this.f21691e.setStrokeWidth(this.j);
        this.f21691e.setColor(this.f21693g);
        float f3 = width - i3;
        float f4 = width + i3;
        this.o.set(f3, f3, f4, f4);
        int i5 = this.n;
        if (i5 == 0) {
            this.f21691e.setStyle(Paint.Style.STROKE);
            canvas.drawArc(this.o, -90.0f, (this.l * 360) / this.k, false, this.f21691e);
        } else if (i5 != 1) {
        } else {
            this.f21691e.setStyle(Paint.Style.FILL_AND_STROKE);
            if (this.l != 0) {
                canvas.drawArc(this.o, -90.0f, (i2 * 360) / this.k, true, this.f21691e);
            }
        }
    }

    public synchronized void setMax(int i2) {
        if (i2 >= 0) {
            this.k = i2;
        } else {
            throw new IllegalArgumentException("max not less than 0");
        }
    }

    public void setOnProgressChangeListener(a aVar) {
        this.p = aVar;
    }

    public synchronized void setProgress(int i2) {
        if (i2 >= 0) {
            if (i2 > this.k) {
                i2 = this.k;
            }
            if (i2 <= this.k) {
                this.l = i2;
                if (this.p != null) {
                    this.p.a(i2);
                }
                postInvalidate();
            }
        } else {
            throw new IllegalArgumentException("progress not less than 0");
        }
    }

    public void setRoundColor(int i2) {
        this.f21692f = i2;
    }

    public void setRoundProgressColor(int i2) {
        this.f21693g = i2;
    }

    public void setTextColor(int i2) {
        this.f21694h = i2;
    }

    public PluginRoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginRoundProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21691e = new Paint();
        this.o = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.RoundProgressBar);
        this.f21692f = obtainStyledAttributes.getColor(h.RoundProgressBar_roundColor, getResources().getColor(b.round_progressbar_round_color));
        this.f21693g = obtainStyledAttributes.getColor(h.RoundProgressBar_roundProgressColor, getResources().getColor(b.color_logo));
        this.f21694h = obtainStyledAttributes.getColor(h.RoundProgressBar_roundTextColor, getResources().getColor(b.plugin_loading_white));
        this.f21695i = obtainStyledAttributes.getDimension(h.RoundProgressBar_roundTextSize, l.e(getContext(), 11.0f));
        this.j = obtainStyledAttributes.getDimension(h.RoundProgressBar_roundWidth, 7.0f);
        this.k = obtainStyledAttributes.getInteger(h.RoundProgressBar_roundMax, 100);
        this.m = obtainStyledAttributes.getBoolean(h.RoundProgressBar_roundTextIsDisplayable, true);
        this.n = obtainStyledAttributes.getInt(h.RoundProgressBar_roundStyle, 0);
        obtainStyledAttributes.recycle();
    }
}
