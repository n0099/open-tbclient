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
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class VideoLoadingProgressView extends View {
    private int chc;
    private float gHk;
    private int gHl;
    private float gHm;
    private int gHn;
    private float gHo;
    private int gHp;
    private int gHq;
    private float gHr;
    private float gHs;
    private int gHt;
    private a gHu;
    private ValueAnimator gHv;
    private ValueAnimator gHw;
    private ValueAnimator gHx;
    private ValueAnimator.AnimatorUpdateListener gHy;
    private AnimatorListenerAdapter gHz;
    private Paint mPaint;
    private RectF mRect;
    private float mStartAngle;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.gHk = 7200.0f;
        this.gHl = 10000;
        this.gHm = 30.0f;
        this.gHn = 50;
        this.gHo = 300.0f;
        this.gHp = 400;
        this.mStartAngle = -90.0f;
        this.gHr = this.mStartAngle;
        this.gHs = 60.0f;
        this.gHy = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gHt != 1 && VideoLoadingProgressView.this.gHt != 2) {
                    if (VideoLoadingProgressView.this.gHt == 3) {
                        VideoLoadingProgressView.this.gHs = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gHr = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gHs = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gHz = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gHt == 2) {
                    VideoLoadingProgressView.this.bsM();
                } else if (VideoLoadingProgressView.this.gHt == 3 && VideoLoadingProgressView.this.gHu != null) {
                    VideoLoadingProgressView.this.gHu.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gHk = 7200.0f;
        this.gHl = 10000;
        this.gHm = 30.0f;
        this.gHn = 50;
        this.gHo = 300.0f;
        this.gHp = 400;
        this.mStartAngle = -90.0f;
        this.gHr = this.mStartAngle;
        this.gHs = 60.0f;
        this.gHy = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gHt != 1 && VideoLoadingProgressView.this.gHt != 2) {
                    if (VideoLoadingProgressView.this.gHt == 3) {
                        VideoLoadingProgressView.this.gHs = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gHr = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gHs = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gHz = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gHt == 2) {
                    VideoLoadingProgressView.this.bsM();
                } else if (VideoLoadingProgressView.this.gHt == 3 && VideoLoadingProgressView.this.gHu != null) {
                    VideoLoadingProgressView.this.gHu.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gHk = 7200.0f;
        this.gHl = 10000;
        this.gHm = 30.0f;
        this.gHn = 50;
        this.gHo = 300.0f;
        this.gHp = 400;
        this.mStartAngle = -90.0f;
        this.gHr = this.mStartAngle;
        this.gHs = 60.0f;
        this.gHy = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gHt != 1 && VideoLoadingProgressView.this.gHt != 2) {
                    if (VideoLoadingProgressView.this.gHt == 3) {
                        VideoLoadingProgressView.this.gHs = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gHr = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gHs = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gHz = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gHt == 2) {
                    VideoLoadingProgressView.this.bsM();
                } else if (VideoLoadingProgressView.this.gHt == 3 && VideoLoadingProgressView.this.gHu != null) {
                    VideoLoadingProgressView.this.gHu.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.chc = getContext().getResources().getColor(e.d.cp_cont_i);
        this.gHq = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds2);
        this.mPaint.setColor(this.chc);
        this.mPaint.setStrokeWidth(this.gHq);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bsN();
        this.gHt = 1;
        this.gHr = -90.0f;
        this.mStartAngle = -90.0f;
        this.gHv = ValueAnimator.ofFloat(this.gHk);
        this.gHv.setDuration(this.gHl);
        this.gHv.addListener(this.gHz);
        this.gHv.addUpdateListener(this.gHy);
        this.gHv.start();
        setVisibility(0);
        invalidate();
    }

    public void bsI() {
        bsN();
        this.gHt = 2;
        this.mStartAngle = this.gHr;
        this.gHw = ValueAnimator.ofFloat(-this.gHm);
        this.gHw.setDuration(this.gHn);
        this.gHw.addListener(this.gHz);
        this.gHw.addUpdateListener(this.gHy);
        this.gHw.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsM() {
        bsN();
        this.gHt = 3;
        this.mStartAngle = this.gHr;
        this.gHx = ValueAnimator.ofFloat(this.gHo);
        this.gHx.setDuration(this.gHp);
        this.gHx.addListener(this.gHz);
        this.gHx.addUpdateListener(this.gHy);
        this.gHx.start();
    }

    public void bsK() {
        bsN();
        setVisibility(8);
    }

    private void bsN() {
        if (this.gHv != null) {
            this.gHv.cancel();
        }
        if (this.gHw != null) {
            this.gHw.cancel();
        }
        if (this.gHx != null) {
            this.gHx.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.gHu = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bsN();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.gHr, this.gHs, false, this.mPaint);
    }
}
