package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public class d extends f {
    private ValueAnimator fKH;
    private ValueAnimator fKI;
    private ValueAnimator jEB;
    private ValueAnimator jEC;
    private float jED;
    private float jEE;
    private float jEF;
    private ValueAnimator jEo;
    private ValueAnimator jEp;

    public d(Context context, e.a aVar) {
        super(context, aVar);
        init();
    }

    private void init() {
        this.jEB = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jEB.setDuration(450L);
        this.jEB.setInterpolator(new OvershootInterpolator());
        this.jEB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jED != 0.0f || d.this.jEE != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jEH.jFg.setCrossFade(valueAnimator.getAnimatedFraction());
                    d.this.jEH.jFg.setTranslationX(d.this.jED - (d.this.jED * valueAnimator.getAnimatedFraction()));
                    d.this.jEH.jFg.setTranslationY(d.this.jEE - (d.this.jEE * valueAnimator.getAnimatedFraction()));
                    d.this.jEH.jFg.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jEB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (d.this.bQe != null) {
                    d.this.bQe.setVisibility(4);
                    d.this.bQe.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jEH.jFg.setTranslationX(0.0f);
                d.this.jEH.jFg.setTranslationY(0.0f);
                d.this.jEH.jFg.setRotation(-135.0f);
                d.this.jEH.jFg.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEC = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jEC.setDuration(300L);
        this.jEC.setInterpolator(new AccelerateInterpolator());
        this.jEC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jED != 0.0f || d.this.jEE != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jEH.jFg.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    d.this.jEH.jFg.setTranslationX(d.this.jED * valueAnimator.getAnimatedFraction());
                    d.this.jEH.jFg.setTranslationY(d.this.jEE * valueAnimator.getAnimatedFraction());
                    d.this.jEH.jFg.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jEC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jEH.jFg.setTranslationX(d.this.jED);
                d.this.jEH.jFg.setTranslationY(d.this.jEE);
                d.this.jEH.jFg.setRotation(0.0f);
                d.this.jEH.jFg.setCrossFade(0.0f);
                if (d.this.bQe != null) {
                    d.this.bQe.setVisibility(0);
                    d.this.bQe.setAlpha(1.0f);
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
        this.fKH = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fKH.setDuration(500L);
        this.fKH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jEH.jES.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jEH.jET.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fKH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jEH.jES.setAlpha(1.0f);
                d.this.jEH.jET.setAlpha(1.0f);
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
        this.fKI.setDuration(300L);
        this.fKI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jEH.jES.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jEH.jET.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (d.this.jEH.jFj.getVisibility() == 0 && d.this.jEH.jFi.getVisibility() == 0) {
                        d.this.jEH.jFj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        d.this.jEH.jFi.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fKI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jEH.jES.setAlpha(0.0f);
                d.this.jEH.jET.setAlpha(0.0f);
                if (d.this.jEH.jFj.getVisibility() == 0 && d.this.jEH.jFi.getVisibility() == 0) {
                    d.this.jEH.jFj.setAlpha(0.0f);
                    d.this.jEH.jFi.setAlpha(0);
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
        this.jEo.setDuration(450L);
        this.jEo.setInterpolator(new OvershootInterpolator(1.0f));
        this.jEo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jEH.jFh.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jEH.jFh.setTranslationY(d.this.jEF - (d.this.jEF * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jEo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jEH.jFe.setClickable(false);
                d.this.jEH.jFb.setClickable(false);
                d.this.jEH.jEY.setClickable(false);
                d.this.jEH.jEV.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jEH.jFh.setAlpha(1.0f);
                d.this.jEH.jFh.setTranslationY(0.0f);
                d.this.mState = 2;
                if (d.this.jEP != null) {
                    d.this.jEP.Cg(d.this.mState);
                }
                d.this.jEH.jFe.setClickable(true);
                d.this.jEH.jFb.setClickable(true);
                d.this.jEH.jEY.setClickable(true);
                d.this.jEH.jEV.setClickable(true);
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
        this.jEp.setDuration(300L);
        this.jEp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jEH.jFh.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jEH.jFh.setTranslationY(d.this.jEF * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jEp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jEH.jFe.setClickable(false);
                d.this.jEH.jFb.setClickable(false);
                d.this.jEH.jEY.setClickable(false);
                d.this.jEH.jEV.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jEH.jFh.setAlpha(0.0f);
                d.this.jEH.jFh.setTranslationY(d.this.jEF);
                d.this.cwm();
                d.this.jEH.jFe.setClickable(true);
                d.this.jEH.jFb.setClickable(true);
                d.this.jEH.jEY.setClickable(true);
                d.this.jEH.jEV.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEH.jEX.setVisibility(0);
        this.jEH.jEU.setVisibility(0);
        this.jEH.jFa.setVisibility(0);
        this.jEH.jFd.setVisibility(0);
        this.jEF = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds501);
    }

    @Override // com.baidu.tieba.write.f
    public void cwn() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jEP != null) {
                this.jEP.Cg(this.mState);
            }
            clearAnimation();
            Cd(0);
            this.fKH.start();
            this.jEo.start();
            cws();
        }
    }

    private void cws() {
        this.jEH.jFg.post(new Runnable() { // from class: com.baidu.tieba.write.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jFl != null && d.this.jED == 0.0f && d.this.jEE == 0.0f) {
                    d.this.jEH.jFg.getGlobalVisibleRect(d.this.jFm);
                    d.this.jED = d.this.jFl.centerX() - d.this.jFm.centerX();
                    d.this.jEE = d.this.jFl.centerY() - d.this.jFm.centerY();
                }
                d.this.jEH.jFg.setVisibility(0);
                d.this.jEH.jFg.setTranslationX(d.this.jED);
                d.this.jEH.jFg.setTranslationY(d.this.jEE);
                if (d.this.bQe instanceof OvalActionButton) {
                    ((OvalActionButton) d.this.bQe).a(d.this.jEH.jFg);
                }
                d.this.jEB.start();
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
            clearAnimation();
            this.fKI.start();
            this.jEC.start();
            this.jEp.start();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cwq() {
        cwm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwm() {
        if (this.bQe != null) {
            this.bQe.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        Cd(8);
        this.jEH.jFg.setVisibility(4);
        if (this.bQe != null) {
            this.bQe.setVisibility(0);
            this.bQe.setAlpha(1.0f);
        }
        if (this.jEP != null) {
            this.jEP.Cg(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.jEB.cancel();
        this.jEC.cancel();
        this.fKI.cancel();
        this.fKH.cancel();
    }

    private void Cd(int i) {
        this.jEH.jET.setVisibility(i);
        this.jEH.jES.setVisibility(i);
        this.jEH.jFh.setVisibility(i);
    }
}
