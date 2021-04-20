package com.baidu.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import d.b.c.e.p.l;
import d.b.i0.m1.b;
import d.b.i0.m1.g;
/* loaded from: classes5.dex */
public class PluginRoundProgressBar extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f21849e;

    /* renamed from: f  reason: collision with root package name */
    public int f21850f;

    /* renamed from: g  reason: collision with root package name */
    public int f21851g;

    /* renamed from: h  reason: collision with root package name */
    public int f21852h;
    public float i;
    public float j;
    public int k;
    public int l;
    public boolean m;
    public int n;
    public RectF o;
    public a p;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i);
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
        int i;
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f2 = width;
        int i2 = (int) ((f2 - (this.j / 2.0f)) - 5.0f);
        this.f21849e.setColor(this.f21850f);
        this.f21849e.setStyle(Paint.Style.STROKE);
        this.f21849e.setStrokeWidth(this.j);
        this.f21849e.setAntiAlias(true);
        canvas.drawCircle(f2, f2, i2, this.f21849e);
        this.f21849e.setStyle(Paint.Style.FILL);
        this.f21849e.setStrokeWidth(0.0f);
        this.f21849e.setColor(this.f21852h);
        this.f21849e.setTextSize(this.i);
        int i3 = (int) ((this.l / this.k) * 100.0f);
        float measureText = this.f21849e.measureText(i3 + "%");
        if (this.m && this.n == 0) {
            if (i3 == 0) {
                i3 = 1;
            }
            canvas.drawText(i3 + "%", f2 - (measureText / 2.0f), f2 + (this.i / 2.0f), this.f21849e);
        }
        this.f21849e.setStrokeWidth(this.j);
        this.f21849e.setColor(this.f21851g);
        float f3 = width - i2;
        float f4 = width + i2;
        this.o.set(f3, f3, f4, f4);
        int i4 = this.n;
        if (i4 == 0) {
            this.f21849e.setStyle(Paint.Style.STROKE);
            canvas.drawArc(this.o, -90.0f, (this.l * 360) / this.k, false, this.f21849e);
        } else if (i4 != 1) {
        } else {
            this.f21849e.setStyle(Paint.Style.FILL_AND_STROKE);
            if (this.l != 0) {
                canvas.drawArc(this.o, -90.0f, (i * 360) / this.k, true, this.f21849e);
            }
        }
    }

    public synchronized void setMax(int i) {
        if (i >= 0) {
            this.k = i;
        } else {
            throw new IllegalArgumentException("max not less than 0");
        }
    }

    public void setOnProgressChangeListener(a aVar) {
        this.p = aVar;
    }

    public synchronized void setProgress(int i) {
        if (i >= 0) {
            if (i > this.k) {
                i = this.k;
            }
            if (i <= this.k) {
                this.l = i;
                if (this.p != null) {
                    this.p.a(i);
                }
                postInvalidate();
            }
        } else {
            throw new IllegalArgumentException("progress not less than 0");
        }
    }

    public void setRoundColor(int i) {
        this.f21850f = i;
    }

    public void setRoundProgressColor(int i) {
        this.f21851g = i;
    }

    public void setTextColor(int i) {
        this.f21852h = i;
    }

    public PluginRoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginRoundProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21849e = new Paint();
        this.o = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.RoundProgressBar);
        this.f21850f = obtainStyledAttributes.getColor(g.RoundProgressBar_roundColor, getResources().getColor(b.round_progressbar_round_color));
        this.f21851g = obtainStyledAttributes.getColor(g.RoundProgressBar_roundProgressColor, getResources().getColor(b.color_logo));
        this.f21852h = obtainStyledAttributes.getColor(g.RoundProgressBar_roundTextColor, getResources().getColor(b.plugin_loading_white));
        this.i = obtainStyledAttributes.getDimension(g.RoundProgressBar_roundTextSize, l.e(getContext(), 11.0f));
        this.j = obtainStyledAttributes.getDimension(g.RoundProgressBar_roundWidth, 7.0f);
        this.k = obtainStyledAttributes.getInteger(g.RoundProgressBar_roundMax, 100);
        this.m = obtainStyledAttributes.getBoolean(g.RoundProgressBar_roundTextIsDisplayable, true);
        this.n = obtainStyledAttributes.getInt(g.RoundProgressBar_roundStyle, 0);
        obtainStyledAttributes.recycle();
    }
}
