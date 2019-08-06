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
    private float amk;
    private int dLj;
    private float iyh;
    private int iyi;
    private float iyj;
    private int iyk;
    private float iyl;
    private int iym;
    private int iyn;
    private float iyo;
    private float iyp;
    private int iyq;
    private a iyr;
    private ValueAnimator iys;
    private ValueAnimator iyt;
    private ValueAnimator iyu;
    private ValueAnimator.AnimatorUpdateListener iyv;
    private AnimatorListenerAdapter iyw;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.iyh = 7200.0f;
        this.iyi = 10000;
        this.iyj = 30.0f;
        this.iyk = 50;
        this.iyl = 300.0f;
        this.iym = 400;
        this.amk = -90.0f;
        this.iyo = this.amk;
        this.iyp = 60.0f;
        this.iyv = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.iyq != 1 && VideoLoadingProgressView.this.iyq != 2) {
                    if (VideoLoadingProgressView.this.iyq == 3) {
                        VideoLoadingProgressView.this.iyp = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.iyo = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.amk;
                    VideoLoadingProgressView.this.iyp = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.iyw = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.iyq == 2) {
                    VideoLoadingProgressView.this.cfc();
                } else if (VideoLoadingProgressView.this.iyq == 3 && VideoLoadingProgressView.this.iyr != null) {
                    VideoLoadingProgressView.this.iyr.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iyh = 7200.0f;
        this.iyi = 10000;
        this.iyj = 30.0f;
        this.iyk = 50;
        this.iyl = 300.0f;
        this.iym = 400;
        this.amk = -90.0f;
        this.iyo = this.amk;
        this.iyp = 60.0f;
        this.iyv = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.iyq != 1 && VideoLoadingProgressView.this.iyq != 2) {
                    if (VideoLoadingProgressView.this.iyq == 3) {
                        VideoLoadingProgressView.this.iyp = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.iyo = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.amk;
                    VideoLoadingProgressView.this.iyp = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.iyw = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.iyq == 2) {
                    VideoLoadingProgressView.this.cfc();
                } else if (VideoLoadingProgressView.this.iyq == 3 && VideoLoadingProgressView.this.iyr != null) {
                    VideoLoadingProgressView.this.iyr.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iyh = 7200.0f;
        this.iyi = 10000;
        this.iyj = 30.0f;
        this.iyk = 50;
        this.iyl = 300.0f;
        this.iym = 400;
        this.amk = -90.0f;
        this.iyo = this.amk;
        this.iyp = 60.0f;
        this.iyv = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.iyq != 1 && VideoLoadingProgressView.this.iyq != 2) {
                    if (VideoLoadingProgressView.this.iyq == 3) {
                        VideoLoadingProgressView.this.iyp = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.iyo = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.amk;
                    VideoLoadingProgressView.this.iyp = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.iyw = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.iyq == 2) {
                    VideoLoadingProgressView.this.cfc();
                } else if (VideoLoadingProgressView.this.iyq == 3 && VideoLoadingProgressView.this.iyr != null) {
                    VideoLoadingProgressView.this.iyr.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.dLj = getContext().getResources().getColor(R.color.cp_btn_a);
        this.iyn = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.dLj);
        this.mPaint.setStrokeWidth(this.iyn);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        cfd();
        this.iyq = 1;
        this.iyo = -90.0f;
        this.amk = -90.0f;
        this.iys = ValueAnimator.ofFloat(this.iyh);
        this.iys.setDuration(this.iyi);
        this.iys.addListener(this.iyw);
        this.iys.addUpdateListener(this.iyv);
        this.iys.start();
        setVisibility(0);
        invalidate();
    }

    public void ceY() {
        cfd();
        this.iyq = 2;
        this.amk = this.iyo;
        this.iyt = ValueAnimator.ofFloat(-this.iyj);
        this.iyt.setDuration(this.iyk);
        this.iyt.addListener(this.iyw);
        this.iyt.addUpdateListener(this.iyv);
        this.iyt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfc() {
        cfd();
        this.iyq = 3;
        this.amk = this.iyo;
        this.iyu = ValueAnimator.ofFloat(this.iyl);
        this.iyu.setDuration(this.iym);
        this.iyu.addListener(this.iyw);
        this.iyu.addUpdateListener(this.iyv);
        this.iyu.start();
    }

    public void cfa() {
        cfd();
        setVisibility(8);
    }

    private void cfd() {
        if (this.iys != null) {
            this.iys.cancel();
        }
        if (this.iyt != null) {
            this.iyt.cancel();
        }
        if (this.iyu != null) {
            this.iyu.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.iyr = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cfd();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.iyo, this.iyp, false, this.mPaint);
    }
}
