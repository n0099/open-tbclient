package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends g {
    private ValueAnimator gKo;
    private ValueAnimator gKp;
    private boolean kLE;
    private boolean kLF;
    private boolean kLG;
    private ValueAnimator kLH;
    private ValueAnimator kLI;
    private a.C0630a kLJ;
    private ValueAnimator.AnimatorUpdateListener kLK;
    private Animator.AnimatorListener kLL;
    private ValueAnimator.AnimatorUpdateListener kLM;
    private Animator.AnimatorListener kLN;

    public d(Context context, a.C0630a c0630a) {
        super(context, c0630a);
        this.kLE = false;
        this.kLF = false;
        this.kLG = false;
        this.kLK = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.kLE || animatedFraction < 0.6923f || !d.this.kLJ.kKY.isAnimating()) {
                    if (!d.this.kLG && animatedFraction >= 0.38461f && d.this.kLJ.kKY.isAnimating()) {
                        d.this.kLG = true;
                        return;
                    }
                    return;
                }
                d.this.kLE = true;
            }
        };
        this.kLL = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.cUh();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.kLM = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.kLF && animatedFraction >= 0.57142f && d.this.kLJ.kKY.isAnimating()) {
                    d.this.kLF = true;
                    d.this.cUi();
                }
            }
        };
        this.kLN = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.cUj();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.kLJ = c0630a;
        init();
    }

    private void init() {
        this.gKo = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gKo.setDuration(451L);
        this.gKo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.kLJ.cuz.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gKo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.kLJ.cuz.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gKp = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.gKp.setDuration(485L);
        this.gKp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.kLJ.cuz.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gKp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.kLJ.cuz.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLH = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kLH.setDuration(104L);
        this.kLH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.kLH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.kLI = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kLI.setDuration(208L);
        this.kLI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.kLI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void cUh() {
        this.kLJ.kKY.setVisibility(0);
        this.kLJ.tF(true);
        this.mState = 2;
        if (this.kMd != null) {
            this.kMd.CO(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUi() {
        this.kLH.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUj() {
        this.kLE = false;
        this.kLG = false;
        this.kLF = false;
        this.kLJ.tF(false);
        if (this.cYx != null) {
            this.cYx.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        Eb(8);
        this.mState = 4;
        if (this.kMd != null) {
            this.kMd.CO(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cUk() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.kMd != null) {
                this.kMd.CO(this.mState);
            }
            clearAnimation();
            Eb(0);
            this.kLJ.kKY.setVisibility(0);
            this.gKo.start();
            this.kLI.start();
            this.kLJ.kKY.removeAnimatorListener(this.kLN);
            this.kLJ.kKY.removeUpdateListener(this.kLM);
            this.kLJ.kKY.addAnimatorUpdateListener(this.kLK);
            this.kLJ.kKY.addAnimatorListener(this.kLL);
            this.kLJ.kKY.setMinAndMaxProgress(0.0f, 0.54f);
            this.kLJ.kKY.setProgress(0.0f);
            this.kLJ.kKY.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void startHideAnimation() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.kMd != null) {
                this.kMd.CO(this.mState);
            }
            this.kLJ.kKY.setVisibility(0);
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gKp.start();
                }
            }, 300L);
            this.kLJ.tF(false);
            this.kLJ.kKY.removeAnimatorListener(this.kLL);
            this.kLJ.kKY.removeUpdateListener(this.kLK);
            this.kLJ.kKY.addAnimatorUpdateListener(this.kLM);
            this.kLJ.kKY.addAnimatorListener(this.kLN);
            this.kLJ.kKY.setMinAndMaxProgress(0.54f, 1.0f);
            this.kLJ.kKY.setProgress(0.0f);
            this.kLJ.kKY.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cUl() {
        cUj();
    }

    @Override // com.baidu.tieba.write.g
    public void onDestroy() {
        clearAnimation();
        this.kLJ.kKY.cancelAnimation();
    }

    private void clearAnimation() {
        this.gKo.cancel();
        this.gKp.cancel();
        this.kLH.cancel();
        this.kLI.cancel();
    }

    private void Eb(int i) {
        this.kLJ.kKX.setVisibility(i);
        this.kLJ.cuz.setVisibility(i);
        this.kLJ.kKZ.setVerticalGravity(i);
    }
}
