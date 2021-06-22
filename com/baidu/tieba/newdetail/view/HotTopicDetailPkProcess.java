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
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class HotTopicDetailPkProcess extends View {
    public static int o = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    public static int p = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);

    /* renamed from: e  reason: collision with root package name */
    public int f18660e;

    /* renamed from: f  reason: collision with root package name */
    public int f18661f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f18662g;

    /* renamed from: h  reason: collision with root package name */
    public int f18663h;

    /* renamed from: i  reason: collision with root package name */
    public int f18664i;
    public float j;
    public RectF k;
    public Path l;
    public int m;
    public ValueAnimator n;

    /* loaded from: classes5.dex */
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
        this.f18660e = 3;
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
        this.f18662g.setColor(this.f18663h);
        RectF rectF = this.k;
        int i2 = o;
        rectF.set(0.0f, 0.0f, i2, i2);
        canvas.drawArc(this.k, 90.0f, 180.0f, true, this.f18662g);
        RectF rectF2 = this.k;
        int i3 = o;
        rectF2.set(i3 / 2, 0.0f, this.m, i3);
        canvas.drawRect(this.k, this.f18662g);
    }

    public final void c(Canvas canvas) {
        b(canvas);
        d(canvas);
        e(canvas);
    }

    public final void d(Canvas canvas) {
        this.f18662g.setColor(this.f18664i);
        RectF rectF = this.k;
        int i2 = this.f18661f;
        int i3 = o;
        rectF.set(i2 - i3, 0.0f, i2, i3);
        canvas.drawArc(this.k, -90.0f, 180.0f, true, this.f18662g);
        RectF rectF2 = this.k;
        int i4 = this.m;
        int i5 = o;
        rectF2.set(i4 + i5 + p, 0.0f, this.f18661f - (i5 / 2), i5);
        canvas.drawRect(this.k, this.f18662g);
    }

    public final void e(Canvas canvas) {
        this.f18662g.setColor(this.f18663h);
        this.l.reset();
        this.l.moveTo(this.m, o);
        this.l.lineTo(this.m + o, 0.0f);
        this.l.lineTo(this.m, 0.0f);
        this.l.close();
        canvas.drawPath(this.l, this.f18662g);
        this.f18662g.setColor(this.f18664i);
        this.l.reset();
        this.l.moveTo(this.m + p, o);
        Path path = this.l;
        int i2 = this.m + p;
        int i3 = o;
        path.lineTo(i2 + i3, i3);
        this.l.lineTo(this.m + p + o, 0.0f);
        this.l.close();
        canvas.drawPath(this.l, this.f18662g);
    }

    public final void f() {
        Paint paint = new Paint(1);
        this.f18662g = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        g(TbadkCoreApplication.getInst().getSkinType());
    }

    public void g(int i2) {
        if (this.f18660e != i2) {
            this.f18663h = SkinManager.getColor(R.color.CAM_X0308);
            this.f18664i = SkinManager.getColor(R.color.CAM_X0303);
            if (this.f18660e != 3) {
                invalidate();
            }
            this.f18660e = i2;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f18661f <= 0) {
            return;
        }
        c(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i2), o);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f18661f = i2;
        int i6 = o;
        this.m = ((int) ((((i2 - i6) - (p + i6)) * this.j) / 100.0f)) + (i6 / 2);
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
            int i2 = this.f18661f;
            int i3 = o;
            this.m = ((int) ((((i2 - i3) - (p + i3)) * f3) / 100.0f)) + (i3 / 2);
            invalidate();
            return;
        }
        a(f2);
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18660e = 3;
        this.j = 50.0f;
        this.k = new RectF();
        this.l = new Path();
        f();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18660e = 3;
        this.j = 50.0f;
        this.k = new RectF();
        this.l = new Path();
        f();
    }
}
