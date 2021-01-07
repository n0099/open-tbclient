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
    private float cMc;
    private int fgh;
    private int hxI;
    private ValueAnimator.AnimatorUpdateListener mDA;
    private AnimatorListenerAdapter mDB;
    private float mDl;
    private int mDm;
    private float mDn;
    private int mDo;
    private float mDp;
    private int mDq;
    private float mDr;
    private float mDs;
    private int mDt;
    private a mDu;
    private ValueAnimator mDv;
    private ValueAnimator mDw;
    private ValueAnimator mDz;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.mDl = 7200.0f;
        this.mDm = 10000;
        this.mDn = 30.0f;
        this.mDo = 50;
        this.mDp = 300.0f;
        this.mDq = 400;
        this.cMc = -90.0f;
        this.mDr = this.cMc;
        this.mDs = 60.0f;
        this.mDA = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mDt != 1 && VideoLoadingProgressView.this.mDt != 2) {
                    if (VideoLoadingProgressView.this.mDt == 3) {
                        VideoLoadingProgressView.this.mDs = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mDr = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cMc;
                    VideoLoadingProgressView.this.mDs = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mDB = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mDt == 2) {
                    VideoLoadingProgressView.this.dBO();
                } else if (VideoLoadingProgressView.this.mDt == 3 && VideoLoadingProgressView.this.mDu != null) {
                    VideoLoadingProgressView.this.mDu.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDl = 7200.0f;
        this.mDm = 10000;
        this.mDn = 30.0f;
        this.mDo = 50;
        this.mDp = 300.0f;
        this.mDq = 400;
        this.cMc = -90.0f;
        this.mDr = this.cMc;
        this.mDs = 60.0f;
        this.mDA = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mDt != 1 && VideoLoadingProgressView.this.mDt != 2) {
                    if (VideoLoadingProgressView.this.mDt == 3) {
                        VideoLoadingProgressView.this.mDs = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mDr = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cMc;
                    VideoLoadingProgressView.this.mDs = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mDB = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mDt == 2) {
                    VideoLoadingProgressView.this.dBO();
                } else if (VideoLoadingProgressView.this.mDt == 3 && VideoLoadingProgressView.this.mDu != null) {
                    VideoLoadingProgressView.this.mDu.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDl = 7200.0f;
        this.mDm = 10000;
        this.mDn = 30.0f;
        this.mDo = 50;
        this.mDp = 300.0f;
        this.mDq = 400;
        this.cMc = -90.0f;
        this.mDr = this.cMc;
        this.mDs = 60.0f;
        this.mDA = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mDt != 1 && VideoLoadingProgressView.this.mDt != 2) {
                    if (VideoLoadingProgressView.this.mDt == 3) {
                        VideoLoadingProgressView.this.mDs = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mDr = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cMc;
                    VideoLoadingProgressView.this.mDs = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mDB = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mDt == 2) {
                    VideoLoadingProgressView.this.dBO();
                } else if (VideoLoadingProgressView.this.mDt == 3 && VideoLoadingProgressView.this.mDu != null) {
                    VideoLoadingProgressView.this.mDu.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.hxI = getContext().getResources().getColor(R.color.CAM_X0101);
        this.fgh = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds2);
        this.mPaint.setColor(this.hxI);
        this.mPaint.setStrokeWidth(this.fgh);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        dBP();
        this.mDt = 1;
        this.mDr = -90.0f;
        this.cMc = -90.0f;
        this.mDv = ValueAnimator.ofFloat(this.mDl);
        this.mDv.setDuration(this.mDm);
        this.mDv.addListener(this.mDB);
        this.mDv.addUpdateListener(this.mDA);
        this.mDv.start();
        setVisibility(0);
        invalidate();
    }

    public void dBK() {
        dBP();
        this.mDt = 2;
        this.cMc = this.mDr;
        this.mDw = ValueAnimator.ofFloat(-this.mDn);
        this.mDw.setDuration(this.mDo);
        this.mDw.addListener(this.mDB);
        this.mDw.addUpdateListener(this.mDA);
        this.mDw.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBO() {
        dBP();
        this.mDt = 3;
        this.cMc = this.mDr;
        this.mDz = ValueAnimator.ofFloat(this.mDp);
        this.mDz.setDuration(this.mDq);
        this.mDz.addListener(this.mDB);
        this.mDz.addUpdateListener(this.mDA);
        this.mDz.start();
    }

    public void dBM() {
        dBP();
        setVisibility(8);
    }

    private void dBP() {
        if (this.mDv != null) {
            this.mDv.cancel();
        }
        if (this.mDw != null) {
            this.mDw.cancel();
        }
        if (this.mDz != null) {
            this.mDz.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.mDu = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dBP();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.mDr, this.mDs, false, this.mPaint);
    }
}
