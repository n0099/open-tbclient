package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator idR;
    private ValueAnimator idS;
    private boolean mtG;
    private boolean mtH;
    private boolean mtI;
    private ValueAnimator mtJ;
    private ValueAnimator mtK;
    private a.b mtL;
    private ValueAnimator.AnimatorUpdateListener mtM;
    private Animator.AnimatorListener mtN;
    private ValueAnimator.AnimatorUpdateListener mtO;
    private Animator.AnimatorListener mtP;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.mtG = false;
        this.mtH = false;
        this.mtI = false;
        this.mtM = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.mtG || animatedFraction < 0.6923f || !d.this.mtL.msS.isAnimating()) {
                    if (!d.this.mtI && animatedFraction >= 0.38461f && d.this.mtL.msS.isAnimating()) {
                        d.this.mtI = true;
                        return;
                    }
                    return;
                }
                d.this.mtG = true;
            }
        };
        this.mtN = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dud();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.mtO = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.mtH && animatedFraction >= 0.57142f && d.this.mtL.msS.isAnimating()) {
                    d.this.mtH = true;
                    d.this.due();
                }
            }
        };
        this.mtP = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.duf();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.mtL = bVar;
        init();
    }

    private void init() {
        this.idR = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.idR.setDuration(451L);
        this.idR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.mtL.dpw.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.idR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.mtL.dpw.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.idS = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.idS.setDuration(485L);
        this.idS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.mtL.dpw.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.idS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.mtL.dpw.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mtJ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mtJ.setDuration(104L);
        this.mtJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.mtJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.mtK = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mtK.setDuration(208L);
        this.mtK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.mtK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void dud() {
        this.mtL.msS.setVisibility(0);
        this.mtL.wf(true);
        this.mState = 2;
        if (this.mug != null) {
            this.mug.FL(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void due() {
        this.mtJ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duf() {
        this.mtG = false;
        this.mtI = false;
        this.mtH = false;
        this.mtL.wf(false);
        if (this.dZn != null) {
            this.dZn.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        GX(8);
        this.mState = 4;
        if (this.mug != null) {
            this.mug.FL(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dug() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.mug != null) {
                this.mug.FL(this.mState);
            }
            clearAnimation();
            GX(0);
            this.mtL.msS.setVisibility(0);
            this.idR.start();
            this.mtK.start();
            this.mtL.msS.removeAnimatorListener(this.mtP);
            this.mtL.msS.removeUpdateListener(this.mtO);
            this.mtL.msS.addAnimatorUpdateListener(this.mtM);
            this.mtL.msS.addAnimatorListener(this.mtN);
            this.mtL.msS.setMinAndMaxProgress(0.0f, 1.0f);
            this.mtL.msS.setProgress(0.0f);
            this.mtL.msS.setSpeed(1.4f);
            this.mtL.msS.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void akZ() {
        if (this.mState == 2) {
            this.mtL.wg(false);
            this.mState = 3;
            if (this.mug != null) {
                this.mug.FL(this.mState);
            }
            this.mtL.msS.setVisibility(0);
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.idS.start();
                }
            }, 300L);
            this.mtL.wf(false);
            this.mtL.msS.removeAnimatorListener(this.mtN);
            this.mtL.msS.removeUpdateListener(this.mtM);
            this.mtL.msS.addAnimatorUpdateListener(this.mtO);
            this.mtL.msS.addAnimatorListener(this.mtP);
            this.mtL.msS.setMinAndMaxProgress(0.0f, 1.0f);
            this.mtL.msS.setProgress(1.0f);
            this.mtL.msS.setSpeed(-1.68f);
            this.mtL.msS.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void duh() {
        duf();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.mtL.msS.cancelAnimation();
    }

    private void clearAnimation() {
        this.idR.cancel();
        this.idS.cancel();
        this.mtJ.cancel();
        this.mtK.cancel();
    }

    private void GX(int i) {
        this.mtL.msR.setVisibility(i);
        this.mtL.dpw.setVisibility(i);
        this.mtL.msT.setVerticalGravity(i);
    }
}
