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
    private ValueAnimator jlg;
    private ValueAnimator jlh;
    private ValueAnimator jlt;
    private ValueAnimator jlu;
    private float jlv;
    private float jlw;
    private float jlx;

    public d(Context context, e.a aVar) {
        super(context, aVar);
        init();
    }

    private void init() {
        this.jlt = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlt.setDuration(450L);
        this.jlt.setInterpolator(new OvershootInterpolator());
        this.jlt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jlv != 0.0f || d.this.jlw != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jlz.jlY.setCrossFade(valueAnimator.getAnimatedFraction());
                    d.this.jlz.jlY.setTranslationX(d.this.jlv - (d.this.jlv * valueAnimator.getAnimatedFraction()));
                    d.this.jlz.jlY.setTranslationY(d.this.jlw - (d.this.jlw * valueAnimator.getAnimatedFraction()));
                    d.this.jlz.jlY.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jlt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (d.this.bIp != null) {
                    d.this.bIp.setVisibility(4);
                    d.this.bIp.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jlz.jlY.setTranslationX(0.0f);
                d.this.jlz.jlY.setTranslationY(0.0f);
                d.this.jlz.jlY.setRotation(-135.0f);
                d.this.jlz.jlY.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlu = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlu.setDuration(300L);
        this.jlu.setInterpolator(new AccelerateInterpolator());
        this.jlu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jlv != 0.0f || d.this.jlw != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jlz.jlY.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    d.this.jlz.jlY.setTranslationX(d.this.jlv * valueAnimator.getAnimatedFraction());
                    d.this.jlz.jlY.setTranslationY(d.this.jlw * valueAnimator.getAnimatedFraction());
                    d.this.jlz.jlY.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jlu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jlz.jlY.setTranslationX(d.this.jlv);
                d.this.jlz.jlY.setTranslationY(d.this.jlw);
                d.this.jlz.jlY.setRotation(0.0f);
                d.this.jlz.jlY.setCrossFade(0.0f);
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
                    d.this.jlz.jlK.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jlz.jlL.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fud.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jlz.jlK.setAlpha(1.0f);
                d.this.jlz.jlL.setAlpha(1.0f);
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
                    d.this.jlz.jlK.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jlz.jlL.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (d.this.jlz.jmb.getVisibility() == 0 && d.this.jlz.jma.getVisibility() == 0) {
                        d.this.jlz.jmb.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        d.this.jlz.jma.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
                d.this.jlz.jlK.setAlpha(0.0f);
                d.this.jlz.jlL.setAlpha(0.0f);
                if (d.this.jlz.jmb.getVisibility() == 0 && d.this.jlz.jma.getVisibility() == 0) {
                    d.this.jlz.jmb.setAlpha(0.0f);
                    d.this.jlz.jma.setAlpha(0);
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
        this.jlg.setDuration(450L);
        this.jlg.setInterpolator(new OvershootInterpolator(1.0f));
        this.jlg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jlz.jlZ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jlz.jlZ.setTranslationY(d.this.jlx - (d.this.jlx * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jlg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jlz.jlW.setClickable(false);
                d.this.jlz.jlT.setClickable(false);
                d.this.jlz.jlQ.setClickable(false);
                d.this.jlz.jlN.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jlz.jlZ.setAlpha(1.0f);
                d.this.jlz.jlZ.setTranslationY(0.0f);
                d.this.mState = 2;
                if (d.this.jlH != null) {
                    d.this.jlH.Ba(d.this.mState);
                }
                d.this.jlz.jlW.setClickable(true);
                d.this.jlz.jlT.setClickable(true);
                d.this.jlz.jlQ.setClickable(true);
                d.this.jlz.jlN.setClickable(true);
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
        this.jlh.setDuration(300L);
        this.jlh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jlz.jlZ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jlz.jlZ.setTranslationY(d.this.jlx * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jlh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jlz.jlW.setClickable(false);
                d.this.jlz.jlT.setClickable(false);
                d.this.jlz.jlQ.setClickable(false);
                d.this.jlz.jlN.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jlz.jlZ.setAlpha(0.0f);
                d.this.jlz.jlZ.setTranslationY(d.this.jlx);
                d.this.cnU();
                d.this.jlz.jlW.setClickable(true);
                d.this.jlz.jlT.setClickable(true);
                d.this.jlz.jlQ.setClickable(true);
                d.this.jlz.jlN.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlz.jlP.setVisibility(0);
        this.jlz.jlM.setVisibility(0);
        this.jlz.jlS.setVisibility(0);
        this.jlz.jlV.setVisibility(0);
        this.jlx = l.h(TbadkCoreApplication.getInst(), d.e.tbds501);
    }

    @Override // com.baidu.tieba.write.f
    public void cnV() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jlH != null) {
                this.jlH.Ba(this.mState);
            }
            clearAnimation();
            AX(0);
            this.fud.start();
            this.jlg.start();
            coa();
        }
    }

    private void coa() {
        this.jlz.jlY.post(new Runnable() { // from class: com.baidu.tieba.write.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jmd != null && d.this.jlv == 0.0f && d.this.jlw == 0.0f) {
                    d.this.jlz.jlY.getGlobalVisibleRect(d.this.jme);
                    d.this.jlv = d.this.jmd.centerX() - d.this.jme.centerX();
                    d.this.jlw = d.this.jmd.centerY() - d.this.jme.centerY();
                }
                d.this.jlz.jlY.setVisibility(0);
                d.this.jlz.jlY.setTranslationX(d.this.jlv);
                d.this.jlz.jlY.setTranslationY(d.this.jlw);
                if (d.this.bIp instanceof OvalActionButton) {
                    ((OvalActionButton) d.this.bIp).a(d.this.jlz.jlY);
                }
                d.this.jlt.start();
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
            clearAnimation();
            this.fue.start();
            this.jlu.start();
            this.jlh.start();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cnY() {
        cnU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnU() {
        if (this.bIp != null) {
            this.bIp.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        AX(8);
        this.jlz.jlY.setVisibility(4);
        if (this.bIp != null) {
            this.bIp.setVisibility(0);
            this.bIp.setAlpha(1.0f);
        }
        if (this.jlH != null) {
            this.jlH.Ba(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.jlt.cancel();
        this.jlu.cancel();
        this.fue.cancel();
        this.fud.cancel();
    }

    private void AX(int i) {
        this.jlz.jlL.setVisibility(i);
        this.jlz.jlK.setVisibility(i);
        this.jlz.jlZ.setVisibility(i);
    }
}
