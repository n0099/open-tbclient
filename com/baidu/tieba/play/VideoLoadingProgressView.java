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
    private float gEA;
    private float gEB;
    private float gEC;
    private int gED;
    private a gEE;
    private ValueAnimator gEF;
    private ValueAnimator gEG;
    private ValueAnimator gEH;
    private ValueAnimator.AnimatorUpdateListener gEI;
    private AnimatorListenerAdapter gEJ;
    private float gEs;
    private int gEt;
    private float gEu;
    private int gEv;
    private float gEw;
    private int gEx;
    private int gEy;
    private int gEz;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.gEs = 3600.0f;
        this.gEt = 5000;
        this.gEu = 30.0f;
        this.gEv = 50;
        this.gEw = 300.0f;
        this.gEx = HttpStatus.SC_BAD_REQUEST;
        this.gEA = -90.0f;
        this.gEB = this.gEA;
        this.gEC = 60.0f;
        this.gEI = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gED != 1 && VideoLoadingProgressView.this.gED != 2) {
                    if (VideoLoadingProgressView.this.gED == 3) {
                        VideoLoadingProgressView.this.gEC = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gEB = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gEA;
                    VideoLoadingProgressView.this.gEC = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gEJ = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gED == 2) {
                    VideoLoadingProgressView.this.brm();
                } else if (VideoLoadingProgressView.this.gED == 3 && VideoLoadingProgressView.this.gEE != null) {
                    VideoLoadingProgressView.this.gEE.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gEs = 3600.0f;
        this.gEt = 5000;
        this.gEu = 30.0f;
        this.gEv = 50;
        this.gEw = 300.0f;
        this.gEx = HttpStatus.SC_BAD_REQUEST;
        this.gEA = -90.0f;
        this.gEB = this.gEA;
        this.gEC = 60.0f;
        this.gEI = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gED != 1 && VideoLoadingProgressView.this.gED != 2) {
                    if (VideoLoadingProgressView.this.gED == 3) {
                        VideoLoadingProgressView.this.gEC = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gEB = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gEA;
                    VideoLoadingProgressView.this.gEC = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gEJ = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gED == 2) {
                    VideoLoadingProgressView.this.brm();
                } else if (VideoLoadingProgressView.this.gED == 3 && VideoLoadingProgressView.this.gEE != null) {
                    VideoLoadingProgressView.this.gEE.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gEs = 3600.0f;
        this.gEt = 5000;
        this.gEu = 30.0f;
        this.gEv = 50;
        this.gEw = 300.0f;
        this.gEx = HttpStatus.SC_BAD_REQUEST;
        this.gEA = -90.0f;
        this.gEB = this.gEA;
        this.gEC = 60.0f;
        this.gEI = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gED != 1 && VideoLoadingProgressView.this.gED != 2) {
                    if (VideoLoadingProgressView.this.gED == 3) {
                        VideoLoadingProgressView.this.gEC = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gEB = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gEA;
                    VideoLoadingProgressView.this.gEC = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gEJ = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gED == 2) {
                    VideoLoadingProgressView.this.brm();
                } else if (VideoLoadingProgressView.this.gED == 3 && VideoLoadingProgressView.this.gEE != null) {
                    VideoLoadingProgressView.this.gEE.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.gEy = getContext().getResources().getColor(d.C0108d.cp_cont_i);
        this.gEz = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds2);
        this.mPaint.setColor(this.gEy);
        this.mPaint.setStrokeWidth(this.gEz);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        brn();
        this.gED = 1;
        this.gEB = -90.0f;
        this.gEA = -90.0f;
        this.gEF = ValueAnimator.ofFloat(this.gEs);
        this.gEF.setDuration(this.gEt);
        this.gEF.addListener(this.gEJ);
        this.gEF.addUpdateListener(this.gEI);
        this.gEF.start();
        setVisibility(0);
        invalidate();
    }

    public void bri() {
        brn();
        this.gED = 2;
        this.gEA = this.gEB;
        this.gEG = ValueAnimator.ofFloat(-this.gEu);
        this.gEG.setDuration(this.gEv);
        this.gEG.addListener(this.gEJ);
        this.gEG.addUpdateListener(this.gEI);
        this.gEG.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brm() {
        brn();
        this.gED = 3;
        this.gEA = this.gEB;
        this.gEH = ValueAnimator.ofFloat(this.gEw);
        this.gEH.setDuration(this.gEx);
        this.gEH.addListener(this.gEJ);
        this.gEH.addUpdateListener(this.gEI);
        this.gEH.start();
    }

    public void brk() {
        brn();
        setVisibility(8);
    }

    private void brn() {
        if (this.gEF != null) {
            this.gEF.cancel();
        }
        if (this.gEG != null) {
            this.gEG.cancel();
        }
        if (this.gEH != null) {
            this.gEH.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.gEE = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        brn();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.gEB, this.gEC, false, this.mPaint);
    }
}
