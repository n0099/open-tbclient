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
    private float alH;
    private int dHs;
    private float iqK;
    private int iqL;
    private float iqM;
    private int iqN;
    private float iqO;
    private int iqP;
    private int iqQ;
    private float iqR;
    private float iqS;
    private int iqT;
    private a iqU;
    private ValueAnimator iqV;
    private ValueAnimator iqW;
    private ValueAnimator iqX;
    private ValueAnimator.AnimatorUpdateListener iqY;
    private AnimatorListenerAdapter iqZ;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.iqK = 7200.0f;
        this.iqL = 10000;
        this.iqM = 30.0f;
        this.iqN = 50;
        this.iqO = 300.0f;
        this.iqP = 400;
        this.alH = -90.0f;
        this.iqR = this.alH;
        this.iqS = 60.0f;
        this.iqY = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.iqT != 1 && VideoLoadingProgressView.this.iqT != 2) {
                    if (VideoLoadingProgressView.this.iqT == 3) {
                        VideoLoadingProgressView.this.iqS = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.iqR = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alH;
                    VideoLoadingProgressView.this.iqS = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.iqZ = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.iqT == 2) {
                    VideoLoadingProgressView.this.cbQ();
                } else if (VideoLoadingProgressView.this.iqT == 3 && VideoLoadingProgressView.this.iqU != null) {
                    VideoLoadingProgressView.this.iqU.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iqK = 7200.0f;
        this.iqL = 10000;
        this.iqM = 30.0f;
        this.iqN = 50;
        this.iqO = 300.0f;
        this.iqP = 400;
        this.alH = -90.0f;
        this.iqR = this.alH;
        this.iqS = 60.0f;
        this.iqY = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.iqT != 1 && VideoLoadingProgressView.this.iqT != 2) {
                    if (VideoLoadingProgressView.this.iqT == 3) {
                        VideoLoadingProgressView.this.iqS = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.iqR = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alH;
                    VideoLoadingProgressView.this.iqS = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.iqZ = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.iqT == 2) {
                    VideoLoadingProgressView.this.cbQ();
                } else if (VideoLoadingProgressView.this.iqT == 3 && VideoLoadingProgressView.this.iqU != null) {
                    VideoLoadingProgressView.this.iqU.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iqK = 7200.0f;
        this.iqL = 10000;
        this.iqM = 30.0f;
        this.iqN = 50;
        this.iqO = 300.0f;
        this.iqP = 400;
        this.alH = -90.0f;
        this.iqR = this.alH;
        this.iqS = 60.0f;
        this.iqY = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.iqT != 1 && VideoLoadingProgressView.this.iqT != 2) {
                    if (VideoLoadingProgressView.this.iqT == 3) {
                        VideoLoadingProgressView.this.iqS = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.iqR = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alH;
                    VideoLoadingProgressView.this.iqS = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.iqZ = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.iqT == 2) {
                    VideoLoadingProgressView.this.cbQ();
                } else if (VideoLoadingProgressView.this.iqT == 3 && VideoLoadingProgressView.this.iqU != null) {
                    VideoLoadingProgressView.this.iqU.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.dHs = getContext().getResources().getColor(R.color.cp_btn_a);
        this.iqQ = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.dHs);
        this.mPaint.setStrokeWidth(this.iqQ);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        cbR();
        this.iqT = 1;
        this.iqR = -90.0f;
        this.alH = -90.0f;
        this.iqV = ValueAnimator.ofFloat(this.iqK);
        this.iqV.setDuration(this.iqL);
        this.iqV.addListener(this.iqZ);
        this.iqV.addUpdateListener(this.iqY);
        this.iqV.start();
        setVisibility(0);
        invalidate();
    }

    public void cbM() {
        cbR();
        this.iqT = 2;
        this.alH = this.iqR;
        this.iqW = ValueAnimator.ofFloat(-this.iqM);
        this.iqW.setDuration(this.iqN);
        this.iqW.addListener(this.iqZ);
        this.iqW.addUpdateListener(this.iqY);
        this.iqW.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbQ() {
        cbR();
        this.iqT = 3;
        this.alH = this.iqR;
        this.iqX = ValueAnimator.ofFloat(this.iqO);
        this.iqX.setDuration(this.iqP);
        this.iqX.addListener(this.iqZ);
        this.iqX.addUpdateListener(this.iqY);
        this.iqX.start();
    }

    public void cbO() {
        cbR();
        setVisibility(8);
    }

    private void cbR() {
        if (this.iqV != null) {
            this.iqV.cancel();
        }
        if (this.iqW != null) {
            this.iqW.cancel();
        }
        if (this.iqX != null) {
            this.iqX.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.iqU = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cbR();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.iqR, this.iqS, false, this.mPaint);
    }
}
