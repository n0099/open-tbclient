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
import d.a.c.e.m.e;
import d.a.c.e.p.l;
import java.util.Random;
/* loaded from: classes5.dex */
public class AudioAnimationView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f22356e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f22357f;

    /* renamed from: g  reason: collision with root package name */
    public Random f22358g;

    /* renamed from: h  reason: collision with root package name */
    public int f22359h;

    /* renamed from: i  reason: collision with root package name */
    public int f22360i;
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
        this.f22356e = 3;
        this.f22358g = new Random();
        this.f22359h = 0;
        this.f22360i = 8;
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
        this.f22357f = paint;
        paint.setDither(true);
        this.f22357f.setAntiAlias(true);
        this.f22357f.setStyle(Paint.Style.FILL);
        this.f22357f.setColor(SkinManager.getColor(this.q));
    }

    public final void d() {
        int nextInt;
        RectF[] rectFArr = this.n;
        if (rectFArr == null || rectFArr.length != this.f22360i) {
            this.n = new RectF[this.f22360i];
        }
        for (int i2 = 0; i2 < this.f22360i; i2++) {
            int i3 = this.p * i2 * 2;
            if (this.k) {
                nextInt = (int) ((1.0d - (this.o[i2 % 22] / 10.0d)) * this.m);
            } else {
                int i4 = this.m;
                nextInt = i4 > 0 ? this.f22358g.nextInt(i4) : 0;
            }
            int i5 = this.p + i3;
            int i6 = this.m;
            RectF[] rectFArr2 = this.n;
            if (rectFArr2[i2] == null) {
                rectFArr2[i2] = new RectF(i3, nextInt, i5, i6);
            } else {
                rectFArr2[i2].set(i3, nextInt, i5, i6);
            }
        }
    }

    public void e(int i2) {
        Paint paint;
        if (i2 == this.f22356e || (paint = this.f22357f) == null) {
            return;
        }
        paint.setColor(SkinManager.getColor(this.q));
        invalidate();
        this.f22356e = i2;
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
            for (int i2 = 0; i2 < this.f22360i; i2++) {
                d();
                if (i2 < this.n.length) {
                    canvas.save();
                    canvas.translate(0.0f, -(this.n[i2].top / 2.0f));
                    canvas.drawRoundRect(this.n[i2], 10.0f, 10.0f, this.f22357f);
                    canvas.restore();
                }
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i2, int i3) {
        if (this.f22359h > 0) {
            int mode = View.MeasureSpec.getMode(i2);
            int i4 = this.p;
            int i5 = this.f22359h;
            int i6 = i4 * ((i5 * 2) - 1);
            this.l = i6;
            this.f22360i = i5;
            i2 = View.MeasureSpec.makeMeasureSpec(i6, mode);
        }
        super.onMeasure(i2, i3);
        this.m = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        this.l = measuredWidth;
        if (this.f22359h <= 0) {
            this.f22360i = (measuredWidth / this.p) / 2;
        }
    }

    public void setCertainColumnCount(int i2) {
        if (i2 != 0) {
            this.f22359h = i2;
        }
    }

    public void setColumnColor(int i2) {
        Paint paint = this.f22357f;
        if (paint != null) {
            paint.setColor(SkinManager.getColor(i2));
        }
        this.q = i2;
    }

    public void setColumnWidth(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.p = i2;
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22356e = 3;
        this.f22358g = new Random();
        this.f22359h = 0;
        this.f22360i = 8;
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
