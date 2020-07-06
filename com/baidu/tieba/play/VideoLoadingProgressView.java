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
    private RectF avT;
    private float bSM;
    private int dXB;
    private int gbs;
    private float kUV;
    private int kUW;
    private float kUX;
    private int kUY;
    private float kUZ;
    private int kVa;
    private float kVb;
    private float kVc;
    private int kVd;
    private a kVe;
    private ValueAnimator kVf;
    private ValueAnimator kVg;
    private ValueAnimator kVh;
    private ValueAnimator.AnimatorUpdateListener kVi;
    private AnimatorListenerAdapter kVj;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.kUV = 7200.0f;
        this.kUW = 10000;
        this.kUX = 30.0f;
        this.kUY = 50;
        this.kUZ = 300.0f;
        this.kVa = 400;
        this.bSM = -90.0f;
        this.kVb = this.bSM;
        this.kVc = 60.0f;
        this.kVi = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.kVd != 1 && VideoLoadingProgressView.this.kVd != 2) {
                    if (VideoLoadingProgressView.this.kVd == 3) {
                        VideoLoadingProgressView.this.kVc = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.kVb = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bSM;
                    VideoLoadingProgressView.this.kVc = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.kVj = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.kVd == 2) {
                    VideoLoadingProgressView.this.cVU();
                } else if (VideoLoadingProgressView.this.kVd == 3 && VideoLoadingProgressView.this.kVe != null) {
                    VideoLoadingProgressView.this.kVe.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kUV = 7200.0f;
        this.kUW = 10000;
        this.kUX = 30.0f;
        this.kUY = 50;
        this.kUZ = 300.0f;
        this.kVa = 400;
        this.bSM = -90.0f;
        this.kVb = this.bSM;
        this.kVc = 60.0f;
        this.kVi = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.kVd != 1 && VideoLoadingProgressView.this.kVd != 2) {
                    if (VideoLoadingProgressView.this.kVd == 3) {
                        VideoLoadingProgressView.this.kVc = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.kVb = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bSM;
                    VideoLoadingProgressView.this.kVc = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.kVj = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.kVd == 2) {
                    VideoLoadingProgressView.this.cVU();
                } else if (VideoLoadingProgressView.this.kVd == 3 && VideoLoadingProgressView.this.kVe != null) {
                    VideoLoadingProgressView.this.kVe.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kUV = 7200.0f;
        this.kUW = 10000;
        this.kUX = 30.0f;
        this.kUY = 50;
        this.kUZ = 300.0f;
        this.kVa = 400;
        this.bSM = -90.0f;
        this.kVb = this.bSM;
        this.kVc = 60.0f;
        this.kVi = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.kVd != 1 && VideoLoadingProgressView.this.kVd != 2) {
                    if (VideoLoadingProgressView.this.kVd == 3) {
                        VideoLoadingProgressView.this.kVc = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.kVb = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bSM;
                    VideoLoadingProgressView.this.kVc = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.kVj = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.kVd == 2) {
                    VideoLoadingProgressView.this.cVU();
                } else if (VideoLoadingProgressView.this.kVd == 3 && VideoLoadingProgressView.this.kVe != null) {
                    VideoLoadingProgressView.this.kVe.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.avT = new RectF();
        this.mPaint = new Paint(1);
        this.gbs = getContext().getResources().getColor(R.color.cp_cont_a);
        this.dXB = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.gbs);
        this.mPaint.setStrokeWidth(this.dXB);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        cVV();
        this.kVd = 1;
        this.kVb = -90.0f;
        this.bSM = -90.0f;
        this.kVf = ValueAnimator.ofFloat(this.kUV);
        this.kVf.setDuration(this.kUW);
        this.kVf.addListener(this.kVj);
        this.kVf.addUpdateListener(this.kVi);
        this.kVf.start();
        setVisibility(0);
        invalidate();
    }

    public void cVR() {
        cVV();
        this.kVd = 2;
        this.bSM = this.kVb;
        this.kVg = ValueAnimator.ofFloat(-this.kUX);
        this.kVg.setDuration(this.kUY);
        this.kVg.addListener(this.kVj);
        this.kVg.addUpdateListener(this.kVi);
        this.kVg.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVU() {
        cVV();
        this.kVd = 3;
        this.bSM = this.kVb;
        this.kVh = ValueAnimator.ofFloat(this.kUZ);
        this.kVh.setDuration(this.kVa);
        this.kVh.addListener(this.kVj);
        this.kVh.addUpdateListener(this.kVi);
        this.kVh.start();
    }

    public void cVT() {
        cVV();
        setVisibility(8);
    }

    private void cVV() {
        if (this.kVf != null) {
            this.kVf.cancel();
        }
        if (this.kVg != null) {
            this.kVg.cancel();
        }
        if (this.kVh != null) {
            this.kVh.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.kVe = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cVV();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.avT.left = 1;
        this.avT.top = 1;
        this.avT.right = getWidth() - 1;
        this.avT.bottom = getHeight() - 1;
        canvas.drawArc(this.avT, this.kVb, this.kVc, false, this.mPaint);
    }
}
