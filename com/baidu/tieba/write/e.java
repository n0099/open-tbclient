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
    private ValueAnimator nSH;
    private ValueAnimator nSI;
    private float nSJ;
    private float nSK;
    private AnimatorSet nSL;
    private ValueAnimator nSM;
    private float nSN;
    private float nSO;
    private float nSP;
    private float nSQ;
    private a.c nSR;
    private com.baidu.tieba.b.d nSS;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.nSQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X009);
        this.nSR = cVar;
        this.fMd = l.getDimens(this.mContext, R.dimen.tbds0);
        init();
    }

    private void init() {
        this.nSL = new AnimatorSet();
        this.nSH = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nSH.setDuration(450L);
        this.nSH.setInterpolator(new OvershootInterpolator());
        this.nSH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nSJ != 0.0f || e.this.nSK != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nSR.nSi.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.nSR.nSi.setTranslationX(e.this.nSJ - (e.this.nSJ * valueAnimator.getAnimatedFraction()));
                    e.this.nSR.nSi.setTranslationY(e.this.nSK - (e.this.nSK * valueAnimator.getAnimatedFraction()));
                    e.this.nSR.nSi.setRotation((-90.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nSH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.eXk != null) {
                    e.this.eXk.setVisibility(4);
                    e.this.eXk.setAlpha(0.0f);
                }
                e.this.nSR.nSi.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fMd, "webp");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nSR.nSi.setTranslationX(0.0f);
                e.this.nSR.nSi.setTranslationY(0.0f);
                e.this.nSR.nSi.setRotation(-90.0f);
                e.this.nSR.nSi.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fMd, "webp");
                e.this.nSR.nSi.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nSI = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nSI.setDuration(450L);
        this.nSI.setInterpolator(new AccelerateInterpolator());
        this.nSI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nSJ != 0.0f || e.this.nSK != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nSR.nSi.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.nSR.nSi.setTranslationX(e.this.nSJ * valueAnimator.getAnimatedFraction());
                    e.this.nSR.nSi.setTranslationY(e.this.nSK * valueAnimator.getAnimatedFraction());
                    e.this.nSR.nSi.setRotation((-90.0f) + (90.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nSI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nSR.nSi.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fMd, "webp");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nSR.nSi.setTranslationX(e.this.nSJ);
                e.this.nSR.nSi.setTranslationY(e.this.nSK);
                e.this.nSR.nSi.setRotation(0.0f);
                e.this.nSR.nSi.setEndIcon(0, 0, "");
                e.this.nSR.nSi.setCrossFade(1.0f, true);
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
                    e.this.nSR.nSj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nSR.nRE.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nSR.nRN.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jCK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nSR.nSj.setAlpha(1.0f);
                e.this.nSR.nRE.setAlpha(1.0f);
                e.this.nSR.nRN.setAlpha(1.0f);
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
                    e.this.nSR.nRE.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nSR.nRN.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jCL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nSR.nRE.setAlpha(0.0f);
                e.this.nSR.nRN.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nSM = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nSM.setDuration(240L);
        this.nSM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nSR.nSj.setTranslationY(e.this.nSN - (e.this.nSN * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nSL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nSR.nRY.setClickable(false);
                e.this.nSR.nRV.setClickable(false);
                e.this.nSR.nRS.setClickable(false);
                e.this.nSR.nRP.setClickable(false);
                e.this.nSR.nSa.setClickable(false);
                e.this.nSR.nSc.setClickable(false);
                e.this.nSR.nSf.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.baidu.tieba.b.e aC = new com.baidu.tieba.b.e(e.this.nSP).aD(0.5f).aC(800.0f);
                e.this.nSS = new com.baidu.tieba.b.d(e.this.nSR.nSj, com.baidu.tieba.b.d.iiH).a(aC);
                e.this.nSS.start();
                e.this.nSR.nSj.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.nTd != null) {
                    e.this.nTd.KM(e.this.mState);
                }
                e.this.nSR.nRY.setClickable(true);
                e.this.nSR.nRV.setClickable(true);
                e.this.nSR.nRS.setClickable(true);
                e.this.nSR.nRP.setClickable(true);
                e.this.nSR.nSa.setClickable(true);
                e.this.nSR.nSc.setClickable(true);
                e.this.nSR.nSf.setClickable(true);
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
                    e.this.nSR.nSj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nSR.nSj.setTranslationY(e.this.nSO * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jbB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nSR.nRY.setClickable(false);
                e.this.nSR.nRV.setClickable(false);
                e.this.nSR.nRS.setClickable(false);
                e.this.nSR.nRP.setClickable(false);
                e.this.nSR.nSa.setClickable(false);
                e.this.nSR.nSc.setClickable(false);
                e.this.nSR.nSf.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nSR.nSj.setAlpha(0.0f);
                e.this.nSR.nSj.setTranslationY(e.this.nSO);
                e.this.Qv();
                e.this.nSR.nRY.setClickable(true);
                e.this.nSR.nRV.setClickable(true);
                e.this.nSR.nRS.setClickable(true);
                e.this.nSR.nRP.setClickable(true);
                e.this.nSR.nSa.setClickable(true);
                e.this.nSR.nSc.setClickable(true);
                e.this.nSR.nSf.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nSR.nRR.setVisibility(0);
        this.nSR.nRO.setVisibility(0);
        this.nSR.nRU.setVisibility(0);
        this.nSR.nRX.setVisibility(0);
        this.nSR.nSa.setVisibility(0);
        if (this.nSR.nSc.getVisibility() != 8) {
            this.nSR.nSc.setVisibility(0);
        }
        this.nSN = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.nSP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds25);
        this.nSO = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
        this.nSL.play(this.nSM);
    }

    @Override // com.baidu.tieba.write.h
    public void dUf() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nTd != null) {
                this.nTd.KM(this.mState);
            }
            clearAnimation();
            KJ(0);
            this.jCK.start();
            this.nSL.start();
            dUh();
        }
    }

    private void dUh() {
        this.nSR.nSi.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.nTi != null && e.this.nSJ == 0.0f && e.this.nSK == 0.0f) {
                    e.this.nSR.nSi.getGlobalVisibleRect(e.this.nTj);
                    e.this.nSJ = e.this.nTi.centerX() - e.this.nTj.centerX();
                    e.this.nSK = e.this.nTi.centerY() - e.this.nTj.centerY();
                }
                e.this.nSR.nSi.setVisibility(0);
                e.this.nSR.nSi.setTranslationX(e.this.nSJ);
                e.this.nSR.nSi.setTranslationY(e.this.nSK);
                if (e.this.eXk instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.eXk).a(e.this.nSR.nSi);
                }
                e.this.nSH.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void aAB() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nTd != null) {
                this.nTd.KM(this.mState);
            }
            clearAnimation();
            this.jCL.start();
            this.nSI.start();
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
        this.nSR.nSi.setVisibility(4);
        if (this.eXk != null) {
            this.eXk.setVisibility(0);
            this.eXk.setAlpha(1.0f);
        }
        if (this.nTd != null) {
            this.nTd.KM(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.nSH.cancel();
        this.nSI.cancel();
        this.jCL.cancel();
        this.jCK.cancel();
    }

    private void KJ(int i) {
        this.nSR.nRN.setVisibility(i);
        this.nSR.nRE.setVisibility(i);
        this.nSR.nSj.setVisibility(i);
    }
}
