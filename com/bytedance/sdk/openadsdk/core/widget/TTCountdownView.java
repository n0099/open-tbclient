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
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class TTCountdownView extends View {
    private boolean A;
    private AtomicBoolean B;

    /* renamed from: a  reason: collision with root package name */
    private int f7072a;

    /* renamed from: b  reason: collision with root package name */
    private int f7073b;
    private int c;
    private int d;
    private float e;
    private float f;
    private float g;
    private int h;
    private boolean i;
    private float j;
    private float k;
    private float l;
    private String m;
    private boolean n;
    private Paint o;
    private Paint p;
    private Paint q;
    private Paint r;
    private float s;
    private float t;
    private RectF u;
    private a v;
    private AnimatorSet w;
    private ValueAnimator x;
    private ValueAnimator y;
    private ValueAnimator z;

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public TTCountdownView(Context context) {
        this(context, null);
    }

    public TTCountdownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTCountdownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7072a = Color.parseColor("#fce8b6");
        this.f7073b = Color.parseColor("#f0f0f0");
        this.c = Color.parseColor("#ffffff");
        this.d = Color.parseColor("#7c7c7c");
        this.e = 2.0f;
        this.f = 12.0f;
        this.g = 18.0f;
        this.h = SubsamplingScaleImageView.ORIENTATION_270;
        this.i = false;
        this.j = 5.0f;
        this.k = 5.0f;
        this.l = 0.8f;
        this.m = "跳过";
        this.n = false;
        this.s = 1.0f;
        this.t = 1.0f;
        this.A = false;
        this.B = new AtomicBoolean(true);
        this.e = a(2.0f);
        this.g = a(18.0f);
        this.f = b(12.0f);
        this.h %= EncoderTextureDrawer.X264_WIDTH;
        e();
        f();
    }

    private void e() {
        this.o = new Paint(1);
        this.o.setColor(this.f7072a);
        this.o.setStrokeWidth(this.e);
        this.o.setAntiAlias(true);
        this.o.setStyle(Paint.Style.STROKE);
        this.p = new Paint(1);
        this.p.setColor(this.c);
        this.p.setAntiAlias(true);
        this.p.setStrokeWidth(this.e);
        this.p.setStyle(Paint.Style.FILL);
        this.q = new Paint(1);
        this.q.setColor(this.f7073b);
        this.q.setAntiAlias(true);
        this.q.setStrokeWidth(this.e / 2.0f);
        this.q.setStyle(Paint.Style.STROKE);
        this.r = new Paint(1);
        this.r.setColor(this.d);
        this.q.setAntiAlias(true);
        this.r.setTextSize(this.f);
        this.r.setTextAlign(Paint.Align.CENTER);
    }

    private void f() {
        this.u = new RectF(-this.g, -this.g, this.g, this.g);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = g();
        }
        if (mode2 != 1073741824) {
            size2 = g();
        }
        setMeasuredDimension(size, size2);
    }

    private int g() {
        return (int) ((((this.e / 2.0f) + this.g) * 2.0f) + a(4.0f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        b(canvas);
        a(canvas);
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
        canvas.drawText(str, 0.0f, 0.0f - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f), this.r);
        canvas.restore();
    }

    private void b(Canvas canvas) {
        float f;
        canvas.save();
        float a2 = a(this.s, EncoderTextureDrawer.X264_WIDTH);
        if (this.i) {
            f = this.h - a2;
        } else {
            f = this.h;
        }
        canvas.drawCircle(0.0f, 0.0f, this.g, this.p);
        canvas.drawCircle(0.0f, 0.0f, this.g, this.q);
        canvas.drawArc(this.u, f, a2, false, this.o);
        canvas.restore();
    }

    public void a() {
        if (this.w != null && this.w.isRunning()) {
            this.w.cancel();
            this.w = null;
        }
        this.w = new AnimatorSet();
        this.w.playTogether(getNumAnim(), getArcAnim());
        this.w.setInterpolator(new LinearInterpolator());
        this.w.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                TTCountdownView.this.A = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TTCountdownView.this.A) {
                    TTCountdownView.this.A = false;
                } else if (TTCountdownView.this.v != null) {
                    TTCountdownView.this.v.b();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (TTCountdownView.this.v != null) {
                    TTCountdownView.this.v.a();
                }
            }
        });
        this.w.start();
        if (!this.B.get()) {
            c();
        }
    }

    private ValueAnimator getNumAnim() {
        if (this.x != null) {
            this.x.cancel();
            this.x = null;
        }
        this.x = ValueAnimator.ofFloat(this.t, 0.0f);
        this.x.setInterpolator(new LinearInterpolator());
        this.x.setDuration(a(this.t, this.k) * 1000.0f);
        this.x.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TTCountdownView.this.t = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TTCountdownView.this.postInvalidate();
            }
        });
        return this.x;
    }

    private ValueAnimator getArcAnim() {
        if (this.y != null) {
            this.y.cancel();
            this.y = null;
        }
        this.y = ValueAnimator.ofFloat(this.s, 0.0f);
        this.y.setInterpolator(new LinearInterpolator());
        this.y.setDuration(a(this.s, this.j) * 1000.0f);
        this.y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TTCountdownView.this.s = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TTCountdownView.this.postInvalidate();
            }
        });
        return this.y;
    }

    public void b() {
        if (this.w != null) {
            this.w.cancel();
            this.w = null;
        }
        if (this.z != null) {
            this.z.cancel();
            this.z = null;
        }
        if (this.x != null) {
            this.x.cancel();
            this.x = null;
        }
        if (this.y != null) {
            this.y.cancel();
            this.y = null;
        }
        this.s = 1.0f;
        this.t = 1.0f;
        invalidate();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    public float a(float f, float f2) {
        return f * f2;
    }

    public float a(float f, int i) {
        return i * f;
    }

    public void setCountDownTime(int i) {
        float f = i;
        this.k = f;
        this.j = f;
        b();
    }

    private float a(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private float b(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    public a getCountdownListener() {
        return this.v;
    }

    public void setCountdownListener(a aVar) {
        this.v = aVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.B.set(z);
        if (this.v != null) {
            this.v.c();
        }
        if (!this.B.get()) {
            c();
        } else {
            d();
        }
    }

    public void c() {
        try {
            if (this.w != null && Build.VERSION.SDK_INT >= 19) {
                this.w.pause();
            }
        } catch (Throwable th) {
        }
    }

    public void d() {
        try {
            if (this.w != null && Build.VERSION.SDK_INT >= 19) {
                this.w.resume();
            }
        } catch (Throwable th) {
        }
    }
}
