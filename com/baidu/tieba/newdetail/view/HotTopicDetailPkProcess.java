package com.baidu.tieba.newdetail.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class HotTopicDetailPkProcess extends View {
    public static int o = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    public static int p = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);

    /* renamed from: e  reason: collision with root package name */
    public int f19174e;

    /* renamed from: f  reason: collision with root package name */
    public int f19175f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f19176g;

    /* renamed from: h  reason: collision with root package name */
    public int f19177h;
    public int i;
    public float j;
    public RectF k;
    public Path l;
    public int m;
    public ValueAnimator n;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            HotTopicDetailPkProcess.this.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
        }
    }

    public HotTopicDetailPkProcess(Context context) {
        super(context);
        this.f19174e = 3;
        this.j = 50.0f;
        this.k = new RectF();
        this.l = new Path();
        f();
    }

    public final void a(float f2) {
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.j / 100.0f, f2);
        this.n = ofFloat;
        ofFloat.setDuration(300L);
        this.n.setInterpolator(new AccelerateDecelerateInterpolator());
        this.n.addUpdateListener(new a());
        this.n.start();
    }

    public final void b(Canvas canvas) {
        this.f19176g.setColor(this.f19177h);
        RectF rectF = this.k;
        int i = o;
        rectF.set(0.0f, 0.0f, i, i);
        canvas.drawArc(this.k, 90.0f, 180.0f, true, this.f19176g);
        RectF rectF2 = this.k;
        int i2 = o;
        rectF2.set(i2 / 2, 0.0f, this.m, i2);
        canvas.drawRect(this.k, this.f19176g);
    }

    public final void c(Canvas canvas) {
        b(canvas);
        d(canvas);
        e(canvas);
    }

    public final void d(Canvas canvas) {
        this.f19176g.setColor(this.i);
        RectF rectF = this.k;
        int i = this.f19175f;
        int i2 = o;
        rectF.set(i - i2, 0.0f, i, i2);
        canvas.drawArc(this.k, -90.0f, 180.0f, true, this.f19176g);
        RectF rectF2 = this.k;
        int i3 = this.m;
        int i4 = o;
        rectF2.set(i3 + i4 + p, 0.0f, this.f19175f - (i4 / 2), i4);
        canvas.drawRect(this.k, this.f19176g);
    }

    public final void e(Canvas canvas) {
        this.f19176g.setColor(this.f19177h);
        this.l.reset();
        this.l.moveTo(this.m, o);
        this.l.lineTo(this.m + o, 0.0f);
        this.l.lineTo(this.m, 0.0f);
        this.l.close();
        canvas.drawPath(this.l, this.f19176g);
        this.f19176g.setColor(this.i);
        this.l.reset();
        this.l.moveTo(this.m + p, o);
        Path path = this.l;
        int i = this.m + p;
        int i2 = o;
        path.lineTo(i + i2, i2);
        this.l.lineTo(this.m + p + o, 0.0f);
        this.l.close();
        canvas.drawPath(this.l, this.f19176g);
    }

    public final void f() {
        Paint paint = new Paint(1);
        this.f19176g = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        g(TbadkCoreApplication.getInst().getSkinType());
    }

    public void g(int i) {
        if (this.f19174e != i) {
            this.f19177h = SkinManager.getColor(R.color.CAM_X0308);
            this.i = SkinManager.getColor(R.color.CAM_X0303);
            if (this.f19174e != 3) {
                invalidate();
            }
            this.f19174e = i;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f19175f <= 0) {
            return;
        }
        c(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i), o);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f19175f = i;
        int i5 = o;
        this.m = ((int) ((((i - i5) - (p + i5)) * this.j) / 100.0f)) + (i5 / 2);
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f2, boolean z) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (!z) {
            float f3 = f2 * 100.0f;
            this.j = f3;
            int i = this.f19175f;
            int i2 = o;
            this.m = ((int) ((((i - i2) - (p + i2)) * f3) / 100.0f)) + (i2 / 2);
            invalidate();
            return;
        }
        a(f2);
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19174e = 3;
        this.j = 50.0f;
        this.k = new RectF();
        this.l = new Path();
        f();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19174e = 3;
        this.j = 50.0f;
        this.k = new RectF();
        this.l = new Path();
        f();
    }
}
