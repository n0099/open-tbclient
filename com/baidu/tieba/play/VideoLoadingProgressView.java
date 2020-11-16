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
    private float cAt;
    private int ePr;
    private int hcc;
    private Paint mPaint;
    private RectF mRect;
    private float mjR;
    private int mjS;
    private float mjT;
    private int mjU;
    private float mjV;
    private int mjW;
    private float mjX;
    private float mjY;
    private int mjZ;
    private a mka;
    private ValueAnimator mkb;
    private ValueAnimator mkc;
    private ValueAnimator mkd;
    private ValueAnimator.AnimatorUpdateListener mke;
    private AnimatorListenerAdapter mkf;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.mjR = 7200.0f;
        this.mjS = 10000;
        this.mjT = 30.0f;
        this.mjU = 50;
        this.mjV = 300.0f;
        this.mjW = 400;
        this.cAt = -90.0f;
        this.mjX = this.cAt;
        this.mjY = 60.0f;
        this.mke = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mjZ != 1 && VideoLoadingProgressView.this.mjZ != 2) {
                    if (VideoLoadingProgressView.this.mjZ == 3) {
                        VideoLoadingProgressView.this.mjY = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mjX = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cAt;
                    VideoLoadingProgressView.this.mjY = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mkf = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mjZ == 2) {
                    VideoLoadingProgressView.this.dwF();
                } else if (VideoLoadingProgressView.this.mjZ == 3 && VideoLoadingProgressView.this.mka != null) {
                    VideoLoadingProgressView.this.mka.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mjR = 7200.0f;
        this.mjS = 10000;
        this.mjT = 30.0f;
        this.mjU = 50;
        this.mjV = 300.0f;
        this.mjW = 400;
        this.cAt = -90.0f;
        this.mjX = this.cAt;
        this.mjY = 60.0f;
        this.mke = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mjZ != 1 && VideoLoadingProgressView.this.mjZ != 2) {
                    if (VideoLoadingProgressView.this.mjZ == 3) {
                        VideoLoadingProgressView.this.mjY = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mjX = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cAt;
                    VideoLoadingProgressView.this.mjY = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mkf = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mjZ == 2) {
                    VideoLoadingProgressView.this.dwF();
                } else if (VideoLoadingProgressView.this.mjZ == 3 && VideoLoadingProgressView.this.mka != null) {
                    VideoLoadingProgressView.this.mka.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mjR = 7200.0f;
        this.mjS = 10000;
        this.mjT = 30.0f;
        this.mjU = 50;
        this.mjV = 300.0f;
        this.mjW = 400;
        this.cAt = -90.0f;
        this.mjX = this.cAt;
        this.mjY = 60.0f;
        this.mke = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mjZ != 1 && VideoLoadingProgressView.this.mjZ != 2) {
                    if (VideoLoadingProgressView.this.mjZ == 3) {
                        VideoLoadingProgressView.this.mjY = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mjX = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cAt;
                    VideoLoadingProgressView.this.mjY = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mkf = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mjZ == 2) {
                    VideoLoadingProgressView.this.dwF();
                } else if (VideoLoadingProgressView.this.mjZ == 3 && VideoLoadingProgressView.this.mka != null) {
                    VideoLoadingProgressView.this.mka.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.hcc = getContext().getResources().getColor(R.color.CAM_X0101);
        this.ePr = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.hcc);
        this.mPaint.setStrokeWidth(this.ePr);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        dwG();
        this.mjZ = 1;
        this.mjX = -90.0f;
        this.cAt = -90.0f;
        this.mkb = ValueAnimator.ofFloat(this.mjR);
        this.mkb.setDuration(this.mjS);
        this.mkb.addListener(this.mkf);
        this.mkb.addUpdateListener(this.mke);
        this.mkb.start();
        setVisibility(0);
        invalidate();
    }

    public void dwB() {
        dwG();
        this.mjZ = 2;
        this.cAt = this.mjX;
        this.mkc = ValueAnimator.ofFloat(-this.mjT);
        this.mkc.setDuration(this.mjU);
        this.mkc.addListener(this.mkf);
        this.mkc.addUpdateListener(this.mke);
        this.mkc.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwF() {
        dwG();
        this.mjZ = 3;
        this.cAt = this.mjX;
        this.mkd = ValueAnimator.ofFloat(this.mjV);
        this.mkd.setDuration(this.mjW);
        this.mkd.addListener(this.mkf);
        this.mkd.addUpdateListener(this.mke);
        this.mkd.start();
    }

    public void dwD() {
        dwG();
        setVisibility(8);
    }

    private void dwG() {
        if (this.mkb != null) {
            this.mkb.cancel();
        }
        if (this.mkc != null) {
            this.mkc.cancel();
        }
        if (this.mkd != null) {
            this.mkd.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.mka = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dwG();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.mjX, this.mjY, false, this.mPaint);
    }
}
