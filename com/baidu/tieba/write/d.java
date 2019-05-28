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
    private ValueAnimator fKF;
    private ValueAnimator fKG;
    private float jEA;
    private float jEB;
    private float jEC;
    private ValueAnimator jEl;
    private ValueAnimator jEm;
    private ValueAnimator jEy;
    private ValueAnimator jEz;

    public d(Context context, e.a aVar) {
        super(context, aVar);
        init();
    }

    private void init() {
        this.jEy = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jEy.setDuration(450L);
        this.jEy.setInterpolator(new OvershootInterpolator());
        this.jEy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jEA != 0.0f || d.this.jEB != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jEE.jFd.setCrossFade(valueAnimator.getAnimatedFraction());
                    d.this.jEE.jFd.setTranslationX(d.this.jEA - (d.this.jEA * valueAnimator.getAnimatedFraction()));
                    d.this.jEE.jFd.setTranslationY(d.this.jEB - (d.this.jEB * valueAnimator.getAnimatedFraction()));
                    d.this.jEE.jFd.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jEy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (d.this.bQd != null) {
                    d.this.bQd.setVisibility(4);
                    d.this.bQd.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jEE.jFd.setTranslationX(0.0f);
                d.this.jEE.jFd.setTranslationY(0.0f);
                d.this.jEE.jFd.setRotation(-135.0f);
                d.this.jEE.jFd.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEz = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jEz.setDuration(300L);
        this.jEz.setInterpolator(new AccelerateInterpolator());
        this.jEz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jEA != 0.0f || d.this.jEB != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jEE.jFd.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    d.this.jEE.jFd.setTranslationX(d.this.jEA * valueAnimator.getAnimatedFraction());
                    d.this.jEE.jFd.setTranslationY(d.this.jEB * valueAnimator.getAnimatedFraction());
                    d.this.jEE.jFd.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jEz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jEE.jFd.setTranslationX(d.this.jEA);
                d.this.jEE.jFd.setTranslationY(d.this.jEB);
                d.this.jEE.jFd.setRotation(0.0f);
                d.this.jEE.jFd.setCrossFade(0.0f);
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
        this.fKF = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fKF.setDuration(500L);
        this.fKF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jEE.jEP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jEE.jEQ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fKF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jEE.jEP.setAlpha(1.0f);
                d.this.jEE.jEQ.setAlpha(1.0f);
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
        this.fKG.setDuration(300L);
        this.fKG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jEE.jEP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jEE.jEQ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (d.this.jEE.jFg.getVisibility() == 0 && d.this.jEE.jFf.getVisibility() == 0) {
                        d.this.jEE.jFg.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        d.this.jEE.jFf.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fKG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jEE.jEP.setAlpha(0.0f);
                d.this.jEE.jEQ.setAlpha(0.0f);
                if (d.this.jEE.jFg.getVisibility() == 0 && d.this.jEE.jFf.getVisibility() == 0) {
                    d.this.jEE.jFg.setAlpha(0.0f);
                    d.this.jEE.jFf.setAlpha(0);
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
        this.jEl.setDuration(450L);
        this.jEl.setInterpolator(new OvershootInterpolator(1.0f));
        this.jEl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jEE.jFe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jEE.jFe.setTranslationY(d.this.jEC - (d.this.jEC * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jEl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jEE.jFb.setClickable(false);
                d.this.jEE.jEY.setClickable(false);
                d.this.jEE.jEV.setClickable(false);
                d.this.jEE.jES.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jEE.jFe.setAlpha(1.0f);
                d.this.jEE.jFe.setTranslationY(0.0f);
                d.this.mState = 2;
                if (d.this.jEM != null) {
                    d.this.jEM.Cg(d.this.mState);
                }
                d.this.jEE.jFb.setClickable(true);
                d.this.jEE.jEY.setClickable(true);
                d.this.jEE.jEV.setClickable(true);
                d.this.jEE.jES.setClickable(true);
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
        this.jEm.setDuration(300L);
        this.jEm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jEE.jFe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jEE.jFe.setTranslationY(d.this.jEC * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jEm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jEE.jFb.setClickable(false);
                d.this.jEE.jEY.setClickable(false);
                d.this.jEE.jEV.setClickable(false);
                d.this.jEE.jES.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jEE.jFe.setAlpha(0.0f);
                d.this.jEE.jFe.setTranslationY(d.this.jEC);
                d.this.cwn();
                d.this.jEE.jFb.setClickable(true);
                d.this.jEE.jEY.setClickable(true);
                d.this.jEE.jEV.setClickable(true);
                d.this.jEE.jES.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEE.jEU.setVisibility(0);
        this.jEE.jER.setVisibility(0);
        this.jEE.jEX.setVisibility(0);
        this.jEE.jFa.setVisibility(0);
        this.jEC = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds501);
    }

    @Override // com.baidu.tieba.write.f
    public void cwo() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jEM != null) {
                this.jEM.Cg(this.mState);
            }
            clearAnimation();
            Cd(0);
            this.fKF.start();
            this.jEl.start();
            cwt();
        }
    }

    private void cwt() {
        this.jEE.jFd.post(new Runnable() { // from class: com.baidu.tieba.write.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jFi != null && d.this.jEA == 0.0f && d.this.jEB == 0.0f) {
                    d.this.jEE.jFd.getGlobalVisibleRect(d.this.jFj);
                    d.this.jEA = d.this.jFi.centerX() - d.this.jFj.centerX();
                    d.this.jEB = d.this.jFi.centerY() - d.this.jFj.centerY();
                }
                d.this.jEE.jFd.setVisibility(0);
                d.this.jEE.jFd.setTranslationX(d.this.jEA);
                d.this.jEE.jFd.setTranslationY(d.this.jEB);
                if (d.this.bQd instanceof OvalActionButton) {
                    ((OvalActionButton) d.this.bQd).a(d.this.jEE.jFd);
                }
                d.this.jEy.start();
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
            clearAnimation();
            this.fKG.start();
            this.jEz.start();
            this.jEm.start();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cwr() {
        cwn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwn() {
        if (this.bQd != null) {
            this.bQd.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        Cd(8);
        this.jEE.jFd.setVisibility(4);
        if (this.bQd != null) {
            this.bQd.setVisibility(0);
            this.bQd.setAlpha(1.0f);
        }
        if (this.jEM != null) {
            this.jEM.Cg(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.jEy.cancel();
        this.jEz.cancel();
        this.fKG.cancel();
        this.fKF.cancel();
    }

    private void Cd(int i) {
        this.jEE.jEQ.setVisibility(i);
        this.jEE.jEP.setVisibility(i);
        this.jEE.jFe.setVisibility(i);
    }
}
