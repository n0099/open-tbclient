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
    public PathMeasure f26256a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f26257b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f26258c;

    /* renamed from: d  reason: collision with root package name */
    public Path f26259d;

    /* renamed from: e  reason: collision with root package name */
    public int f26260e;

    /* renamed from: f  reason: collision with root package name */
    public int f26261f;
    public int flag;

    /* renamed from: g  reason: collision with root package name */
    public int f26262g;

    /* renamed from: h  reason: collision with root package name */
    public final RectF f26263h;

    /* renamed from: i  reason: collision with root package name */
    public Path f26264i;
    public Animation j;
    public Handler k;
    public int strokeWidth;

    public PayLoadingImageViewNew(Context context) {
        super(context);
        this.flag = 0;
        this.strokeWidth = 4;
        this.f26263h = new RectF();
        this.f26264i = new Path();
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
        int i2 = this.f26262g;
        if (i2 == 0) {
            return;
        }
        if (this.f26259d == null) {
            float dip2px = (i2 - dip2px(this.strokeWidth)) / 2.0f;
            RectF rectF = this.f26263h;
            int i3 = this.f26260e;
            rectF.left = i3 - dip2px;
            int i4 = this.f26261f;
            rectF.top = i4 - dip2px;
            rectF.right = i3 + dip2px;
            rectF.bottom = i4 + dip2px;
            Path path = new Path();
            this.f26259d = path;
            path.addArc(this.f26263h, 225.0f, 359.9f);
            this.f26259d.rLineTo(0.0f, 0.0f);
            this.f26256a = new PathMeasure(this.f26259d, false);
        }
        canvas.drawPath(this.f26264i, this.f26257b);
        canvas.save();
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (getMeasuredWidth() > getHeight()) {
            this.f26262g = getMeasuredHeight();
        } else {
            this.f26262g = getMeasuredWidth();
        }
        int i4 = this.f26262g;
        this.f26260e = i4 / 2;
        this.f26261f = i4 / 2;
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
        this.f26257b = paint;
        paint.setAntiAlias(true);
        this.f26257b.setColor(ResUtils.getColor(getContext(), "wallet_fp_main_327de7"));
        this.f26257b.setStrokeWidth(dip2px(this.strokeWidth));
        this.f26257b.setStyle(Paint.Style.STROKE);
        this.f26257b.setStrokeJoin(Paint.Join.ROUND);
        this.f26257b.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.f26258c = paint2;
        paint2.setAntiAlias(true);
        this.f26258c.setColor(-16777216);
        this.f26258c.setStrokeWidth(dip2px(this.strokeWidth));
        this.f26258c.setStyle(Paint.Style.STROKE);
        this.f26258c.setStrokeJoin(Paint.Join.ROUND);
        this.f26258c.setStrokeCap(Paint.Cap.ROUND);
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
        this.f26263h = new RectF();
        this.f26264i = new Path();
        a();
    }

    public PayLoadingImageViewNew(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.flag = 0;
        this.strokeWidth = 4;
        this.f26263h = new RectF();
        this.f26264i = new Path();
        a();
    }

    private Animation a(float f2, float f3, long j) {
        Animation animation = new Animation() { // from class: com.baidu.wallet.paysdk.ui.widget.PayLoadingImageViewNew.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float f4, Transformation transformation) {
                PayLoadingImageViewNew payLoadingImageViewNew = PayLoadingImageViewNew.this;
                if (payLoadingImageViewNew.f26256a != null) {
                    payLoadingImageViewNew.f26264i.reset();
                    float length = PayLoadingImageViewNew.this.f26256a.getLength() * f4;
                    PayLoadingImageViewNew payLoadingImageViewNew2 = PayLoadingImageViewNew.this;
                    if (payLoadingImageViewNew2.flag % 2 != 0) {
                        payLoadingImageViewNew2.f26256a.getSegment(0.0f, length, payLoadingImageViewNew2.f26264i, true);
                    } else {
                        PathMeasure pathMeasure = payLoadingImageViewNew2.f26256a;
                        pathMeasure.getSegment(pathMeasure.getLength() - length, PayLoadingImageViewNew.this.f26256a.getLength(), PayLoadingImageViewNew.this.f26264i, true);
                    }
                    String str = PayLoadingImageViewNew.TAG;
                    LogUtil.i(str, "currentLength " + length);
                    PayLoadingImageViewNew.this.f26264i.rLineTo(0.0f, 0.0f);
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
