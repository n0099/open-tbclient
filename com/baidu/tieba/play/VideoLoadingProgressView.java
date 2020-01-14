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
    private RectF UY;
    private float bcm;
    private int cYt;
    private int eSm;
    private int jvA;
    private float jvB;
    private float jvC;
    private int jvD;
    private a jvE;
    private ValueAnimator jvF;
    private ValueAnimator jvG;
    private ValueAnimator jvH;
    private ValueAnimator.AnimatorUpdateListener jvI;
    private AnimatorListenerAdapter jvJ;
    private float jvv;
    private int jvw;
    private float jvx;
    private int jvy;
    private float jvz;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.jvv = 7200.0f;
        this.jvw = 10000;
        this.jvx = 30.0f;
        this.jvy = 50;
        this.jvz = 300.0f;
        this.jvA = 400;
        this.bcm = -90.0f;
        this.jvB = this.bcm;
        this.jvC = 60.0f;
        this.jvI = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jvD != 1 && VideoLoadingProgressView.this.jvD != 2) {
                    if (VideoLoadingProgressView.this.jvD == 3) {
                        VideoLoadingProgressView.this.jvC = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jvB = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bcm;
                    VideoLoadingProgressView.this.jvC = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jvJ = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jvD == 2) {
                    VideoLoadingProgressView.this.cxU();
                } else if (VideoLoadingProgressView.this.jvD == 3 && VideoLoadingProgressView.this.jvE != null) {
                    VideoLoadingProgressView.this.jvE.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jvv = 7200.0f;
        this.jvw = 10000;
        this.jvx = 30.0f;
        this.jvy = 50;
        this.jvz = 300.0f;
        this.jvA = 400;
        this.bcm = -90.0f;
        this.jvB = this.bcm;
        this.jvC = 60.0f;
        this.jvI = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jvD != 1 && VideoLoadingProgressView.this.jvD != 2) {
                    if (VideoLoadingProgressView.this.jvD == 3) {
                        VideoLoadingProgressView.this.jvC = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jvB = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bcm;
                    VideoLoadingProgressView.this.jvC = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jvJ = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jvD == 2) {
                    VideoLoadingProgressView.this.cxU();
                } else if (VideoLoadingProgressView.this.jvD == 3 && VideoLoadingProgressView.this.jvE != null) {
                    VideoLoadingProgressView.this.jvE.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jvv = 7200.0f;
        this.jvw = 10000;
        this.jvx = 30.0f;
        this.jvy = 50;
        this.jvz = 300.0f;
        this.jvA = 400;
        this.bcm = -90.0f;
        this.jvB = this.bcm;
        this.jvC = 60.0f;
        this.jvI = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jvD != 1 && VideoLoadingProgressView.this.jvD != 2) {
                    if (VideoLoadingProgressView.this.jvD == 3) {
                        VideoLoadingProgressView.this.jvC = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jvB = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bcm;
                    VideoLoadingProgressView.this.jvC = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jvJ = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jvD == 2) {
                    VideoLoadingProgressView.this.cxU();
                } else if (VideoLoadingProgressView.this.jvD == 3 && VideoLoadingProgressView.this.jvE != null) {
                    VideoLoadingProgressView.this.jvE.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.UY = new RectF();
        this.mPaint = new Paint(1);
        this.eSm = getContext().getResources().getColor(R.color.cp_cont_a);
        this.cYt = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.eSm);
        this.mPaint.setStrokeWidth(this.cYt);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        cxV();
        this.jvD = 1;
        this.jvB = -90.0f;
        this.bcm = -90.0f;
        this.jvF = ValueAnimator.ofFloat(this.jvv);
        this.jvF.setDuration(this.jvw);
        this.jvF.addListener(this.jvJ);
        this.jvF.addUpdateListener(this.jvI);
        this.jvF.start();
        setVisibility(0);
        invalidate();
    }

    public void cxR() {
        cxV();
        this.jvD = 2;
        this.bcm = this.jvB;
        this.jvG = ValueAnimator.ofFloat(-this.jvx);
        this.jvG.setDuration(this.jvy);
        this.jvG.addListener(this.jvJ);
        this.jvG.addUpdateListener(this.jvI);
        this.jvG.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxU() {
        cxV();
        this.jvD = 3;
        this.bcm = this.jvB;
        this.jvH = ValueAnimator.ofFloat(this.jvz);
        this.jvH.setDuration(this.jvA);
        this.jvH.addListener(this.jvJ);
        this.jvH.addUpdateListener(this.jvI);
        this.jvH.start();
    }

    public void cxT() {
        cxV();
        setVisibility(8);
    }

    private void cxV() {
        if (this.jvF != null) {
            this.jvF.cancel();
        }
        if (this.jvG != null) {
            this.jvG.cancel();
        }
        if (this.jvH != null) {
            this.jvH.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.jvE = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cxV();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.UY.left = 1;
        this.UY.top = 1;
        this.UY.right = getWidth() - 1;
        this.UY.bottom = getHeight() - 1;
        canvas.drawArc(this.UY, this.jvB, this.jvC, false, this.mPaint);
    }
}
