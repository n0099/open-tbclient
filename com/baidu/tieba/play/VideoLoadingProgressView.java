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
    private int bDu;
    private int fRA;
    private float fRB;
    private float fRC;
    private float fRD;
    private int fRE;
    private a fRF;
    private ValueAnimator fRG;
    private ValueAnimator fRH;
    private ValueAnimator fRI;
    private ValueAnimator.AnimatorUpdateListener fRJ;
    private AnimatorListenerAdapter fRK;
    private float fRu;
    private int fRv;
    private float fRw;
    private int fRx;
    private float fRy;
    private int fRz;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.fRu = 7200.0f;
        this.fRv = 10000;
        this.fRw = 30.0f;
        this.fRx = 50;
        this.fRy = 300.0f;
        this.fRz = HttpStatus.SC_BAD_REQUEST;
        this.fRB = -90.0f;
        this.fRC = this.fRB;
        this.fRD = 60.0f;
        this.fRJ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.fRE != 1 && VideoLoadingProgressView.this.fRE != 2) {
                    if (VideoLoadingProgressView.this.fRE == 3) {
                        VideoLoadingProgressView.this.fRD = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.fRC = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.fRB;
                    VideoLoadingProgressView.this.fRD = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.fRK = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.fRE == 2) {
                    VideoLoadingProgressView.this.bgZ();
                } else if (VideoLoadingProgressView.this.fRE == 3 && VideoLoadingProgressView.this.fRF != null) {
                    VideoLoadingProgressView.this.fRF.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fRu = 7200.0f;
        this.fRv = 10000;
        this.fRw = 30.0f;
        this.fRx = 50;
        this.fRy = 300.0f;
        this.fRz = HttpStatus.SC_BAD_REQUEST;
        this.fRB = -90.0f;
        this.fRC = this.fRB;
        this.fRD = 60.0f;
        this.fRJ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.fRE != 1 && VideoLoadingProgressView.this.fRE != 2) {
                    if (VideoLoadingProgressView.this.fRE == 3) {
                        VideoLoadingProgressView.this.fRD = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.fRC = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.fRB;
                    VideoLoadingProgressView.this.fRD = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.fRK = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.fRE == 2) {
                    VideoLoadingProgressView.this.bgZ();
                } else if (VideoLoadingProgressView.this.fRE == 3 && VideoLoadingProgressView.this.fRF != null) {
                    VideoLoadingProgressView.this.fRF.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fRu = 7200.0f;
        this.fRv = 10000;
        this.fRw = 30.0f;
        this.fRx = 50;
        this.fRy = 300.0f;
        this.fRz = HttpStatus.SC_BAD_REQUEST;
        this.fRB = -90.0f;
        this.fRC = this.fRB;
        this.fRD = 60.0f;
        this.fRJ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.fRE != 1 && VideoLoadingProgressView.this.fRE != 2) {
                    if (VideoLoadingProgressView.this.fRE == 3) {
                        VideoLoadingProgressView.this.fRD = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.fRC = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.fRB;
                    VideoLoadingProgressView.this.fRD = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.fRK = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.fRE == 2) {
                    VideoLoadingProgressView.this.bgZ();
                } else if (VideoLoadingProgressView.this.fRE == 3 && VideoLoadingProgressView.this.fRF != null) {
                    VideoLoadingProgressView.this.fRF.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.bDu = getContext().getResources().getColor(d.C0126d.cp_cont_i);
        this.fRA = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds2);
        this.mPaint.setColor(this.bDu);
        this.mPaint.setStrokeWidth(this.fRA);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bha();
        this.fRE = 1;
        this.fRC = -90.0f;
        this.fRB = -90.0f;
        this.fRG = ValueAnimator.ofFloat(this.fRu);
        this.fRG.setDuration(this.fRv);
        this.fRG.addListener(this.fRK);
        this.fRG.addUpdateListener(this.fRJ);
        this.fRG.start();
        setVisibility(0);
        invalidate();
    }

    public void bgV() {
        bha();
        this.fRE = 2;
        this.fRB = this.fRC;
        this.fRH = ValueAnimator.ofFloat(-this.fRw);
        this.fRH.setDuration(this.fRx);
        this.fRH.addListener(this.fRK);
        this.fRH.addUpdateListener(this.fRJ);
        this.fRH.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgZ() {
        bha();
        this.fRE = 3;
        this.fRB = this.fRC;
        this.fRI = ValueAnimator.ofFloat(this.fRy);
        this.fRI.setDuration(this.fRz);
        this.fRI.addListener(this.fRK);
        this.fRI.addUpdateListener(this.fRJ);
        this.fRI.start();
    }

    public void bgX() {
        bha();
        setVisibility(8);
    }

    private void bha() {
        if (this.fRG != null) {
            this.fRG.cancel();
        }
        if (this.fRH != null) {
            this.fRH.cancel();
        }
        if (this.fRI != null) {
            this.fRI.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.fRF = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bha();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.fRC, this.fRD, false, this.mPaint);
    }
}
