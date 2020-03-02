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
    private float bgC;
    private int dcy;
    private int eWe;
    private ValueAnimator.AnimatorUpdateListener jwA;
    private AnimatorListenerAdapter jwB;
    private float jwn;
    private int jwo;
    private float jwp;
    private int jwq;
    private float jwr;
    private int jws;
    private float jwt;
    private float jwu;
    private int jwv;
    private a jww;
    private ValueAnimator jwx;
    private ValueAnimator jwy;
    private ValueAnimator jwz;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.jwn = 7200.0f;
        this.jwo = 10000;
        this.jwp = 30.0f;
        this.jwq = 50;
        this.jwr = 300.0f;
        this.jws = 400;
        this.bgC = -90.0f;
        this.jwt = this.bgC;
        this.jwu = 60.0f;
        this.jwA = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jwv != 1 && VideoLoadingProgressView.this.jwv != 2) {
                    if (VideoLoadingProgressView.this.jwv == 3) {
                        VideoLoadingProgressView.this.jwu = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jwt = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bgC;
                    VideoLoadingProgressView.this.jwu = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jwB = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jwv == 2) {
                    VideoLoadingProgressView.this.czq();
                } else if (VideoLoadingProgressView.this.jwv == 3 && VideoLoadingProgressView.this.jww != null) {
                    VideoLoadingProgressView.this.jww.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jwn = 7200.0f;
        this.jwo = 10000;
        this.jwp = 30.0f;
        this.jwq = 50;
        this.jwr = 300.0f;
        this.jws = 400;
        this.bgC = -90.0f;
        this.jwt = this.bgC;
        this.jwu = 60.0f;
        this.jwA = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jwv != 1 && VideoLoadingProgressView.this.jwv != 2) {
                    if (VideoLoadingProgressView.this.jwv == 3) {
                        VideoLoadingProgressView.this.jwu = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jwt = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bgC;
                    VideoLoadingProgressView.this.jwu = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jwB = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jwv == 2) {
                    VideoLoadingProgressView.this.czq();
                } else if (VideoLoadingProgressView.this.jwv == 3 && VideoLoadingProgressView.this.jww != null) {
                    VideoLoadingProgressView.this.jww.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jwn = 7200.0f;
        this.jwo = 10000;
        this.jwp = 30.0f;
        this.jwq = 50;
        this.jwr = 300.0f;
        this.jws = 400;
        this.bgC = -90.0f;
        this.jwt = this.bgC;
        this.jwu = 60.0f;
        this.jwA = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jwv != 1 && VideoLoadingProgressView.this.jwv != 2) {
                    if (VideoLoadingProgressView.this.jwv == 3) {
                        VideoLoadingProgressView.this.jwu = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jwt = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bgC;
                    VideoLoadingProgressView.this.jwu = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jwB = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jwv == 2) {
                    VideoLoadingProgressView.this.czq();
                } else if (VideoLoadingProgressView.this.jwv == 3 && VideoLoadingProgressView.this.jww != null) {
                    VideoLoadingProgressView.this.jww.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.WF = new RectF();
        this.mPaint = new Paint(1);
        this.eWe = getContext().getResources().getColor(R.color.cp_cont_a);
        this.dcy = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.eWe);
        this.mPaint.setStrokeWidth(this.dcy);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        czr();
        this.jwv = 1;
        this.jwt = -90.0f;
        this.bgC = -90.0f;
        this.jwx = ValueAnimator.ofFloat(this.jwn);
        this.jwx.setDuration(this.jwo);
        this.jwx.addListener(this.jwB);
        this.jwx.addUpdateListener(this.jwA);
        this.jwx.start();
        setVisibility(0);
        invalidate();
    }

    public void czn() {
        czr();
        this.jwv = 2;
        this.bgC = this.jwt;
        this.jwy = ValueAnimator.ofFloat(-this.jwp);
        this.jwy.setDuration(this.jwq);
        this.jwy.addListener(this.jwB);
        this.jwy.addUpdateListener(this.jwA);
        this.jwy.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czq() {
        czr();
        this.jwv = 3;
        this.bgC = this.jwt;
        this.jwz = ValueAnimator.ofFloat(this.jwr);
        this.jwz.setDuration(this.jws);
        this.jwz.addListener(this.jwB);
        this.jwz.addUpdateListener(this.jwA);
        this.jwz.start();
    }

    public void czp() {
        czr();
        setVisibility(8);
    }

    private void czr() {
        if (this.jwx != null) {
            this.jwx.cancel();
        }
        if (this.jwy != null) {
            this.jwy.cancel();
        }
        if (this.jwz != null) {
            this.jwz.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.jww = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        czr();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.WF.left = 1;
        this.WF.top = 1;
        this.WF.right = getWidth() - 1;
        this.WF.bottom = getHeight() - 1;
        canvas.drawArc(this.WF, this.jwt, this.jwu, false, this.mPaint);
    }
}
