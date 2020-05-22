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
    private ValueAnimator hJQ;
    private ValueAnimator hJR;
    private a.c lQA;
    private ValueAnimator lQt;
    private ValueAnimator lQu;
    private float lQv;
    private float lQw;
    private ValueAnimator lQx;
    private ValueAnimator lQy;
    private float lQz;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.lQA = cVar;
        init();
    }

    private void init() {
        this.lQt = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lQt.setDuration(450L);
        this.lQt.setInterpolator(new OvershootInterpolator());
        this.lQt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.lQv != 0.0f || e.this.lQw != 0.0f) && valueAnimator.isRunning()) {
                    e.this.lQA.lPU.setCrossFade(valueAnimator.getAnimatedFraction());
                    e.this.lQA.lPU.setTranslationX(e.this.lQv - (e.this.lQv * valueAnimator.getAnimatedFraction()));
                    e.this.lQA.lPU.setTranslationY(e.this.lQw - (e.this.lQw * valueAnimator.getAnimatedFraction()));
                    e.this.lQA.lPU.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.lQt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.dMf != null) {
                    e.this.dMf.setVisibility(4);
                    e.this.dMf.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lQA.lPU.setTranslationX(0.0f);
                e.this.lQA.lPU.setTranslationY(0.0f);
                e.this.lQA.lPU.setRotation(-135.0f);
                e.this.lQA.lPU.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lQu = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lQu.setDuration(300L);
        this.lQu.setInterpolator(new AccelerateInterpolator());
        this.lQu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.lQv != 0.0f || e.this.lQw != 0.0f) && valueAnimator.isRunning()) {
                    e.this.lQA.lPU.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    e.this.lQA.lPU.setTranslationX(e.this.lQv * valueAnimator.getAnimatedFraction());
                    e.this.lQA.lPU.setTranslationY(e.this.lQw * valueAnimator.getAnimatedFraction());
                    e.this.lQA.lPU.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.lQu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lQA.lPU.setTranslationX(e.this.lQv);
                e.this.lQA.lPU.setTranslationY(e.this.lQw);
                e.this.lQA.lPU.setRotation(0.0f);
                e.this.lQA.lPU.setCrossFade(0.0f);
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
        this.hJQ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.hJQ.setDuration(500L);
        this.hJQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.lQA.lPy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.lQA.lPH.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hJQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lQA.lPy.setAlpha(1.0f);
                e.this.lQA.lPH.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hJR = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.hJR.setDuration(300L);
        this.hJR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.lQA.lPy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.lQA.lPH.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hJR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lQA.lPy.setAlpha(0.0f);
                e.this.lQA.lPH.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lQx = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lQx.setDuration(450L);
        this.lQx.setInterpolator(new OvershootInterpolator(1.0f));
        this.lQx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.lQA.lPV.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.lQA.lPV.setTranslationY(e.this.lQz - (e.this.lQz * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.lQx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.lQA.lPS.setClickable(false);
                e.this.lQA.lPP.setClickable(false);
                e.this.lQA.lPM.setClickable(false);
                e.this.lQA.lPJ.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lQA.lPV.setAlpha(1.0f);
                e.this.lQA.lPV.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.lQI != null) {
                    e.this.lQI.El(e.this.mState);
                }
                e.this.lQA.lPS.setClickable(true);
                e.this.lQA.lPP.setClickable(true);
                e.this.lQA.lPM.setClickable(true);
                e.this.lQA.lPJ.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lQy = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.lQy.setDuration(300L);
        this.lQy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.lQA.lPV.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.lQA.lPV.setTranslationY(e.this.lQz * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.lQy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.lQA.lPS.setClickable(false);
                e.this.lQA.lPP.setClickable(false);
                e.this.lQA.lPM.setClickable(false);
                e.this.lQA.lPJ.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lQA.lPV.setAlpha(0.0f);
                e.this.lQA.lPV.setTranslationY(e.this.lQz);
                e.this.dmn();
                e.this.lQA.lPS.setClickable(true);
                e.this.lQA.lPP.setClickable(true);
                e.this.lQA.lPM.setClickable(true);
                e.this.lQA.lPJ.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lQA.lPL.setVisibility(0);
        this.lQA.lPI.setVisibility(0);
        this.lQA.lPO.setVisibility(0);
        this.lQA.lPR.setVisibility(0);
        this.lQz = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds501);
    }

    @Override // com.baidu.tieba.write.h
    public void dmo() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.lQI != null) {
                this.lQI.El(this.mState);
            }
            clearAnimation();
            Fv(0);
            this.hJQ.start();
            this.lQx.start();
            dmq();
        }
    }

    private void dmq() {
        this.lQA.lPU.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.lQN != null && e.this.lQv == 0.0f && e.this.lQw == 0.0f) {
                    e.this.lQA.lPU.getGlobalVisibleRect(e.this.lQO);
                    e.this.lQv = e.this.lQN.centerX() - e.this.lQO.centerX();
                    e.this.lQw = e.this.lQN.centerY() - e.this.lQO.centerY();
                }
                e.this.lQA.lPU.setVisibility(0);
                e.this.lQA.lPU.setTranslationX(e.this.lQv);
                e.this.lQA.lPU.setTranslationY(e.this.lQw);
                if (e.this.dMf instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.dMf).a(e.this.lQA.lPU);
                }
                e.this.lQt.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void aiD() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.lQI != null) {
                this.lQI.El(this.mState);
            }
            clearAnimation();
            this.hJR.start();
            this.lQu.start();
            this.lQy.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dmp() {
        dmn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmn() {
        if (this.dMf != null) {
            this.dMf.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        Fv(8);
        this.lQA.lPU.setVisibility(4);
        if (this.dMf != null) {
            this.dMf.setVisibility(0);
            this.dMf.setAlpha(1.0f);
        }
        if (this.lQI != null) {
            this.lQI.El(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.lQt.cancel();
        this.lQu.cancel();
        this.hJR.cancel();
        this.hJQ.cancel();
    }

    private void Fv(int i) {
        this.lQA.lPH.setVisibility(i);
        this.lQA.lPy.setVisibility(i);
        this.lQA.lPV.setVisibility(i);
    }
}
