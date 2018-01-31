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
    private float gtU;
    private int gtV;
    private float gtW;
    private int gtX;
    private float gtY;
    private int gtZ;
    private int gua;
    private int gub;
    private float guc;
    private float gud;
    private float gue;
    private int guf;
    private a gug;
    private ValueAnimator guh;
    private ValueAnimator gui;
    private ValueAnimator guj;
    private ValueAnimator.AnimatorUpdateListener guk;
    private AnimatorListenerAdapter gul;
    private Paint mPaint;
    private RectF mRect;

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public VideoLoadingProgressView(Context context) {
        super(context);
        this.gtU = 3600.0f;
        this.gtV = 5000;
        this.gtW = 30.0f;
        this.gtX = 50;
        this.gtY = 300.0f;
        this.gtZ = HttpStatus.SC_BAD_REQUEST;
        this.guc = -90.0f;
        this.gud = this.guc;
        this.gue = 60.0f;
        this.guk = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.guf != 1 && VideoLoadingProgressView.this.guf != 2) {
                    if (VideoLoadingProgressView.this.guf == 3) {
                        VideoLoadingProgressView.this.gue = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gud = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.guc;
                    VideoLoadingProgressView.this.gue = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gul = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.guf == 2) {
                    VideoLoadingProgressView.this.bkG();
                } else if (VideoLoadingProgressView.this.guf == 3 && VideoLoadingProgressView.this.gug != null) {
                    VideoLoadingProgressView.this.gug.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gtU = 3600.0f;
        this.gtV = 5000;
        this.gtW = 30.0f;
        this.gtX = 50;
        this.gtY = 300.0f;
        this.gtZ = HttpStatus.SC_BAD_REQUEST;
        this.guc = -90.0f;
        this.gud = this.guc;
        this.gue = 60.0f;
        this.guk = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.guf != 1 && VideoLoadingProgressView.this.guf != 2) {
                    if (VideoLoadingProgressView.this.guf == 3) {
                        VideoLoadingProgressView.this.gue = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gud = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.guc;
                    VideoLoadingProgressView.this.gue = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gul = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.guf == 2) {
                    VideoLoadingProgressView.this.bkG();
                } else if (VideoLoadingProgressView.this.guf == 3 && VideoLoadingProgressView.this.gug != null) {
                    VideoLoadingProgressView.this.gug.onAnimationEnd();
                }
            }
        };
        init();
    }

    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gtU = 3600.0f;
        this.gtV = 5000;
        this.gtW = 30.0f;
        this.gtX = 50;
        this.gtY = 300.0f;
        this.gtZ = HttpStatus.SC_BAD_REQUEST;
        this.guc = -90.0f;
        this.gud = this.guc;
        this.gue = 60.0f;
        this.guk = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoLoadingProgressView.this.guf != 1 && VideoLoadingProgressView.this.guf != 2) {
                    if (VideoLoadingProgressView.this.guf == 3) {
                        VideoLoadingProgressView.this.gue = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView.this.gud = ((Float) valueAnimator.getAnimatedValue()).floatValue() + VideoLoadingProgressView.this.guc;
                    VideoLoadingProgressView.this.gue = 60.0f;
                }
                VideoLoadingProgressView.this.invalidate();
            }
        };
        this.gul = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.play.VideoLoadingProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoLoadingProgressView.this.guf == 2) {
                    VideoLoadingProgressView.this.bkG();
                } else if (VideoLoadingProgressView.this.guf == 3 && VideoLoadingProgressView.this.gug != null) {
                    VideoLoadingProgressView.this.gug.onAnimationEnd();
                }
            }
        };
        init();
    }

    private void init() {
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        this.gua = getContext().getResources().getColor(d.C0108d.cp_cont_i);
        this.gub = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds2);
        this.mPaint.setColor(this.gua);
        this.mPaint.setStrokeWidth(this.gub);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void startLoading() {
        bkH();
        this.guf = 1;
        this.gud = -90.0f;
        this.guc = -90.0f;
        this.guh = ValueAnimator.ofFloat(this.gtU);
        this.guh.setDuration(this.gtV);
        this.guh.addListener(this.gul);
        this.guh.addUpdateListener(this.guk);
        this.guh.start();
        setVisibility(0);
        invalidate();
    }

    public void bkC() {
        bkH();
        this.guf = 2;
        this.guc = this.gud;
        this.gui = ValueAnimator.ofFloat(-this.gtW);
        this.gui.setDuration(this.gtX);
        this.gui.addListener(this.gul);
        this.gui.addUpdateListener(this.guk);
        this.gui.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkG() {
        bkH();
        this.guf = 3;
        this.guc = this.gud;
        this.guj = ValueAnimator.ofFloat(this.gtY);
        this.guj.setDuration(this.gtZ);
        this.guj.addListener(this.gul);
        this.guj.addUpdateListener(this.guk);
        this.guj.start();
    }

    public void bkE() {
        bkH();
        setVisibility(8);
    }

    private void bkH() {
        if (this.guh != null) {
            this.guh.cancel();
        }
        if (this.gui != null) {
            this.gui.cancel();
        }
        if (this.guj != null) {
            this.guj.cancel();
        }
    }

    public void setLoadingAnimationListener(a aVar) {
        this.gug = aVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bkH();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = 1;
        this.mRect.top = 1;
        this.mRect.right = getWidth() - 1;
        this.mRect.bottom = getHeight() - 1;
        canvas.drawArc(this.mRect, this.gud, this.gue, false, this.mPaint);
    }
}
