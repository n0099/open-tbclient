package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator jCK;
    private ValueAnimator jCL;
    private ValueAnimator nSA;
    private a.b nSB;
    private ValueAnimator.AnimatorUpdateListener nSC;
    private Animator.AnimatorListener nSD;
    private ValueAnimator.AnimatorUpdateListener nSE;
    private Animator.AnimatorListener nSF;
    private boolean nSw;
    private boolean nSx;
    private boolean nSy;
    private ValueAnimator nSz;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.nSw = false;
        this.nSx = false;
        this.nSy = false;
        this.nSC = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.nSw || animatedFraction < 0.6923f || !d.this.nSB.nRF.isAnimating()) {
                    if (!d.this.nSy && animatedFraction >= 0.38461f && d.this.nSB.nRF.isAnimating()) {
                        d.this.nSy = true;
                        return;
                    }
                    return;
                }
                d.this.nSw = true;
            }
        };
        this.nSD = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.Qu();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.nSE = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.nSx && animatedFraction >= 0.57142f && d.this.nSB.nRF.isAnimating()) {
                    d.this.nSx = true;
                    d.this.dUe();
                }
            }
        };
        this.nSF = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.Qv();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.nSB = bVar;
        init();
    }

    private void init() {
        this.jCK = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jCK.setDuration(451L);
        this.jCK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.nSB.ely.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jCK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nSB.ely.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jCL = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jCL.setDuration(485L);
        this.jCL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.nSB.ely.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jCL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nSB.ely.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nSz = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nSz.setDuration(104L);
        this.nSz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nSz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(1.0f);
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
        this.nSA = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.nSA.setDuration(208L);
        this.nSA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nSA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(0.0f);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qu() {
        this.nSB.nRF.setVisibility(0);
        this.nSB.yU(true);
        this.mState = 2;
        if (this.nTd != null) {
            this.nTd.KM(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUe() {
        this.nSz.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qv() {
        this.nSw = false;
        this.nSy = false;
        this.nSx = false;
        this.nSB.yU(false);
        if (this.eXk != null) {
            this.eXk.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        KJ(8);
        this.mState = 4;
        if (this.nTd != null) {
            this.nTd.KM(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dUf() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nTd != null) {
                this.nTd.KM(this.mState);
            }
            clearAnimation();
            KJ(0);
            this.nSB.nRF.setVisibility(0);
            this.jCK.start();
            this.nSA.start();
            this.nSB.nRF.removeAnimatorListener(this.nSF);
            this.nSB.nRF.removeUpdateListener(this.nSE);
            this.nSB.nRF.addAnimatorUpdateListener(this.nSC);
            this.nSB.nRF.addAnimatorListener(this.nSD);
            this.nSB.nRF.setMinAndMaxProgress(0.0f, 1.0f);
            this.nSB.nRF.setProgress(0.0f);
            this.nSB.nRF.setSpeed(1.4f);
            this.nSB.nRF.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aAB() {
        if (this.mState == 2) {
            this.nSB.yV(false);
            this.mState = 3;
            if (this.nTd != null) {
                this.nTd.KM(this.mState);
            }
            this.nSB.nRF.setVisibility(0);
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.jCL.start();
                }
            }, 300L);
            this.nSB.yU(false);
            this.nSB.nRF.removeAnimatorListener(this.nSD);
            this.nSB.nRF.removeUpdateListener(this.nSC);
            this.nSB.nRF.addAnimatorUpdateListener(this.nSE);
            this.nSB.nRF.addAnimatorListener(this.nSF);
            this.nSB.nRF.setMinAndMaxProgress(0.0f, 1.0f);
            this.nSB.nRF.setProgress(1.0f);
            this.nSB.nRF.setSpeed(-1.68f);
            this.nSB.nRF.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dUg() {
        Qv();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.nSB.nRF.cancelAnimation();
    }

    private void clearAnimation() {
        this.jCK.cancel();
        this.jCL.cancel();
        this.nSz.cancel();
        this.nSA.cancel();
    }

    private void KJ(int i) {
        this.nSB.nRE.setVisibility(i);
        this.nSB.ely.setVisibility(i);
        this.nSB.nRG.setVisibility(i);
    }
}
