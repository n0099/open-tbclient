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
    private float cbr;
    private int epR;
    private int gwj;
    private float lBM;
    private int lBN;
    private float lBO;
    private int lBP;
    private float lBQ;
    private int lBR;
    private float lBS;
    private float lBT;
    private int lBU;
    private a lBV;
    private ValueAnimator lBW;
    private ValueAnimator lBX;
    private ValueAnimator lBY;
    private ValueAnimator.AnimatorUpdateListener lBZ;
    private AnimatorListenerAdapter lCa;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.lBM = 7200.0f;
        this.lBN = 10000;
        this.lBO = 30.0f;
        this.lBP = 50;
        this.lBQ = 300.0f;
        this.lBR = 400;
        this.cbr = -90.0f;
        this.lBS = this.cbr;
        this.lBT = 60.0f;
        this.lBZ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.lBU != 1 && VideoLoadingProgressView.this.lBU != 2) {
                    if (VideoLoadingProgressView.this.lBU == 3) {
                        VideoLoadingProgressView.this.lBT = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.lBS = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cbr;
                    VideoLoadingProgressView.this.lBT = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.lCa = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.lBU == 2) {
                    VideoLoadingProgressView.this.dnL();
                } else if (VideoLoadingProgressView.this.lBU == 3 && VideoLoadingProgressView.this.lBV != null) {
                    VideoLoadingProgressView.this.lBV.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lBM = 7200.0f;
        this.lBN = 10000;
        this.lBO = 30.0f;
        this.lBP = 50;
        this.lBQ = 300.0f;
        this.lBR = 400;
        this.cbr = -90.0f;
        this.lBS = this.cbr;
        this.lBT = 60.0f;
        this.lBZ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.lBU != 1 && VideoLoadingProgressView.this.lBU != 2) {
                    if (VideoLoadingProgressView.this.lBU == 3) {
                        VideoLoadingProgressView.this.lBT = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.lBS = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cbr;
                    VideoLoadingProgressView.this.lBT = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.lCa = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.lBU == 2) {
                    VideoLoadingProgressView.this.dnL();
                } else if (VideoLoadingProgressView.this.lBU == 3 && VideoLoadingProgressView.this.lBV != null) {
                    VideoLoadingProgressView.this.lBV.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lBM = 7200.0f;
        this.lBN = 10000;
        this.lBO = 30.0f;
        this.lBP = 50;
        this.lBQ = 300.0f;
        this.lBR = 400;
        this.cbr = -90.0f;
        this.lBS = this.cbr;
        this.lBT = 60.0f;
        this.lBZ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.lBU != 1 && VideoLoadingProgressView.this.lBU != 2) {
                    if (VideoLoadingProgressView.this.lBU == 3) {
                        VideoLoadingProgressView.this.lBT = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.lBS = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cbr;
                    VideoLoadingProgressView.this.lBT = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.lCa = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.lBU == 2) {
                    VideoLoadingProgressView.this.dnL();
                } else if (VideoLoadingProgressView.this.lBU == 3 && VideoLoadingProgressView.this.lBV != null) {
                    VideoLoadingProgressView.this.lBV.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.gwj = getContext().getResources().getColor(R.color.cp_cont_a);
        this.epR = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.gwj);
        this.mPaint.setStrokeWidth(this.epR);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        dnM();
        this.lBU = 1;
        this.lBS = -90.0f;
        this.cbr = -90.0f;
        this.lBW = ValueAnimator.ofFloat(this.lBM);
        this.lBW.setDuration(this.lBN);
        this.lBW.addListener(this.lCa);
        this.lBW.addUpdateListener(this.lBZ);
        this.lBW.start();
        setVisibility(0);
        invalidate();
    }

    public void dnH() {
        dnM();
        this.lBU = 2;
        this.cbr = this.lBS;
        this.lBX = ValueAnimator.ofFloat(-this.lBO);
        this.lBX.setDuration(this.lBP);
        this.lBX.addListener(this.lCa);
        this.lBX.addUpdateListener(this.lBZ);
        this.lBX.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnL() {
        dnM();
        this.lBU = 3;
        this.cbr = this.lBS;
        this.lBY = ValueAnimator.ofFloat(this.lBQ);
        this.lBY.setDuration(this.lBR);
        this.lBY.addListener(this.lCa);
        this.lBY.addUpdateListener(this.lBZ);
        this.lBY.start();
    }

    public void dnJ() {
        dnM();
        setVisibility(8);
    }

    private void dnM() {
        if (this.lBW != null) {
            this.lBW.cancel();
        }
        if (this.lBX != null) {
            this.lBX.cancel();
        }
        if (this.lBY != null) {
            this.lBY.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.lBV = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dnM();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.lBS, this.lBT, false, this.mPaint);
    }
}
