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
    private RectF Ol;
    private float aGb;
    private int ebF;
    private float iyG;
    private int iyH;
    private float iyI;
    private int iyJ;
    private float iyK;
    private int iyL;
    private int iyM;
    private float iyN;
    private float iyO;
    private int iyP;
    private a iyQ;
    private ValueAnimator iyR;
    private ValueAnimator iyS;
    private ValueAnimator iyT;
    private ValueAnimator.AnimatorUpdateListener iyU;
    private AnimatorListenerAdapter iyV;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.iyG = 7200.0f;
        this.iyH = 10000;
        this.iyI = 30.0f;
        this.iyJ = 50;
        this.iyK = 300.0f;
        this.iyL = 400;
        this.aGb = -90.0f;
        this.iyN = this.aGb;
        this.iyO = 60.0f;
        this.iyU = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.iyP != 1 && VideoLoadingProgressView.this.iyP != 2) {
                    if (VideoLoadingProgressView.this.iyP == 3) {
                        VideoLoadingProgressView.this.iyO = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.iyN = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.aGb;
                    VideoLoadingProgressView.this.iyO = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.iyV = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.iyP == 2) {
                    VideoLoadingProgressView.this.ccR();
                } else if (VideoLoadingProgressView.this.iyP == 3 && VideoLoadingProgressView.this.iyQ != null) {
                    VideoLoadingProgressView.this.iyQ.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iyG = 7200.0f;
        this.iyH = 10000;
        this.iyI = 30.0f;
        this.iyJ = 50;
        this.iyK = 300.0f;
        this.iyL = 400;
        this.aGb = -90.0f;
        this.iyN = this.aGb;
        this.iyO = 60.0f;
        this.iyU = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.iyP != 1 && VideoLoadingProgressView.this.iyP != 2) {
                    if (VideoLoadingProgressView.this.iyP == 3) {
                        VideoLoadingProgressView.this.iyO = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.iyN = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.aGb;
                    VideoLoadingProgressView.this.iyO = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.iyV = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.iyP == 2) {
                    VideoLoadingProgressView.this.ccR();
                } else if (VideoLoadingProgressView.this.iyP == 3 && VideoLoadingProgressView.this.iyQ != null) {
                    VideoLoadingProgressView.this.iyQ.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iyG = 7200.0f;
        this.iyH = 10000;
        this.iyI = 30.0f;
        this.iyJ = 50;
        this.iyK = 300.0f;
        this.iyL = 400;
        this.aGb = -90.0f;
        this.iyN = this.aGb;
        this.iyO = 60.0f;
        this.iyU = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.iyP != 1 && VideoLoadingProgressView.this.iyP != 2) {
                    if (VideoLoadingProgressView.this.iyP == 3) {
                        VideoLoadingProgressView.this.iyO = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.iyN = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.aGb;
                    VideoLoadingProgressView.this.iyO = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.iyV = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.iyP == 2) {
                    VideoLoadingProgressView.this.ccR();
                } else if (VideoLoadingProgressView.this.iyP == 3 && VideoLoadingProgressView.this.iyQ != null) {
                    VideoLoadingProgressView.this.iyQ.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.Ol = new RectF();
        this.mPaint = new Paint(1);
        this.ebF = getContext().getResources().getColor(R.color.cp_cont_a);
        this.iyM = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.ebF);
        this.mPaint.setStrokeWidth(this.iyM);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        ccS();
        this.iyP = 1;
        this.iyN = -90.0f;
        this.aGb = -90.0f;
        this.iyR = ValueAnimator.ofFloat(this.iyG);
        this.iyR.setDuration(this.iyH);
        this.iyR.addListener(this.iyV);
        this.iyR.addUpdateListener(this.iyU);
        this.iyR.start();
        setVisibility(0);
        invalidate();
    }

    public void ccN() {
        ccS();
        this.iyP = 2;
        this.aGb = this.iyN;
        this.iyS = ValueAnimator.ofFloat(-this.iyI);
        this.iyS.setDuration(this.iyJ);
        this.iyS.addListener(this.iyV);
        this.iyS.addUpdateListener(this.iyU);
        this.iyS.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccR() {
        ccS();
        this.iyP = 3;
        this.aGb = this.iyN;
        this.iyT = ValueAnimator.ofFloat(this.iyK);
        this.iyT.setDuration(this.iyL);
        this.iyT.addListener(this.iyV);
        this.iyT.addUpdateListener(this.iyU);
        this.iyT.start();
    }

    public void ccP() {
        ccS();
        setVisibility(8);
    }

    private void ccS() {
        if (this.iyR != null) {
            this.iyR.cancel();
        }
        if (this.iyS != null) {
            this.iyS.cancel();
        }
        if (this.iyT != null) {
            this.iyT.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.iyQ = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ccS();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.Ol.left = 1;
        this.Ol.top = 1;
        this.Ol.right = getWidth() - 1;
        this.Ol.bottom = getHeight() - 1;
        canvas.drawArc(this.Ol, this.iyN, this.iyO, false, this.mPaint);
    }
}
