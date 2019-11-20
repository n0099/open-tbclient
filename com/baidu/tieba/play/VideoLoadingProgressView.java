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
    private RectF NJ;
    private float aFJ;
    private int eaO;
    private float ixP;
    private int ixQ;
    private float ixR;
    private int ixS;
    private float ixT;
    private int ixU;
    private int ixV;
    private float ixW;
    private float ixX;
    private int ixY;
    private a ixZ;
    private ValueAnimator iya;
    private ValueAnimator iyb;
    private ValueAnimator iyc;
    private ValueAnimator.AnimatorUpdateListener iyd;
    private AnimatorListenerAdapter iye;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.ixP = 7200.0f;
        this.ixQ = 10000;
        this.ixR = 30.0f;
        this.ixS = 50;
        this.ixT = 300.0f;
        this.ixU = 400;
        this.aFJ = -90.0f;
        this.ixW = this.aFJ;
        this.ixX = 60.0f;
        this.iyd = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.ixY != 1 && VideoLoadingProgressView.this.ixY != 2) {
                    if (VideoLoadingProgressView.this.ixY == 3) {
                        VideoLoadingProgressView.this.ixX = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.ixW = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.aFJ;
                    VideoLoadingProgressView.this.ixX = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.iye = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.ixY == 2) {
                    VideoLoadingProgressView.this.ccP();
                } else if (VideoLoadingProgressView.this.ixY == 3 && VideoLoadingProgressView.this.ixZ != null) {
                    VideoLoadingProgressView.this.ixZ.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ixP = 7200.0f;
        this.ixQ = 10000;
        this.ixR = 30.0f;
        this.ixS = 50;
        this.ixT = 300.0f;
        this.ixU = 400;
        this.aFJ = -90.0f;
        this.ixW = this.aFJ;
        this.ixX = 60.0f;
        this.iyd = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.ixY != 1 && VideoLoadingProgressView.this.ixY != 2) {
                    if (VideoLoadingProgressView.this.ixY == 3) {
                        VideoLoadingProgressView.this.ixX = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.ixW = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.aFJ;
                    VideoLoadingProgressView.this.ixX = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.iye = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.ixY == 2) {
                    VideoLoadingProgressView.this.ccP();
                } else if (VideoLoadingProgressView.this.ixY == 3 && VideoLoadingProgressView.this.ixZ != null) {
                    VideoLoadingProgressView.this.ixZ.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ixP = 7200.0f;
        this.ixQ = 10000;
        this.ixR = 30.0f;
        this.ixS = 50;
        this.ixT = 300.0f;
        this.ixU = 400;
        this.aFJ = -90.0f;
        this.ixW = this.aFJ;
        this.ixX = 60.0f;
        this.iyd = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.ixY != 1 && VideoLoadingProgressView.this.ixY != 2) {
                    if (VideoLoadingProgressView.this.ixY == 3) {
                        VideoLoadingProgressView.this.ixX = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.ixW = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.aFJ;
                    VideoLoadingProgressView.this.ixX = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.iye = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.ixY == 2) {
                    VideoLoadingProgressView.this.ccP();
                } else if (VideoLoadingProgressView.this.ixY == 3 && VideoLoadingProgressView.this.ixZ != null) {
                    VideoLoadingProgressView.this.ixZ.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.NJ = new RectF();
        this.mPaint = new Paint(1);
        this.eaO = getContext().getResources().getColor(R.color.cp_cont_a);
        this.ixV = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.eaO);
        this.mPaint.setStrokeWidth(this.ixV);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        ccQ();
        this.ixY = 1;
        this.ixW = -90.0f;
        this.aFJ = -90.0f;
        this.iya = ValueAnimator.ofFloat(this.ixP);
        this.iya.setDuration(this.ixQ);
        this.iya.addListener(this.iye);
        this.iya.addUpdateListener(this.iyd);
        this.iya.start();
        setVisibility(0);
        invalidate();
    }

    public void ccL() {
        ccQ();
        this.ixY = 2;
        this.aFJ = this.ixW;
        this.iyb = ValueAnimator.ofFloat(-this.ixR);
        this.iyb.setDuration(this.ixS);
        this.iyb.addListener(this.iye);
        this.iyb.addUpdateListener(this.iyd);
        this.iyb.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccP() {
        ccQ();
        this.ixY = 3;
        this.aFJ = this.ixW;
        this.iyc = ValueAnimator.ofFloat(this.ixT);
        this.iyc.setDuration(this.ixU);
        this.iyc.addListener(this.iye);
        this.iyc.addUpdateListener(this.iyd);
        this.iyc.start();
    }

    public void ccN() {
        ccQ();
        setVisibility(8);
    }

    private void ccQ() {
        if (this.iya != null) {
            this.iya.cancel();
        }
        if (this.iyb != null) {
            this.iyb.cancel();
        }
        if (this.iyc != null) {
            this.iyc.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.ixZ = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ccQ();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.NJ.left = 1;
        this.NJ.top = 1;
        this.NJ.right = getWidth() - 1;
        this.NJ.bottom = getHeight() - 1;
        canvas.drawArc(this.NJ, this.ixW, this.ixX, false, this.mPaint);
    }
}
