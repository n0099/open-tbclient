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
    private ValueAnimator jvA;
    private ValueAnimator jvB;
    private ValueAnimator jvC;
    private ValueAnimator.AnimatorUpdateListener jvD;
    private AnimatorListenerAdapter jvE;
    private float jvq;
    private int jvr;
    private float jvs;
    private int jvt;
    private float jvu;
    private int jvv;
    private float jvw;
    private float jvx;
    private int jvy;
    private a jvz;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.jvq = 7200.0f;
        this.jvr = 10000;
        this.jvs = 30.0f;
        this.jvt = 50;
        this.jvu = 300.0f;
        this.jvv = 400;
        this.bcm = -90.0f;
        this.jvw = this.bcm;
        this.jvx = 60.0f;
        this.jvD = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jvy != 1 && VideoLoadingProgressView.this.jvy != 2) {
                    if (VideoLoadingProgressView.this.jvy == 3) {
                        VideoLoadingProgressView.this.jvx = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jvw = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bcm;
                    VideoLoadingProgressView.this.jvx = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jvE = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jvy == 2) {
                    VideoLoadingProgressView.this.cxS();
                } else if (VideoLoadingProgressView.this.jvy == 3 && VideoLoadingProgressView.this.jvz != null) {
                    VideoLoadingProgressView.this.jvz.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jvq = 7200.0f;
        this.jvr = 10000;
        this.jvs = 30.0f;
        this.jvt = 50;
        this.jvu = 300.0f;
        this.jvv = 400;
        this.bcm = -90.0f;
        this.jvw = this.bcm;
        this.jvx = 60.0f;
        this.jvD = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jvy != 1 && VideoLoadingProgressView.this.jvy != 2) {
                    if (VideoLoadingProgressView.this.jvy == 3) {
                        VideoLoadingProgressView.this.jvx = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jvw = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bcm;
                    VideoLoadingProgressView.this.jvx = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jvE = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jvy == 2) {
                    VideoLoadingProgressView.this.cxS();
                } else if (VideoLoadingProgressView.this.jvy == 3 && VideoLoadingProgressView.this.jvz != null) {
                    VideoLoadingProgressView.this.jvz.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jvq = 7200.0f;
        this.jvr = 10000;
        this.jvs = 30.0f;
        this.jvt = 50;
        this.jvu = 300.0f;
        this.jvv = 400;
        this.bcm = -90.0f;
        this.jvw = this.bcm;
        this.jvx = 60.0f;
        this.jvD = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jvy != 1 && VideoLoadingProgressView.this.jvy != 2) {
                    if (VideoLoadingProgressView.this.jvy == 3) {
                        VideoLoadingProgressView.this.jvx = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jvw = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bcm;
                    VideoLoadingProgressView.this.jvx = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jvE = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jvy == 2) {
                    VideoLoadingProgressView.this.cxS();
                } else if (VideoLoadingProgressView.this.jvy == 3 && VideoLoadingProgressView.this.jvz != null) {
                    VideoLoadingProgressView.this.jvz.onAnimationEnd();
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
        cxT();
        this.jvy = 1;
        this.jvw = -90.0f;
        this.bcm = -90.0f;
        this.jvA = ValueAnimator.ofFloat(this.jvq);
        this.jvA.setDuration(this.jvr);
        this.jvA.addListener(this.jvE);
        this.jvA.addUpdateListener(this.jvD);
        this.jvA.start();
        setVisibility(0);
        invalidate();
    }

    public void cxP() {
        cxT();
        this.jvy = 2;
        this.bcm = this.jvw;
        this.jvB = ValueAnimator.ofFloat(-this.jvs);
        this.jvB.setDuration(this.jvt);
        this.jvB.addListener(this.jvE);
        this.jvB.addUpdateListener(this.jvD);
        this.jvB.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxS() {
        cxT();
        this.jvy = 3;
        this.bcm = this.jvw;
        this.jvC = ValueAnimator.ofFloat(this.jvu);
        this.jvC.setDuration(this.jvv);
        this.jvC.addListener(this.jvE);
        this.jvC.addUpdateListener(this.jvD);
        this.jvC.start();
    }

    public void cxR() {
        cxT();
        setVisibility(8);
    }

    private void cxT() {
        if (this.jvA != null) {
            this.jvA.cancel();
        }
        if (this.jvB != null) {
            this.jvB.cancel();
        }
        if (this.jvC != null) {
            this.jvC.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.jvz = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cxT();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.UY.left = 1;
        this.UY.top = 1;
        this.UY.right = getWidth() - 1;
        this.UY.bottom = getHeight() - 1;
        canvas.drawArc(this.UY, this.jvw, this.jvx, false, this.mPaint);
    }
}
