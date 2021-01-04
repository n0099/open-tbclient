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
    private ValueAnimator mDA;
    private ValueAnimator.AnimatorUpdateListener mDB;
    private AnimatorListenerAdapter mDC;
    private float mDm;
    private int mDn;
    private float mDo;
    private int mDp;
    private float mDq;
    private int mDr;
    private float mDs;
    private float mDt;
    private int mDu;
    private a mDv;
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
        this.mDm = 7200.0f;
        this.mDn = 10000;
        this.mDo = 30.0f;
        this.mDp = 50;
        this.mDq = 300.0f;
        this.mDr = 400;
        this.cMc = -90.0f;
        this.mDs = this.cMc;
        this.mDt = 60.0f;
        this.mDB = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mDu != 1 && VideoLoadingProgressView.this.mDu != 2) {
                    if (VideoLoadingProgressView.this.mDu == 3) {
                        VideoLoadingProgressView.this.mDt = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mDs = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cMc;
                    VideoLoadingProgressView.this.mDt = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mDC = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mDu == 2) {
                    VideoLoadingProgressView.this.dBN();
                } else if (VideoLoadingProgressView.this.mDu == 3 && VideoLoadingProgressView.this.mDv != null) {
                    VideoLoadingProgressView.this.mDv.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDm = 7200.0f;
        this.mDn = 10000;
        this.mDo = 30.0f;
        this.mDp = 50;
        this.mDq = 300.0f;
        this.mDr = 400;
        this.cMc = -90.0f;
        this.mDs = this.cMc;
        this.mDt = 60.0f;
        this.mDB = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mDu != 1 && VideoLoadingProgressView.this.mDu != 2) {
                    if (VideoLoadingProgressView.this.mDu == 3) {
                        VideoLoadingProgressView.this.mDt = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mDs = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cMc;
                    VideoLoadingProgressView.this.mDt = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mDC = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mDu == 2) {
                    VideoLoadingProgressView.this.dBN();
                } else if (VideoLoadingProgressView.this.mDu == 3 && VideoLoadingProgressView.this.mDv != null) {
                    VideoLoadingProgressView.this.mDv.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDm = 7200.0f;
        this.mDn = 10000;
        this.mDo = 30.0f;
        this.mDp = 50;
        this.mDq = 300.0f;
        this.mDr = 400;
        this.cMc = -90.0f;
        this.mDs = this.cMc;
        this.mDt = 60.0f;
        this.mDB = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.mDu != 1 && VideoLoadingProgressView.this.mDu != 2) {
                    if (VideoLoadingProgressView.this.mDu == 3) {
                        VideoLoadingProgressView.this.mDt = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.mDs = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.cMc;
                    VideoLoadingProgressView.this.mDt = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.mDC = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.mDu == 2) {
                    VideoLoadingProgressView.this.dBN();
                } else if (VideoLoadingProgressView.this.mDu == 3 && VideoLoadingProgressView.this.mDv != null) {
                    VideoLoadingProgressView.this.mDv.onAnimationEnd();
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
        dBO();
        this.mDu = 1;
        this.mDs = -90.0f;
        this.cMc = -90.0f;
        this.mDw = ValueAnimator.ofFloat(this.mDm);
        this.mDw.setDuration(this.mDn);
        this.mDw.addListener(this.mDC);
        this.mDw.addUpdateListener(this.mDB);
        this.mDw.start();
        setVisibility(0);
        invalidate();
    }

    public void dBJ() {
        dBO();
        this.mDu = 2;
        this.cMc = this.mDs;
        this.mDz = ValueAnimator.ofFloat(-this.mDo);
        this.mDz.setDuration(this.mDp);
        this.mDz.addListener(this.mDC);
        this.mDz.addUpdateListener(this.mDB);
        this.mDz.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBN() {
        dBO();
        this.mDu = 3;
        this.cMc = this.mDs;
        this.mDA = ValueAnimator.ofFloat(this.mDq);
        this.mDA.setDuration(this.mDr);
        this.mDA.addListener(this.mDC);
        this.mDA.addUpdateListener(this.mDB);
        this.mDA.start();
    }

    public void dBL() {
        dBO();
        setVisibility(8);
    }

    private void dBO() {
        if (this.mDw != null) {
            this.mDw.cancel();
        }
        if (this.mDz != null) {
            this.mDz.cancel();
        }
        if (this.mDA != null) {
            this.mDA.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.mDv = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dBO();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.mDs, this.mDt, false, this.mPaint);
    }
}
