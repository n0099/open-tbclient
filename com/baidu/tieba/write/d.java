package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends g {
    private ValueAnimator gLF;
    private ValueAnimator gLG;
    private boolean kNA;
    private boolean kNB;
    private ValueAnimator kNC;
    private ValueAnimator kND;
    private a.C0631a kNE;
    private ValueAnimator.AnimatorUpdateListener kNF;
    private Animator.AnimatorListener kNG;
    private ValueAnimator.AnimatorUpdateListener kNH;
    private Animator.AnimatorListener kNI;
    private boolean kNz;

    public d(Context context, a.C0631a c0631a) {
        super(context, c0631a);
        this.kNz = false;
        this.kNA = false;
        this.kNB = false;
        this.kNF = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.kNz || animatedFraction < 0.6923f || !d.this.kNE.kMR.isAnimating()) {
                    if (!d.this.kNB && animatedFraction >= 0.38461f && d.this.kNE.kMR.isAnimating()) {
                        d.this.kNB = true;
                        return;
                    }
                    return;
                }
                d.this.kNz = true;
            }
        };
        this.kNG = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.cUC();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.kNH = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.kNA && animatedFraction >= 0.57142f && d.this.kNE.kMR.isAnimating()) {
                    d.this.kNA = true;
                    d.this.cUD();
                }
            }
        };
        this.kNI = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.cUE();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.kNE = c0631a;
        init();
    }

    private void init() {
        this.gLF = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gLF.setDuration(451L);
        this.gLF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.kNE.cuL.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gLF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.kNE.cuL.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gLG = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.gLG.setDuration(485L);
        this.gLG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.kNE.cuL.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gLG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.kNE.cuL.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kNC = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kNC.setDuration(104L);
        this.kNC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.kNC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.kND = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kND.setDuration(208L);
        this.kND.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.kND.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void cUC() {
        this.kNE.kMR.setVisibility(0);
        this.kNE.tL(true);
        this.mState = 2;
        if (this.kNY != null) {
            this.kNY.CW(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUD() {
        this.kNC.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUE() {
        this.kNz = false;
        this.kNB = false;
        this.kNA = false;
        this.kNE.tL(false);
        if (this.cYL != null) {
            this.cYL.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        Ej(8);
        this.mState = 4;
        if (this.kNY != null) {
            this.kNY.CW(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cUF() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.kNY != null) {
                this.kNY.CW(this.mState);
            }
            clearAnimation();
            Ej(0);
            this.kNE.kMR.setVisibility(0);
            this.gLF.start();
            this.kND.start();
            this.kNE.kMR.removeAnimatorListener(this.kNI);
            this.kNE.kMR.removeUpdateListener(this.kNH);
            this.kNE.kMR.addAnimatorUpdateListener(this.kNF);
            this.kNE.kMR.addAnimatorListener(this.kNG);
            this.kNE.kMR.setMinAndMaxProgress(0.0f, 0.54f);
            this.kNE.kMR.setProgress(0.0f);
            this.kNE.kMR.setSpeed(1.4f);
            this.kNE.kMR.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void startHideAnimation() {
        if (this.mState == 2) {
            this.kNE.tM(false);
            this.mState = 3;
            if (this.kNY != null) {
                this.kNY.CW(this.mState);
            }
            this.kNE.kMR.setVisibility(0);
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gLG.start();
                }
            }, 300L);
            this.kNE.tL(false);
            this.kNE.kMR.removeAnimatorListener(this.kNG);
            this.kNE.kMR.removeUpdateListener(this.kNF);
            this.kNE.kMR.addAnimatorUpdateListener(this.kNH);
            this.kNE.kMR.addAnimatorListener(this.kNI);
            this.kNE.kMR.setMinAndMaxProgress(0.0f, 0.54f);
            this.kNE.kMR.setProgress(1.0f);
            this.kNE.kMR.setSpeed(-1.68f);
            this.kNE.kMR.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cUG() {
        cUE();
    }

    @Override // com.baidu.tieba.write.g
    public void onDestroy() {
        clearAnimation();
        this.kNE.kMR.cancelAnimation();
    }

    private void clearAnimation() {
        this.gLF.cancel();
        this.gLG.cancel();
        this.kNC.cancel();
        this.kND.cancel();
    }

    private void Ej(int i) {
        this.kNE.kMQ.setVisibility(i);
        this.kNE.cuL.setVisibility(i);
        this.kNE.kMS.setVerticalGravity(i);
    }
}
