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
    private int dLc;
    private float ixe;
    private int ixf;
    private float ixg;
    private int ixh;
    private float ixi;
    private int ixj;
    private int ixk;
    private float ixl;
    private float ixm;
    private int ixn;
    private a ixo;
    private ValueAnimator ixp;
    private ValueAnimator ixq;
    private ValueAnimator ixr;
    private ValueAnimator.AnimatorUpdateListener ixs;
    private AnimatorListenerAdapter ixt;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.ixe = 7200.0f;
        this.ixf = 10000;
        this.ixg = 30.0f;
        this.ixh = 50;
        this.ixi = 300.0f;
        this.ixj = 400;
        this.amk = -90.0f;
        this.ixl = this.amk;
        this.ixm = 60.0f;
        this.ixs = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.ixn != 1 && VideoLoadingProgressView.this.ixn != 2) {
                    if (VideoLoadingProgressView.this.ixn == 3) {
                        VideoLoadingProgressView.this.ixm = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.ixl = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.amk;
                    VideoLoadingProgressView.this.ixm = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.ixt = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.ixn == 2) {
                    VideoLoadingProgressView.this.ceK();
                } else if (VideoLoadingProgressView.this.ixn == 3 && VideoLoadingProgressView.this.ixo != null) {
                    VideoLoadingProgressView.this.ixo.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ixe = 7200.0f;
        this.ixf = 10000;
        this.ixg = 30.0f;
        this.ixh = 50;
        this.ixi = 300.0f;
        this.ixj = 400;
        this.amk = -90.0f;
        this.ixl = this.amk;
        this.ixm = 60.0f;
        this.ixs = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.ixn != 1 && VideoLoadingProgressView.this.ixn != 2) {
                    if (VideoLoadingProgressView.this.ixn == 3) {
                        VideoLoadingProgressView.this.ixm = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.ixl = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.amk;
                    VideoLoadingProgressView.this.ixm = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.ixt = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.ixn == 2) {
                    VideoLoadingProgressView.this.ceK();
                } else if (VideoLoadingProgressView.this.ixn == 3 && VideoLoadingProgressView.this.ixo != null) {
                    VideoLoadingProgressView.this.ixo.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ixe = 7200.0f;
        this.ixf = 10000;
        this.ixg = 30.0f;
        this.ixh = 50;
        this.ixi = 300.0f;
        this.ixj = 400;
        this.amk = -90.0f;
        this.ixl = this.amk;
        this.ixm = 60.0f;
        this.ixs = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.ixn != 1 && VideoLoadingProgressView.this.ixn != 2) {
                    if (VideoLoadingProgressView.this.ixn == 3) {
                        VideoLoadingProgressView.this.ixm = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.ixl = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.amk;
                    VideoLoadingProgressView.this.ixm = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.ixt = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.ixn == 2) {
                    VideoLoadingProgressView.this.ceK();
                } else if (VideoLoadingProgressView.this.ixn == 3 && VideoLoadingProgressView.this.ixo != null) {
                    VideoLoadingProgressView.this.ixo.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.dLc = getContext().getResources().getColor(R.color.cp_btn_a);
        this.ixk = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.dLc);
        this.mPaint.setStrokeWidth(this.ixk);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        ceL();
        this.ixn = 1;
        this.ixl = -90.0f;
        this.amk = -90.0f;
        this.ixp = ValueAnimator.ofFloat(this.ixe);
        this.ixp.setDuration(this.ixf);
        this.ixp.addListener(this.ixt);
        this.ixp.addUpdateListener(this.ixs);
        this.ixp.start();
        setVisibility(0);
        invalidate();
    }

    public void ceG() {
        ceL();
        this.ixn = 2;
        this.amk = this.ixl;
        this.ixq = ValueAnimator.ofFloat(-this.ixg);
        this.ixq.setDuration(this.ixh);
        this.ixq.addListener(this.ixt);
        this.ixq.addUpdateListener(this.ixs);
        this.ixq.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceK() {
        ceL();
        this.ixn = 3;
        this.amk = this.ixl;
        this.ixr = ValueAnimator.ofFloat(this.ixi);
        this.ixr.setDuration(this.ixj);
        this.ixr.addListener(this.ixt);
        this.ixr.addUpdateListener(this.ixs);
        this.ixr.start();
    }

    public void ceI() {
        ceL();
        setVisibility(8);
    }

    private void ceL() {
        if (this.ixp != null) {
            this.ixp.cancel();
        }
        if (this.ixq != null) {
            this.ixq.cancel();
        }
        if (this.ixr != null) {
            this.ixr.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.ixo = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ceL();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.ixl, this.ixm, false, this.mPaint);
    }
}
