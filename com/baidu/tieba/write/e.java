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
    private ValueAnimator iTV;
    private ValueAnimator juT;
    private ValueAnimator juU;
    private ValueAnimator nTP;
    private ValueAnimator nTQ;
    private float nTR;
    private float nTS;
    private AnimatorSet nTT;
    private ValueAnimator nTU;
    private float nTV;
    private float nTW;
    private float nTX;
    private float nTY;
    private a.c nTZ;
    private com.baidu.tieba.c.d nUa;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.nTY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X009);
        this.nTZ = cVar;
        this.fHi = l.getDimens(this.mContext, R.dimen.tbds0);
        init();
    }

    private void init() {
        this.nTT = new AnimatorSet();
        this.nTP = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nTP.setDuration(450L);
        this.nTP.setInterpolator(new OvershootInterpolator());
        this.nTP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nTR != 0.0f || e.this.nTS != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nTZ.nTq.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.nTZ.nTq.setTranslationX(e.this.nTR - (e.this.nTR * valueAnimator.getAnimatedFraction()));
                    e.this.nTZ.nTq.setTranslationY(e.this.nTS - (e.this.nTS * valueAnimator.getAnimatedFraction()));
                    e.this.nTZ.nTq.setRotation((-90.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nTP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.eRT != null) {
                    e.this.eRT.setVisibility(4);
                    e.this.eRT.setAlpha(0.0f);
                }
                e.this.nTZ.nTq.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fHi, WebpUtils.TYPE_IMG_WEBP);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nTZ.nTq.setTranslationX(0.0f);
                e.this.nTZ.nTq.setTranslationY(0.0f);
                e.this.nTZ.nTq.setRotation(-90.0f);
                e.this.nTZ.nTq.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fHi, WebpUtils.TYPE_IMG_WEBP);
                e.this.nTZ.nTq.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nTQ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nTQ.setDuration(450L);
        this.nTQ.setInterpolator(new AccelerateInterpolator());
        this.nTQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nTR != 0.0f || e.this.nTS != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nTZ.nTq.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.nTZ.nTq.setTranslationX(e.this.nTR * valueAnimator.getAnimatedFraction());
                    e.this.nTZ.nTq.setTranslationY(e.this.nTS * valueAnimator.getAnimatedFraction());
                    e.this.nTZ.nTq.setRotation((-90.0f) + (90.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nTQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nTZ.nTq.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fHi, WebpUtils.TYPE_IMG_WEBP);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nTZ.nTq.setTranslationX(e.this.nTR);
                e.this.nTZ.nTq.setTranslationY(e.this.nTS);
                e.this.nTZ.nTq.setRotation(0.0f);
                e.this.nTZ.nTq.setEndIcon(0, 0, "");
                e.this.nTZ.nTq.setCrossFade(1.0f, true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.juT = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.juT.setDuration(416L);
        this.juT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nTZ.nTr.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nTZ.nSM.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nTZ.nSV.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.juT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nTZ.nTr.setAlpha(1.0f);
                e.this.nTZ.nSM.setAlpha(1.0f);
                e.this.nTZ.nSV.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.juU = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.juU.setDuration(200L);
        this.juU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nTZ.nSM.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nTZ.nSV.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.juU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nTZ.nSM.setAlpha(0.0f);
                e.this.nTZ.nSV.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nTU = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nTU.setDuration(240L);
        this.nTU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nTZ.nTr.setTranslationY(e.this.nTV - (e.this.nTV * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nTT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nTZ.nTg.setClickable(false);
                e.this.nTZ.nTd.setClickable(false);
                e.this.nTZ.nTa.setClickable(false);
                e.this.nTZ.nSX.setClickable(false);
                e.this.nTZ.nTi.setClickable(false);
                e.this.nTZ.nTk.setClickable(false);
                e.this.nTZ.nTn.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.baidu.tieba.c.e aA = new com.baidu.tieba.c.e(e.this.nTX).aB(0.5f).aA(800.0f);
                e.this.nUa = new com.baidu.tieba.c.d(e.this.nTZ.nTr, com.baidu.tieba.c.d.iaO).a(aA);
                e.this.nUa.start();
                e.this.nTZ.nTr.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.nUl != null) {
                    e.this.nUl.MG(e.this.mState);
                }
                e.this.nTZ.nTg.setClickable(true);
                e.this.nTZ.nTd.setClickable(true);
                e.this.nTZ.nTa.setClickable(true);
                e.this.nTZ.nSX.setClickable(true);
                e.this.nTZ.nTi.setClickable(true);
                e.this.nTZ.nTk.setClickable(true);
                e.this.nTZ.nTn.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iTV = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.iTV.setDuration(200L);
        this.iTV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nTZ.nTr.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nTZ.nTr.setTranslationY(e.this.nTW * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.iTV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nTZ.nTg.setClickable(false);
                e.this.nTZ.nTd.setClickable(false);
                e.this.nTZ.nTa.setClickable(false);
                e.this.nTZ.nSX.setClickable(false);
                e.this.nTZ.nTi.setClickable(false);
                e.this.nTZ.nTk.setClickable(false);
                e.this.nTZ.nTn.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nTZ.nTr.setAlpha(0.0f);
                e.this.nTZ.nTr.setTranslationY(e.this.nTW);
                e.this.Tl();
                e.this.nTZ.nTg.setClickable(true);
                e.this.nTZ.nTd.setClickable(true);
                e.this.nTZ.nTa.setClickable(true);
                e.this.nTZ.nSX.setClickable(true);
                e.this.nTZ.nTi.setClickable(true);
                e.this.nTZ.nTk.setClickable(true);
                e.this.nTZ.nTn.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nTZ.nSZ.setVisibility(0);
        this.nTZ.nSW.setVisibility(0);
        this.nTZ.nTc.setVisibility(0);
        this.nTZ.nTf.setVisibility(0);
        this.nTZ.nTi.setVisibility(0);
        if (this.nTZ.nTk.getVisibility() != 8) {
            this.nTZ.nTk.setVisibility(0);
        }
        this.nTV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.nTX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds25);
        this.nTW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
        this.nTT.play(this.nTU);
    }

    @Override // com.baidu.tieba.write.h
    public void dYs() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nUl != null) {
                this.nUl.MG(this.mState);
            }
            clearAnimation();
            MD(0);
            this.juT.start();
            this.nTT.start();
            dYu();
        }
    }

    private void dYu() {
        this.nTZ.nTq.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.nUq != null && e.this.nTR == 0.0f && e.this.nTS == 0.0f) {
                    e.this.nTZ.nTq.getGlobalVisibleRect(e.this.nUr);
                    e.this.nTR = e.this.nUq.centerX() - e.this.nUr.centerX();
                    e.this.nTS = e.this.nUq.centerY() - e.this.nUr.centerY();
                }
                e.this.nTZ.nTq.setVisibility(0);
                e.this.nTZ.nTq.setTranslationX(e.this.nTR);
                e.this.nTZ.nTq.setTranslationY(e.this.nTS);
                if (e.this.eRT instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.eRT).a(e.this.nTZ.nTq);
                }
                e.this.nTP.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void aDc() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nUl != null) {
                this.nUl.MG(this.mState);
            }
            clearAnimation();
            this.juU.start();
            this.nTQ.start();
            this.iTV.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dYt() {
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
        this.nTZ.nTq.setVisibility(4);
        if (this.eRT != null) {
            this.eRT.setVisibility(0);
            this.eRT.setAlpha(1.0f);
        }
        if (this.nUl != null) {
            this.nUl.MG(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.nTP.cancel();
        this.nTQ.cancel();
        this.juU.cancel();
        this.juT.cancel();
    }

    private void MD(int i) {
        this.nTZ.nSV.setVisibility(i);
        this.nTZ.nSM.setVisibility(i);
        this.nTZ.nTr.setVisibility(i);
    }
}
