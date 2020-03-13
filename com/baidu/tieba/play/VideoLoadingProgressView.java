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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VideoLoadingProgressView extends View {
    private RectF WF;
    private float bgD;
    private int dcL;
    private int eWr;
    private int jwA;
    private float jwB;
    private int jwC;
    private float jwD;
    private int jwE;
    private float jwF;
    private float jwG;
    private int jwH;
    private a jwI;
    private ValueAnimator jwJ;
    private ValueAnimator jwK;
    private ValueAnimator jwL;
    private ValueAnimator.AnimatorUpdateListener jwM;
    private AnimatorListenerAdapter jwN;
    private float jwz;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.jwz = 7200.0f;
        this.jwA = 10000;
        this.jwB = 30.0f;
        this.jwC = 50;
        this.jwD = 300.0f;
        this.jwE = 400;
        this.bgD = -90.0f;
        this.jwF = this.bgD;
        this.jwG = 60.0f;
        this.jwM = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jwH != 1 && VideoLoadingProgressView.this.jwH != 2) {
                    if (VideoLoadingProgressView.this.jwH == 3) {
                        VideoLoadingProgressView.this.jwG = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jwF = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bgD;
                    VideoLoadingProgressView.this.jwG = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jwN = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jwH == 2) {
                    VideoLoadingProgressView.this.czr();
                } else if (VideoLoadingProgressView.this.jwH == 3 && VideoLoadingProgressView.this.jwI != null) {
                    VideoLoadingProgressView.this.jwI.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jwz = 7200.0f;
        this.jwA = 10000;
        this.jwB = 30.0f;
        this.jwC = 50;
        this.jwD = 300.0f;
        this.jwE = 400;
        this.bgD = -90.0f;
        this.jwF = this.bgD;
        this.jwG = 60.0f;
        this.jwM = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jwH != 1 && VideoLoadingProgressView.this.jwH != 2) {
                    if (VideoLoadingProgressView.this.jwH == 3) {
                        VideoLoadingProgressView.this.jwG = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jwF = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bgD;
                    VideoLoadingProgressView.this.jwG = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jwN = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jwH == 2) {
                    VideoLoadingProgressView.this.czr();
                } else if (VideoLoadingProgressView.this.jwH == 3 && VideoLoadingProgressView.this.jwI != null) {
                    VideoLoadingProgressView.this.jwI.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jwz = 7200.0f;
        this.jwA = 10000;
        this.jwB = 30.0f;
        this.jwC = 50;
        this.jwD = 300.0f;
        this.jwE = 400;
        this.bgD = -90.0f;
        this.jwF = this.bgD;
        this.jwG = 60.0f;
        this.jwM = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.jwH != 1 && VideoLoadingProgressView.this.jwH != 2) {
                    if (VideoLoadingProgressView.this.jwH == 3) {
                        VideoLoadingProgressView.this.jwG = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.jwF = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.bgD;
                    VideoLoadingProgressView.this.jwG = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.jwN = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.jwH == 2) {
                    VideoLoadingProgressView.this.czr();
                } else if (VideoLoadingProgressView.this.jwH == 3 && VideoLoadingProgressView.this.jwI != null) {
                    VideoLoadingProgressView.this.jwI.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.WF = new RectF();
        this.mPaint = new Paint(1);
        this.eWr = getContext().getResources().getColor(R.color.cp_cont_a);
        this.dcL = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.eWr);
        this.mPaint.setStrokeWidth(this.dcL);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        czs();
        this.jwH = 1;
        this.jwF = -90.0f;
        this.bgD = -90.0f;
        this.jwJ = ValueAnimator.ofFloat(this.jwz);
        this.jwJ.setDuration(this.jwA);
        this.jwJ.addListener(this.jwN);
        this.jwJ.addUpdateListener(this.jwM);
        this.jwJ.start();
        setVisibility(0);
        invalidate();
    }

    public void czo() {
        czs();
        this.jwH = 2;
        this.bgD = this.jwF;
        this.jwK = ValueAnimator.ofFloat(-this.jwB);
        this.jwK.setDuration(this.jwC);
        this.jwK.addListener(this.jwN);
        this.jwK.addUpdateListener(this.jwM);
        this.jwK.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czr() {
        czs();
        this.jwH = 3;
        this.bgD = this.jwF;
        this.jwL = ValueAnimator.ofFloat(this.jwD);
        this.jwL.setDuration(this.jwE);
        this.jwL.addListener(this.jwN);
        this.jwL.addUpdateListener(this.jwM);
        this.jwL.start();
    }

    public void czq() {
        czs();
        setVisibility(8);
    }

    private void czs() {
        if (this.jwJ != null) {
            this.jwJ.cancel();
        }
        if (this.jwK != null) {
            this.jwK.cancel();
        }
        if (this.jwL != null) {
            this.jwL.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.jwI = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        czs();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.WF.left = 1;
        this.WF.top = 1;
        this.WF.right = getWidth() - 1;
        this.WF.bottom = getHeight() - 1;
        canvas.drawArc(this.WF, this.jwF, this.jwG, false, this.mPaint);
    }
}
