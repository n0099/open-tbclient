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
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public class d extends f {
    private ValueAnimator fQt;
    private ValueAnimator fQu;
    private ValueAnimator jMK;
    private ValueAnimator jML;
    private float jMM;
    private float jMN;
    private float jMO;
    private ValueAnimator jMx;
    private ValueAnimator jMy;

    public d(Context context, e.a aVar) {
        super(context, aVar);
        init();
    }

    private void init() {
        this.jMK = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jMK.setDuration(450L);
        this.jMK.setInterpolator(new OvershootInterpolator());
        this.jMK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jMM != 0.0f || d.this.jMN != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jMQ.jNr.setCrossFade(valueAnimator.getAnimatedFraction());
                    d.this.jMQ.jNr.setTranslationX(d.this.jMM - (d.this.jMM * valueAnimator.getAnimatedFraction()));
                    d.this.jMQ.jNr.setTranslationY(d.this.jMN - (d.this.jMN * valueAnimator.getAnimatedFraction()));
                    d.this.jMQ.jNr.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jMK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (d.this.bRk != null) {
                    d.this.bRk.setVisibility(4);
                    d.this.bRk.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jMQ.jNr.setTranslationX(0.0f);
                d.this.jMQ.jNr.setTranslationY(0.0f);
                d.this.jMQ.jNr.setRotation(-135.0f);
                d.this.jMQ.jNr.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jML = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jML.setDuration(300L);
        this.jML.setInterpolator(new AccelerateInterpolator());
        this.jML.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jMM != 0.0f || d.this.jMN != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jMQ.jNr.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    d.this.jMQ.jNr.setTranslationX(d.this.jMM * valueAnimator.getAnimatedFraction());
                    d.this.jMQ.jNr.setTranslationY(d.this.jMN * valueAnimator.getAnimatedFraction());
                    d.this.jMQ.jNr.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jML.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jMQ.jNr.setTranslationX(d.this.jMM);
                d.this.jMQ.jNr.setTranslationY(d.this.jMN);
                d.this.jMQ.jNr.setRotation(0.0f);
                d.this.jMQ.jNr.setCrossFade(0.0f);
                if (d.this.bRk != null) {
                    d.this.bRk.setVisibility(0);
                    d.this.bRk.setAlpha(1.0f);
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
        this.fQt = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fQt.setDuration(500L);
        this.fQt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jMQ.jNd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jMQ.jNe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fQt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jMQ.jNd.setAlpha(1.0f);
                d.this.jMQ.jNe.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fQu = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fQu.setDuration(300L);
        this.fQu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jMQ.jNd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jMQ.jNe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (d.this.jMQ.jNu.getVisibility() == 0 && d.this.jMQ.jNt.getVisibility() == 0) {
                        d.this.jMQ.jNu.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        d.this.jMQ.jNt.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fQu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jMQ.jNd.setAlpha(0.0f);
                d.this.jMQ.jNe.setAlpha(0.0f);
                if (d.this.jMQ.jNu.getVisibility() == 0 && d.this.jMQ.jNt.getVisibility() == 0) {
                    d.this.jMQ.jNu.setAlpha(0.0f);
                    d.this.jMQ.jNt.setAlpha(0);
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
        this.jMx = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jMx.setDuration(450L);
        this.jMx.setInterpolator(new OvershootInterpolator(1.0f));
        this.jMx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jMQ.jNs.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jMQ.jNs.setTranslationY(d.this.jMO - (d.this.jMO * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jMx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jMQ.jNp.setClickable(false);
                d.this.jMQ.jNm.setClickable(false);
                d.this.jMQ.jNj.setClickable(false);
                d.this.jMQ.jNg.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jMQ.jNs.setAlpha(1.0f);
                d.this.jMQ.jNs.setTranslationY(0.0f);
                d.this.mState = 2;
                if (d.this.jMY != null) {
                    d.this.jMY.CP(d.this.mState);
                }
                d.this.jMQ.jNp.setClickable(true);
                d.this.jMQ.jNm.setClickable(true);
                d.this.jMQ.jNj.setClickable(true);
                d.this.jMQ.jNg.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jMy = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jMy.setDuration(300L);
        this.jMy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jMQ.jNs.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jMQ.jNs.setTranslationY(d.this.jMO * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jMy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jMQ.jNp.setClickable(false);
                d.this.jMQ.jNm.setClickable(false);
                d.this.jMQ.jNj.setClickable(false);
                d.this.jMQ.jNg.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jMQ.jNs.setAlpha(0.0f);
                d.this.jMQ.jNs.setTranslationY(d.this.jMO);
                d.this.czI();
                d.this.jMQ.jNp.setClickable(true);
                d.this.jMQ.jNm.setClickable(true);
                d.this.jMQ.jNj.setClickable(true);
                d.this.jMQ.jNg.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jMQ.jNi.setVisibility(0);
        this.jMQ.jNf.setVisibility(0);
        this.jMQ.jNl.setVisibility(0);
        this.jMQ.jNo.setVisibility(0);
        this.jMO = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds501);
    }

    @Override // com.baidu.tieba.write.f
    public void czJ() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jMY != null) {
                this.jMY.CP(this.mState);
            }
            clearAnimation();
            CM(0);
            this.fQt.start();
            this.jMx.start();
            czO();
        }
    }

    private void czO() {
        this.jMQ.jNr.post(new Runnable() { // from class: com.baidu.tieba.write.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jNw != null && d.this.jMM == 0.0f && d.this.jMN == 0.0f) {
                    d.this.jMQ.jNr.getGlobalVisibleRect(d.this.jNx);
                    d.this.jMM = d.this.jNw.centerX() - d.this.jNx.centerX();
                    d.this.jMN = d.this.jNw.centerY() - d.this.jNx.centerY();
                }
                d.this.jMQ.jNr.setVisibility(0);
                d.this.jMQ.jNr.setTranslationX(d.this.jMM);
                d.this.jMQ.jNr.setTranslationY(d.this.jMN);
                if (d.this.bRk instanceof OvalActionButton) {
                    ((OvalActionButton) d.this.bRk).a(d.this.jMQ.jNr);
                }
                d.this.jMK.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.f
    public void czL() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jMY != null) {
                this.jMY.CP(this.mState);
            }
            clearAnimation();
            this.fQu.start();
            this.jML.start();
            this.jMy.start();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void czM() {
        czI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czI() {
        if (this.bRk != null) {
            this.bRk.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        CM(8);
        this.jMQ.jNr.setVisibility(4);
        if (this.bRk != null) {
            this.bRk.setVisibility(0);
            this.bRk.setAlpha(1.0f);
        }
        if (this.jMY != null) {
            this.jMY.CP(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.jMK.cancel();
        this.jML.cancel();
        this.fQu.cancel();
        this.fQt.cancel();
    }

    private void CM(int i) {
        this.jMQ.jNe.setVisibility(i);
        this.jMQ.jNd.setVisibility(i);
        this.jMQ.jNs.setVisibility(i);
    }
}
