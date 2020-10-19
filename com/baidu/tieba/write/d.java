package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator iOm;
    private ValueAnimator iOn;
    private boolean nlG;
    private boolean nlH;
    private boolean nlI;
    private ValueAnimator nlJ;
    private ValueAnimator nlK;
    private a.b nlL;
    private ValueAnimator.AnimatorUpdateListener nlM;
    private Animator.AnimatorListener nlN;
    private ValueAnimator.AnimatorUpdateListener nlO;
    private Animator.AnimatorListener nlP;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.nlG = false;
        this.nlH = false;
        this.nlI = false;
        this.nlM = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.nlG || animatedFraction < 0.6923f || !d.this.nlL.nkP.isAnimating()) {
                    if (!d.this.nlI && animatedFraction >= 0.38461f && d.this.nlL.nkP.isAnimating()) {
                        d.this.nlI = true;
                        return;
                    }
                    return;
                }
                d.this.nlG = true;
            }
        };
        this.nlN = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dNo();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.nlO = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.nlH && animatedFraction >= 0.57142f && d.this.nlL.nkP.isAnimating()) {
                    d.this.nlH = true;
                    d.this.dNp();
                }
            }
        };
        this.nlP = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dNq();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.nlL = bVar;
        init();
    }

    private void init() {
        this.iOm = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iOm.setDuration(451L);
        this.iOm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.nlL.dNE.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.iOm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nlL.dNE.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iOn = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.iOn.setDuration(485L);
        this.iOn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.nlL.dNE.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.iOn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nlL.dNE.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nlJ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nlJ.setDuration(104L);
        this.nlJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nlJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.nlK = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.nlK.setDuration(208L);
        this.nlK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nlK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void dNo() {
        this.nlL.nkP.setVisibility(0);
        this.nlL.xM(true);
        this.mState = 2;
        if (this.nmj != null) {
            this.nmj.KG(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNp() {
        this.nlJ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNq() {
        this.nlG = false;
        this.nlI = false;
        this.nlH = false;
        this.nlL.xM(false);
        if (this.exv != null) {
            this.exv.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        KD(8);
        this.mState = 4;
        if (this.nmj != null) {
            this.nmj.KG(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dNr() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nmj != null) {
                this.nmj.KG(this.mState);
            }
            clearAnimation();
            KD(0);
            this.nlL.nkP.setVisibility(0);
            this.iOm.start();
            this.nlK.start();
            this.nlL.nkP.removeAnimatorListener(this.nlP);
            this.nlL.nkP.removeUpdateListener(this.nlO);
            this.nlL.nkP.addAnimatorUpdateListener(this.nlM);
            this.nlL.nkP.addAnimatorListener(this.nlN);
            this.nlL.nkP.setMinAndMaxProgress(0.0f, 1.0f);
            this.nlL.nkP.setProgress(0.0f);
            this.nlL.nkP.setSpeed(1.4f);
            this.nlL.nkP.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void awh() {
        if (this.mState == 2) {
            this.nlL.xN(false);
            this.mState = 3;
            if (this.nmj != null) {
                this.nmj.KG(this.mState);
            }
            this.nlL.nkP.setVisibility(0);
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.iOn.start();
                }
            }, 300L);
            this.nlL.xM(false);
            this.nlL.nkP.removeAnimatorListener(this.nlN);
            this.nlL.nkP.removeUpdateListener(this.nlM);
            this.nlL.nkP.addAnimatorUpdateListener(this.nlO);
            this.nlL.nkP.addAnimatorListener(this.nlP);
            this.nlL.nkP.setMinAndMaxProgress(0.0f, 1.0f);
            this.nlL.nkP.setProgress(1.0f);
            this.nlL.nkP.setSpeed(-1.68f);
            this.nlL.nkP.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dNs() {
        dNq();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.nlL.nkP.cancelAnimation();
    }

    private void clearAnimation() {
        this.iOm.cancel();
        this.iOn.cancel();
        this.nlJ.cancel();
        this.nlK.cancel();
    }

    private void KD(int i) {
        this.nlL.nkO.setVisibility(i);
        this.nlL.dNE.setVisibility(i);
        this.nlL.nkQ.setVerticalGravity(i);
    }
}
