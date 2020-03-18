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
    private ValueAnimator gLF;
    private ValueAnimator gLG;
    private ValueAnimator kNK;
    private ValueAnimator kNL;
    private float kNM;
    private float kNN;
    private ValueAnimator kNO;
    private ValueAnimator kNP;
    private float kNQ;
    private a.b kNR;

    public e(Context context, a.b bVar) {
        super(context, bVar);
        this.kNR = bVar;
        init();
    }

    private void init() {
        this.kNK = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kNK.setDuration(450L);
        this.kNK.setInterpolator(new OvershootInterpolator());
        this.kNK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.kNM != 0.0f || e.this.kNN != 0.0f) && valueAnimator.isRunning()) {
                    e.this.kNR.kNl.setCrossFade(valueAnimator.getAnimatedFraction());
                    e.this.kNR.kNl.setTranslationX(e.this.kNM - (e.this.kNM * valueAnimator.getAnimatedFraction()));
                    e.this.kNR.kNl.setTranslationY(e.this.kNN - (e.this.kNN * valueAnimator.getAnimatedFraction()));
                    e.this.kNR.kNl.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kNK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.cYL != null) {
                    e.this.cYL.setVisibility(4);
                    e.this.cYL.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kNR.kNl.setTranslationX(0.0f);
                e.this.kNR.kNl.setTranslationY(0.0f);
                e.this.kNR.kNl.setRotation(-135.0f);
                e.this.kNR.kNl.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kNL = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kNL.setDuration(300L);
        this.kNL.setInterpolator(new AccelerateInterpolator());
        this.kNL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.kNM != 0.0f || e.this.kNN != 0.0f) && valueAnimator.isRunning()) {
                    e.this.kNR.kNl.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    e.this.kNR.kNl.setTranslationX(e.this.kNM * valueAnimator.getAnimatedFraction());
                    e.this.kNR.kNl.setTranslationY(e.this.kNN * valueAnimator.getAnimatedFraction());
                    e.this.kNR.kNl.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.kNL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kNR.kNl.setTranslationX(e.this.kNM);
                e.this.kNR.kNl.setTranslationY(e.this.kNN);
                e.this.kNR.kNl.setRotation(0.0f);
                e.this.kNR.kNl.setCrossFade(0.0f);
                if (e.this.cYL != null) {
                    e.this.cYL.setVisibility(0);
                    e.this.cYL.setAlpha(1.0f);
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
        this.gLF = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gLF.setDuration(500L);
        this.gLF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kNR.kMQ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kNR.kMZ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gLF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kNR.kMQ.setAlpha(1.0f);
                e.this.kNR.kMZ.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gLG = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.gLG.setDuration(300L);
        this.gLG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kNR.kMQ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kNR.kMZ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gLG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kNR.kMQ.setAlpha(0.0f);
                e.this.kNR.kMZ.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kNO = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kNO.setDuration(450L);
        this.kNO.setInterpolator(new OvershootInterpolator(1.0f));
        this.kNO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kNR.kNm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kNR.kNm.setTranslationY(e.this.kNQ - (e.this.kNQ * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.kNO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.kNR.kNj.setClickable(false);
                e.this.kNR.kNg.setClickable(false);
                e.this.kNR.kNd.setClickable(false);
                e.this.kNR.kNa.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kNR.kNm.setAlpha(1.0f);
                e.this.kNR.kNm.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.kNY != null) {
                    e.this.kNY.CW(e.this.mState);
                }
                e.this.kNR.kNj.setClickable(true);
                e.this.kNR.kNg.setClickable(true);
                e.this.kNR.kNd.setClickable(true);
                e.this.kNR.kNa.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kNP = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kNP.setDuration(300L);
        this.kNP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kNR.kNm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kNR.kNm.setTranslationY(e.this.kNQ * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kNP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.kNR.kNj.setClickable(false);
                e.this.kNR.kNg.setClickable(false);
                e.this.kNR.kNd.setClickable(false);
                e.this.kNR.kNa.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kNR.kNm.setAlpha(0.0f);
                e.this.kNR.kNm.setTranslationY(e.this.kNQ);
                e.this.cUE();
                e.this.kNR.kNj.setClickable(true);
                e.this.kNR.kNg.setClickable(true);
                e.this.kNR.kNd.setClickable(true);
                e.this.kNR.kNa.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kNR.kNc.setVisibility(0);
        this.kNR.mPhotoView.setVisibility(0);
        this.kNR.kNf.setVisibility(0);
        this.kNR.kNi.setVisibility(0);
        this.kNQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds501);
    }

    @Override // com.baidu.tieba.write.g
    public void cUF() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.kNY != null) {
                this.kNY.CW(this.mState);
            }
            clearAnimation();
            Ej(0);
            this.gLF.start();
            this.kNO.start();
            cUH();
        }
    }

    private void cUH() {
        this.kNR.kNl.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.kOd != null && e.this.kNM == 0.0f && e.this.kNN == 0.0f) {
                    e.this.kNR.kNl.getGlobalVisibleRect(e.this.kOe);
                    e.this.kNM = e.this.kOd.centerX() - e.this.kOe.centerX();
                    e.this.kNN = e.this.kOd.centerY() - e.this.kOe.centerY();
                }
                e.this.kNR.kNl.setVisibility(0);
                e.this.kNR.kNl.setTranslationX(e.this.kNM);
                e.this.kNR.kNl.setTranslationY(e.this.kNN);
                if (e.this.cYL instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.cYL).a(e.this.kNR.kNl);
                }
                e.this.kNK.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.g
    public void startHideAnimation() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.kNY != null) {
                this.kNY.CW(this.mState);
            }
            clearAnimation();
            this.gLG.start();
            this.kNL.start();
            this.kNP.start();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cUG() {
        cUE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUE() {
        if (this.cYL != null) {
            this.cYL.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        Ej(8);
        this.kNR.kNl.setVisibility(4);
        if (this.cYL != null) {
            this.cYL.setVisibility(0);
            this.cYL.setAlpha(1.0f);
        }
        if (this.kNY != null) {
            this.kNY.CW(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.g
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.kNK.cancel();
        this.kNL.cancel();
        this.gLG.cancel();
        this.gLF.cancel();
    }

    private void Ej(int i) {
        this.kNR.kMZ.setVisibility(i);
        this.kNR.kMQ.setVisibility(i);
        this.kNR.kNm.setVisibility(i);
    }
}
