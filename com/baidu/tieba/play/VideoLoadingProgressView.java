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
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class VideoLoadingProgressView extends View {
    private int chO;
    private ValueAnimator gIA;
    private ValueAnimator gIB;
    private ValueAnimator gIC;
    private ValueAnimator.AnimatorUpdateListener gID;
    private AnimatorListenerAdapter gIE;
    private float gIp;
    private int gIq;
    private float gIr;
    private int gIs;
    private float gIt;
    private int gIu;
    private int gIv;
    private float gIw;
    private float gIx;
    private int gIy;
    private a gIz;
    private Paint mPaint;
    private RectF mRect;
    private float mStartAngle;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.gIp = 7200.0f;
        this.gIq = 10000;
        this.gIr = 30.0f;
        this.gIs = 50;
        this.gIt = 300.0f;
        this.gIu = 400;
        this.mStartAngle = -90.0f;
        this.gIw = this.mStartAngle;
        this.gIx = 60.0f;
        this.gID = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gIy != 1 && VideoLoadingProgressView.this.gIy != 2) {
                    if (VideoLoadingProgressView.this.gIy == 3) {
                        VideoLoadingProgressView.this.gIx = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gIw = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gIx = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gIE = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gIy == 2) {
                    VideoLoadingProgressView.this.btv();
                } else if (VideoLoadingProgressView.this.gIy == 3 && VideoLoadingProgressView.this.gIz != null) {
                    VideoLoadingProgressView.this.gIz.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gIp = 7200.0f;
        this.gIq = 10000;
        this.gIr = 30.0f;
        this.gIs = 50;
        this.gIt = 300.0f;
        this.gIu = 400;
        this.mStartAngle = -90.0f;
        this.gIw = this.mStartAngle;
        this.gIx = 60.0f;
        this.gID = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gIy != 1 && VideoLoadingProgressView.this.gIy != 2) {
                    if (VideoLoadingProgressView.this.gIy == 3) {
                        VideoLoadingProgressView.this.gIx = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gIw = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gIx = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gIE = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gIy == 2) {
                    VideoLoadingProgressView.this.btv();
                } else if (VideoLoadingProgressView.this.gIy == 3 && VideoLoadingProgressView.this.gIz != null) {
                    VideoLoadingProgressView.this.gIz.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gIp = 7200.0f;
        this.gIq = 10000;
        this.gIr = 30.0f;
        this.gIs = 50;
        this.gIt = 300.0f;
        this.gIu = 400;
        this.mStartAngle = -90.0f;
        this.gIw = this.mStartAngle;
        this.gIx = 60.0f;
        this.gID = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gIy != 1 && VideoLoadingProgressView.this.gIy != 2) {
                    if (VideoLoadingProgressView.this.gIy == 3) {
                        VideoLoadingProgressView.this.gIx = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gIw = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gIx = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gIE = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gIy == 2) {
                    VideoLoadingProgressView.this.btv();
                } else if (VideoLoadingProgressView.this.gIy == 3 && VideoLoadingProgressView.this.gIz != null) {
                    VideoLoadingProgressView.this.gIz.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.chO = getContext().getResources().getColor(e.d.cp_cont_i);
        this.gIv = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds2);
        this.mPaint.setColor(this.chO);
        this.mPaint.setStrokeWidth(this.gIv);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        btw();
        this.gIy = 1;
        this.gIw = -90.0f;
        this.mStartAngle = -90.0f;
        this.gIA = ValueAnimator.ofFloat(this.gIp);
        this.gIA.setDuration(this.gIq);
        this.gIA.addListener(this.gIE);
        this.gIA.addUpdateListener(this.gID);
        this.gIA.start();
        setVisibility(0);
        invalidate();
    }

    public void btr() {
        btw();
        this.gIy = 2;
        this.mStartAngle = this.gIw;
        this.gIB = ValueAnimator.ofFloat(-this.gIr);
        this.gIB.setDuration(this.gIs);
        this.gIB.addListener(this.gIE);
        this.gIB.addUpdateListener(this.gID);
        this.gIB.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btv() {
        btw();
        this.gIy = 3;
        this.mStartAngle = this.gIw;
        this.gIC = ValueAnimator.ofFloat(this.gIt);
        this.gIC.setDuration(this.gIu);
        this.gIC.addListener(this.gIE);
        this.gIC.addUpdateListener(this.gID);
        this.gIC.start();
    }

    public void btt() {
        btw();
        setVisibility(8);
    }

    private void btw() {
        if (this.gIA != null) {
            this.gIA.cancel();
        }
        if (this.gIB != null) {
            this.gIB.cancel();
        }
        if (this.gIC != null) {
            this.gIC.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.gIz = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        btw();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.gIw, this.gIx, false, this.mPaint);
    }
}
