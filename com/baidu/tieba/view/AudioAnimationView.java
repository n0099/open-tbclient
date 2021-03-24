package com.baidu.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.e.m.e;
import d.b.b.e.p.l;
import java.util.Random;
/* loaded from: classes5.dex */
public class AudioAnimationView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f22017e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f22018f;

    /* renamed from: g  reason: collision with root package name */
    public Random f22019g;

    /* renamed from: h  reason: collision with root package name */
    public int f22020h;
    public int i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public RectF[] n;
    public int[] o;
    public int p;
    public int q;
    public final Runnable r;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AudioAnimationView.this.b();
        }
    }

    public AudioAnimationView(Context context) {
        super(context);
        this.f22017e = 3;
        this.f22019g = new Random();
        this.f22020h = 0;
        this.i = 8;
        this.j = false;
        this.k = true;
        this.o = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.p = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.q = R.color.CAM_X0302;
        this.r = new a();
        c();
        b();
    }

    public final void b() {
        if (this.j) {
            invalidate();
        }
        e.a().removeCallbacks(this.r);
        if (this.k) {
            return;
        }
        e.a().postDelayed(this.r, 250L);
    }

    public final void c() {
        Paint paint = new Paint();
        this.f22018f = paint;
        paint.setDither(true);
        this.f22018f.setAntiAlias(true);
        this.f22018f.setStyle(Paint.Style.FILL);
        this.f22018f.setColor(SkinManager.getColor(this.q));
    }

    public final void d() {
        int nextInt;
        RectF[] rectFArr = this.n;
        if (rectFArr == null || rectFArr.length != this.i) {
            this.n = new RectF[this.i];
        }
        for (int i = 0; i < this.i; i++) {
            int i2 = this.p * i * 2;
            if (this.k) {
                double d2 = this.o[i % 22];
                Double.isNaN(d2);
                double d3 = 1.0d - (d2 / 10.0d);
                double d4 = this.m;
                Double.isNaN(d4);
                nextInt = (int) (d3 * d4);
            } else {
                int i3 = this.m;
                nextInt = i3 > 0 ? this.f22019g.nextInt(i3) : 0;
            }
            int i4 = this.p + i2;
            int i5 = this.m;
            RectF[] rectFArr2 = this.n;
            if (rectFArr2[i] == null) {
                rectFArr2[i] = new RectF(i2, nextInt, i4, i5);
            } else {
                rectFArr2[i].set(i2, nextInt, i4, i5);
            }
        }
    }

    public void e(int i) {
        Paint paint;
        if (i == this.f22017e || (paint = this.f22018f) == null) {
            return;
        }
        paint.setColor(SkinManager.getColor(this.q));
        invalidate();
        this.f22017e = i;
    }

    public void f() {
        this.j = true;
        this.k = true;
        b();
    }

    public void g() {
        this.j = true;
        this.k = false;
        b();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e.a().removeCallbacks(this.r);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.j) {
            for (int i = 0; i < this.i; i++) {
                d();
                if (i < this.n.length) {
                    canvas.save();
                    canvas.translate(0.0f, -(this.n[i].top / 2.0f));
                    canvas.drawRoundRect(this.n[i], 10.0f, 10.0f, this.f22018f);
                    canvas.restore();
                }
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i, int i2) {
        if (this.f22020h > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int i3 = this.p;
            int i4 = this.f22020h;
            int i5 = i3 * ((i4 * 2) - 1);
            this.l = i5;
            this.i = i4;
            i = View.MeasureSpec.makeMeasureSpec(i5, mode);
        }
        super.onMeasure(i, i2);
        this.m = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        this.l = measuredWidth;
        if (this.f22020h <= 0) {
            this.i = (measuredWidth / this.p) / 2;
        }
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.f22020h = i;
        }
    }

    public void setColumnColor(int i) {
        Paint paint = this.f22018f;
        if (paint != null) {
            paint.setColor(SkinManager.getColor(i));
        }
        this.q = i;
    }

    public void setColumnWidth(int i) {
        if (i <= 0) {
            return;
        }
        this.p = i;
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22017e = 3;
        this.f22019g = new Random();
        this.f22020h = 0;
        this.i = 8;
        this.j = false;
        this.k = true;
        this.o = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.p = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.q = R.color.CAM_X0302;
        this.r = new a();
        c();
        b();
    }
}
