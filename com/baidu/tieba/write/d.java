package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator jgF;
    private ValueAnimator jgG;
    private boolean nEb;
    private boolean nEc;
    private boolean nEd;
    private ValueAnimator nEe;
    private ValueAnimator nEf;
    private a.b nEg;
    private ValueAnimator.AnimatorUpdateListener nEh;
    private Animator.AnimatorListener nEi;
    private ValueAnimator.AnimatorUpdateListener nEj;
    private Animator.AnimatorListener nEk;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.nEb = false;
        this.nEc = false;
        this.nEd = false;
        this.nEh = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.nEb || animatedFraction < 0.6923f || !d.this.nEg.nDk.isAnimating()) {
                    if (!d.this.nEd && animatedFraction >= 0.38461f && d.this.nEg.nDk.isAnimating()) {
                        d.this.nEd = true;
                        return;
                    }
                    return;
                }
                d.this.nEb = true;
            }
        };
        this.nEi = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.Rv();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.nEj = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.nEc && animatedFraction >= 0.57142f && d.this.nEg.nDk.isAnimating()) {
                    d.this.nEc = true;
                    d.this.dSY();
                }
            }
        };
        this.nEk = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.Rw();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.nEg = bVar;
        init();
    }

    private void init() {
        this.jgF = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jgF.setDuration(451L);
        this.jgF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.nEg.ebT.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jgF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nEg.ebT.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jgG = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jgG.setDuration(485L);
        this.jgG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.nEg.ebT.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jgG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nEg.ebT.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nEe = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nEe.setDuration(104L);
        this.nEe.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nEe.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.nEf = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.nEf.setDuration(208L);
        this.nEf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nEf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void Rv() {
        this.nEg.nDk.setVisibility(0);
        this.nEg.ym(true);
        this.mState = 2;
        if (this.nEE != null) {
            this.nEE.Ll(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSY() {
        this.nEe.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rw() {
        this.nEb = false;
        this.nEd = false;
        this.nEc = false;
        this.nEg.ym(false);
        if (this.eLI != null) {
            this.eLI.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        Li(8);
        this.mState = 4;
        if (this.nEE != null) {
            this.nEE.Ll(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dSZ() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nEE != null) {
                this.nEE.Ll(this.mState);
            }
            clearAnimation();
            Li(0);
            this.nEg.nDk.setVisibility(0);
            this.jgF.start();
            this.nEf.start();
            this.nEg.nDk.removeAnimatorListener(this.nEk);
            this.nEg.nDk.removeUpdateListener(this.nEj);
            this.nEg.nDk.addAnimatorUpdateListener(this.nEh);
            this.nEg.nDk.addAnimatorListener(this.nEi);
            this.nEg.nDk.setMinAndMaxProgress(0.0f, 1.0f);
            this.nEg.nDk.setProgress(0.0f);
            this.nEg.nDk.setSpeed(1.4f);
            this.nEg.nDk.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aAB() {
        if (this.mState == 2) {
            this.nEg.yn(false);
            this.mState = 3;
            if (this.nEE != null) {
                this.nEE.Ll(this.mState);
            }
            this.nEg.nDk.setVisibility(0);
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.jgG.start();
                }
            }, 300L);
            this.nEg.ym(false);
            this.nEg.nDk.removeAnimatorListener(this.nEi);
            this.nEg.nDk.removeUpdateListener(this.nEh);
            this.nEg.nDk.addAnimatorUpdateListener(this.nEj);
            this.nEg.nDk.addAnimatorListener(this.nEk);
            this.nEg.nDk.setMinAndMaxProgress(0.0f, 1.0f);
            this.nEg.nDk.setProgress(1.0f);
            this.nEg.nDk.setSpeed(-1.68f);
            this.nEg.nDk.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dTa() {
        Rw();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.nEg.nDk.cancelAnimation();
    }

    private void clearAnimation() {
        this.jgF.cancel();
        this.jgG.cancel();
        this.nEe.cancel();
        this.nEf.cancel();
    }

    private void Li(int i) {
        this.nEg.nDj.setVisibility(i);
        this.nEg.ebT.setVisibility(i);
        this.nEg.nDl.setVerticalGravity(i);
    }
}
