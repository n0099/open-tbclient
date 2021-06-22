package com.bytedance.sdk.openadsdk.core.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class TTCountdownView extends View {
    public boolean A;
    public AtomicBoolean B;

    /* renamed from: a  reason: collision with root package name */
    public int f28758a;

    /* renamed from: b  reason: collision with root package name */
    public int f28759b;

    /* renamed from: c  reason: collision with root package name */
    public int f28760c;

    /* renamed from: d  reason: collision with root package name */
    public int f28761d;

    /* renamed from: e  reason: collision with root package name */
    public float f28762e;

    /* renamed from: f  reason: collision with root package name */
    public float f28763f;

    /* renamed from: g  reason: collision with root package name */
    public float f28764g;

    /* renamed from: h  reason: collision with root package name */
    public int f28765h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28766i;
    public float j;
    public float k;
    public float l;
    public String m;
    public boolean n;
    public Paint o;
    public Paint p;
    public Paint q;
    public Paint r;
    public float s;
    public float t;
    public RectF u;
    public a v;
    public AnimatorSet w;
    public ValueAnimator x;
    public ValueAnimator y;
    public ValueAnimator z;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public TTCountdownView(Context context) {
        this(context, null);
    }

    private void e() {
        Paint paint = new Paint(1);
        this.o = paint;
        paint.setColor(this.f28758a);
        this.o.setStrokeWidth(this.f28762e);
        this.o.setAntiAlias(true);
        this.o.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.p = paint2;
        paint2.setColor(this.f28760c);
        this.p.setAntiAlias(true);
        this.p.setStrokeWidth(this.f28762e);
        this.p.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.q = paint3;
        paint3.setColor(this.f28759b);
        this.q.setAntiAlias(true);
        this.q.setStrokeWidth(this.f28762e / 2.0f);
        this.q.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint(1);
        this.r = paint4;
        paint4.setColor(this.f28761d);
        this.q.setAntiAlias(true);
        this.r.setTextSize(this.f28763f);
        this.r.setTextAlign(Paint.Align.CENTER);
    }

    private void f() {
        float f2 = this.f28764g;
        this.u = new RectF(-f2, -f2, f2, f2);
    }

    private int g() {
        return (int) ((((this.f28762e / 2.0f) + this.f28764g) * 2.0f) + a(4.0f));
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.y;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.y = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.s, 0.0f);
        this.y = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.y.setDuration(a(this.s, this.j) * 1000.0f);
        this.y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownView.this.s = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownView.this.postInvalidate();
            }
        });
        return this.y;
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.x;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.x = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.t, 0.0f);
        this.x = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.x.setDuration(a(this.t, this.k) * 1000.0f);
        this.x.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownView.this.t = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownView.this.postInvalidate();
            }
        });
        return this.x;
    }

    public float a(float f2, float f3) {
        return f2 * f3;
    }

    public float a(float f2, int i2) {
        return i2 * f2;
    }

    public void c() {
        try {
            if (this.w == null || Build.VERSION.SDK_INT < 19) {
                return;
            }
            this.w.pause();
        } catch (Throwable unused) {
        }
    }

    public void d() {
        try {
            if (this.w == null || Build.VERSION.SDK_INT < 19) {
                return;
            }
            this.w.resume();
        } catch (Throwable unused) {
        }
    }

    public a getCountdownListener() {
        return this.v;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        b(canvas);
        a(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824) {
            size = g();
        }
        if (mode2 != 1073741824) {
            size2 = g();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.B.set(z);
        if (!this.B.get()) {
            c();
            a aVar = this.v;
            if (aVar != null) {
                aVar.c();
                return;
            }
            return;
        }
        d();
        a aVar2 = this.v;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    public void setCountDownTime(int i2) {
        float f2 = i2;
        this.k = f2;
        this.j = f2;
        b();
    }

    public void setCountdownListener(a aVar) {
        this.v = aVar;
        if (this.B.get() || aVar == null) {
            return;
        }
        aVar.c();
    }

    public TTCountdownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTCountdownView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f28758a = Color.parseColor("#fce8b6");
        this.f28759b = Color.parseColor("#f0f0f0");
        this.f28760c = Color.parseColor("#ffffff");
        this.f28761d = Color.parseColor("#7c7c7c");
        this.f28762e = 2.0f;
        this.f28763f = 12.0f;
        this.f28764g = 18.0f;
        this.f28765h = 270;
        this.f28766i = false;
        this.j = 5.0f;
        this.k = 5.0f;
        this.l = 0.8f;
        this.m = "跳过";
        this.n = false;
        this.s = 1.0f;
        this.t = 1.0f;
        this.A = false;
        this.B = new AtomicBoolean(true);
        this.f28762e = a(2.0f);
        this.f28764g = a(18.0f);
        this.f28763f = b(12.0f);
        this.f28765h %= 360;
        e();
        f();
    }

    private void b(Canvas canvas) {
        float f2;
        canvas.save();
        float a2 = a(this.s, 360);
        if (this.f28766i) {
            f2 = this.f28765h - a2;
        } else {
            f2 = this.f28765h;
        }
        canvas.drawCircle(0.0f, 0.0f, this.f28764g, this.p);
        canvas.drawCircle(0.0f, 0.0f, this.f28764g, this.q);
        canvas.drawArc(this.u, f2, a2, false, this.o);
        canvas.restore();
    }

    private void a(Canvas canvas) {
        String str;
        canvas.save();
        Paint.FontMetrics fontMetrics = this.r.getFontMetrics();
        if (this.n) {
            str = "" + ((int) Math.ceil(a(this.t, this.k)));
        } else {
            str = this.m;
        }
        if (TextUtils.isEmpty(str)) {
            str = "跳过";
        }
        canvas.drawText(str, 0.0f, 0.0f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.r);
        canvas.restore();
    }

    public void a() {
        AnimatorSet animatorSet = this.w;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.w.cancel();
            this.w = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.w = animatorSet2;
        animatorSet2.playTogether(getNumAnim(), getArcAnim());
        this.w.setInterpolator(new LinearInterpolator());
        this.w.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                TTCountdownView.this.A = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!TTCountdownView.this.A) {
                    if (TTCountdownView.this.v != null) {
                        TTCountdownView.this.v.b();
                        return;
                    }
                    return;
                }
                TTCountdownView.this.A = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.w.start();
        if (this.B.get()) {
            return;
        }
        c();
    }

    public void b() {
        AnimatorSet animatorSet = this.w;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.w = null;
        }
        ValueAnimator valueAnimator = this.z;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.z = null;
        }
        ValueAnimator valueAnimator2 = this.x;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.x = null;
        }
        ValueAnimator valueAnimator3 = this.y;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.y = null;
        }
        this.s = 1.0f;
        this.t = 1.0f;
        invalidate();
    }

    private float a(float f2) {
        return TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
    }

    private float b(float f2) {
        return TypedValue.applyDimension(2, f2, getResources().getDisplayMetrics());
    }
}
