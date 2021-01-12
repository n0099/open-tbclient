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
    private float cHq;
    private int fby;
    private int htc;
    private Paint mPaint;
    private RectF mRect;
    private float myE;
    private int myF;
    private float myG;
    private int myH;
    private float myI;
    private int myJ;
    private float myK;
    private float myL;
    private int myM;
    private a myN;
    private ValueAnimator myO;
    private ValueAnimator myP;
    private ValueAnimator myQ;
    private ValueAnimator.AnimatorUpdateListener myR;
    private AnimatorListenerAdapter myS;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.myE = 7200.0f;
        this.myF = 10000;
        this.myG = 30.0f;
        this.myH = 50;
        this.myI = 300.0f;
        this.myJ = 400;
        this.cHq = -90.0f;
        this.myK = this.cHq;
        this.myL = 60.0f;
        this.myR = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.myM != 1 && VideoLoadingProgressView.this.myM != 2) {
                    if (VideoLoadingProgressView.this.myM == 3) {
                        VideoLoadingProgressView.this.myL = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.myK = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cHq;
                    VideoLoadingProgressView.this.myL = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.myS = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.myM == 2) {
                    VideoLoadingProgressView.this.dxW();
                } else if (VideoLoadingProgressView.this.myM == 3 && VideoLoadingProgressView.this.myN != null) {
                    VideoLoadingProgressView.this.myN.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.myE = 7200.0f;
        this.myF = 10000;
        this.myG = 30.0f;
        this.myH = 50;
        this.myI = 300.0f;
        this.myJ = 400;
        this.cHq = -90.0f;
        this.myK = this.cHq;
        this.myL = 60.0f;
        this.myR = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.myM != 1 && VideoLoadingProgressView.this.myM != 2) {
                    if (VideoLoadingProgressView.this.myM == 3) {
                        VideoLoadingProgressView.this.myL = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.myK = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cHq;
                    VideoLoadingProgressView.this.myL = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.myS = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.myM == 2) {
                    VideoLoadingProgressView.this.dxW();
                } else if (VideoLoadingProgressView.this.myM == 3 && VideoLoadingProgressView.this.myN != null) {
                    VideoLoadingProgressView.this.myN.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.myE = 7200.0f;
        this.myF = 10000;
        this.myG = 30.0f;
        this.myH = 50;
        this.myI = 300.0f;
        this.myJ = 400;
        this.cHq = -90.0f;
        this.myK = this.cHq;
        this.myL = 60.0f;
        this.myR = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.myM != 1 && VideoLoadingProgressView.this.myM != 2) {
                    if (VideoLoadingProgressView.this.myM == 3) {
                        VideoLoadingProgressView.this.myL = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.myK = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cHq;
                    VideoLoadingProgressView.this.myL = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.myS = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.myM == 2) {
                    VideoLoadingProgressView.this.dxW();
                } else if (VideoLoadingProgressView.this.myM == 3 && VideoLoadingProgressView.this.myN != null) {
                    VideoLoadingProgressView.this.myN.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.htc = getContext().getResources().getColor(R.color.CAM_X0101);
        this.fby = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.htc);
        this.mPaint.setStrokeWidth(this.fby);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        dxX();
        this.myM = 1;
        this.myK = -90.0f;
        this.cHq = -90.0f;
        this.myO = ValueAnimator.ofFloat(this.myE);
        this.myO.setDuration(this.myF);
        this.myO.addListener(this.myS);
        this.myO.addUpdateListener(this.myR);
        this.myO.start();
        setVisibility(0);
        invalidate();
    }

    public void dxS() {
        dxX();
        this.myM = 2;
        this.cHq = this.myK;
        this.myP = ValueAnimator.ofFloat(-this.myG);
        this.myP.setDuration(this.myH);
        this.myP.addListener(this.myS);
        this.myP.addUpdateListener(this.myR);
        this.myP.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxW() {
        dxX();
        this.myM = 3;
        this.cHq = this.myK;
        this.myQ = ValueAnimator.ofFloat(this.myI);
        this.myQ.setDuration(this.myJ);
        this.myQ.addListener(this.myS);
        this.myQ.addUpdateListener(this.myR);
        this.myQ.start();
    }

    public void dxU() {
        dxX();
        setVisibility(8);
    }

    private void dxX() {
        if (this.myO != null) {
            this.myO.cancel();
        }
        if (this.myP != null) {
            this.myP.cancel();
        }
        if (this.myQ != null) {
            this.myQ.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.myN = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dxX();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.myK, this.myL, false, this.mPaint);
    }
}
