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
    private int fHi;
    private ValueAnimator iTX;
    private ValueAnimator juV;
    private ValueAnimator juW;
    private ValueAnimator nTR;
    private ValueAnimator nTS;
    private float nTT;
    private float nTU;
    private AnimatorSet nTV;
    private ValueAnimator nTW;
    private float nTX;
    private float nTY;
    private float nTZ;
    private float nUa;
    private a.c nUb;
    private com.baidu.tieba.c.d nUc;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.nUa = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X009);
        this.nUb = cVar;
        this.fHi = l.getDimens(this.mContext, R.dimen.tbds0);
        init();
    }

    private void init() {
        this.nTV = new AnimatorSet();
        this.nTR = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nTR.setDuration(450L);
        this.nTR.setInterpolator(new OvershootInterpolator());
        this.nTR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nTT != 0.0f || e.this.nTU != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nUb.nTs.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.nUb.nTs.setTranslationX(e.this.nTT - (e.this.nTT * valueAnimator.getAnimatedFraction()));
                    e.this.nUb.nTs.setTranslationY(e.this.nTU - (e.this.nTU * valueAnimator.getAnimatedFraction()));
                    e.this.nUb.nTs.setRotation((-90.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nTR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.eRT != null) {
                    e.this.eRT.setVisibility(4);
                    e.this.eRT.setAlpha(0.0f);
                }
                e.this.nUb.nTs.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fHi, WebpUtils.TYPE_IMG_WEBP);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nUb.nTs.setTranslationX(0.0f);
                e.this.nUb.nTs.setTranslationY(0.0f);
                e.this.nUb.nTs.setRotation(-90.0f);
                e.this.nUb.nTs.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fHi, WebpUtils.TYPE_IMG_WEBP);
                e.this.nUb.nTs.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nTS = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nTS.setDuration(450L);
        this.nTS.setInterpolator(new AccelerateInterpolator());
        this.nTS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nTT != 0.0f || e.this.nTU != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nUb.nTs.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.nUb.nTs.setTranslationX(e.this.nTT * valueAnimator.getAnimatedFraction());
                    e.this.nUb.nTs.setTranslationY(e.this.nTU * valueAnimator.getAnimatedFraction());
                    e.this.nUb.nTs.setRotation((-90.0f) + (90.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nTS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nUb.nTs.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fHi, WebpUtils.TYPE_IMG_WEBP);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nUb.nTs.setTranslationX(e.this.nTT);
                e.this.nUb.nTs.setTranslationY(e.this.nTU);
                e.this.nUb.nTs.setRotation(0.0f);
                e.this.nUb.nTs.setEndIcon(0, 0, "");
                e.this.nUb.nTs.setCrossFade(1.0f, true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.juV = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.juV.setDuration(416L);
        this.juV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nUb.nTt.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nUb.nSO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nUb.nSX.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.juV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nUb.nTt.setAlpha(1.0f);
                e.this.nUb.nSO.setAlpha(1.0f);
                e.this.nUb.nSX.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.juW = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.juW.setDuration(200L);
        this.juW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nUb.nSO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nUb.nSX.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.juW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nUb.nSO.setAlpha(0.0f);
                e.this.nUb.nSX.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nTW = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nTW.setDuration(240L);
        this.nTW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nUb.nTt.setTranslationY(e.this.nTX - (e.this.nTX * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nTV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nUb.nTi.setClickable(false);
                e.this.nUb.nTf.setClickable(false);
                e.this.nUb.nTc.setClickable(false);
                e.this.nUb.nSZ.setClickable(false);
                e.this.nUb.nTk.setClickable(false);
                e.this.nUb.nTm.setClickable(false);
                e.this.nUb.nTp.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.baidu.tieba.c.e aA = new com.baidu.tieba.c.e(e.this.nTZ).aB(0.5f).aA(800.0f);
                e.this.nUc = new com.baidu.tieba.c.d(e.this.nUb.nTt, com.baidu.tieba.c.d.iaQ).a(aA);
                e.this.nUc.start();
                e.this.nUb.nTt.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.nUn != null) {
                    e.this.nUn.MG(e.this.mState);
                }
                e.this.nUb.nTi.setClickable(true);
                e.this.nUb.nTf.setClickable(true);
                e.this.nUb.nTc.setClickable(true);
                e.this.nUb.nSZ.setClickable(true);
                e.this.nUb.nTk.setClickable(true);
                e.this.nUb.nTm.setClickable(true);
                e.this.nUb.nTp.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iTX = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.iTX.setDuration(200L);
        this.iTX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nUb.nTt.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nUb.nTt.setTranslationY(e.this.nTY * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.iTX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nUb.nTi.setClickable(false);
                e.this.nUb.nTf.setClickable(false);
                e.this.nUb.nTc.setClickable(false);
                e.this.nUb.nSZ.setClickable(false);
                e.this.nUb.nTk.setClickable(false);
                e.this.nUb.nTm.setClickable(false);
                e.this.nUb.nTp.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nUb.nTt.setAlpha(0.0f);
                e.this.nUb.nTt.setTranslationY(e.this.nTY);
                e.this.Tl();
                e.this.nUb.nTi.setClickable(true);
                e.this.nUb.nTf.setClickable(true);
                e.this.nUb.nTc.setClickable(true);
                e.this.nUb.nSZ.setClickable(true);
                e.this.nUb.nTk.setClickable(true);
                e.this.nUb.nTm.setClickable(true);
                e.this.nUb.nTp.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nUb.nTb.setVisibility(0);
        this.nUb.nSY.setVisibility(0);
        this.nUb.nTe.setVisibility(0);
        this.nUb.nTh.setVisibility(0);
        this.nUb.nTk.setVisibility(0);
        if (this.nUb.nTm.getVisibility() != 8) {
            this.nUb.nTm.setVisibility(0);
        }
        this.nTX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.nTZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds25);
        this.nTY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
        this.nTV.play(this.nTW);
    }

    @Override // com.baidu.tieba.write.h
    public void dYt() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nUn != null) {
                this.nUn.MG(this.mState);
            }
            clearAnimation();
            MD(0);
            this.juV.start();
            this.nTV.start();
            dYv();
        }
    }

    private void dYv() {
        this.nUb.nTs.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.nUs != null && e.this.nTT == 0.0f && e.this.nTU == 0.0f) {
                    e.this.nUb.nTs.getGlobalVisibleRect(e.this.nUt);
                    e.this.nTT = e.this.nUs.centerX() - e.this.nUt.centerX();
                    e.this.nTU = e.this.nUs.centerY() - e.this.nUt.centerY();
                }
                e.this.nUb.nTs.setVisibility(0);
                e.this.nUb.nTs.setTranslationX(e.this.nTT);
                e.this.nUb.nTs.setTranslationY(e.this.nTU);
                if (e.this.eRT instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.eRT).a(e.this.nUb.nTs);
                }
                e.this.nTR.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void aDc() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nUn != null) {
                this.nUn.MG(this.mState);
            }
            clearAnimation();
            this.juW.start();
            this.nTS.start();
            this.iTX.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dYu() {
        Tl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tl() {
        if (this.eRT != null) {
            this.eRT.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        MD(8);
        this.nUb.nTs.setVisibility(4);
        if (this.eRT != null) {
            this.eRT.setVisibility(0);
            this.eRT.setAlpha(1.0f);
        }
        if (this.nUn != null) {
            this.nUn.MG(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.nTR.cancel();
        this.nTS.cancel();
        this.juW.cancel();
        this.juV.cancel();
    }

    private void MD(int i) {
        this.nUb.nSX.setVisibility(i);
        this.nUb.nSO.setVisibility(i);
        this.nUb.nTt.setVisibility(i);
    }
}
