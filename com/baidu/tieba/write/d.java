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
    private ValueAnimator fKE;
    private ValueAnimator fKF;
    private float jEA;
    private float jEB;
    private ValueAnimator jEk;
    private ValueAnimator jEl;
    private ValueAnimator jEx;
    private ValueAnimator jEy;
    private float jEz;

    public d(Context context, e.a aVar) {
        super(context, aVar);
        init();
    }

    private void init() {
        this.jEx = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jEx.setDuration(450L);
        this.jEx.setInterpolator(new OvershootInterpolator());
        this.jEx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jEz != 0.0f || d.this.jEA != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jED.jFc.setCrossFade(valueAnimator.getAnimatedFraction());
                    d.this.jED.jFc.setTranslationX(d.this.jEz - (d.this.jEz * valueAnimator.getAnimatedFraction()));
                    d.this.jED.jFc.setTranslationY(d.this.jEA - (d.this.jEA * valueAnimator.getAnimatedFraction()));
                    d.this.jED.jFc.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jEx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (d.this.bQd != null) {
                    d.this.bQd.setVisibility(4);
                    d.this.bQd.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jED.jFc.setTranslationX(0.0f);
                d.this.jED.jFc.setTranslationY(0.0f);
                d.this.jED.jFc.setRotation(-135.0f);
                d.this.jED.jFc.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEy = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jEy.setDuration(300L);
        this.jEy.setInterpolator(new AccelerateInterpolator());
        this.jEy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jEz != 0.0f || d.this.jEA != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jED.jFc.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    d.this.jED.jFc.setTranslationX(d.this.jEz * valueAnimator.getAnimatedFraction());
                    d.this.jED.jFc.setTranslationY(d.this.jEA * valueAnimator.getAnimatedFraction());
                    d.this.jED.jFc.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jEy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jED.jFc.setTranslationX(d.this.jEz);
                d.this.jED.jFc.setTranslationY(d.this.jEA);
                d.this.jED.jFc.setRotation(0.0f);
                d.this.jED.jFc.setCrossFade(0.0f);
                if (d.this.bQd != null) {
                    d.this.bQd.setVisibility(0);
                    d.this.bQd.setAlpha(1.0f);
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
        this.fKE = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fKE.setDuration(500L);
        this.fKE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jED.jEO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jED.jEP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fKE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jED.jEO.setAlpha(1.0f);
                d.this.jED.jEP.setAlpha(1.0f);
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
        this.fKF.setDuration(300L);
        this.fKF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jED.jEO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jED.jEP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (d.this.jED.jFf.getVisibility() == 0 && d.this.jED.jFe.getVisibility() == 0) {
                        d.this.jED.jFf.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        d.this.jED.jFe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fKF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jED.jEO.setAlpha(0.0f);
                d.this.jED.jEP.setAlpha(0.0f);
                if (d.this.jED.jFf.getVisibility() == 0 && d.this.jED.jFe.getVisibility() == 0) {
                    d.this.jED.jFf.setAlpha(0.0f);
                    d.this.jED.jFe.setAlpha(0);
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
        this.jEk.setDuration(450L);
        this.jEk.setInterpolator(new OvershootInterpolator(1.0f));
        this.jEk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jED.jFd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jED.jFd.setTranslationY(d.this.jEB - (d.this.jEB * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jEk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jED.jFa.setClickable(false);
                d.this.jED.jEX.setClickable(false);
                d.this.jED.jEU.setClickable(false);
                d.this.jED.jER.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jED.jFd.setAlpha(1.0f);
                d.this.jED.jFd.setTranslationY(0.0f);
                d.this.mState = 2;
                if (d.this.jEL != null) {
                    d.this.jEL.Cg(d.this.mState);
                }
                d.this.jED.jFa.setClickable(true);
                d.this.jED.jEX.setClickable(true);
                d.this.jED.jEU.setClickable(true);
                d.this.jED.jER.setClickable(true);
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
        this.jEl.setDuration(300L);
        this.jEl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jED.jFd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jED.jFd.setTranslationY(d.this.jEB * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jEl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jED.jFa.setClickable(false);
                d.this.jED.jEX.setClickable(false);
                d.this.jED.jEU.setClickable(false);
                d.this.jED.jER.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jED.jFd.setAlpha(0.0f);
                d.this.jED.jFd.setTranslationY(d.this.jEB);
                d.this.cwl();
                d.this.jED.jFa.setClickable(true);
                d.this.jED.jEX.setClickable(true);
                d.this.jED.jEU.setClickable(true);
                d.this.jED.jER.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jED.jET.setVisibility(0);
        this.jED.jEQ.setVisibility(0);
        this.jED.jEW.setVisibility(0);
        this.jED.jEZ.setVisibility(0);
        this.jEB = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds501);
    }

    @Override // com.baidu.tieba.write.f
    public void cwm() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jEL != null) {
                this.jEL.Cg(this.mState);
            }
            clearAnimation();
            Cd(0);
            this.fKE.start();
            this.jEk.start();
            cwr();
        }
    }

    private void cwr() {
        this.jED.jFc.post(new Runnable() { // from class: com.baidu.tieba.write.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jFh != null && d.this.jEz == 0.0f && d.this.jEA == 0.0f) {
                    d.this.jED.jFc.getGlobalVisibleRect(d.this.jFi);
                    d.this.jEz = d.this.jFh.centerX() - d.this.jFi.centerX();
                    d.this.jEA = d.this.jFh.centerY() - d.this.jFi.centerY();
                }
                d.this.jED.jFc.setVisibility(0);
                d.this.jED.jFc.setTranslationX(d.this.jEz);
                d.this.jED.jFc.setTranslationY(d.this.jEA);
                if (d.this.bQd instanceof OvalActionButton) {
                    ((OvalActionButton) d.this.bQd).a(d.this.jED.jFc);
                }
                d.this.jEx.start();
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
            clearAnimation();
            this.fKF.start();
            this.jEy.start();
            this.jEl.start();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cwp() {
        cwl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwl() {
        if (this.bQd != null) {
            this.bQd.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        Cd(8);
        this.jED.jFc.setVisibility(4);
        if (this.bQd != null) {
            this.bQd.setVisibility(0);
            this.bQd.setAlpha(1.0f);
        }
        if (this.jEL != null) {
            this.jEL.Cg(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.jEx.cancel();
        this.jEy.cancel();
        this.fKF.cancel();
        this.fKE.cancel();
    }

    private void Cd(int i) {
        this.jED.jEP.setVisibility(i);
        this.jED.jEO.setVisibility(i);
        this.jED.jFd.setVisibility(i);
    }
}
