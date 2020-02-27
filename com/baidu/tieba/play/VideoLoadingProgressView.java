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
    private RectF WF;
    private float bgB;
    private int dcx;
    private int eWd;
    private float jwl;
    private int jwm;
    private float jwn;
    private int jwo;
    private float jwp;
    private int jwq;
    private float jwr;
    private float jws;
    private int jwt;
    private a jwu;
    private ValueAnimator jwv;
    private ValueAnimator jww;
    private ValueAnimator jwx;
    private ValueAnimator.AnimatorUpdateListener jwy;
    private AnimatorListenerAdapter jwz;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.jwl = 7200.0f;
        this.jwm = 10000;
        this.jwn = 30.0f;
        this.jwo = 50;
        this.jwp = 300.0f;
        this.jwq = 400;
        this.bgB = -90.0f;
        this.jwr = this.bgB;
        this.jws = 60.0f;
        this.jwy = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jwt != 1 && VideoLoadingProgressView.this.jwt != 2) {
                    if (VideoLoadingProgressView.this.jwt == 3) {
                        VideoLoadingProgressView.this.jws = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jwr = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bgB;
                    VideoLoadingProgressView.this.jws = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jwz = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jwt == 2) {
                    VideoLoadingProgressView.this.czo();
                } else if (VideoLoadingProgressView.this.jwt == 3 && VideoLoadingProgressView.this.jwu != null) {
                    VideoLoadingProgressView.this.jwu.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jwl = 7200.0f;
        this.jwm = 10000;
        this.jwn = 30.0f;
        this.jwo = 50;
        this.jwp = 300.0f;
        this.jwq = 400;
        this.bgB = -90.0f;
        this.jwr = this.bgB;
        this.jws = 60.0f;
        this.jwy = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jwt != 1 && VideoLoadingProgressView.this.jwt != 2) {
                    if (VideoLoadingProgressView.this.jwt == 3) {
                        VideoLoadingProgressView.this.jws = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jwr = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bgB;
                    VideoLoadingProgressView.this.jws = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jwz = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jwt == 2) {
                    VideoLoadingProgressView.this.czo();
                } else if (VideoLoadingProgressView.this.jwt == 3 && VideoLoadingProgressView.this.jwu != null) {
                    VideoLoadingProgressView.this.jwu.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jwl = 7200.0f;
        this.jwm = 10000;
        this.jwn = 30.0f;
        this.jwo = 50;
        this.jwp = 300.0f;
        this.jwq = 400;
        this.bgB = -90.0f;
        this.jwr = this.bgB;
        this.jws = 60.0f;
        this.jwy = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jwt != 1 && VideoLoadingProgressView.this.jwt != 2) {
                    if (VideoLoadingProgressView.this.jwt == 3) {
                        VideoLoadingProgressView.this.jws = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jwr = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bgB;
                    VideoLoadingProgressView.this.jws = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jwz = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jwt == 2) {
                    VideoLoadingProgressView.this.czo();
                } else if (VideoLoadingProgressView.this.jwt == 3 && VideoLoadingProgressView.this.jwu != null) {
                    VideoLoadingProgressView.this.jwu.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.WF = new RectF();
        this.mPaint = new Paint(1);
        this.eWd = getContext().getResources().getColor(R.color.cp_cont_a);
        this.dcx = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.eWd);
        this.mPaint.setStrokeWidth(this.dcx);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        czp();
        this.jwt = 1;
        this.jwr = -90.0f;
        this.bgB = -90.0f;
        this.jwv = ValueAnimator.ofFloat(this.jwl);
        this.jwv.setDuration(this.jwm);
        this.jwv.addListener(this.jwz);
        this.jwv.addUpdateListener(this.jwy);
        this.jwv.start();
        setVisibility(0);
        invalidate();
    }

    public void czl() {
        czp();
        this.jwt = 2;
        this.bgB = this.jwr;
        this.jww = ValueAnimator.ofFloat(-this.jwn);
        this.jww.setDuration(this.jwo);
        this.jww.addListener(this.jwz);
        this.jww.addUpdateListener(this.jwy);
        this.jww.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czo() {
        czp();
        this.jwt = 3;
        this.bgB = this.jwr;
        this.jwx = ValueAnimator.ofFloat(this.jwp);
        this.jwx.setDuration(this.jwq);
        this.jwx.addListener(this.jwz);
        this.jwx.addUpdateListener(this.jwy);
        this.jwx.start();
    }

    public void czn() {
        czp();
        setVisibility(8);
    }

    private void czp() {
        if (this.jwv != null) {
            this.jwv.cancel();
        }
        if (this.jww != null) {
            this.jww.cancel();
        }
        if (this.jwx != null) {
            this.jwx.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.jwu = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        czp();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.WF.left = 1;
        this.WF.top = 1;
        this.WF.right = getWidth() - 1;
        this.WF.bottom = getHeight() - 1;
        canvas.drawArc(this.WF, this.jwr, this.jws, false, this.mPaint);
    }
}
