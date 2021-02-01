package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator jIo;
    private ValueAnimator jIp;
    private boolean ocC;
    private boolean ocD;
    private boolean ocE;
    private ValueAnimator ocF;
    private ValueAnimator ocG;
    private a.b ocH;
    private ValueAnimator.AnimatorUpdateListener ocI;
    private Animator.AnimatorListener ocJ;
    private ValueAnimator.AnimatorUpdateListener ocK;
    private Animator.AnimatorListener ocL;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.ocC = false;
        this.ocD = false;
        this.ocE = false;
        this.ocI = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.ocC || animatedFraction < 0.6923f || !d.this.ocH.obK.isAnimating()) {
                    if (!d.this.ocE && animatedFraction >= 0.38461f && d.this.ocH.obK.isAnimating()) {
                        d.this.ocE = true;
                        return;
                    }
                    return;
                }
                d.this.ocC = true;
            }
        };
        this.ocJ = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
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
        this.ocK = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.ocD && animatedFraction >= 0.57142f && d.this.ocH.obK.isAnimating()) {
                    d.this.ocD = true;
                    d.this.dWs();
                }
            }
        };
        this.ocL = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
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
        this.ocH = bVar;
        init();
    }

    private void init() {
        this.jIo = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jIo.setDuration(451L);
        this.jIo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.ocH.enH.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jIo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.ocH.enH.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jIp = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jIp.setDuration(485L);
        this.jIp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.ocH.enH.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jIp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.ocH.enH.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ocF = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ocF.setDuration(104L);
        this.ocF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.ocF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.ocG = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.ocG.setDuration(208L);
        this.ocG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.ocG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
        this.ocH.obK.setVisibility(0);
        this.ocH.zq(true);
        this.mState = 2;
        if (this.odj != null) {
            this.odj.Lh(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWs() {
        this.ocF.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sf() {
        this.ocC = false;
        this.ocE = false;
        this.ocD = false;
        this.ocH.zq(false);
        if (this.eZA != null) {
            this.eZA.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        Le(8);
        this.mState = 4;
        if (this.odj != null) {
            this.odj.Lh(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dWt() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.odj != null) {
                this.odj.Lh(this.mState);
            }
            clearAnimation();
            Le(0);
            this.ocH.obK.setVisibility(0);
            this.jIo.start();
            this.ocG.start();
            this.ocH.obK.removeAnimatorListener(this.ocL);
            this.ocH.obK.removeUpdateListener(this.ocK);
            this.ocH.obK.addAnimatorUpdateListener(this.ocI);
            this.ocH.obK.addAnimatorListener(this.ocJ);
            this.ocH.obK.setMinAndMaxProgress(0.0f, 1.0f);
            this.ocH.obK.setProgress(0.0f);
            this.ocH.obK.setSpeed(1.4f);
            this.ocH.obK.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aAZ() {
        if (this.mState == 2) {
            this.ocH.zr(false);
            this.mState = 3;
            if (this.odj != null) {
                this.odj.Lh(this.mState);
            }
            this.ocH.obK.setVisibility(0);
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.jIp.start();
                }
            }, 300L);
            this.ocH.zq(false);
            this.ocH.obK.removeAnimatorListener(this.ocJ);
            this.ocH.obK.removeUpdateListener(this.ocI);
            this.ocH.obK.addAnimatorUpdateListener(this.ocK);
            this.ocH.obK.addAnimatorListener(this.ocL);
            this.ocH.obK.setMinAndMaxProgress(0.0f, 1.0f);
            this.ocH.obK.setProgress(1.0f);
            this.ocH.obK.setSpeed(-1.68f);
            this.ocH.obK.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dWu() {
        Sf();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.ocH.obK.cancelAnimation();
    }

    private void clearAnimation() {
        this.jIo.cancel();
        this.jIp.cancel();
        this.ocF.cancel();
        this.ocG.cancel();
    }

    private void Le(int i) {
        this.ocH.obJ.setVisibility(i);
        this.ocH.enH.setVisibility(i);
        this.ocH.obL.setVisibility(i);
    }
}
