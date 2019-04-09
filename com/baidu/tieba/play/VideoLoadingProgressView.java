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
    private float alv;
    private int dwS;
    private float hYe;
    private int hYf;
    private float hYg;
    private int hYh;
    private float hYi;
    private int hYj;
    private int hYk;
    private float hYl;
    private float hYm;
    private int hYn;
    private a hYo;
    private ValueAnimator hYp;
    private ValueAnimator hYq;
    private ValueAnimator hYr;
    private ValueAnimator.AnimatorUpdateListener hYs;
    private AnimatorListenerAdapter hYt;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.hYe = 7200.0f;
        this.hYf = 10000;
        this.hYg = 30.0f;
        this.hYh = 50;
        this.hYi = 300.0f;
        this.hYj = 400;
        this.alv = -90.0f;
        this.hYl = this.alv;
        this.hYm = 60.0f;
        this.hYs = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.hYn != 1 && VideoLoadingProgressView.this.hYn != 2) {
                    if (VideoLoadingProgressView.this.hYn == 3) {
                        VideoLoadingProgressView.this.hYm = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.hYl = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alv;
                    VideoLoadingProgressView.this.hYm = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.hYt = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.hYn == 2) {
                    VideoLoadingProgressView.this.bTP();
                } else if (VideoLoadingProgressView.this.hYn == 3 && VideoLoadingProgressView.this.hYo != null) {
                    VideoLoadingProgressView.this.hYo.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hYe = 7200.0f;
        this.hYf = 10000;
        this.hYg = 30.0f;
        this.hYh = 50;
        this.hYi = 300.0f;
        this.hYj = 400;
        this.alv = -90.0f;
        this.hYl = this.alv;
        this.hYm = 60.0f;
        this.hYs = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.hYn != 1 && VideoLoadingProgressView.this.hYn != 2) {
                    if (VideoLoadingProgressView.this.hYn == 3) {
                        VideoLoadingProgressView.this.hYm = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.hYl = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alv;
                    VideoLoadingProgressView.this.hYm = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.hYt = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.hYn == 2) {
                    VideoLoadingProgressView.this.bTP();
                } else if (VideoLoadingProgressView.this.hYn == 3 && VideoLoadingProgressView.this.hYo != null) {
                    VideoLoadingProgressView.this.hYo.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hYe = 7200.0f;
        this.hYf = 10000;
        this.hYg = 30.0f;
        this.hYh = 50;
        this.hYi = 300.0f;
        this.hYj = 400;
        this.alv = -90.0f;
        this.hYl = this.alv;
        this.hYm = 60.0f;
        this.hYs = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.hYn != 1 && VideoLoadingProgressView.this.hYn != 2) {
                    if (VideoLoadingProgressView.this.hYn == 3) {
                        VideoLoadingProgressView.this.hYm = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.hYl = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.alv;
                    VideoLoadingProgressView.this.hYm = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.hYt = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.hYn == 2) {
                    VideoLoadingProgressView.this.bTP();
                } else if (VideoLoadingProgressView.this.hYn == 3 && VideoLoadingProgressView.this.hYo != null) {
                    VideoLoadingProgressView.this.hYo.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.dwS = getContext().getResources().getColor(d.C0277d.cp_btn_a);
        this.hYk = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds2);
        this.mPaint.setColor(this.dwS);
        this.mPaint.setStrokeWidth(this.hYk);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bTQ();
        this.hYn = 1;
        this.hYl = -90.0f;
        this.alv = -90.0f;
        this.hYp = ValueAnimator.ofFloat(this.hYe);
        this.hYp.setDuration(this.hYf);
        this.hYp.addListener(this.hYt);
        this.hYp.addUpdateListener(this.hYs);
        this.hYp.start();
        setVisibility(0);
        invalidate();
    }

    public void bTL() {
        bTQ();
        this.hYn = 2;
        this.alv = this.hYl;
        this.hYq = ValueAnimator.ofFloat(-this.hYg);
        this.hYq.setDuration(this.hYh);
        this.hYq.addListener(this.hYt);
        this.hYq.addUpdateListener(this.hYs);
        this.hYq.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTP() {
        bTQ();
        this.hYn = 3;
        this.alv = this.hYl;
        this.hYr = ValueAnimator.ofFloat(this.hYi);
        this.hYr.setDuration(this.hYj);
        this.hYr.addListener(this.hYt);
        this.hYr.addUpdateListener(this.hYs);
        this.hYr.start();
    }

    public void bTN() {
        bTQ();
        setVisibility(8);
    }

    private void bTQ() {
        if (this.hYp != null) {
            this.hYp.cancel();
        }
        if (this.hYq != null) {
            this.hYq.cancel();
        }
        if (this.hYr != null) {
            this.hYr.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.hYo = aVar;
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
        canvas.drawArc(this.mRect, this.hYl, this.hYm, false, this.mPaint);
    }
}
