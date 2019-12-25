package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends g {
    private ValueAnimator gEY;
    private ValueAnimator gEZ;
    private boolean kHq;
    private boolean kHr;
    private boolean kHs;
    private ValueAnimator kHt;
    private ValueAnimator kHu;
    private a.C0617a kHv;
    private ValueAnimator.AnimatorUpdateListener kHw;
    private Animator.AnimatorListener kHx;
    private ValueAnimator.AnimatorUpdateListener kHy;
    private Animator.AnimatorListener kHz;

    public d(Context context, a.C0617a c0617a) {
        super(context, c0617a);
        this.kHq = false;
        this.kHr = false;
        this.kHs = false;
        this.kHw = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.kHq || animatedFraction < 0.6923f || !d.this.kHv.kGK.isAnimating()) {
                    if (!d.this.kHs && animatedFraction >= 0.38461f && d.this.kHv.kGK.isAnimating()) {
                        d.this.kHs = true;
                        return;
                    }
                    return;
                }
                d.this.kHq = true;
            }
        };
        this.kHx = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.cRM();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.kHy = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.kHr && animatedFraction >= 0.57142f && d.this.kHv.kGK.isAnimating()) {
                    d.this.kHr = true;
                    d.this.cRN();
                }
            }
        };
        this.kHz = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.cRO();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.kHv = c0617a;
        init();
    }

    private void init() {
        this.gEY = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gEY.setDuration(451L);
        this.gEY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.kHv.cqj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gEY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.kHv.cqj.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gEZ = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.gEZ.setDuration(485L);
        this.gEZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.kHv.cqj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gEZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.kHv.cqj.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kHt = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kHt.setDuration(104L);
        this.kHt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.kHt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.kHu = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kHu.setDuration(208L);
        this.kHu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.kHu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void cRM() {
        this.kHv.kGK.setVisibility(0);
        this.kHv.tp(true);
        this.mState = 2;
        if (this.kHP != null) {
            this.kHP.DT(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRN() {
        this.kHt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRO() {
        this.kHq = false;
        this.kHs = false;
        this.kHr = false;
        this.kHv.tp(false);
        if (this.cUk != null) {
            this.cUk.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        DQ(8);
        this.mState = 4;
        if (this.kHP != null) {
            this.kHP.DT(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cRP() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.kHP != null) {
                this.kHP.DT(this.mState);
            }
            clearAnimation();
            DQ(0);
            this.kHv.kGK.setVisibility(0);
            this.gEY.start();
            this.kHu.start();
            this.kHv.kGK.removeAnimatorListener(this.kHz);
            this.kHv.kGK.removeUpdateListener(this.kHy);
            this.kHv.kGK.addAnimatorUpdateListener(this.kHw);
            this.kHv.kGK.addAnimatorListener(this.kHx);
            this.kHv.kGK.setMinAndMaxProgress(0.0f, 0.54f);
            this.kHv.kGK.setProgress(0.0f);
            this.kHv.kGK.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void startHideAnimation() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.kHP != null) {
                this.kHP.DT(this.mState);
            }
            this.kHv.kGK.setVisibility(0);
            com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gEZ.start();
                }
            }, 300L);
            this.kHv.tp(false);
            this.kHv.kGK.removeAnimatorListener(this.kHx);
            this.kHv.kGK.removeUpdateListener(this.kHw);
            this.kHv.kGK.addAnimatorUpdateListener(this.kHy);
            this.kHv.kGK.addAnimatorListener(this.kHz);
            this.kHv.kGK.setMinAndMaxProgress(0.54f, 1.0f);
            this.kHv.kGK.setProgress(0.0f);
            this.kHv.kGK.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cRQ() {
        cRO();
    }

    @Override // com.baidu.tieba.write.g
    public void onDestroy() {
        clearAnimation();
        this.kHv.kGK.cancelAnimation();
    }

    private void clearAnimation() {
        this.gEY.cancel();
        this.gEZ.cancel();
        this.kHt.cancel();
        this.kHu.cancel();
    }

    private void DQ(int i) {
        this.kHv.kGJ.setVisibility(i);
        this.kHv.cqj.setVisibility(i);
        this.kHv.kGL.setVerticalGravity(i);
    }
}
