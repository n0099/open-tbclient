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
    private float cHl;
    private int eWG;
    private int hlL;
    private Paint mPaint;
    private RectF mRect;
    private float mxV;
    private int mxW;
    private float mxX;
    private int mxY;
    private float mxZ;
    private int mya;
    private float myb;
    private float myc;
    private int myd;
    private a mye;
    private ValueAnimator myf;
    private ValueAnimator myg;
    private ValueAnimator myh;
    private ValueAnimator.AnimatorUpdateListener myi;
    private AnimatorListenerAdapter myj;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.mxV = 7200.0f;
        this.mxW = 10000;
        this.mxX = 30.0f;
        this.mxY = 50;
        this.mxZ = 300.0f;
        this.mya = 400;
        this.cHl = -90.0f;
        this.myb = this.cHl;
        this.myc = 60.0f;
        this.myi = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.myd != 1 && VideoLoadingProgressView.this.myd != 2) {
                    if (VideoLoadingProgressView.this.myd == 3) {
                        VideoLoadingProgressView.this.myc = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.myb = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cHl;
                    VideoLoadingProgressView.this.myc = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.myj = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.myd == 2) {
                    VideoLoadingProgressView.this.dBX();
                } else if (VideoLoadingProgressView.this.myd == 3 && VideoLoadingProgressView.this.mye != null) {
                    VideoLoadingProgressView.this.mye.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mxV = 7200.0f;
        this.mxW = 10000;
        this.mxX = 30.0f;
        this.mxY = 50;
        this.mxZ = 300.0f;
        this.mya = 400;
        this.cHl = -90.0f;
        this.myb = this.cHl;
        this.myc = 60.0f;
        this.myi = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.myd != 1 && VideoLoadingProgressView.this.myd != 2) {
                    if (VideoLoadingProgressView.this.myd == 3) {
                        VideoLoadingProgressView.this.myc = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.myb = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cHl;
                    VideoLoadingProgressView.this.myc = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.myj = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.myd == 2) {
                    VideoLoadingProgressView.this.dBX();
                } else if (VideoLoadingProgressView.this.myd == 3 && VideoLoadingProgressView.this.mye != null) {
                    VideoLoadingProgressView.this.mye.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mxV = 7200.0f;
        this.mxW = 10000;
        this.mxX = 30.0f;
        this.mxY = 50;
        this.mxZ = 300.0f;
        this.mya = 400;
        this.cHl = -90.0f;
        this.myb = this.cHl;
        this.myc = 60.0f;
        this.myi = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.myd != 1 && VideoLoadingProgressView.this.myd != 2) {
                    if (VideoLoadingProgressView.this.myd == 3) {
                        VideoLoadingProgressView.this.myc = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.myb = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cHl;
                    VideoLoadingProgressView.this.myc = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.myj = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.myd == 2) {
                    VideoLoadingProgressView.this.dBX();
                } else if (VideoLoadingProgressView.this.myd == 3 && VideoLoadingProgressView.this.mye != null) {
                    VideoLoadingProgressView.this.mye.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.hlL = getContext().getResources().getColor(R.color.CAM_X0101);
        this.eWG = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.hlL);
        this.mPaint.setStrokeWidth(this.eWG);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        dBY();
        this.myd = 1;
        this.myb = -90.0f;
        this.cHl = -90.0f;
        this.myf = ValueAnimator.ofFloat(this.mxV);
        this.myf.setDuration(this.mxW);
        this.myf.addListener(this.myj);
        this.myf.addUpdateListener(this.myi);
        this.myf.start();
        setVisibility(0);
        invalidate();
    }

    public void dBT() {
        dBY();
        this.myd = 2;
        this.cHl = this.myb;
        this.myg = ValueAnimator.ofFloat(-this.mxX);
        this.myg.setDuration(this.mxY);
        this.myg.addListener(this.myj);
        this.myg.addUpdateListener(this.myi);
        this.myg.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBX() {
        dBY();
        this.myd = 3;
        this.cHl = this.myb;
        this.myh = ValueAnimator.ofFloat(this.mxZ);
        this.myh.setDuration(this.mya);
        this.myh.addListener(this.myj);
        this.myh.addUpdateListener(this.myi);
        this.myh.start();
    }

    public void dBV() {
        dBY();
        setVisibility(8);
    }

    private void dBY() {
        if (this.myf != null) {
            this.myf.cancel();
        }
        if (this.myg != null) {
            this.myg.cancel();
        }
        if (this.myh != null) {
            this.myh.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.mye = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dBY();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.myb, this.myc, false, this.mPaint);
    }
}
