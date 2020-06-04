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
    private ValueAnimator hKD;
    private ValueAnimator hKE;
    private ValueAnimator lRE;
    private ValueAnimator lRF;
    private float lRG;
    private float lRH;
    private ValueAnimator lRI;
    private ValueAnimator lRJ;
    private float lRK;
    private a.c lRL;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.lRL = cVar;
        init();
    }

    private void init() {
        this.lRE = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lRE.setDuration(450L);
        this.lRE.setInterpolator(new OvershootInterpolator());
        this.lRE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.lRG != 0.0f || e.this.lRH != 0.0f) && valueAnimator.isRunning()) {
                    e.this.lRL.lRf.setCrossFade(valueAnimator.getAnimatedFraction());
                    e.this.lRL.lRf.setTranslationX(e.this.lRG - (e.this.lRG * valueAnimator.getAnimatedFraction()));
                    e.this.lRL.lRf.setTranslationY(e.this.lRH - (e.this.lRH * valueAnimator.getAnimatedFraction()));
                    e.this.lRL.lRf.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.lRE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.dMf != null) {
                    e.this.dMf.setVisibility(4);
                    e.this.dMf.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lRL.lRf.setTranslationX(0.0f);
                e.this.lRL.lRf.setTranslationY(0.0f);
                e.this.lRL.lRf.setRotation(-135.0f);
                e.this.lRL.lRf.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lRF = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lRF.setDuration(300L);
        this.lRF.setInterpolator(new AccelerateInterpolator());
        this.lRF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.lRG != 0.0f || e.this.lRH != 0.0f) && valueAnimator.isRunning()) {
                    e.this.lRL.lRf.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    e.this.lRL.lRf.setTranslationX(e.this.lRG * valueAnimator.getAnimatedFraction());
                    e.this.lRL.lRf.setTranslationY(e.this.lRH * valueAnimator.getAnimatedFraction());
                    e.this.lRL.lRf.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.lRF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lRL.lRf.setTranslationX(e.this.lRG);
                e.this.lRL.lRf.setTranslationY(e.this.lRH);
                e.this.lRL.lRf.setRotation(0.0f);
                e.this.lRL.lRf.setCrossFade(0.0f);
                if (e.this.dMf != null) {
                    e.this.dMf.setVisibility(0);
                    e.this.dMf.setAlpha(1.0f);
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
        this.hKD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.hKD.setDuration(500L);
        this.hKD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.lRL.lQG.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.lRL.lQP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hKD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lRL.lQG.setAlpha(1.0f);
                e.this.lRL.lQP.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hKE = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.hKE.setDuration(300L);
        this.hKE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.lRL.lQG.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.lRL.lQP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hKE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lRL.lQG.setAlpha(0.0f);
                e.this.lRL.lQP.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lRI = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lRI.setDuration(450L);
        this.lRI.setInterpolator(new OvershootInterpolator(1.0f));
        this.lRI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.lRL.lRg.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.lRL.lRg.setTranslationY(e.this.lRK - (e.this.lRK * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.lRI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.lRL.lRa.setClickable(false);
                e.this.lRL.lQX.setClickable(false);
                e.this.lRL.lQU.setClickable(false);
                e.this.lRL.lQR.setClickable(false);
                e.this.lRL.lRc.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lRL.lRg.setAlpha(1.0f);
                e.this.lRL.lRg.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.lRT != null) {
                    e.this.lRT.En(e.this.mState);
                }
                e.this.lRL.lRa.setClickable(true);
                e.this.lRL.lQX.setClickable(true);
                e.this.lRL.lQU.setClickable(true);
                e.this.lRL.lQR.setClickable(true);
                e.this.lRL.lRc.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lRJ = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.lRJ.setDuration(300L);
        this.lRJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.lRL.lRg.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.lRL.lRg.setTranslationY(e.this.lRK * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.lRJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.lRL.lRa.setClickable(false);
                e.this.lRL.lQX.setClickable(false);
                e.this.lRL.lQU.setClickable(false);
                e.this.lRL.lQR.setClickable(false);
                e.this.lRL.lRc.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lRL.lRg.setAlpha(0.0f);
                e.this.lRL.lRg.setTranslationY(e.this.lRK);
                e.this.dmC();
                e.this.lRL.lRa.setClickable(true);
                e.this.lRL.lQX.setClickable(true);
                e.this.lRL.lQU.setClickable(true);
                e.this.lRL.lQR.setClickable(true);
                e.this.lRL.lRc.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lRL.lQT.setVisibility(0);
        this.lRL.lQQ.setVisibility(0);
        this.lRL.lQW.setVisibility(0);
        this.lRL.lQZ.setVisibility(0);
        if (this.lRL.lRc.getVisibility() != 8) {
            this.lRL.lRc.setVisibility(0);
        }
        this.lRK = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds501);
    }

    @Override // com.baidu.tieba.write.h
    public void dmD() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.lRT != null) {
                this.lRT.En(this.mState);
            }
            clearAnimation();
            Fx(0);
            this.hKD.start();
            this.lRI.start();
            dmF();
        }
    }

    private void dmF() {
        this.lRL.lRf.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.lRZ != null && e.this.lRG == 0.0f && e.this.lRH == 0.0f) {
                    e.this.lRL.lRf.getGlobalVisibleRect(e.this.lSa);
                    e.this.lRG = e.this.lRZ.centerX() - e.this.lSa.centerX();
                    e.this.lRH = e.this.lRZ.centerY() - e.this.lSa.centerY();
                }
                e.this.lRL.lRf.setVisibility(0);
                e.this.lRL.lRf.setTranslationX(e.this.lRG);
                e.this.lRL.lRf.setTranslationY(e.this.lRH);
                if (e.this.dMf instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.dMf).a(e.this.lRL.lRf);
                }
                e.this.lRE.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void aiD() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.lRT != null) {
                this.lRT.En(this.mState);
            }
            clearAnimation();
            this.hKE.start();
            this.lRF.start();
            this.lRJ.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dmE() {
        dmC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmC() {
        if (this.dMf != null) {
            this.dMf.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        Fx(8);
        this.lRL.lRf.setVisibility(4);
        if (this.dMf != null) {
            this.dMf.setVisibility(0);
            this.dMf.setAlpha(1.0f);
        }
        if (this.lRT != null) {
            this.lRT.En(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.lRE.cancel();
        this.lRF.cancel();
        this.hKE.cancel();
        this.hKD.cancel();
    }

    private void Fx(int i) {
        this.lRL.lQP.setVisibility(i);
        this.lRL.lQG.setVisibility(i);
        this.lRL.lRg.setVisibility(i);
    }
}
