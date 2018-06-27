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
    private int bNG;
    private float ggH;
    private int ggI;
    private float ggJ;
    private int ggK;
    private float ggL;
    private int ggM;
    private int ggN;
    private float ggO;
    private float ggP;
    private float ggQ;
    private int ggR;
    private a ggS;
    private ValueAnimator ggT;
    private ValueAnimator ggU;
    private ValueAnimator ggV;
    private ValueAnimator.AnimatorUpdateListener ggW;
    private AnimatorListenerAdapter ggX;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.ggH = 7200.0f;
        this.ggI = 10000;
        this.ggJ = 30.0f;
        this.ggK = 50;
        this.ggL = 300.0f;
        this.ggM = HttpStatus.SC_BAD_REQUEST;
        this.ggO = -90.0f;
        this.ggP = this.ggO;
        this.ggQ = 60.0f;
        this.ggW = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.ggR != 1 && VideoLoadingProgressView.this.ggR != 2) {
                    if (VideoLoadingProgressView.this.ggR == 3) {
                        VideoLoadingProgressView.this.ggQ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.ggP = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.ggO;
                    VideoLoadingProgressView.this.ggQ = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.ggX = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.ggR == 2) {
                    VideoLoadingProgressView.this.bmB();
                } else if (VideoLoadingProgressView.this.ggR == 3 && VideoLoadingProgressView.this.ggS != null) {
                    VideoLoadingProgressView.this.ggS.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ggH = 7200.0f;
        this.ggI = 10000;
        this.ggJ = 30.0f;
        this.ggK = 50;
        this.ggL = 300.0f;
        this.ggM = HttpStatus.SC_BAD_REQUEST;
        this.ggO = -90.0f;
        this.ggP = this.ggO;
        this.ggQ = 60.0f;
        this.ggW = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.ggR != 1 && VideoLoadingProgressView.this.ggR != 2) {
                    if (VideoLoadingProgressView.this.ggR == 3) {
                        VideoLoadingProgressView.this.ggQ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.ggP = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.ggO;
                    VideoLoadingProgressView.this.ggQ = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.ggX = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.ggR == 2) {
                    VideoLoadingProgressView.this.bmB();
                } else if (VideoLoadingProgressView.this.ggR == 3 && VideoLoadingProgressView.this.ggS != null) {
                    VideoLoadingProgressView.this.ggS.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ggH = 7200.0f;
        this.ggI = 10000;
        this.ggJ = 30.0f;
        this.ggK = 50;
        this.ggL = 300.0f;
        this.ggM = HttpStatus.SC_BAD_REQUEST;
        this.ggO = -90.0f;
        this.ggP = this.ggO;
        this.ggQ = 60.0f;
        this.ggW = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.ggR != 1 && VideoLoadingProgressView.this.ggR != 2) {
                    if (VideoLoadingProgressView.this.ggR == 3) {
                        VideoLoadingProgressView.this.ggQ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.ggP = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.ggO;
                    VideoLoadingProgressView.this.ggQ = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.ggX = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.ggR == 2) {
                    VideoLoadingProgressView.this.bmB();
                } else if (VideoLoadingProgressView.this.ggR == 3 && VideoLoadingProgressView.this.ggS != null) {
                    VideoLoadingProgressView.this.ggS.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.bNG = getContext().getResources().getColor(d.C0142d.cp_cont_i);
        this.ggN = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds2);
        this.mPaint.setColor(this.bNG);
        this.mPaint.setStrokeWidth(this.ggN);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bmC();
        this.ggR = 1;
        this.ggP = -90.0f;
        this.ggO = -90.0f;
        this.ggT = ValueAnimator.ofFloat(this.ggH);
        this.ggT.setDuration(this.ggI);
        this.ggT.addListener(this.ggX);
        this.ggT.addUpdateListener(this.ggW);
        this.ggT.start();
        setVisibility(0);
        invalidate();
    }

    public void bmx() {
        bmC();
        this.ggR = 2;
        this.ggO = this.ggP;
        this.ggU = ValueAnimator.ofFloat(-this.ggJ);
        this.ggU.setDuration(this.ggK);
        this.ggU.addListener(this.ggX);
        this.ggU.addUpdateListener(this.ggW);
        this.ggU.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmB() {
        bmC();
        this.ggR = 3;
        this.ggO = this.ggP;
        this.ggV = ValueAnimator.ofFloat(this.ggL);
        this.ggV.setDuration(this.ggM);
        this.ggV.addListener(this.ggX);
        this.ggV.addUpdateListener(this.ggW);
        this.ggV.start();
    }

    public void bmz() {
        bmC();
        setVisibility(8);
    }

    private void bmC() {
        if (this.ggT != null) {
            this.ggT.cancel();
        }
        if (this.ggU != null) {
            this.ggU.cancel();
        }
        if (this.ggV != null) {
            this.ggV.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.ggS = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bmC();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.ggP, this.ggQ, false, this.mPaint);
    }
}
