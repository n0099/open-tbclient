package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public class c extends f {
    private ValueAnimator fud;
    private ValueAnimator fue;
    private ValueAnimator jlA;
    private ValueAnimator jlB;
    private ValueAnimator jlC;
    private ValueAnimator jlD;
    private ValueAnimator jlE;
    private int jlF;
    private int jlG;
    private ValueAnimator.AnimatorUpdateListener jlH;
    private Animator.AnimatorListener jlI;
    private ValueAnimator.AnimatorUpdateListener jlJ;
    private Animator.AnimatorListener jlK;
    private boolean jlw;
    private boolean jlx;
    private boolean jly;
    private ValueAnimator jlz;

    public c(Context context, e.a aVar) {
        super(context, aVar);
        this.jlw = false;
        this.jlx = false;
        this.jly = false;
        this.jlH = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (c.this.jlw || animatedFraction < 0.6923f || !c.this.jlS.jmw.isAnimating()) {
                    if (!c.this.jly && animatedFraction >= 0.38461f && c.this.jlS.jmw.isAnimating()) {
                        c.this.jly = true;
                        c.this.coa();
                        return;
                    }
                    return;
                }
                c.this.jlw = true;
                c.this.cob();
            }
        };
        this.jlI = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.coc();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.jlJ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!c.this.jlx && animatedFraction >= 0.57142f && c.this.jlS.jmw.isAnimating()) {
                    c.this.jlx = true;
                    c.this.cod();
                }
            }
        };
        this.jlK = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.16
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.coe();
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
        this.fud = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fud.setDuration(451L);
        this.fud.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.17
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jlS.jmd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jlS.jme.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fud.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.18
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jlS.jmd.setAlpha(1.0f);
                c.this.jlS.jme.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fue = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fue.setDuration(485L);
        this.fue.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.19
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jlS.jmd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jlS.jme.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (c.this.jlS.jmv.getVisibility() == 0 && c.this.jlS.jmu.getVisibility() == 0) {
                        c.this.jlS.jmv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        c.this.jlS.jmu.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fue.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.20
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jlS.jmd.setAlpha(0.0f);
                c.this.jlS.jme.setAlpha(0.0f);
                if (c.this.jlS.jmv.getVisibility() == 0 && c.this.jlS.jmu.getVisibility() == 0) {
                    c.this.jlS.jmv.setAlpha(0.0f);
                    c.this.jlS.jmu.setAlpha(0);
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
        this.jlz = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlz.setDuration(138L);
        this.jlz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.21
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jlS.jmt.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jlS.jmt.setTranslationY(c.this.jlG - (c.this.jlG * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jlz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jlS.jmt.setAlpha(1.0f);
                c.this.jlS.jmt.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlA = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jlA.setDuration(138L);
        this.jlA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jlS.jmt.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jlS.jmt.setTranslationY(c.this.jlG * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jlA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jlS.jmt.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlB = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlB.setDuration(104L);
        this.jlB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jlB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.6
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
        this.jlC = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jlC.setDuration(208L);
        this.jlC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jlC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.8
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
        this.jlE = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlE.setDuration(173L);
        this.jlE.setInterpolator(new DecelerateInterpolator());
        this.jlE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.jlF != 0 && valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c.this.jlS.jms.setTranslationY(c.this.jlF * (1.0f - floatValue));
                    c.this.jlS.jms.setRotation(floatValue * 135.0f);
                }
            }
        });
        this.jlE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jlS.jms.setTranslationY(0.0f);
                c.this.jlS.jms.setRotation(135.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlD.setDuration(277L);
        this.jlD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.jlS.jms.setTranslationY(c.this.jlF * animatedFraction);
                    c.this.jlS.jms.setRotation(135.0f - (animatedFraction * 135.0f));
                }
            }
        });
        this.jlD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.13
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jlS.jms.setTranslationY(c.this.jlF);
                c.this.jlS.jms.setRotation(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlG = l.h(TbadkCoreApplication.getInst(), d.e.tbds40);
        this.jlS.jmi.setVisibility(0);
        this.jlS.jmf.setVisibility(0);
        this.jlS.jml.setVisibility(0);
        this.jlS.jmo.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coa() {
        this.jlE.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cob() {
        this.jlS.jmt.setVisibility(0);
        this.jlz.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coc() {
        this.jlS.jmw.setVisibility(8);
        this.mState = 2;
        if (this.jma != null) {
            this.jma.Bb(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cod() {
        this.jlB.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coe() {
        this.jlw = false;
        this.jly = false;
        this.jlx = false;
        if (this.bIp != null) {
            this.bIp.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        coj();
        this.mState = 4;
        if (this.jma != null) {
            this.jma.Bb(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cof() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jma != null) {
                this.jma.Bb(this.mState);
            }
            this.jlS.cop();
            clearAnimation();
            this.jlS.jme.setVisibility(0);
            this.jlS.jmd.setVisibility(0);
            this.jlS.jmw.setVisibility(0);
            this.jlS.jmt.setVisibility(8);
            cog();
            this.fud.start();
            this.jlC.start();
            this.jlS.jmw.b(this.jlK);
            this.jlS.jmw.removeUpdateListener(this.jlJ);
            this.jlS.jmw.a(this.jlH);
            this.jlS.jmw.a(this.jlI);
            this.jlS.jmw.setMinAndMaxProgress(0.0f, 0.48148f);
            this.jlS.jmw.setProgress(0.0f);
            this.jlS.jmw.cu();
        }
    }

    private void cog() {
        this.jlS.jms.post(new Runnable() { // from class: com.baidu.tieba.write.c.14
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jmx != null && c.this.jlF == 0) {
                    c.this.jlS.jms.getGlobalVisibleRect(c.this.jmy);
                    c.this.jlF = (c.this.jmx.centerY() - c.this.jmy.centerY()) - l.h(TbadkCoreApplication.getInst(), d.e.tbds4);
                }
                c.this.jlS.jms.setVisibility(0);
                c.this.jlS.jms.setTranslationY(c.this.jlF);
                if (c.this.bIp != null) {
                    c.this.bIp.setVisibility(4);
                }
            }
        });
    }

    @Override // com.baidu.tieba.write.f
    public void coh() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jma != null) {
                this.jma.Bb(this.mState);
            }
            this.jlS.coq();
            this.jlS.jmw.setVisibility(0);
            this.jlA.start();
            this.fue.start();
            this.jlD.start();
            this.jlS.jmw.b(this.jlI);
            this.jlS.jmw.removeUpdateListener(this.jlH);
            this.jlS.jmw.a(this.jlJ);
            this.jlS.jmw.a(this.jlK);
            this.jlS.jmw.setMinAndMaxProgress(0.48148f, 1.0f);
            this.jlS.jmw.setProgress(0.0f);
            this.jlS.jmw.cu();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void coi() {
        coe();
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
        this.jlS.jmw.cancelAnimation();
    }

    private void clearAnimation() {
        this.fud.cancel();
        this.fue.cancel();
        this.jlz.cancel();
        this.jlA.cancel();
        this.jlB.cancel();
        this.jlC.cancel();
        this.jlE.cancel();
        this.jlD.cancel();
    }

    private void coj() {
        this.jlS.jmw.setVisibility(8);
        this.jlS.jms.setVisibility(4);
        this.jlS.jme.setVisibility(8);
        this.jlS.jmd.setVisibility(8);
        this.jlS.jmt.setVisibility(8);
    }
}
