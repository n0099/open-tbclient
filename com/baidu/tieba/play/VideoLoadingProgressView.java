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
    private int gvA;
    private a gvB;
    private ValueAnimator gvC;
    private ValueAnimator gvD;
    private ValueAnimator gvE;
    private ValueAnimator.AnimatorUpdateListener gvF;
    private AnimatorListenerAdapter gvG;
    private float gvp;
    private int gvq;
    private float gvr;
    private int gvs;
    private float gvt;
    private int gvu;
    private int gvv;
    private int gvw;
    private float gvx;
    private float gvy;
    private float gvz;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.gvp = 3600.0f;
        this.gvq = 5000;
        this.gvr = 30.0f;
        this.gvs = 50;
        this.gvt = 300.0f;
        this.gvu = HttpStatus.SC_BAD_REQUEST;
        this.gvx = -90.0f;
        this.gvy = this.gvx;
        this.gvz = 60.0f;
        this.gvF = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gvA != 1 && VideoLoadingProgressView.this.gvA != 2) {
                    if (VideoLoadingProgressView.this.gvA == 3) {
                        VideoLoadingProgressView.this.gvz = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gvy = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gvx;
                    VideoLoadingProgressView.this.gvz = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gvG = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gvA == 2) {
                    VideoLoadingProgressView.this.blS();
                } else if (VideoLoadingProgressView.this.gvA == 3 && VideoLoadingProgressView.this.gvB != null) {
                    VideoLoadingProgressView.this.gvB.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gvp = 3600.0f;
        this.gvq = 5000;
        this.gvr = 30.0f;
        this.gvs = 50;
        this.gvt = 300.0f;
        this.gvu = HttpStatus.SC_BAD_REQUEST;
        this.gvx = -90.0f;
        this.gvy = this.gvx;
        this.gvz = 60.0f;
        this.gvF = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gvA != 1 && VideoLoadingProgressView.this.gvA != 2) {
                    if (VideoLoadingProgressView.this.gvA == 3) {
                        VideoLoadingProgressView.this.gvz = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gvy = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gvx;
                    VideoLoadingProgressView.this.gvz = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gvG = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gvA == 2) {
                    VideoLoadingProgressView.this.blS();
                } else if (VideoLoadingProgressView.this.gvA == 3 && VideoLoadingProgressView.this.gvB != null) {
                    VideoLoadingProgressView.this.gvB.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gvp = 3600.0f;
        this.gvq = 5000;
        this.gvr = 30.0f;
        this.gvs = 50;
        this.gvt = 300.0f;
        this.gvu = HttpStatus.SC_BAD_REQUEST;
        this.gvx = -90.0f;
        this.gvy = this.gvx;
        this.gvz = 60.0f;
        this.gvF = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gvA != 1 && VideoLoadingProgressView.this.gvA != 2) {
                    if (VideoLoadingProgressView.this.gvA == 3) {
                        VideoLoadingProgressView.this.gvz = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gvy = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gvx;
                    VideoLoadingProgressView.this.gvz = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gvG = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gvA == 2) {
                    VideoLoadingProgressView.this.blS();
                } else if (VideoLoadingProgressView.this.gvA == 3 && VideoLoadingProgressView.this.gvB != null) {
                    VideoLoadingProgressView.this.gvB.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.gvv = getContext().getResources().getColor(d.C0141d.cp_cont_i);
        this.gvw = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds2);
        this.mPaint.setColor(this.gvv);
        this.mPaint.setStrokeWidth(this.gvw);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        blT();
        this.gvA = 1;
        this.gvy = -90.0f;
        this.gvx = -90.0f;
        this.gvC = ValueAnimator.ofFloat(this.gvp);
        this.gvC.setDuration(this.gvq);
        this.gvC.addListener(this.gvG);
        this.gvC.addUpdateListener(this.gvF);
        this.gvC.start();
        setVisibility(0);
        invalidate();
    }

    public void blO() {
        blT();
        this.gvA = 2;
        this.gvx = this.gvy;
        this.gvD = ValueAnimator.ofFloat(-this.gvr);
        this.gvD.setDuration(this.gvs);
        this.gvD.addListener(this.gvG);
        this.gvD.addUpdateListener(this.gvF);
        this.gvD.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blS() {
        blT();
        this.gvA = 3;
        this.gvx = this.gvy;
        this.gvE = ValueAnimator.ofFloat(this.gvt);
        this.gvE.setDuration(this.gvu);
        this.gvE.addListener(this.gvG);
        this.gvE.addUpdateListener(this.gvF);
        this.gvE.start();
    }

    public void blQ() {
        blT();
        setVisibility(8);
    }

    private void blT() {
        if (this.gvC != null) {
            this.gvC.cancel();
        }
        if (this.gvD != null) {
            this.gvD.cancel();
        }
        if (this.gvE != null) {
            this.gvE.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.gvB = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        blT();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.gvy, this.gvz, false, this.mPaint);
    }
}
