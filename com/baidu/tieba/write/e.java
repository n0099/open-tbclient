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
    private ValueAnimator mlQ;
    private ValueAnimator mlR;
    private float mlS;
    private float mlT;
    private ValueAnimator mlU;
    private ValueAnimator mlV;
    private float mlW;
    private float mlX;
    private a.c mlY;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.mlY = cVar;
        this.eFw = l.getDimens(this.mContext, R.dimen.tbds9);
        init();
    }

    private void init() {
        this.mlQ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mlQ.setDuration(450L);
        this.mlQ.setInterpolator(new OvershootInterpolator());
        this.mlQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.mlS != 0.0f || e.this.mlT != 0.0f) && valueAnimator.isRunning()) {
                    e.this.mlY.mlr.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.mlY.mlr.setTranslationX(e.this.mlS - (e.this.mlS * valueAnimator.getAnimatedFraction()));
                    e.this.mlY.mlr.setTranslationY(e.this.mlT - (e.this.mlT * valueAnimator.getAnimatedFraction()));
                    e.this.mlY.mlr.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.mlQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.dSV != null) {
                    e.this.dSV.setVisibility(4);
                    e.this.dSV.setAlpha(0.0f);
                }
                e.this.mlY.mlr.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eFw);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mlY.mlr.setTranslationX(0.0f);
                e.this.mlY.mlr.setTranslationY(0.0f);
                e.this.mlY.mlr.setRotation(-135.0f);
                e.this.mlY.mlr.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eFw);
                e.this.mlY.mlr.setCrossFade(1.0f, false);
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
        this.mlR.setDuration(200L);
        this.mlR.setInterpolator(new AccelerateInterpolator());
        this.mlR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.mlS != 0.0f || e.this.mlT != 0.0f) && valueAnimator.isRunning()) {
                    e.this.mlY.mlr.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.mlY.mlr.setTranslationX(e.this.mlS * valueAnimator.getAnimatedFraction());
                    e.this.mlY.mlr.setTranslationY(e.this.mlT * valueAnimator.getAnimatedFraction());
                    e.this.mlY.mlr.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.mlR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mlY.mlr.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eFw);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mlY.mlr.setTranslationX(e.this.mlS);
                e.this.mlY.mlr.setTranslationY(e.this.mlT);
                e.this.mlY.mlr.setRotation(0.0f);
                e.this.mlY.mlr.setEndIcon(0, 0);
                e.this.mlY.mlr.setCrossFade(1.0f, true);
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
                    e.this.mlY.mls.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mlY.mkQ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mlY.mkZ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hXP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mlY.mls.setAlpha(1.0f);
                e.this.mlY.mkQ.setAlpha(1.0f);
                e.this.mlY.mkZ.setAlpha(1.0f);
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
                    e.this.mlY.mkQ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mlY.mkZ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hXQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mlY.mkQ.setAlpha(0.0f);
                e.this.mlY.mkZ.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mlU = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mlU.setDuration(500L);
        this.mlU.setInterpolator(new OvershootInterpolator(1.0f));
        this.mlU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mlY.mls.setTranslationY(e.this.mlW - (e.this.mlW * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.mlU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mlY.mlk.setClickable(false);
                e.this.mlY.mlh.setClickable(false);
                e.this.mlY.mle.setClickable(false);
                e.this.mlY.mlb.setClickable(false);
                e.this.mlY.mlm.setClickable(false);
                e.this.mlY.mlo.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mlY.mls.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.mmg != null) {
                    e.this.mmg.Fp(e.this.mState);
                }
                e.this.mlY.mlk.setClickable(true);
                e.this.mlY.mlh.setClickable(true);
                e.this.mlY.mle.setClickable(true);
                e.this.mlY.mlb.setClickable(true);
                e.this.mlY.mlm.setClickable(true);
                e.this.mlY.mlo.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mlV = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mlV.setDuration(200L);
        this.mlV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mlY.mls.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mlY.mls.setTranslationY(e.this.mlX * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.mlV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mlY.mlk.setClickable(false);
                e.this.mlY.mlh.setClickable(false);
                e.this.mlY.mle.setClickable(false);
                e.this.mlY.mlb.setClickable(false);
                e.this.mlY.mlm.setClickable(false);
                e.this.mlY.mlo.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mlY.mls.setAlpha(0.0f);
                e.this.mlY.mls.setTranslationY(e.this.mlX);
                e.this.dqT();
                e.this.mlY.mlk.setClickable(true);
                e.this.mlY.mlh.setClickable(true);
                e.this.mlY.mle.setClickable(true);
                e.this.mlY.mlb.setClickable(true);
                e.this.mlY.mlm.setClickable(true);
                e.this.mlY.mlo.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mlY.mld.setVisibility(0);
        this.mlY.mla.setVisibility(0);
        this.mlY.mlg.setVisibility(0);
        this.mlY.mlj.setVisibility(0);
        this.mlY.mlm.setVisibility(0);
        if (this.mlY.mlo.getVisibility() != 8) {
            this.mlY.mlo.setVisibility(0);
        }
        this.mlW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.mlX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
    }

    @Override // com.baidu.tieba.write.h
    public void dqU() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.mmg != null) {
                this.mmg.Fp(this.mState);
            }
            clearAnimation();
            GB(0);
            this.hXP.start();
            this.mlU.start();
            dqW();
        }
    }

    private void dqW() {
        this.mlY.mlr.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.mml != null && e.this.mlS == 0.0f && e.this.mlT == 0.0f) {
                    e.this.mlY.mlr.getGlobalVisibleRect(e.this.mmm);
                    e.this.mlS = e.this.mml.centerX() - e.this.mmm.centerX();
                    e.this.mlT = e.this.mml.centerY() - e.this.mmm.centerY();
                }
                e.this.mlY.mlr.setVisibility(0);
                e.this.mlY.mlr.setTranslationX(e.this.mlS);
                e.this.mlY.mlr.setTranslationY(e.this.mlT);
                if (e.this.dSV instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.dSV).a(e.this.mlY.mlr);
                }
                e.this.mlQ.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void ajJ() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.mmg != null) {
                this.mmg.Fp(this.mState);
            }
            clearAnimation();
            this.hXQ.start();
            this.mlR.start();
            this.mlV.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dqV() {
        dqT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqT() {
        if (this.dSV != null) {
            this.dSV.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        GB(8);
        this.mlY.mlr.setVisibility(4);
        if (this.dSV != null) {
            this.dSV.setVisibility(0);
            this.dSV.setAlpha(1.0f);
        }
        if (this.mmg != null) {
            this.mmg.Fp(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.mlQ.cancel();
        this.mlR.cancel();
        this.hXQ.cancel();
        this.hXP.cancel();
    }

    private void GB(int i) {
        this.mlY.mkZ.setVisibility(i);
        this.mlY.mkQ.setVisibility(i);
        this.mlY.mls.setVisibility(i);
    }
}
