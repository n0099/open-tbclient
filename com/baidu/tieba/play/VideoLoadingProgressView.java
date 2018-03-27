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
    private float gvF;
    private int gvG;
    private float gvH;
    private int gvI;
    private float gvJ;
    private int gvK;
    private int gvL;
    private int gvM;
    private float gvN;
    private float gvO;
    private float gvP;
    private int gvQ;
    private a gvR;
    private ValueAnimator gvS;
    private ValueAnimator gvT;
    private ValueAnimator gvU;
    private ValueAnimator.AnimatorUpdateListener gvV;
    private AnimatorListenerAdapter gvW;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.gvF = 3600.0f;
        this.gvG = 5000;
        this.gvH = 30.0f;
        this.gvI = 50;
        this.gvJ = 300.0f;
        this.gvK = HttpStatus.SC_BAD_REQUEST;
        this.gvN = -90.0f;
        this.gvO = this.gvN;
        this.gvP = 60.0f;
        this.gvV = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gvQ != 1 && VideoLoadingProgressView.this.gvQ != 2) {
                    if (VideoLoadingProgressView.this.gvQ == 3) {
                        VideoLoadingProgressView.this.gvP = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gvO = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gvN;
                    VideoLoadingProgressView.this.gvP = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gvW = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gvQ == 2) {
                    VideoLoadingProgressView.this.blT();
                } else if (VideoLoadingProgressView.this.gvQ == 3 && VideoLoadingProgressView.this.gvR != null) {
                    VideoLoadingProgressView.this.gvR.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gvF = 3600.0f;
        this.gvG = 5000;
        this.gvH = 30.0f;
        this.gvI = 50;
        this.gvJ = 300.0f;
        this.gvK = HttpStatus.SC_BAD_REQUEST;
        this.gvN = -90.0f;
        this.gvO = this.gvN;
        this.gvP = 60.0f;
        this.gvV = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gvQ != 1 && VideoLoadingProgressView.this.gvQ != 2) {
                    if (VideoLoadingProgressView.this.gvQ == 3) {
                        VideoLoadingProgressView.this.gvP = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gvO = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gvN;
                    VideoLoadingProgressView.this.gvP = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gvW = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gvQ == 2) {
                    VideoLoadingProgressView.this.blT();
                } else if (VideoLoadingProgressView.this.gvQ == 3 && VideoLoadingProgressView.this.gvR != null) {
                    VideoLoadingProgressView.this.gvR.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gvF = 3600.0f;
        this.gvG = 5000;
        this.gvH = 30.0f;
        this.gvI = 50;
        this.gvJ = 300.0f;
        this.gvK = HttpStatus.SC_BAD_REQUEST;
        this.gvN = -90.0f;
        this.gvO = this.gvN;
        this.gvP = 60.0f;
        this.gvV = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gvQ != 1 && VideoLoadingProgressView.this.gvQ != 2) {
                    if (VideoLoadingProgressView.this.gvQ == 3) {
                        VideoLoadingProgressView.this.gvP = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gvO = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gvN;
                    VideoLoadingProgressView.this.gvP = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gvW = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gvQ == 2) {
                    VideoLoadingProgressView.this.blT();
                } else if (VideoLoadingProgressView.this.gvQ == 3 && VideoLoadingProgressView.this.gvR != null) {
                    VideoLoadingProgressView.this.gvR.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.gvL = getContext().getResources().getColor(d.C0141d.cp_cont_i);
        this.gvM = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds2);
        this.mPaint.setColor(this.gvL);
        this.mPaint.setStrokeWidth(this.gvM);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        blU();
        this.gvQ = 1;
        this.gvO = -90.0f;
        this.gvN = -90.0f;
        this.gvS = ValueAnimator.ofFloat(this.gvF);
        this.gvS.setDuration(this.gvG);
        this.gvS.addListener(this.gvW);
        this.gvS.addUpdateListener(this.gvV);
        this.gvS.start();
        setVisibility(0);
        invalidate();
    }

    public void blP() {
        blU();
        this.gvQ = 2;
        this.gvN = this.gvO;
        this.gvT = ValueAnimator.ofFloat(-this.gvH);
        this.gvT.setDuration(this.gvI);
        this.gvT.addListener(this.gvW);
        this.gvT.addUpdateListener(this.gvV);
        this.gvT.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blT() {
        blU();
        this.gvQ = 3;
        this.gvN = this.gvO;
        this.gvU = ValueAnimator.ofFloat(this.gvJ);
        this.gvU.setDuration(this.gvK);
        this.gvU.addListener(this.gvW);
        this.gvU.addUpdateListener(this.gvV);
        this.gvU.start();
    }

    public void blR() {
        blU();
        setVisibility(8);
    }

    private void blU() {
        if (this.gvS != null) {
            this.gvS.cancel();
        }
        if (this.gvT != null) {
            this.gvT.cancel();
        }
        if (this.gvU != null) {
            this.gvU.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.gvR = aVar;
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
        canvas.drawArc(this.mRect, this.gvO, this.gvP, false, this.mPaint);
    }
}
