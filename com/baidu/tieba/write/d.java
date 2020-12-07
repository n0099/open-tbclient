package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator juT;
    private ValueAnimator juU;
    private boolean nTE;
    private boolean nTF;
    private boolean nTG;
    private ValueAnimator nTH;
    private ValueAnimator nTI;
    private a.b nTJ;
    private ValueAnimator.AnimatorUpdateListener nTK;
    private Animator.AnimatorListener nTL;
    private ValueAnimator.AnimatorUpdateListener nTM;
    private Animator.AnimatorListener nTN;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.nTE = false;
        this.nTF = false;
        this.nTG = false;
        this.nTK = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.nTE || animatedFraction < 0.6923f || !d.this.nTJ.nSN.isAnimating()) {
                    if (!d.this.nTG && animatedFraction >= 0.38461f && d.this.nTJ.nSN.isAnimating()) {
                        d.this.nTG = true;
                        return;
                    }
                    return;
                }
                d.this.nTE = true;
            }
        };
        this.nTL = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.Tk();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.nTM = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.nTF && animatedFraction >= 0.57142f && d.this.nTJ.nSN.isAnimating()) {
                    d.this.nTF = true;
                    d.this.dYr();
                }
            }
        };
        this.nTN = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.Tl();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.nTJ = bVar;
        init();
    }

    private void init() {
        this.juT = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.juT.setDuration(451L);
        this.juT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.nTJ.ehl.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.juT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nTJ.ehl.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.juU = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.juU.setDuration(485L);
        this.juU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.nTJ.ehl.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.juU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nTJ.ehl.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nTH = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nTH.setDuration(104L);
        this.nTH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nTH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.nTI = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.nTI.setDuration(208L);
        this.nTI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nTI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void Tk() {
        this.nTJ.nSN.setVisibility(0);
        this.nTJ.yY(true);
        this.mState = 2;
        if (this.nUl != null) {
            this.nUl.MG(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYr() {
        this.nTH.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tl() {
        this.nTE = false;
        this.nTG = false;
        this.nTF = false;
        this.nTJ.yY(false);
        if (this.eRT != null) {
            this.eRT.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        MD(8);
        this.mState = 4;
        if (this.nUl != null) {
            this.nUl.MG(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dYs() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nUl != null) {
                this.nUl.MG(this.mState);
            }
            clearAnimation();
            MD(0);
            this.nTJ.nSN.setVisibility(0);
            this.juT.start();
            this.nTI.start();
            this.nTJ.nSN.removeAnimatorListener(this.nTN);
            this.nTJ.nSN.removeUpdateListener(this.nTM);
            this.nTJ.nSN.addAnimatorUpdateListener(this.nTK);
            this.nTJ.nSN.addAnimatorListener(this.nTL);
            this.nTJ.nSN.setMinAndMaxProgress(0.0f, 1.0f);
            this.nTJ.nSN.setProgress(0.0f);
            this.nTJ.nSN.setSpeed(1.4f);
            this.nTJ.nSN.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aDc() {
        if (this.mState == 2) {
            this.nTJ.yZ(false);
            this.mState = 3;
            if (this.nUl != null) {
                this.nUl.MG(this.mState);
            }
            this.nTJ.nSN.setVisibility(0);
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.juU.start();
                }
            }, 300L);
            this.nTJ.yY(false);
            this.nTJ.nSN.removeAnimatorListener(this.nTL);
            this.nTJ.nSN.removeUpdateListener(this.nTK);
            this.nTJ.nSN.addAnimatorUpdateListener(this.nTM);
            this.nTJ.nSN.addAnimatorListener(this.nTN);
            this.nTJ.nSN.setMinAndMaxProgress(0.0f, 1.0f);
            this.nTJ.nSN.setProgress(1.0f);
            this.nTJ.nSN.setSpeed(-1.68f);
            this.nTJ.nSN.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dYt() {
        Tl();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.nTJ.nSN.cancelAnimation();
    }

    private void clearAnimation() {
        this.juT.cancel();
        this.juU.cancel();
        this.nTH.cancel();
        this.nTI.cancel();
    }

    private void MD(int i) {
        this.nTJ.nSM.setVisibility(i);
        this.nTJ.ehl.setVisibility(i);
        this.nTJ.nSO.setVisibility(i);
    }
}
