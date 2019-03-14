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
    private ValueAnimator fuc;
    private ValueAnimator fud;
    private ValueAnimator jlE;
    private ValueAnimator jlF;
    private float jlG;
    private float jlH;
    private float jlI;
    private ValueAnimator jlr;
    private ValueAnimator jls;

    public d(Context context, e.a aVar) {
        super(context, aVar);
        init();
    }

    private void init() {
        this.jlE = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlE.setDuration(450L);
        this.jlE.setInterpolator(new OvershootInterpolator());
        this.jlE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jlG != 0.0f || d.this.jlH != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jlK.jmj.setCrossFade(valueAnimator.getAnimatedFraction());
                    d.this.jlK.jmj.setTranslationX(d.this.jlG - (d.this.jlG * valueAnimator.getAnimatedFraction()));
                    d.this.jlK.jmj.setTranslationY(d.this.jlH - (d.this.jlH * valueAnimator.getAnimatedFraction()));
                    d.this.jlK.jmj.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jlE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (d.this.bIq != null) {
                    d.this.bIq.setVisibility(4);
                    d.this.bIq.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jlK.jmj.setTranslationX(0.0f);
                d.this.jlK.jmj.setTranslationY(0.0f);
                d.this.jlK.jmj.setRotation(-135.0f);
                d.this.jlK.jmj.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlF = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlF.setDuration(300L);
        this.jlF.setInterpolator(new AccelerateInterpolator());
        this.jlF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jlG != 0.0f || d.this.jlH != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jlK.jmj.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    d.this.jlK.jmj.setTranslationX(d.this.jlG * valueAnimator.getAnimatedFraction());
                    d.this.jlK.jmj.setTranslationY(d.this.jlH * valueAnimator.getAnimatedFraction());
                    d.this.jlK.jmj.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jlF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jlK.jmj.setTranslationX(d.this.jlG);
                d.this.jlK.jmj.setTranslationY(d.this.jlH);
                d.this.jlK.jmj.setRotation(0.0f);
                d.this.jlK.jmj.setCrossFade(0.0f);
                if (d.this.bIq != null) {
                    d.this.bIq.setVisibility(0);
                    d.this.bIq.setAlpha(1.0f);
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
        this.fuc = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fuc.setDuration(500L);
        this.fuc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jlK.jlV.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jlK.jlW.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fuc.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jlK.jlV.setAlpha(1.0f);
                d.this.jlK.jlW.setAlpha(1.0f);
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
        this.fud.setDuration(300L);
        this.fud.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jlK.jlV.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jlK.jlW.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (d.this.jlK.jmm.getVisibility() == 0 && d.this.jlK.jml.getVisibility() == 0) {
                        d.this.jlK.jmm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        d.this.jlK.jml.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fud.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jlK.jlV.setAlpha(0.0f);
                d.this.jlK.jlW.setAlpha(0.0f);
                if (d.this.jlK.jmm.getVisibility() == 0 && d.this.jlK.jml.getVisibility() == 0) {
                    d.this.jlK.jmm.setAlpha(0.0f);
                    d.this.jlK.jml.setAlpha(0);
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
        this.jlr.setDuration(450L);
        this.jlr.setInterpolator(new OvershootInterpolator(1.0f));
        this.jlr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jlK.jmk.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jlK.jmk.setTranslationY(d.this.jlI - (d.this.jlI * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jlr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jlK.jmh.setClickable(false);
                d.this.jlK.jme.setClickable(false);
                d.this.jlK.jmb.setClickable(false);
                d.this.jlK.jlY.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jlK.jmk.setAlpha(1.0f);
                d.this.jlK.jmk.setTranslationY(0.0f);
                d.this.mState = 2;
                if (d.this.jlS != null) {
                    d.this.jlS.Bb(d.this.mState);
                }
                d.this.jlK.jmh.setClickable(true);
                d.this.jlK.jme.setClickable(true);
                d.this.jlK.jmb.setClickable(true);
                d.this.jlK.jlY.setClickable(true);
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
        this.jls.setDuration(300L);
        this.jls.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jlK.jmk.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jlK.jmk.setTranslationY(d.this.jlI * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jls.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jlK.jmh.setClickable(false);
                d.this.jlK.jme.setClickable(false);
                d.this.jlK.jmb.setClickable(false);
                d.this.jlK.jlY.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jlK.jmk.setAlpha(0.0f);
                d.this.jlK.jmk.setTranslationY(d.this.jlI);
                d.this.coh();
                d.this.jlK.jmh.setClickable(true);
                d.this.jlK.jme.setClickable(true);
                d.this.jlK.jmb.setClickable(true);
                d.this.jlK.jlY.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlK.jma.setVisibility(0);
        this.jlK.jlX.setVisibility(0);
        this.jlK.jmd.setVisibility(0);
        this.jlK.jmg.setVisibility(0);
        this.jlI = l.h(TbadkCoreApplication.getInst(), d.e.tbds501);
    }

    @Override // com.baidu.tieba.write.f
    public void coi() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jlS != null) {
                this.jlS.Bb(this.mState);
            }
            clearAnimation();
            AY(0);
            this.fuc.start();
            this.jlr.start();
            con();
        }
    }

    private void con() {
        this.jlK.jmj.post(new Runnable() { // from class: com.baidu.tieba.write.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jmo != null && d.this.jlG == 0.0f && d.this.jlH == 0.0f) {
                    d.this.jlK.jmj.getGlobalVisibleRect(d.this.jmq);
                    d.this.jlG = d.this.jmo.centerX() - d.this.jmq.centerX();
                    d.this.jlH = d.this.jmo.centerY() - d.this.jmq.centerY();
                }
                d.this.jlK.jmj.setVisibility(0);
                d.this.jlK.jmj.setTranslationX(d.this.jlG);
                d.this.jlK.jmj.setTranslationY(d.this.jlH);
                if (d.this.bIq instanceof OvalActionButton) {
                    ((OvalActionButton) d.this.bIq).a(d.this.jlK.jmj);
                }
                d.this.jlE.start();
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
            clearAnimation();
            this.fud.start();
            this.jlF.start();
            this.jls.start();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void col() {
        coh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coh() {
        if (this.bIq != null) {
            this.bIq.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        AY(8);
        this.jlK.jmj.setVisibility(4);
        if (this.bIq != null) {
            this.bIq.setVisibility(0);
            this.bIq.setAlpha(1.0f);
        }
        if (this.jlS != null) {
            this.jlS.Bb(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.jlE.cancel();
        this.jlF.cancel();
        this.fud.cancel();
        this.fuc.cancel();
    }

    private void AY(int i) {
        this.jlK.jlW.setVisibility(i);
        this.jlK.jlV.setVisibility(i);
        this.jlK.jmk.setVisibility(i);
    }
}
