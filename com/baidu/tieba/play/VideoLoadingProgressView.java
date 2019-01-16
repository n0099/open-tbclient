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
    private int chN;
    private ValueAnimator gIA;
    private ValueAnimator gIB;
    private ValueAnimator.AnimatorUpdateListener gIC;
    private AnimatorListenerAdapter gID;
    private float gIo;
    private int gIp;
    private float gIq;
    private int gIr;
    private float gIs;
    private int gIt;
    private int gIu;
    private float gIv;
    private float gIw;
    private int gIx;
    private a gIy;
    private ValueAnimator gIz;
    private Paint mPaint;
    private RectF mRect;
    private float mStartAngle;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.gIo = 7200.0f;
        this.gIp = 10000;
        this.gIq = 30.0f;
        this.gIr = 50;
        this.gIs = 300.0f;
        this.gIt = 400;
        this.mStartAngle = -90.0f;
        this.gIv = this.mStartAngle;
        this.gIw = 60.0f;
        this.gIC = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gIx != 1 && VideoLoadingProgressView.this.gIx != 2) {
                    if (VideoLoadingProgressView.this.gIx == 3) {
                        VideoLoadingProgressView.this.gIw = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gIv = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gIw = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gID = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gIx == 2) {
                    VideoLoadingProgressView.this.btv();
                } else if (VideoLoadingProgressView.this.gIx == 3 && VideoLoadingProgressView.this.gIy != null) {
                    VideoLoadingProgressView.this.gIy.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gIo = 7200.0f;
        this.gIp = 10000;
        this.gIq = 30.0f;
        this.gIr = 50;
        this.gIs = 300.0f;
        this.gIt = 400;
        this.mStartAngle = -90.0f;
        this.gIv = this.mStartAngle;
        this.gIw = 60.0f;
        this.gIC = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gIx != 1 && VideoLoadingProgressView.this.gIx != 2) {
                    if (VideoLoadingProgressView.this.gIx == 3) {
                        VideoLoadingProgressView.this.gIw = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gIv = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gIw = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gID = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gIx == 2) {
                    VideoLoadingProgressView.this.btv();
                } else if (VideoLoadingProgressView.this.gIx == 3 && VideoLoadingProgressView.this.gIy != null) {
                    VideoLoadingProgressView.this.gIy.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gIo = 7200.0f;
        this.gIp = 10000;
        this.gIq = 30.0f;
        this.gIr = 50;
        this.gIs = 300.0f;
        this.gIt = 400;
        this.mStartAngle = -90.0f;
        this.gIv = this.mStartAngle;
        this.gIw = 60.0f;
        this.gIC = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gIx != 1 && VideoLoadingProgressView.this.gIx != 2) {
                    if (VideoLoadingProgressView.this.gIx == 3) {
                        VideoLoadingProgressView.this.gIw = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gIv = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gIw = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gID = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gIx == 2) {
                    VideoLoadingProgressView.this.btv();
                } else if (VideoLoadingProgressView.this.gIx == 3 && VideoLoadingProgressView.this.gIy != null) {
                    VideoLoadingProgressView.this.gIy.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.chN = getContext().getResources().getColor(e.d.cp_cont_i);
        this.gIu = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds2);
        this.mPaint.setColor(this.chN);
        this.mPaint.setStrokeWidth(this.gIu);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        btw();
        this.gIx = 1;
        this.gIv = -90.0f;
        this.mStartAngle = -90.0f;
        this.gIz = ValueAnimator.ofFloat(this.gIo);
        this.gIz.setDuration(this.gIp);
        this.gIz.addListener(this.gID);
        this.gIz.addUpdateListener(this.gIC);
        this.gIz.start();
        setVisibility(0);
        invalidate();
    }

    public void btr() {
        btw();
        this.gIx = 2;
        this.mStartAngle = this.gIv;
        this.gIA = ValueAnimator.ofFloat(-this.gIq);
        this.gIA.setDuration(this.gIr);
        this.gIA.addListener(this.gID);
        this.gIA.addUpdateListener(this.gIC);
        this.gIA.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btv() {
        btw();
        this.gIx = 3;
        this.mStartAngle = this.gIv;
        this.gIB = ValueAnimator.ofFloat(this.gIs);
        this.gIB.setDuration(this.gIt);
        this.gIB.addListener(this.gID);
        this.gIB.addUpdateListener(this.gIC);
        this.gIB.start();
    }

    public void btt() {
        btw();
        setVisibility(8);
    }

    private void btw() {
        if (this.gIz != null) {
            this.gIz.cancel();
        }
        if (this.gIA != null) {
            this.gIA.cancel();
        }
        if (this.gIB != null) {
            this.gIB.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.gIy = aVar;
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
        canvas.drawArc(this.mRect, this.gIv, this.gIw, false, this.mPaint);
    }
}
