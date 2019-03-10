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
    private int hYA;
    private float hYB;
    private int hYC;
    private int hYD;
    private float hYE;
    private float hYF;
    private int hYG;
    private a hYH;
    private ValueAnimator hYI;
    private ValueAnimator hYJ;
    private ValueAnimator hYK;
    private ValueAnimator.AnimatorUpdateListener hYL;
    private AnimatorListenerAdapter hYM;
    private float hYx;
    private int hYy;
    private float hYz;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.hYx = 7200.0f;
        this.hYy = 10000;
        this.hYz = 30.0f;
        this.hYA = 50;
        this.hYB = 300.0f;
        this.hYC = 400;
        this.alp = -90.0f;
        this.hYE = this.alp;
        this.hYF = 60.0f;
        this.hYL = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.hYG != 1 && VideoLoadingProgressView.this.hYG != 2) {
                    if (VideoLoadingProgressView.this.hYG == 3) {
                        VideoLoadingProgressView.this.hYF = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.hYE = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alp;
                    VideoLoadingProgressView.this.hYF = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.hYM = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.hYG == 2) {
                    VideoLoadingProgressView.this.bTR();
                } else if (VideoLoadingProgressView.this.hYG == 3 && VideoLoadingProgressView.this.hYH != null) {
                    VideoLoadingProgressView.this.hYH.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hYx = 7200.0f;
        this.hYy = 10000;
        this.hYz = 30.0f;
        this.hYA = 50;
        this.hYB = 300.0f;
        this.hYC = 400;
        this.alp = -90.0f;
        this.hYE = this.alp;
        this.hYF = 60.0f;
        this.hYL = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.hYG != 1 && VideoLoadingProgressView.this.hYG != 2) {
                    if (VideoLoadingProgressView.this.hYG == 3) {
                        VideoLoadingProgressView.this.hYF = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.hYE = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alp;
                    VideoLoadingProgressView.this.hYF = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.hYM = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.hYG == 2) {
                    VideoLoadingProgressView.this.bTR();
                } else if (VideoLoadingProgressView.this.hYG == 3 && VideoLoadingProgressView.this.hYH != null) {
                    VideoLoadingProgressView.this.hYH.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hYx = 7200.0f;
        this.hYy = 10000;
        this.hYz = 30.0f;
        this.hYA = 50;
        this.hYB = 300.0f;
        this.hYC = 400;
        this.alp = -90.0f;
        this.hYE = this.alp;
        this.hYF = 60.0f;
        this.hYL = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.hYG != 1 && VideoLoadingProgressView.this.hYG != 2) {
                    if (VideoLoadingProgressView.this.hYG == 3) {
                        VideoLoadingProgressView.this.hYF = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.hYE = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alp;
                    VideoLoadingProgressView.this.hYF = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.hYM = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.hYG == 2) {
                    VideoLoadingProgressView.this.bTR();
                } else if (VideoLoadingProgressView.this.hYG == 3 && VideoLoadingProgressView.this.hYH != null) {
                    VideoLoadingProgressView.this.hYH.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.dwQ = getContext().getResources().getColor(d.C0236d.cp_btn_a);
        this.hYD = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds2);
        this.mPaint.setColor(this.dwQ);
        this.mPaint.setStrokeWidth(this.hYD);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bTS();
        this.hYG = 1;
        this.hYE = -90.0f;
        this.alp = -90.0f;
        this.hYI = ValueAnimator.ofFloat(this.hYx);
        this.hYI.setDuration(this.hYy);
        this.hYI.addListener(this.hYM);
        this.hYI.addUpdateListener(this.hYL);
        this.hYI.start();
        setVisibility(0);
        invalidate();
    }

    public void bTN() {
        bTS();
        this.hYG = 2;
        this.alp = this.hYE;
        this.hYJ = ValueAnimator.ofFloat(-this.hYz);
        this.hYJ.setDuration(this.hYA);
        this.hYJ.addListener(this.hYM);
        this.hYJ.addUpdateListener(this.hYL);
        this.hYJ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTR() {
        bTS();
        this.hYG = 3;
        this.alp = this.hYE;
        this.hYK = ValueAnimator.ofFloat(this.hYB);
        this.hYK.setDuration(this.hYC);
        this.hYK.addListener(this.hYM);
        this.hYK.addUpdateListener(this.hYL);
        this.hYK.start();
    }

    public void bTP() {
        bTS();
        setVisibility(8);
    }

    private void bTS() {
        if (this.hYI != null) {
            this.hYI.cancel();
        }
        if (this.hYJ != null) {
            this.hYJ.cancel();
        }
        if (this.hYK != null) {
            this.hYK.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.hYH = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bTS();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.hYE, this.hYF, false, this.mPaint);
    }
}
