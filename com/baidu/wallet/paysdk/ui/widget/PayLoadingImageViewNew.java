package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes5.dex */
public class PayLoadingImageViewNew extends View {
    public static String TAG = "PayLoadingImageViewNew";

    /* renamed from: a  reason: collision with root package name */
    public PathMeasure f26407a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f26408b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f26409c;

    /* renamed from: d  reason: collision with root package name */
    public Path f26410d;

    /* renamed from: e  reason: collision with root package name */
    public int f26411e;

    /* renamed from: f  reason: collision with root package name */
    public int f26412f;
    public int flag;

    /* renamed from: g  reason: collision with root package name */
    public int f26413g;

    /* renamed from: h  reason: collision with root package name */
    public final RectF f26414h;
    public Path i;
    public Animation j;
    public Handler k;
    public int strokeWidth;

    public PayLoadingImageViewNew(Context context) {
        super(context);
        this.flag = 0;
        this.strokeWidth = 4;
        this.f26414h = new RectF();
        this.i = new Path();
        a();
    }

    public int dip2px(float f2) {
        return (int) ((f2 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.f26413g;
        if (i == 0) {
            return;
        }
        if (this.f26410d == null) {
            float dip2px = (i - dip2px(this.strokeWidth)) / 2.0f;
            RectF rectF = this.f26414h;
            int i2 = this.f26411e;
            rectF.left = i2 - dip2px;
            int i3 = this.f26412f;
            rectF.top = i3 - dip2px;
            rectF.right = i2 + dip2px;
            rectF.bottom = i3 + dip2px;
            Path path = new Path();
            this.f26410d = path;
            path.addArc(this.f26414h, 225.0f, 359.9f);
            this.f26410d.rLineTo(0.0f, 0.0f);
            this.f26407a = new PathMeasure(this.f26410d, false);
        }
        canvas.drawPath(this.i, this.f26408b);
        canvas.save();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredWidth() > getHeight()) {
            this.f26413g = getMeasuredHeight();
        } else {
            this.f26413g = getMeasuredWidth();
        }
        int i3 = this.f26413g;
        this.f26411e = i3 / 2;
        this.f26412f = i3 / 2;
    }

    public void startAnimation() {
        stopAnimation();
        this.flag = 0;
        a(0.0f, 1.0f, 800L);
    }

    public void stopAnimation() {
        clearAnimation();
    }

    private void a() {
        Paint paint = new Paint();
        this.f26408b = paint;
        paint.setAntiAlias(true);
        this.f26408b.setColor(ResUtils.getColor(getContext(), "wallet_fp_main_327de7"));
        this.f26408b.setStrokeWidth(dip2px(this.strokeWidth));
        this.f26408b.setStyle(Paint.Style.STROKE);
        this.f26408b.setStrokeJoin(Paint.Join.ROUND);
        this.f26408b.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.f26409c = paint2;
        paint2.setAntiAlias(true);
        this.f26409c.setColor(-16777216);
        this.f26409c.setStrokeWidth(dip2px(this.strokeWidth));
        this.f26409c.setStyle(Paint.Style.STROKE);
        this.f26409c.setStrokeJoin(Paint.Join.ROUND);
        this.f26409c.setStrokeCap(Paint.Cap.ROUND);
        this.k = new Handler() { // from class: com.baidu.wallet.paysdk.ui.widget.PayLoadingImageViewNew.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                PayLoadingImageViewNew.this.j.start();
                LogUtil.i(PayLoadingImageViewNew.TAG, "restart animation");
            }
        };
    }

    public PayLoadingImageViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.flag = 0;
        this.strokeWidth = 4;
        this.f26414h = new RectF();
        this.i = new Path();
        a();
    }

    public PayLoadingImageViewNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.flag = 0;
        this.strokeWidth = 4;
        this.f26414h = new RectF();
        this.i = new Path();
        a();
    }

    private Animation a(float f2, float f3, long j) {
        Animation animation = new Animation() { // from class: com.baidu.wallet.paysdk.ui.widget.PayLoadingImageViewNew.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float f4, Transformation transformation) {
                PayLoadingImageViewNew payLoadingImageViewNew = PayLoadingImageViewNew.this;
                if (payLoadingImageViewNew.f26407a != null) {
                    payLoadingImageViewNew.i.reset();
                    float length = PayLoadingImageViewNew.this.f26407a.getLength() * f4;
                    PayLoadingImageViewNew payLoadingImageViewNew2 = PayLoadingImageViewNew.this;
                    if (payLoadingImageViewNew2.flag % 2 != 0) {
                        payLoadingImageViewNew2.f26407a.getSegment(0.0f, length, payLoadingImageViewNew2.i, true);
                    } else {
                        PathMeasure pathMeasure = payLoadingImageViewNew2.f26407a;
                        pathMeasure.getSegment(pathMeasure.getLength() - length, PayLoadingImageViewNew.this.f26407a.getLength(), PayLoadingImageViewNew.this.i, true);
                    }
                    String str = PayLoadingImageViewNew.TAG;
                    LogUtil.i(str, "currentLength " + length);
                    PayLoadingImageViewNew.this.i.rLineTo(0.0f, 0.0f);
                }
                PayLoadingImageViewNew.this.invalidate();
            }
        };
        this.j = animation;
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.wallet.paysdk.ui.widget.PayLoadingImageViewNew.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
                PayLoadingImageViewNew.this.flag++;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }
        });
        this.j.setInterpolator(new LinearInterpolator());
        this.j.setDuration(j);
        this.j.setRepeatMode(2);
        this.j.setRepeatCount(-1);
        startAnimation(this.j);
        return this.j;
    }
}
