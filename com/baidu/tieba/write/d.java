package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator hKD;
    private ValueAnimator hKE;
    private Animator.AnimatorListener lRA;
    private ValueAnimator.AnimatorUpdateListener lRB;
    private Animator.AnimatorListener lRC;
    private boolean lRt;
    private boolean lRu;
    private boolean lRv;
    private ValueAnimator lRw;
    private ValueAnimator lRx;
    private a.b lRy;
    private ValueAnimator.AnimatorUpdateListener lRz;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.lRt = false;
        this.lRu = false;
        this.lRv = false;
        this.lRz = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.lRt || animatedFraction < 0.6923f || !d.this.lRy.lQH.isAnimating()) {
                    if (!d.this.lRv && animatedFraction >= 0.38461f && d.this.lRy.lQH.isAnimating()) {
                        d.this.lRv = true;
                        return;
                    }
                    return;
                }
                d.this.lRt = true;
            }
        };
        this.lRA = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dmA();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.lRB = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.lRu && animatedFraction >= 0.57142f && d.this.lRy.lQH.isAnimating()) {
                    d.this.lRu = true;
                    d.this.dmB();
                }
            }
        };
        this.lRC = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dmC();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.lRy = bVar;
        init();
    }

    private void init() {
        this.hKD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.hKD.setDuration(451L);
        this.hKD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.lRy.deP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hKD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.lRy.deP.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hKE = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.hKE.setDuration(485L);
        this.hKE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.lRy.deP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hKE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.lRy.deP.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lRw = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lRw.setDuration(104L);
        this.lRw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.lRw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.lRx = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.lRx.setDuration(208L);
        this.lRx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.lRx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void dmA() {
        this.lRy.lQH.setVisibility(0);
        this.lRy.vj(true);
        this.mState = 2;
        if (this.lRT != null) {
            this.lRT.En(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmB() {
        this.lRw.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmC() {
        this.lRt = false;
        this.lRv = false;
        this.lRu = false;
        this.lRy.vj(false);
        if (this.dMf != null) {
            this.dMf.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        Fx(8);
        this.mState = 4;
        if (this.lRT != null) {
            this.lRT.En(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dmD() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.lRT != null) {
                this.lRT.En(this.mState);
            }
            clearAnimation();
            Fx(0);
            this.lRy.lQH.setVisibility(0);
            this.hKD.start();
            this.lRx.start();
            this.lRy.lQH.removeAnimatorListener(this.lRC);
            this.lRy.lQH.removeUpdateListener(this.lRB);
            this.lRy.lQH.addAnimatorUpdateListener(this.lRz);
            this.lRy.lQH.addAnimatorListener(this.lRA);
            this.lRy.lQH.setMinAndMaxProgress(0.0f, 1.0f);
            this.lRy.lQH.setProgress(0.0f);
            this.lRy.lQH.setSpeed(1.4f);
            this.lRy.lQH.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aiD() {
        if (this.mState == 2) {
            this.lRy.vk(false);
            this.mState = 3;
            if (this.lRT != null) {
                this.lRT.En(this.mState);
            }
            this.lRy.lQH.setVisibility(0);
            com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.hKE.start();
                }
            }, 300L);
            this.lRy.vj(false);
            this.lRy.lQH.removeAnimatorListener(this.lRA);
            this.lRy.lQH.removeUpdateListener(this.lRz);
            this.lRy.lQH.addAnimatorUpdateListener(this.lRB);
            this.lRy.lQH.addAnimatorListener(this.lRC);
            this.lRy.lQH.setMinAndMaxProgress(0.0f, 1.0f);
            this.lRy.lQH.setProgress(1.0f);
            this.lRy.lQH.setSpeed(-1.68f);
            this.lRy.lQH.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dmE() {
        dmC();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.lRy.lQH.cancelAnimation();
    }

    private void clearAnimation() {
        this.hKD.cancel();
        this.hKE.cancel();
        this.lRw.cancel();
        this.lRx.cancel();
    }

    private void Fx(int i) {
        this.lRy.lQG.setVisibility(i);
        this.lRy.deP.setVisibility(i);
        this.lRy.lQI.setVerticalGravity(i);
    }
}
