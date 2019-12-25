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
public class e extends g {
    private ValueAnimator gEY;
    private ValueAnimator gEZ;
    private ValueAnimator kHB;
    private ValueAnimator kHC;
    private float kHD;
    private float kHE;
    private ValueAnimator kHF;
    private ValueAnimator kHG;
    private float kHH;
    private a.b kHI;

    public e(Context context, a.b bVar) {
        super(context, bVar);
        this.kHI = bVar;
        init();
    }

    private void init() {
        this.kHB = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kHB.setDuration(450L);
        this.kHB.setInterpolator(new OvershootInterpolator());
        this.kHB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.kHD != 0.0f || e.this.kHE != 0.0f) && valueAnimator.isRunning()) {
                    e.this.kHI.kHc.setCrossFade(valueAnimator.getAnimatedFraction());
                    e.this.kHI.kHc.setTranslationX(e.this.kHD - (e.this.kHD * valueAnimator.getAnimatedFraction()));
                    e.this.kHI.kHc.setTranslationY(e.this.kHE - (e.this.kHE * valueAnimator.getAnimatedFraction()));
                    e.this.kHI.kHc.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kHB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.cUk != null) {
                    e.this.cUk.setVisibility(4);
                    e.this.cUk.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kHI.kHc.setTranslationX(0.0f);
                e.this.kHI.kHc.setTranslationY(0.0f);
                e.this.kHI.kHc.setRotation(-135.0f);
                e.this.kHI.kHc.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kHC = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kHC.setDuration(300L);
        this.kHC.setInterpolator(new AccelerateInterpolator());
        this.kHC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.kHD != 0.0f || e.this.kHE != 0.0f) && valueAnimator.isRunning()) {
                    e.this.kHI.kHc.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    e.this.kHI.kHc.setTranslationX(e.this.kHD * valueAnimator.getAnimatedFraction());
                    e.this.kHI.kHc.setTranslationY(e.this.kHE * valueAnimator.getAnimatedFraction());
                    e.this.kHI.kHc.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.kHC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kHI.kHc.setTranslationX(e.this.kHD);
                e.this.kHI.kHc.setTranslationY(e.this.kHE);
                e.this.kHI.kHc.setRotation(0.0f);
                e.this.kHI.kHc.setCrossFade(0.0f);
                if (e.this.cUk != null) {
                    e.this.cUk.setVisibility(0);
                    e.this.cUk.setAlpha(1.0f);
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
        this.gEY = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gEY.setDuration(500L);
        this.gEY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kHI.kGJ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kHI.kGQ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gEY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kHI.kGJ.setAlpha(1.0f);
                e.this.kHI.kGQ.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gEZ = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.gEZ.setDuration(300L);
        this.gEZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kHI.kGJ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kHI.kGQ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gEZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kHI.kGJ.setAlpha(0.0f);
                e.this.kHI.kGQ.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kHF = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kHF.setDuration(450L);
        this.kHF.setInterpolator(new OvershootInterpolator(1.0f));
        this.kHF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kHI.kHd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kHI.kHd.setTranslationY(e.this.kHH - (e.this.kHH * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.kHF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.kHI.kHa.setClickable(false);
                e.this.kHI.kGX.setClickable(false);
                e.this.kHI.kGU.setClickable(false);
                e.this.kHI.kGR.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kHI.kHd.setAlpha(1.0f);
                e.this.kHI.kHd.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.kHP != null) {
                    e.this.kHP.DT(e.this.mState);
                }
                e.this.kHI.kHa.setClickable(true);
                e.this.kHI.kGX.setClickable(true);
                e.this.kHI.kGU.setClickable(true);
                e.this.kHI.kGR.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kHG = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kHG.setDuration(300L);
        this.kHG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kHI.kHd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kHI.kHd.setTranslationY(e.this.kHH * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kHG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.kHI.kHa.setClickable(false);
                e.this.kHI.kGX.setClickable(false);
                e.this.kHI.kGU.setClickable(false);
                e.this.kHI.kGR.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kHI.kHd.setAlpha(0.0f);
                e.this.kHI.kHd.setTranslationY(e.this.kHH);
                e.this.cRO();
                e.this.kHI.kHa.setClickable(true);
                e.this.kHI.kGX.setClickable(true);
                e.this.kHI.kGU.setClickable(true);
                e.this.kHI.kGR.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kHI.kGT.setVisibility(0);
        this.kHI.mPhotoView.setVisibility(0);
        this.kHI.kGW.setVisibility(0);
        this.kHI.kGZ.setVisibility(0);
        this.kHH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds501);
    }

    @Override // com.baidu.tieba.write.g
    public void cRP() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.kHP != null) {
                this.kHP.DT(this.mState);
            }
            clearAnimation();
            DQ(0);
            this.gEY.start();
            this.kHF.start();
            cRR();
        }
    }

    private void cRR() {
        this.kHI.kHc.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.kHU != null && e.this.kHD == 0.0f && e.this.kHE == 0.0f) {
                    e.this.kHI.kHc.getGlobalVisibleRect(e.this.kHV);
                    e.this.kHD = e.this.kHU.centerX() - e.this.kHV.centerX();
                    e.this.kHE = e.this.kHU.centerY() - e.this.kHV.centerY();
                }
                e.this.kHI.kHc.setVisibility(0);
                e.this.kHI.kHc.setTranslationX(e.this.kHD);
                e.this.kHI.kHc.setTranslationY(e.this.kHE);
                if (e.this.cUk instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.cUk).a(e.this.kHI.kHc);
                }
                e.this.kHB.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.g
    public void startHideAnimation() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.kHP != null) {
                this.kHP.DT(this.mState);
            }
            clearAnimation();
            this.gEZ.start();
            this.kHC.start();
            this.kHG.start();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cRQ() {
        cRO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRO() {
        if (this.cUk != null) {
            this.cUk.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        DQ(8);
        this.kHI.kHc.setVisibility(4);
        if (this.cUk != null) {
            this.cUk.setVisibility(0);
            this.cUk.setAlpha(1.0f);
        }
        if (this.kHP != null) {
            this.kHP.DT(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.g
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.kHB.cancel();
        this.kHC.cancel();
        this.gEZ.cancel();
        this.gEY.cancel();
    }

    private void DQ(int i) {
        this.kHI.kGQ.setVisibility(i);
        this.kHI.kGJ.setVisibility(i);
        this.kHI.kHd.setVisibility(i);
    }
}
