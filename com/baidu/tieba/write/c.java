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
    private ValueAnimator fKH;
    private ValueAnimator fKI;
    private boolean jEl;
    private boolean jEm;
    private boolean jEn;
    private ValueAnimator jEo;
    private ValueAnimator jEp;
    private ValueAnimator jEq;
    private ValueAnimator jEr;
    private ValueAnimator jEs;
    private ValueAnimator jEt;
    private int jEu;
    private int jEv;
    private ValueAnimator.AnimatorUpdateListener jEw;
    private Animator.AnimatorListener jEx;
    private ValueAnimator.AnimatorUpdateListener jEy;
    private Animator.AnimatorListener jEz;

    public c(Context context, e.a aVar) {
        super(context, aVar);
        this.jEl = false;
        this.jEm = false;
        this.jEn = false;
        this.jEw = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (c.this.jEl || animatedFraction < 0.6923f || !c.this.jEH.jFk.isAnimating()) {
                    if (!c.this.jEn && animatedFraction >= 0.38461f && c.this.jEH.jFk.isAnimating()) {
                        c.this.jEn = true;
                        c.this.cwi();
                        return;
                    }
                    return;
                }
                c.this.jEl = true;
                c.this.cwj();
            }
        };
        this.jEx = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.cwk();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.jEy = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!c.this.jEm && animatedFraction >= 0.57142f && c.this.jEH.jFk.isAnimating()) {
                    c.this.jEm = true;
                    c.this.cwl();
                }
            }
        };
        this.jEz = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.16
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.cwm();
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
        this.fKH = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fKH.setDuration(451L);
        this.fKH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.17
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jEH.jES.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jEH.jET.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fKH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.18
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jEH.jES.setAlpha(1.0f);
                c.this.jEH.jET.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fKI = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fKI.setDuration(485L);
        this.fKI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.19
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jEH.jES.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jEH.jET.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (c.this.jEH.jFj.getVisibility() == 0 && c.this.jEH.jFi.getVisibility() == 0) {
                        c.this.jEH.jFj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        c.this.jEH.jFi.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fKI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.20
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jEH.jES.setAlpha(0.0f);
                c.this.jEH.jET.setAlpha(0.0f);
                if (c.this.jEH.jFj.getVisibility() == 0 && c.this.jEH.jFi.getVisibility() == 0) {
                    c.this.jEH.jFj.setAlpha(0.0f);
                    c.this.jEH.jFi.setAlpha(0);
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
        this.jEo = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jEo.setDuration(138L);
        this.jEo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.21
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jEH.jFh.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jEH.jFh.setTranslationY(c.this.jEv - (c.this.jEv * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jEo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jEH.jFh.setAlpha(1.0f);
                c.this.jEH.jFh.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEp = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jEp.setDuration(138L);
        this.jEp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jEH.jFh.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jEH.jFh.setTranslationY(c.this.jEv * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jEp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jEH.jFh.setAlpha(0.0f);
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
        this.jEq.setDuration(104L);
        this.jEq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jEq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.6
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
        this.jEr = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jEr.setDuration(208L);
        this.jEr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jEr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.8
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
        this.jEt = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jEt.setDuration(173L);
        this.jEt.setInterpolator(new DecelerateInterpolator());
        this.jEt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.jEu != 0 && valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c.this.jEH.jFg.setTranslationY(c.this.jEu * (1.0f - floatValue));
                    c.this.jEH.jFg.setRotation(floatValue * 135.0f);
                }
            }
        });
        this.jEt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jEH.jFg.setTranslationY(0.0f);
                c.this.jEH.jFg.setRotation(135.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEs = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jEs.setDuration(277L);
        this.jEs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.jEH.jFg.setTranslationY(c.this.jEu * animatedFraction);
                    c.this.jEH.jFg.setRotation(135.0f - (animatedFraction * 135.0f));
                }
            }
        });
        this.jEs.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.13
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jEH.jFg.setTranslationY(c.this.jEu);
                c.this.jEH.jFg.setRotation(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEv = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.jEH.jEX.setVisibility(0);
        this.jEH.jEU.setVisibility(0);
        this.jEH.jFa.setVisibility(0);
        this.jEH.jFd.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwi() {
        this.jEt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwj() {
        this.jEH.jFh.setVisibility(0);
        this.jEo.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwk() {
        this.jEH.jFk.setVisibility(8);
        this.mState = 2;
        if (this.jEP != null) {
            this.jEP.Cg(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwl() {
        this.jEq.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwm() {
        this.jEl = false;
        this.jEn = false;
        this.jEm = false;
        if (this.bQe != null) {
            this.bQe.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        cwr();
        this.mState = 4;
        if (this.jEP != null) {
            this.jEP.Cg(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cwn() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jEP != null) {
                this.jEP.Cg(this.mState);
            }
            this.jEH.cwy();
            clearAnimation();
            this.jEH.jET.setVisibility(0);
            this.jEH.jES.setVisibility(0);
            this.jEH.jFk.setVisibility(0);
            this.jEH.jFh.setVisibility(8);
            cwo();
            this.fKH.start();
            this.jEr.start();
            this.jEH.jFk.b(this.jEz);
            this.jEH.jFk.removeUpdateListener(this.jEy);
            this.jEH.jFk.a(this.jEw);
            this.jEH.jFk.a(this.jEx);
            this.jEH.jFk.setMinAndMaxProgress(0.0f, 0.48148f);
            this.jEH.jFk.setProgress(0.0f);
            this.jEH.jFk.bo();
        }
    }

    private void cwo() {
        this.jEH.jFg.post(new Runnable() { // from class: com.baidu.tieba.write.c.14
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jFl != null && c.this.jEu == 0) {
                    c.this.jEH.jFg.getGlobalVisibleRect(c.this.jFm);
                    c.this.jEu = (c.this.jFl.centerY() - c.this.jFm.centerY()) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
                }
                c.this.jEH.jFg.setVisibility(0);
                c.this.jEH.jFg.setTranslationY(c.this.jEu);
                if (c.this.bQe != null) {
                    c.this.bQe.setVisibility(4);
                }
            }
        });
    }

    @Override // com.baidu.tieba.write.f
    public void cwp() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jEP != null) {
                this.jEP.Cg(this.mState);
            }
            this.jEH.cwz();
            this.jEH.jFk.setVisibility(0);
            this.jEp.start();
            this.fKI.start();
            this.jEs.start();
            this.jEH.jFk.b(this.jEx);
            this.jEH.jFk.removeUpdateListener(this.jEw);
            this.jEH.jFk.a(this.jEy);
            this.jEH.jFk.a(this.jEz);
            this.jEH.jFk.setMinAndMaxProgress(0.48148f, 1.0f);
            this.jEH.jFk.setProgress(0.0f);
            this.jEH.jFk.bo();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cwq() {
        cwm();
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
        this.jEH.jFk.cancelAnimation();
    }

    private void clearAnimation() {
        this.fKH.cancel();
        this.fKI.cancel();
        this.jEo.cancel();
        this.jEp.cancel();
        this.jEq.cancel();
        this.jEr.cancel();
        this.jEt.cancel();
        this.jEs.cancel();
    }

    private void cwr() {
        this.jEH.jFk.setVisibility(8);
        this.jEH.jFg.setVisibility(4);
        this.jEH.jET.setVisibility(8);
        this.jEH.jES.setVisibility(8);
        this.jEH.jFh.setVisibility(8);
    }
}
