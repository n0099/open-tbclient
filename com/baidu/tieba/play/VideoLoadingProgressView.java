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
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class VideoLoadingProgressView extends View {
    private int bUp;
    private int goA;
    private float goB;
    private int goC;
    private float goD;
    private int goE;
    private int goF;
    private float goG;
    private float goH;
    private float goI;
    private int goJ;
    private a goK;
    private ValueAnimator goL;
    private ValueAnimator goM;
    private ValueAnimator goN;
    private ValueAnimator.AnimatorUpdateListener goO;
    private AnimatorListenerAdapter goP;
    private float goz;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.goz = 7200.0f;
        this.goA = 10000;
        this.goB = 30.0f;
        this.goC = 50;
        this.goD = 300.0f;
        this.goE = HttpStatus.SC_BAD_REQUEST;
        this.goG = -90.0f;
        this.goH = this.goG;
        this.goI = 60.0f;
        this.goO = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.goJ != 1 && VideoLoadingProgressView.this.goJ != 2) {
                    if (VideoLoadingProgressView.this.goJ == 3) {
                        VideoLoadingProgressView.this.goI = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.goH = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.goG;
                    VideoLoadingProgressView.this.goI = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.goP = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.goJ == 2) {
                    VideoLoadingProgressView.this.bnx();
                } else if (VideoLoadingProgressView.this.goJ == 3 && VideoLoadingProgressView.this.goK != null) {
                    VideoLoadingProgressView.this.goK.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.goz = 7200.0f;
        this.goA = 10000;
        this.goB = 30.0f;
        this.goC = 50;
        this.goD = 300.0f;
        this.goE = HttpStatus.SC_BAD_REQUEST;
        this.goG = -90.0f;
        this.goH = this.goG;
        this.goI = 60.0f;
        this.goO = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.goJ != 1 && VideoLoadingProgressView.this.goJ != 2) {
                    if (VideoLoadingProgressView.this.goJ == 3) {
                        VideoLoadingProgressView.this.goI = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.goH = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.goG;
                    VideoLoadingProgressView.this.goI = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.goP = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.goJ == 2) {
                    VideoLoadingProgressView.this.bnx();
                } else if (VideoLoadingProgressView.this.goJ == 3 && VideoLoadingProgressView.this.goK != null) {
                    VideoLoadingProgressView.this.goK.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.goz = 7200.0f;
        this.goA = 10000;
        this.goB = 30.0f;
        this.goC = 50;
        this.goD = 300.0f;
        this.goE = HttpStatus.SC_BAD_REQUEST;
        this.goG = -90.0f;
        this.goH = this.goG;
        this.goI = 60.0f;
        this.goO = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.goJ != 1 && VideoLoadingProgressView.this.goJ != 2) {
                    if (VideoLoadingProgressView.this.goJ == 3) {
                        VideoLoadingProgressView.this.goI = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.goH = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.goG;
                    VideoLoadingProgressView.this.goI = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.goP = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.goJ == 2) {
                    VideoLoadingProgressView.this.bnx();
                } else if (VideoLoadingProgressView.this.goJ == 3 && VideoLoadingProgressView.this.goK != null) {
                    VideoLoadingProgressView.this.goK.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.bUp = getContext().getResources().getColor(e.d.cp_cont_i);
        this.goF = com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.ds2);
        this.mPaint.setColor(this.bUp);
        this.mPaint.setStrokeWidth(this.goF);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bny();
        this.goJ = 1;
        this.goH = -90.0f;
        this.goG = -90.0f;
        this.goL = ValueAnimator.ofFloat(this.goz);
        this.goL.setDuration(this.goA);
        this.goL.addListener(this.goP);
        this.goL.addUpdateListener(this.goO);
        this.goL.start();
        setVisibility(0);
        invalidate();
    }

    public void bnt() {
        bny();
        this.goJ = 2;
        this.goG = this.goH;
        this.goM = ValueAnimator.ofFloat(-this.goB);
        this.goM.setDuration(this.goC);
        this.goM.addListener(this.goP);
        this.goM.addUpdateListener(this.goO);
        this.goM.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnx() {
        bny();
        this.goJ = 3;
        this.goG = this.goH;
        this.goN = ValueAnimator.ofFloat(this.goD);
        this.goN.setDuration(this.goE);
        this.goN.addListener(this.goP);
        this.goN.addUpdateListener(this.goO);
        this.goN.start();
    }

    public void bnv() {
        bny();
        setVisibility(8);
    }

    private void bny() {
        if (this.goL != null) {
            this.goL.cancel();
        }
        if (this.goM != null) {
            this.goM.cancel();
        }
        if (this.goN != null) {
            this.goN.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.goK = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bny();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.goH, this.goI, false, this.mPaint);
    }
}
