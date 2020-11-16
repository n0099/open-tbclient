package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator jhq;
    private ValueAnimator jhr;
    private boolean nFA;
    private ValueAnimator nFB;
    private ValueAnimator nFC;
    private a.b nFD;
    private ValueAnimator.AnimatorUpdateListener nFE;
    private Animator.AnimatorListener nFF;
    private ValueAnimator.AnimatorUpdateListener nFG;
    private Animator.AnimatorListener nFH;
    private boolean nFy;
    private boolean nFz;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.nFy = false;
        this.nFz = false;
        this.nFA = false;
        this.nFE = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.nFy || animatedFraction < 0.6923f || !d.this.nFD.nEH.isAnimating()) {
                    if (!d.this.nFA && animatedFraction >= 0.38461f && d.this.nFD.nEH.isAnimating()) {
                        d.this.nFA = true;
                        return;
                    }
                    return;
                }
                d.this.nFy = true;
            }
        };
        this.nFF = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.QM();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.nFG = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.nFz && animatedFraction >= 0.57142f && d.this.nFD.nEH.isAnimating()) {
                    d.this.nFz = true;
                    d.this.dSX();
                }
            }
        };
        this.nFH = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.QN();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.nFD = bVar;
        init();
    }

    private void init() {
        this.jhq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jhq.setDuration(451L);
        this.jhq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.nFD.eal.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jhq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nFD.eal.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jhr = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jhr.setDuration(485L);
        this.jhr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.nFD.eal.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jhr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nFD.eal.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nFB = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nFB.setDuration(104L);
        this.nFB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nFB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.nFC = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.nFC.setDuration(208L);
        this.nFC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nFC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void QM() {
        this.nFD.nEH.setVisibility(0);
        this.nFD.yt(true);
        this.mState = 2;
        if (this.nGf != null) {
            this.nGf.LO(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSX() {
        this.nFB.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QN() {
        this.nFy = false;
        this.nFA = false;
        this.nFz = false;
        this.nFD.yt(false);
        if (this.eKH != null) {
            this.eKH.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        LL(8);
        this.mState = 4;
        if (this.nGf != null) {
            this.nGf.LO(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dSY() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nGf != null) {
                this.nGf.LO(this.mState);
            }
            clearAnimation();
            LL(0);
            this.nFD.nEH.setVisibility(0);
            this.jhq.start();
            this.nFC.start();
            this.nFD.nEH.removeAnimatorListener(this.nFH);
            this.nFD.nEH.removeUpdateListener(this.nFG);
            this.nFD.nEH.addAnimatorUpdateListener(this.nFE);
            this.nFD.nEH.addAnimatorListener(this.nFF);
            this.nFD.nEH.setMinAndMaxProgress(0.0f, 1.0f);
            this.nFD.nEH.setProgress(0.0f);
            this.nFD.nEH.setSpeed(1.4f);
            this.nFD.nEH.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void azT() {
        if (this.mState == 2) {
            this.nFD.yu(false);
            this.mState = 3;
            if (this.nGf != null) {
                this.nGf.LO(this.mState);
            }
            this.nFD.nEH.setVisibility(0);
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.jhr.start();
                }
            }, 300L);
            this.nFD.yt(false);
            this.nFD.nEH.removeAnimatorListener(this.nFF);
            this.nFD.nEH.removeUpdateListener(this.nFE);
            this.nFD.nEH.addAnimatorUpdateListener(this.nFG);
            this.nFD.nEH.addAnimatorListener(this.nFH);
            this.nFD.nEH.setMinAndMaxProgress(0.0f, 1.0f);
            this.nFD.nEH.setProgress(1.0f);
            this.nFD.nEH.setSpeed(-1.68f);
            this.nFD.nEH.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dSZ() {
        QN();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.nFD.nEH.cancelAnimation();
    }

    private void clearAnimation() {
        this.jhq.cancel();
        this.jhr.cancel();
        this.nFB.cancel();
        this.nFC.cancel();
    }

    private void LL(int i) {
        this.nFD.nEG.setVisibility(i);
        this.nFD.eal.setVisibility(i);
        this.nFD.nEI.setVisibility(i);
    }
}
