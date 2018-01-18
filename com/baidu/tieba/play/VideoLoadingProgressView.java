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
    private int gtA;
    private float gtB;
    private int gtC;
    private float gtD;
    private int gtE;
    private int gtF;
    private int gtG;
    private float gtH;
    private float gtI;
    private float gtJ;
    private int gtK;
    private a gtL;
    private ValueAnimator gtM;
    private ValueAnimator gtN;
    private ValueAnimator gtO;
    private ValueAnimator.AnimatorUpdateListener gtP;
    private AnimatorListenerAdapter gtQ;
    private float gtz;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.gtz = 3600.0f;
        this.gtA = 5000;
        this.gtB = 30.0f;
        this.gtC = 50;
        this.gtD = 300.0f;
        this.gtE = HttpStatus.SC_BAD_REQUEST;
        this.gtH = -90.0f;
        this.gtI = this.gtH;
        this.gtJ = 60.0f;
        this.gtP = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gtK != 1 && VideoLoadingProgressView.this.gtK != 2) {
                    if (VideoLoadingProgressView.this.gtK == 3) {
                        VideoLoadingProgressView.this.gtJ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gtI = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gtH;
                    VideoLoadingProgressView.this.gtJ = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gtQ = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gtK == 2) {
                    VideoLoadingProgressView.this.bkF();
                } else if (VideoLoadingProgressView.this.gtK == 3 && VideoLoadingProgressView.this.gtL != null) {
                    VideoLoadingProgressView.this.gtL.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gtz = 3600.0f;
        this.gtA = 5000;
        this.gtB = 30.0f;
        this.gtC = 50;
        this.gtD = 300.0f;
        this.gtE = HttpStatus.SC_BAD_REQUEST;
        this.gtH = -90.0f;
        this.gtI = this.gtH;
        this.gtJ = 60.0f;
        this.gtP = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gtK != 1 && VideoLoadingProgressView.this.gtK != 2) {
                    if (VideoLoadingProgressView.this.gtK == 3) {
                        VideoLoadingProgressView.this.gtJ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gtI = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gtH;
                    VideoLoadingProgressView.this.gtJ = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gtQ = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gtK == 2) {
                    VideoLoadingProgressView.this.bkF();
                } else if (VideoLoadingProgressView.this.gtK == 3 && VideoLoadingProgressView.this.gtL != null) {
                    VideoLoadingProgressView.this.gtL.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gtz = 3600.0f;
        this.gtA = 5000;
        this.gtB = 30.0f;
        this.gtC = 50;
        this.gtD = 300.0f;
        this.gtE = HttpStatus.SC_BAD_REQUEST;
        this.gtH = -90.0f;
        this.gtI = this.gtH;
        this.gtJ = 60.0f;
        this.gtP = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.gtK != 1 && VideoLoadingProgressView.this.gtK != 2) {
                    if (VideoLoadingProgressView.this.gtK == 3) {
                        VideoLoadingProgressView.this.gtJ = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gtI = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.gtH;
                    VideoLoadingProgressView.this.gtJ = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gtQ = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.gtK == 2) {
                    VideoLoadingProgressView.this.bkF();
                } else if (VideoLoadingProgressView.this.gtK == 3 && VideoLoadingProgressView.this.gtL != null) {
                    VideoLoadingProgressView.this.gtL.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.gtF = getContext().getResources().getColor(d.C0107d.cp_cont_i);
        this.gtG = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds2);
        this.mPaint.setColor(this.gtF);
        this.mPaint.setStrokeWidth(this.gtG);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bkG();
        this.gtK = 1;
        this.gtI = -90.0f;
        this.gtH = -90.0f;
        this.gtM = ValueAnimator.ofFloat(this.gtz);
        this.gtM.setDuration(this.gtA);
        this.gtM.addListener(this.gtQ);
        this.gtM.addUpdateListener(this.gtP);
        this.gtM.start();
        setVisibility(0);
        invalidate();
    }

    public void bkB() {
        bkG();
        this.gtK = 2;
        this.gtH = this.gtI;
        this.gtN = ValueAnimator.ofFloat(-this.gtB);
        this.gtN.setDuration(this.gtC);
        this.gtN.addListener(this.gtQ);
        this.gtN.addUpdateListener(this.gtP);
        this.gtN.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkF() {
        bkG();
        this.gtK = 3;
        this.gtH = this.gtI;
        this.gtO = ValueAnimator.ofFloat(this.gtD);
        this.gtO.setDuration(this.gtE);
        this.gtO.addListener(this.gtQ);
        this.gtO.addUpdateListener(this.gtP);
        this.gtO.start();
    }

    public void bkD() {
        bkG();
        setVisibility(8);
    }

    private void bkG() {
        if (this.gtM != null) {
            this.gtM.cancel();
        }
        if (this.gtN != null) {
            this.gtN.cancel();
        }
        if (this.gtO != null) {
            this.gtO.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.gtL = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bkG();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.gtI, this.gtJ, false, this.mPaint);
    }
}
