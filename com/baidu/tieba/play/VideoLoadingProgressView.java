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
    private RectF atR;
    private float bNY;
    private int dQJ;
    private int fPw;
    private float kAY;
    private int kAZ;
    private float kBa;
    private int kBb;
    private float kBc;
    private int kBd;
    private float kBe;
    private float kBf;
    private int kBg;
    private a kBh;
    private ValueAnimator kBi;
    private ValueAnimator kBj;
    private ValueAnimator kBk;
    private ValueAnimator.AnimatorUpdateListener kBl;
    private AnimatorListenerAdapter kBm;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.kAY = 7200.0f;
        this.kAZ = 10000;
        this.kBa = 30.0f;
        this.kBb = 50;
        this.kBc = 300.0f;
        this.kBd = 400;
        this.bNY = -90.0f;
        this.kBe = this.bNY;
        this.kBf = 60.0f;
        this.kBl = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.kBg != 1 && VideoLoadingProgressView.this.kBg != 2) {
                    if (VideoLoadingProgressView.this.kBg == 3) {
                        VideoLoadingProgressView.this.kBf = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.kBe = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bNY;
                    VideoLoadingProgressView.this.kBf = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.kBm = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.kBg == 2) {
                    VideoLoadingProgressView.this.cRC();
                } else if (VideoLoadingProgressView.this.kBg == 3 && VideoLoadingProgressView.this.kBh != null) {
                    VideoLoadingProgressView.this.kBh.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kAY = 7200.0f;
        this.kAZ = 10000;
        this.kBa = 30.0f;
        this.kBb = 50;
        this.kBc = 300.0f;
        this.kBd = 400;
        this.bNY = -90.0f;
        this.kBe = this.bNY;
        this.kBf = 60.0f;
        this.kBl = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.kBg != 1 && VideoLoadingProgressView.this.kBg != 2) {
                    if (VideoLoadingProgressView.this.kBg == 3) {
                        VideoLoadingProgressView.this.kBf = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.kBe = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bNY;
                    VideoLoadingProgressView.this.kBf = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.kBm = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.kBg == 2) {
                    VideoLoadingProgressView.this.cRC();
                } else if (VideoLoadingProgressView.this.kBg == 3 && VideoLoadingProgressView.this.kBh != null) {
                    VideoLoadingProgressView.this.kBh.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kAY = 7200.0f;
        this.kAZ = 10000;
        this.kBa = 30.0f;
        this.kBb = 50;
        this.kBc = 300.0f;
        this.kBd = 400;
        this.bNY = -90.0f;
        this.kBe = this.bNY;
        this.kBf = 60.0f;
        this.kBl = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.kBg != 1 && VideoLoadingProgressView.this.kBg != 2) {
                    if (VideoLoadingProgressView.this.kBg == 3) {
                        VideoLoadingProgressView.this.kBf = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.kBe = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bNY;
                    VideoLoadingProgressView.this.kBf = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.kBm = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.kBg == 2) {
                    VideoLoadingProgressView.this.cRC();
                } else if (VideoLoadingProgressView.this.kBg == 3 && VideoLoadingProgressView.this.kBh != null) {
                    VideoLoadingProgressView.this.kBh.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.atR = new RectF();
        this.mPaint = new Paint(1);
        this.fPw = getContext().getResources().getColor(R.color.cp_cont_a);
        this.dQJ = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.fPw);
        this.mPaint.setStrokeWidth(this.dQJ);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        cRD();
        this.kBg = 1;
        this.kBe = -90.0f;
        this.bNY = -90.0f;
        this.kBi = ValueAnimator.ofFloat(this.kAY);
        this.kBi.setDuration(this.kAZ);
        this.kBi.addListener(this.kBm);
        this.kBi.addUpdateListener(this.kBl);
        this.kBi.start();
        setVisibility(0);
        invalidate();
    }

    public void cRz() {
        cRD();
        this.kBg = 2;
        this.bNY = this.kBe;
        this.kBj = ValueAnimator.ofFloat(-this.kBa);
        this.kBj.setDuration(this.kBb);
        this.kBj.addListener(this.kBm);
        this.kBj.addUpdateListener(this.kBl);
        this.kBj.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRC() {
        cRD();
        this.kBg = 3;
        this.bNY = this.kBe;
        this.kBk = ValueAnimator.ofFloat(this.kBc);
        this.kBk.setDuration(this.kBd);
        this.kBk.addListener(this.kBm);
        this.kBk.addUpdateListener(this.kBl);
        this.kBk.start();
    }

    public void cRB() {
        cRD();
        setVisibility(8);
    }

    private void cRD() {
        if (this.kBi != null) {
            this.kBi.cancel();
        }
        if (this.kBj != null) {
            this.kBj.cancel();
        }
        if (this.kBk != null) {
            this.kBk.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.kBh = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cRD();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.atR.left = 1;
        this.atR.top = 1;
        this.atR.right = getWidth() - 1;
        this.atR.bottom = getHeight() - 1;
        canvas.drawArc(this.atR, this.kBe, this.kBf, false, this.mPaint);
    }
}
