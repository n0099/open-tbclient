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
    private int dHt;
    private float iqN;
    private int iqO;
    private float iqP;
    private int iqQ;
    private float iqR;
    private int iqS;
    private int iqT;
    private float iqU;
    private float iqV;
    private int iqW;
    private a iqX;
    private ValueAnimator iqY;
    private ValueAnimator iqZ;
    private ValueAnimator ira;
    private ValueAnimator.AnimatorUpdateListener irb;
    private AnimatorListenerAdapter irc;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.iqN = 7200.0f;
        this.iqO = 10000;
        this.iqP = 30.0f;
        this.iqQ = 50;
        this.iqR = 300.0f;
        this.iqS = 400;
        this.alH = -90.0f;
        this.iqU = this.alH;
        this.iqV = 60.0f;
        this.irb = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.iqW != 1 && VideoLoadingProgressView.this.iqW != 2) {
                    if (VideoLoadingProgressView.this.iqW == 3) {
                        VideoLoadingProgressView.this.iqV = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.iqU = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alH;
                    VideoLoadingProgressView.this.iqV = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.irc = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.iqW == 2) {
                    VideoLoadingProgressView.this.cbT();
                } else if (VideoLoadingProgressView.this.iqW == 3 && VideoLoadingProgressView.this.iqX != null) {
                    VideoLoadingProgressView.this.iqX.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iqN = 7200.0f;
        this.iqO = 10000;
        this.iqP = 30.0f;
        this.iqQ = 50;
        this.iqR = 300.0f;
        this.iqS = 400;
        this.alH = -90.0f;
        this.iqU = this.alH;
        this.iqV = 60.0f;
        this.irb = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.iqW != 1 && VideoLoadingProgressView.this.iqW != 2) {
                    if (VideoLoadingProgressView.this.iqW == 3) {
                        VideoLoadingProgressView.this.iqV = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.iqU = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alH;
                    VideoLoadingProgressView.this.iqV = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.irc = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.iqW == 2) {
                    VideoLoadingProgressView.this.cbT();
                } else if (VideoLoadingProgressView.this.iqW == 3 && VideoLoadingProgressView.this.iqX != null) {
                    VideoLoadingProgressView.this.iqX.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iqN = 7200.0f;
        this.iqO = 10000;
        this.iqP = 30.0f;
        this.iqQ = 50;
        this.iqR = 300.0f;
        this.iqS = 400;
        this.alH = -90.0f;
        this.iqU = this.alH;
        this.iqV = 60.0f;
        this.irb = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.iqW != 1 && VideoLoadingProgressView.this.iqW != 2) {
                    if (VideoLoadingProgressView.this.iqW == 3) {
                        VideoLoadingProgressView.this.iqV = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.iqU = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alH;
                    VideoLoadingProgressView.this.iqV = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.irc = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.iqW == 2) {
                    VideoLoadingProgressView.this.cbT();
                } else if (VideoLoadingProgressView.this.iqW == 3 && VideoLoadingProgressView.this.iqX != null) {
                    VideoLoadingProgressView.this.iqX.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.dHt = getContext().getResources().getColor(R.color.cp_btn_a);
        this.iqT = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.dHt);
        this.mPaint.setStrokeWidth(this.iqT);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        cbU();
        this.iqW = 1;
        this.iqU = -90.0f;
        this.alH = -90.0f;
        this.iqY = ValueAnimator.ofFloat(this.iqN);
        this.iqY.setDuration(this.iqO);
        this.iqY.addListener(this.irc);
        this.iqY.addUpdateListener(this.irb);
        this.iqY.start();
        setVisibility(0);
        invalidate();
    }

    public void cbP() {
        cbU();
        this.iqW = 2;
        this.alH = this.iqU;
        this.iqZ = ValueAnimator.ofFloat(-this.iqP);
        this.iqZ.setDuration(this.iqQ);
        this.iqZ.addListener(this.irc);
        this.iqZ.addUpdateListener(this.irb);
        this.iqZ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbT() {
        cbU();
        this.iqW = 3;
        this.alH = this.iqU;
        this.ira = ValueAnimator.ofFloat(this.iqR);
        this.ira.setDuration(this.iqS);
        this.ira.addListener(this.irc);
        this.ira.addUpdateListener(this.irb);
        this.ira.start();
    }

    public void cbR() {
        cbU();
        setVisibility(8);
    }

    private void cbU() {
        if (this.iqY != null) {
            this.iqY.cancel();
        }
        if (this.iqZ != null) {
            this.iqZ.cancel();
        }
        if (this.ira != null) {
            this.ira.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.iqX = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cbU();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.iqU, this.iqV, false, this.mPaint);
    }
}
