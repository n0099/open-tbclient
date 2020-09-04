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
    private RectF aCc;
    private float bZq;
    private int enA;
    private int gsN;
    private float lsU;
    private int lsV;
    private float lsW;
    private int lsX;
    private float lsY;
    private int lsZ;
    private float lta;
    private float ltb;
    private int ltc;
    private a ltd;
    private ValueAnimator lte;
    private ValueAnimator ltf;
    private ValueAnimator ltg;
    private ValueAnimator.AnimatorUpdateListener lth;
    private AnimatorListenerAdapter lti;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.lsU = 7200.0f;
        this.lsV = 10000;
        this.lsW = 30.0f;
        this.lsX = 50;
        this.lsY = 300.0f;
        this.lsZ = 400;
        this.bZq = -90.0f;
        this.lta = this.bZq;
        this.ltb = 60.0f;
        this.lth = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.ltc != 1 && VideoLoadingProgressView.this.ltc != 2) {
                    if (VideoLoadingProgressView.this.ltc == 3) {
                        VideoLoadingProgressView.this.ltb = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.lta = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bZq;
                    VideoLoadingProgressView.this.ltb = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.lti = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.ltc == 2) {
                    VideoLoadingProgressView.this.dke();
                } else if (VideoLoadingProgressView.this.ltc == 3 && VideoLoadingProgressView.this.ltd != null) {
                    VideoLoadingProgressView.this.ltd.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lsU = 7200.0f;
        this.lsV = 10000;
        this.lsW = 30.0f;
        this.lsX = 50;
        this.lsY = 300.0f;
        this.lsZ = 400;
        this.bZq = -90.0f;
        this.lta = this.bZq;
        this.ltb = 60.0f;
        this.lth = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.ltc != 1 && VideoLoadingProgressView.this.ltc != 2) {
                    if (VideoLoadingProgressView.this.ltc == 3) {
                        VideoLoadingProgressView.this.ltb = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.lta = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bZq;
                    VideoLoadingProgressView.this.ltb = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.lti = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.ltc == 2) {
                    VideoLoadingProgressView.this.dke();
                } else if (VideoLoadingProgressView.this.ltc == 3 && VideoLoadingProgressView.this.ltd != null) {
                    VideoLoadingProgressView.this.ltd.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lsU = 7200.0f;
        this.lsV = 10000;
        this.lsW = 30.0f;
        this.lsX = 50;
        this.lsY = 300.0f;
        this.lsZ = 400;
        this.bZq = -90.0f;
        this.lta = this.bZq;
        this.ltb = 60.0f;
        this.lth = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.ltc != 1 && VideoLoadingProgressView.this.ltc != 2) {
                    if (VideoLoadingProgressView.this.ltc == 3) {
                        VideoLoadingProgressView.this.ltb = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.lta = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bZq;
                    VideoLoadingProgressView.this.ltb = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.lti = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.ltc == 2) {
                    VideoLoadingProgressView.this.dke();
                } else if (VideoLoadingProgressView.this.ltc == 3 && VideoLoadingProgressView.this.ltd != null) {
                    VideoLoadingProgressView.this.ltd.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.aCc = new RectF();
        this.mPaint = new Paint(1);
        this.gsN = getContext().getResources().getColor(R.color.cp_cont_a);
        this.enA = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.gsN);
        this.mPaint.setStrokeWidth(this.enA);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        dkf();
        this.ltc = 1;
        this.lta = -90.0f;
        this.bZq = -90.0f;
        this.lte = ValueAnimator.ofFloat(this.lsU);
        this.lte.setDuration(this.lsV);
        this.lte.addListener(this.lti);
        this.lte.addUpdateListener(this.lth);
        this.lte.start();
        setVisibility(0);
        invalidate();
    }

    public void dkb() {
        dkf();
        this.ltc = 2;
        this.bZq = this.lta;
        this.ltf = ValueAnimator.ofFloat(-this.lsW);
        this.ltf.setDuration(this.lsX);
        this.ltf.addListener(this.lti);
        this.ltf.addUpdateListener(this.lth);
        this.ltf.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dke() {
        dkf();
        this.ltc = 3;
        this.bZq = this.lta;
        this.ltg = ValueAnimator.ofFloat(this.lsY);
        this.ltg.setDuration(this.lsZ);
        this.ltg.addListener(this.lti);
        this.ltg.addUpdateListener(this.lth);
        this.ltg.start();
    }

    public void dkd() {
        dkf();
        setVisibility(8);
    }

    private void dkf() {
        if (this.lte != null) {
            this.lte.cancel();
        }
        if (this.ltf != null) {
            this.ltf.cancel();
        }
        if (this.ltg != null) {
            this.ltg.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.ltd = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dkf();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.aCc.left = 1;
        this.aCc.top = 1;
        this.aCc.right = getWidth() - 1;
        this.aCc.bottom = getHeight() - 1;
        canvas.drawArc(this.aCc, this.lta, this.ltb, false, this.mPaint);
    }
}
