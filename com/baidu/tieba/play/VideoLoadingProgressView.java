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
    private float cJK;
    private int fdO;
    private int hxA;
    private float mHZ;
    private int mIa;
    private float mIb;
    private int mIc;
    private float mIe;
    private int mIf;
    private float mIg;
    private float mIh;
    private int mIi;
    private a mIj;
    private ValueAnimator mIk;
    private ValueAnimator mIl;
    private ValueAnimator mIm;
    private ValueAnimator.AnimatorUpdateListener mIn;
    private AnimatorListenerAdapter mIo;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.mHZ = 7200.0f;
        this.mIa = 10000;
        this.mIb = 30.0f;
        this.mIc = 50;
        this.mIe = 300.0f;
        this.mIf = 400;
        this.cJK = -90.0f;
        this.mIg = this.cJK;
        this.mIh = 60.0f;
        this.mIn = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mIi != 1 && VideoLoadingProgressView.this.mIi != 2) {
                    if (VideoLoadingProgressView.this.mIi == 3) {
                        VideoLoadingProgressView.this.mIh = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mIg = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cJK;
                    VideoLoadingProgressView.this.mIh = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mIo = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mIi == 2) {
                    VideoLoadingProgressView.this.dAl();
                } else if (VideoLoadingProgressView.this.mIi == 3 && VideoLoadingProgressView.this.mIj != null) {
                    VideoLoadingProgressView.this.mIj.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHZ = 7200.0f;
        this.mIa = 10000;
        this.mIb = 30.0f;
        this.mIc = 50;
        this.mIe = 300.0f;
        this.mIf = 400;
        this.cJK = -90.0f;
        this.mIg = this.cJK;
        this.mIh = 60.0f;
        this.mIn = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mIi != 1 && VideoLoadingProgressView.this.mIi != 2) {
                    if (VideoLoadingProgressView.this.mIi == 3) {
                        VideoLoadingProgressView.this.mIh = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mIg = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cJK;
                    VideoLoadingProgressView.this.mIh = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mIo = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mIi == 2) {
                    VideoLoadingProgressView.this.dAl();
                } else if (VideoLoadingProgressView.this.mIi == 3 && VideoLoadingProgressView.this.mIj != null) {
                    VideoLoadingProgressView.this.mIj.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHZ = 7200.0f;
        this.mIa = 10000;
        this.mIb = 30.0f;
        this.mIc = 50;
        this.mIe = 300.0f;
        this.mIf = 400;
        this.cJK = -90.0f;
        this.mIg = this.cJK;
        this.mIh = 60.0f;
        this.mIn = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mIi != 1 && VideoLoadingProgressView.this.mIi != 2) {
                    if (VideoLoadingProgressView.this.mIi == 3) {
                        VideoLoadingProgressView.this.mIh = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mIg = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cJK;
                    VideoLoadingProgressView.this.mIh = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mIo = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mIi == 2) {
                    VideoLoadingProgressView.this.dAl();
                } else if (VideoLoadingProgressView.this.mIi == 3 && VideoLoadingProgressView.this.mIj != null) {
                    VideoLoadingProgressView.this.mIj.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.hxA = getContext().getResources().getColor(R.color.CAM_X0101);
        this.fdO = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.hxA);
        this.mPaint.setStrokeWidth(this.fdO);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        dAm();
        this.mIi = 1;
        this.mIg = -90.0f;
        this.cJK = -90.0f;
        this.mIk = ValueAnimator.ofFloat(this.mHZ);
        this.mIk.setDuration(this.mIa);
        this.mIk.addListener(this.mIo);
        this.mIk.addUpdateListener(this.mIn);
        this.mIk.start();
        setVisibility(0);
        invalidate();
    }

    public void dAh() {
        dAm();
        this.mIi = 2;
        this.cJK = this.mIg;
        this.mIl = ValueAnimator.ofFloat(-this.mIb);
        this.mIl.setDuration(this.mIc);
        this.mIl.addListener(this.mIo);
        this.mIl.addUpdateListener(this.mIn);
        this.mIl.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAl() {
        dAm();
        this.mIi = 3;
        this.cJK = this.mIg;
        this.mIm = ValueAnimator.ofFloat(this.mIe);
        this.mIm.setDuration(this.mIf);
        this.mIm.addListener(this.mIo);
        this.mIm.addUpdateListener(this.mIn);
        this.mIm.start();
    }

    public void dAj() {
        dAm();
        setVisibility(8);
    }

    private void dAm() {
        if (this.mIk != null) {
            this.mIk.cancel();
        }
        if (this.mIl != null) {
            this.mIl.cancel();
        }
        if (this.mIm != null) {
            this.mIm.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.mIj = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dAm();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.mIg, this.mIh, false, this.mPaint);
    }
}
