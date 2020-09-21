package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator izt;
    private ValueAnimator izu;
    private boolean mWh;
    private boolean mWi;
    private boolean mWj;
    private ValueAnimator mWk;
    private ValueAnimator mWl;
    private a.b mWm;
    private ValueAnimator.AnimatorUpdateListener mWn;
    private Animator.AnimatorListener mWo;
    private ValueAnimator.AnimatorUpdateListener mWp;
    private Animator.AnimatorListener mWq;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.mWh = false;
        this.mWi = false;
        this.mWj = false;
        this.mWn = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.mWh || animatedFraction < 0.6923f || !d.this.mWm.mVq.isAnimating()) {
                    if (!d.this.mWj && animatedFraction >= 0.38461f && d.this.mWm.mVq.isAnimating()) {
                        d.this.mWj = true;
                        return;
                    }
                    return;
                }
                d.this.mWh = true;
            }
        };
        this.mWo = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dJC();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.mWp = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.mWi && animatedFraction >= 0.57142f && d.this.mWm.mVq.isAnimating()) {
                    d.this.mWi = true;
                    d.this.dJD();
                }
            }
        };
        this.mWq = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dJE();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.mWm = bVar;
        init();
    }

    private void init() {
        this.izt = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.izt.setDuration(451L);
        this.izt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.mWm.dBD.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.izt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.mWm.dBD.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.izu = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.izu.setDuration(485L);
        this.izu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.mWm.dBD.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.izu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.mWm.dBD.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mWk = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mWk.setDuration(104L);
        this.mWk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.mWk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.mWl = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mWl.setDuration(208L);
        this.mWl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.mWl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void dJC() {
        this.mWm.mVq.setVisibility(0);
        this.mWm.xf(true);
        this.mState = 2;
        if (this.mWK != null) {
            this.mWK.Ka(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJD() {
        this.mWk.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJE() {
        this.mWh = false;
        this.mWj = false;
        this.mWi = false;
        this.mWm.xf(false);
        if (this.elm != null) {
            this.elm.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        JX(8);
        this.mState = 4;
        if (this.mWK != null) {
            this.mWK.Ka(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dJF() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.mWK != null) {
                this.mWK.Ka(this.mState);
            }
            clearAnimation();
            JX(0);
            this.mWm.mVq.setVisibility(0);
            this.izt.start();
            this.mWl.start();
            this.mWm.mVq.removeAnimatorListener(this.mWq);
            this.mWm.mVq.removeUpdateListener(this.mWp);
            this.mWm.mVq.addAnimatorUpdateListener(this.mWn);
            this.mWm.mVq.addAnimatorListener(this.mWo);
            this.mWm.mVq.setMinAndMaxProgress(0.0f, 1.0f);
            this.mWm.mVq.setProgress(0.0f);
            this.mWm.mVq.setSpeed(1.4f);
            this.mWm.mVq.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void atw() {
        if (this.mState == 2) {
            this.mWm.xg(false);
            this.mState = 3;
            if (this.mWK != null) {
                this.mWK.Ka(this.mState);
            }
            this.mWm.mVq.setVisibility(0);
            com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.izu.start();
                }
            }, 300L);
            this.mWm.xf(false);
            this.mWm.mVq.removeAnimatorListener(this.mWo);
            this.mWm.mVq.removeUpdateListener(this.mWn);
            this.mWm.mVq.addAnimatorUpdateListener(this.mWp);
            this.mWm.mVq.addAnimatorListener(this.mWq);
            this.mWm.mVq.setMinAndMaxProgress(0.0f, 1.0f);
            this.mWm.mVq.setProgress(1.0f);
            this.mWm.mVq.setSpeed(-1.68f);
            this.mWm.mVq.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dJG() {
        dJE();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.mWm.mVq.cancelAnimation();
    }

    private void clearAnimation() {
        this.izt.cancel();
        this.izu.cancel();
        this.mWk.cancel();
        this.mWl.cancel();
    }

    private void JX(int i) {
        this.mWm.mVp.setVisibility(i);
        this.mWm.dBD.setVisibility(i);
        this.mWm.mVr.setVerticalGravity(i);
    }
}
