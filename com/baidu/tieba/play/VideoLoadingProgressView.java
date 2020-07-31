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
    private ValueAnimator.AnimatorUpdateListener lcB;
    private AnimatorListenerAdapter lcC;
    private float lco;
    private int lcp;
    private float lcq;
    private int lcr;
    private float lcs;
    private int lct;
    private float lcu;
    private float lcv;
    private int lcw;
    private a lcx;
    private ValueAnimator lcy;
    private ValueAnimator lcz;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.lco = 7200.0f;
        this.lcp = 10000;
        this.lcq = 30.0f;
        this.lcr = 50;
        this.lcs = 300.0f;
        this.lct = 400;
        this.bTE = -90.0f;
        this.lcu = this.bTE;
        this.lcv = 60.0f;
        this.lcB = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.lcw != 1 && VideoLoadingProgressView.this.lcw != 2) {
                    if (VideoLoadingProgressView.this.lcw == 3) {
                        VideoLoadingProgressView.this.lcv = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.lcu = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bTE;
                    VideoLoadingProgressView.this.lcv = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.lcC = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.lcw == 2) {
                    VideoLoadingProgressView.this.cYY();
                } else if (VideoLoadingProgressView.this.lcw == 3 && VideoLoadingProgressView.this.lcx != null) {
                    VideoLoadingProgressView.this.lcx.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lco = 7200.0f;
        this.lcp = 10000;
        this.lcq = 30.0f;
        this.lcr = 50;
        this.lcs = 300.0f;
        this.lct = 400;
        this.bTE = -90.0f;
        this.lcu = this.bTE;
        this.lcv = 60.0f;
        this.lcB = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.lcw != 1 && VideoLoadingProgressView.this.lcw != 2) {
                    if (VideoLoadingProgressView.this.lcw == 3) {
                        VideoLoadingProgressView.this.lcv = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.lcu = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bTE;
                    VideoLoadingProgressView.this.lcv = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.lcC = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.lcw == 2) {
                    VideoLoadingProgressView.this.cYY();
                } else if (VideoLoadingProgressView.this.lcw == 3 && VideoLoadingProgressView.this.lcx != null) {
                    VideoLoadingProgressView.this.lcx.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lco = 7200.0f;
        this.lcp = 10000;
        this.lcq = 30.0f;
        this.lcr = 50;
        this.lcs = 300.0f;
        this.lct = 400;
        this.bTE = -90.0f;
        this.lcu = this.bTE;
        this.lcv = 60.0f;
        this.lcB = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.lcw != 1 && VideoLoadingProgressView.this.lcw != 2) {
                    if (VideoLoadingProgressView.this.lcw == 3) {
                        VideoLoadingProgressView.this.lcv = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.lcu = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bTE;
                    VideoLoadingProgressView.this.lcv = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.lcC = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.lcw == 2) {
                    VideoLoadingProgressView.this.cYY();
                } else if (VideoLoadingProgressView.this.lcw == 3 && VideoLoadingProgressView.this.lcx != null) {
                    VideoLoadingProgressView.this.lcx.onAnimationEnd();
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
        this.lcw = 1;
        this.lcu = -90.0f;
        this.bTE = -90.0f;
        this.lcy = ValueAnimator.ofFloat(this.lco);
        this.lcy.setDuration(this.lcp);
        this.lcy.addListener(this.lcC);
        this.lcy.addUpdateListener(this.lcB);
        this.lcy.start();
        setVisibility(0);
        invalidate();
    }

    public void cYV() {
        cYZ();
        this.lcw = 2;
        this.bTE = this.lcu;
        this.lcz = ValueAnimator.ofFloat(-this.lcq);
        this.lcz.setDuration(this.lcr);
        this.lcz.addListener(this.lcC);
        this.lcz.addUpdateListener(this.lcB);
        this.lcz.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYY() {
        cYZ();
        this.lcw = 3;
        this.bTE = this.lcu;
        this.lcA = ValueAnimator.ofFloat(this.lcs);
        this.lcA.setDuration(this.lct);
        this.lcA.addListener(this.lcC);
        this.lcA.addUpdateListener(this.lcB);
        this.lcA.start();
    }

    public void cYX() {
        cYZ();
        setVisibility(8);
    }

    private void cYZ() {
        if (this.lcy != null) {
            this.lcy.cancel();
        }
        if (this.lcz != null) {
            this.lcz.cancel();
        }
        if (this.lcA != null) {
            this.lcA.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.lcx = aVar;
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
        canvas.drawArc(this.awY, this.lcu, this.lcv, false, this.mPaint);
    }
}
