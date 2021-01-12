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
    private int fMd;
    private ValueAnimator jCK;
    private ValueAnimator jCL;
    private ValueAnimator jbB;
    private ValueAnimator nSG;
    private ValueAnimator nSH;
    private float nSI;
    private float nSJ;
    private AnimatorSet nSK;
    private ValueAnimator nSL;
    private float nSM;
    private float nSN;
    private float nSO;
    private float nSP;
    private a.c nSQ;
    private com.baidu.tieba.b.d nSR;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.nSP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X009);
        this.nSQ = cVar;
        this.fMd = l.getDimens(this.mContext, R.dimen.tbds0);
        init();
    }

    private void init() {
        this.nSK = new AnimatorSet();
        this.nSG = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nSG.setDuration(450L);
        this.nSG.setInterpolator(new OvershootInterpolator());
        this.nSG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nSI != 0.0f || e.this.nSJ != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nSQ.nSh.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.nSQ.nSh.setTranslationX(e.this.nSI - (e.this.nSI * valueAnimator.getAnimatedFraction()));
                    e.this.nSQ.nSh.setTranslationY(e.this.nSJ - (e.this.nSJ * valueAnimator.getAnimatedFraction()));
                    e.this.nSQ.nSh.setRotation((-90.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nSG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.eXk != null) {
                    e.this.eXk.setVisibility(4);
                    e.this.eXk.setAlpha(0.0f);
                }
                e.this.nSQ.nSh.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fMd, "webp");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nSQ.nSh.setTranslationX(0.0f);
                e.this.nSQ.nSh.setTranslationY(0.0f);
                e.this.nSQ.nSh.setRotation(-90.0f);
                e.this.nSQ.nSh.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fMd, "webp");
                e.this.nSQ.nSh.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nSH = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nSH.setDuration(450L);
        this.nSH.setInterpolator(new AccelerateInterpolator());
        this.nSH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nSI != 0.0f || e.this.nSJ != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nSQ.nSh.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.nSQ.nSh.setTranslationX(e.this.nSI * valueAnimator.getAnimatedFraction());
                    e.this.nSQ.nSh.setTranslationY(e.this.nSJ * valueAnimator.getAnimatedFraction());
                    e.this.nSQ.nSh.setRotation((-90.0f) + (90.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nSH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nSQ.nSh.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fMd, "webp");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nSQ.nSh.setTranslationX(e.this.nSI);
                e.this.nSQ.nSh.setTranslationY(e.this.nSJ);
                e.this.nSQ.nSh.setRotation(0.0f);
                e.this.nSQ.nSh.setEndIcon(0, 0, "");
                e.this.nSQ.nSh.setCrossFade(1.0f, true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jCK = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jCK.setDuration(416L);
        this.jCK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nSQ.nSi.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nSQ.nRD.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nSQ.nRM.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jCK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nSQ.nSi.setAlpha(1.0f);
                e.this.nSQ.nRD.setAlpha(1.0f);
                e.this.nSQ.nRM.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jCL = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jCL.setDuration(200L);
        this.jCL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nSQ.nRD.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nSQ.nRM.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jCL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nSQ.nRD.setAlpha(0.0f);
                e.this.nSQ.nRM.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nSL = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nSL.setDuration(240L);
        this.nSL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nSQ.nSi.setTranslationY(e.this.nSM - (e.this.nSM * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nSK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nSQ.nRX.setClickable(false);
                e.this.nSQ.nRU.setClickable(false);
                e.this.nSQ.nRR.setClickable(false);
                e.this.nSQ.nRO.setClickable(false);
                e.this.nSQ.nRZ.setClickable(false);
                e.this.nSQ.nSb.setClickable(false);
                e.this.nSQ.nSe.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.baidu.tieba.b.e aC = new com.baidu.tieba.b.e(e.this.nSO).aD(0.5f).aC(800.0f);
                e.this.nSR = new com.baidu.tieba.b.d(e.this.nSQ.nSi, com.baidu.tieba.b.d.iiH).a(aC);
                e.this.nSR.start();
                e.this.nSQ.nSi.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.nTc != null) {
                    e.this.nTc.KM(e.this.mState);
                }
                e.this.nSQ.nRX.setClickable(true);
                e.this.nSQ.nRU.setClickable(true);
                e.this.nSQ.nRR.setClickable(true);
                e.this.nSQ.nRO.setClickable(true);
                e.this.nSQ.nRZ.setClickable(true);
                e.this.nSQ.nSb.setClickable(true);
                e.this.nSQ.nSe.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jbB = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jbB.setDuration(200L);
        this.jbB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nSQ.nSi.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nSQ.nSi.setTranslationY(e.this.nSN * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jbB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nSQ.nRX.setClickable(false);
                e.this.nSQ.nRU.setClickable(false);
                e.this.nSQ.nRR.setClickable(false);
                e.this.nSQ.nRO.setClickable(false);
                e.this.nSQ.nRZ.setClickable(false);
                e.this.nSQ.nSb.setClickable(false);
                e.this.nSQ.nSe.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nSQ.nSi.setAlpha(0.0f);
                e.this.nSQ.nSi.setTranslationY(e.this.nSN);
                e.this.Qv();
                e.this.nSQ.nRX.setClickable(true);
                e.this.nSQ.nRU.setClickable(true);
                e.this.nSQ.nRR.setClickable(true);
                e.this.nSQ.nRO.setClickable(true);
                e.this.nSQ.nRZ.setClickable(true);
                e.this.nSQ.nSb.setClickable(true);
                e.this.nSQ.nSe.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nSQ.nRQ.setVisibility(0);
        this.nSQ.nRN.setVisibility(0);
        this.nSQ.nRT.setVisibility(0);
        this.nSQ.nRW.setVisibility(0);
        this.nSQ.nRZ.setVisibility(0);
        if (this.nSQ.nSb.getVisibility() != 8) {
            this.nSQ.nSb.setVisibility(0);
        }
        this.nSM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.nSO = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds25);
        this.nSN = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
        this.nSK.play(this.nSL);
    }

    @Override // com.baidu.tieba.write.h
    public void dUf() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nTc != null) {
                this.nTc.KM(this.mState);
            }
            clearAnimation();
            KJ(0);
            this.jCK.start();
            this.nSK.start();
            dUh();
        }
    }

    private void dUh() {
        this.nSQ.nSh.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.nTh != null && e.this.nSI == 0.0f && e.this.nSJ == 0.0f) {
                    e.this.nSQ.nSh.getGlobalVisibleRect(e.this.nTi);
                    e.this.nSI = e.this.nTh.centerX() - e.this.nTi.centerX();
                    e.this.nSJ = e.this.nTh.centerY() - e.this.nTi.centerY();
                }
                e.this.nSQ.nSh.setVisibility(0);
                e.this.nSQ.nSh.setTranslationX(e.this.nSI);
                e.this.nSQ.nSh.setTranslationY(e.this.nSJ);
                if (e.this.eXk instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.eXk).a(e.this.nSQ.nSh);
                }
                e.this.nSG.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void aAB() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nTc != null) {
                this.nTc.KM(this.mState);
            }
            clearAnimation();
            this.jCL.start();
            this.nSH.start();
            this.jbB.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dUg() {
        Qv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qv() {
        if (this.eXk != null) {
            this.eXk.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        KJ(8);
        this.nSQ.nSh.setVisibility(4);
        if (this.eXk != null) {
            this.eXk.setVisibility(0);
            this.eXk.setAlpha(1.0f);
        }
        if (this.nTc != null) {
            this.nTc.KM(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.nSG.cancel();
        this.nSH.cancel();
        this.jCL.cancel();
        this.jCK.cancel();
    }

    private void KJ(int i) {
        this.nSQ.nRM.setVisibility(i);
        this.nSQ.nRD.setVisibility(i);
        this.nSQ.nSi.setVisibility(i);
    }
}
