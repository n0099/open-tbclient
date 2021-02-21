package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator jIC;
    private ValueAnimator jID;
    private boolean odc;
    private boolean odd;
    private boolean ode;
    private ValueAnimator odf;
    private ValueAnimator odg;
    private a.b odh;
    private ValueAnimator.AnimatorUpdateListener odi;
    private Animator.AnimatorListener odj;
    private ValueAnimator.AnimatorUpdateListener odk;
    private Animator.AnimatorListener odl;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.odc = false;
        this.odd = false;
        this.ode = false;
        this.odi = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.odc || animatedFraction < 0.6923f || !d.this.odh.ock.isAnimating()) {
                    if (!d.this.ode && animatedFraction >= 0.38461f && d.this.odh.ock.isAnimating()) {
                        d.this.ode = true;
                        return;
                    }
                    return;
                }
                d.this.odc = true;
            }
        };
        this.odj = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.Se();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.odk = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.odd && animatedFraction >= 0.57142f && d.this.odh.ock.isAnimating()) {
                    d.this.odd = true;
                    d.this.dWA();
                }
            }
        };
        this.odl = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.Sf();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.odh = bVar;
        init();
    }

    private void init() {
        this.jIC = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jIC.setDuration(451L);
        this.jIC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.odh.enH.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jIC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.odh.enH.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jID = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jID.setDuration(485L);
        this.jID.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.odh.enH.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jID.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.odh.enH.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.odf = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.odf.setDuration(104L);
        this.odf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.odf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.odg = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.odg.setDuration(208L);
        this.odg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.odg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void Se() {
        this.odh.ock.setVisibility(0);
        this.odh.zq(true);
        this.mState = 2;
        if (this.odJ != null) {
            this.odJ.Li(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWA() {
        this.odf.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sf() {
        this.odc = false;
        this.ode = false;
        this.odd = false;
        this.odh.zq(false);
        if (this.eZA != null) {
            this.eZA.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        Lf(8);
        this.mState = 4;
        if (this.odJ != null) {
            this.odJ.Li(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dWB() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.odJ != null) {
                this.odJ.Li(this.mState);
            }
            clearAnimation();
            Lf(0);
            this.odh.ock.setVisibility(0);
            this.jIC.start();
            this.odg.start();
            this.odh.ock.removeAnimatorListener(this.odl);
            this.odh.ock.removeUpdateListener(this.odk);
            this.odh.ock.addAnimatorUpdateListener(this.odi);
            this.odh.ock.addAnimatorListener(this.odj);
            this.odh.ock.setMinAndMaxProgress(0.0f, 1.0f);
            this.odh.ock.setProgress(0.0f);
            this.odh.ock.setSpeed(1.4f);
            this.odh.ock.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aAZ() {
        if (this.mState == 2) {
            this.odh.zr(false);
            this.mState = 3;
            if (this.odJ != null) {
                this.odJ.Li(this.mState);
            }
            this.odh.ock.setVisibility(0);
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.jID.start();
                }
            }, 300L);
            this.odh.zq(false);
            this.odh.ock.removeAnimatorListener(this.odj);
            this.odh.ock.removeUpdateListener(this.odi);
            this.odh.ock.addAnimatorUpdateListener(this.odk);
            this.odh.ock.addAnimatorListener(this.odl);
            this.odh.ock.setMinAndMaxProgress(0.0f, 1.0f);
            this.odh.ock.setProgress(1.0f);
            this.odh.ock.setSpeed(-1.68f);
            this.odh.ock.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dWC() {
        Sf();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.odh.ock.cancelAnimation();
    }

    private void clearAnimation() {
        this.jIC.cancel();
        this.jID.cancel();
        this.odf.cancel();
        this.odg.cancel();
    }

    private void Lf(int i) {
        this.odh.ocj.setVisibility(i);
        this.odh.enH.setVisibility(i);
        this.odh.ocl.setVisibility(i);
    }
}
