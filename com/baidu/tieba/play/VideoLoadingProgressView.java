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
    private int ccP;
    private float gwb;
    private int gwc;
    private float gwd;
    private int gwe;
    private float gwf;
    private int gwg;
    private int gwh;
    private float gwi;
    private float gwj;
    private int gwk;
    private a gwl;
    private ValueAnimator gwm;
    private ValueAnimator gwn;
    private ValueAnimator gwo;
    private ValueAnimator.AnimatorUpdateListener gwp;
    private AnimatorListenerAdapter gwq;
    private Paint mPaint;
    private RectF mRect;
    private float mStartAngle;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.gwb = 7200.0f;
        this.gwc = 10000;
        this.gwd = 30.0f;
        this.gwe = 50;
        this.gwf = 300.0f;
        this.gwg = 400;
        this.mStartAngle = -90.0f;
        this.gwi = this.mStartAngle;
        this.gwj = 60.0f;
        this.gwp = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gwk != 1 && VideoLoadingProgressView.this.gwk != 2) {
                    if (VideoLoadingProgressView.this.gwk == 3) {
                        VideoLoadingProgressView.this.gwj = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gwi = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gwj = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gwq = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gwk == 2) {
                    VideoLoadingProgressView.this.bqM();
                } else if (VideoLoadingProgressView.this.gwk == 3 && VideoLoadingProgressView.this.gwl != null) {
                    VideoLoadingProgressView.this.gwl.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gwb = 7200.0f;
        this.gwc = 10000;
        this.gwd = 30.0f;
        this.gwe = 50;
        this.gwf = 300.0f;
        this.gwg = 400;
        this.mStartAngle = -90.0f;
        this.gwi = this.mStartAngle;
        this.gwj = 60.0f;
        this.gwp = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gwk != 1 && VideoLoadingProgressView.this.gwk != 2) {
                    if (VideoLoadingProgressView.this.gwk == 3) {
                        VideoLoadingProgressView.this.gwj = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gwi = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gwj = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gwq = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gwk == 2) {
                    VideoLoadingProgressView.this.bqM();
                } else if (VideoLoadingProgressView.this.gwk == 3 && VideoLoadingProgressView.this.gwl != null) {
                    VideoLoadingProgressView.this.gwl.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gwb = 7200.0f;
        this.gwc = 10000;
        this.gwd = 30.0f;
        this.gwe = 50;
        this.gwf = 300.0f;
        this.gwg = 400;
        this.mStartAngle = -90.0f;
        this.gwi = this.mStartAngle;
        this.gwj = 60.0f;
        this.gwp = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gwk != 1 && VideoLoadingProgressView.this.gwk != 2) {
                    if (VideoLoadingProgressView.this.gwk == 3) {
                        VideoLoadingProgressView.this.gwj = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gwi = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gwj = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gwq = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gwk == 2) {
                    VideoLoadingProgressView.this.bqM();
                } else if (VideoLoadingProgressView.this.gwk == 3 && VideoLoadingProgressView.this.gwl != null) {
                    VideoLoadingProgressView.this.gwl.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.ccP = getContext().getResources().getColor(e.d.cp_cont_i);
        this.gwh = com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds2);
        this.mPaint.setColor(this.ccP);
        this.mPaint.setStrokeWidth(this.gwh);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bqN();
        this.gwk = 1;
        this.gwi = -90.0f;
        this.mStartAngle = -90.0f;
        this.gwm = ValueAnimator.ofFloat(this.gwb);
        this.gwm.setDuration(this.gwc);
        this.gwm.addListener(this.gwq);
        this.gwm.addUpdateListener(this.gwp);
        this.gwm.start();
        setVisibility(0);
        invalidate();
    }

    public void bqI() {
        bqN();
        this.gwk = 2;
        this.mStartAngle = this.gwi;
        this.gwn = ValueAnimator.ofFloat(-this.gwd);
        this.gwn.setDuration(this.gwe);
        this.gwn.addListener(this.gwq);
        this.gwn.addUpdateListener(this.gwp);
        this.gwn.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqM() {
        bqN();
        this.gwk = 3;
        this.mStartAngle = this.gwi;
        this.gwo = ValueAnimator.ofFloat(this.gwf);
        this.gwo.setDuration(this.gwg);
        this.gwo.addListener(this.gwq);
        this.gwo.addUpdateListener(this.gwp);
        this.gwo.start();
    }

    public void bqK() {
        bqN();
        setVisibility(8);
    }

    private void bqN() {
        if (this.gwm != null) {
            this.gwm.cancel();
        }
        if (this.gwn != null) {
            this.gwn.cancel();
        }
        if (this.gwo != null) {
            this.gwo.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.gwl = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bqN();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.gwi, this.gwj, false, this.mPaint);
    }
}
