package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator hXP;
    private ValueAnimator hXQ;
    private boolean mlF;
    private boolean mlG;
    private boolean mlH;
    private ValueAnimator mlI;
    private ValueAnimator mlJ;
    private a.b mlK;
    private ValueAnimator.AnimatorUpdateListener mlL;
    private Animator.AnimatorListener mlM;
    private ValueAnimator.AnimatorUpdateListener mlN;
    private Animator.AnimatorListener mlO;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.mlF = false;
        this.mlG = false;
        this.mlH = false;
        this.mlL = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.mlF || animatedFraction < 0.6923f || !d.this.mlK.mkR.isAnimating()) {
                    if (!d.this.mlH && animatedFraction >= 0.38461f && d.this.mlK.mkR.isAnimating()) {
                        d.this.mlH = true;
                        return;
                    }
                    return;
                }
                d.this.mlF = true;
            }
        };
        this.mlM = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dqR();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.mlN = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.mlG && animatedFraction >= 0.57142f && d.this.mlK.mkR.isAnimating()) {
                    d.this.mlG = true;
                    d.this.dqS();
                }
            }
        };
        this.mlO = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dqT();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.mlK = bVar;
        init();
    }

    private void init() {
        this.hXP = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.hXP.setDuration(451L);
        this.hXP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.mlK.djB.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hXP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.mlK.djB.setAlpha(1.0f);
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
                    d.this.mlK.djB.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hXQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.mlK.djB.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mlI = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mlI.setDuration(104L);
        this.mlI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.mlI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.mlJ = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mlJ.setDuration(208L);
        this.mlJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.mlJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void dqR() {
        this.mlK.mkR.setVisibility(0);
        this.mlK.vB(true);
        this.mState = 2;
        if (this.mmg != null) {
            this.mmg.Fp(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqS() {
        this.mlI.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqT() {
        this.mlF = false;
        this.mlH = false;
        this.mlG = false;
        this.mlK.vB(false);
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
        if (this.mmg != null) {
            this.mmg.Fp(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dqU() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.mmg != null) {
                this.mmg.Fp(this.mState);
            }
            clearAnimation();
            GB(0);
            this.mlK.mkR.setVisibility(0);
            this.hXP.start();
            this.mlJ.start();
            this.mlK.mkR.removeAnimatorListener(this.mlO);
            this.mlK.mkR.removeUpdateListener(this.mlN);
            this.mlK.mkR.addAnimatorUpdateListener(this.mlL);
            this.mlK.mkR.addAnimatorListener(this.mlM);
            this.mlK.mkR.setMinAndMaxProgress(0.0f, 1.0f);
            this.mlK.mkR.setProgress(0.0f);
            this.mlK.mkR.setSpeed(1.4f);
            this.mlK.mkR.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void ajJ() {
        if (this.mState == 2) {
            this.mlK.vC(false);
            this.mState = 3;
            if (this.mmg != null) {
                this.mmg.Fp(this.mState);
            }
            this.mlK.mkR.setVisibility(0);
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.hXQ.start();
                }
            }, 300L);
            this.mlK.vB(false);
            this.mlK.mkR.removeAnimatorListener(this.mlM);
            this.mlK.mkR.removeUpdateListener(this.mlL);
            this.mlK.mkR.addAnimatorUpdateListener(this.mlN);
            this.mlK.mkR.addAnimatorListener(this.mlO);
            this.mlK.mkR.setMinAndMaxProgress(0.0f, 1.0f);
            this.mlK.mkR.setProgress(1.0f);
            this.mlK.mkR.setSpeed(-1.68f);
            this.mlK.mkR.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dqV() {
        dqT();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.mlK.mkR.cancelAnimation();
    }

    private void clearAnimation() {
        this.hXP.cancel();
        this.hXQ.cancel();
        this.mlI.cancel();
        this.mlJ.cancel();
    }

    private void GB(int i) {
        this.mlK.mkQ.setVisibility(i);
        this.mlK.djB.setVisibility(i);
        this.mlK.mkS.setVerticalGravity(i);
    }
}
