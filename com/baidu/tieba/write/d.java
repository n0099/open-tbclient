package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator juV;
    private ValueAnimator juW;
    private boolean nTG;
    private boolean nTH;
    private boolean nTI;
    private ValueAnimator nTJ;
    private ValueAnimator nTK;
    private a.b nTL;
    private ValueAnimator.AnimatorUpdateListener nTM;
    private Animator.AnimatorListener nTN;
    private ValueAnimator.AnimatorUpdateListener nTO;
    private Animator.AnimatorListener nTP;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.nTG = false;
        this.nTH = false;
        this.nTI = false;
        this.nTM = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.nTG || animatedFraction < 0.6923f || !d.this.nTL.nSP.isAnimating()) {
                    if (!d.this.nTI && animatedFraction >= 0.38461f && d.this.nTL.nSP.isAnimating()) {
                        d.this.nTI = true;
                        return;
                    }
                    return;
                }
                d.this.nTG = true;
            }
        };
        this.nTN = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
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
        this.nTO = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.nTH && animatedFraction >= 0.57142f && d.this.nTL.nSP.isAnimating()) {
                    d.this.nTH = true;
                    d.this.dYs();
                }
            }
        };
        this.nTP = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
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
        this.nTL = bVar;
        init();
    }

    private void init() {
        this.juV = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.juV.setDuration(451L);
        this.juV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.nTL.ehl.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.juV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nTL.ehl.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.juW = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.juW.setDuration(485L);
        this.juW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.nTL.ehl.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.juW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nTL.ehl.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nTJ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nTJ.setDuration(104L);
        this.nTJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nTJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.nTK = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.nTK.setDuration(208L);
        this.nTK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nTK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
        this.nTL.nSP.setVisibility(0);
        this.nTL.yY(true);
        this.mState = 2;
        if (this.nUn != null) {
            this.nUn.MG(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYs() {
        this.nTJ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tl() {
        this.nTG = false;
        this.nTI = false;
        this.nTH = false;
        this.nTL.yY(false);
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
        if (this.nUn != null) {
            this.nUn.MG(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dYt() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nUn != null) {
                this.nUn.MG(this.mState);
            }
            clearAnimation();
            MD(0);
            this.nTL.nSP.setVisibility(0);
            this.juV.start();
            this.nTK.start();
            this.nTL.nSP.removeAnimatorListener(this.nTP);
            this.nTL.nSP.removeUpdateListener(this.nTO);
            this.nTL.nSP.addAnimatorUpdateListener(this.nTM);
            this.nTL.nSP.addAnimatorListener(this.nTN);
            this.nTL.nSP.setMinAndMaxProgress(0.0f, 1.0f);
            this.nTL.nSP.setProgress(0.0f);
            this.nTL.nSP.setSpeed(1.4f);
            this.nTL.nSP.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aDc() {
        if (this.mState == 2) {
            this.nTL.yZ(false);
            this.mState = 3;
            if (this.nUn != null) {
                this.nUn.MG(this.mState);
            }
            this.nTL.nSP.setVisibility(0);
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.juW.start();
                }
            }, 300L);
            this.nTL.yY(false);
            this.nTL.nSP.removeAnimatorListener(this.nTN);
            this.nTL.nSP.removeUpdateListener(this.nTM);
            this.nTL.nSP.addAnimatorUpdateListener(this.nTO);
            this.nTL.nSP.addAnimatorListener(this.nTP);
            this.nTL.nSP.setMinAndMaxProgress(0.0f, 1.0f);
            this.nTL.nSP.setProgress(1.0f);
            this.nTL.nSP.setSpeed(-1.68f);
            this.nTL.nSP.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dYu() {
        Tl();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.nTL.nSP.cancelAnimation();
    }

    private void clearAnimation() {
        this.juV.cancel();
        this.juW.cancel();
        this.nTJ.cancel();
        this.nTK.cancel();
    }

    private void MD(int i) {
        this.nTL.nSO.setVisibility(i);
        this.nTL.ehl.setVisibility(i);
        this.nTL.nSQ.setVisibility(i);
    }
}
