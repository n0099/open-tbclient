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
/* loaded from: classes.dex */
public class VideoLoadingProgressView extends View {
    private RectF WP;
    private float bgQ;
    private int dcY;
    private int eWP;
    private float jxY;
    private int jxZ;
    private float jya;
    private int jyb;
    private float jyc;
    private int jyd;
    private float jye;
    private float jyf;
    private int jyg;
    private a jyh;
    private ValueAnimator jyi;
    private ValueAnimator jyj;
    private ValueAnimator jyk;
    private ValueAnimator.AnimatorUpdateListener jyl;
    private AnimatorListenerAdapter jym;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.jxY = 7200.0f;
        this.jxZ = 10000;
        this.jya = 30.0f;
        this.jyb = 50;
        this.jyc = 300.0f;
        this.jyd = 400;
        this.bgQ = -90.0f;
        this.jye = this.bgQ;
        this.jyf = 60.0f;
        this.jyl = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jyg != 1 && VideoLoadingProgressView.this.jyg != 2) {
                    if (VideoLoadingProgressView.this.jyg == 3) {
                        VideoLoadingProgressView.this.jyf = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jye = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bgQ;
                    VideoLoadingProgressView.this.jyf = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jym = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jyg == 2) {
                    VideoLoadingProgressView.this.czK();
                } else if (VideoLoadingProgressView.this.jyg == 3 && VideoLoadingProgressView.this.jyh != null) {
                    VideoLoadingProgressView.this.jyh.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jxY = 7200.0f;
        this.jxZ = 10000;
        this.jya = 30.0f;
        this.jyb = 50;
        this.jyc = 300.0f;
        this.jyd = 400;
        this.bgQ = -90.0f;
        this.jye = this.bgQ;
        this.jyf = 60.0f;
        this.jyl = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jyg != 1 && VideoLoadingProgressView.this.jyg != 2) {
                    if (VideoLoadingProgressView.this.jyg == 3) {
                        VideoLoadingProgressView.this.jyf = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jye = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bgQ;
                    VideoLoadingProgressView.this.jyf = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jym = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jyg == 2) {
                    VideoLoadingProgressView.this.czK();
                } else if (VideoLoadingProgressView.this.jyg == 3 && VideoLoadingProgressView.this.jyh != null) {
                    VideoLoadingProgressView.this.jyh.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jxY = 7200.0f;
        this.jxZ = 10000;
        this.jya = 30.0f;
        this.jyb = 50;
        this.jyc = 300.0f;
        this.jyd = 400;
        this.bgQ = -90.0f;
        this.jye = this.bgQ;
        this.jyf = 60.0f;
        this.jyl = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jyg != 1 && VideoLoadingProgressView.this.jyg != 2) {
                    if (VideoLoadingProgressView.this.jyg == 3) {
                        VideoLoadingProgressView.this.jyf = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jye = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bgQ;
                    VideoLoadingProgressView.this.jyf = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jym = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jyg == 2) {
                    VideoLoadingProgressView.this.czK();
                } else if (VideoLoadingProgressView.this.jyg == 3 && VideoLoadingProgressView.this.jyh != null) {
                    VideoLoadingProgressView.this.jyh.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.WP = new RectF();
        this.mPaint = new Paint(1);
        this.eWP = getContext().getResources().getColor(R.color.cp_cont_a);
        this.dcY = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.eWP);
        this.mPaint.setStrokeWidth(this.dcY);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        czL();
        this.jyg = 1;
        this.jye = -90.0f;
        this.bgQ = -90.0f;
        this.jyi = ValueAnimator.ofFloat(this.jxY);
        this.jyi.setDuration(this.jxZ);
        this.jyi.addListener(this.jym);
        this.jyi.addUpdateListener(this.jyl);
        this.jyi.start();
        setVisibility(0);
        invalidate();
    }

    public void czH() {
        czL();
        this.jyg = 2;
        this.bgQ = this.jye;
        this.jyj = ValueAnimator.ofFloat(-this.jya);
        this.jyj.setDuration(this.jyb);
        this.jyj.addListener(this.jym);
        this.jyj.addUpdateListener(this.jyl);
        this.jyj.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czK() {
        czL();
        this.jyg = 3;
        this.bgQ = this.jye;
        this.jyk = ValueAnimator.ofFloat(this.jyc);
        this.jyk.setDuration(this.jyd);
        this.jyk.addListener(this.jym);
        this.jyk.addUpdateListener(this.jyl);
        this.jyk.start();
    }

    public void czJ() {
        czL();
        setVisibility(8);
    }

    private void czL() {
        if (this.jyi != null) {
            this.jyi.cancel();
        }
        if (this.jyj != null) {
            this.jyj.cancel();
        }
        if (this.jyk != null) {
            this.jyk.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.jyh = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        czL();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.WP.left = 1;
        this.WP.top = 1;
        this.WP.right = getWidth() - 1;
        this.WP.bottom = getHeight() - 1;
        canvas.drawArc(this.WP, this.jye, this.jyf, false, this.mPaint);
    }
}
