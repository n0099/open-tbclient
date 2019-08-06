package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public class c extends f {
    private ValueAnimator fQt;
    private ValueAnimator fQu;
    private ValueAnimator jMA;
    private ValueAnimator jMB;
    private ValueAnimator jMC;
    private int jMD;
    private int jME;
    private ValueAnimator.AnimatorUpdateListener jMF;
    private Animator.AnimatorListener jMG;
    private ValueAnimator.AnimatorUpdateListener jMH;
    private Animator.AnimatorListener jMI;
    private boolean jMu;
    private boolean jMv;
    private boolean jMw;
    private ValueAnimator jMx;
    private ValueAnimator jMy;
    private ValueAnimator jMz;

    public c(Context context, e.a aVar) {
        super(context, aVar);
        this.jMu = false;
        this.jMv = false;
        this.jMw = false;
        this.jMF = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (c.this.jMu || animatedFraction < 0.6923f || !c.this.jMQ.jNv.isAnimating()) {
                    if (!c.this.jMw && animatedFraction >= 0.38461f && c.this.jMQ.jNv.isAnimating()) {
                        c.this.jMw = true;
                        c.this.czE();
                        return;
                    }
                    return;
                }
                c.this.jMu = true;
                c.this.czF();
            }
        };
        this.jMG = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.czG();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.jMH = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!c.this.jMv && animatedFraction >= 0.57142f && c.this.jMQ.jNv.isAnimating()) {
                    c.this.jMv = true;
                    c.this.czH();
                }
            }
        };
        this.jMI = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.16
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.czI();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        init();
    }

    private void init() {
        this.fQt = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fQt.setDuration(451L);
        this.fQt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.17
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jMQ.jNd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jMQ.jNe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fQt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.18
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jMQ.jNd.setAlpha(1.0f);
                c.this.jMQ.jNe.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fQu = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fQu.setDuration(485L);
        this.fQu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.19
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jMQ.jNd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jMQ.jNe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (c.this.jMQ.jNu.getVisibility() == 0 && c.this.jMQ.jNt.getVisibility() == 0) {
                        c.this.jMQ.jNu.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        c.this.jMQ.jNt.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fQu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.20
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jMQ.jNd.setAlpha(0.0f);
                c.this.jMQ.jNe.setAlpha(0.0f);
                if (c.this.jMQ.jNu.getVisibility() == 0 && c.this.jMQ.jNt.getVisibility() == 0) {
                    c.this.jMQ.jNu.setAlpha(0.0f);
                    c.this.jMQ.jNt.setAlpha(0);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jMx = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jMx.setDuration(138L);
        this.jMx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.21
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jMQ.jNs.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jMQ.jNs.setTranslationY(c.this.jME - (c.this.jME * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jMx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jMQ.jNs.setAlpha(1.0f);
                c.this.jMQ.jNs.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jMy = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jMy.setDuration(138L);
        this.jMy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jMQ.jNs.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jMQ.jNs.setTranslationY(c.this.jME * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jMy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jMQ.jNs.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jMz = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jMz.setDuration(104L);
        this.jMz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jMz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jMA = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jMA.setDuration(208L);
        this.jMA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jMA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jMC = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jMC.setDuration(173L);
        this.jMC.setInterpolator(new DecelerateInterpolator());
        this.jMC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.jMD != 0 && valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c.this.jMQ.jNr.setTranslationY(c.this.jMD * (1.0f - floatValue));
                    c.this.jMQ.jNr.setRotation(floatValue * 135.0f);
                }
            }
        });
        this.jMC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jMQ.jNr.setTranslationY(0.0f);
                c.this.jMQ.jNr.setRotation(135.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jMB = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jMB.setDuration(277L);
        this.jMB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.jMQ.jNr.setTranslationY(c.this.jMD * animatedFraction);
                    c.this.jMQ.jNr.setRotation(135.0f - (animatedFraction * 135.0f));
                }
            }
        });
        this.jMB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.13
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jMQ.jNr.setTranslationY(c.this.jMD);
                c.this.jMQ.jNr.setRotation(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jME = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.jMQ.jNi.setVisibility(0);
        this.jMQ.jNf.setVisibility(0);
        this.jMQ.jNl.setVisibility(0);
        this.jMQ.jNo.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czE() {
        this.jMC.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czF() {
        this.jMQ.jNs.setVisibility(0);
        this.jMx.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czG() {
        this.jMQ.jNv.setVisibility(8);
        this.mState = 2;
        if (this.jMY != null) {
            this.jMY.CP(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czH() {
        this.jMz.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czI() {
        this.jMu = false;
        this.jMw = false;
        this.jMv = false;
        if (this.bRk != null) {
            this.bRk.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        czN();
        this.mState = 4;
        if (this.jMY != null) {
            this.jMY.CP(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void czJ() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jMY != null) {
                this.jMY.CP(this.mState);
            }
            this.jMQ.czU();
            clearAnimation();
            this.jMQ.jNe.setVisibility(0);
            this.jMQ.jNd.setVisibility(0);
            this.jMQ.jNv.setVisibility(0);
            this.jMQ.jNs.setVisibility(8);
            czK();
            this.fQt.start();
            this.jMA.start();
            this.jMQ.jNv.b(this.jMI);
            this.jMQ.jNv.b(this.jMH);
            this.jMQ.jNv.a(this.jMF);
            this.jMQ.jNv.a(this.jMG);
            this.jMQ.jNv.setMinAndMaxProgress(0.0f, 0.48148f);
            this.jMQ.jNv.setProgress(0.0f);
            this.jMQ.jNv.br();
        }
    }

    private void czK() {
        this.jMQ.jNr.post(new Runnable() { // from class: com.baidu.tieba.write.c.14
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jNw != null && c.this.jMD == 0) {
                    c.this.jMQ.jNr.getGlobalVisibleRect(c.this.jNx);
                    c.this.jMD = (c.this.jNw.centerY() - c.this.jNx.centerY()) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
                }
                c.this.jMQ.jNr.setVisibility(0);
                c.this.jMQ.jNr.setTranslationY(c.this.jMD);
                if (c.this.bRk != null) {
                    c.this.bRk.setVisibility(4);
                }
            }
        });
    }

    @Override // com.baidu.tieba.write.f
    public void czL() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jMY != null) {
                this.jMY.CP(this.mState);
            }
            this.jMQ.czV();
            this.jMQ.jNv.setVisibility(0);
            this.jMy.start();
            this.fQu.start();
            this.jMB.start();
            this.jMQ.jNv.b(this.jMG);
            this.jMQ.jNv.b(this.jMF);
            this.jMQ.jNv.a(this.jMH);
            this.jMQ.jNv.a(this.jMI);
            this.jMQ.jNv.setMinAndMaxProgress(0.48148f, 1.0f);
            this.jMQ.jNv.setProgress(0.0f);
            this.jMQ.jNv.br();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void czM() {
        czI();
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
        this.jMQ.jNv.cancelAnimation();
    }

    private void clearAnimation() {
        this.fQt.cancel();
        this.fQu.cancel();
        this.jMx.cancel();
        this.jMy.cancel();
        this.jMz.cancel();
        this.jMA.cancel();
        this.jMC.cancel();
        this.jMB.cancel();
    }

    private void czN() {
        this.jMQ.jNv.setVisibility(8);
        this.jMQ.jNr.setVisibility(4);
        this.jMQ.jNe.setVisibility(8);
        this.jMQ.jNd.setVisibility(8);
        this.jMQ.jNs.setVisibility(8);
    }
}
