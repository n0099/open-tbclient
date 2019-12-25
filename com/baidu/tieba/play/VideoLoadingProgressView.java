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
    private RectF UG;
    private float bbu;
    private int cYj;
    private int eQJ;
    private float jrP;
    private int jrQ;
    private float jrR;
    private int jrS;
    private float jrT;
    private int jrU;
    private float jrV;
    private float jrW;
    private int jrX;
    private a jrY;
    private ValueAnimator jrZ;
    private ValueAnimator jsa;
    private ValueAnimator jsb;
    private ValueAnimator.AnimatorUpdateListener jsc;
    private AnimatorListenerAdapter jsd;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.jrP = 7200.0f;
        this.jrQ = 10000;
        this.jrR = 30.0f;
        this.jrS = 50;
        this.jrT = 300.0f;
        this.jrU = 400;
        this.bbu = -90.0f;
        this.jrV = this.bbu;
        this.jrW = 60.0f;
        this.jsc = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jrX != 1 && VideoLoadingProgressView.this.jrX != 2) {
                    if (VideoLoadingProgressView.this.jrX == 3) {
                        VideoLoadingProgressView.this.jrW = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jrV = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bbu;
                    VideoLoadingProgressView.this.jrW = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jsd = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jrX == 2) {
                    VideoLoadingProgressView.this.cwL();
                } else if (VideoLoadingProgressView.this.jrX == 3 && VideoLoadingProgressView.this.jrY != null) {
                    VideoLoadingProgressView.this.jrY.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jrP = 7200.0f;
        this.jrQ = 10000;
        this.jrR = 30.0f;
        this.jrS = 50;
        this.jrT = 300.0f;
        this.jrU = 400;
        this.bbu = -90.0f;
        this.jrV = this.bbu;
        this.jrW = 60.0f;
        this.jsc = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jrX != 1 && VideoLoadingProgressView.this.jrX != 2) {
                    if (VideoLoadingProgressView.this.jrX == 3) {
                        VideoLoadingProgressView.this.jrW = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jrV = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bbu;
                    VideoLoadingProgressView.this.jrW = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jsd = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jrX == 2) {
                    VideoLoadingProgressView.this.cwL();
                } else if (VideoLoadingProgressView.this.jrX == 3 && VideoLoadingProgressView.this.jrY != null) {
                    VideoLoadingProgressView.this.jrY.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jrP = 7200.0f;
        this.jrQ = 10000;
        this.jrR = 30.0f;
        this.jrS = 50;
        this.jrT = 300.0f;
        this.jrU = 400;
        this.bbu = -90.0f;
        this.jrV = this.bbu;
        this.jrW = 60.0f;
        this.jsc = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jrX != 1 && VideoLoadingProgressView.this.jrX != 2) {
                    if (VideoLoadingProgressView.this.jrX == 3) {
                        VideoLoadingProgressView.this.jrW = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jrV = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bbu;
                    VideoLoadingProgressView.this.jrW = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jsd = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jrX == 2) {
                    VideoLoadingProgressView.this.cwL();
                } else if (VideoLoadingProgressView.this.jrX == 3 && VideoLoadingProgressView.this.jrY != null) {
                    VideoLoadingProgressView.this.jrY.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.UG = new RectF();
        this.mPaint = new Paint(1);
        this.eQJ = getContext().getResources().getColor(R.color.cp_cont_a);
        this.cYj = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.eQJ);
        this.mPaint.setStrokeWidth(this.cYj);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        cwM();
        this.jrX = 1;
        this.jrV = -90.0f;
        this.bbu = -90.0f;
        this.jrZ = ValueAnimator.ofFloat(this.jrP);
        this.jrZ.setDuration(this.jrQ);
        this.jrZ.addListener(this.jsd);
        this.jrZ.addUpdateListener(this.jsc);
        this.jrZ.start();
        setVisibility(0);
        invalidate();
    }

    public void cwI() {
        cwM();
        this.jrX = 2;
        this.bbu = this.jrV;
        this.jsa = ValueAnimator.ofFloat(-this.jrR);
        this.jsa.setDuration(this.jrS);
        this.jsa.addListener(this.jsd);
        this.jsa.addUpdateListener(this.jsc);
        this.jsa.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwL() {
        cwM();
        this.jrX = 3;
        this.bbu = this.jrV;
        this.jsb = ValueAnimator.ofFloat(this.jrT);
        this.jsb.setDuration(this.jrU);
        this.jsb.addListener(this.jsd);
        this.jsb.addUpdateListener(this.jsc);
        this.jsb.start();
    }

    public void cwK() {
        cwM();
        setVisibility(8);
    }

    private void cwM() {
        if (this.jrZ != null) {
            this.jrZ.cancel();
        }
        if (this.jsa != null) {
            this.jsa.cancel();
        }
        if (this.jsb != null) {
            this.jsb.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.jrY = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cwM();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.UG.left = 1;
        this.UG.top = 1;
        this.UG.right = getWidth() - 1;
        this.UG.bottom = getHeight() - 1;
        canvas.drawArc(this.UG, this.jrV, this.jrW, false, this.mPaint);
    }
}
