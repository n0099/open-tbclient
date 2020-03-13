package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends g {
    private ValueAnimator gKA;
    private ValueAnimator gKB;
    private boolean kLQ;
    private boolean kLR;
    private boolean kLS;
    private ValueAnimator kLT;
    private ValueAnimator kLU;
    private a.C0630a kLV;
    private ValueAnimator.AnimatorUpdateListener kLW;
    private Animator.AnimatorListener kLX;
    private ValueAnimator.AnimatorUpdateListener kLY;
    private Animator.AnimatorListener kLZ;

    public d(Context context, a.C0630a c0630a) {
        super(context, c0630a);
        this.kLQ = false;
        this.kLR = false;
        this.kLS = false;
        this.kLW = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.kLQ || animatedFraction < 0.6923f || !d.this.kLV.kLk.isAnimating()) {
                    if (!d.this.kLS && animatedFraction >= 0.38461f && d.this.kLV.kLk.isAnimating()) {
                        d.this.kLS = true;
                        return;
                    }
                    return;
                }
                d.this.kLQ = true;
            }
        };
        this.kLX = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.cUi();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.kLY = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.kLR && animatedFraction >= 0.57142f && d.this.kLV.kLk.isAnimating()) {
                    d.this.kLR = true;
                    d.this.cUj();
                }
            }
        };
        this.kLZ = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.cUk();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.kLV = c0630a;
        init();
    }

    private void init() {
        this.gKA = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gKA.setDuration(451L);
        this.gKA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.kLV.cuA.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gKA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.kLV.cuA.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gKB = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.gKB.setDuration(485L);
        this.gKB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.kLV.cuA.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gKB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.kLV.cuA.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLT = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kLT.setDuration(104L);
        this.kLT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.kLT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.kLU = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kLU.setDuration(208L);
        this.kLU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.kLU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void cUi() {
        this.kLV.kLk.setVisibility(0);
        this.kLV.tF(true);
        this.mState = 2;
        if (this.kMp != null) {
            this.kMp.CO(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUj() {
        this.kLT.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUk() {
        this.kLQ = false;
        this.kLS = false;
        this.kLR = false;
        this.kLV.tF(false);
        if (this.cYy != null) {
            this.cYy.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        Eb(8);
        this.mState = 4;
        if (this.kMp != null) {
            this.kMp.CO(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cUl() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.kMp != null) {
                this.kMp.CO(this.mState);
            }
            clearAnimation();
            Eb(0);
            this.kLV.kLk.setVisibility(0);
            this.gKA.start();
            this.kLU.start();
            this.kLV.kLk.removeAnimatorListener(this.kLZ);
            this.kLV.kLk.removeUpdateListener(this.kLY);
            this.kLV.kLk.addAnimatorUpdateListener(this.kLW);
            this.kLV.kLk.addAnimatorListener(this.kLX);
            this.kLV.kLk.setMinAndMaxProgress(0.0f, 0.54f);
            this.kLV.kLk.setProgress(0.0f);
            this.kLV.kLk.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void startHideAnimation() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.kMp != null) {
                this.kMp.CO(this.mState);
            }
            this.kLV.kLk.setVisibility(0);
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gKB.start();
                }
            }, 300L);
            this.kLV.tF(false);
            this.kLV.kLk.removeAnimatorListener(this.kLX);
            this.kLV.kLk.removeUpdateListener(this.kLW);
            this.kLV.kLk.addAnimatorUpdateListener(this.kLY);
            this.kLV.kLk.addAnimatorListener(this.kLZ);
            this.kLV.kLk.setMinAndMaxProgress(0.54f, 1.0f);
            this.kLV.kLk.setProgress(0.0f);
            this.kLV.kLk.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cUm() {
        cUk();
    }

    @Override // com.baidu.tieba.write.g
    public void onDestroy() {
        clearAnimation();
        this.kLV.kLk.cancelAnimation();
    }

    private void clearAnimation() {
        this.gKA.cancel();
        this.gKB.cancel();
        this.kLT.cancel();
        this.kLU.cancel();
    }

    private void Eb(int i) {
        this.kLV.kLj.setVisibility(i);
        this.kLV.cuA.setVisibility(i);
        this.kLV.kLl.setVerticalGravity(i);
    }
}
