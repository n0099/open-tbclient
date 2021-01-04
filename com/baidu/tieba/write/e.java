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
    private ValueAnimator nXm;
    private ValueAnimator nXn;
    private float nXo;
    private float nXp;
    private AnimatorSet nXq;
    private ValueAnimator nXr;
    private float nXs;
    private float nXt;
    private float nXu;
    private float nXv;
    private a.c nXw;
    private com.baidu.tieba.b.d nXx;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.nXv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X009);
        this.nXw = cVar;
        this.fQK = l.getDimens(this.mContext, R.dimen.tbds0);
        init();
    }

    private void init() {
        this.nXq = new AnimatorSet();
        this.nXm = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nXm.setDuration(450L);
        this.nXm.setInterpolator(new OvershootInterpolator());
        this.nXm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nXo != 0.0f || e.this.nXp != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nXw.nWN.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.nXw.nWN.setTranslationX(e.this.nXo - (e.this.nXo * valueAnimator.getAnimatedFraction()));
                    e.this.nXw.nWN.setTranslationY(e.this.nXp - (e.this.nXp * valueAnimator.getAnimatedFraction()));
                    e.this.nXw.nWN.setRotation((-90.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nXm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.fbS != null) {
                    e.this.fbS.setVisibility(4);
                    e.this.fbS.setAlpha(0.0f);
                }
                e.this.nXw.nWN.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fQK, "webp");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nXw.nWN.setTranslationX(0.0f);
                e.this.nXw.nWN.setTranslationY(0.0f);
                e.this.nXw.nWN.setRotation(-90.0f);
                e.this.nXw.nWN.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fQK, "webp");
                e.this.nXw.nWN.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nXn = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nXn.setDuration(450L);
        this.nXn.setInterpolator(new AccelerateInterpolator());
        this.nXn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nXo != 0.0f || e.this.nXp != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nXw.nWN.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.nXw.nWN.setTranslationX(e.this.nXo * valueAnimator.getAnimatedFraction());
                    e.this.nXw.nWN.setTranslationY(e.this.nXp * valueAnimator.getAnimatedFraction());
                    e.this.nXw.nWN.setRotation((-90.0f) + (90.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nXn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nXw.nWN.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fQK, "webp");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nXw.nWN.setTranslationX(e.this.nXo);
                e.this.nXw.nWN.setTranslationY(e.this.nXp);
                e.this.nXw.nWN.setRotation(0.0f);
                e.this.nXw.nWN.setEndIcon(0, 0, "");
                e.this.nXw.nWN.setCrossFade(1.0f, true);
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
                    e.this.nXw.nWO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nXw.nWj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nXw.nWs.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jHq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nXw.nWO.setAlpha(1.0f);
                e.this.nXw.nWj.setAlpha(1.0f);
                e.this.nXw.nWs.setAlpha(1.0f);
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
                    e.this.nXw.nWj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nXw.nWs.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jHr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nXw.nWj.setAlpha(0.0f);
                e.this.nXw.nWs.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nXr = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nXr.setDuration(240L);
        this.nXr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nXw.nWO.setTranslationY(e.this.nXs - (e.this.nXs * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nXq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nXw.nWD.setClickable(false);
                e.this.nXw.nWA.setClickable(false);
                e.this.nXw.nWx.setClickable(false);
                e.this.nXw.nWu.setClickable(false);
                e.this.nXw.nWF.setClickable(false);
                e.this.nXw.nWH.setClickable(false);
                e.this.nXw.nWK.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.baidu.tieba.b.e aC = new com.baidu.tieba.b.e(e.this.nXu).aD(0.5f).aC(800.0f);
                e.this.nXx = new com.baidu.tieba.b.d(e.this.nXw.nWO, com.baidu.tieba.b.d.inp).a(aC);
                e.this.nXx.start();
                e.this.nXw.nWO.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.nXI != null) {
                    e.this.nXI.Mt(e.this.mState);
                }
                e.this.nXw.nWD.setClickable(true);
                e.this.nXw.nWA.setClickable(true);
                e.this.nXw.nWx.setClickable(true);
                e.this.nXw.nWu.setClickable(true);
                e.this.nXw.nWF.setClickable(true);
                e.this.nXw.nWH.setClickable(true);
                e.this.nXw.nWK.setClickable(true);
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
                    e.this.nXw.nWO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nXw.nWO.setTranslationY(e.this.nXt * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jgi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nXw.nWD.setClickable(false);
                e.this.nXw.nWA.setClickable(false);
                e.this.nXw.nWx.setClickable(false);
                e.this.nXw.nWu.setClickable(false);
                e.this.nXw.nWF.setClickable(false);
                e.this.nXw.nWH.setClickable(false);
                e.this.nXw.nWK.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nXw.nWO.setAlpha(0.0f);
                e.this.nXw.nWO.setTranslationY(e.this.nXt);
                e.this.Uq();
                e.this.nXw.nWD.setClickable(true);
                e.this.nXw.nWA.setClickable(true);
                e.this.nXw.nWx.setClickable(true);
                e.this.nXw.nWu.setClickable(true);
                e.this.nXw.nWF.setClickable(true);
                e.this.nXw.nWH.setClickable(true);
                e.this.nXw.nWK.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nXw.nWw.setVisibility(0);
        this.nXw.nWt.setVisibility(0);
        this.nXw.nWz.setVisibility(0);
        this.nXw.nWC.setVisibility(0);
        this.nXw.nWF.setVisibility(0);
        if (this.nXw.nWH.getVisibility() != 8) {
            this.nXw.nWH.setVisibility(0);
        }
        this.nXs = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.nXu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds25);
        this.nXt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
        this.nXq.play(this.nXr);
    }

    @Override // com.baidu.tieba.write.h
    public void dXW() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nXI != null) {
                this.nXI.Mt(this.mState);
            }
            clearAnimation();
            Mq(0);
            this.jHq.start();
            this.nXq.start();
            dXY();
        }
    }

    private void dXY() {
        this.nXw.nWN.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.nXN != null && e.this.nXo == 0.0f && e.this.nXp == 0.0f) {
                    e.this.nXw.nWN.getGlobalVisibleRect(e.this.nXO);
                    e.this.nXo = e.this.nXN.centerX() - e.this.nXO.centerX();
                    e.this.nXp = e.this.nXN.centerY() - e.this.nXO.centerY();
                }
                e.this.nXw.nWN.setVisibility(0);
                e.this.nXw.nWN.setTranslationX(e.this.nXo);
                e.this.nXw.nWN.setTranslationY(e.this.nXp);
                if (e.this.fbS instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.fbS).a(e.this.nXw.nWN);
                }
                e.this.nXm.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void aEu() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nXI != null) {
                this.nXI.Mt(this.mState);
            }
            clearAnimation();
            this.jHr.start();
            this.nXn.start();
            this.jgi.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dXX() {
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
        this.nXw.nWN.setVisibility(4);
        if (this.fbS != null) {
            this.fbS.setVisibility(0);
            this.fbS.setAlpha(1.0f);
        }
        if (this.nXI != null) {
            this.nXI.Mt(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.nXm.cancel();
        this.nXn.cancel();
        this.jHr.cancel();
        this.jHq.cancel();
    }

    private void Mq(int i) {
        this.nXw.nWs.setVisibility(i);
        this.nXw.nWj.setVisibility(i);
        this.nXw.nWO.setVisibility(i);
    }
}
