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
    private float gvA;
    private int gvB;
    private float gvC;
    private int gvD;
    private float gvE;
    private int gvF;
    private int gvG;
    private int gvH;
    private float gvI;
    private float gvJ;
    private float gvK;
    private int gvL;
    private a gvM;
    private ValueAnimator gvN;
    private ValueAnimator gvO;
    private ValueAnimator gvP;
    private ValueAnimator.AnimatorUpdateListener gvQ;
    private AnimatorListenerAdapter gvR;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.gvA = 3600.0f;
        this.gvB = 5000;
        this.gvC = 30.0f;
        this.gvD = 50;
        this.gvE = 300.0f;
        this.gvF = HttpStatus.SC_BAD_REQUEST;
        this.gvI = -90.0f;
        this.gvJ = this.gvI;
        this.gvK = 60.0f;
        this.gvQ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gvL != 1 && VideoLoadingProgressView.this.gvL != 2) {
                    if (VideoLoadingProgressView.this.gvL == 3) {
                        VideoLoadingProgressView.this.gvK = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gvJ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gvI;
                    VideoLoadingProgressView.this.gvK = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gvR = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gvL == 2) {
                    VideoLoadingProgressView.this.blT();
                } else if (VideoLoadingProgressView.this.gvL == 3 && VideoLoadingProgressView.this.gvM != null) {
                    VideoLoadingProgressView.this.gvM.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gvA = 3600.0f;
        this.gvB = 5000;
        this.gvC = 30.0f;
        this.gvD = 50;
        this.gvE = 300.0f;
        this.gvF = HttpStatus.SC_BAD_REQUEST;
        this.gvI = -90.0f;
        this.gvJ = this.gvI;
        this.gvK = 60.0f;
        this.gvQ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gvL != 1 && VideoLoadingProgressView.this.gvL != 2) {
                    if (VideoLoadingProgressView.this.gvL == 3) {
                        VideoLoadingProgressView.this.gvK = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gvJ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gvI;
                    VideoLoadingProgressView.this.gvK = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gvR = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gvL == 2) {
                    VideoLoadingProgressView.this.blT();
                } else if (VideoLoadingProgressView.this.gvL == 3 && VideoLoadingProgressView.this.gvM != null) {
                    VideoLoadingProgressView.this.gvM.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gvA = 3600.0f;
        this.gvB = 5000;
        this.gvC = 30.0f;
        this.gvD = 50;
        this.gvE = 300.0f;
        this.gvF = HttpStatus.SC_BAD_REQUEST;
        this.gvI = -90.0f;
        this.gvJ = this.gvI;
        this.gvK = 60.0f;
        this.gvQ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gvL != 1 && VideoLoadingProgressView.this.gvL != 2) {
                    if (VideoLoadingProgressView.this.gvL == 3) {
                        VideoLoadingProgressView.this.gvK = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gvJ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gvI;
                    VideoLoadingProgressView.this.gvK = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gvR = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gvL == 2) {
                    VideoLoadingProgressView.this.blT();
                } else if (VideoLoadingProgressView.this.gvL == 3 && VideoLoadingProgressView.this.gvM != null) {
                    VideoLoadingProgressView.this.gvM.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.gvG = getContext().getResources().getColor(d.C0140d.cp_cont_i);
        this.gvH = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds2);
        this.mPaint.setColor(this.gvG);
        this.mPaint.setStrokeWidth(this.gvH);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        blU();
        this.gvL = 1;
        this.gvJ = -90.0f;
        this.gvI = -90.0f;
        this.gvN = ValueAnimator.ofFloat(this.gvA);
        this.gvN.setDuration(this.gvB);
        this.gvN.addListener(this.gvR);
        this.gvN.addUpdateListener(this.gvQ);
        this.gvN.start();
        setVisibility(0);
        invalidate();
    }

    public void blP() {
        blU();
        this.gvL = 2;
        this.gvI = this.gvJ;
        this.gvO = ValueAnimator.ofFloat(-this.gvC);
        this.gvO.setDuration(this.gvD);
        this.gvO.addListener(this.gvR);
        this.gvO.addUpdateListener(this.gvQ);
        this.gvO.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blT() {
        blU();
        this.gvL = 3;
        this.gvI = this.gvJ;
        this.gvP = ValueAnimator.ofFloat(this.gvE);
        this.gvP.setDuration(this.gvF);
        this.gvP.addListener(this.gvR);
        this.gvP.addUpdateListener(this.gvQ);
        this.gvP.start();
    }

    public void blR() {
        blU();
        setVisibility(8);
    }

    private void blU() {
        if (this.gvN != null) {
            this.gvN.cancel();
        }
        if (this.gvO != null) {
            this.gvO.cancel();
        }
        if (this.gvP != null) {
            this.gvP.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.gvM = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        blU();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.gvJ, this.gvK, false, this.mPaint);
    }
}
