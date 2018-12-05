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
    private int cgV;
    private float gEA;
    private float gEB;
    private int gEC;
    private a gED;
    private ValueAnimator gEE;
    private ValueAnimator gEF;
    private ValueAnimator gEG;
    private ValueAnimator.AnimatorUpdateListener gEH;
    private AnimatorListenerAdapter gEI;
    private float gEt;
    private int gEu;
    private float gEv;
    private int gEw;
    private float gEx;
    private int gEy;
    private int gEz;
    private Paint mPaint;
    private RectF mRect;
    private float mStartAngle;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.gEt = 7200.0f;
        this.gEu = 10000;
        this.gEv = 30.0f;
        this.gEw = 50;
        this.gEx = 300.0f;
        this.gEy = 400;
        this.mStartAngle = -90.0f;
        this.gEA = this.mStartAngle;
        this.gEB = 60.0f;
        this.gEH = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gEC != 1 && VideoLoadingProgressView.this.gEC != 2) {
                    if (VideoLoadingProgressView.this.gEC == 3) {
                        VideoLoadingProgressView.this.gEB = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gEA = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gEB = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gEI = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gEC == 2) {
                    VideoLoadingProgressView.this.bsb();
                } else if (VideoLoadingProgressView.this.gEC == 3 && VideoLoadingProgressView.this.gED != null) {
                    VideoLoadingProgressView.this.gED.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gEt = 7200.0f;
        this.gEu = 10000;
        this.gEv = 30.0f;
        this.gEw = 50;
        this.gEx = 300.0f;
        this.gEy = 400;
        this.mStartAngle = -90.0f;
        this.gEA = this.mStartAngle;
        this.gEB = 60.0f;
        this.gEH = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gEC != 1 && VideoLoadingProgressView.this.gEC != 2) {
                    if (VideoLoadingProgressView.this.gEC == 3) {
                        VideoLoadingProgressView.this.gEB = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gEA = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gEB = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gEI = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gEC == 2) {
                    VideoLoadingProgressView.this.bsb();
                } else if (VideoLoadingProgressView.this.gEC == 3 && VideoLoadingProgressView.this.gED != null) {
                    VideoLoadingProgressView.this.gED.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gEt = 7200.0f;
        this.gEu = 10000;
        this.gEv = 30.0f;
        this.gEw = 50;
        this.gEx = 300.0f;
        this.gEy = 400;
        this.mStartAngle = -90.0f;
        this.gEA = this.mStartAngle;
        this.gEB = 60.0f;
        this.gEH = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gEC != 1 && VideoLoadingProgressView.this.gEC != 2) {
                    if (VideoLoadingProgressView.this.gEC == 3) {
                        VideoLoadingProgressView.this.gEB = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gEA = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gEB = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gEI = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gEC == 2) {
                    VideoLoadingProgressView.this.bsb();
                } else if (VideoLoadingProgressView.this.gEC == 3 && VideoLoadingProgressView.this.gED != null) {
                    VideoLoadingProgressView.this.gED.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.cgV = getContext().getResources().getColor(e.d.cp_cont_i);
        this.gEz = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds2);
        this.mPaint.setColor(this.cgV);
        this.mPaint.setStrokeWidth(this.gEz);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bsc();
        this.gEC = 1;
        this.gEA = -90.0f;
        this.mStartAngle = -90.0f;
        this.gEE = ValueAnimator.ofFloat(this.gEt);
        this.gEE.setDuration(this.gEu);
        this.gEE.addListener(this.gEI);
        this.gEE.addUpdateListener(this.gEH);
        this.gEE.start();
        setVisibility(0);
        invalidate();
    }

    public void brX() {
        bsc();
        this.gEC = 2;
        this.mStartAngle = this.gEA;
        this.gEF = ValueAnimator.ofFloat(-this.gEv);
        this.gEF.setDuration(this.gEw);
        this.gEF.addListener(this.gEI);
        this.gEF.addUpdateListener(this.gEH);
        this.gEF.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsb() {
        bsc();
        this.gEC = 3;
        this.mStartAngle = this.gEA;
        this.gEG = ValueAnimator.ofFloat(this.gEx);
        this.gEG.setDuration(this.gEy);
        this.gEG.addListener(this.gEI);
        this.gEG.addUpdateListener(this.gEH);
        this.gEG.start();
    }

    public void brZ() {
        bsc();
        setVisibility(8);
    }

    private void bsc() {
        if (this.gEE != null) {
            this.gEE.cancel();
        }
        if (this.gEF != null) {
            this.gEF.cancel();
        }
        if (this.gEG != null) {
            this.gEG.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.gED = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bsc();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.gEA, this.gEB, false, this.mPaint);
    }
}
