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
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class VideoLoadingProgressView extends View {
    private int bOB;
    private float ghh;
    private int ghi;
    private float ghj;
    private int ghk;
    private float ghl;
    private int ghm;
    private int ghn;
    private float gho;
    private float ghp;
    private float ghq;
    private int ghr;
    private a ghs;
    private ValueAnimator ght;
    private ValueAnimator ghu;
    private ValueAnimator ghv;
    private ValueAnimator.AnimatorUpdateListener ghw;
    private AnimatorListenerAdapter ghx;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.ghh = 7200.0f;
        this.ghi = 10000;
        this.ghj = 30.0f;
        this.ghk = 50;
        this.ghl = 300.0f;
        this.ghm = HttpStatus.SC_BAD_REQUEST;
        this.gho = -90.0f;
        this.ghp = this.gho;
        this.ghq = 60.0f;
        this.ghw = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.ghr != 1 && VideoLoadingProgressView.this.ghr != 2) {
                    if (VideoLoadingProgressView.this.ghr == 3) {
                        VideoLoadingProgressView.this.ghq = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.ghp = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gho;
                    VideoLoadingProgressView.this.ghq = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.ghx = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.ghr == 2) {
                    VideoLoadingProgressView.this.bkU();
                } else if (VideoLoadingProgressView.this.ghr == 3 && VideoLoadingProgressView.this.ghs != null) {
                    VideoLoadingProgressView.this.ghs.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ghh = 7200.0f;
        this.ghi = 10000;
        this.ghj = 30.0f;
        this.ghk = 50;
        this.ghl = 300.0f;
        this.ghm = HttpStatus.SC_BAD_REQUEST;
        this.gho = -90.0f;
        this.ghp = this.gho;
        this.ghq = 60.0f;
        this.ghw = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.ghr != 1 && VideoLoadingProgressView.this.ghr != 2) {
                    if (VideoLoadingProgressView.this.ghr == 3) {
                        VideoLoadingProgressView.this.ghq = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.ghp = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gho;
                    VideoLoadingProgressView.this.ghq = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.ghx = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.ghr == 2) {
                    VideoLoadingProgressView.this.bkU();
                } else if (VideoLoadingProgressView.this.ghr == 3 && VideoLoadingProgressView.this.ghs != null) {
                    VideoLoadingProgressView.this.ghs.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ghh = 7200.0f;
        this.ghi = 10000;
        this.ghj = 30.0f;
        this.ghk = 50;
        this.ghl = 300.0f;
        this.ghm = HttpStatus.SC_BAD_REQUEST;
        this.gho = -90.0f;
        this.ghp = this.gho;
        this.ghq = 60.0f;
        this.ghw = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.ghr != 1 && VideoLoadingProgressView.this.ghr != 2) {
                    if (VideoLoadingProgressView.this.ghr == 3) {
                        VideoLoadingProgressView.this.ghq = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.ghp = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gho;
                    VideoLoadingProgressView.this.ghq = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.ghx = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.ghr == 2) {
                    VideoLoadingProgressView.this.bkU();
                } else if (VideoLoadingProgressView.this.ghr == 3 && VideoLoadingProgressView.this.ghs != null) {
                    VideoLoadingProgressView.this.ghs.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.bOB = getContext().getResources().getColor(d.C0140d.cp_cont_i);
        this.ghn = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds2);
        this.mPaint.setColor(this.bOB);
        this.mPaint.setStrokeWidth(this.ghn);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bkV();
        this.ghr = 1;
        this.ghp = -90.0f;
        this.gho = -90.0f;
        this.ght = ValueAnimator.ofFloat(this.ghh);
        this.ght.setDuration(this.ghi);
        this.ght.addListener(this.ghx);
        this.ght.addUpdateListener(this.ghw);
        this.ght.start();
        setVisibility(0);
        invalidate();
    }

    public void bkQ() {
        bkV();
        this.ghr = 2;
        this.gho = this.ghp;
        this.ghu = ValueAnimator.ofFloat(-this.ghj);
        this.ghu.setDuration(this.ghk);
        this.ghu.addListener(this.ghx);
        this.ghu.addUpdateListener(this.ghw);
        this.ghu.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkU() {
        bkV();
        this.ghr = 3;
        this.gho = this.ghp;
        this.ghv = ValueAnimator.ofFloat(this.ghl);
        this.ghv.setDuration(this.ghm);
        this.ghv.addListener(this.ghx);
        this.ghv.addUpdateListener(this.ghw);
        this.ghv.start();
    }

    public void bkS() {
        bkV();
        setVisibility(8);
    }

    private void bkV() {
        if (this.ght != null) {
            this.ght.cancel();
        }
        if (this.ghu != null) {
            this.ghu.cancel();
        }
        if (this.ghv != null) {
            this.ghv.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.ghs = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bkV();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.ghp, this.ghq, false, this.mPaint);
    }
}
