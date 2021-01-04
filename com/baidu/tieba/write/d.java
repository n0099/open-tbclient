package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator jHq;
    private ValueAnimator jHr;
    private boolean nXb;
    private boolean nXc;
    private boolean nXd;
    private ValueAnimator nXe;
    private ValueAnimator nXf;
    private a.b nXg;
    private ValueAnimator.AnimatorUpdateListener nXh;
    private Animator.AnimatorListener nXi;
    private ValueAnimator.AnimatorUpdateListener nXj;
    private Animator.AnimatorListener nXk;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.nXb = false;
        this.nXc = false;
        this.nXd = false;
        this.nXh = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.nXb || animatedFraction < 0.6923f || !d.this.nXg.nWk.isAnimating()) {
                    if (!d.this.nXd && animatedFraction >= 0.38461f && d.this.nXg.nWk.isAnimating()) {
                        d.this.nXd = true;
                        return;
                    }
                    return;
                }
                d.this.nXb = true;
            }
        };
        this.nXi = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.Up();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.nXj = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.nXc && animatedFraction >= 0.57142f && d.this.nXg.nWk.isAnimating()) {
                    d.this.nXc = true;
                    d.this.dXV();
                }
            }
        };
        this.nXk = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.Uq();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.nXg = bVar;
        init();
    }

    private void init() {
        this.jHq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jHq.setDuration(451L);
        this.jHq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.nXg.eqn.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jHq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nXg.eqn.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jHr = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jHr.setDuration(485L);
        this.jHr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.nXg.eqn.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jHr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nXg.eqn.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nXe = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nXe.setDuration(104L);
        this.nXe.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nXe.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.nXf = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.nXf.setDuration(208L);
        this.nXf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nXf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void Up() {
        this.nXg.nWk.setVisibility(0);
        this.nXg.yY(true);
        this.mState = 2;
        if (this.nXI != null) {
            this.nXI.Mt(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXV() {
        this.nXe.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uq() {
        this.nXb = false;
        this.nXd = false;
        this.nXc = false;
        this.nXg.yY(false);
        if (this.fbS != null) {
            this.fbS.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        Mq(8);
        this.mState = 4;
        if (this.nXI != null) {
            this.nXI.Mt(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dXW() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nXI != null) {
                this.nXI.Mt(this.mState);
            }
            clearAnimation();
            Mq(0);
            this.nXg.nWk.setVisibility(0);
            this.jHq.start();
            this.nXf.start();
            this.nXg.nWk.removeAnimatorListener(this.nXk);
            this.nXg.nWk.removeUpdateListener(this.nXj);
            this.nXg.nWk.addAnimatorUpdateListener(this.nXh);
            this.nXg.nWk.addAnimatorListener(this.nXi);
            this.nXg.nWk.setMinAndMaxProgress(0.0f, 1.0f);
            this.nXg.nWk.setProgress(0.0f);
            this.nXg.nWk.setSpeed(1.4f);
            this.nXg.nWk.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aEu() {
        if (this.mState == 2) {
            this.nXg.yZ(false);
            this.mState = 3;
            if (this.nXI != null) {
                this.nXI.Mt(this.mState);
            }
            this.nXg.nWk.setVisibility(0);
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.jHr.start();
                }
            }, 300L);
            this.nXg.yY(false);
            this.nXg.nWk.removeAnimatorListener(this.nXi);
            this.nXg.nWk.removeUpdateListener(this.nXh);
            this.nXg.nWk.addAnimatorUpdateListener(this.nXj);
            this.nXg.nWk.addAnimatorListener(this.nXk);
            this.nXg.nWk.setMinAndMaxProgress(0.0f, 1.0f);
            this.nXg.nWk.setProgress(1.0f);
            this.nXg.nWk.setSpeed(-1.68f);
            this.nXg.nWk.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dXX() {
        Uq();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.nXg.nWk.cancelAnimation();
    }

    private void clearAnimation() {
        this.jHq.cancel();
        this.jHr.cancel();
        this.nXe.cancel();
        this.nXf.cancel();
    }

    private void Mq(int i) {
        this.nXg.nWj.setVisibility(i);
        this.nXg.eqn.setVisibility(i);
        this.nXg.nWl.setVisibility(i);
    }
}
