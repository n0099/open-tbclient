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
    private int bCx;
    private ValueAnimator fQA;
    private ValueAnimator fQB;
    private ValueAnimator fQC;
    private ValueAnimator.AnimatorUpdateListener fQD;
    private AnimatorListenerAdapter fQE;
    private float fQo;
    private int fQp;
    private float fQq;
    private int fQr;
    private float fQs;
    private int fQt;
    private int fQu;
    private float fQv;
    private float fQw;
    private float fQx;
    private int fQy;
    private a fQz;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.fQo = 7200.0f;
        this.fQp = 10000;
        this.fQq = 30.0f;
        this.fQr = 50;
        this.fQs = 300.0f;
        this.fQt = HttpStatus.SC_BAD_REQUEST;
        this.fQv = -90.0f;
        this.fQw = this.fQv;
        this.fQx = 60.0f;
        this.fQD = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.fQy != 1 && VideoLoadingProgressView.this.fQy != 2) {
                    if (VideoLoadingProgressView.this.fQy == 3) {
                        VideoLoadingProgressView.this.fQx = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.fQw = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.fQv;
                    VideoLoadingProgressView.this.fQx = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.fQE = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.fQy == 2) {
                    VideoLoadingProgressView.this.bgZ();
                } else if (VideoLoadingProgressView.this.fQy == 3 && VideoLoadingProgressView.this.fQz != null) {
                    VideoLoadingProgressView.this.fQz.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fQo = 7200.0f;
        this.fQp = 10000;
        this.fQq = 30.0f;
        this.fQr = 50;
        this.fQs = 300.0f;
        this.fQt = HttpStatus.SC_BAD_REQUEST;
        this.fQv = -90.0f;
        this.fQw = this.fQv;
        this.fQx = 60.0f;
        this.fQD = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.fQy != 1 && VideoLoadingProgressView.this.fQy != 2) {
                    if (VideoLoadingProgressView.this.fQy == 3) {
                        VideoLoadingProgressView.this.fQx = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.fQw = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.fQv;
                    VideoLoadingProgressView.this.fQx = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.fQE = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.fQy == 2) {
                    VideoLoadingProgressView.this.bgZ();
                } else if (VideoLoadingProgressView.this.fQy == 3 && VideoLoadingProgressView.this.fQz != null) {
                    VideoLoadingProgressView.this.fQz.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fQo = 7200.0f;
        this.fQp = 10000;
        this.fQq = 30.0f;
        this.fQr = 50;
        this.fQs = 300.0f;
        this.fQt = HttpStatus.SC_BAD_REQUEST;
        this.fQv = -90.0f;
        this.fQw = this.fQv;
        this.fQx = 60.0f;
        this.fQD = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.fQy != 1 && VideoLoadingProgressView.this.fQy != 2) {
                    if (VideoLoadingProgressView.this.fQy == 3) {
                        VideoLoadingProgressView.this.fQx = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.fQw = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.fQv;
                    VideoLoadingProgressView.this.fQx = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.fQE = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.fQy == 2) {
                    VideoLoadingProgressView.this.bgZ();
                } else if (VideoLoadingProgressView.this.fQy == 3 && VideoLoadingProgressView.this.fQz != null) {
                    VideoLoadingProgressView.this.fQz.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.bCx = getContext().getResources().getColor(d.C0126d.cp_cont_i);
        this.fQu = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds2);
        this.mPaint.setColor(this.bCx);
        this.mPaint.setStrokeWidth(this.fQu);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bha();
        this.fQy = 1;
        this.fQw = -90.0f;
        this.fQv = -90.0f;
        this.fQA = ValueAnimator.ofFloat(this.fQo);
        this.fQA.setDuration(this.fQp);
        this.fQA.addListener(this.fQE);
        this.fQA.addUpdateListener(this.fQD);
        this.fQA.start();
        setVisibility(0);
        invalidate();
    }

    public void bgV() {
        bha();
        this.fQy = 2;
        this.fQv = this.fQw;
        this.fQB = ValueAnimator.ofFloat(-this.fQq);
        this.fQB.setDuration(this.fQr);
        this.fQB.addListener(this.fQE);
        this.fQB.addUpdateListener(this.fQD);
        this.fQB.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgZ() {
        bha();
        this.fQy = 3;
        this.fQv = this.fQw;
        this.fQC = ValueAnimator.ofFloat(this.fQs);
        this.fQC.setDuration(this.fQt);
        this.fQC.addListener(this.fQE);
        this.fQC.addUpdateListener(this.fQD);
        this.fQC.start();
    }

    public void bgX() {
        bha();
        setVisibility(8);
    }

    private void bha() {
        if (this.fQA != null) {
            this.fQA.cancel();
        }
        if (this.fQB != null) {
            this.fQB.cancel();
        }
        if (this.fQC != null) {
            this.fQC.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.fQz = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bha();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.fQw, this.fQx, false, this.mPaint);
    }
}
