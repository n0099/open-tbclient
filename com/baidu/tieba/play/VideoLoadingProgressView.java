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
    private float cwk;
    private int eKz;
    private int gWr;
    private Paint mPaint;
    private RectF mRect;
    private int mdA;
    private float mdB;
    private int mdC;
    private float mdD;
    private int mdE;
    private float mdF;
    private float mdG;
    private int mdH;
    private a mdI;
    private ValueAnimator mdJ;
    private ValueAnimator mdK;
    private ValueAnimator mdL;
    private ValueAnimator.AnimatorUpdateListener mdM;
    private AnimatorListenerAdapter mdN;
    private float mdz;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.mdz = 7200.0f;
        this.mdA = 10000;
        this.mdB = 30.0f;
        this.mdC = 50;
        this.mdD = 300.0f;
        this.mdE = 400;
        this.cwk = -90.0f;
        this.mdF = this.cwk;
        this.mdG = 60.0f;
        this.mdM = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mdH != 1 && VideoLoadingProgressView.this.mdH != 2) {
                    if (VideoLoadingProgressView.this.mdH == 3) {
                        VideoLoadingProgressView.this.mdG = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mdF = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cwk;
                    VideoLoadingProgressView.this.mdG = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mdN = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mdH == 2) {
                    VideoLoadingProgressView.this.duD();
                } else if (VideoLoadingProgressView.this.mdH == 3 && VideoLoadingProgressView.this.mdI != null) {
                    VideoLoadingProgressView.this.mdI.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mdz = 7200.0f;
        this.mdA = 10000;
        this.mdB = 30.0f;
        this.mdC = 50;
        this.mdD = 300.0f;
        this.mdE = 400;
        this.cwk = -90.0f;
        this.mdF = this.cwk;
        this.mdG = 60.0f;
        this.mdM = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mdH != 1 && VideoLoadingProgressView.this.mdH != 2) {
                    if (VideoLoadingProgressView.this.mdH == 3) {
                        VideoLoadingProgressView.this.mdG = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mdF = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cwk;
                    VideoLoadingProgressView.this.mdG = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mdN = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mdH == 2) {
                    VideoLoadingProgressView.this.duD();
                } else if (VideoLoadingProgressView.this.mdH == 3 && VideoLoadingProgressView.this.mdI != null) {
                    VideoLoadingProgressView.this.mdI.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mdz = 7200.0f;
        this.mdA = 10000;
        this.mdB = 30.0f;
        this.mdC = 50;
        this.mdD = 300.0f;
        this.mdE = 400;
        this.cwk = -90.0f;
        this.mdF = this.cwk;
        this.mdG = 60.0f;
        this.mdM = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mdH != 1 && VideoLoadingProgressView.this.mdH != 2) {
                    if (VideoLoadingProgressView.this.mdH == 3) {
                        VideoLoadingProgressView.this.mdG = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mdF = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cwk;
                    VideoLoadingProgressView.this.mdG = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mdN = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mdH == 2) {
                    VideoLoadingProgressView.this.duD();
                } else if (VideoLoadingProgressView.this.mdH == 3 && VideoLoadingProgressView.this.mdI != null) {
                    VideoLoadingProgressView.this.mdI.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.gWr = getContext().getResources().getColor(R.color.cp_cont_a);
        this.eKz = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.gWr);
        this.mPaint.setStrokeWidth(this.eKz);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        duE();
        this.mdH = 1;
        this.mdF = -90.0f;
        this.cwk = -90.0f;
        this.mdJ = ValueAnimator.ofFloat(this.mdz);
        this.mdJ.setDuration(this.mdA);
        this.mdJ.addListener(this.mdN);
        this.mdJ.addUpdateListener(this.mdM);
        this.mdJ.start();
        setVisibility(0);
        invalidate();
    }

    public void duz() {
        duE();
        this.mdH = 2;
        this.cwk = this.mdF;
        this.mdK = ValueAnimator.ofFloat(-this.mdB);
        this.mdK.setDuration(this.mdC);
        this.mdK.addListener(this.mdN);
        this.mdK.addUpdateListener(this.mdM);
        this.mdK.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duD() {
        duE();
        this.mdH = 3;
        this.cwk = this.mdF;
        this.mdL = ValueAnimator.ofFloat(this.mdD);
        this.mdL.setDuration(this.mdE);
        this.mdL.addListener(this.mdN);
        this.mdL.addUpdateListener(this.mdM);
        this.mdL.start();
    }

    public void duB() {
        duE();
        setVisibility(8);
    }

    private void duE() {
        if (this.mdJ != null) {
            this.mdJ.cancel();
        }
        if (this.mdK != null) {
            this.mdK.cancel();
        }
        if (this.mdL != null) {
            this.mdL.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.mdI = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        duE();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.mdF, this.mdG, false, this.mPaint);
    }
}
