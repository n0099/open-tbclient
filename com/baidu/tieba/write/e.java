package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class e extends h {
    private int fQK;
    private ValueAnimator jHq;
    private ValueAnimator jHr;
    private ValueAnimator jgi;
    private ValueAnimator nXl;
    private ValueAnimator nXm;
    private float nXn;
    private float nXo;
    private AnimatorSet nXp;
    private ValueAnimator nXq;
    private float nXr;
    private float nXs;
    private float nXt;
    private float nXu;
    private a.c nXv;
    private com.baidu.tieba.b.d nXw;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.nXu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X009);
        this.nXv = cVar;
        this.fQK = l.getDimens(this.mContext, R.dimen.tbds0);
        init();
    }

    private void init() {
        this.nXp = new AnimatorSet();
        this.nXl = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nXl.setDuration(450L);
        this.nXl.setInterpolator(new OvershootInterpolator());
        this.nXl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nXn != 0.0f || e.this.nXo != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nXv.nWM.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.nXv.nWM.setTranslationX(e.this.nXn - (e.this.nXn * valueAnimator.getAnimatedFraction()));
                    e.this.nXv.nWM.setTranslationY(e.this.nXo - (e.this.nXo * valueAnimator.getAnimatedFraction()));
                    e.this.nXv.nWM.setRotation((-90.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nXl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.fbS != null) {
                    e.this.fbS.setVisibility(4);
                    e.this.fbS.setAlpha(0.0f);
                }
                e.this.nXv.nWM.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fQK, "webp");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nXv.nWM.setTranslationX(0.0f);
                e.this.nXv.nWM.setTranslationY(0.0f);
                e.this.nXv.nWM.setRotation(-90.0f);
                e.this.nXv.nWM.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fQK, "webp");
                e.this.nXv.nWM.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nXm = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nXm.setDuration(450L);
        this.nXm.setInterpolator(new AccelerateInterpolator());
        this.nXm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nXn != 0.0f || e.this.nXo != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nXv.nWM.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.nXv.nWM.setTranslationX(e.this.nXn * valueAnimator.getAnimatedFraction());
                    e.this.nXv.nWM.setTranslationY(e.this.nXo * valueAnimator.getAnimatedFraction());
                    e.this.nXv.nWM.setRotation((-90.0f) + (90.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nXm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nXv.nWM.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fQK, "webp");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nXv.nWM.setTranslationX(e.this.nXn);
                e.this.nXv.nWM.setTranslationY(e.this.nXo);
                e.this.nXv.nWM.setRotation(0.0f);
                e.this.nXv.nWM.setEndIcon(0, 0, "");
                e.this.nXv.nWM.setCrossFade(1.0f, true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jHq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jHq.setDuration(416L);
        this.jHq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nXv.nWN.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nXv.nWi.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nXv.nWr.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jHq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nXv.nWN.setAlpha(1.0f);
                e.this.nXv.nWi.setAlpha(1.0f);
                e.this.nXv.nWr.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jHr = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jHr.setDuration(200L);
        this.jHr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nXv.nWi.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nXv.nWr.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jHr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nXv.nWi.setAlpha(0.0f);
                e.this.nXv.nWr.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nXq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nXq.setDuration(240L);
        this.nXq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nXv.nWN.setTranslationY(e.this.nXr - (e.this.nXr * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nXp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nXv.nWC.setClickable(false);
                e.this.nXv.nWz.setClickable(false);
                e.this.nXv.nWw.setClickable(false);
                e.this.nXv.nWt.setClickable(false);
                e.this.nXv.nWE.setClickable(false);
                e.this.nXv.nWG.setClickable(false);
                e.this.nXv.nWJ.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.baidu.tieba.b.e aC = new com.baidu.tieba.b.e(e.this.nXt).aD(0.5f).aC(800.0f);
                e.this.nXw = new com.baidu.tieba.b.d(e.this.nXv.nWN, com.baidu.tieba.b.d.inp).a(aC);
                e.this.nXw.start();
                e.this.nXv.nWN.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.nXH != null) {
                    e.this.nXH.Mt(e.this.mState);
                }
                e.this.nXv.nWC.setClickable(true);
                e.this.nXv.nWz.setClickable(true);
                e.this.nXv.nWw.setClickable(true);
                e.this.nXv.nWt.setClickable(true);
                e.this.nXv.nWE.setClickable(true);
                e.this.nXv.nWG.setClickable(true);
                e.this.nXv.nWJ.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jgi = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jgi.setDuration(200L);
        this.jgi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nXv.nWN.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nXv.nWN.setTranslationY(e.this.nXs * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jgi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nXv.nWC.setClickable(false);
                e.this.nXv.nWz.setClickable(false);
                e.this.nXv.nWw.setClickable(false);
                e.this.nXv.nWt.setClickable(false);
                e.this.nXv.nWE.setClickable(false);
                e.this.nXv.nWG.setClickable(false);
                e.this.nXv.nWJ.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nXv.nWN.setAlpha(0.0f);
                e.this.nXv.nWN.setTranslationY(e.this.nXs);
                e.this.Uq();
                e.this.nXv.nWC.setClickable(true);
                e.this.nXv.nWz.setClickable(true);
                e.this.nXv.nWw.setClickable(true);
                e.this.nXv.nWt.setClickable(true);
                e.this.nXv.nWE.setClickable(true);
                e.this.nXv.nWG.setClickable(true);
                e.this.nXv.nWJ.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nXv.nWv.setVisibility(0);
        this.nXv.nWs.setVisibility(0);
        this.nXv.nWy.setVisibility(0);
        this.nXv.nWB.setVisibility(0);
        this.nXv.nWE.setVisibility(0);
        if (this.nXv.nWG.getVisibility() != 8) {
            this.nXv.nWG.setVisibility(0);
        }
        this.nXr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.nXt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds25);
        this.nXs = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
        this.nXp.play(this.nXq);
    }

    @Override // com.baidu.tieba.write.h
    public void dXX() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nXH != null) {
                this.nXH.Mt(this.mState);
            }
            clearAnimation();
            Mq(0);
            this.jHq.start();
            this.nXp.start();
            dXZ();
        }
    }

    private void dXZ() {
        this.nXv.nWM.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.nXM != null && e.this.nXn == 0.0f && e.this.nXo == 0.0f) {
                    e.this.nXv.nWM.getGlobalVisibleRect(e.this.nXN);
                    e.this.nXn = e.this.nXM.centerX() - e.this.nXN.centerX();
                    e.this.nXo = e.this.nXM.centerY() - e.this.nXN.centerY();
                }
                e.this.nXv.nWM.setVisibility(0);
                e.this.nXv.nWM.setTranslationX(e.this.nXn);
                e.this.nXv.nWM.setTranslationY(e.this.nXo);
                if (e.this.fbS instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.fbS).a(e.this.nXv.nWM);
                }
                e.this.nXl.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void aEv() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nXH != null) {
                this.nXH.Mt(this.mState);
            }
            clearAnimation();
            this.jHr.start();
            this.nXm.start();
            this.jgi.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dXY() {
        Uq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uq() {
        if (this.fbS != null) {
            this.fbS.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        Mq(8);
        this.nXv.nWM.setVisibility(4);
        if (this.fbS != null) {
            this.fbS.setVisibility(0);
            this.fbS.setAlpha(1.0f);
        }
        if (this.nXH != null) {
            this.nXH.Mt(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.nXl.cancel();
        this.nXm.cancel();
        this.jHr.cancel();
        this.jHq.cancel();
    }

    private void Mq(int i) {
        this.nXv.nWr.setVisibility(i);
        this.nXv.nWi.setVisibility(i);
        this.nXv.nWN.setVisibility(i);
    }
}
