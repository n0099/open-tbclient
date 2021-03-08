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
    private float cLk;
    private int ffn;
    private int hzj;
    private float mKg;
    private int mKh;
    private float mKi;
    private int mKj;
    private float mKk;
    private int mKl;
    private float mKm;
    private float mKn;
    private int mKo;
    private a mKp;
    private ValueAnimator mKq;
    private ValueAnimator mKr;
    private ValueAnimator mKs;
    private ValueAnimator.AnimatorUpdateListener mKt;
    private AnimatorListenerAdapter mKu;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.mKg = 7200.0f;
        this.mKh = 10000;
        this.mKi = 30.0f;
        this.mKj = 50;
        this.mKk = 300.0f;
        this.mKl = 400;
        this.cLk = -90.0f;
        this.mKm = this.cLk;
        this.mKn = 60.0f;
        this.mKt = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mKo != 1 && VideoLoadingProgressView.this.mKo != 2) {
                    if (VideoLoadingProgressView.this.mKo == 3) {
                        VideoLoadingProgressView.this.mKn = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mKm = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cLk;
                    VideoLoadingProgressView.this.mKn = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mKu = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mKo == 2) {
                    VideoLoadingProgressView.this.dAt();
                } else if (VideoLoadingProgressView.this.mKo == 3 && VideoLoadingProgressView.this.mKp != null) {
                    VideoLoadingProgressView.this.mKp.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mKg = 7200.0f;
        this.mKh = 10000;
        this.mKi = 30.0f;
        this.mKj = 50;
        this.mKk = 300.0f;
        this.mKl = 400;
        this.cLk = -90.0f;
        this.mKm = this.cLk;
        this.mKn = 60.0f;
        this.mKt = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mKo != 1 && VideoLoadingProgressView.this.mKo != 2) {
                    if (VideoLoadingProgressView.this.mKo == 3) {
                        VideoLoadingProgressView.this.mKn = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mKm = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cLk;
                    VideoLoadingProgressView.this.mKn = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mKu = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mKo == 2) {
                    VideoLoadingProgressView.this.dAt();
                } else if (VideoLoadingProgressView.this.mKo == 3 && VideoLoadingProgressView.this.mKp != null) {
                    VideoLoadingProgressView.this.mKp.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mKg = 7200.0f;
        this.mKh = 10000;
        this.mKi = 30.0f;
        this.mKj = 50;
        this.mKk = 300.0f;
        this.mKl = 400;
        this.cLk = -90.0f;
        this.mKm = this.cLk;
        this.mKn = 60.0f;
        this.mKt = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mKo != 1 && VideoLoadingProgressView.this.mKo != 2) {
                    if (VideoLoadingProgressView.this.mKo == 3) {
                        VideoLoadingProgressView.this.mKn = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mKm = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cLk;
                    VideoLoadingProgressView.this.mKn = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mKu = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mKo == 2) {
                    VideoLoadingProgressView.this.dAt();
                } else if (VideoLoadingProgressView.this.mKo == 3 && VideoLoadingProgressView.this.mKp != null) {
                    VideoLoadingProgressView.this.mKp.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.hzj = getContext().getResources().getColor(R.color.CAM_X0101);
        this.ffn = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.hzj);
        this.mPaint.setStrokeWidth(this.ffn);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        dAu();
        this.mKo = 1;
        this.mKm = -90.0f;
        this.cLk = -90.0f;
        this.mKq = ValueAnimator.ofFloat(this.mKg);
        this.mKq.setDuration(this.mKh);
        this.mKq.addListener(this.mKu);
        this.mKq.addUpdateListener(this.mKt);
        this.mKq.start();
        setVisibility(0);
        invalidate();
    }

    public void dAp() {
        dAu();
        this.mKo = 2;
        this.cLk = this.mKm;
        this.mKr = ValueAnimator.ofFloat(-this.mKi);
        this.mKr.setDuration(this.mKj);
        this.mKr.addListener(this.mKu);
        this.mKr.addUpdateListener(this.mKt);
        this.mKr.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAt() {
        dAu();
        this.mKo = 3;
        this.cLk = this.mKm;
        this.mKs = ValueAnimator.ofFloat(this.mKk);
        this.mKs.setDuration(this.mKl);
        this.mKs.addListener(this.mKu);
        this.mKs.addUpdateListener(this.mKt);
        this.mKs.start();
    }

    public void dAr() {
        dAu();
        setVisibility(8);
    }

    private void dAu() {
        if (this.mKq != null) {
            this.mKq.cancel();
        }
        if (this.mKr != null) {
            this.mKr.cancel();
        }
        if (this.mKs != null) {
            this.mKs.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.mKp = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dAu();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.mKm, this.mKn, false, this.mPaint);
    }
}
