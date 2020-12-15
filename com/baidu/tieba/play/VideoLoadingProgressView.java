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
    private int hlN;
    private Paint mPaint;
    private RectF mRect;
    private float mxX;
    private int mxY;
    private float mxZ;
    private int mya;
    private float myb;
    private int myc;
    private float myd;
    private float mye;
    private int myf;
    private a myg;
    private ValueAnimator myh;
    private ValueAnimator myi;
    private ValueAnimator myj;
    private ValueAnimator.AnimatorUpdateListener myk;
    private AnimatorListenerAdapter myl;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.mxX = 7200.0f;
        this.mxY = 10000;
        this.mxZ = 30.0f;
        this.mya = 50;
        this.myb = 300.0f;
        this.myc = 400;
        this.cHl = -90.0f;
        this.myd = this.cHl;
        this.mye = 60.0f;
        this.myk = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.myf != 1 && VideoLoadingProgressView.this.myf != 2) {
                    if (VideoLoadingProgressView.this.myf == 3) {
                        VideoLoadingProgressView.this.mye = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.myd = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cHl;
                    VideoLoadingProgressView.this.mye = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.myl = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.myf == 2) {
                    VideoLoadingProgressView.this.dBY();
                } else if (VideoLoadingProgressView.this.myf == 3 && VideoLoadingProgressView.this.myg != null) {
                    VideoLoadingProgressView.this.myg.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mxX = 7200.0f;
        this.mxY = 10000;
        this.mxZ = 30.0f;
        this.mya = 50;
        this.myb = 300.0f;
        this.myc = 400;
        this.cHl = -90.0f;
        this.myd = this.cHl;
        this.mye = 60.0f;
        this.myk = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.myf != 1 && VideoLoadingProgressView.this.myf != 2) {
                    if (VideoLoadingProgressView.this.myf == 3) {
                        VideoLoadingProgressView.this.mye = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.myd = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cHl;
                    VideoLoadingProgressView.this.mye = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.myl = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.myf == 2) {
                    VideoLoadingProgressView.this.dBY();
                } else if (VideoLoadingProgressView.this.myf == 3 && VideoLoadingProgressView.this.myg != null) {
                    VideoLoadingProgressView.this.myg.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mxX = 7200.0f;
        this.mxY = 10000;
        this.mxZ = 30.0f;
        this.mya = 50;
        this.myb = 300.0f;
        this.myc = 400;
        this.cHl = -90.0f;
        this.myd = this.cHl;
        this.mye = 60.0f;
        this.myk = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.myf != 1 && VideoLoadingProgressView.this.myf != 2) {
                    if (VideoLoadingProgressView.this.myf == 3) {
                        VideoLoadingProgressView.this.mye = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.myd = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cHl;
                    VideoLoadingProgressView.this.mye = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.myl = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.myf == 2) {
                    VideoLoadingProgressView.this.dBY();
                } else if (VideoLoadingProgressView.this.myf == 3 && VideoLoadingProgressView.this.myg != null) {
                    VideoLoadingProgressView.this.myg.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.hlN = getContext().getResources().getColor(R.color.CAM_X0101);
        this.eWG = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.hlN);
        this.mPaint.setStrokeWidth(this.eWG);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        dBZ();
        this.myf = 1;
        this.myd = -90.0f;
        this.cHl = -90.0f;
        this.myh = ValueAnimator.ofFloat(this.mxX);
        this.myh.setDuration(this.mxY);
        this.myh.addListener(this.myl);
        this.myh.addUpdateListener(this.myk);
        this.myh.start();
        setVisibility(0);
        invalidate();
    }

    public void dBU() {
        dBZ();
        this.myf = 2;
        this.cHl = this.myd;
        this.myi = ValueAnimator.ofFloat(-this.mxZ);
        this.myi.setDuration(this.mya);
        this.myi.addListener(this.myl);
        this.myi.addUpdateListener(this.myk);
        this.myi.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBY() {
        dBZ();
        this.myf = 3;
        this.cHl = this.myd;
        this.myj = ValueAnimator.ofFloat(this.myb);
        this.myj.setDuration(this.myc);
        this.myj.addListener(this.myl);
        this.myj.addUpdateListener(this.myk);
        this.myj.start();
    }

    public void dBW() {
        dBZ();
        setVisibility(8);
    }

    private void dBZ() {
        if (this.myh != null) {
            this.myh.cancel();
        }
        if (this.myi != null) {
            this.myi.cancel();
        }
        if (this.myj != null) {
            this.myj.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.myg = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dBZ();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.myd, this.mye, false, this.mPaint);
    }
}
