package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.baidu.adp.lib.util.l;
import com.baidu.android.util.media.WebpUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class e extends h {
    private int fzt;
    private ValueAnimator iJe;
    private ValueAnimator jhq;
    private ValueAnimator jhr;
    private ValueAnimator nFJ;
    private ValueAnimator nFK;
    private float nFL;
    private float nFM;
    private AnimatorSet nFN;
    private ValueAnimator nFO;
    private float nFP;
    private float nFQ;
    private float nFR;
    private float nFS;
    private a.c nFT;
    private com.baidu.tieba.c.d nFU;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.nFS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X009);
        this.nFT = cVar;
        this.fzt = l.getDimens(this.mContext, R.dimen.tbds0);
        init();
    }

    private void init() {
        this.nFN = new AnimatorSet();
        this.nFJ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nFJ.setDuration(450L);
        this.nFJ.setInterpolator(new OvershootInterpolator());
        this.nFJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nFL != 0.0f || e.this.nFM != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nFT.nFk.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.nFT.nFk.setTranslationX(e.this.nFL - (e.this.nFL * valueAnimator.getAnimatedFraction()));
                    e.this.nFT.nFk.setTranslationY(e.this.nFM - (e.this.nFM * valueAnimator.getAnimatedFraction()));
                    e.this.nFT.nFk.setRotation((-90.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nFJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.eKH != null) {
                    e.this.eKH.setVisibility(4);
                    e.this.eKH.setAlpha(0.0f);
                }
                e.this.nFT.nFk.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fzt, WebpUtils.TYPE_IMG_WEBP);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nFT.nFk.setTranslationX(0.0f);
                e.this.nFT.nFk.setTranslationY(0.0f);
                e.this.nFT.nFk.setRotation(-90.0f);
                e.this.nFT.nFk.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fzt, WebpUtils.TYPE_IMG_WEBP);
                e.this.nFT.nFk.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nFK = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nFK.setDuration(450L);
        this.nFK.setInterpolator(new AccelerateInterpolator());
        this.nFK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nFL != 0.0f || e.this.nFM != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nFT.nFk.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.nFT.nFk.setTranslationX(e.this.nFL * valueAnimator.getAnimatedFraction());
                    e.this.nFT.nFk.setTranslationY(e.this.nFM * valueAnimator.getAnimatedFraction());
                    e.this.nFT.nFk.setRotation((-90.0f) + (90.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nFK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nFT.nFk.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fzt, WebpUtils.TYPE_IMG_WEBP);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nFT.nFk.setTranslationX(e.this.nFL);
                e.this.nFT.nFk.setTranslationY(e.this.nFM);
                e.this.nFT.nFk.setRotation(0.0f);
                e.this.nFT.nFk.setEndIcon(0, 0, "");
                e.this.nFT.nFk.setCrossFade(1.0f, true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jhq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jhq.setDuration(416L);
        this.jhq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nFT.nFl.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nFT.nEG.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nFT.nEP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jhq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nFT.nFl.setAlpha(1.0f);
                e.this.nFT.nEG.setAlpha(1.0f);
                e.this.nFT.nEP.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jhr = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jhr.setDuration(200L);
        this.jhr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nFT.nEG.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nFT.nEP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jhr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nFT.nEG.setAlpha(0.0f);
                e.this.nFT.nEP.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nFO = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nFO.setDuration(240L);
        this.nFO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nFT.nFl.setTranslationY(e.this.nFP - (e.this.nFP * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nFN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nFT.nFa.setClickable(false);
                e.this.nFT.nEX.setClickable(false);
                e.this.nFT.nEU.setClickable(false);
                e.this.nFT.nER.setClickable(false);
                e.this.nFT.nFc.setClickable(false);
                e.this.nFT.nFe.setClickable(false);
                e.this.nFT.nFh.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.baidu.tieba.c.e az = new com.baidu.tieba.c.e(e.this.nFR).aA(0.5f).az(800.0f);
                e.this.nFU = new com.baidu.tieba.c.d(e.this.nFT.nFl, com.baidu.tieba.c.d.hPX).a(az);
                e.this.nFU.start();
                e.this.nFT.nFl.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.nGf != null) {
                    e.this.nGf.LO(e.this.mState);
                }
                e.this.nFT.nFa.setClickable(true);
                e.this.nFT.nEX.setClickable(true);
                e.this.nFT.nEU.setClickable(true);
                e.this.nFT.nER.setClickable(true);
                e.this.nFT.nFc.setClickable(true);
                e.this.nFT.nFe.setClickable(true);
                e.this.nFT.nFh.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iJe = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.iJe.setDuration(200L);
        this.iJe.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nFT.nFl.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nFT.nFl.setTranslationY(e.this.nFQ * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.iJe.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nFT.nFa.setClickable(false);
                e.this.nFT.nEX.setClickable(false);
                e.this.nFT.nEU.setClickable(false);
                e.this.nFT.nER.setClickable(false);
                e.this.nFT.nFc.setClickable(false);
                e.this.nFT.nFe.setClickable(false);
                e.this.nFT.nFh.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nFT.nFl.setAlpha(0.0f);
                e.this.nFT.nFl.setTranslationY(e.this.nFQ);
                e.this.QN();
                e.this.nFT.nFa.setClickable(true);
                e.this.nFT.nEX.setClickable(true);
                e.this.nFT.nEU.setClickable(true);
                e.this.nFT.nER.setClickable(true);
                e.this.nFT.nFc.setClickable(true);
                e.this.nFT.nFe.setClickable(true);
                e.this.nFT.nFh.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nFT.nET.setVisibility(0);
        this.nFT.nEQ.setVisibility(0);
        this.nFT.nEW.setVisibility(0);
        this.nFT.nEZ.setVisibility(0);
        this.nFT.nFc.setVisibility(0);
        if (this.nFT.nFe.getVisibility() != 8) {
            this.nFT.nFe.setVisibility(0);
        }
        this.nFP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.nFR = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds25);
        this.nFQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
        this.nFN.play(this.nFO);
    }

    @Override // com.baidu.tieba.write.h
    public void dSY() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nGf != null) {
                this.nGf.LO(this.mState);
            }
            clearAnimation();
            LL(0);
            this.jhq.start();
            this.nFN.start();
            dTa();
        }
    }

    private void dTa() {
        this.nFT.nFk.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.nGk != null && e.this.nFL == 0.0f && e.this.nFM == 0.0f) {
                    e.this.nFT.nFk.getGlobalVisibleRect(e.this.nGl);
                    e.this.nFL = e.this.nGk.centerX() - e.this.nGl.centerX();
                    e.this.nFM = e.this.nGk.centerY() - e.this.nGl.centerY();
                }
                e.this.nFT.nFk.setVisibility(0);
                e.this.nFT.nFk.setTranslationX(e.this.nFL);
                e.this.nFT.nFk.setTranslationY(e.this.nFM);
                if (e.this.eKH instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.eKH).a(e.this.nFT.nFk);
                }
                e.this.nFJ.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void azT() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nGf != null) {
                this.nGf.LO(this.mState);
            }
            clearAnimation();
            this.jhr.start();
            this.nFK.start();
            this.iJe.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dSZ() {
        QN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QN() {
        if (this.eKH != null) {
            this.eKH.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        LL(8);
        this.nFT.nFk.setVisibility(4);
        if (this.eKH != null) {
            this.eKH.setVisibility(0);
            this.eKH.setAlpha(1.0f);
        }
        if (this.nGf != null) {
            this.nGf.LO(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.nFJ.cancel();
        this.nFK.cancel();
        this.jhr.cancel();
        this.jhq.cancel();
    }

    private void LL(int i) {
        this.nFT.nEP.setVisibility(i);
        this.nFT.nEG.setVisibility(i);
        this.nFT.nFl.setVisibility(i);
    }
}
