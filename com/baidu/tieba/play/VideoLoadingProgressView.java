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
    private float amI;
    private int dMU;
    private float iAj;
    private int iAk;
    private float iAl;
    private int iAm;
    private float iAn;
    private int iAo;
    private int iAp;
    private float iAq;
    private float iAr;
    private int iAs;
    private a iAt;
    private ValueAnimator iAu;
    private ValueAnimator iAv;
    private ValueAnimator iAw;
    private ValueAnimator.AnimatorUpdateListener iAx;
    private AnimatorListenerAdapter iAy;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.iAj = 7200.0f;
        this.iAk = 10000;
        this.iAl = 30.0f;
        this.iAm = 50;
        this.iAn = 300.0f;
        this.iAo = 400;
        this.amI = -90.0f;
        this.iAq = this.amI;
        this.iAr = 60.0f;
        this.iAx = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.iAs != 1 && VideoLoadingProgressView.this.iAs != 2) {
                    if (VideoLoadingProgressView.this.iAs == 3) {
                        VideoLoadingProgressView.this.iAr = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.iAq = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.amI;
                    VideoLoadingProgressView.this.iAr = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.iAy = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.iAs == 2) {
                    VideoLoadingProgressView.this.cfQ();
                } else if (VideoLoadingProgressView.this.iAs == 3 && VideoLoadingProgressView.this.iAt != null) {
                    VideoLoadingProgressView.this.iAt.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iAj = 7200.0f;
        this.iAk = 10000;
        this.iAl = 30.0f;
        this.iAm = 50;
        this.iAn = 300.0f;
        this.iAo = 400;
        this.amI = -90.0f;
        this.iAq = this.amI;
        this.iAr = 60.0f;
        this.iAx = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.iAs != 1 && VideoLoadingProgressView.this.iAs != 2) {
                    if (VideoLoadingProgressView.this.iAs == 3) {
                        VideoLoadingProgressView.this.iAr = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.iAq = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.amI;
                    VideoLoadingProgressView.this.iAr = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.iAy = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.iAs == 2) {
                    VideoLoadingProgressView.this.cfQ();
                } else if (VideoLoadingProgressView.this.iAs == 3 && VideoLoadingProgressView.this.iAt != null) {
                    VideoLoadingProgressView.this.iAt.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iAj = 7200.0f;
        this.iAk = 10000;
        this.iAl = 30.0f;
        this.iAm = 50;
        this.iAn = 300.0f;
        this.iAo = 400;
        this.amI = -90.0f;
        this.iAq = this.amI;
        this.iAr = 60.0f;
        this.iAx = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.iAs != 1 && VideoLoadingProgressView.this.iAs != 2) {
                    if (VideoLoadingProgressView.this.iAs == 3) {
                        VideoLoadingProgressView.this.iAr = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.iAq = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.amI;
                    VideoLoadingProgressView.this.iAr = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.iAy = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.iAs == 2) {
                    VideoLoadingProgressView.this.cfQ();
                } else if (VideoLoadingProgressView.this.iAs == 3 && VideoLoadingProgressView.this.iAt != null) {
                    VideoLoadingProgressView.this.iAt.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.dMU = getContext().getResources().getColor(R.color.cp_cont_a);
        this.iAp = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.dMU);
        this.mPaint.setStrokeWidth(this.iAp);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        cfR();
        this.iAs = 1;
        this.iAq = -90.0f;
        this.amI = -90.0f;
        this.iAu = ValueAnimator.ofFloat(this.iAj);
        this.iAu.setDuration(this.iAk);
        this.iAu.addListener(this.iAy);
        this.iAu.addUpdateListener(this.iAx);
        this.iAu.start();
        setVisibility(0);
        invalidate();
    }

    public void cfM() {
        cfR();
        this.iAs = 2;
        this.amI = this.iAq;
        this.iAv = ValueAnimator.ofFloat(-this.iAl);
        this.iAv.setDuration(this.iAm);
        this.iAv.addListener(this.iAy);
        this.iAv.addUpdateListener(this.iAx);
        this.iAv.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfQ() {
        cfR();
        this.iAs = 3;
        this.amI = this.iAq;
        this.iAw = ValueAnimator.ofFloat(this.iAn);
        this.iAw.setDuration(this.iAo);
        this.iAw.addListener(this.iAy);
        this.iAw.addUpdateListener(this.iAx);
        this.iAw.start();
    }

    public void cfO() {
        cfR();
        setVisibility(8);
    }

    private void cfR() {
        if (this.iAu != null) {
            this.iAu.cancel();
        }
        if (this.iAv != null) {
            this.iAv.cancel();
        }
        if (this.iAw != null) {
            this.iAw.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.iAt = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cfR();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.iAq, this.iAr, false, this.mPaint);
    }
}
