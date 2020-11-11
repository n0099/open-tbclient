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
    private float cCd;
    private int eQo;
    private int hcv;
    private Paint mPaint;
    private RectF mRect;
    private float mjA;
    private int mjB;
    private float mjC;
    private int mjD;
    private float mjE;
    private float mjF;
    private int mjG;
    private a mjH;
    private ValueAnimator mjI;
    private ValueAnimator mjJ;
    private ValueAnimator mjK;
    private ValueAnimator.AnimatorUpdateListener mjL;
    private AnimatorListenerAdapter mjM;
    private float mjy;
    private int mjz;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.mjy = 7200.0f;
        this.mjz = 10000;
        this.mjA = 30.0f;
        this.mjB = 50;
        this.mjC = 300.0f;
        this.mjD = 400;
        this.cCd = -90.0f;
        this.mjE = this.cCd;
        this.mjF = 60.0f;
        this.mjL = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mjG != 1 && VideoLoadingProgressView.this.mjG != 2) {
                    if (VideoLoadingProgressView.this.mjG == 3) {
                        VideoLoadingProgressView.this.mjF = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mjE = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cCd;
                    VideoLoadingProgressView.this.mjF = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mjM = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mjG == 2) {
                    VideoLoadingProgressView.this.dxf();
                } else if (VideoLoadingProgressView.this.mjG == 3 && VideoLoadingProgressView.this.mjH != null) {
                    VideoLoadingProgressView.this.mjH.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mjy = 7200.0f;
        this.mjz = 10000;
        this.mjA = 30.0f;
        this.mjB = 50;
        this.mjC = 300.0f;
        this.mjD = 400;
        this.cCd = -90.0f;
        this.mjE = this.cCd;
        this.mjF = 60.0f;
        this.mjL = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mjG != 1 && VideoLoadingProgressView.this.mjG != 2) {
                    if (VideoLoadingProgressView.this.mjG == 3) {
                        VideoLoadingProgressView.this.mjF = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mjE = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cCd;
                    VideoLoadingProgressView.this.mjF = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mjM = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mjG == 2) {
                    VideoLoadingProgressView.this.dxf();
                } else if (VideoLoadingProgressView.this.mjG == 3 && VideoLoadingProgressView.this.mjH != null) {
                    VideoLoadingProgressView.this.mjH.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mjy = 7200.0f;
        this.mjz = 10000;
        this.mjA = 30.0f;
        this.mjB = 50;
        this.mjC = 300.0f;
        this.mjD = 400;
        this.cCd = -90.0f;
        this.mjE = this.cCd;
        this.mjF = 60.0f;
        this.mjL = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mjG != 1 && VideoLoadingProgressView.this.mjG != 2) {
                    if (VideoLoadingProgressView.this.mjG == 3) {
                        VideoLoadingProgressView.this.mjF = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mjE = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cCd;
                    VideoLoadingProgressView.this.mjF = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mjM = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mjG == 2) {
                    VideoLoadingProgressView.this.dxf();
                } else if (VideoLoadingProgressView.this.mjG == 3 && VideoLoadingProgressView.this.mjH != null) {
                    VideoLoadingProgressView.this.mjH.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.hcv = getContext().getResources().getColor(R.color.cp_cont_a);
        this.eQo = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.hcv);
        this.mPaint.setStrokeWidth(this.eQo);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        dxg();
        this.mjG = 1;
        this.mjE = -90.0f;
        this.cCd = -90.0f;
        this.mjI = ValueAnimator.ofFloat(this.mjy);
        this.mjI.setDuration(this.mjz);
        this.mjI.addListener(this.mjM);
        this.mjI.addUpdateListener(this.mjL);
        this.mjI.start();
        setVisibility(0);
        invalidate();
    }

    public void dxb() {
        dxg();
        this.mjG = 2;
        this.cCd = this.mjE;
        this.mjJ = ValueAnimator.ofFloat(-this.mjA);
        this.mjJ.setDuration(this.mjB);
        this.mjJ.addListener(this.mjM);
        this.mjJ.addUpdateListener(this.mjL);
        this.mjJ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxf() {
        dxg();
        this.mjG = 3;
        this.cCd = this.mjE;
        this.mjK = ValueAnimator.ofFloat(this.mjC);
        this.mjK.setDuration(this.mjD);
        this.mjK.addListener(this.mjM);
        this.mjK.addUpdateListener(this.mjL);
        this.mjK.start();
    }

    public void dxd() {
        dxg();
        setVisibility(8);
    }

    private void dxg() {
        if (this.mjI != null) {
            this.mjI.cancel();
        }
        if (this.mjJ != null) {
            this.mjJ.cancel();
        }
        if (this.mjK != null) {
            this.mjK.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.mjH = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dxg();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.mjE, this.mjF, false, this.mPaint);
    }
}
