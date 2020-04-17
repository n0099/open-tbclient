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
    private RectF aoR;
    private float bFb;
    private int dCy;
    private int fBd;
    private float khT;
    private int khU;
    private float khV;
    private int khW;
    private float khX;
    private int khY;
    private float khZ;
    private float kia;
    private int kib;
    private a kic;
    private ValueAnimator kie;
    private ValueAnimator kif;
    private ValueAnimator kig;
    private ValueAnimator.AnimatorUpdateListener kih;
    private AnimatorListenerAdapter kii;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.khT = 7200.0f;
        this.khU = 10000;
        this.khV = 30.0f;
        this.khW = 50;
        this.khX = 300.0f;
        this.khY = 400;
        this.bFb = -90.0f;
        this.khZ = this.bFb;
        this.kia = 60.0f;
        this.kih = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.kib != 1 && VideoLoadingProgressView.this.kib != 2) {
                    if (VideoLoadingProgressView.this.kib == 3) {
                        VideoLoadingProgressView.this.kia = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.khZ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bFb;
                    VideoLoadingProgressView.this.kia = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.kii = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.kib == 2) {
                    VideoLoadingProgressView.this.cKp();
                } else if (VideoLoadingProgressView.this.kib == 3 && VideoLoadingProgressView.this.kic != null) {
                    VideoLoadingProgressView.this.kic.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.khT = 7200.0f;
        this.khU = 10000;
        this.khV = 30.0f;
        this.khW = 50;
        this.khX = 300.0f;
        this.khY = 400;
        this.bFb = -90.0f;
        this.khZ = this.bFb;
        this.kia = 60.0f;
        this.kih = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.kib != 1 && VideoLoadingProgressView.this.kib != 2) {
                    if (VideoLoadingProgressView.this.kib == 3) {
                        VideoLoadingProgressView.this.kia = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.khZ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bFb;
                    VideoLoadingProgressView.this.kia = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.kii = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.kib == 2) {
                    VideoLoadingProgressView.this.cKp();
                } else if (VideoLoadingProgressView.this.kib == 3 && VideoLoadingProgressView.this.kic != null) {
                    VideoLoadingProgressView.this.kic.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.khT = 7200.0f;
        this.khU = 10000;
        this.khV = 30.0f;
        this.khW = 50;
        this.khX = 300.0f;
        this.khY = 400;
        this.bFb = -90.0f;
        this.khZ = this.bFb;
        this.kia = 60.0f;
        this.kih = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.kib != 1 && VideoLoadingProgressView.this.kib != 2) {
                    if (VideoLoadingProgressView.this.kib == 3) {
                        VideoLoadingProgressView.this.kia = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.khZ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bFb;
                    VideoLoadingProgressView.this.kia = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.kii = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.kib == 2) {
                    VideoLoadingProgressView.this.cKp();
                } else if (VideoLoadingProgressView.this.kib == 3 && VideoLoadingProgressView.this.kic != null) {
                    VideoLoadingProgressView.this.kic.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.aoR = new RectF();
        this.mPaint = new Paint(1);
        this.fBd = getContext().getResources().getColor(R.color.cp_cont_a);
        this.dCy = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.fBd);
        this.mPaint.setStrokeWidth(this.dCy);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        cKq();
        this.kib = 1;
        this.khZ = -90.0f;
        this.bFb = -90.0f;
        this.kie = ValueAnimator.ofFloat(this.khT);
        this.kie.setDuration(this.khU);
        this.kie.addListener(this.kii);
        this.kie.addUpdateListener(this.kih);
        this.kie.start();
        setVisibility(0);
        invalidate();
    }

    public void cKm() {
        cKq();
        this.kib = 2;
        this.bFb = this.khZ;
        this.kif = ValueAnimator.ofFloat(-this.khV);
        this.kif.setDuration(this.khW);
        this.kif.addListener(this.kii);
        this.kif.addUpdateListener(this.kih);
        this.kif.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKp() {
        cKq();
        this.kib = 3;
        this.bFb = this.khZ;
        this.kig = ValueAnimator.ofFloat(this.khX);
        this.kig.setDuration(this.khY);
        this.kig.addListener(this.kii);
        this.kig.addUpdateListener(this.kih);
        this.kig.start();
    }

    public void cKo() {
        cKq();
        setVisibility(8);
    }

    private void cKq() {
        if (this.kie != null) {
            this.kie.cancel();
        }
        if (this.kif != null) {
            this.kif.cancel();
        }
        if (this.kig != null) {
            this.kig.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.kic = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cKq();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.aoR.left = 1;
        this.aoR.top = 1;
        this.aoR.right = getWidth() - 1;
        this.aoR.bottom = getHeight() - 1;
        canvas.drawArc(this.aoR, this.khZ, this.kia, false, this.mPaint);
    }
}
