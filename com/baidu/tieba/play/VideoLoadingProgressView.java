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
    private float cnH;
    private int eCd;
    private int gKC;
    private float lRb;
    private int lRc;
    private float lRd;
    private int lRe;
    private float lRf;
    private int lRg;
    private float lRh;
    private float lRi;
    private int lRj;
    private a lRk;
    private ValueAnimator lRl;
    private ValueAnimator lRm;
    private ValueAnimator lRn;
    private ValueAnimator.AnimatorUpdateListener lRo;
    private AnimatorListenerAdapter lRp;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.lRb = 7200.0f;
        this.lRc = 10000;
        this.lRd = 30.0f;
        this.lRe = 50;
        this.lRf = 300.0f;
        this.lRg = 400;
        this.cnH = -90.0f;
        this.lRh = this.cnH;
        this.lRi = 60.0f;
        this.lRo = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.lRj != 1 && VideoLoadingProgressView.this.lRj != 2) {
                    if (VideoLoadingProgressView.this.lRj == 3) {
                        VideoLoadingProgressView.this.lRi = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.lRh = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cnH;
                    VideoLoadingProgressView.this.lRi = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.lRp = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.lRj == 2) {
                    VideoLoadingProgressView.this.drw();
                } else if (VideoLoadingProgressView.this.lRj == 3 && VideoLoadingProgressView.this.lRk != null) {
                    VideoLoadingProgressView.this.lRk.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lRb = 7200.0f;
        this.lRc = 10000;
        this.lRd = 30.0f;
        this.lRe = 50;
        this.lRf = 300.0f;
        this.lRg = 400;
        this.cnH = -90.0f;
        this.lRh = this.cnH;
        this.lRi = 60.0f;
        this.lRo = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.lRj != 1 && VideoLoadingProgressView.this.lRj != 2) {
                    if (VideoLoadingProgressView.this.lRj == 3) {
                        VideoLoadingProgressView.this.lRi = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.lRh = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cnH;
                    VideoLoadingProgressView.this.lRi = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.lRp = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.lRj == 2) {
                    VideoLoadingProgressView.this.drw();
                } else if (VideoLoadingProgressView.this.lRj == 3 && VideoLoadingProgressView.this.lRk != null) {
                    VideoLoadingProgressView.this.lRk.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lRb = 7200.0f;
        this.lRc = 10000;
        this.lRd = 30.0f;
        this.lRe = 50;
        this.lRf = 300.0f;
        this.lRg = 400;
        this.cnH = -90.0f;
        this.lRh = this.cnH;
        this.lRi = 60.0f;
        this.lRo = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.lRj != 1 && VideoLoadingProgressView.this.lRj != 2) {
                    if (VideoLoadingProgressView.this.lRj == 3) {
                        VideoLoadingProgressView.this.lRi = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.lRh = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cnH;
                    VideoLoadingProgressView.this.lRi = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.lRp = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.lRj == 2) {
                    VideoLoadingProgressView.this.drw();
                } else if (VideoLoadingProgressView.this.lRj == 3 && VideoLoadingProgressView.this.lRk != null) {
                    VideoLoadingProgressView.this.lRk.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.gKC = getContext().getResources().getColor(R.color.cp_cont_a);
        this.eCd = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.gKC);
        this.mPaint.setStrokeWidth(this.eCd);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        drx();
        this.lRj = 1;
        this.lRh = -90.0f;
        this.cnH = -90.0f;
        this.lRl = ValueAnimator.ofFloat(this.lRb);
        this.lRl.setDuration(this.lRc);
        this.lRl.addListener(this.lRp);
        this.lRl.addUpdateListener(this.lRo);
        this.lRl.start();
        setVisibility(0);
        invalidate();
    }

    public void drs() {
        drx();
        this.lRj = 2;
        this.cnH = this.lRh;
        this.lRm = ValueAnimator.ofFloat(-this.lRd);
        this.lRm.setDuration(this.lRe);
        this.lRm.addListener(this.lRp);
        this.lRm.addUpdateListener(this.lRo);
        this.lRm.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drw() {
        drx();
        this.lRj = 3;
        this.cnH = this.lRh;
        this.lRn = ValueAnimator.ofFloat(this.lRf);
        this.lRn.setDuration(this.lRg);
        this.lRn.addListener(this.lRp);
        this.lRn.addUpdateListener(this.lRo);
        this.lRn.start();
    }

    public void dru() {
        drx();
        setVisibility(8);
    }

    private void drx() {
        if (this.lRl != null) {
            this.lRl.cancel();
        }
        if (this.lRm != null) {
            this.lRm.cancel();
        }
        if (this.lRn != null) {
            this.lRn.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.lRk = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        drx();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.lRh, this.lRi, false, this.mPaint);
    }
}
