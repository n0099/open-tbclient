package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.d;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public class d extends f {
    private ValueAnimator fud;
    private ValueAnimator fue;
    private ValueAnimator jlA;
    private ValueAnimator jlM;
    private ValueAnimator jlN;
    private float jlO;
    private float jlP;
    private float jlQ;
    private ValueAnimator jlz;

    public d(Context context, e.a aVar) {
        super(context, aVar);
        init();
    }

    private void init() {
        this.jlM = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlM.setDuration(450L);
        this.jlM.setInterpolator(new OvershootInterpolator());
        this.jlM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jlO != 0.0f || d.this.jlP != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jlS.jms.setCrossFade(valueAnimator.getAnimatedFraction());
                    d.this.jlS.jms.setTranslationX(d.this.jlO - (d.this.jlO * valueAnimator.getAnimatedFraction()));
                    d.this.jlS.jms.setTranslationY(d.this.jlP - (d.this.jlP * valueAnimator.getAnimatedFraction()));
                    d.this.jlS.jms.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jlM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (d.this.bIp != null) {
                    d.this.bIp.setVisibility(4);
                    d.this.bIp.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jlS.jms.setTranslationX(0.0f);
                d.this.jlS.jms.setTranslationY(0.0f);
                d.this.jlS.jms.setRotation(-135.0f);
                d.this.jlS.jms.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlN = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlN.setDuration(300L);
        this.jlN.setInterpolator(new AccelerateInterpolator());
        this.jlN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jlO != 0.0f || d.this.jlP != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jlS.jms.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    d.this.jlS.jms.setTranslationX(d.this.jlO * valueAnimator.getAnimatedFraction());
                    d.this.jlS.jms.setTranslationY(d.this.jlP * valueAnimator.getAnimatedFraction());
                    d.this.jlS.jms.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jlN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jlS.jms.setTranslationX(d.this.jlO);
                d.this.jlS.jms.setTranslationY(d.this.jlP);
                d.this.jlS.jms.setRotation(0.0f);
                d.this.jlS.jms.setCrossFade(0.0f);
                if (d.this.bIp != null) {
                    d.this.bIp.setVisibility(0);
                    d.this.bIp.setAlpha(1.0f);
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
        this.fud = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fud.setDuration(500L);
        this.fud.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jlS.jmd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jlS.jme.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fud.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jlS.jmd.setAlpha(1.0f);
                d.this.jlS.jme.setAlpha(1.0f);
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
        this.fue.setDuration(300L);
        this.fue.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jlS.jmd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jlS.jme.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (d.this.jlS.jmv.getVisibility() == 0 && d.this.jlS.jmu.getVisibility() == 0) {
                        d.this.jlS.jmv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        d.this.jlS.jmu.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fue.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jlS.jmd.setAlpha(0.0f);
                d.this.jlS.jme.setAlpha(0.0f);
                if (d.this.jlS.jmv.getVisibility() == 0 && d.this.jlS.jmu.getVisibility() == 0) {
                    d.this.jlS.jmv.setAlpha(0.0f);
                    d.this.jlS.jmu.setAlpha(0);
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
        this.jlz.setDuration(450L);
        this.jlz.setInterpolator(new OvershootInterpolator(1.0f));
        this.jlz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jlS.jmt.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jlS.jmt.setTranslationY(d.this.jlQ - (d.this.jlQ * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jlz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jlS.jmq.setClickable(false);
                d.this.jlS.jmm.setClickable(false);
                d.this.jlS.jmj.setClickable(false);
                d.this.jlS.jmg.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jlS.jmt.setAlpha(1.0f);
                d.this.jlS.jmt.setTranslationY(0.0f);
                d.this.mState = 2;
                if (d.this.jma != null) {
                    d.this.jma.Bb(d.this.mState);
                }
                d.this.jlS.jmq.setClickable(true);
                d.this.jlS.jmm.setClickable(true);
                d.this.jlS.jmj.setClickable(true);
                d.this.jlS.jmg.setClickable(true);
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
        this.jlA.setDuration(300L);
        this.jlA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jlS.jmt.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jlS.jmt.setTranslationY(d.this.jlQ * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jlA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jlS.jmq.setClickable(false);
                d.this.jlS.jmm.setClickable(false);
                d.this.jlS.jmj.setClickable(false);
                d.this.jlS.jmg.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jlS.jmt.setAlpha(0.0f);
                d.this.jlS.jmt.setTranslationY(d.this.jlQ);
                d.this.coe();
                d.this.jlS.jmq.setClickable(true);
                d.this.jlS.jmm.setClickable(true);
                d.this.jlS.jmj.setClickable(true);
                d.this.jlS.jmg.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlS.jmi.setVisibility(0);
        this.jlS.jmf.setVisibility(0);
        this.jlS.jml.setVisibility(0);
        this.jlS.jmo.setVisibility(0);
        this.jlQ = l.h(TbadkCoreApplication.getInst(), d.e.tbds501);
    }

    @Override // com.baidu.tieba.write.f
    public void cof() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jma != null) {
                this.jma.Bb(this.mState);
            }
            clearAnimation();
            AY(0);
            this.fud.start();
            this.jlz.start();
            cok();
        }
    }

    private void cok() {
        this.jlS.jms.post(new Runnable() { // from class: com.baidu.tieba.write.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jmx != null && d.this.jlO == 0.0f && d.this.jlP == 0.0f) {
                    d.this.jlS.jms.getGlobalVisibleRect(d.this.jmy);
                    d.this.jlO = d.this.jmx.centerX() - d.this.jmy.centerX();
                    d.this.jlP = d.this.jmx.centerY() - d.this.jmy.centerY();
                }
                d.this.jlS.jms.setVisibility(0);
                d.this.jlS.jms.setTranslationX(d.this.jlO);
                d.this.jlS.jms.setTranslationY(d.this.jlP);
                if (d.this.bIp instanceof OvalActionButton) {
                    ((OvalActionButton) d.this.bIp).a(d.this.jlS.jms);
                }
                d.this.jlM.start();
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
            clearAnimation();
            this.fue.start();
            this.jlN.start();
            this.jlA.start();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void coi() {
        coe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coe() {
        if (this.bIp != null) {
            this.bIp.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        AY(8);
        this.jlS.jms.setVisibility(4);
        if (this.bIp != null) {
            this.bIp.setVisibility(0);
            this.bIp.setAlpha(1.0f);
        }
        if (this.jma != null) {
            this.jma.Bb(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.jlM.cancel();
        this.jlN.cancel();
        this.fue.cancel();
        this.fud.cancel();
    }

    private void AY(int i) {
        this.jlS.jme.setVisibility(i);
        this.jlS.jmd.setVisibility(i);
        this.jlS.jmt.setVisibility(i);
    }
}
