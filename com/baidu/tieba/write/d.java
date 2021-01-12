package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator jCK;
    private ValueAnimator jCL;
    private a.b nSA;
    private ValueAnimator.AnimatorUpdateListener nSB;
    private Animator.AnimatorListener nSC;
    private ValueAnimator.AnimatorUpdateListener nSD;
    private Animator.AnimatorListener nSE;
    private boolean nSv;
    private boolean nSw;
    private boolean nSx;
    private ValueAnimator nSy;
    private ValueAnimator nSz;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.nSv = false;
        this.nSw = false;
        this.nSx = false;
        this.nSB = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.nSv || animatedFraction < 0.6923f || !d.this.nSA.nRE.isAnimating()) {
                    if (!d.this.nSx && animatedFraction >= 0.38461f && d.this.nSA.nRE.isAnimating()) {
                        d.this.nSx = true;
                        return;
                    }
                    return;
                }
                d.this.nSv = true;
            }
        };
        this.nSC = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
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
        this.nSD = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.nSw && animatedFraction >= 0.57142f && d.this.nSA.nRE.isAnimating()) {
                    d.this.nSw = true;
                    d.this.dUe();
                }
            }
        };
        this.nSE = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
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
        this.nSA = bVar;
        init();
    }

    private void init() {
        this.jCK = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jCK.setDuration(451L);
        this.jCK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.nSA.ely.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jCK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nSA.ely.setAlpha(1.0f);
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
                    d.this.nSA.ely.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jCL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nSA.ely.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nSy = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nSy.setDuration(104L);
        this.nSy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nSy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.nSz = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.nSz.setDuration(208L);
        this.nSz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nSz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
        this.nSA.nRE.setVisibility(0);
        this.nSA.yU(true);
        this.mState = 2;
        if (this.nTc != null) {
            this.nTc.KM(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUe() {
        this.nSy.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qv() {
        this.nSv = false;
        this.nSx = false;
        this.nSw = false;
        this.nSA.yU(false);
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
        if (this.nTc != null) {
            this.nTc.KM(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dUf() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nTc != null) {
                this.nTc.KM(this.mState);
            }
            clearAnimation();
            KJ(0);
            this.nSA.nRE.setVisibility(0);
            this.jCK.start();
            this.nSz.start();
            this.nSA.nRE.removeAnimatorListener(this.nSE);
            this.nSA.nRE.removeUpdateListener(this.nSD);
            this.nSA.nRE.addAnimatorUpdateListener(this.nSB);
            this.nSA.nRE.addAnimatorListener(this.nSC);
            this.nSA.nRE.setMinAndMaxProgress(0.0f, 1.0f);
            this.nSA.nRE.setProgress(0.0f);
            this.nSA.nRE.setSpeed(1.4f);
            this.nSA.nRE.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aAB() {
        if (this.mState == 2) {
            this.nSA.yV(false);
            this.mState = 3;
            if (this.nTc != null) {
                this.nTc.KM(this.mState);
            }
            this.nSA.nRE.setVisibility(0);
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.jCL.start();
                }
            }, 300L);
            this.nSA.yU(false);
            this.nSA.nRE.removeAnimatorListener(this.nSC);
            this.nSA.nRE.removeUpdateListener(this.nSB);
            this.nSA.nRE.addAnimatorUpdateListener(this.nSD);
            this.nSA.nRE.addAnimatorListener(this.nSE);
            this.nSA.nRE.setMinAndMaxProgress(0.0f, 1.0f);
            this.nSA.nRE.setProgress(1.0f);
            this.nSA.nRE.setSpeed(-1.68f);
            this.nSA.nRE.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dUg() {
        Qv();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.nSA.nRE.cancelAnimation();
    }

    private void clearAnimation() {
        this.jCK.cancel();
        this.jCL.cancel();
        this.nSy.cancel();
        this.nSz.cancel();
    }

    private void KJ(int i) {
        this.nSA.nRD.setVisibility(i);
        this.nSA.ely.setVisibility(i);
        this.nSA.nRF.setVisibility(i);
    }
}
