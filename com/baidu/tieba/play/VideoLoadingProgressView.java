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
    private float gwc;
    private int gwd;
    private float gwe;
    private int gwf;
    private float gwg;
    private int gwh;
    private int gwi;
    private float gwj;
    private float gwk;
    private int gwl;
    private a gwm;
    private ValueAnimator gwn;
    private ValueAnimator gwo;
    private ValueAnimator gwp;
    private ValueAnimator.AnimatorUpdateListener gwq;
    private AnimatorListenerAdapter gwr;
    private Paint mPaint;
    private RectF mRect;
    private float mStartAngle;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.gwc = 7200.0f;
        this.gwd = 10000;
        this.gwe = 30.0f;
        this.gwf = 50;
        this.gwg = 300.0f;
        this.gwh = 400;
        this.mStartAngle = -90.0f;
        this.gwj = this.mStartAngle;
        this.gwk = 60.0f;
        this.gwq = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gwl != 1 && VideoLoadingProgressView.this.gwl != 2) {
                    if (VideoLoadingProgressView.this.gwl == 3) {
                        VideoLoadingProgressView.this.gwk = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gwj = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gwk = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gwr = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gwl == 2) {
                    VideoLoadingProgressView.this.bqM();
                } else if (VideoLoadingProgressView.this.gwl == 3 && VideoLoadingProgressView.this.gwm != null) {
                    VideoLoadingProgressView.this.gwm.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gwc = 7200.0f;
        this.gwd = 10000;
        this.gwe = 30.0f;
        this.gwf = 50;
        this.gwg = 300.0f;
        this.gwh = 400;
        this.mStartAngle = -90.0f;
        this.gwj = this.mStartAngle;
        this.gwk = 60.0f;
        this.gwq = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gwl != 1 && VideoLoadingProgressView.this.gwl != 2) {
                    if (VideoLoadingProgressView.this.gwl == 3) {
                        VideoLoadingProgressView.this.gwk = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gwj = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gwk = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gwr = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gwl == 2) {
                    VideoLoadingProgressView.this.bqM();
                } else if (VideoLoadingProgressView.this.gwl == 3 && VideoLoadingProgressView.this.gwm != null) {
                    VideoLoadingProgressView.this.gwm.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gwc = 7200.0f;
        this.gwd = 10000;
        this.gwe = 30.0f;
        this.gwf = 50;
        this.gwg = 300.0f;
        this.gwh = 400;
        this.mStartAngle = -90.0f;
        this.gwj = this.mStartAngle;
        this.gwk = 60.0f;
        this.gwq = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gwl != 1 && VideoLoadingProgressView.this.gwl != 2) {
                    if (VideoLoadingProgressView.this.gwl == 3) {
                        VideoLoadingProgressView.this.gwk = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gwj = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.mStartAngle;
                    VideoLoadingProgressView.this.gwk = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gwr = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gwl == 2) {
                    VideoLoadingProgressView.this.bqM();
                } else if (VideoLoadingProgressView.this.gwl == 3 && VideoLoadingProgressView.this.gwm != null) {
                    VideoLoadingProgressView.this.gwm.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.ccP = getContext().getResources().getColor(e.d.cp_cont_i);
        this.gwi = com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds2);
        this.mPaint.setColor(this.ccP);
        this.mPaint.setStrokeWidth(this.gwi);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bqN();
        this.gwl = 1;
        this.gwj = -90.0f;
        this.mStartAngle = -90.0f;
        this.gwn = ValueAnimator.ofFloat(this.gwc);
        this.gwn.setDuration(this.gwd);
        this.gwn.addListener(this.gwr);
        this.gwn.addUpdateListener(this.gwq);
        this.gwn.start();
        setVisibility(0);
        invalidate();
    }

    public void bqI() {
        bqN();
        this.gwl = 2;
        this.mStartAngle = this.gwj;
        this.gwo = ValueAnimator.ofFloat(-this.gwe);
        this.gwo.setDuration(this.gwf);
        this.gwo.addListener(this.gwr);
        this.gwo.addUpdateListener(this.gwq);
        this.gwo.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqM() {
        bqN();
        this.gwl = 3;
        this.mStartAngle = this.gwj;
        this.gwp = ValueAnimator.ofFloat(this.gwg);
        this.gwp.setDuration(this.gwh);
        this.gwp.addListener(this.gwr);
        this.gwp.addUpdateListener(this.gwq);
        this.gwp.start();
    }

    public void bqK() {
        bqN();
        setVisibility(8);
    }

    private void bqN() {
        if (this.gwn != null) {
            this.gwn.cancel();
        }
        if (this.gwo != null) {
            this.gwo.cancel();
        }
        if (this.gwp != null) {
            this.gwp.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.gwm = aVar;
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
        canvas.drawArc(this.mRect, this.gwj, this.gwk, false, this.mPaint);
    }
}
