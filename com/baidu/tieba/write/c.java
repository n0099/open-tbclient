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
    private ValueAnimator fuc;
    private ValueAnimator fud;
    private Animator.AnimatorListener jlA;
    private ValueAnimator.AnimatorUpdateListener jlB;
    private Animator.AnimatorListener jlC;
    private boolean jlo;
    private boolean jlp;
    private boolean jlq;
    private ValueAnimator jlr;
    private ValueAnimator jls;
    private ValueAnimator jlt;
    private ValueAnimator jlu;
    private ValueAnimator jlv;
    private ValueAnimator jlw;
    private int jlx;
    private int jly;
    private ValueAnimator.AnimatorUpdateListener jlz;

    public c(Context context, e.a aVar) {
        super(context, aVar);
        this.jlo = false;
        this.jlp = false;
        this.jlq = false;
        this.jlz = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (c.this.jlo || animatedFraction < 0.6923f || !c.this.jlK.jmn.isAnimating()) {
                    if (!c.this.jlq && animatedFraction >= 0.38461f && c.this.jlK.jmn.isAnimating()) {
                        c.this.jlq = true;
                        c.this.cod();
                        return;
                    }
                    return;
                }
                c.this.jlo = true;
                c.this.coe();
            }
        };
        this.jlA = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.12
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
        this.jlB = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!c.this.jlp && animatedFraction >= 0.57142f && c.this.jlK.jmn.isAnimating()) {
                    c.this.jlp = true;
                    c.this.cog();
                }
            }
        };
        this.jlC = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.16
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.coh();
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
        this.fuc = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fuc.setDuration(451L);
        this.fuc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.17
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jlK.jlV.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jlK.jlW.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fuc.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.18
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jlK.jlV.setAlpha(1.0f);
                c.this.jlK.jlW.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fud = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fud.setDuration(485L);
        this.fud.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.19
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jlK.jlV.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jlK.jlW.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (c.this.jlK.jmm.getVisibility() == 0 && c.this.jlK.jml.getVisibility() == 0) {
                        c.this.jlK.jmm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        c.this.jlK.jml.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fud.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.20
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jlK.jlV.setAlpha(0.0f);
                c.this.jlK.jlW.setAlpha(0.0f);
                if (c.this.jlK.jmm.getVisibility() == 0 && c.this.jlK.jml.getVisibility() == 0) {
                    c.this.jlK.jmm.setAlpha(0.0f);
                    c.this.jlK.jml.setAlpha(0);
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
        this.jlr = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlr.setDuration(138L);
        this.jlr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.21
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jlK.jmk.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jlK.jmk.setTranslationY(c.this.jly - (c.this.jly * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jlr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jlK.jmk.setAlpha(1.0f);
                c.this.jlK.jmk.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jls = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jls.setDuration(138L);
        this.jls.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jlK.jmk.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jlK.jmk.setTranslationY(c.this.jly * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jls.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jlK.jmk.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlt = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlt.setDuration(104L);
        this.jlt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jlt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.6
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
        this.jlu = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jlu.setDuration(208L);
        this.jlu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jlu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.8
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
        this.jlw = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlw.setDuration(173L);
        this.jlw.setInterpolator(new DecelerateInterpolator());
        this.jlw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.jlx != 0 && valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c.this.jlK.jmj.setTranslationY(c.this.jlx * (1.0f - floatValue));
                    c.this.jlK.jmj.setRotation(floatValue * 135.0f);
                }
            }
        });
        this.jlw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jlK.jmj.setTranslationY(0.0f);
                c.this.jlK.jmj.setRotation(135.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlv = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlv.setDuration(277L);
        this.jlv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.jlK.jmj.setTranslationY(c.this.jlx * animatedFraction);
                    c.this.jlK.jmj.setRotation(135.0f - (animatedFraction * 135.0f));
                }
            }
        });
        this.jlv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.13
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jlK.jmj.setTranslationY(c.this.jlx);
                c.this.jlK.jmj.setRotation(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jly = l.h(TbadkCoreApplication.getInst(), d.e.tbds40);
        this.jlK.jma.setVisibility(0);
        this.jlK.jlX.setVisibility(0);
        this.jlK.jmd.setVisibility(0);
        this.jlK.jmg.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cod() {
        this.jlw.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coe() {
        this.jlK.jmk.setVisibility(0);
        this.jlr.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cof() {
        this.jlK.jmn.setVisibility(8);
        this.mState = 2;
        if (this.jlS != null) {
            this.jlS.Bb(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cog() {
        this.jlt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coh() {
        this.jlo = false;
        this.jlq = false;
        this.jlp = false;
        if (this.bIq != null) {
            this.bIq.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        com();
        this.mState = 4;
        if (this.jlS != null) {
            this.jlS.Bb(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void coi() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jlS != null) {
                this.jlS.Bb(this.mState);
            }
            this.jlK.cos();
            clearAnimation();
            this.jlK.jlW.setVisibility(0);
            this.jlK.jlV.setVisibility(0);
            this.jlK.jmn.setVisibility(0);
            this.jlK.jmk.setVisibility(8);
            coj();
            this.fuc.start();
            this.jlu.start();
            this.jlK.jmn.b(this.jlC);
            this.jlK.jmn.removeUpdateListener(this.jlB);
            this.jlK.jmn.a(this.jlz);
            this.jlK.jmn.a(this.jlA);
            this.jlK.jmn.setMinAndMaxProgress(0.0f, 0.48148f);
            this.jlK.jmn.setProgress(0.0f);
            this.jlK.jmn.cu();
        }
    }

    private void coj() {
        this.jlK.jmj.post(new Runnable() { // from class: com.baidu.tieba.write.c.14
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jmo != null && c.this.jlx == 0) {
                    c.this.jlK.jmj.getGlobalVisibleRect(c.this.jmq);
                    c.this.jlx = (c.this.jmo.centerY() - c.this.jmq.centerY()) - l.h(TbadkCoreApplication.getInst(), d.e.tbds4);
                }
                c.this.jlK.jmj.setVisibility(0);
                c.this.jlK.jmj.setTranslationY(c.this.jlx);
                if (c.this.bIq != null) {
                    c.this.bIq.setVisibility(4);
                }
            }
        });
    }

    @Override // com.baidu.tieba.write.f
    public void cok() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jlS != null) {
                this.jlS.Bb(this.mState);
            }
            this.jlK.cot();
            this.jlK.jmn.setVisibility(0);
            this.jls.start();
            this.fud.start();
            this.jlv.start();
            this.jlK.jmn.b(this.jlA);
            this.jlK.jmn.removeUpdateListener(this.jlz);
            this.jlK.jmn.a(this.jlB);
            this.jlK.jmn.a(this.jlC);
            this.jlK.jmn.setMinAndMaxProgress(0.48148f, 1.0f);
            this.jlK.jmn.setProgress(0.0f);
            this.jlK.jmn.cu();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void col() {
        coh();
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
        this.jlK.jmn.cancelAnimation();
    }

    private void clearAnimation() {
        this.fuc.cancel();
        this.fud.cancel();
        this.jlr.cancel();
        this.jls.cancel();
        this.jlt.cancel();
        this.jlu.cancel();
        this.jlw.cancel();
        this.jlv.cancel();
    }

    private void com() {
        this.jlK.jmn.setVisibility(8);
        this.jlK.jmj.setVisibility(4);
        this.jlK.jlW.setVisibility(8);
        this.jlK.jlV.setVisibility(8);
        this.jlK.jmk.setVisibility(8);
    }
}
