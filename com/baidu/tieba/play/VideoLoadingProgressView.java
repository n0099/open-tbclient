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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class VideoLoadingProgressView extends View {
    private float alq;
    private int dwM;
    private int hYA;
    private a hYB;
    private ValueAnimator hYC;
    private ValueAnimator hYD;
    private ValueAnimator hYE;
    private ValueAnimator.AnimatorUpdateListener hYF;
    private AnimatorListenerAdapter hYG;
    private float hYr;
    private int hYs;
    private float hYt;
    private int hYu;
    private float hYv;
    private int hYw;
    private int hYx;
    private float hYy;
    private float hYz;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.hYr = 7200.0f;
        this.hYs = 10000;
        this.hYt = 30.0f;
        this.hYu = 50;
        this.hYv = 300.0f;
        this.hYw = 400;
        this.alq = -90.0f;
        this.hYy = this.alq;
        this.hYz = 60.0f;
        this.hYF = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.hYA != 1 && VideoLoadingProgressView.this.hYA != 2) {
                    if (VideoLoadingProgressView.this.hYA == 3) {
                        VideoLoadingProgressView.this.hYz = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.hYy = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alq;
                    VideoLoadingProgressView.this.hYz = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.hYG = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.hYA == 2) {
                    VideoLoadingProgressView.this.bTT();
                } else if (VideoLoadingProgressView.this.hYA == 3 && VideoLoadingProgressView.this.hYB != null) {
                    VideoLoadingProgressView.this.hYB.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hYr = 7200.0f;
        this.hYs = 10000;
        this.hYt = 30.0f;
        this.hYu = 50;
        this.hYv = 300.0f;
        this.hYw = 400;
        this.alq = -90.0f;
        this.hYy = this.alq;
        this.hYz = 60.0f;
        this.hYF = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.hYA != 1 && VideoLoadingProgressView.this.hYA != 2) {
                    if (VideoLoadingProgressView.this.hYA == 3) {
                        VideoLoadingProgressView.this.hYz = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.hYy = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alq;
                    VideoLoadingProgressView.this.hYz = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.hYG = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.hYA == 2) {
                    VideoLoadingProgressView.this.bTT();
                } else if (VideoLoadingProgressView.this.hYA == 3 && VideoLoadingProgressView.this.hYB != null) {
                    VideoLoadingProgressView.this.hYB.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hYr = 7200.0f;
        this.hYs = 10000;
        this.hYt = 30.0f;
        this.hYu = 50;
        this.hYv = 300.0f;
        this.hYw = 400;
        this.alq = -90.0f;
        this.hYy = this.alq;
        this.hYz = 60.0f;
        this.hYF = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.hYA != 1 && VideoLoadingProgressView.this.hYA != 2) {
                    if (VideoLoadingProgressView.this.hYA == 3) {
                        VideoLoadingProgressView.this.hYz = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.hYy = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alq;
                    VideoLoadingProgressView.this.hYz = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.hYG = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.hYA == 2) {
                    VideoLoadingProgressView.this.bTT();
                } else if (VideoLoadingProgressView.this.hYA == 3 && VideoLoadingProgressView.this.hYB != null) {
                    VideoLoadingProgressView.this.hYB.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.dwM = getContext().getResources().getColor(d.C0277d.cp_btn_a);
        this.hYx = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds2);
        this.mPaint.setColor(this.dwM);
        this.mPaint.setStrokeWidth(this.hYx);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bTU();
        this.hYA = 1;
        this.hYy = -90.0f;
        this.alq = -90.0f;
        this.hYC = ValueAnimator.ofFloat(this.hYr);
        this.hYC.setDuration(this.hYs);
        this.hYC.addListener(this.hYG);
        this.hYC.addUpdateListener(this.hYF);
        this.hYC.start();
        setVisibility(0);
        invalidate();
    }

    public void bTP() {
        bTU();
        this.hYA = 2;
        this.alq = this.hYy;
        this.hYD = ValueAnimator.ofFloat(-this.hYt);
        this.hYD.setDuration(this.hYu);
        this.hYD.addListener(this.hYG);
        this.hYD.addUpdateListener(this.hYF);
        this.hYD.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTT() {
        bTU();
        this.hYA = 3;
        this.alq = this.hYy;
        this.hYE = ValueAnimator.ofFloat(this.hYv);
        this.hYE.setDuration(this.hYw);
        this.hYE.addListener(this.hYG);
        this.hYE.addUpdateListener(this.hYF);
        this.hYE.start();
    }

    public void bTR() {
        bTU();
        setVisibility(8);
    }

    private void bTU() {
        if (this.hYC != null) {
            this.hYC.cancel();
        }
        if (this.hYD != null) {
            this.hYD.cancel();
        }
        if (this.hYE != null) {
            this.hYE.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.hYB = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bTU();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.hYy, this.hYz, false, this.mPaint);
    }
}
