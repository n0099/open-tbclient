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
    private ValueAnimator fPF;
    private ValueAnimator fPG;
    private ValueAnimator.AnimatorUpdateListener jLA;
    private Animator.AnimatorListener jLB;
    private boolean jLn;
    private boolean jLo;
    private boolean jLp;
    private ValueAnimator jLq;
    private ValueAnimator jLr;
    private ValueAnimator jLs;
    private ValueAnimator jLt;
    private ValueAnimator jLu;
    private ValueAnimator jLv;
    private int jLw;
    private int jLx;
    private ValueAnimator.AnimatorUpdateListener jLy;
    private Animator.AnimatorListener jLz;

    public c(Context context, e.a aVar) {
        super(context, aVar);
        this.jLn = false;
        this.jLo = false;
        this.jLp = false;
        this.jLy = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (c.this.jLn || animatedFraction < 0.6923f || !c.this.jLJ.jMo.isAnimating()) {
                    if (!c.this.jLp && animatedFraction >= 0.38461f && c.this.jLJ.jMo.isAnimating()) {
                        c.this.jLp = true;
                        c.this.czj();
                        return;
                    }
                    return;
                }
                c.this.jLn = true;
                c.this.czk();
            }
        };
        this.jLz = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.czl();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.jLA = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!c.this.jLo && animatedFraction >= 0.57142f && c.this.jLJ.jMo.isAnimating()) {
                    c.this.jLo = true;
                    c.this.czm();
                }
            }
        };
        this.jLB = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.16
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.czn();
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
        this.fPF = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fPF.setDuration(451L);
        this.fPF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.17
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jLJ.jLW.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jLJ.jLX.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fPF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.18
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jLJ.jLW.setAlpha(1.0f);
                c.this.jLJ.jLX.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fPG = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fPG.setDuration(485L);
        this.fPG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.19
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jLJ.jLW.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jLJ.jLX.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (c.this.jLJ.jMn.getVisibility() == 0 && c.this.jLJ.jMm.getVisibility() == 0) {
                        c.this.jLJ.jMn.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        c.this.jLJ.jMm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fPG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.20
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jLJ.jLW.setAlpha(0.0f);
                c.this.jLJ.jLX.setAlpha(0.0f);
                if (c.this.jLJ.jMn.getVisibility() == 0 && c.this.jLJ.jMm.getVisibility() == 0) {
                    c.this.jLJ.jMn.setAlpha(0.0f);
                    c.this.jLJ.jMm.setAlpha(0);
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
        this.jLq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jLq.setDuration(138L);
        this.jLq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.21
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jLJ.jMl.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jLJ.jMl.setTranslationY(c.this.jLx - (c.this.jLx * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jLq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jLJ.jMl.setAlpha(1.0f);
                c.this.jLJ.jMl.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jLr = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jLr.setDuration(138L);
        this.jLr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    c.this.jLJ.jMl.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jLJ.jMl.setTranslationY(c.this.jLx * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jLr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jLJ.jMl.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jLs = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jLs.setDuration(104L);
        this.jLs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jLs.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.6
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
        this.jLt = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jLt.setDuration(208L);
        this.jLt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && c.this.mAnchorView != null) {
                    c.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jLt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.8
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
        this.jLv = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jLv.setDuration(173L);
        this.jLv.setInterpolator(new DecelerateInterpolator());
        this.jLv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.jLw != 0 && valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c.this.jLJ.jMk.setTranslationY(c.this.jLw * (1.0f - floatValue));
                    c.this.jLJ.jMk.setRotation(floatValue * 135.0f);
                }
            }
        });
        this.jLv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jLJ.jMk.setTranslationY(0.0f);
                c.this.jLJ.jMk.setRotation(135.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jLu = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jLu.setDuration(277L);
        this.jLu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.c.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.jLJ.jMk.setTranslationY(c.this.jLw * animatedFraction);
                    c.this.jLJ.jMk.setRotation(135.0f - (animatedFraction * 135.0f));
                }
            }
        });
        this.jLu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.c.13
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.jLJ.jMk.setTranslationY(c.this.jLw);
                c.this.jLJ.jMk.setRotation(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jLx = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.jLJ.jMb.setVisibility(0);
        this.jLJ.jLY.setVisibility(0);
        this.jLJ.jMe.setVisibility(0);
        this.jLJ.jMh.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czj() {
        this.jLv.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czk() {
        this.jLJ.jMl.setVisibility(0);
        this.jLq.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czl() {
        this.jLJ.jMo.setVisibility(8);
        this.mState = 2;
        if (this.jLR != null) {
            this.jLR.CN(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czm() {
        this.jLs.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czn() {
        this.jLn = false;
        this.jLp = false;
        this.jLo = false;
        if (this.bRe != null) {
            this.bRe.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        czs();
        this.mState = 4;
        if (this.jLR != null) {
            this.jLR.CN(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void czo() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jLR != null) {
                this.jLR.CN(this.mState);
            }
            this.jLJ.czz();
            clearAnimation();
            this.jLJ.jLX.setVisibility(0);
            this.jLJ.jLW.setVisibility(0);
            this.jLJ.jMo.setVisibility(0);
            this.jLJ.jMl.setVisibility(8);
            czp();
            this.fPF.start();
            this.jLt.start();
            this.jLJ.jMo.b(this.jLB);
            this.jLJ.jMo.b(this.jLA);
            this.jLJ.jMo.a(this.jLy);
            this.jLJ.jMo.a(this.jLz);
            this.jLJ.jMo.setMinAndMaxProgress(0.0f, 0.48148f);
            this.jLJ.jMo.setProgress(0.0f);
            this.jLJ.jMo.br();
        }
    }

    private void czp() {
        this.jLJ.jMk.post(new Runnable() { // from class: com.baidu.tieba.write.c.14
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.jMp != null && c.this.jLw == 0) {
                    c.this.jLJ.jMk.getGlobalVisibleRect(c.this.jMq);
                    c.this.jLw = (c.this.jMp.centerY() - c.this.jMq.centerY()) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
                }
                c.this.jLJ.jMk.setVisibility(0);
                c.this.jLJ.jMk.setTranslationY(c.this.jLw);
                if (c.this.bRe != null) {
                    c.this.bRe.setVisibility(4);
                }
            }
        });
    }

    @Override // com.baidu.tieba.write.f
    public void czq() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jLR != null) {
                this.jLR.CN(this.mState);
            }
            this.jLJ.czA();
            this.jLJ.jMo.setVisibility(0);
            this.jLr.start();
            this.fPG.start();
            this.jLu.start();
            this.jLJ.jMo.b(this.jLz);
            this.jLJ.jMo.b(this.jLy);
            this.jLJ.jMo.a(this.jLA);
            this.jLJ.jMo.a(this.jLB);
            this.jLJ.jMo.setMinAndMaxProgress(0.48148f, 1.0f);
            this.jLJ.jMo.setProgress(0.0f);
            this.jLJ.jMo.br();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void czr() {
        czn();
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
        this.jLJ.jMo.cancelAnimation();
    }

    private void clearAnimation() {
        this.fPF.cancel();
        this.fPG.cancel();
        this.jLq.cancel();
        this.jLr.cancel();
        this.jLs.cancel();
        this.jLt.cancel();
        this.jLv.cancel();
        this.jLu.cancel();
    }

    private void czs() {
        this.jLJ.jMo.setVisibility(8);
        this.jLJ.jMk.setVisibility(4);
        this.jLJ.jLX.setVisibility(8);
        this.jLJ.jLW.setVisibility(8);
        this.jLJ.jMl.setVisibility(8);
    }
}
