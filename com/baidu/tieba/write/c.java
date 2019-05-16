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
    private ValueAnimator fKE;
    private ValueAnimator fKF;
    private boolean jEh;
    private boolean jEi;
    private boolean jEj;
    private ValueAnimator jEk;
    private ValueAnimator jEl;
    private ValueAnimator jEm;
    private ValueAnimator jEn;
    private ValueAnimator jEo;
    private ValueAnimator jEp;
    private int jEq;
    private int jEr;
    private ValueAnimator.AnimatorUpdateListener jEs;
    private Animator.AnimatorListener jEt;
    private ValueAnimator.AnimatorUpdateListener jEu;
    private Animator.AnimatorListener jEv;

    public c(Context context, e.a aVar) {
        super(context, aVar);
        this.jEh = false;
        this.jEi = false;
        this.jEj = false;
        this.jEs = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (c.this.jEh || animatedFraction < 0.6923f || !c.this.jED.jFg.isAnimating()) {
                    if (!c.this.jEj && animatedFraction >= 0.38461f && c.this.jED.jFg.isAnimating()) {
                        c.this.jEj = true;
                        c.this.cwh();
                        return;
                    }
                    return;
                }
                c.this.jEh = true;
                c.this.cwi();
            }
        };
        this.jEt = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.cwj();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.jEu = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!c.this.jEi && animatedFraction >= 0.57142f && c.this.jED.jFg.isAnimating()) {
                    c.this.jEi = true;
                    c.this.cwk();
                }
            }
        };
        this.jEv = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.16
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.cwl();
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
        this.fKE = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fKE.setDuration(451L);
        this.fKE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.17
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jED.jEO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jED.jEP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fKE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.18
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jED.jEO.setAlpha(1.0f);
                c.this.jED.jEP.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fKF = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fKF.setDuration(485L);
        this.fKF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.19
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jED.jEO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jED.jEP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (c.this.jED.jFf.getVisibility() == 0 && c.this.jED.jFe.getVisibility() == 0) {
                        c.this.jED.jFf.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        c.this.jED.jFe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fKF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.20
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jED.jEO.setAlpha(0.0f);
                c.this.jED.jEP.setAlpha(0.0f);
                if (c.this.jED.jFf.getVisibility() == 0 && c.this.jED.jFe.getVisibility() == 0) {
                    c.this.jED.jFf.setAlpha(0.0f);
                    c.this.jED.jFe.setAlpha(0);
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
        this.jEk = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jEk.setDuration(138L);
        this.jEk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.21
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jED.jFd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jED.jFd.setTranslationY(c.this.jEr - (c.this.jEr * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jEk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jED.jFd.setAlpha(1.0f);
                c.this.jED.jFd.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEl = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jEl.setDuration(138L);
        this.jEl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jED.jFd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jED.jFd.setTranslationY(c.this.jEr * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jEl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jED.jFd.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEm = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jEm.setDuration(104L);
        this.jEm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jEm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.6
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
        this.jEn = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jEn.setDuration(208L);
        this.jEn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jEn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.8
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
        this.jEp = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jEp.setDuration(173L);
        this.jEp.setInterpolator(new DecelerateInterpolator());
        this.jEp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.jEq != 0 && valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c.this.jED.jFc.setTranslationY(c.this.jEq * (1.0f - floatValue));
                    c.this.jED.jFc.setRotation(floatValue * 135.0f);
                }
            }
        });
        this.jEp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jED.jFc.setTranslationY(0.0f);
                c.this.jED.jFc.setRotation(135.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEo = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jEo.setDuration(277L);
        this.jEo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.jED.jFc.setTranslationY(c.this.jEq * animatedFraction);
                    c.this.jED.jFc.setRotation(135.0f - (animatedFraction * 135.0f));
                }
            }
        });
        this.jEo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.13
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jED.jFc.setTranslationY(c.this.jEq);
                c.this.jED.jFc.setRotation(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEr = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.jED.jET.setVisibility(0);
        this.jED.jEQ.setVisibility(0);
        this.jED.jEW.setVisibility(0);
        this.jED.jEZ.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwh() {
        this.jEp.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwi() {
        this.jED.jFd.setVisibility(0);
        this.jEk.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwj() {
        this.jED.jFg.setVisibility(8);
        this.mState = 2;
        if (this.jEL != null) {
            this.jEL.Cg(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwk() {
        this.jEm.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwl() {
        this.jEh = false;
        this.jEj = false;
        this.jEi = false;
        if (this.bQd != null) {
            this.bQd.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        cwq();
        this.mState = 4;
        if (this.jEL != null) {
            this.jEL.Cg(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cwm() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jEL != null) {
                this.jEL.Cg(this.mState);
            }
            this.jED.cwx();
            clearAnimation();
            this.jED.jEP.setVisibility(0);
            this.jED.jEO.setVisibility(0);
            this.jED.jFg.setVisibility(0);
            this.jED.jFd.setVisibility(8);
            cwn();
            this.fKE.start();
            this.jEn.start();
            this.jED.jFg.b(this.jEv);
            this.jED.jFg.removeUpdateListener(this.jEu);
            this.jED.jFg.a(this.jEs);
            this.jED.jFg.a(this.jEt);
            this.jED.jFg.setMinAndMaxProgress(0.0f, 0.48148f);
            this.jED.jFg.setProgress(0.0f);
            this.jED.jFg.bo();
        }
    }

    private void cwn() {
        this.jED.jFc.post(new Runnable() { // from class: com.baidu.tieba.write.c.14
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jFh != null && c.this.jEq == 0) {
                    c.this.jED.jFc.getGlobalVisibleRect(c.this.jFi);
                    c.this.jEq = (c.this.jFh.centerY() - c.this.jFi.centerY()) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
                }
                c.this.jED.jFc.setVisibility(0);
                c.this.jED.jFc.setTranslationY(c.this.jEq);
                if (c.this.bQd != null) {
                    c.this.bQd.setVisibility(4);
                }
            }
        });
    }

    @Override // com.baidu.tieba.write.f
    public void cwo() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jEL != null) {
                this.jEL.Cg(this.mState);
            }
            this.jED.cwy();
            this.jED.jFg.setVisibility(0);
            this.jEl.start();
            this.fKF.start();
            this.jEo.start();
            this.jED.jFg.b(this.jEt);
            this.jED.jFg.removeUpdateListener(this.jEs);
            this.jED.jFg.a(this.jEu);
            this.jED.jFg.a(this.jEv);
            this.jED.jFg.setMinAndMaxProgress(0.48148f, 1.0f);
            this.jED.jFg.setProgress(0.0f);
            this.jED.jFg.bo();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cwp() {
        cwl();
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
        this.jED.jFg.cancelAnimation();
    }

    private void clearAnimation() {
        this.fKE.cancel();
        this.fKF.cancel();
        this.jEk.cancel();
        this.jEl.cancel();
        this.jEm.cancel();
        this.jEn.cancel();
        this.jEp.cancel();
        this.jEo.cancel();
    }

    private void cwq() {
        this.jED.jFg.setVisibility(8);
        this.jED.jFc.setVisibility(4);
        this.jED.jEP.setVisibility(8);
        this.jED.jEO.setVisibility(8);
        this.jED.jFd.setVisibility(8);
    }
}
