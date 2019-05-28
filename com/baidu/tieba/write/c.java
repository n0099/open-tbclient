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
    private ValueAnimator fKF;
    private ValueAnimator fKG;
    private boolean jEi;
    private boolean jEj;
    private boolean jEk;
    private ValueAnimator jEl;
    private ValueAnimator jEm;
    private ValueAnimator jEn;
    private ValueAnimator jEo;
    private ValueAnimator jEp;
    private ValueAnimator jEq;
    private int jEr;
    private int jEs;
    private ValueAnimator.AnimatorUpdateListener jEt;
    private Animator.AnimatorListener jEu;
    private ValueAnimator.AnimatorUpdateListener jEv;
    private Animator.AnimatorListener jEw;

    public c(Context context, e.a aVar) {
        super(context, aVar);
        this.jEi = false;
        this.jEj = false;
        this.jEk = false;
        this.jEt = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (c.this.jEi || animatedFraction < 0.6923f || !c.this.jEE.jFh.isAnimating()) {
                    if (!c.this.jEk && animatedFraction >= 0.38461f && c.this.jEE.jFh.isAnimating()) {
                        c.this.jEk = true;
                        c.this.cwj();
                        return;
                    }
                    return;
                }
                c.this.jEi = true;
                c.this.cwk();
            }
        };
        this.jEu = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.12
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
        this.jEv = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!c.this.jEj && animatedFraction >= 0.57142f && c.this.jEE.jFh.isAnimating()) {
                    c.this.jEj = true;
                    c.this.cwm();
                }
            }
        };
        this.jEw = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.16
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.cwn();
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
        this.fKF = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fKF.setDuration(451L);
        this.fKF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.17
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jEE.jEP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jEE.jEQ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fKF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.18
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jEE.jEP.setAlpha(1.0f);
                c.this.jEE.jEQ.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fKG = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fKG.setDuration(485L);
        this.fKG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.19
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jEE.jEP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jEE.jEQ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (c.this.jEE.jFg.getVisibility() == 0 && c.this.jEE.jFf.getVisibility() == 0) {
                        c.this.jEE.jFg.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        c.this.jEE.jFf.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fKG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.20
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jEE.jEP.setAlpha(0.0f);
                c.this.jEE.jEQ.setAlpha(0.0f);
                if (c.this.jEE.jFg.getVisibility() == 0 && c.this.jEE.jFf.getVisibility() == 0) {
                    c.this.jEE.jFg.setAlpha(0.0f);
                    c.this.jEE.jFf.setAlpha(0);
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
        this.jEl = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jEl.setDuration(138L);
        this.jEl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.21
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jEE.jFe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jEE.jFe.setTranslationY(c.this.jEs - (c.this.jEs * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jEl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jEE.jFe.setAlpha(1.0f);
                c.this.jEE.jFe.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEm = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jEm.setDuration(138L);
        this.jEm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jEE.jFe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jEE.jFe.setTranslationY(c.this.jEs * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jEm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jEE.jFe.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEn = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jEn.setDuration(104L);
        this.jEn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jEn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.6
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
        this.jEo = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jEo.setDuration(208L);
        this.jEo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jEo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.8
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
        this.jEq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jEq.setDuration(173L);
        this.jEq.setInterpolator(new DecelerateInterpolator());
        this.jEq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.jEr != 0 && valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c.this.jEE.jFd.setTranslationY(c.this.jEr * (1.0f - floatValue));
                    c.this.jEE.jFd.setRotation(floatValue * 135.0f);
                }
            }
        });
        this.jEq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jEE.jFd.setTranslationY(0.0f);
                c.this.jEE.jFd.setRotation(135.0f);
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
        this.jEp.setDuration(277L);
        this.jEp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.jEE.jFd.setTranslationY(c.this.jEr * animatedFraction);
                    c.this.jEE.jFd.setRotation(135.0f - (animatedFraction * 135.0f));
                }
            }
        });
        this.jEp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.13
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jEE.jFd.setTranslationY(c.this.jEr);
                c.this.jEE.jFd.setRotation(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEs = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.jEE.jEU.setVisibility(0);
        this.jEE.jER.setVisibility(0);
        this.jEE.jEX.setVisibility(0);
        this.jEE.jFa.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwj() {
        this.jEq.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwk() {
        this.jEE.jFe.setVisibility(0);
        this.jEl.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwl() {
        this.jEE.jFh.setVisibility(8);
        this.mState = 2;
        if (this.jEM != null) {
            this.jEM.Cg(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwm() {
        this.jEn.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwn() {
        this.jEi = false;
        this.jEk = false;
        this.jEj = false;
        if (this.bQd != null) {
            this.bQd.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        cws();
        this.mState = 4;
        if (this.jEM != null) {
            this.jEM.Cg(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cwo() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jEM != null) {
                this.jEM.Cg(this.mState);
            }
            this.jEE.cwz();
            clearAnimation();
            this.jEE.jEQ.setVisibility(0);
            this.jEE.jEP.setVisibility(0);
            this.jEE.jFh.setVisibility(0);
            this.jEE.jFe.setVisibility(8);
            cwp();
            this.fKF.start();
            this.jEo.start();
            this.jEE.jFh.b(this.jEw);
            this.jEE.jFh.removeUpdateListener(this.jEv);
            this.jEE.jFh.a(this.jEt);
            this.jEE.jFh.a(this.jEu);
            this.jEE.jFh.setMinAndMaxProgress(0.0f, 0.48148f);
            this.jEE.jFh.setProgress(0.0f);
            this.jEE.jFh.bo();
        }
    }

    private void cwp() {
        this.jEE.jFd.post(new Runnable() { // from class: com.baidu.tieba.write.c.14
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jFi != null && c.this.jEr == 0) {
                    c.this.jEE.jFd.getGlobalVisibleRect(c.this.jFj);
                    c.this.jEr = (c.this.jFi.centerY() - c.this.jFj.centerY()) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
                }
                c.this.jEE.jFd.setVisibility(0);
                c.this.jEE.jFd.setTranslationY(c.this.jEr);
                if (c.this.bQd != null) {
                    c.this.bQd.setVisibility(4);
                }
            }
        });
    }

    @Override // com.baidu.tieba.write.f
    public void cwq() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jEM != null) {
                this.jEM.Cg(this.mState);
            }
            this.jEE.cwA();
            this.jEE.jFh.setVisibility(0);
            this.jEm.start();
            this.fKG.start();
            this.jEp.start();
            this.jEE.jFh.b(this.jEu);
            this.jEE.jFh.removeUpdateListener(this.jEt);
            this.jEE.jFh.a(this.jEv);
            this.jEE.jFh.a(this.jEw);
            this.jEE.jFh.setMinAndMaxProgress(0.48148f, 1.0f);
            this.jEE.jFh.setProgress(0.0f);
            this.jEE.jFh.bo();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cwr() {
        cwn();
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
        this.jEE.jFh.cancelAnimation();
    }

    private void clearAnimation() {
        this.fKF.cancel();
        this.fKG.cancel();
        this.jEl.cancel();
        this.jEm.cancel();
        this.jEn.cancel();
        this.jEo.cancel();
        this.jEq.cancel();
        this.jEp.cancel();
    }

    private void cws() {
        this.jEE.jFh.setVisibility(8);
        this.jEE.jFd.setVisibility(4);
        this.jEE.jEQ.setVisibility(8);
        this.jEE.jEP.setVisibility(8);
        this.jEE.jFe.setVisibility(8);
    }
}
