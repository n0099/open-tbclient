package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends g {
    private ValueAnimator huX;
    private ValueAnimator huY;
    private boolean lwQ;
    private boolean lwR;
    private boolean lwS;
    private ValueAnimator lwT;
    private ValueAnimator lwU;
    private a.C0672a lwV;
    private ValueAnimator.AnimatorUpdateListener lwW;
    private Animator.AnimatorListener lwX;
    private ValueAnimator.AnimatorUpdateListener lwY;
    private Animator.AnimatorListener lwZ;

    public d(Context context, a.C0672a c0672a) {
        super(context, c0672a);
        this.lwQ = false;
        this.lwR = false;
        this.lwS = false;
        this.lwW = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.lwQ || animatedFraction < 0.6923f || !d.this.lwV.lwh.isAnimating()) {
                    if (!d.this.lwS && animatedFraction >= 0.38461f && d.this.lwV.lwh.isAnimating()) {
                        d.this.lwS = true;
                        return;
                    }
                    return;
                }
                d.this.lwQ = true;
            }
        };
        this.lwX = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.deX();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.lwY = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.lwR && animatedFraction >= 0.57142f && d.this.lwV.lwh.isAnimating()) {
                    d.this.lwR = true;
                    d.this.deY();
                }
            }
        };
        this.lwZ = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.deZ();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.lwV = c0672a;
        init();
    }

    private void init() {
        this.huX = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.huX.setDuration(451L);
        this.huX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.lwV.cTH.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.huX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.lwV.cTH.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.huY = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.huY.setDuration(485L);
        this.huY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.lwV.cTH.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.huY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.lwV.cTH.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lwT = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lwT.setDuration(104L);
        this.lwT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.lwT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.lwU = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.lwU.setDuration(208L);
        this.lwU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.lwU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void deX() {
        this.lwV.lwh.setVisibility(0);
        this.lwV.uL(true);
        this.mState = 2;
        if (this.lxp != null) {
            this.lxp.DA(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deY() {
        this.lwT.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deZ() {
        this.lwQ = false;
        this.lwS = false;
        this.lwR = false;
        this.lwV.uL(false);
        if (this.dxV != null) {
            this.dxV.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        EK(8);
        this.mState = 4;
        if (this.lxp != null) {
            this.lxp.DA(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.g
    public void dfa() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.lxp != null) {
                this.lxp.DA(this.mState);
            }
            clearAnimation();
            EK(0);
            this.lwV.lwh.setVisibility(0);
            this.huX.start();
            this.lwU.start();
            this.lwV.lwh.removeAnimatorListener(this.lwZ);
            this.lwV.lwh.removeUpdateListener(this.lwY);
            this.lwV.lwh.addAnimatorUpdateListener(this.lwW);
            this.lwV.lwh.addAnimatorListener(this.lwX);
            this.lwV.lwh.setMinAndMaxProgress(0.0f, 1.0f);
            this.lwV.lwh.setProgress(0.0f);
            this.lwV.lwh.setSpeed(1.4f);
            this.lwV.lwh.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void afp() {
        if (this.mState == 2) {
            this.lwV.uM(false);
            this.mState = 3;
            if (this.lxp != null) {
                this.lxp.DA(this.mState);
            }
            this.lwV.lwh.setVisibility(0);
            com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.huY.start();
                }
            }, 300L);
            this.lwV.uL(false);
            this.lwV.lwh.removeAnimatorListener(this.lwX);
            this.lwV.lwh.removeUpdateListener(this.lwW);
            this.lwV.lwh.addAnimatorUpdateListener(this.lwY);
            this.lwV.lwh.addAnimatorListener(this.lwZ);
            this.lwV.lwh.setMinAndMaxProgress(0.0f, 1.0f);
            this.lwV.lwh.setProgress(1.0f);
            this.lwV.lwh.setSpeed(-1.68f);
            this.lwV.lwh.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void dfb() {
        deZ();
    }

    @Override // com.baidu.tieba.write.g
    public void onDestroy() {
        clearAnimation();
        this.lwV.lwh.cancelAnimation();
    }

    private void clearAnimation() {
        this.huX.cancel();
        this.huY.cancel();
        this.lwT.cancel();
        this.lwU.cancel();
    }

    private void EK(int i) {
        this.lwV.lwg.setVisibility(i);
        this.lwV.cTH.setVisibility(i);
        this.lwV.lwi.setVerticalGravity(i);
    }
}
