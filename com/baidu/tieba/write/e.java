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
    private int fOr;
    private ValueAnimator jIo;
    private ValueAnimator jIp;
    private ValueAnimator jhh;
    private ValueAnimator ocN;
    private ValueAnimator ocO;
    private float ocP;
    private float ocQ;
    private AnimatorSet ocR;
    private ValueAnimator ocS;
    private float ocT;
    private float ocU;
    private float ocV;
    private float ocW;
    private a.c ocX;
    private com.baidu.tieba.b.d ocY;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.ocW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X009);
        this.ocX = cVar;
        this.fOr = l.getDimens(this.mContext, R.dimen.tbds0);
        init();
    }

    private void init() {
        this.ocR = new AnimatorSet();
        this.ocN = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ocN.setDuration(450L);
        this.ocN.setInterpolator(new OvershootInterpolator());
        this.ocN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.ocP != 0.0f || e.this.ocQ != 0.0f) && valueAnimator.isRunning()) {
                    e.this.ocX.ocn.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.ocX.ocn.setTranslationX(e.this.ocP - (e.this.ocP * valueAnimator.getAnimatedFraction()));
                    e.this.ocX.ocn.setTranslationY(e.this.ocQ - (e.this.ocQ * valueAnimator.getAnimatedFraction()));
                    e.this.ocX.ocn.setRotation((-90.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.ocN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.eZA != null) {
                    e.this.eZA.setVisibility(4);
                    e.this.eZA.setAlpha(0.0f);
                }
                e.this.ocX.ocn.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fOr, "webp");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.ocX.ocn.setTranslationX(0.0f);
                e.this.ocX.ocn.setTranslationY(0.0f);
                e.this.ocX.ocn.setRotation(-90.0f);
                e.this.ocX.ocn.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fOr, "webp");
                e.this.ocX.ocn.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ocO = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ocO.setDuration(450L);
        this.ocO.setInterpolator(new AccelerateInterpolator());
        this.ocO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.ocP != 0.0f || e.this.ocQ != 0.0f) && valueAnimator.isRunning()) {
                    e.this.ocX.ocn.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.ocX.ocn.setTranslationX(e.this.ocP * valueAnimator.getAnimatedFraction());
                    e.this.ocX.ocn.setTranslationY(e.this.ocQ * valueAnimator.getAnimatedFraction());
                    e.this.ocX.ocn.setRotation((-90.0f) + (90.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.ocO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.ocX.ocn.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fOr, "webp");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.ocX.ocn.setTranslationX(e.this.ocP);
                e.this.ocX.ocn.setTranslationY(e.this.ocQ);
                e.this.ocX.ocn.setRotation(0.0f);
                e.this.ocX.ocn.setEndIcon(0, 0, "");
                e.this.ocX.ocn.setCrossFade(1.0f, true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jIo = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jIo.setDuration(416L);
        this.jIo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.ocX.oco.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.ocX.obJ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.ocX.obS.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jIo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.ocX.oco.setAlpha(1.0f);
                e.this.ocX.obJ.setAlpha(1.0f);
                e.this.ocX.obS.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jIp = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jIp.setDuration(200L);
        this.jIp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.ocX.obJ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.ocX.obS.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jIp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.ocX.obJ.setAlpha(0.0f);
                e.this.ocX.obS.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ocS = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ocS.setDuration(240L);
        this.ocS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.ocX.oco.setTranslationY(e.this.ocT - (e.this.ocT * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.ocR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.ocX.ocd.setClickable(false);
                e.this.ocX.oca.setClickable(false);
                e.this.ocX.obX.setClickable(false);
                e.this.ocX.obU.setClickable(false);
                e.this.ocX.ocf.setClickable(false);
                e.this.ocX.och.setClickable(false);
                e.this.ocX.ock.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.baidu.tieba.b.e aF = new com.baidu.tieba.b.e(e.this.ocV).aG(0.5f).aF(800.0f);
                e.this.ocY = new com.baidu.tieba.b.d(e.this.ocX.oco, com.baidu.tieba.b.d.iop).a(aF);
                e.this.ocY.start();
                e.this.ocX.oco.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.odj != null) {
                    e.this.odj.Lh(e.this.mState);
                }
                e.this.ocX.ocd.setClickable(true);
                e.this.ocX.oca.setClickable(true);
                e.this.ocX.obX.setClickable(true);
                e.this.ocX.obU.setClickable(true);
                e.this.ocX.ocf.setClickable(true);
                e.this.ocX.och.setClickable(true);
                e.this.ocX.ock.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jhh = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jhh.setDuration(200L);
        this.jhh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.ocX.oco.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.ocX.oco.setTranslationY(e.this.ocU * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jhh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.ocX.ocd.setClickable(false);
                e.this.ocX.oca.setClickable(false);
                e.this.ocX.obX.setClickable(false);
                e.this.ocX.obU.setClickable(false);
                e.this.ocX.ocf.setClickable(false);
                e.this.ocX.och.setClickable(false);
                e.this.ocX.ock.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.ocX.oco.setAlpha(0.0f);
                e.this.ocX.oco.setTranslationY(e.this.ocU);
                e.this.Sf();
                e.this.ocX.ocd.setClickable(true);
                e.this.ocX.oca.setClickable(true);
                e.this.ocX.obX.setClickable(true);
                e.this.ocX.obU.setClickable(true);
                e.this.ocX.ocf.setClickable(true);
                e.this.ocX.och.setClickable(true);
                e.this.ocX.ock.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ocX.obW.setVisibility(0);
        this.ocX.obT.setVisibility(0);
        this.ocX.obZ.setVisibility(0);
        this.ocX.occ.setVisibility(0);
        this.ocX.ocf.setVisibility(0);
        if (this.ocX.och.getVisibility() != 8) {
            this.ocX.och.setVisibility(0);
        }
        this.ocT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.ocV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds25);
        this.ocU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
        this.ocR.play(this.ocS);
    }

    @Override // com.baidu.tieba.write.h
    public void dWt() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.odj != null) {
                this.odj.Lh(this.mState);
            }
            clearAnimation();
            Le(0);
            this.jIo.start();
            this.ocR.start();
            dWv();
        }
    }

    private void dWv() {
        this.ocX.ocn.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.odo != null && e.this.ocP == 0.0f && e.this.ocQ == 0.0f) {
                    e.this.ocX.ocn.getGlobalVisibleRect(e.this.odp);
                    e.this.ocP = e.this.odo.centerX() - e.this.odp.centerX();
                    e.this.ocQ = e.this.odo.centerY() - e.this.odp.centerY();
                }
                e.this.ocX.ocn.setVisibility(0);
                e.this.ocX.ocn.setTranslationX(e.this.ocP);
                e.this.ocX.ocn.setTranslationY(e.this.ocQ);
                if (e.this.eZA instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.eZA).a(e.this.ocX.ocn);
                }
                e.this.ocN.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void aAZ() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.odj != null) {
                this.odj.Lh(this.mState);
            }
            clearAnimation();
            this.jIp.start();
            this.ocO.start();
            this.jhh.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dWu() {
        Sf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sf() {
        if (this.eZA != null) {
            this.eZA.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        Le(8);
        this.ocX.ocn.setVisibility(4);
        if (this.eZA != null) {
            this.eZA.setVisibility(0);
            this.eZA.setAlpha(1.0f);
        }
        if (this.odj != null) {
            this.odj.Lh(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.ocN.cancel();
        this.ocO.cancel();
        this.jIp.cancel();
        this.jIo.cancel();
    }

    private void Le(int i) {
        this.ocX.obS.setVisibility(i);
        this.ocX.obJ.setVisibility(i);
        this.ocX.oco.setVisibility(i);
    }
}
