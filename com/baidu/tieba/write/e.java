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
    private int flF;
    private ValueAnimator iOm;
    private ValueAnimator iOn;
    private ValueAnimator ipX;
    private ValueAnimator nlR;
    private ValueAnimator nlS;
    private float nlT;
    private float nlU;
    private ValueAnimator nlV;
    private float nlW;
    private float nlX;
    private a.c nlY;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.nlY = cVar;
        this.flF = l.getDimens(this.mContext, R.dimen.tbds9);
        init();
    }

    private void init() {
        this.nlR = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nlR.setDuration(450L);
        this.nlR.setInterpolator(new OvershootInterpolator());
        this.nlR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nlT != 0.0f || e.this.nlU != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nlY.nls.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.nlY.nls.setTranslationX(e.this.nlT - (e.this.nlT * valueAnimator.getAnimatedFraction()));
                    e.this.nlY.nls.setTranslationY(e.this.nlU - (e.this.nlU * valueAnimator.getAnimatedFraction()));
                    e.this.nlY.nls.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nlR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.exv != null) {
                    e.this.exv.setVisibility(4);
                    e.this.exv.setAlpha(0.0f);
                }
                e.this.nlY.nls.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.flF);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nlY.nls.setTranslationX(0.0f);
                e.this.nlY.nls.setTranslationY(0.0f);
                e.this.nlY.nls.setRotation(-135.0f);
                e.this.nlY.nls.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.flF);
                e.this.nlY.nls.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nlS = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nlS.setDuration(200L);
        this.nlS.setInterpolator(new AccelerateInterpolator());
        this.nlS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nlT != 0.0f || e.this.nlU != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nlY.nls.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.nlY.nls.setTranslationX(e.this.nlT * valueAnimator.getAnimatedFraction());
                    e.this.nlY.nls.setTranslationY(e.this.nlU * valueAnimator.getAnimatedFraction());
                    e.this.nlY.nls.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nlS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nlY.nls.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.flF);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nlY.nls.setTranslationX(e.this.nlT);
                e.this.nlY.nls.setTranslationY(e.this.nlU);
                e.this.nlY.nls.setRotation(0.0f);
                e.this.nlY.nls.setEndIcon(0, 0);
                e.this.nlY.nls.setCrossFade(1.0f, true);
                if (e.this.exv != null) {
                    e.this.exv.setVisibility(0);
                    e.this.exv.setAlpha(1.0f);
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
        this.iOm = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iOm.setDuration(416L);
        this.iOm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nlY.nlt.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nlY.nkO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nlY.nkX.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.iOm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nlY.nlt.setAlpha(1.0f);
                e.this.nlY.nkO.setAlpha(1.0f);
                e.this.nlY.nkX.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iOn = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.iOn.setDuration(200L);
        this.iOn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nlY.nkO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nlY.nkX.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.iOn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nlY.nkO.setAlpha(0.0f);
                e.this.nlY.nkX.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nlV = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nlV.setDuration(500L);
        this.nlV.setInterpolator(new OvershootInterpolator(1.0f));
        this.nlV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nlY.nlt.setTranslationY(e.this.nlW - (e.this.nlW * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nlV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nlY.nli.setClickable(false);
                e.this.nlY.nlf.setClickable(false);
                e.this.nlY.nlc.setClickable(false);
                e.this.nlY.nkZ.setClickable(false);
                e.this.nlY.nlk.setClickable(false);
                e.this.nlY.nlm.setClickable(false);
                e.this.nlY.nlp.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nlY.nlt.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.nmj != null) {
                    e.this.nmj.KG(e.this.mState);
                }
                e.this.nlY.nli.setClickable(true);
                e.this.nlY.nlf.setClickable(true);
                e.this.nlY.nlc.setClickable(true);
                e.this.nlY.nkZ.setClickable(true);
                e.this.nlY.nlk.setClickable(true);
                e.this.nlY.nlm.setClickable(true);
                e.this.nlY.nlp.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ipX = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.ipX.setDuration(200L);
        this.ipX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nlY.nlt.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nlY.nlt.setTranslationY(e.this.nlX * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.ipX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nlY.nli.setClickable(false);
                e.this.nlY.nlf.setClickable(false);
                e.this.nlY.nlc.setClickable(false);
                e.this.nlY.nkZ.setClickable(false);
                e.this.nlY.nlk.setClickable(false);
                e.this.nlY.nlm.setClickable(false);
                e.this.nlY.nlp.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nlY.nlt.setAlpha(0.0f);
                e.this.nlY.nlt.setTranslationY(e.this.nlX);
                e.this.dNq();
                e.this.nlY.nli.setClickable(true);
                e.this.nlY.nlf.setClickable(true);
                e.this.nlY.nlc.setClickable(true);
                e.this.nlY.nkZ.setClickable(true);
                e.this.nlY.nlk.setClickable(true);
                e.this.nlY.nlm.setClickable(true);
                e.this.nlY.nlp.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nlY.nlb.setVisibility(0);
        this.nlY.nkY.setVisibility(0);
        this.nlY.nle.setVisibility(0);
        this.nlY.nlh.setVisibility(0);
        this.nlY.nlk.setVisibility(0);
        if (this.nlY.nlm.getVisibility() != 8) {
            this.nlY.nlm.setVisibility(0);
        }
        this.nlW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.nlX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
    }

    @Override // com.baidu.tieba.write.h
    public void dNr() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nmj != null) {
                this.nmj.KG(this.mState);
            }
            clearAnimation();
            KD(0);
            this.iOm.start();
            this.nlV.start();
            dNt();
        }
    }

    private void dNt() {
        this.nlY.nls.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.nmo != null && e.this.nlT == 0.0f && e.this.nlU == 0.0f) {
                    e.this.nlY.nls.getGlobalVisibleRect(e.this.nmp);
                    e.this.nlT = e.this.nmo.centerX() - e.this.nmp.centerX();
                    e.this.nlU = e.this.nmo.centerY() - e.this.nmp.centerY();
                }
                e.this.nlY.nls.setVisibility(0);
                e.this.nlY.nls.setTranslationX(e.this.nlT);
                e.this.nlY.nls.setTranslationY(e.this.nlU);
                if (e.this.exv instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.exv).a(e.this.nlY.nls);
                }
                e.this.nlR.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void awh() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nmj != null) {
                this.nmj.KG(this.mState);
            }
            clearAnimation();
            this.iOn.start();
            this.nlS.start();
            this.ipX.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dNs() {
        dNq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNq() {
        if (this.exv != null) {
            this.exv.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        KD(8);
        this.nlY.nls.setVisibility(4);
        if (this.exv != null) {
            this.exv.setVisibility(0);
            this.exv.setAlpha(1.0f);
        }
        if (this.nmj != null) {
            this.nmj.KG(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.nlR.cancel();
        this.nlS.cancel();
        this.iOn.cancel();
        this.iOm.cancel();
    }

    private void KD(int i) {
        this.nlY.nkX.setVisibility(i);
        this.nlY.nkO.setVisibility(i);
        this.nlY.nlt.setVisibility(i);
    }
}
