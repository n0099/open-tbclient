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
    private float alp;
    private int dwQ;
    private float hYA;
    private int hYB;
    private int hYC;
    private float hYD;
    private float hYE;
    private int hYF;
    private a hYG;
    private ValueAnimator hYH;
    private ValueAnimator hYI;
    private ValueAnimator hYJ;
    private ValueAnimator.AnimatorUpdateListener hYK;
    private AnimatorListenerAdapter hYL;
    private float hYw;
    private int hYx;
    private float hYy;
    private int hYz;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.hYw = 7200.0f;
        this.hYx = 10000;
        this.hYy = 30.0f;
        this.hYz = 50;
        this.hYA = 300.0f;
        this.hYB = 400;
        this.alp = -90.0f;
        this.hYD = this.alp;
        this.hYE = 60.0f;
        this.hYK = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.hYF != 1 && VideoLoadingProgressView.this.hYF != 2) {
                    if (VideoLoadingProgressView.this.hYF == 3) {
                        VideoLoadingProgressView.this.hYE = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.hYD = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alp;
                    VideoLoadingProgressView.this.hYE = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.hYL = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.hYF == 2) {
                    VideoLoadingProgressView.this.bTQ();
                } else if (VideoLoadingProgressView.this.hYF == 3 && VideoLoadingProgressView.this.hYG != null) {
                    VideoLoadingProgressView.this.hYG.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hYw = 7200.0f;
        this.hYx = 10000;
        this.hYy = 30.0f;
        this.hYz = 50;
        this.hYA = 300.0f;
        this.hYB = 400;
        this.alp = -90.0f;
        this.hYD = this.alp;
        this.hYE = 60.0f;
        this.hYK = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.hYF != 1 && VideoLoadingProgressView.this.hYF != 2) {
                    if (VideoLoadingProgressView.this.hYF == 3) {
                        VideoLoadingProgressView.this.hYE = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.hYD = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alp;
                    VideoLoadingProgressView.this.hYE = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.hYL = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.hYF == 2) {
                    VideoLoadingProgressView.this.bTQ();
                } else if (VideoLoadingProgressView.this.hYF == 3 && VideoLoadingProgressView.this.hYG != null) {
                    VideoLoadingProgressView.this.hYG.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hYw = 7200.0f;
        this.hYx = 10000;
        this.hYy = 30.0f;
        this.hYz = 50;
        this.hYA = 300.0f;
        this.hYB = 400;
        this.alp = -90.0f;
        this.hYD = this.alp;
        this.hYE = 60.0f;
        this.hYK = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.hYF != 1 && VideoLoadingProgressView.this.hYF != 2) {
                    if (VideoLoadingProgressView.this.hYF == 3) {
                        VideoLoadingProgressView.this.hYE = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.hYD = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alp;
                    VideoLoadingProgressView.this.hYE = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.hYL = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.hYF == 2) {
                    VideoLoadingProgressView.this.bTQ();
                } else if (VideoLoadingProgressView.this.hYF == 3 && VideoLoadingProgressView.this.hYG != null) {
                    VideoLoadingProgressView.this.hYG.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.dwQ = getContext().getResources().getColor(d.C0236d.cp_btn_a);
        this.hYC = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds2);
        this.mPaint.setColor(this.dwQ);
        this.mPaint.setStrokeWidth(this.hYC);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bTR();
        this.hYF = 1;
        this.hYD = -90.0f;
        this.alp = -90.0f;
        this.hYH = ValueAnimator.ofFloat(this.hYw);
        this.hYH.setDuration(this.hYx);
        this.hYH.addListener(this.hYL);
        this.hYH.addUpdateListener(this.hYK);
        this.hYH.start();
        setVisibility(0);
        invalidate();
    }

    public void bTM() {
        bTR();
        this.hYF = 2;
        this.alp = this.hYD;
        this.hYI = ValueAnimator.ofFloat(-this.hYy);
        this.hYI.setDuration(this.hYz);
        this.hYI.addListener(this.hYL);
        this.hYI.addUpdateListener(this.hYK);
        this.hYI.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTQ() {
        bTR();
        this.hYF = 3;
        this.alp = this.hYD;
        this.hYJ = ValueAnimator.ofFloat(this.hYA);
        this.hYJ.setDuration(this.hYB);
        this.hYJ.addListener(this.hYL);
        this.hYJ.addUpdateListener(this.hYK);
        this.hYJ.start();
    }

    public void bTO() {
        bTR();
        setVisibility(8);
    }

    private void bTR() {
        if (this.hYH != null) {
            this.hYH.cancel();
        }
        if (this.hYI != null) {
            this.hYI.cancel();
        }
        if (this.hYJ != null) {
            this.hYJ.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.hYG = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bTR();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.hYD, this.hYE, false, this.mPaint);
    }
}
