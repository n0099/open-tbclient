package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator hXP;
    private ValueAnimator hXQ;
    private boolean mlC;
    private boolean mlD;
    private boolean mlE;
    private ValueAnimator mlF;
    private ValueAnimator mlG;
    private a.b mlH;
    private ValueAnimator.AnimatorUpdateListener mlI;
    private Animator.AnimatorListener mlJ;
    private ValueAnimator.AnimatorUpdateListener mlK;
    private Animator.AnimatorListener mlL;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.mlC = false;
        this.mlD = false;
        this.mlE = false;
        this.mlI = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.mlC || animatedFraction < 0.6923f || !d.this.mlH.mkO.isAnimating()) {
                    if (!d.this.mlE && animatedFraction >= 0.38461f && d.this.mlH.mkO.isAnimating()) {
                        d.this.mlE = true;
                        return;
                    }
                    return;
                }
                d.this.mlC = true;
            }
        };
        this.mlJ = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dqN();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.mlK = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.mlD && animatedFraction >= 0.57142f && d.this.mlH.mkO.isAnimating()) {
                    d.this.mlD = true;
                    d.this.dqO();
                }
            }
        };
        this.mlL = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dqP();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.mlH = bVar;
        init();
    }

    private void init() {
        this.hXP = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.hXP.setDuration(451L);
        this.hXP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.mlH.djB.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hXP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.mlH.djB.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hXQ = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.hXQ.setDuration(485L);
        this.hXQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.mlH.djB.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hXQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.mlH.djB.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mlF = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mlF.setDuration(104L);
        this.mlF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.mlF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.mlG = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mlG.setDuration(208L);
        this.mlG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.mlG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void dqN() {
        this.mlH.mkO.setVisibility(0);
        this.mlH.vB(true);
        this.mState = 2;
        if (this.mmd != null) {
            this.mmd.Fp(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqO() {
        this.mlF.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqP() {
        this.mlC = false;
        this.mlE = false;
        this.mlD = false;
        this.mlH.vB(false);
        if (this.dSV != null) {
            this.dSV.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        GB(8);
        this.mState = 4;
        if (this.mmd != null) {
            this.mmd.Fp(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dqQ() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.mmd != null) {
                this.mmd.Fp(this.mState);
            }
            clearAnimation();
            GB(0);
            this.mlH.mkO.setVisibility(0);
            this.hXP.start();
            this.mlG.start();
            this.mlH.mkO.removeAnimatorListener(this.mlL);
            this.mlH.mkO.removeUpdateListener(this.mlK);
            this.mlH.mkO.addAnimatorUpdateListener(this.mlI);
            this.mlH.mkO.addAnimatorListener(this.mlJ);
            this.mlH.mkO.setMinAndMaxProgress(0.0f, 1.0f);
            this.mlH.mkO.setProgress(0.0f);
            this.mlH.mkO.setSpeed(1.4f);
            this.mlH.mkO.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void ajJ() {
        if (this.mState == 2) {
            this.mlH.vC(false);
            this.mState = 3;
            if (this.mmd != null) {
                this.mmd.Fp(this.mState);
            }
            this.mlH.mkO.setVisibility(0);
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.hXQ.start();
                }
            }, 300L);
            this.mlH.vB(false);
            this.mlH.mkO.removeAnimatorListener(this.mlJ);
            this.mlH.mkO.removeUpdateListener(this.mlI);
            this.mlH.mkO.addAnimatorUpdateListener(this.mlK);
            this.mlH.mkO.addAnimatorListener(this.mlL);
            this.mlH.mkO.setMinAndMaxProgress(0.0f, 1.0f);
            this.mlH.mkO.setProgress(1.0f);
            this.mlH.mkO.setSpeed(-1.68f);
            this.mlH.mkO.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dqR() {
        dqP();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.mlH.mkO.cancelAnimation();
    }

    private void clearAnimation() {
        this.hXP.cancel();
        this.hXQ.cancel();
        this.mlF.cancel();
        this.mlG.cancel();
    }

    private void GB(int i) {
        this.mlH.mkN.setVisibility(i);
        this.mlH.djB.setVisibility(i);
        this.mlH.mkP.setVerticalGravity(i);
    }
}
