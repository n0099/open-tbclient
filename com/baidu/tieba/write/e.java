package com.baidu.tieba.write;

import android.animation.Animator;
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
    private int eFw;
    private ValueAnimator hXP;
    private ValueAnimator hXQ;
    private ValueAnimator mlN;
    private ValueAnimator mlO;
    private float mlP;
    private float mlQ;
    private ValueAnimator mlR;
    private ValueAnimator mlS;
    private float mlT;
    private float mlU;
    private a.c mlV;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.mlV = cVar;
        this.eFw = l.getDimens(this.mContext, R.dimen.tbds9);
        init();
    }

    private void init() {
        this.mlN = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mlN.setDuration(450L);
        this.mlN.setInterpolator(new OvershootInterpolator());
        this.mlN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.mlP != 0.0f || e.this.mlQ != 0.0f) && valueAnimator.isRunning()) {
                    e.this.mlV.mlo.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.mlV.mlo.setTranslationX(e.this.mlP - (e.this.mlP * valueAnimator.getAnimatedFraction()));
                    e.this.mlV.mlo.setTranslationY(e.this.mlQ - (e.this.mlQ * valueAnimator.getAnimatedFraction()));
                    e.this.mlV.mlo.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.mlN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.dSV != null) {
                    e.this.dSV.setVisibility(4);
                    e.this.dSV.setAlpha(0.0f);
                }
                e.this.mlV.mlo.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eFw);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mlV.mlo.setTranslationX(0.0f);
                e.this.mlV.mlo.setTranslationY(0.0f);
                e.this.mlV.mlo.setRotation(-135.0f);
                e.this.mlV.mlo.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eFw);
                e.this.mlV.mlo.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mlO = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mlO.setDuration(200L);
        this.mlO.setInterpolator(new AccelerateInterpolator());
        this.mlO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.mlP != 0.0f || e.this.mlQ != 0.0f) && valueAnimator.isRunning()) {
                    e.this.mlV.mlo.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.mlV.mlo.setTranslationX(e.this.mlP * valueAnimator.getAnimatedFraction());
                    e.this.mlV.mlo.setTranslationY(e.this.mlQ * valueAnimator.getAnimatedFraction());
                    e.this.mlV.mlo.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.mlO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mlV.mlo.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eFw);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mlV.mlo.setTranslationX(e.this.mlP);
                e.this.mlV.mlo.setTranslationY(e.this.mlQ);
                e.this.mlV.mlo.setRotation(0.0f);
                e.this.mlV.mlo.setEndIcon(0, 0);
                e.this.mlV.mlo.setCrossFade(1.0f, true);
                if (e.this.dSV != null) {
                    e.this.dSV.setVisibility(0);
                    e.this.dSV.setAlpha(1.0f);
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
        this.hXP = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.hXP.setDuration(416L);
        this.hXP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mlV.mlp.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mlV.mkN.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mlV.mkW.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hXP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mlV.mlp.setAlpha(1.0f);
                e.this.mlV.mkN.setAlpha(1.0f);
                e.this.mlV.mkW.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hXQ = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.hXQ.setDuration(200L);
        this.hXQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mlV.mkN.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mlV.mkW.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hXQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mlV.mkN.setAlpha(0.0f);
                e.this.mlV.mkW.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mlR = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mlR.setDuration(500L);
        this.mlR.setInterpolator(new OvershootInterpolator(1.0f));
        this.mlR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mlV.mlp.setTranslationY(e.this.mlT - (e.this.mlT * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.mlR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mlV.mlh.setClickable(false);
                e.this.mlV.mle.setClickable(false);
                e.this.mlV.mlb.setClickable(false);
                e.this.mlV.mkY.setClickable(false);
                e.this.mlV.mlj.setClickable(false);
                e.this.mlV.mll.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mlV.mlp.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.mmd != null) {
                    e.this.mmd.Fp(e.this.mState);
                }
                e.this.mlV.mlh.setClickable(true);
                e.this.mlV.mle.setClickable(true);
                e.this.mlV.mlb.setClickable(true);
                e.this.mlV.mkY.setClickable(true);
                e.this.mlV.mlj.setClickable(true);
                e.this.mlV.mll.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mlS = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mlS.setDuration(200L);
        this.mlS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mlV.mlp.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mlV.mlp.setTranslationY(e.this.mlU * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.mlS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mlV.mlh.setClickable(false);
                e.this.mlV.mle.setClickable(false);
                e.this.mlV.mlb.setClickable(false);
                e.this.mlV.mkY.setClickable(false);
                e.this.mlV.mlj.setClickable(false);
                e.this.mlV.mll.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mlV.mlp.setAlpha(0.0f);
                e.this.mlV.mlp.setTranslationY(e.this.mlU);
                e.this.dqP();
                e.this.mlV.mlh.setClickable(true);
                e.this.mlV.mle.setClickable(true);
                e.this.mlV.mlb.setClickable(true);
                e.this.mlV.mkY.setClickable(true);
                e.this.mlV.mlj.setClickable(true);
                e.this.mlV.mll.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mlV.mla.setVisibility(0);
        this.mlV.mkX.setVisibility(0);
        this.mlV.mld.setVisibility(0);
        this.mlV.mlg.setVisibility(0);
        this.mlV.mlj.setVisibility(0);
        if (this.mlV.mll.getVisibility() != 8) {
            this.mlV.mll.setVisibility(0);
        }
        this.mlT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.mlU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
    }

    @Override // com.baidu.tieba.write.h
    public void dqQ() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.mmd != null) {
                this.mmd.Fp(this.mState);
            }
            clearAnimation();
            GB(0);
            this.hXP.start();
            this.mlR.start();
            dqS();
        }
    }

    private void dqS() {
        this.mlV.mlo.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.mmi != null && e.this.mlP == 0.0f && e.this.mlQ == 0.0f) {
                    e.this.mlV.mlo.getGlobalVisibleRect(e.this.mmj);
                    e.this.mlP = e.this.mmi.centerX() - e.this.mmj.centerX();
                    e.this.mlQ = e.this.mmi.centerY() - e.this.mmj.centerY();
                }
                e.this.mlV.mlo.setVisibility(0);
                e.this.mlV.mlo.setTranslationX(e.this.mlP);
                e.this.mlV.mlo.setTranslationY(e.this.mlQ);
                if (e.this.dSV instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.dSV).a(e.this.mlV.mlo);
                }
                e.this.mlN.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void ajJ() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.mmd != null) {
                this.mmd.Fp(this.mState);
            }
            clearAnimation();
            this.hXQ.start();
            this.mlO.start();
            this.mlS.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dqR() {
        dqP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqP() {
        if (this.dSV != null) {
            this.dSV.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        GB(8);
        this.mlV.mlo.setVisibility(4);
        if (this.dSV != null) {
            this.dSV.setVisibility(0);
            this.dSV.setAlpha(1.0f);
        }
        if (this.mmd != null) {
            this.mmd.Fp(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.mlN.cancel();
        this.mlO.cancel();
        this.hXQ.cancel();
        this.hXP.cancel();
    }

    private void GB(int i) {
        this.mlV.mkW.setVisibility(i);
        this.mlV.mkN.setVisibility(i);
        this.mlV.mlp.setVisibility(i);
    }
}
