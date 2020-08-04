package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator idT;
    private ValueAnimator idU;
    private boolean mtI;
    private boolean mtJ;
    private boolean mtK;
    private ValueAnimator mtL;
    private ValueAnimator mtM;
    private a.b mtN;
    private ValueAnimator.AnimatorUpdateListener mtO;
    private Animator.AnimatorListener mtP;
    private ValueAnimator.AnimatorUpdateListener mtQ;
    private Animator.AnimatorListener mtR;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.mtI = false;
        this.mtJ = false;
        this.mtK = false;
        this.mtO = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.mtI || animatedFraction < 0.6923f || !d.this.mtN.msU.isAnimating()) {
                    if (!d.this.mtK && animatedFraction >= 0.38461f && d.this.mtN.msU.isAnimating()) {
                        d.this.mtK = true;
                        return;
                    }
                    return;
                }
                d.this.mtI = true;
            }
        };
        this.mtP = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.due();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.mtQ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.mtJ && animatedFraction >= 0.57142f && d.this.mtN.msU.isAnimating()) {
                    d.this.mtJ = true;
                    d.this.duf();
                }
            }
        };
        this.mtR = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dug();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.mtN = bVar;
        init();
    }

    private void init() {
        this.idT = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.idT.setDuration(451L);
        this.idT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.mtN.dpw.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.idT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.mtN.dpw.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.idU = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.idU.setDuration(485L);
        this.idU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.mtN.dpw.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.idU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.mtN.dpw.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mtL = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mtL.setDuration(104L);
        this.mtL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.mtL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.mtM = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mtM.setDuration(208L);
        this.mtM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.mtM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void due() {
        this.mtN.msU.setVisibility(0);
        this.mtN.wf(true);
        this.mState = 2;
        if (this.mui != null) {
            this.mui.FL(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duf() {
        this.mtL.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dug() {
        this.mtI = false;
        this.mtK = false;
        this.mtJ = false;
        this.mtN.wf(false);
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
        if (this.mui != null) {
            this.mui.FL(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void duh() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.mui != null) {
                this.mui.FL(this.mState);
            }
            clearAnimation();
            GX(0);
            this.mtN.msU.setVisibility(0);
            this.idT.start();
            this.mtM.start();
            this.mtN.msU.removeAnimatorListener(this.mtR);
            this.mtN.msU.removeUpdateListener(this.mtQ);
            this.mtN.msU.addAnimatorUpdateListener(this.mtO);
            this.mtN.msU.addAnimatorListener(this.mtP);
            this.mtN.msU.setMinAndMaxProgress(0.0f, 1.0f);
            this.mtN.msU.setProgress(0.0f);
            this.mtN.msU.setSpeed(1.4f);
            this.mtN.msU.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void akZ() {
        if (this.mState == 2) {
            this.mtN.wg(false);
            this.mState = 3;
            if (this.mui != null) {
                this.mui.FL(this.mState);
            }
            this.mtN.msU.setVisibility(0);
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.idU.start();
                }
            }, 300L);
            this.mtN.wf(false);
            this.mtN.msU.removeAnimatorListener(this.mtP);
            this.mtN.msU.removeUpdateListener(this.mtO);
            this.mtN.msU.addAnimatorUpdateListener(this.mtQ);
            this.mtN.msU.addAnimatorListener(this.mtR);
            this.mtN.msU.setMinAndMaxProgress(0.0f, 1.0f);
            this.mtN.msU.setProgress(1.0f);
            this.mtN.msU.setSpeed(-1.68f);
            this.mtN.msU.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dui() {
        dug();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.mtN.msU.cancelAnimation();
    }

    private void clearAnimation() {
        this.idT.cancel();
        this.idU.cancel();
        this.mtL.cancel();
        this.mtM.cancel();
    }

    private void GX(int i) {
        this.mtN.msT.setVisibility(i);
        this.mtN.dpw.setVisibility(i);
        this.mtN.msV.setVerticalGravity(i);
    }
}
