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
    private int cde;
    private float gxD;
    private int gxE;
    private float gxF;
    private int gxG;
    private float gxH;
    private int gxI;
    private int gxJ;
    private float gxK;
    private float gxL;
    private int gxM;
    private a gxN;
    private ValueAnimator gxO;
    private ValueAnimator gxP;
    private ValueAnimator gxQ;
    private ValueAnimator.AnimatorUpdateListener gxR;
    private AnimatorListenerAdapter gxS;
    private Paint mPaint;
    private RectF mRect;
    private float mStartAngle;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.gxD = 7200.0f;
        this.gxE = 10000;
        this.gxF = 30.0f;
        this.gxG = 50;
        this.gxH = 300.0f;
        this.gxI = 400;
        this.mStartAngle = -90.0f;
        this.gxK = this.mStartAngle;
        this.gxL = 60.0f;
        this.gxR = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gxM != 1 && VideoLoadingProgressView.this.gxM != 2) {
                    if (VideoLoadingProgressView.this.gxM == 3) {
                        VideoLoadingProgressView.this.gxL = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gxK = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gxL = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gxS = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gxM == 2) {
                    VideoLoadingProgressView.this.bqi();
                } else if (VideoLoadingProgressView.this.gxM == 3 && VideoLoadingProgressView.this.gxN != null) {
                    VideoLoadingProgressView.this.gxN.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gxD = 7200.0f;
        this.gxE = 10000;
        this.gxF = 30.0f;
        this.gxG = 50;
        this.gxH = 300.0f;
        this.gxI = 400;
        this.mStartAngle = -90.0f;
        this.gxK = this.mStartAngle;
        this.gxL = 60.0f;
        this.gxR = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gxM != 1 && VideoLoadingProgressView.this.gxM != 2) {
                    if (VideoLoadingProgressView.this.gxM == 3) {
                        VideoLoadingProgressView.this.gxL = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gxK = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gxL = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gxS = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gxM == 2) {
                    VideoLoadingProgressView.this.bqi();
                } else if (VideoLoadingProgressView.this.gxM == 3 && VideoLoadingProgressView.this.gxN != null) {
                    VideoLoadingProgressView.this.gxN.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gxD = 7200.0f;
        this.gxE = 10000;
        this.gxF = 30.0f;
        this.gxG = 50;
        this.gxH = 300.0f;
        this.gxI = 400;
        this.mStartAngle = -90.0f;
        this.gxK = this.mStartAngle;
        this.gxL = 60.0f;
        this.gxR = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gxM != 1 && VideoLoadingProgressView.this.gxM != 2) {
                    if (VideoLoadingProgressView.this.gxM == 3) {
                        VideoLoadingProgressView.this.gxL = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gxK = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gxL = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gxS = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gxM == 2) {
                    VideoLoadingProgressView.this.bqi();
                } else if (VideoLoadingProgressView.this.gxM == 3 && VideoLoadingProgressView.this.gxN != null) {
                    VideoLoadingProgressView.this.gxN.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.cde = getContext().getResources().getColor(e.d.cp_cont_i);
        this.gxJ = com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.ds2);
        this.mPaint.setColor(this.cde);
        this.mPaint.setStrokeWidth(this.gxJ);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bqj();
        this.gxM = 1;
        this.gxK = -90.0f;
        this.mStartAngle = -90.0f;
        this.gxO = ValueAnimator.ofFloat(this.gxD);
        this.gxO.setDuration(this.gxE);
        this.gxO.addListener(this.gxS);
        this.gxO.addUpdateListener(this.gxR);
        this.gxO.start();
        setVisibility(0);
        invalidate();
    }

    public void bqe() {
        bqj();
        this.gxM = 2;
        this.mStartAngle = this.gxK;
        this.gxP = ValueAnimator.ofFloat(-this.gxF);
        this.gxP.setDuration(this.gxG);
        this.gxP.addListener(this.gxS);
        this.gxP.addUpdateListener(this.gxR);
        this.gxP.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqi() {
        bqj();
        this.gxM = 3;
        this.mStartAngle = this.gxK;
        this.gxQ = ValueAnimator.ofFloat(this.gxH);
        this.gxQ.setDuration(this.gxI);
        this.gxQ.addListener(this.gxS);
        this.gxQ.addUpdateListener(this.gxR);
        this.gxQ.start();
    }

    public void bqg() {
        bqj();
        setVisibility(8);
    }

    private void bqj() {
        if (this.gxO != null) {
            this.gxO.cancel();
        }
        if (this.gxP != null) {
            this.gxP.cancel();
        }
        if (this.gxQ != null) {
            this.gxQ.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.gxN = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bqj();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.gxK, this.gxL, false, this.mPaint);
    }
}
