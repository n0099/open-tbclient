package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public class c extends f {
    private ValueAnimator fQM;
    private ValueAnimator fQN;
    private boolean jMe;
    private boolean jMf;
    private boolean jMg;
    private ValueAnimator jMh;
    private ValueAnimator jMi;
    private ValueAnimator jMj;
    private ValueAnimator jMk;
    private ValueAnimator jMl;
    private ValueAnimator jMm;
    private int jMn;
    private int jMo;
    private ValueAnimator.AnimatorUpdateListener jMp;
    private Animator.AnimatorListener jMq;
    private ValueAnimator.AnimatorUpdateListener jMr;
    private Animator.AnimatorListener jMs;

    public c(Context context, e.a aVar) {
        super(context, aVar);
        this.jMe = false;
        this.jMf = false;
        this.jMg = false;
        this.jMp = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (c.this.jMe || animatedFraction < 0.6923f || !c.this.jMA.jNf.isAnimating()) {
                    if (!c.this.jMg && animatedFraction >= 0.38461f && c.this.jMA.jNf.isAnimating()) {
                        c.this.jMg = true;
                        c.this.cxB();
                        return;
                    }
                    return;
                }
                c.this.jMe = true;
                c.this.cxC();
            }
        };
        this.jMq = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.cxD();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.jMr = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!c.this.jMf && animatedFraction >= 0.57142f && c.this.jMA.jNf.isAnimating()) {
                    c.this.jMf = true;
                    c.this.cxE();
                }
            }
        };
        this.jMs = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.16
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.cxF();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        init();
    }

    private void init() {
        this.fQM = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fQM.setDuration(451L);
        this.fQM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.17
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jMA.jMN.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jMA.jMO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fQM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.18
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jMA.jMN.setAlpha(1.0f);
                c.this.jMA.jMO.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fQN = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fQN.setDuration(485L);
        this.fQN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.19
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jMA.jMN.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jMA.jMO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (c.this.jMA.jNe.getVisibility() == 0 && c.this.jMA.jNd.getVisibility() == 0) {
                        c.this.jMA.jNe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        c.this.jMA.jNd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fQN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.20
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jMA.jMN.setAlpha(0.0f);
                c.this.jMA.jMO.setAlpha(0.0f);
                if (c.this.jMA.jNe.getVisibility() == 0 && c.this.jMA.jNd.getVisibility() == 0) {
                    c.this.jMA.jNe.setAlpha(0.0f);
                    c.this.jMA.jNd.setAlpha(0);
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
        this.jMh = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jMh.setDuration(138L);
        this.jMh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.21
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jMA.jNc.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jMA.jNc.setTranslationY(c.this.jMo - (c.this.jMo * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jMh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jMA.jNc.setAlpha(1.0f);
                c.this.jMA.jNc.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jMi = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jMi.setDuration(138L);
        this.jMi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jMA.jNc.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jMA.jNc.setTranslationY(c.this.jMo * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jMi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jMA.jNc.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jMj = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jMj.setDuration(104L);
        this.jMj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jMj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(1.0f);
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
        this.jMk = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jMk.setDuration(208L);
        this.jMk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jMk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(0.0f);
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
        this.jMm = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jMm.setDuration(173L);
        this.jMm.setInterpolator(new DecelerateInterpolator());
        this.jMm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.jMn != 0 && valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c.this.jMA.jNb.setTranslationY(c.this.jMn * (1.0f - floatValue));
                    c.this.jMA.jNb.setRotation(floatValue * 135.0f);
                }
            }
        });
        this.jMm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jMA.jNb.setTranslationY(0.0f);
                c.this.jMA.jNb.setRotation(135.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jMl = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jMl.setDuration(277L);
        this.jMl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.jMA.jNb.setTranslationY(c.this.jMn * animatedFraction);
                    c.this.jMA.jNb.setRotation(135.0f - (animatedFraction * 135.0f));
                }
            }
        });
        this.jMl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.13
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jMA.jNb.setTranslationY(c.this.jMn);
                c.this.jMA.jNb.setRotation(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jMo = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.jMA.jMS.setVisibility(0);
        this.jMA.jMP.setVisibility(0);
        this.jMA.jMV.setVisibility(0);
        this.jMA.jMY.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxB() {
        this.jMm.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxC() {
        this.jMA.jNc.setVisibility(0);
        this.jMh.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxD() {
        this.jMA.jNf.setVisibility(8);
        this.mState = 2;
        if (this.jMI != null) {
            this.jMI.Bw(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxE() {
        this.jMj.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxF() {
        this.jMe = false;
        this.jMg = false;
        this.jMf = false;
        if (this.chz != null) {
            this.chz.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        cxK();
        this.mState = 4;
        if (this.jMI != null) {
            this.jMI.Bw(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cxG() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jMI != null) {
                this.jMI.Bw(this.mState);
            }
            this.jMA.cxR();
            clearAnimation();
            this.jMA.jMO.setVisibility(0);
            this.jMA.jMN.setVisibility(0);
            this.jMA.jNf.setVisibility(0);
            this.jMA.jNc.setVisibility(8);
            cxH();
            this.fQM.start();
            this.jMk.start();
            this.jMA.jNf.removeAnimatorListener(this.jMs);
            this.jMA.jNf.removeUpdateListener(this.jMr);
            this.jMA.jNf.addAnimatorUpdateListener(this.jMp);
            this.jMA.jNf.addAnimatorListener(this.jMq);
            this.jMA.jNf.setMinAndMaxProgress(0.0f, 0.48148f);
            this.jMA.jNf.setProgress(0.0f);
            this.jMA.jNf.playAnimation();
        }
    }

    private void cxH() {
        this.jMA.jNb.post(new Runnable() { // from class: com.baidu.tieba.write.c.14
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jNg != null && c.this.jMn == 0) {
                    c.this.jMA.jNb.getGlobalVisibleRect(c.this.jNh);
                    c.this.jMn = (c.this.jNg.centerY() - c.this.jNh.centerY()) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
                }
                c.this.jMA.jNb.setVisibility(0);
                c.this.jMA.jNb.setTranslationY(c.this.jMn);
                if (c.this.chz != null) {
                    c.this.chz.setVisibility(4);
                }
            }
        });
    }

    @Override // com.baidu.tieba.write.f
    public void cxI() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jMI != null) {
                this.jMI.Bw(this.mState);
            }
            this.jMA.cxS();
            this.jMA.jNf.setVisibility(0);
            this.jMi.start();
            this.fQN.start();
            this.jMl.start();
            this.jMA.jNf.removeAnimatorListener(this.jMq);
            this.jMA.jNf.removeUpdateListener(this.jMp);
            this.jMA.jNf.addAnimatorUpdateListener(this.jMr);
            this.jMA.jNf.addAnimatorListener(this.jMs);
            this.jMA.jNf.setMinAndMaxProgress(0.48148f, 1.0f);
            this.jMA.jNf.setProgress(0.0f);
            this.jMA.jNf.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cxJ() {
        cxF();
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
        this.jMA.jNf.cancelAnimation();
    }

    private void clearAnimation() {
        this.fQM.cancel();
        this.fQN.cancel();
        this.jMh.cancel();
        this.jMi.cancel();
        this.jMj.cancel();
        this.jMk.cancel();
        this.jMm.cancel();
        this.jMl.cancel();
    }

    private void cxK() {
        this.jMA.jNf.setVisibility(8);
        this.jMA.jNb.setVisibility(4);
        this.jMA.jMO.setVisibility(8);
        this.jMA.jMN.setVisibility(8);
        this.jMA.jNc.setVisibility(8);
    }
}
