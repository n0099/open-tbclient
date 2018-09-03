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
import com.baidu.tieba.f;
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class VideoLoadingProgressView extends View {
    private int bOA;
    private float ghg;
    private int ghh;
    private float ghi;
    private int ghj;
    private float ghk;
    private int ghl;
    private int ghm;
    private float ghn;
    private float gho;
    private float ghp;
    private int ghq;
    private a ghr;
    private ValueAnimator ghs;
    private ValueAnimator ght;
    private ValueAnimator ghu;
    private ValueAnimator.AnimatorUpdateListener ghv;
    private AnimatorListenerAdapter ghw;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.ghg = 7200.0f;
        this.ghh = 10000;
        this.ghi = 30.0f;
        this.ghj = 50;
        this.ghk = 300.0f;
        this.ghl = HttpStatus.SC_BAD_REQUEST;
        this.ghn = -90.0f;
        this.gho = this.ghn;
        this.ghp = 60.0f;
        this.ghv = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.ghq != 1 && VideoLoadingProgressView.this.ghq != 2) {
                    if (VideoLoadingProgressView.this.ghq == 3) {
                        VideoLoadingProgressView.this.ghp = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gho = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.ghn;
                    VideoLoadingProgressView.this.ghp = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.ghw = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.ghq == 2) {
                    VideoLoadingProgressView.this.bkR();
                } else if (VideoLoadingProgressView.this.ghq == 3 && VideoLoadingProgressView.this.ghr != null) {
                    VideoLoadingProgressView.this.ghr.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ghg = 7200.0f;
        this.ghh = 10000;
        this.ghi = 30.0f;
        this.ghj = 50;
        this.ghk = 300.0f;
        this.ghl = HttpStatus.SC_BAD_REQUEST;
        this.ghn = -90.0f;
        this.gho = this.ghn;
        this.ghp = 60.0f;
        this.ghv = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.ghq != 1 && VideoLoadingProgressView.this.ghq != 2) {
                    if (VideoLoadingProgressView.this.ghq == 3) {
                        VideoLoadingProgressView.this.ghp = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gho = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.ghn;
                    VideoLoadingProgressView.this.ghp = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.ghw = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.ghq == 2) {
                    VideoLoadingProgressView.this.bkR();
                } else if (VideoLoadingProgressView.this.ghq == 3 && VideoLoadingProgressView.this.ghr != null) {
                    VideoLoadingProgressView.this.ghr.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ghg = 7200.0f;
        this.ghh = 10000;
        this.ghi = 30.0f;
        this.ghj = 50;
        this.ghk = 300.0f;
        this.ghl = HttpStatus.SC_BAD_REQUEST;
        this.ghn = -90.0f;
        this.gho = this.ghn;
        this.ghp = 60.0f;
        this.ghv = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.ghq != 1 && VideoLoadingProgressView.this.ghq != 2) {
                    if (VideoLoadingProgressView.this.ghq == 3) {
                        VideoLoadingProgressView.this.ghp = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gho = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.ghn;
                    VideoLoadingProgressView.this.ghp = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.ghw = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.ghq == 2) {
                    VideoLoadingProgressView.this.bkR();
                } else if (VideoLoadingProgressView.this.ghq == 3 && VideoLoadingProgressView.this.ghr != null) {
                    VideoLoadingProgressView.this.ghr.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.bOA = getContext().getResources().getColor(f.d.cp_cont_i);
        this.ghm = com.baidu.adp.lib.util.l.f(getContext(), f.e.ds2);
        this.mPaint.setColor(this.bOA);
        this.mPaint.setStrokeWidth(this.ghm);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bkS();
        this.ghq = 1;
        this.gho = -90.0f;
        this.ghn = -90.0f;
        this.ghs = ValueAnimator.ofFloat(this.ghg);
        this.ghs.setDuration(this.ghh);
        this.ghs.addListener(this.ghw);
        this.ghs.addUpdateListener(this.ghv);
        this.ghs.start();
        setVisibility(0);
        invalidate();
    }

    public void bkN() {
        bkS();
        this.ghq = 2;
        this.ghn = this.gho;
        this.ght = ValueAnimator.ofFloat(-this.ghi);
        this.ght.setDuration(this.ghj);
        this.ght.addListener(this.ghw);
        this.ght.addUpdateListener(this.ghv);
        this.ght.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkR() {
        bkS();
        this.ghq = 3;
        this.ghn = this.gho;
        this.ghu = ValueAnimator.ofFloat(this.ghk);
        this.ghu.setDuration(this.ghl);
        this.ghu.addListener(this.ghw);
        this.ghu.addUpdateListener(this.ghv);
        this.ghu.start();
    }

    public void bkP() {
        bkS();
        setVisibility(8);
    }

    private void bkS() {
        if (this.ghs != null) {
            this.ghs.cancel();
        }
        if (this.ght != null) {
            this.ght.cancel();
        }
        if (this.ghu != null) {
            this.ghu.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.ghr = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bkS();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.gho, this.ghp, false, this.mPaint);
    }
}
