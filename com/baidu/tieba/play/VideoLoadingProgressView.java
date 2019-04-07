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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class VideoLoadingProgressView extends View {
    private float alu;
    private int dwR;
    private float hYd;
    private int hYe;
    private float hYf;
    private int hYg;
    private float hYh;
    private int hYi;
    private int hYj;
    private float hYk;
    private float hYl;
    private int hYm;
    private a hYn;
    private ValueAnimator hYo;
    private ValueAnimator hYp;
    private ValueAnimator hYq;
    private ValueAnimator.AnimatorUpdateListener hYr;
    private AnimatorListenerAdapter hYs;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.hYd = 7200.0f;
        this.hYe = 10000;
        this.hYf = 30.0f;
        this.hYg = 50;
        this.hYh = 300.0f;
        this.hYi = 400;
        this.alu = -90.0f;
        this.hYk = this.alu;
        this.hYl = 60.0f;
        this.hYr = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.hYm != 1 && VideoLoadingProgressView.this.hYm != 2) {
                    if (VideoLoadingProgressView.this.hYm == 3) {
                        VideoLoadingProgressView.this.hYl = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.hYk = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alu;
                    VideoLoadingProgressView.this.hYl = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.hYs = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.hYm == 2) {
                    VideoLoadingProgressView.this.bTP();
                } else if (VideoLoadingProgressView.this.hYm == 3 && VideoLoadingProgressView.this.hYn != null) {
                    VideoLoadingProgressView.this.hYn.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hYd = 7200.0f;
        this.hYe = 10000;
        this.hYf = 30.0f;
        this.hYg = 50;
        this.hYh = 300.0f;
        this.hYi = 400;
        this.alu = -90.0f;
        this.hYk = this.alu;
        this.hYl = 60.0f;
        this.hYr = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.hYm != 1 && VideoLoadingProgressView.this.hYm != 2) {
                    if (VideoLoadingProgressView.this.hYm == 3) {
                        VideoLoadingProgressView.this.hYl = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.hYk = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alu;
                    VideoLoadingProgressView.this.hYl = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.hYs = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.hYm == 2) {
                    VideoLoadingProgressView.this.bTP();
                } else if (VideoLoadingProgressView.this.hYm == 3 && VideoLoadingProgressView.this.hYn != null) {
                    VideoLoadingProgressView.this.hYn.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hYd = 7200.0f;
        this.hYe = 10000;
        this.hYf = 30.0f;
        this.hYg = 50;
        this.hYh = 300.0f;
        this.hYi = 400;
        this.alu = -90.0f;
        this.hYk = this.alu;
        this.hYl = 60.0f;
        this.hYr = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.hYm != 1 && VideoLoadingProgressView.this.hYm != 2) {
                    if (VideoLoadingProgressView.this.hYm == 3) {
                        VideoLoadingProgressView.this.hYl = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.hYk = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alu;
                    VideoLoadingProgressView.this.hYl = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.hYs = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.hYm == 2) {
                    VideoLoadingProgressView.this.bTP();
                } else if (VideoLoadingProgressView.this.hYm == 3 && VideoLoadingProgressView.this.hYn != null) {
                    VideoLoadingProgressView.this.hYn.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.dwR = getContext().getResources().getColor(d.C0277d.cp_btn_a);
        this.hYj = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds2);
        this.mPaint.setColor(this.dwR);
        this.mPaint.setStrokeWidth(this.hYj);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bTQ();
        this.hYm = 1;
        this.hYk = -90.0f;
        this.alu = -90.0f;
        this.hYo = ValueAnimator.ofFloat(this.hYd);
        this.hYo.setDuration(this.hYe);
        this.hYo.addListener(this.hYs);
        this.hYo.addUpdateListener(this.hYr);
        this.hYo.start();
        setVisibility(0);
        invalidate();
    }

    public void bTL() {
        bTQ();
        this.hYm = 2;
        this.alu = this.hYk;
        this.hYp = ValueAnimator.ofFloat(-this.hYf);
        this.hYp.setDuration(this.hYg);
        this.hYp.addListener(this.hYs);
        this.hYp.addUpdateListener(this.hYr);
        this.hYp.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTP() {
        bTQ();
        this.hYm = 3;
        this.alu = this.hYk;
        this.hYq = ValueAnimator.ofFloat(this.hYh);
        this.hYq.setDuration(this.hYi);
        this.hYq.addListener(this.hYs);
        this.hYq.addUpdateListener(this.hYr);
        this.hYq.start();
    }

    public void bTN() {
        bTQ();
        setVisibility(8);
    }

    private void bTQ() {
        if (this.hYo != null) {
            this.hYo.cancel();
        }
        if (this.hYp != null) {
            this.hYp.cancel();
        }
        if (this.hYq != null) {
            this.hYq.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.hYn = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bTQ();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.hYk, this.hYl, false, this.mPaint);
    }
}
