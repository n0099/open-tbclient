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
    private int bLx;
    private float gcG;
    private int gcH;
    private float gcI;
    private int gcJ;
    private float gcK;
    private int gcL;
    private int gcM;
    private float gcN;
    private float gcO;
    private float gcP;
    private int gcQ;
    private a gcR;
    private ValueAnimator gcS;
    private ValueAnimator gcT;
    private ValueAnimator gcU;
    private ValueAnimator.AnimatorUpdateListener gcV;
    private AnimatorListenerAdapter gcW;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.gcG = 7200.0f;
        this.gcH = 10000;
        this.gcI = 30.0f;
        this.gcJ = 50;
        this.gcK = 300.0f;
        this.gcL = HttpStatus.SC_BAD_REQUEST;
        this.gcN = -90.0f;
        this.gcO = this.gcN;
        this.gcP = 60.0f;
        this.gcV = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gcQ != 1 && VideoLoadingProgressView.this.gcQ != 2) {
                    if (VideoLoadingProgressView.this.gcQ == 3) {
                        VideoLoadingProgressView.this.gcP = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gcO = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gcN;
                    VideoLoadingProgressView.this.gcP = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gcW = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gcQ == 2) {
                    VideoLoadingProgressView.this.blX();
                } else if (VideoLoadingProgressView.this.gcQ == 3 && VideoLoadingProgressView.this.gcR != null) {
                    VideoLoadingProgressView.this.gcR.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gcG = 7200.0f;
        this.gcH = 10000;
        this.gcI = 30.0f;
        this.gcJ = 50;
        this.gcK = 300.0f;
        this.gcL = HttpStatus.SC_BAD_REQUEST;
        this.gcN = -90.0f;
        this.gcO = this.gcN;
        this.gcP = 60.0f;
        this.gcV = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gcQ != 1 && VideoLoadingProgressView.this.gcQ != 2) {
                    if (VideoLoadingProgressView.this.gcQ == 3) {
                        VideoLoadingProgressView.this.gcP = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gcO = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gcN;
                    VideoLoadingProgressView.this.gcP = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gcW = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gcQ == 2) {
                    VideoLoadingProgressView.this.blX();
                } else if (VideoLoadingProgressView.this.gcQ == 3 && VideoLoadingProgressView.this.gcR != null) {
                    VideoLoadingProgressView.this.gcR.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gcG = 7200.0f;
        this.gcH = 10000;
        this.gcI = 30.0f;
        this.gcJ = 50;
        this.gcK = 300.0f;
        this.gcL = HttpStatus.SC_BAD_REQUEST;
        this.gcN = -90.0f;
        this.gcO = this.gcN;
        this.gcP = 60.0f;
        this.gcV = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gcQ != 1 && VideoLoadingProgressView.this.gcQ != 2) {
                    if (VideoLoadingProgressView.this.gcQ == 3) {
                        VideoLoadingProgressView.this.gcP = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gcO = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gcN;
                    VideoLoadingProgressView.this.gcP = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gcW = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gcQ == 2) {
                    VideoLoadingProgressView.this.blX();
                } else if (VideoLoadingProgressView.this.gcQ == 3 && VideoLoadingProgressView.this.gcR != null) {
                    VideoLoadingProgressView.this.gcR.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.bLx = getContext().getResources().getColor(d.C0141d.cp_cont_i);
        this.gcM = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds2);
        this.mPaint.setColor(this.bLx);
        this.mPaint.setStrokeWidth(this.gcM);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        blY();
        this.gcQ = 1;
        this.gcO = -90.0f;
        this.gcN = -90.0f;
        this.gcS = ValueAnimator.ofFloat(this.gcG);
        this.gcS.setDuration(this.gcH);
        this.gcS.addListener(this.gcW);
        this.gcS.addUpdateListener(this.gcV);
        this.gcS.start();
        setVisibility(0);
        invalidate();
    }

    public void blT() {
        blY();
        this.gcQ = 2;
        this.gcN = this.gcO;
        this.gcT = ValueAnimator.ofFloat(-this.gcI);
        this.gcT.setDuration(this.gcJ);
        this.gcT.addListener(this.gcW);
        this.gcT.addUpdateListener(this.gcV);
        this.gcT.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blX() {
        blY();
        this.gcQ = 3;
        this.gcN = this.gcO;
        this.gcU = ValueAnimator.ofFloat(this.gcK);
        this.gcU.setDuration(this.gcL);
        this.gcU.addListener(this.gcW);
        this.gcU.addUpdateListener(this.gcV);
        this.gcU.start();
    }

    public void blV() {
        blY();
        setVisibility(8);
    }

    private void blY() {
        if (this.gcS != null) {
            this.gcS.cancel();
        }
        if (this.gcT != null) {
            this.gcT.cancel();
        }
        if (this.gcU != null) {
            this.gcU.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.gcR = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        blY();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.gcO, this.gcP, false, this.mPaint);
    }
}
