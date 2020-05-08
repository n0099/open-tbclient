package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends g {
    private ValueAnimator hvd;
    private ValueAnimator hve;
    private boolean lwU;
    private boolean lwV;
    private boolean lwW;
    private ValueAnimator lwX;
    private ValueAnimator lwY;
    private a.C0693a lwZ;
    private ValueAnimator.AnimatorUpdateListener lxa;
    private Animator.AnimatorListener lxb;
    private ValueAnimator.AnimatorUpdateListener lxc;
    private Animator.AnimatorListener lxd;

    public d(Context context, a.C0693a c0693a) {
        super(context, c0693a);
        this.lwU = false;
        this.lwV = false;
        this.lwW = false;
        this.lxa = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.lwU || animatedFraction < 0.6923f || !d.this.lwZ.lwl.isAnimating()) {
                    if (!d.this.lwW && animatedFraction >= 0.38461f && d.this.lwZ.lwl.isAnimating()) {
                        d.this.lwW = true;
                        return;
                    }
                    return;
                }
                d.this.lwU = true;
            }
        };
        this.lxb = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.deU();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.lxc = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.lwV && animatedFraction >= 0.57142f && d.this.lwZ.lwl.isAnimating()) {
                    d.this.lwV = true;
                    d.this.deV();
                }
            }
        };
        this.lxd = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.deW();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.lwZ = c0693a;
        init();
    }

    private void init() {
        this.hvd = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.hvd.setDuration(451L);
        this.hvd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.lwZ.cTM.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hvd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.lwZ.cTM.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hve = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.hve.setDuration(485L);
        this.hve.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.lwZ.cTM.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hve.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.lwZ.cTM.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lwX = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lwX.setDuration(104L);
        this.lwX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.lwX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.lwY = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.lwY.setDuration(208L);
        this.lwY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.lwY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void deU() {
        this.lwZ.lwl.setVisibility(0);
        this.lwZ.uL(true);
        this.mState = 2;
        if (this.lxt != null) {
            this.lxt.DA(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deV() {
        this.lwX.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deW() {
        this.lwU = false;
        this.lwW = false;
        this.lwV = false;
        this.lwZ.uL(false);
        if (this.dxZ != null) {
            this.dxZ.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        EK(8);
        this.mState = 4;
        if (this.lxt != null) {
            this.lxt.DA(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.g
    public void deX() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.lxt != null) {
                this.lxt.DA(this.mState);
            }
            clearAnimation();
            EK(0);
            this.lwZ.lwl.setVisibility(0);
            this.hvd.start();
            this.lwY.start();
            this.lwZ.lwl.removeAnimatorListener(this.lxd);
            this.lwZ.lwl.removeUpdateListener(this.lxc);
            this.lwZ.lwl.addAnimatorUpdateListener(this.lxa);
            this.lwZ.lwl.addAnimatorListener(this.lxb);
            this.lwZ.lwl.setMinAndMaxProgress(0.0f, 1.0f);
            this.lwZ.lwl.setProgress(0.0f);
            this.lwZ.lwl.setSpeed(1.4f);
            this.lwZ.lwl.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void afo() {
        if (this.mState == 2) {
            this.lwZ.uM(false);
            this.mState = 3;
            if (this.lxt != null) {
                this.lxt.DA(this.mState);
            }
            this.lwZ.lwl.setVisibility(0);
            com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.hve.start();
                }
            }, 300L);
            this.lwZ.uL(false);
            this.lwZ.lwl.removeAnimatorListener(this.lxb);
            this.lwZ.lwl.removeUpdateListener(this.lxa);
            this.lwZ.lwl.addAnimatorUpdateListener(this.lxc);
            this.lwZ.lwl.addAnimatorListener(this.lxd);
            this.lwZ.lwl.setMinAndMaxProgress(0.0f, 1.0f);
            this.lwZ.lwl.setProgress(1.0f);
            this.lwZ.lwl.setSpeed(-1.68f);
            this.lwZ.lwl.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void deY() {
        deW();
    }

    @Override // com.baidu.tieba.write.g
    public void onDestroy() {
        clearAnimation();
        this.lwZ.lwl.cancelAnimation();
    }

    private void clearAnimation() {
        this.hvd.cancel();
        this.hve.cancel();
        this.lwX.cancel();
        this.lwY.cancel();
    }

    private void EK(int i) {
        this.lwZ.lwk.setVisibility(i);
        this.lwZ.cTM.setVisibility(i);
        this.lwZ.lwm.setVerticalGravity(i);
    }
}
