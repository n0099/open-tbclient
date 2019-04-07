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
    private ValueAnimator ftO;
    private ValueAnimator ftP;
    private boolean jlc;
    private boolean jld;
    private boolean jle;
    private ValueAnimator jlf;
    private ValueAnimator jlg;
    private ValueAnimator jlh;
    private ValueAnimator jli;
    private ValueAnimator jlj;
    private ValueAnimator jlk;
    private int jll;
    private int jlm;
    private ValueAnimator.AnimatorUpdateListener jln;
    private Animator.AnimatorListener jlo;
    private ValueAnimator.AnimatorUpdateListener jlp;
    private Animator.AnimatorListener jlq;

    public c(Context context, e.a aVar) {
        super(context, aVar);
        this.jlc = false;
        this.jld = false;
        this.jle = false;
        this.jln = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (c.this.jlc || animatedFraction < 0.6923f || !c.this.jly.jmb.isAnimating()) {
                    if (!c.this.jle && animatedFraction >= 0.38461f && c.this.jly.jmb.isAnimating()) {
                        c.this.jle = true;
                        c.this.cob();
                        return;
                    }
                    return;
                }
                c.this.jlc = true;
                c.this.coc();
            }
        };
        this.jlo = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.cod();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.jlp = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!c.this.jld && animatedFraction >= 0.57142f && c.this.jly.jmb.isAnimating()) {
                    c.this.jld = true;
                    c.this.coe();
                }
            }
        };
        this.jlq = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.16
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.cof();
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
        this.ftO = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ftO.setDuration(451L);
        this.ftO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.17
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jly.jlJ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jly.jlK.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.ftO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.18
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jly.jlJ.setAlpha(1.0f);
                c.this.jly.jlK.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ftP = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.ftP.setDuration(485L);
        this.ftP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.19
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jly.jlJ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jly.jlK.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (c.this.jly.jma.getVisibility() == 0 && c.this.jly.jlZ.getVisibility() == 0) {
                        c.this.jly.jma.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        c.this.jly.jlZ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.ftP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.20
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jly.jlJ.setAlpha(0.0f);
                c.this.jly.jlK.setAlpha(0.0f);
                if (c.this.jly.jma.getVisibility() == 0 && c.this.jly.jlZ.getVisibility() == 0) {
                    c.this.jly.jma.setAlpha(0.0f);
                    c.this.jly.jlZ.setAlpha(0);
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
        this.jlf = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlf.setDuration(138L);
        this.jlf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.21
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jly.jlY.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jly.jlY.setTranslationY(c.this.jlm - (c.this.jlm * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jlf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jly.jlY.setAlpha(1.0f);
                c.this.jly.jlY.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlg = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jlg.setDuration(138L);
        this.jlg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jly.jlY.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jly.jlY.setTranslationY(c.this.jlm * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jlg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jly.jlY.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlh = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlh.setDuration(104L);
        this.jlh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jlh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.6
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
        this.jli = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jli.setDuration(208L);
        this.jli.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jli.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.8
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
        this.jlk = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlk.setDuration(173L);
        this.jlk.setInterpolator(new DecelerateInterpolator());
        this.jlk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.jll != 0 && valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c.this.jly.jlX.setTranslationY(c.this.jll * (1.0f - floatValue));
                    c.this.jly.jlX.setRotation(floatValue * 135.0f);
                }
            }
        });
        this.jlk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jly.jlX.setTranslationY(0.0f);
                c.this.jly.jlX.setRotation(135.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlj = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlj.setDuration(277L);
        this.jlj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.jly.jlX.setTranslationY(c.this.jll * animatedFraction);
                    c.this.jly.jlX.setRotation(135.0f - (animatedFraction * 135.0f));
                }
            }
        });
        this.jlj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.13
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jly.jlX.setTranslationY(c.this.jll);
                c.this.jly.jlX.setRotation(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlm = l.h(TbadkCoreApplication.getInst(), d.e.tbds40);
        this.jly.jlO.setVisibility(0);
        this.jly.jlL.setVisibility(0);
        this.jly.jlR.setVisibility(0);
        this.jly.jlU.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cob() {
        this.jlk.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coc() {
        this.jly.jlY.setVisibility(0);
        this.jlf.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cod() {
        this.jly.jmb.setVisibility(8);
        this.mState = 2;
        if (this.jlG != null) {
            this.jlG.AX(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coe() {
        this.jlh.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cof() {
        this.jlc = false;
        this.jle = false;
        this.jld = false;
        if (this.bIs != null) {
            this.bIs.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        cok();
        this.mState = 4;
        if (this.jlG != null) {
            this.jlG.AX(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cog() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jlG != null) {
                this.jlG.AX(this.mState);
            }
            this.jly.coq();
            clearAnimation();
            this.jly.jlK.setVisibility(0);
            this.jly.jlJ.setVisibility(0);
            this.jly.jmb.setVisibility(0);
            this.jly.jlY.setVisibility(8);
            coh();
            this.ftO.start();
            this.jli.start();
            this.jly.jmb.b(this.jlq);
            this.jly.jmb.removeUpdateListener(this.jlp);
            this.jly.jmb.a(this.jln);
            this.jly.jmb.a(this.jlo);
            this.jly.jmb.setMinAndMaxProgress(0.0f, 0.48148f);
            this.jly.jmb.setProgress(0.0f);
            this.jly.jmb.cu();
        }
    }

    private void coh() {
        this.jly.jlX.post(new Runnable() { // from class: com.baidu.tieba.write.c.14
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jmc != null && c.this.jll == 0) {
                    c.this.jly.jlX.getGlobalVisibleRect(c.this.jmd);
                    c.this.jll = (c.this.jmc.centerY() - c.this.jmd.centerY()) - l.h(TbadkCoreApplication.getInst(), d.e.tbds4);
                }
                c.this.jly.jlX.setVisibility(0);
                c.this.jly.jlX.setTranslationY(c.this.jll);
                if (c.this.bIs != null) {
                    c.this.bIs.setVisibility(4);
                }
            }
        });
    }

    @Override // com.baidu.tieba.write.f
    public void coi() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jlG != null) {
                this.jlG.AX(this.mState);
            }
            this.jly.cor();
            this.jly.jmb.setVisibility(0);
            this.jlg.start();
            this.ftP.start();
            this.jlj.start();
            this.jly.jmb.b(this.jlo);
            this.jly.jmb.removeUpdateListener(this.jln);
            this.jly.jmb.a(this.jlp);
            this.jly.jmb.a(this.jlq);
            this.jly.jmb.setMinAndMaxProgress(0.48148f, 1.0f);
            this.jly.jmb.setProgress(0.0f);
            this.jly.jmb.cu();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void coj() {
        cof();
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
        this.jly.jmb.cancelAnimation();
    }

    private void clearAnimation() {
        this.ftO.cancel();
        this.ftP.cancel();
        this.jlf.cancel();
        this.jlg.cancel();
        this.jlh.cancel();
        this.jli.cancel();
        this.jlk.cancel();
        this.jlj.cancel();
    }

    private void cok() {
        this.jly.jmb.setVisibility(8);
        this.jly.jlX.setVisibility(4);
        this.jly.jlK.setVisibility(8);
        this.jly.jlJ.setVisibility(8);
        this.jly.jlY.setVisibility(8);
    }
}
