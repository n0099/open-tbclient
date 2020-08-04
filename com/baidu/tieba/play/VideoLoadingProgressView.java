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
    private RectF awY;
    private float bTE;
    private int edV;
    private int ggA;
    private ValueAnimator lcA;
    private ValueAnimator lcB;
    private ValueAnimator lcC;
    private ValueAnimator.AnimatorUpdateListener lcD;
    private AnimatorListenerAdapter lcE;
    private float lcq;
    private int lcr;
    private float lcs;
    private int lct;
    private float lcu;
    private int lcv;
    private float lcw;
    private float lcx;
    private int lcy;
    private a lcz;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.lcq = 7200.0f;
        this.lcr = 10000;
        this.lcs = 30.0f;
        this.lct = 50;
        this.lcu = 300.0f;
        this.lcv = 400;
        this.bTE = -90.0f;
        this.lcw = this.bTE;
        this.lcx = 60.0f;
        this.lcD = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.lcy != 1 && VideoLoadingProgressView.this.lcy != 2) {
                    if (VideoLoadingProgressView.this.lcy == 3) {
                        VideoLoadingProgressView.this.lcx = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.lcw = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bTE;
                    VideoLoadingProgressView.this.lcx = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.lcE = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.lcy == 2) {
                    VideoLoadingProgressView.this.cYY();
                } else if (VideoLoadingProgressView.this.lcy == 3 && VideoLoadingProgressView.this.lcz != null) {
                    VideoLoadingProgressView.this.lcz.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lcq = 7200.0f;
        this.lcr = 10000;
        this.lcs = 30.0f;
        this.lct = 50;
        this.lcu = 300.0f;
        this.lcv = 400;
        this.bTE = -90.0f;
        this.lcw = this.bTE;
        this.lcx = 60.0f;
        this.lcD = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.lcy != 1 && VideoLoadingProgressView.this.lcy != 2) {
                    if (VideoLoadingProgressView.this.lcy == 3) {
                        VideoLoadingProgressView.this.lcx = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.lcw = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bTE;
                    VideoLoadingProgressView.this.lcx = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.lcE = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.lcy == 2) {
                    VideoLoadingProgressView.this.cYY();
                } else if (VideoLoadingProgressView.this.lcy == 3 && VideoLoadingProgressView.this.lcz != null) {
                    VideoLoadingProgressView.this.lcz.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lcq = 7200.0f;
        this.lcr = 10000;
        this.lcs = 30.0f;
        this.lct = 50;
        this.lcu = 300.0f;
        this.lcv = 400;
        this.bTE = -90.0f;
        this.lcw = this.bTE;
        this.lcx = 60.0f;
        this.lcD = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.lcy != 1 && VideoLoadingProgressView.this.lcy != 2) {
                    if (VideoLoadingProgressView.this.lcy == 3) {
                        VideoLoadingProgressView.this.lcx = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.lcw = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bTE;
                    VideoLoadingProgressView.this.lcx = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.lcE = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.lcy == 2) {
                    VideoLoadingProgressView.this.cYY();
                } else if (VideoLoadingProgressView.this.lcy == 3 && VideoLoadingProgressView.this.lcz != null) {
                    VideoLoadingProgressView.this.lcz.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.awY = new RectF();
        this.mPaint = new Paint(1);
        this.ggA = getContext().getResources().getColor(R.color.cp_cont_a);
        this.edV = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.ggA);
        this.mPaint.setStrokeWidth(this.edV);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        cYZ();
        this.lcy = 1;
        this.lcw = -90.0f;
        this.bTE = -90.0f;
        this.lcA = ValueAnimator.ofFloat(this.lcq);
        this.lcA.setDuration(this.lcr);
        this.lcA.addListener(this.lcE);
        this.lcA.addUpdateListener(this.lcD);
        this.lcA.start();
        setVisibility(0);
        invalidate();
    }

    public void cYV() {
        cYZ();
        this.lcy = 2;
        this.bTE = this.lcw;
        this.lcB = ValueAnimator.ofFloat(-this.lcs);
        this.lcB.setDuration(this.lct);
        this.lcB.addListener(this.lcE);
        this.lcB.addUpdateListener(this.lcD);
        this.lcB.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYY() {
        cYZ();
        this.lcy = 3;
        this.bTE = this.lcw;
        this.lcC = ValueAnimator.ofFloat(this.lcu);
        this.lcC.setDuration(this.lcv);
        this.lcC.addListener(this.lcE);
        this.lcC.addUpdateListener(this.lcD);
        this.lcC.start();
    }

    public void cYX() {
        cYZ();
        setVisibility(8);
    }

    private void cYZ() {
        if (this.lcA != null) {
            this.lcA.cancel();
        }
        if (this.lcB != null) {
            this.lcB.cancel();
        }
        if (this.lcC != null) {
            this.lcC.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.lcz = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cYZ();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.awY.left = 1;
        this.awY.top = 1;
        this.awY.right = getWidth() - 1;
        this.awY.bottom = getHeight() - 1;
        canvas.drawArc(this.awY, this.lcw, this.lcx, false, this.mPaint);
    }
}
