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
    private RectF aoX;
    private float bFg;
    private int dCC;
    private int fBi;
    private float khX;
    private int khY;
    private float khZ;
    private int kia;
    private float kib;
    private int kic;
    private float kie;
    private float kif;
    private int kig;
    private a kih;
    private ValueAnimator kii;
    private ValueAnimator kij;
    private ValueAnimator kik;
    private ValueAnimator.AnimatorUpdateListener kil;
    private AnimatorListenerAdapter kim;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.khX = 7200.0f;
        this.khY = 10000;
        this.khZ = 30.0f;
        this.kia = 50;
        this.kib = 300.0f;
        this.kic = 400;
        this.bFg = -90.0f;
        this.kie = this.bFg;
        this.kif = 60.0f;
        this.kil = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.kig != 1 && VideoLoadingProgressView.this.kig != 2) {
                    if (VideoLoadingProgressView.this.kig == 3) {
                        VideoLoadingProgressView.this.kif = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.kie = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bFg;
                    VideoLoadingProgressView.this.kif = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.kim = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.kig == 2) {
                    VideoLoadingProgressView.this.cKn();
                } else if (VideoLoadingProgressView.this.kig == 3 && VideoLoadingProgressView.this.kih != null) {
                    VideoLoadingProgressView.this.kih.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.khX = 7200.0f;
        this.khY = 10000;
        this.khZ = 30.0f;
        this.kia = 50;
        this.kib = 300.0f;
        this.kic = 400;
        this.bFg = -90.0f;
        this.kie = this.bFg;
        this.kif = 60.0f;
        this.kil = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.kig != 1 && VideoLoadingProgressView.this.kig != 2) {
                    if (VideoLoadingProgressView.this.kig == 3) {
                        VideoLoadingProgressView.this.kif = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.kie = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bFg;
                    VideoLoadingProgressView.this.kif = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.kim = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.kig == 2) {
                    VideoLoadingProgressView.this.cKn();
                } else if (VideoLoadingProgressView.this.kig == 3 && VideoLoadingProgressView.this.kih != null) {
                    VideoLoadingProgressView.this.kih.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.khX = 7200.0f;
        this.khY = 10000;
        this.khZ = 30.0f;
        this.kia = 50;
        this.kib = 300.0f;
        this.kic = 400;
        this.bFg = -90.0f;
        this.kie = this.bFg;
        this.kif = 60.0f;
        this.kil = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.kig != 1 && VideoLoadingProgressView.this.kig != 2) {
                    if (VideoLoadingProgressView.this.kig == 3) {
                        VideoLoadingProgressView.this.kif = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.kie = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bFg;
                    VideoLoadingProgressView.this.kif = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.kim = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.kig == 2) {
                    VideoLoadingProgressView.this.cKn();
                } else if (VideoLoadingProgressView.this.kig == 3 && VideoLoadingProgressView.this.kih != null) {
                    VideoLoadingProgressView.this.kih.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.aoX = new RectF();
        this.mPaint = new Paint(1);
        this.fBi = getContext().getResources().getColor(R.color.cp_cont_a);
        this.dCC = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.fBi);
        this.mPaint.setStrokeWidth(this.dCC);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        cKo();
        this.kig = 1;
        this.kie = -90.0f;
        this.bFg = -90.0f;
        this.kii = ValueAnimator.ofFloat(this.khX);
        this.kii.setDuration(this.khY);
        this.kii.addListener(this.kim);
        this.kii.addUpdateListener(this.kil);
        this.kii.start();
        setVisibility(0);
        invalidate();
    }

    public void cKk() {
        cKo();
        this.kig = 2;
        this.bFg = this.kie;
        this.kij = ValueAnimator.ofFloat(-this.khZ);
        this.kij.setDuration(this.kia);
        this.kij.addListener(this.kim);
        this.kij.addUpdateListener(this.kil);
        this.kij.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKn() {
        cKo();
        this.kig = 3;
        this.bFg = this.kie;
        this.kik = ValueAnimator.ofFloat(this.kib);
        this.kik.setDuration(this.kic);
        this.kik.addListener(this.kim);
        this.kik.addUpdateListener(this.kil);
        this.kik.start();
    }

    public void cKm() {
        cKo();
        setVisibility(8);
    }

    private void cKo() {
        if (this.kii != null) {
            this.kii.cancel();
        }
        if (this.kij != null) {
            this.kij.cancel();
        }
        if (this.kik != null) {
            this.kik.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.kih = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cKo();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.aoX.left = 1;
        this.aoX.top = 1;
        this.aoX.right = getWidth() - 1;
        this.aoX.bottom = getHeight() - 1;
        canvas.drawArc(this.aoX, this.kie, this.kif, false, this.mPaint);
    }
}
