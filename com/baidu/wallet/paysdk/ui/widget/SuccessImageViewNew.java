package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes5.dex */
public class SuccessImageViewNew extends View {
    public static int ALLDegree = 359;
    public static int StatD = 310;
    public static String TAG = "SuccessImageViewNew";

    /* renamed from: a  reason: collision with root package name */
    public PathMeasure f26207a;

    /* renamed from: b  reason: collision with root package name */
    public PathMeasure f26208b;

    /* renamed from: c  reason: collision with root package name */
    public Animation f26209c;

    /* renamed from: d  reason: collision with root package name */
    public Animation f26210d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f26211e;

    /* renamed from: f  reason: collision with root package name */
    public float f26212f;

    /* renamed from: g  reason: collision with root package name */
    public float f26213g;

    /* renamed from: h  reason: collision with root package name */
    public float f26214h;

    /* renamed from: i  reason: collision with root package name */
    public float f26215i;
    public final RectF j;
    public Path k;
    public Path l;
    public Path m;
    public int n;
    public int o;
    public a p;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public SuccessImageViewNew(Context context) {
        super(context);
        this.f26207a = new PathMeasure();
        this.f26208b = new PathMeasure();
        this.j = new RectF();
        this.k = new Path();
        this.n = 0;
        this.o = StatD / ALLDegree;
        this.p = null;
        a();
    }

    public int dip2px(float f2) {
        return (int) ((f2 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Path path;
        super.onDraw(canvas);
        if (this.f26214h == 0.0f) {
            return;
        }
        if (this.n == 1 && (path = this.m) != null) {
            canvas.drawPath(path, this.f26211e);
        }
        canvas.drawPath(this.k, this.f26211e);
        canvas.save();
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (getMeasuredWidth() > getMeasuredHeight()) {
            this.f26214h = getMeasuredHeight();
        } else {
            this.f26214h = getMeasuredWidth();
        }
        float f2 = this.f26214h;
        this.f26212f = f2 / 2.0f;
        this.f26213g = f2 / 2.0f;
        this.f26215i = (f2 - dip2px(4.0f)) / 2.0f;
        b();
    }

    public void startAnimation(a aVar) {
        stopAnim();
        this.p = aVar;
        a(0.0f, 1.0f, 250L);
    }

    public void stopAnim() {
        clearAnimation();
    }

    private void b() {
        if (this.f26214h == 0.0f) {
            return;
        }
        if (this.l == null) {
            RectF rectF = this.j;
            float f2 = this.f26212f;
            float f3 = this.f26215i;
            rectF.left = f2 - f3;
            float f4 = this.f26213g;
            rectF.top = f4 - f3;
            rectF.right = f2 + f3;
            rectF.bottom = f4 + f3;
            Path path = new Path();
            this.l = path;
            path.addArc(this.j, 0.0f, 320.0f);
            this.l.rLineTo(0.0f, 0.0f);
            this.f26208b = new PathMeasure(this.l, false);
        }
        if (this.m == null) {
            PathMeasure pathMeasure = new PathMeasure(this.l, true);
            String str = TAG;
            LogUtil.i(str, "path1 len" + pathMeasure.getLength());
            float[] fArr = new float[2];
            pathMeasure.getPosTan((pathMeasure.getLength() * 320.0f) / 359.0f, fArr, null);
            String str2 = TAG;
            LogUtil.i(str2, "path1 pos" + fArr[0] + GlideException.IndentedAppendable.INDENT + fArr[1]);
            Path path2 = new Path();
            this.m = path2;
            float f5 = (this.f26215i * 3.0f) / 7.0f;
            path2.moveTo(this.f26212f - f5, this.f26213g - ((2.0f * f5) / 5.0f));
            this.m.lineTo(this.f26212f, this.f26213g + ((f5 * 3.0f) / 5.0f));
            this.m.rMoveTo(0.0f, 0.0f);
            this.m.lineTo(fArr[0], fArr[1]);
            this.f26207a = new PathMeasure(this.m, false);
        }
    }

    private void a() {
        Paint paint = new Paint();
        this.f26211e = paint;
        paint.setAntiAlias(true);
        this.f26211e.setColor(ResUtils.getColor(getContext(), "wallet_fp_main_327de7"));
        this.f26211e.setStrokeWidth(dip2px(4.0f));
        this.f26211e.setStyle(Paint.Style.STROKE);
        this.f26211e.setStrokeJoin(Paint.Join.ROUND);
        this.f26211e.setStrokeCap(Paint.Cap.ROUND);
    }

    public SuccessImageViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26207a = new PathMeasure();
        this.f26208b = new PathMeasure();
        this.j = new RectF();
        this.k = new Path();
        this.n = 0;
        this.o = StatD / ALLDegree;
        this.p = null;
        a();
    }

    private void a(float f2, float f3, final long j) {
        Animation animation = new Animation() { // from class: com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew.1
            @Override // android.view.animation.Animation
            public void applyTransformation(float f4, Transformation transformation) {
                SuccessImageViewNew successImageViewNew = SuccessImageViewNew.this;
                if (successImageViewNew.f26209c != null) {
                    successImageViewNew.k.reset();
                    float length = SuccessImageViewNew.this.f26207a.getLength();
                    float f5 = f4 * length;
                    SuccessImageViewNew successImageViewNew2 = SuccessImageViewNew.this;
                    successImageViewNew2.f26207a.getSegment(0.0f, f5, successImageViewNew2.k, true);
                    String str = SuccessImageViewNew.TAG;
                    LogUtil.i(str, "length " + length + "currentLength " + f5);
                    SuccessImageViewNew.this.k.rLineTo(0.0f, 0.0f);
                }
                SuccessImageViewNew.this.invalidate();
            }
        };
        this.f26209c = animation;
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                SuccessImageViewNew.this.n = 1;
                SuccessImageViewNew.this.b(0.0f, 1.0f, j);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }
        });
        this.f26209c.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f26209c.setDuration(j);
        this.f26209c.setRepeatCount(0);
        startAnimation(this.f26209c);
    }

    public SuccessImageViewNew(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f26207a = new PathMeasure();
        this.f26208b = new PathMeasure();
        this.j = new RectF();
        this.k = new Path();
        this.n = 0;
        this.o = StatD / ALLDegree;
        this.p = null;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, float f3, long j) {
        Animation animation = new Animation() { // from class: com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew.3
            @Override // android.view.animation.Animation
            public void applyTransformation(float f4, Transformation transformation) {
                SuccessImageViewNew successImageViewNew = SuccessImageViewNew.this;
                if (successImageViewNew.f26210d != null) {
                    successImageViewNew.k.reset();
                    float length = SuccessImageViewNew.this.f26208b.getLength();
                    float f5 = f4 * length;
                    SuccessImageViewNew successImageViewNew2 = SuccessImageViewNew.this;
                    successImageViewNew2.f26208b.getSegment(length - f5, length, successImageViewNew2.k, true);
                    String str = SuccessImageViewNew.TAG;
                    LogUtil.i(str, "length " + length + "currentLengthCircle " + f5);
                    SuccessImageViewNew.this.k.rLineTo(0.0f, 0.0f);
                }
                SuccessImageViewNew.this.invalidate();
            }
        };
        this.f26210d = animation;
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                if (SuccessImageViewNew.this.p != null) {
                    SuccessImageViewNew.this.p.a();
                    SuccessImageViewNew.this.p = null;
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }
        });
        this.f26210d.setInterpolator(new LinearInterpolator());
        this.f26210d.setDuration(j);
        this.f26210d.setRepeatCount(0);
        startAnimation(this.f26210d);
    }
}
