package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends g {
    private ValueAnimator gIn;
    private ValueAnimator gIo;
    private boolean kKR;
    private boolean kKS;
    private boolean kKT;
    private ValueAnimator kKU;
    private ValueAnimator kKV;
    private a.C0622a kKW;
    private ValueAnimator.AnimatorUpdateListener kKX;
    private Animator.AnimatorListener kKY;
    private ValueAnimator.AnimatorUpdateListener kKZ;
    private Animator.AnimatorListener kLa;

    public d(Context context, a.C0622a c0622a) {
        super(context, c0622a);
        this.kKR = false;
        this.kKS = false;
        this.kKT = false;
        this.kKX = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.kKR || animatedFraction < 0.6923f || !d.this.kKW.kKl.isAnimating()) {
                    if (!d.this.kKT && animatedFraction >= 0.38461f && d.this.kKW.kKl.isAnimating()) {
                        d.this.kKT = true;
                        return;
                    }
                    return;
                }
                d.this.kKR = true;
            }
        };
        this.kKY = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.cSP();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.kKZ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.kKS && animatedFraction >= 0.57142f && d.this.kKW.kKl.isAnimating()) {
                    d.this.kKS = true;
                    d.this.cSQ();
                }
            }
        };
        this.kLa = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.cSR();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.kKW = c0622a;
        init();
    }

    private void init() {
        this.gIn = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gIn.setDuration(451L);
        this.gIn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.kKW.cqv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gIn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.kKW.cqv.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gIo = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.gIo.setDuration(485L);
        this.gIo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.kKW.cqv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gIo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.kKW.cqv.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kKU = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kKU.setDuration(104L);
        this.kKU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.kKU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.kKV = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kKV.setDuration(208L);
        this.kKV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.kKV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void cSP() {
        this.kKW.kKl.setVisibility(0);
        this.kKW.tB(true);
        this.mState = 2;
        if (this.kLq != null) {
            this.kLq.CI(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSQ() {
        this.kKU.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSR() {
        this.kKR = false;
        this.kKT = false;
        this.kKS = false;
        this.kKW.tB(false);
        if (this.cUu != null) {
            this.cUu.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        DW(8);
        this.mState = 4;
        if (this.kLq != null) {
            this.kLq.CI(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cSS() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.kLq != null) {
                this.kLq.CI(this.mState);
            }
            clearAnimation();
            DW(0);
            this.kKW.kKl.setVisibility(0);
            this.gIn.start();
            this.kKV.start();
            this.kKW.kKl.removeAnimatorListener(this.kLa);
            this.kKW.kKl.removeUpdateListener(this.kKZ);
            this.kKW.kKl.addAnimatorUpdateListener(this.kKX);
            this.kKW.kKl.addAnimatorListener(this.kKY);
            this.kKW.kKl.setMinAndMaxProgress(0.0f, 0.54f);
            this.kKW.kKl.setProgress(0.0f);
            this.kKW.kKl.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void startHideAnimation() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.kLq != null) {
                this.kLq.CI(this.mState);
            }
            this.kKW.kKl.setVisibility(0);
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gIo.start();
                }
            }, 300L);
            this.kKW.tB(false);
            this.kKW.kKl.removeAnimatorListener(this.kKY);
            this.kKW.kKl.removeUpdateListener(this.kKX);
            this.kKW.kKl.addAnimatorUpdateListener(this.kKZ);
            this.kKW.kKl.addAnimatorListener(this.kLa);
            this.kKW.kKl.setMinAndMaxProgress(0.54f, 1.0f);
            this.kKW.kKl.setProgress(0.0f);
            this.kKW.kKl.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cST() {
        cSR();
    }

    @Override // com.baidu.tieba.write.g
    public void onDestroy() {
        clearAnimation();
        this.kKW.kKl.cancelAnimation();
    }

    private void clearAnimation() {
        this.gIn.cancel();
        this.gIo.cancel();
        this.kKU.cancel();
        this.kKV.cancel();
    }

    private void DW(int i) {
        this.kKW.kKk.setVisibility(i);
        this.kKW.cqv.setVisibility(i);
        this.kKW.kKm.setVerticalGravity(i);
    }
}
