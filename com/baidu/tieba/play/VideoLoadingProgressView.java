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
    private int bCz;
    private float fQA;
    private int fQB;
    private a fQC;
    private ValueAnimator fQD;
    private ValueAnimator fQE;
    private ValueAnimator fQF;
    private ValueAnimator.AnimatorUpdateListener fQG;
    private AnimatorListenerAdapter fQH;
    private float fQr;
    private int fQs;
    private float fQt;
    private int fQu;
    private float fQv;
    private int fQw;
    private int fQx;
    private float fQy;
    private float fQz;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.fQr = 7200.0f;
        this.fQs = 10000;
        this.fQt = 30.0f;
        this.fQu = 50;
        this.fQv = 300.0f;
        this.fQw = HttpStatus.SC_BAD_REQUEST;
        this.fQy = -90.0f;
        this.fQz = this.fQy;
        this.fQA = 60.0f;
        this.fQG = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.fQB != 1 && VideoLoadingProgressView.this.fQB != 2) {
                    if (VideoLoadingProgressView.this.fQB == 3) {
                        VideoLoadingProgressView.this.fQA = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.fQz = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.fQy;
                    VideoLoadingProgressView.this.fQA = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.fQH = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.fQB == 2) {
                    VideoLoadingProgressView.this.bgZ();
                } else if (VideoLoadingProgressView.this.fQB == 3 && VideoLoadingProgressView.this.fQC != null) {
                    VideoLoadingProgressView.this.fQC.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fQr = 7200.0f;
        this.fQs = 10000;
        this.fQt = 30.0f;
        this.fQu = 50;
        this.fQv = 300.0f;
        this.fQw = HttpStatus.SC_BAD_REQUEST;
        this.fQy = -90.0f;
        this.fQz = this.fQy;
        this.fQA = 60.0f;
        this.fQG = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.fQB != 1 && VideoLoadingProgressView.this.fQB != 2) {
                    if (VideoLoadingProgressView.this.fQB == 3) {
                        VideoLoadingProgressView.this.fQA = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.fQz = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.fQy;
                    VideoLoadingProgressView.this.fQA = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.fQH = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.fQB == 2) {
                    VideoLoadingProgressView.this.bgZ();
                } else if (VideoLoadingProgressView.this.fQB == 3 && VideoLoadingProgressView.this.fQC != null) {
                    VideoLoadingProgressView.this.fQC.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fQr = 7200.0f;
        this.fQs = 10000;
        this.fQt = 30.0f;
        this.fQu = 50;
        this.fQv = 300.0f;
        this.fQw = HttpStatus.SC_BAD_REQUEST;
        this.fQy = -90.0f;
        this.fQz = this.fQy;
        this.fQA = 60.0f;
        this.fQG = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.fQB != 1 && VideoLoadingProgressView.this.fQB != 2) {
                    if (VideoLoadingProgressView.this.fQB == 3) {
                        VideoLoadingProgressView.this.fQA = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.fQz = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.fQy;
                    VideoLoadingProgressView.this.fQA = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.fQH = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.fQB == 2) {
                    VideoLoadingProgressView.this.bgZ();
                } else if (VideoLoadingProgressView.this.fQB == 3 && VideoLoadingProgressView.this.fQC != null) {
                    VideoLoadingProgressView.this.fQC.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.bCz = getContext().getResources().getColor(d.C0126d.cp_cont_i);
        this.fQx = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds2);
        this.mPaint.setColor(this.bCz);
        this.mPaint.setStrokeWidth(this.fQx);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bha();
        this.fQB = 1;
        this.fQz = -90.0f;
        this.fQy = -90.0f;
        this.fQD = ValueAnimator.ofFloat(this.fQr);
        this.fQD.setDuration(this.fQs);
        this.fQD.addListener(this.fQH);
        this.fQD.addUpdateListener(this.fQG);
        this.fQD.start();
        setVisibility(0);
        invalidate();
    }

    public void bgV() {
        bha();
        this.fQB = 2;
        this.fQy = this.fQz;
        this.fQE = ValueAnimator.ofFloat(-this.fQt);
        this.fQE.setDuration(this.fQu);
        this.fQE.addListener(this.fQH);
        this.fQE.addUpdateListener(this.fQG);
        this.fQE.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgZ() {
        bha();
        this.fQB = 3;
        this.fQy = this.fQz;
        this.fQF = ValueAnimator.ofFloat(this.fQv);
        this.fQF.setDuration(this.fQw);
        this.fQF.addListener(this.fQH);
        this.fQF.addUpdateListener(this.fQG);
        this.fQF.start();
    }

    public void bgX() {
        bha();
        setVisibility(8);
    }

    private void bha() {
        if (this.fQD != null) {
            this.fQD.cancel();
        }
        if (this.fQE != null) {
            this.fQE.cancel();
        }
        if (this.fQF != null) {
            this.fQF.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.fQC = aVar;
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
        canvas.drawArc(this.mRect, this.fQz, this.fQA, false, this.mPaint);
    }
}
