package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator jKl;
    private ValueAnimator jKm;
    private boolean ofi;
    private boolean ofj;
    private boolean ofk;
    private ValueAnimator ofl;
    private ValueAnimator ofm;
    private a.b ofn;
    private ValueAnimator.AnimatorUpdateListener ofo;
    private Animator.AnimatorListener ofp;
    private ValueAnimator.AnimatorUpdateListener ofq;
    private Animator.AnimatorListener ofr;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.ofi = false;
        this.ofj = false;
        this.ofk = false;
        this.ofo = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.ofi || animatedFraction < 0.6923f || !d.this.ofn.oeq.isAnimating()) {
                    if (!d.this.ofk && animatedFraction >= 0.38461f && d.this.ofn.oeq.isAnimating()) {
                        d.this.ofk = true;
                        return;
                    }
                    return;
                }
                d.this.ofi = true;
            }
        };
        this.ofp = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.Sh();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.ofq = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.ofj && animatedFraction >= 0.57142f && d.this.ofn.oeq.isAnimating()) {
                    d.this.ofj = true;
                    d.this.dWI();
                }
            }
        };
        this.ofr = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.Si();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.ofn = bVar;
        init();
    }

    private void init() {
        this.jKl = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jKl.setDuration(451L);
        this.jKl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.ofn.epj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jKl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.ofn.epj.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jKm = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jKm.setDuration(485L);
        this.jKm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.ofn.epj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jKm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.ofn.epj.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ofl = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ofl.setDuration(104L);
        this.ofl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.ofl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.ofm = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.ofm.setDuration(208L);
        this.ofm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.ofm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void Sh() {
        this.ofn.oeq.setVisibility(0);
        this.ofn.zp(true);
        this.mState = 2;
        if (this.ofP != null) {
            this.ofP.Lm(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWI() {
        this.ofl.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Si() {
        this.ofi = false;
        this.ofk = false;
        this.ofj = false;
        this.ofn.zp(false);
        if (this.faZ != null) {
            this.faZ.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        Lj(8);
        this.mState = 4;
        if (this.ofP != null) {
            this.ofP.Lm(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dWJ() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.ofP != null) {
                this.ofP.Lm(this.mState);
            }
            clearAnimation();
            Lj(0);
            this.ofn.oeq.setVisibility(0);
            this.jKl.start();
            this.ofm.start();
            this.ofn.oeq.removeAnimatorListener(this.ofr);
            this.ofn.oeq.removeUpdateListener(this.ofq);
            this.ofn.oeq.addAnimatorUpdateListener(this.ofo);
            this.ofn.oeq.addAnimatorListener(this.ofp);
            this.ofn.oeq.setMinAndMaxProgress(0.0f, 1.0f);
            this.ofn.oeq.setProgress(0.0f);
            this.ofn.oeq.setSpeed(1.4f);
            this.ofn.oeq.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aBc() {
        if (this.mState == 2) {
            this.ofn.zq(false);
            this.mState = 3;
            if (this.ofP != null) {
                this.ofP.Lm(this.mState);
            }
            this.ofn.oeq.setVisibility(0);
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.jKm.start();
                }
            }, 300L);
            this.ofn.zp(false);
            this.ofn.oeq.removeAnimatorListener(this.ofp);
            this.ofn.oeq.removeUpdateListener(this.ofo);
            this.ofn.oeq.addAnimatorUpdateListener(this.ofq);
            this.ofn.oeq.addAnimatorListener(this.ofr);
            this.ofn.oeq.setMinAndMaxProgress(0.0f, 1.0f);
            this.ofn.oeq.setProgress(1.0f);
            this.ofn.oeq.setSpeed(-1.68f);
            this.ofn.oeq.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dWK() {
        Si();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.ofn.oeq.cancelAnimation();
    }

    private void clearAnimation() {
        this.jKl.cancel();
        this.jKm.cancel();
        this.ofl.cancel();
        this.ofm.cancel();
    }

    private void Lj(int i) {
        this.ofn.oep.setVisibility(i);
        this.ofn.epj.setVisibility(i);
        this.ofn.oer.setVisibility(i);
    }
}
