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
    private boolean jld;
    private boolean jle;
    private boolean jlf;
    private ValueAnimator jlg;
    private ValueAnimator jlh;
    private ValueAnimator jli;
    private ValueAnimator jlj;
    private ValueAnimator jlk;
    private ValueAnimator jll;
    private int jlm;
    private int jln;
    private ValueAnimator.AnimatorUpdateListener jlo;
    private Animator.AnimatorListener jlp;
    private ValueAnimator.AnimatorUpdateListener jlq;
    private Animator.AnimatorListener jlr;

    public c(Context context, e.a aVar) {
        super(context, aVar);
        this.jld = false;
        this.jle = false;
        this.jlf = false;
        this.jlo = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (c.this.jld || animatedFraction < 0.6923f || !c.this.jlz.jmc.isAnimating()) {
                    if (!c.this.jlf && animatedFraction >= 0.38461f && c.this.jlz.jmc.isAnimating()) {
                        c.this.jlf = true;
                        c.this.cnQ();
                        return;
                    }
                    return;
                }
                c.this.jld = true;
                c.this.cnR();
            }
        };
        this.jlp = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.cnS();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.jlq = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!c.this.jle && animatedFraction >= 0.57142f && c.this.jlz.jmc.isAnimating()) {
                    c.this.jle = true;
                    c.this.cnT();
                }
            }
        };
        this.jlr = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.16
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.cnU();
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
                    c.this.jlz.jlK.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jlz.jlL.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fud.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.18
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jlz.jlK.setAlpha(1.0f);
                c.this.jlz.jlL.setAlpha(1.0f);
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
                    c.this.jlz.jlK.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jlz.jlL.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (c.this.jlz.jmb.getVisibility() == 0 && c.this.jlz.jma.getVisibility() == 0) {
                        c.this.jlz.jmb.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        c.this.jlz.jma.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
                c.this.jlz.jlK.setAlpha(0.0f);
                c.this.jlz.jlL.setAlpha(0.0f);
                if (c.this.jlz.jmb.getVisibility() == 0 && c.this.jlz.jma.getVisibility() == 0) {
                    c.this.jlz.jmb.setAlpha(0.0f);
                    c.this.jlz.jma.setAlpha(0);
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
        this.jlg = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlg.setDuration(138L);
        this.jlg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.21
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jlz.jlZ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jlz.jlZ.setTranslationY(c.this.jln - (c.this.jln * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jlg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jlz.jlZ.setAlpha(1.0f);
                c.this.jlz.jlZ.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlh = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jlh.setDuration(138L);
        this.jlh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jlz.jlZ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jlz.jlZ.setTranslationY(c.this.jln * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jlh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jlz.jlZ.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jli = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jli.setDuration(104L);
        this.jli.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jli.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.6
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
        this.jlj = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jlj.setDuration(208L);
        this.jlj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jlj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.8
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
        this.jll = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jll.setDuration(173L);
        this.jll.setInterpolator(new DecelerateInterpolator());
        this.jll.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.jlm != 0 && valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c.this.jlz.jlY.setTranslationY(c.this.jlm * (1.0f - floatValue));
                    c.this.jlz.jlY.setRotation(floatValue * 135.0f);
                }
            }
        });
        this.jll.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jlz.jlY.setTranslationY(0.0f);
                c.this.jlz.jlY.setRotation(135.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlk = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlk.setDuration(277L);
        this.jlk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.jlz.jlY.setTranslationY(c.this.jlm * animatedFraction);
                    c.this.jlz.jlY.setRotation(135.0f - (animatedFraction * 135.0f));
                }
            }
        });
        this.jlk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.13
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jlz.jlY.setTranslationY(c.this.jlm);
                c.this.jlz.jlY.setRotation(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jln = l.h(TbadkCoreApplication.getInst(), d.e.tbds40);
        this.jlz.jlP.setVisibility(0);
        this.jlz.jlM.setVisibility(0);
        this.jlz.jlS.setVisibility(0);
        this.jlz.jlV.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnQ() {
        this.jll.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnR() {
        this.jlz.jlZ.setVisibility(0);
        this.jlg.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnS() {
        this.jlz.jmc.setVisibility(8);
        this.mState = 2;
        if (this.jlH != null) {
            this.jlH.Ba(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnT() {
        this.jli.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnU() {
        this.jld = false;
        this.jlf = false;
        this.jle = false;
        if (this.bIp != null) {
            this.bIp.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        cnZ();
        this.mState = 4;
        if (this.jlH != null) {
            this.jlH.Ba(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cnV() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jlH != null) {
                this.jlH.Ba(this.mState);
            }
            this.jlz.cof();
            clearAnimation();
            this.jlz.jlL.setVisibility(0);
            this.jlz.jlK.setVisibility(0);
            this.jlz.jmc.setVisibility(0);
            this.jlz.jlZ.setVisibility(8);
            cnW();
            this.fud.start();
            this.jlj.start();
            this.jlz.jmc.b(this.jlr);
            this.jlz.jmc.removeUpdateListener(this.jlq);
            this.jlz.jmc.a(this.jlo);
            this.jlz.jmc.a(this.jlp);
            this.jlz.jmc.setMinAndMaxProgress(0.0f, 0.48148f);
            this.jlz.jmc.setProgress(0.0f);
            this.jlz.jmc.cu();
        }
    }

    private void cnW() {
        this.jlz.jlY.post(new Runnable() { // from class: com.baidu.tieba.write.c.14
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jmd != null && c.this.jlm == 0) {
                    c.this.jlz.jlY.getGlobalVisibleRect(c.this.jme);
                    c.this.jlm = (c.this.jmd.centerY() - c.this.jme.centerY()) - l.h(TbadkCoreApplication.getInst(), d.e.tbds4);
                }
                c.this.jlz.jlY.setVisibility(0);
                c.this.jlz.jlY.setTranslationY(c.this.jlm);
                if (c.this.bIp != null) {
                    c.this.bIp.setVisibility(4);
                }
            }
        });
    }

    @Override // com.baidu.tieba.write.f
    public void cnX() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jlH != null) {
                this.jlH.Ba(this.mState);
            }
            this.jlz.cog();
            this.jlz.jmc.setVisibility(0);
            this.jlh.start();
            this.fue.start();
            this.jlk.start();
            this.jlz.jmc.b(this.jlp);
            this.jlz.jmc.removeUpdateListener(this.jlo);
            this.jlz.jmc.a(this.jlq);
            this.jlz.jmc.a(this.jlr);
            this.jlz.jmc.setMinAndMaxProgress(0.48148f, 1.0f);
            this.jlz.jmc.setProgress(0.0f);
            this.jlz.jmc.cu();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cnY() {
        cnU();
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
        this.jlz.jmc.cancelAnimation();
    }

    private void clearAnimation() {
        this.fud.cancel();
        this.fue.cancel();
        this.jlg.cancel();
        this.jlh.cancel();
        this.jli.cancel();
        this.jlj.cancel();
        this.jll.cancel();
        this.jlk.cancel();
    }

    private void cnZ() {
        this.jlz.jmc.setVisibility(8);
        this.jlz.jlY.setVisibility(4);
        this.jlz.jlL.setVisibility(8);
        this.jlz.jlK.setVisibility(8);
        this.jlz.jlZ.setVisibility(8);
    }
}
