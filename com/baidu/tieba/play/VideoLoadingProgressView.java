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
    private float cJK;
    private int fdO;
    private int hxm;
    private float mHK;
    private int mHL;
    private float mHM;
    private int mHN;
    private float mHO;
    private int mHP;
    private float mHQ;
    private float mHR;
    private int mHS;
    private a mHT;
    private ValueAnimator mHU;
    private ValueAnimator mHV;
    private ValueAnimator mHW;
    private ValueAnimator.AnimatorUpdateListener mHX;
    private AnimatorListenerAdapter mHY;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.mHK = 7200.0f;
        this.mHL = 10000;
        this.mHM = 30.0f;
        this.mHN = 50;
        this.mHO = 300.0f;
        this.mHP = 400;
        this.cJK = -90.0f;
        this.mHQ = this.cJK;
        this.mHR = 60.0f;
        this.mHX = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mHS != 1 && VideoLoadingProgressView.this.mHS != 2) {
                    if (VideoLoadingProgressView.this.mHS == 3) {
                        VideoLoadingProgressView.this.mHR = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mHQ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cJK;
                    VideoLoadingProgressView.this.mHR = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mHY = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mHS == 2) {
                    VideoLoadingProgressView.this.dAe();
                } else if (VideoLoadingProgressView.this.mHS == 3 && VideoLoadingProgressView.this.mHT != null) {
                    VideoLoadingProgressView.this.mHT.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHK = 7200.0f;
        this.mHL = 10000;
        this.mHM = 30.0f;
        this.mHN = 50;
        this.mHO = 300.0f;
        this.mHP = 400;
        this.cJK = -90.0f;
        this.mHQ = this.cJK;
        this.mHR = 60.0f;
        this.mHX = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mHS != 1 && VideoLoadingProgressView.this.mHS != 2) {
                    if (VideoLoadingProgressView.this.mHS == 3) {
                        VideoLoadingProgressView.this.mHR = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mHQ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cJK;
                    VideoLoadingProgressView.this.mHR = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mHY = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mHS == 2) {
                    VideoLoadingProgressView.this.dAe();
                } else if (VideoLoadingProgressView.this.mHS == 3 && VideoLoadingProgressView.this.mHT != null) {
                    VideoLoadingProgressView.this.mHT.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHK = 7200.0f;
        this.mHL = 10000;
        this.mHM = 30.0f;
        this.mHN = 50;
        this.mHO = 300.0f;
        this.mHP = 400;
        this.cJK = -90.0f;
        this.mHQ = this.cJK;
        this.mHR = 60.0f;
        this.mHX = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mHS != 1 && VideoLoadingProgressView.this.mHS != 2) {
                    if (VideoLoadingProgressView.this.mHS == 3) {
                        VideoLoadingProgressView.this.mHR = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mHQ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cJK;
                    VideoLoadingProgressView.this.mHR = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mHY = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mHS == 2) {
                    VideoLoadingProgressView.this.dAe();
                } else if (VideoLoadingProgressView.this.mHS == 3 && VideoLoadingProgressView.this.mHT != null) {
                    VideoLoadingProgressView.this.mHT.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.hxm = getContext().getResources().getColor(R.color.CAM_X0101);
        this.fdO = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.hxm);
        this.mPaint.setStrokeWidth(this.fdO);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        dAf();
        this.mHS = 1;
        this.mHQ = -90.0f;
        this.cJK = -90.0f;
        this.mHU = ValueAnimator.ofFloat(this.mHK);
        this.mHU.setDuration(this.mHL);
        this.mHU.addListener(this.mHY);
        this.mHU.addUpdateListener(this.mHX);
        this.mHU.start();
        setVisibility(0);
        invalidate();
    }

    public void dAa() {
        dAf();
        this.mHS = 2;
        this.cJK = this.mHQ;
        this.mHV = ValueAnimator.ofFloat(-this.mHM);
        this.mHV.setDuration(this.mHN);
        this.mHV.addListener(this.mHY);
        this.mHV.addUpdateListener(this.mHX);
        this.mHV.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAe() {
        dAf();
        this.mHS = 3;
        this.cJK = this.mHQ;
        this.mHW = ValueAnimator.ofFloat(this.mHO);
        this.mHW.setDuration(this.mHP);
        this.mHW.addListener(this.mHY);
        this.mHW.addUpdateListener(this.mHX);
        this.mHW.start();
    }

    public void dAc() {
        dAf();
        setVisibility(8);
    }

    private void dAf() {
        if (this.mHU != null) {
            this.mHU.cancel();
        }
        if (this.mHV != null) {
            this.mHV.cancel();
        }
        if (this.mHW != null) {
            this.mHW.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.mHT = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dAf();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.mHQ, this.mHR, false, this.mPaint);
    }
}
