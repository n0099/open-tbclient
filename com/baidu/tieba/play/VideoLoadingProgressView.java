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
    private RectF atR;
    private float bNY;
    private int dQJ;
    private int fPl;
    private int kAa;
    private a kAb;
    private ValueAnimator kAc;
    private ValueAnimator kAd;
    private ValueAnimator kAe;
    private ValueAnimator.AnimatorUpdateListener kAf;
    private AnimatorListenerAdapter kAg;
    private float kzS;
    private int kzT;
    private float kzU;
    private int kzV;
    private float kzW;
    private int kzX;
    private float kzY;
    private float kzZ;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.kzS = 7200.0f;
        this.kzT = 10000;
        this.kzU = 30.0f;
        this.kzV = 50;
        this.kzW = 300.0f;
        this.kzX = 400;
        this.bNY = -90.0f;
        this.kzY = this.bNY;
        this.kzZ = 60.0f;
        this.kAf = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.kAa != 1 && VideoLoadingProgressView.this.kAa != 2) {
                    if (VideoLoadingProgressView.this.kAa == 3) {
                        VideoLoadingProgressView.this.kzZ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.kzY = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bNY;
                    VideoLoadingProgressView.this.kzZ = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.kAg = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.kAa == 2) {
                    VideoLoadingProgressView.this.cRm();
                } else if (VideoLoadingProgressView.this.kAa == 3 && VideoLoadingProgressView.this.kAb != null) {
                    VideoLoadingProgressView.this.kAb.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kzS = 7200.0f;
        this.kzT = 10000;
        this.kzU = 30.0f;
        this.kzV = 50;
        this.kzW = 300.0f;
        this.kzX = 400;
        this.bNY = -90.0f;
        this.kzY = this.bNY;
        this.kzZ = 60.0f;
        this.kAf = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.kAa != 1 && VideoLoadingProgressView.this.kAa != 2) {
                    if (VideoLoadingProgressView.this.kAa == 3) {
                        VideoLoadingProgressView.this.kzZ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.kzY = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bNY;
                    VideoLoadingProgressView.this.kzZ = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.kAg = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.kAa == 2) {
                    VideoLoadingProgressView.this.cRm();
                } else if (VideoLoadingProgressView.this.kAa == 3 && VideoLoadingProgressView.this.kAb != null) {
                    VideoLoadingProgressView.this.kAb.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kzS = 7200.0f;
        this.kzT = 10000;
        this.kzU = 30.0f;
        this.kzV = 50;
        this.kzW = 300.0f;
        this.kzX = 400;
        this.bNY = -90.0f;
        this.kzY = this.bNY;
        this.kzZ = 60.0f;
        this.kAf = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.kAa != 1 && VideoLoadingProgressView.this.kAa != 2) {
                    if (VideoLoadingProgressView.this.kAa == 3) {
                        VideoLoadingProgressView.this.kzZ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.kzY = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bNY;
                    VideoLoadingProgressView.this.kzZ = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.kAg = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.kAa == 2) {
                    VideoLoadingProgressView.this.cRm();
                } else if (VideoLoadingProgressView.this.kAa == 3 && VideoLoadingProgressView.this.kAb != null) {
                    VideoLoadingProgressView.this.kAb.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.atR = new RectF();
        this.mPaint = new Paint(1);
        this.fPl = getContext().getResources().getColor(R.color.cp_cont_a);
        this.dQJ = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.fPl);
        this.mPaint.setStrokeWidth(this.dQJ);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        cRn();
        this.kAa = 1;
        this.kzY = -90.0f;
        this.bNY = -90.0f;
        this.kAc = ValueAnimator.ofFloat(this.kzS);
        this.kAc.setDuration(this.kzT);
        this.kAc.addListener(this.kAg);
        this.kAc.addUpdateListener(this.kAf);
        this.kAc.start();
        setVisibility(0);
        invalidate();
    }

    public void cRj() {
        cRn();
        this.kAa = 2;
        this.bNY = this.kzY;
        this.kAd = ValueAnimator.ofFloat(-this.kzU);
        this.kAd.setDuration(this.kzV);
        this.kAd.addListener(this.kAg);
        this.kAd.addUpdateListener(this.kAf);
        this.kAd.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRm() {
        cRn();
        this.kAa = 3;
        this.bNY = this.kzY;
        this.kAe = ValueAnimator.ofFloat(this.kzW);
        this.kAe.setDuration(this.kzX);
        this.kAe.addListener(this.kAg);
        this.kAe.addUpdateListener(this.kAf);
        this.kAe.start();
    }

    public void cRl() {
        cRn();
        setVisibility(8);
    }

    private void cRn() {
        if (this.kAc != null) {
            this.kAc.cancel();
        }
        if (this.kAd != null) {
            this.kAd.cancel();
        }
        if (this.kAe != null) {
            this.kAe.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.kAb = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cRn();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.atR.left = 1;
        this.atR.top = 1;
        this.atR.right = getWidth() - 1;
        this.atR.bottom = getHeight() - 1;
        canvas.drawArc(this.atR, this.kzY, this.kzZ, false, this.mPaint);
    }
}
