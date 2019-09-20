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
    private ValueAnimator fSk;
    private ValueAnimator fSl;
    private boolean jOP;
    private boolean jOQ;
    private boolean jOR;
    private ValueAnimator jOS;
    private ValueAnimator jOT;
    private ValueAnimator jOU;
    private ValueAnimator jOV;
    private ValueAnimator jOW;
    private ValueAnimator jOX;
    private int jOY;
    private int jOZ;
    private ValueAnimator.AnimatorUpdateListener jPa;
    private Animator.AnimatorListener jPb;
    private ValueAnimator.AnimatorUpdateListener jPc;
    private Animator.AnimatorListener jPd;

    public c(Context context, e.a aVar) {
        super(context, aVar);
        this.jOP = false;
        this.jOQ = false;
        this.jOR = false;
        this.jPa = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (c.this.jOP || animatedFraction < 0.6923f || !c.this.jPl.jPQ.isAnimating()) {
                    if (!c.this.jOR && animatedFraction >= 0.38461f && c.this.jPl.jPQ.isAnimating()) {
                        c.this.jOR = true;
                        c.this.cAs();
                        return;
                    }
                    return;
                }
                c.this.jOP = true;
                c.this.cAt();
            }
        };
        this.jPb = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.cAu();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.jPc = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!c.this.jOQ && animatedFraction >= 0.57142f && c.this.jPl.jPQ.isAnimating()) {
                    c.this.jOQ = true;
                    c.this.cAv();
                }
            }
        };
        this.jPd = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.16
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.cAw();
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
        this.fSk = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fSk.setDuration(451L);
        this.fSk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.17
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jPl.jPy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jPl.jPz.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fSk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.18
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jPl.jPy.setAlpha(1.0f);
                c.this.jPl.jPz.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fSl = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fSl.setDuration(485L);
        this.fSl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.19
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jPl.jPy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jPl.jPz.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (c.this.jPl.jPP.getVisibility() == 0 && c.this.jPl.jPO.getVisibility() == 0) {
                        c.this.jPl.jPP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        c.this.jPl.jPO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fSl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.20
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jPl.jPy.setAlpha(0.0f);
                c.this.jPl.jPz.setAlpha(0.0f);
                if (c.this.jPl.jPP.getVisibility() == 0 && c.this.jPl.jPO.getVisibility() == 0) {
                    c.this.jPl.jPP.setAlpha(0.0f);
                    c.this.jPl.jPO.setAlpha(0);
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
        this.jOS = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jOS.setDuration(138L);
        this.jOS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.21
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jPl.jPN.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jPl.jPN.setTranslationY(c.this.jOZ - (c.this.jOZ * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jOS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jPl.jPN.setAlpha(1.0f);
                c.this.jPl.jPN.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jOT = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jOT.setDuration(138L);
        this.jOT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jPl.jPN.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jPl.jPN.setTranslationY(c.this.jOZ * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jOT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jPl.jPN.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jOU = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jOU.setDuration(104L);
        this.jOU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jOU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.6
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
        this.jOV = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jOV.setDuration(208L);
        this.jOV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jOV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.8
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
        this.jOX = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jOX.setDuration(173L);
        this.jOX.setInterpolator(new DecelerateInterpolator());
        this.jOX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.jOY != 0 && valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c.this.jPl.jPM.setTranslationY(c.this.jOY * (1.0f - floatValue));
                    c.this.jPl.jPM.setRotation(floatValue * 135.0f);
                }
            }
        });
        this.jOX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jPl.jPM.setTranslationY(0.0f);
                c.this.jPl.jPM.setRotation(135.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jOW = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jOW.setDuration(277L);
        this.jOW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.jPl.jPM.setTranslationY(c.this.jOY * animatedFraction);
                    c.this.jPl.jPM.setRotation(135.0f - (animatedFraction * 135.0f));
                }
            }
        });
        this.jOW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.13
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jPl.jPM.setTranslationY(c.this.jOY);
                c.this.jPl.jPM.setRotation(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jOZ = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.jPl.jPD.setVisibility(0);
        this.jPl.jPA.setVisibility(0);
        this.jPl.jPG.setVisibility(0);
        this.jPl.jPJ.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAs() {
        this.jOX.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAt() {
        this.jPl.jPN.setVisibility(0);
        this.jOS.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAu() {
        this.jPl.jPQ.setVisibility(8);
        this.mState = 2;
        if (this.jPt != null) {
            this.jPt.CT(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAv() {
        this.jOU.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAw() {
        this.jOP = false;
        this.jOR = false;
        this.jOQ = false;
        if (this.bRL != null) {
            this.bRL.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        cAB();
        this.mState = 4;
        if (this.jPt != null) {
            this.jPt.CT(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cAx() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jPt != null) {
                this.jPt.CT(this.mState);
            }
            this.jPl.cAI();
            clearAnimation();
            this.jPl.jPz.setVisibility(0);
            this.jPl.jPy.setVisibility(0);
            this.jPl.jPQ.setVisibility(0);
            this.jPl.jPN.setVisibility(8);
            cAy();
            this.fSk.start();
            this.jOV.start();
            this.jPl.jPQ.b(this.jPd);
            this.jPl.jPQ.b(this.jPc);
            this.jPl.jPQ.a(this.jPa);
            this.jPl.jPQ.a(this.jPb);
            this.jPl.jPQ.setMinAndMaxProgress(0.0f, 0.48148f);
            this.jPl.jPQ.setProgress(0.0f);
            this.jPl.jPQ.br();
        }
    }

    private void cAy() {
        this.jPl.jPM.post(new Runnable() { // from class: com.baidu.tieba.write.c.14
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jPR != null && c.this.jOY == 0) {
                    c.this.jPl.jPM.getGlobalVisibleRect(c.this.jPS);
                    c.this.jOY = (c.this.jPR.centerY() - c.this.jPS.centerY()) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
                }
                c.this.jPl.jPM.setVisibility(0);
                c.this.jPl.jPM.setTranslationY(c.this.jOY);
                if (c.this.bRL != null) {
                    c.this.bRL.setVisibility(4);
                }
            }
        });
    }

    @Override // com.baidu.tieba.write.f
    public void cAz() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jPt != null) {
                this.jPt.CT(this.mState);
            }
            this.jPl.cAJ();
            this.jPl.jPQ.setVisibility(0);
            this.jOT.start();
            this.fSl.start();
            this.jOW.start();
            this.jPl.jPQ.b(this.jPb);
            this.jPl.jPQ.b(this.jPa);
            this.jPl.jPQ.a(this.jPc);
            this.jPl.jPQ.a(this.jPd);
            this.jPl.jPQ.setMinAndMaxProgress(0.48148f, 1.0f);
            this.jPl.jPQ.setProgress(0.0f);
            this.jPl.jPQ.br();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cAA() {
        cAw();
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
        this.jPl.jPQ.cancelAnimation();
    }

    private void clearAnimation() {
        this.fSk.cancel();
        this.fSl.cancel();
        this.jOS.cancel();
        this.jOT.cancel();
        this.jOU.cancel();
        this.jOV.cancel();
        this.jOX.cancel();
        this.jOW.cancel();
    }

    private void cAB() {
        this.jPl.jPQ.setVisibility(8);
        this.jPl.jPM.setVisibility(4);
        this.jPl.jPz.setVisibility(8);
        this.jPl.jPy.setVisibility(8);
        this.jPl.jPN.setVisibility(8);
    }
}
