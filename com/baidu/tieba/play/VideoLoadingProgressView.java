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
/* loaded from: classes2.dex */
public class VideoLoadingProgressView extends View {
    private RectF aCa;
    private float bZm;
    private int enw;
    private int gsJ;
    private float lsJ;
    private int lsK;
    private float lsL;
    private int lsM;
    private float lsN;
    private int lsO;
    private float lsP;
    private float lsQ;
    private int lsR;
    private a lsS;
    private ValueAnimator lsT;
    private ValueAnimator lsU;
    private ValueAnimator lsV;
    private ValueAnimator.AnimatorUpdateListener lsW;
    private AnimatorListenerAdapter lsX;
    private Paint mPaint;

    /* loaded from: classes2.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.lsJ = 7200.0f;
        this.lsK = 10000;
        this.lsL = 30.0f;
        this.lsM = 50;
        this.lsN = 300.0f;
        this.lsO = 400;
        this.bZm = -90.0f;
        this.lsP = this.bZm;
        this.lsQ = 60.0f;
        this.lsW = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.lsR != 1 && VideoLoadingProgressView.this.lsR != 2) {
                    if (VideoLoadingProgressView.this.lsR == 3) {
                        VideoLoadingProgressView.this.lsQ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.lsP = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bZm;
                    VideoLoadingProgressView.this.lsQ = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.lsX = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.lsR == 2) {
                    VideoLoadingProgressView.this.dkb();
                } else if (VideoLoadingProgressView.this.lsR == 3 && VideoLoadingProgressView.this.lsS != null) {
                    VideoLoadingProgressView.this.lsS.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lsJ = 7200.0f;
        this.lsK = 10000;
        this.lsL = 30.0f;
        this.lsM = 50;
        this.lsN = 300.0f;
        this.lsO = 400;
        this.bZm = -90.0f;
        this.lsP = this.bZm;
        this.lsQ = 60.0f;
        this.lsW = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.lsR != 1 && VideoLoadingProgressView.this.lsR != 2) {
                    if (VideoLoadingProgressView.this.lsR == 3) {
                        VideoLoadingProgressView.this.lsQ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.lsP = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bZm;
                    VideoLoadingProgressView.this.lsQ = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.lsX = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.lsR == 2) {
                    VideoLoadingProgressView.this.dkb();
                } else if (VideoLoadingProgressView.this.lsR == 3 && VideoLoadingProgressView.this.lsS != null) {
                    VideoLoadingProgressView.this.lsS.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lsJ = 7200.0f;
        this.lsK = 10000;
        this.lsL = 30.0f;
        this.lsM = 50;
        this.lsN = 300.0f;
        this.lsO = 400;
        this.bZm = -90.0f;
        this.lsP = this.bZm;
        this.lsQ = 60.0f;
        this.lsW = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.lsR != 1 && VideoLoadingProgressView.this.lsR != 2) {
                    if (VideoLoadingProgressView.this.lsR == 3) {
                        VideoLoadingProgressView.this.lsQ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.lsP = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bZm;
                    VideoLoadingProgressView.this.lsQ = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.lsX = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.lsR == 2) {
                    VideoLoadingProgressView.this.dkb();
                } else if (VideoLoadingProgressView.this.lsR == 3 && VideoLoadingProgressView.this.lsS != null) {
                    VideoLoadingProgressView.this.lsS.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.aCa = new RectF();
        this.mPaint = new Paint(1);
        this.gsJ = getContext().getResources().getColor(R.color.cp_cont_a);
        this.enw = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.gsJ);
        this.mPaint.setStrokeWidth(this.enw);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        dkc();
        this.lsR = 1;
        this.lsP = -90.0f;
        this.bZm = -90.0f;
        this.lsT = ValueAnimator.ofFloat(this.lsJ);
        this.lsT.setDuration(this.lsK);
        this.lsT.addListener(this.lsX);
        this.lsT.addUpdateListener(this.lsW);
        this.lsT.start();
        setVisibility(0);
        invalidate();
    }

    public void djY() {
        dkc();
        this.lsR = 2;
        this.bZm = this.lsP;
        this.lsU = ValueAnimator.ofFloat(-this.lsL);
        this.lsU.setDuration(this.lsM);
        this.lsU.addListener(this.lsX);
        this.lsU.addUpdateListener(this.lsW);
        this.lsU.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkb() {
        dkc();
        this.lsR = 3;
        this.bZm = this.lsP;
        this.lsV = ValueAnimator.ofFloat(this.lsN);
        this.lsV.setDuration(this.lsO);
        this.lsV.addListener(this.lsX);
        this.lsV.addUpdateListener(this.lsW);
        this.lsV.start();
    }

    public void dka() {
        dkc();
        setVisibility(8);
    }

    private void dkc() {
        if (this.lsT != null) {
            this.lsT.cancel();
        }
        if (this.lsU != null) {
            this.lsU.cancel();
        }
        if (this.lsV != null) {
            this.lsV.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.lsS = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dkc();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.aCa.left = 1;
        this.aCa.top = 1;
        this.aCa.right = getWidth() - 1;
        this.aCa.bottom = getHeight() - 1;
        canvas.drawArc(this.aCa, this.lsP, this.lsQ, false, this.mPaint);
    }
}
