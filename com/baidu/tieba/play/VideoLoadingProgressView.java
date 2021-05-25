package com.baidu.tieba.play;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class VideoLoadingProgressView extends View {

    /* renamed from: e  reason: collision with root package name */
    public float f19941e;

    /* renamed from: f  reason: collision with root package name */
    public int f19942f;

    /* renamed from: g  reason: collision with root package name */
    public float f19943g;

    /* renamed from: h  reason: collision with root package name */
    public int f19944h;

    /* renamed from: i  reason: collision with root package name */
    public float f19945i;
    public int j;
    public RectF k;
    public Paint l;
    public int m;
    public int n;
    public float o;
    public float p;
    public float q;
    public int r;
    public c s;
    public ValueAnimator t;
    public ValueAnimator u;
    public ValueAnimator v;
    public ValueAnimator.AnimatorUpdateListener w;
    public AnimatorListenerAdapter x;

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (VideoLoadingProgressView.this.r != 1 && VideoLoadingProgressView.this.r != 2) {
                if (VideoLoadingProgressView.this.r == 3) {
                    VideoLoadingProgressView.this.q = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                }
            } else {
                VideoLoadingProgressView videoLoadingProgressView = VideoLoadingProgressView.this;
                videoLoadingProgressView.p = videoLoadingProgressView.o + ((Float) valueAnimator.getAnimatedValue()).floatValue();
                VideoLoadingProgressView.this.q = 60.0f;
            }
            VideoLoadingProgressView.this.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (VideoLoadingProgressView.this.r == 2) {
                VideoLoadingProgressView.this.k();
            } else if (VideoLoadingProgressView.this.r != 3 || VideoLoadingProgressView.this.s == null) {
            } else {
                VideoLoadingProgressView.this.s.onAnimationEnd();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.f19941e = 7200.0f;
        this.f19942f = 10000;
        this.f19943g = 30.0f;
        this.f19944h = 50;
        this.f19945i = 300.0f;
        this.j = 400;
        this.o = -90.0f;
        this.p = -90.0f;
        this.q = 60.0f;
        this.w = new a();
        this.x = new b();
        i();
    }

    public final void g() {
        ValueAnimator valueAnimator = this.t;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.u;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator valueAnimator3 = this.v;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
    }

    public void h() {
        g();
        setVisibility(8);
    }

    public final void i() {
        this.k = new RectF();
        this.l = new Paint(1);
        this.m = getContext().getResources().getColor(R.color.CAM_X0101);
        this.n = l.g(getContext(), R.dimen.ds2);
        this.l.setColor(this.m);
        this.l.setStrokeWidth(this.n);
        this.l.setStyle(Paint.Style.STROKE);
        this.l.setStrokeCap(Paint.Cap.ROUND);
    }

    public void j() {
        g();
        this.r = 2;
        this.o = this.p;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(-this.f19943g);
        this.u = ofFloat;
        ofFloat.setDuration(this.f19944h);
        this.u.addListener(this.x);
        this.u.addUpdateListener(this.w);
        this.u.start();
    }

    public final void k() {
        g();
        this.r = 3;
        this.o = this.p;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f19945i);
        this.v = ofFloat;
        ofFloat.setDuration(this.j);
        this.v.addListener(this.x);
        this.v.addUpdateListener(this.w);
        this.v.start();
    }

    public void l() {
        g();
        this.r = 1;
        this.p = -90.0f;
        this.o = -90.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f19941e);
        this.t = ofFloat;
        ofFloat.setDuration(this.f19942f);
        this.t.addListener(this.x);
        this.t.addUpdateListener(this.w);
        this.t.start();
        setVisibility(0);
        invalidate();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.k;
        float f2 = 1;
        rectF.left = f2;
        rectF.top = f2;
        rectF.right = getWidth() - 1;
        this.k.bottom = getHeight() - 1;
        canvas.drawArc(this.k, this.p, this.q, false, this.l);
    }

    public void setLoadingAnimationListener(c cVar) {
        this.s = cVar;
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19941e = 7200.0f;
        this.f19942f = 10000;
        this.f19943g = 30.0f;
        this.f19944h = 50;
        this.f19945i = 300.0f;
        this.j = 400;
        this.o = -90.0f;
        this.p = -90.0f;
        this.q = 60.0f;
        this.w = new a();
        this.x = new b();
        i();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19941e = 7200.0f;
        this.f19942f = 10000;
        this.f19943g = 30.0f;
        this.f19944h = 50;
        this.f19945i = 300.0f;
        this.j = 400;
        this.o = -90.0f;
        this.p = -90.0f;
        this.q = 60.0f;
        this.w = new a();
        this.x = new b();
        i();
    }
}
