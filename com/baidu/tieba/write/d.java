package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator jHq;
    private ValueAnimator jHr;
    private boolean nXa;
    private boolean nXb;
    private boolean nXc;
    private ValueAnimator nXd;
    private ValueAnimator nXe;
    private a.b nXf;
    private ValueAnimator.AnimatorUpdateListener nXg;
    private Animator.AnimatorListener nXh;
    private ValueAnimator.AnimatorUpdateListener nXi;
    private Animator.AnimatorListener nXj;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.nXa = false;
        this.nXb = false;
        this.nXc = false;
        this.nXg = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.nXa || animatedFraction < 0.6923f || !d.this.nXf.nWj.isAnimating()) {
                    if (!d.this.nXc && animatedFraction >= 0.38461f && d.this.nXf.nWj.isAnimating()) {
                        d.this.nXc = true;
                        return;
                    }
                    return;
                }
                d.this.nXa = true;
            }
        };
        this.nXh = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
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
        this.nXi = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.nXb && animatedFraction >= 0.57142f && d.this.nXf.nWj.isAnimating()) {
                    d.this.nXb = true;
                    d.this.dXW();
                }
            }
        };
        this.nXj = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
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
        this.nXf = bVar;
        init();
    }

    private void init() {
        this.jHq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jHq.setDuration(451L);
        this.jHq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.nXf.eqn.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jHq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nXf.eqn.setAlpha(1.0f);
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
                    d.this.nXf.eqn.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jHr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nXf.eqn.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nXd = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nXd.setDuration(104L);
        this.nXd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nXd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.nXe = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.nXe.setDuration(208L);
        this.nXe.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nXe.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
        this.nXf.nWj.setVisibility(0);
        this.nXf.yY(true);
        this.mState = 2;
        if (this.nXH != null) {
            this.nXH.Mt(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXW() {
        this.nXd.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uq() {
        this.nXa = false;
        this.nXc = false;
        this.nXb = false;
        this.nXf.yY(false);
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
        if (this.nXH != null) {
            this.nXH.Mt(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dXX() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nXH != null) {
                this.nXH.Mt(this.mState);
            }
            clearAnimation();
            Mq(0);
            this.nXf.nWj.setVisibility(0);
            this.jHq.start();
            this.nXe.start();
            this.nXf.nWj.removeAnimatorListener(this.nXj);
            this.nXf.nWj.removeUpdateListener(this.nXi);
            this.nXf.nWj.addAnimatorUpdateListener(this.nXg);
            this.nXf.nWj.addAnimatorListener(this.nXh);
            this.nXf.nWj.setMinAndMaxProgress(0.0f, 1.0f);
            this.nXf.nWj.setProgress(0.0f);
            this.nXf.nWj.setSpeed(1.4f);
            this.nXf.nWj.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aEv() {
        if (this.mState == 2) {
            this.nXf.yZ(false);
            this.mState = 3;
            if (this.nXH != null) {
                this.nXH.Mt(this.mState);
            }
            this.nXf.nWj.setVisibility(0);
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.jHr.start();
                }
            }, 300L);
            this.nXf.yY(false);
            this.nXf.nWj.removeAnimatorListener(this.nXh);
            this.nXf.nWj.removeUpdateListener(this.nXg);
            this.nXf.nWj.addAnimatorUpdateListener(this.nXi);
            this.nXf.nWj.addAnimatorListener(this.nXj);
            this.nXf.nWj.setMinAndMaxProgress(0.0f, 1.0f);
            this.nXf.nWj.setProgress(1.0f);
            this.nXf.nWj.setSpeed(-1.68f);
            this.nXf.nWj.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dXY() {
        Uq();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.nXf.nWj.cancelAnimation();
    }

    private void clearAnimation() {
        this.jHq.cancel();
        this.jHr.cancel();
        this.nXd.cancel();
        this.nXe.cancel();
    }

    private void Mq(int i) {
        this.nXf.nWi.setVisibility(i);
        this.nXf.eqn.setVisibility(i);
        this.nXf.nWk.setVisibility(i);
    }
}
