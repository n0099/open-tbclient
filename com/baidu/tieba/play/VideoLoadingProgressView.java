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
    private float iqO;
    private int iqP;
    private float iqQ;
    private int iqR;
    private float iqS;
    private int iqT;
    private int iqU;
    private float iqV;
    private float iqW;
    private int iqX;
    private a iqY;
    private ValueAnimator iqZ;
    private ValueAnimator ira;
    private ValueAnimator irb;
    private ValueAnimator.AnimatorUpdateListener irc;
    private AnimatorListenerAdapter ird;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.iqO = 7200.0f;
        this.iqP = 10000;
        this.iqQ = 30.0f;
        this.iqR = 50;
        this.iqS = 300.0f;
        this.iqT = 400;
        this.alH = -90.0f;
        this.iqV = this.alH;
        this.iqW = 60.0f;
        this.irc = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.iqX != 1 && VideoLoadingProgressView.this.iqX != 2) {
                    if (VideoLoadingProgressView.this.iqX == 3) {
                        VideoLoadingProgressView.this.iqW = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.iqV = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alH;
                    VideoLoadingProgressView.this.iqW = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.ird = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.iqX == 2) {
                    VideoLoadingProgressView.this.cbU();
                } else if (VideoLoadingProgressView.this.iqX == 3 && VideoLoadingProgressView.this.iqY != null) {
                    VideoLoadingProgressView.this.iqY.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iqO = 7200.0f;
        this.iqP = 10000;
        this.iqQ = 30.0f;
        this.iqR = 50;
        this.iqS = 300.0f;
        this.iqT = 400;
        this.alH = -90.0f;
        this.iqV = this.alH;
        this.iqW = 60.0f;
        this.irc = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.iqX != 1 && VideoLoadingProgressView.this.iqX != 2) {
                    if (VideoLoadingProgressView.this.iqX == 3) {
                        VideoLoadingProgressView.this.iqW = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.iqV = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alH;
                    VideoLoadingProgressView.this.iqW = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.ird = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.iqX == 2) {
                    VideoLoadingProgressView.this.cbU();
                } else if (VideoLoadingProgressView.this.iqX == 3 && VideoLoadingProgressView.this.iqY != null) {
                    VideoLoadingProgressView.this.iqY.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iqO = 7200.0f;
        this.iqP = 10000;
        this.iqQ = 30.0f;
        this.iqR = 50;
        this.iqS = 300.0f;
        this.iqT = 400;
        this.alH = -90.0f;
        this.iqV = this.alH;
        this.iqW = 60.0f;
        this.irc = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.iqX != 1 && VideoLoadingProgressView.this.iqX != 2) {
                    if (VideoLoadingProgressView.this.iqX == 3) {
                        VideoLoadingProgressView.this.iqW = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.iqV = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alH;
                    VideoLoadingProgressView.this.iqW = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.ird = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.iqX == 2) {
                    VideoLoadingProgressView.this.cbU();
                } else if (VideoLoadingProgressView.this.iqX == 3 && VideoLoadingProgressView.this.iqY != null) {
                    VideoLoadingProgressView.this.iqY.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.dHt = getContext().getResources().getColor(R.color.cp_btn_a);
        this.iqU = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.dHt);
        this.mPaint.setStrokeWidth(this.iqU);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        cbV();
        this.iqX = 1;
        this.iqV = -90.0f;
        this.alH = -90.0f;
        this.iqZ = ValueAnimator.ofFloat(this.iqO);
        this.iqZ.setDuration(this.iqP);
        this.iqZ.addListener(this.ird);
        this.iqZ.addUpdateListener(this.irc);
        this.iqZ.start();
        setVisibility(0);
        invalidate();
    }

    public void cbQ() {
        cbV();
        this.iqX = 2;
        this.alH = this.iqV;
        this.ira = ValueAnimator.ofFloat(-this.iqQ);
        this.ira.setDuration(this.iqR);
        this.ira.addListener(this.ird);
        this.ira.addUpdateListener(this.irc);
        this.ira.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbU() {
        cbV();
        this.iqX = 3;
        this.alH = this.iqV;
        this.irb = ValueAnimator.ofFloat(this.iqS);
        this.irb.setDuration(this.iqT);
        this.irb.addListener(this.ird);
        this.irb.addUpdateListener(this.irc);
        this.irb.start();
    }

    public void cbS() {
        cbV();
        setVisibility(8);
    }

    private void cbV() {
        if (this.iqZ != null) {
            this.iqZ.cancel();
        }
        if (this.ira != null) {
            this.ira.cancel();
        }
        if (this.irb != null) {
            this.irb.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.iqY = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cbV();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.iqV, this.iqW, false, this.mPaint);
    }
}
