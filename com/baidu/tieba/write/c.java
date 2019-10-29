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
    private ValueAnimator fRD;
    private ValueAnimator fRE;
    private boolean jMV;
    private boolean jMW;
    private boolean jMX;
    private ValueAnimator jMY;
    private ValueAnimator jMZ;
    private ValueAnimator jNa;
    private ValueAnimator jNb;
    private ValueAnimator jNc;
    private ValueAnimator jNd;
    private int jNe;
    private int jNf;
    private ValueAnimator.AnimatorUpdateListener jNg;
    private Animator.AnimatorListener jNh;
    private ValueAnimator.AnimatorUpdateListener jNi;
    private Animator.AnimatorListener jNj;

    public c(Context context, e.a aVar) {
        super(context, aVar);
        this.jMV = false;
        this.jMW = false;
        this.jMX = false;
        this.jNg = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (c.this.jMV || animatedFraction < 0.6923f || !c.this.jNr.jNW.isAnimating()) {
                    if (!c.this.jMX && animatedFraction >= 0.38461f && c.this.jNr.jNW.isAnimating()) {
                        c.this.jMX = true;
                        c.this.cxD();
                        return;
                    }
                    return;
                }
                c.this.jMV = true;
                c.this.cxE();
            }
        };
        this.jNh = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.cxF();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.jNi = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!c.this.jMW && animatedFraction >= 0.57142f && c.this.jNr.jNW.isAnimating()) {
                    c.this.jMW = true;
                    c.this.cxG();
                }
            }
        };
        this.jNj = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.16
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.cxH();
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
        this.fRD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fRD.setDuration(451L);
        this.fRD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.17
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jNr.jNE.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jNr.jNF.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fRD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.18
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jNr.jNE.setAlpha(1.0f);
                c.this.jNr.jNF.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fRE = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fRE.setDuration(485L);
        this.fRE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.19
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jNr.jNE.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jNr.jNF.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (c.this.jNr.jNV.getVisibility() == 0 && c.this.jNr.jNU.getVisibility() == 0) {
                        c.this.jNr.jNV.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        c.this.jNr.jNU.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fRE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.20
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jNr.jNE.setAlpha(0.0f);
                c.this.jNr.jNF.setAlpha(0.0f);
                if (c.this.jNr.jNV.getVisibility() == 0 && c.this.jNr.jNU.getVisibility() == 0) {
                    c.this.jNr.jNV.setAlpha(0.0f);
                    c.this.jNr.jNU.setAlpha(0);
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
        this.jMY = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jMY.setDuration(138L);
        this.jMY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.21
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jNr.jNT.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jNr.jNT.setTranslationY(c.this.jNf - (c.this.jNf * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jMY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jNr.jNT.setAlpha(1.0f);
                c.this.jNr.jNT.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jMZ = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jMZ.setDuration(138L);
        this.jMZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jNr.jNT.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jNr.jNT.setTranslationY(c.this.jNf * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jMZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jNr.jNT.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jNa = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jNa.setDuration(104L);
        this.jNa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jNa.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.6
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
        this.jNb = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jNb.setDuration(208L);
        this.jNb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jNb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.8
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
        this.jNd = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jNd.setDuration(173L);
        this.jNd.setInterpolator(new DecelerateInterpolator());
        this.jNd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.jNe != 0 && valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c.this.jNr.jNS.setTranslationY(c.this.jNe * (1.0f - floatValue));
                    c.this.jNr.jNS.setRotation(floatValue * 135.0f);
                }
            }
        });
        this.jNd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jNr.jNS.setTranslationY(0.0f);
                c.this.jNr.jNS.setRotation(135.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jNc = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jNc.setDuration(277L);
        this.jNc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.jNr.jNS.setTranslationY(c.this.jNe * animatedFraction);
                    c.this.jNr.jNS.setRotation(135.0f - (animatedFraction * 135.0f));
                }
            }
        });
        this.jNc.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.13
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jNr.jNS.setTranslationY(c.this.jNe);
                c.this.jNr.jNS.setRotation(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jNf = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.jNr.jNJ.setVisibility(0);
        this.jNr.jNG.setVisibility(0);
        this.jNr.jNM.setVisibility(0);
        this.jNr.jNP.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxD() {
        this.jNd.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxE() {
        this.jNr.jNT.setVisibility(0);
        this.jMY.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxF() {
        this.jNr.jNW.setVisibility(8);
        this.mState = 2;
        if (this.jNz != null) {
            this.jNz.Bx(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxG() {
        this.jNa.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxH() {
        this.jMV = false;
        this.jMX = false;
        this.jMW = false;
        if (this.cir != null) {
            this.cir.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        cxM();
        this.mState = 4;
        if (this.jNz != null) {
            this.jNz.Bx(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cxI() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jNz != null) {
                this.jNz.Bx(this.mState);
            }
            this.jNr.cxT();
            clearAnimation();
            this.jNr.jNF.setVisibility(0);
            this.jNr.jNE.setVisibility(0);
            this.jNr.jNW.setVisibility(0);
            this.jNr.jNT.setVisibility(8);
            cxJ();
            this.fRD.start();
            this.jNb.start();
            this.jNr.jNW.removeAnimatorListener(this.jNj);
            this.jNr.jNW.removeUpdateListener(this.jNi);
            this.jNr.jNW.addAnimatorUpdateListener(this.jNg);
            this.jNr.jNW.addAnimatorListener(this.jNh);
            this.jNr.jNW.setMinAndMaxProgress(0.0f, 0.48148f);
            this.jNr.jNW.setProgress(0.0f);
            this.jNr.jNW.playAnimation();
        }
    }

    private void cxJ() {
        this.jNr.jNS.post(new Runnable() { // from class: com.baidu.tieba.write.c.14
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jNX != null && c.this.jNe == 0) {
                    c.this.jNr.jNS.getGlobalVisibleRect(c.this.jNY);
                    c.this.jNe = (c.this.jNX.centerY() - c.this.jNY.centerY()) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
                }
                c.this.jNr.jNS.setVisibility(0);
                c.this.jNr.jNS.setTranslationY(c.this.jNe);
                if (c.this.cir != null) {
                    c.this.cir.setVisibility(4);
                }
            }
        });
    }

    @Override // com.baidu.tieba.write.f
    public void cxK() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jNz != null) {
                this.jNz.Bx(this.mState);
            }
            this.jNr.cxU();
            this.jNr.jNW.setVisibility(0);
            this.jMZ.start();
            this.fRE.start();
            this.jNc.start();
            this.jNr.jNW.removeAnimatorListener(this.jNh);
            this.jNr.jNW.removeUpdateListener(this.jNg);
            this.jNr.jNW.addAnimatorUpdateListener(this.jNi);
            this.jNr.jNW.addAnimatorListener(this.jNj);
            this.jNr.jNW.setMinAndMaxProgress(0.48148f, 1.0f);
            this.jNr.jNW.setProgress(0.0f);
            this.jNr.jNW.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cxL() {
        cxH();
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
        this.jNr.jNW.cancelAnimation();
    }

    private void clearAnimation() {
        this.fRD.cancel();
        this.fRE.cancel();
        this.jMY.cancel();
        this.jMZ.cancel();
        this.jNa.cancel();
        this.jNb.cancel();
        this.jNd.cancel();
        this.jNc.cancel();
    }

    private void cxM() {
        this.jNr.jNW.setVisibility(8);
        this.jNr.jNS.setVisibility(4);
        this.jNr.jNF.setVisibility(8);
        this.jNr.jNE.setVisibility(8);
        this.jNr.jNT.setVisibility(8);
    }
}
