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
    private ValueAnimator gIn;
    private ValueAnimator gIo;
    private ValueAnimator kLh;
    private ValueAnimator kLi;
    private float kLj;
    private float kLk;
    private ValueAnimator kLl;
    private ValueAnimator kLm;
    private float kLn;
    private a.b kLo;

    public e(Context context, a.b bVar) {
        super(context, bVar);
        this.kLo = bVar;
        init();
    }

    private void init() {
        this.kLh = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kLh.setDuration(450L);
        this.kLh.setInterpolator(new OvershootInterpolator());
        this.kLh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.kLj != 0.0f || e.this.kLk != 0.0f) && valueAnimator.isRunning()) {
                    e.this.kLo.kKI.setCrossFade(valueAnimator.getAnimatedFraction());
                    e.this.kLo.kKI.setTranslationX(e.this.kLj - (e.this.kLj * valueAnimator.getAnimatedFraction()));
                    e.this.kLo.kKI.setTranslationY(e.this.kLk - (e.this.kLk * valueAnimator.getAnimatedFraction()));
                    e.this.kLo.kKI.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kLh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.cUu != null) {
                    e.this.cUu.setVisibility(4);
                    e.this.cUu.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLo.kKI.setTranslationX(0.0f);
                e.this.kLo.kKI.setTranslationY(0.0f);
                e.this.kLo.kKI.setRotation(-135.0f);
                e.this.kLo.kKI.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLi = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kLi.setDuration(300L);
        this.kLi.setInterpolator(new AccelerateInterpolator());
        this.kLi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.kLj != 0.0f || e.this.kLk != 0.0f) && valueAnimator.isRunning()) {
                    e.this.kLo.kKI.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    e.this.kLo.kKI.setTranslationX(e.this.kLj * valueAnimator.getAnimatedFraction());
                    e.this.kLo.kKI.setTranslationY(e.this.kLk * valueAnimator.getAnimatedFraction());
                    e.this.kLo.kKI.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.kLi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLo.kKI.setTranslationX(e.this.kLj);
                e.this.kLo.kKI.setTranslationY(e.this.kLk);
                e.this.kLo.kKI.setRotation(0.0f);
                e.this.kLo.kKI.setCrossFade(0.0f);
                if (e.this.cUu != null) {
                    e.this.cUu.setVisibility(0);
                    e.this.cUu.setAlpha(1.0f);
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
        this.gIn = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gIn.setDuration(500L);
        this.gIn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kLo.kKp.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kLo.kKw.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gIn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLo.kKp.setAlpha(1.0f);
                e.this.kLo.kKw.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gIo = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.gIo.setDuration(300L);
        this.gIo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kLo.kKp.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kLo.kKw.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gIo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLo.kKp.setAlpha(0.0f);
                e.this.kLo.kKw.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLl = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kLl.setDuration(450L);
        this.kLl.setInterpolator(new OvershootInterpolator(1.0f));
        this.kLl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kLo.kKJ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kLo.kKJ.setTranslationY(e.this.kLn - (e.this.kLn * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.kLl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.kLo.kKG.setClickable(false);
                e.this.kLo.kKD.setClickable(false);
                e.this.kLo.kKA.setClickable(false);
                e.this.kLo.kKx.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLo.kKJ.setAlpha(1.0f);
                e.this.kLo.kKJ.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.kLv != null) {
                    e.this.kLv.CI(e.this.mState);
                }
                e.this.kLo.kKG.setClickable(true);
                e.this.kLo.kKD.setClickable(true);
                e.this.kLo.kKA.setClickable(true);
                e.this.kLo.kKx.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLm = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kLm.setDuration(300L);
        this.kLm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kLo.kKJ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kLo.kKJ.setTranslationY(e.this.kLn * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kLm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.kLo.kKG.setClickable(false);
                e.this.kLo.kKD.setClickable(false);
                e.this.kLo.kKA.setClickable(false);
                e.this.kLo.kKx.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLo.kKJ.setAlpha(0.0f);
                e.this.kLo.kKJ.setTranslationY(e.this.kLn);
                e.this.cST();
                e.this.kLo.kKG.setClickable(true);
                e.this.kLo.kKD.setClickable(true);
                e.this.kLo.kKA.setClickable(true);
                e.this.kLo.kKx.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLo.kKz.setVisibility(0);
        this.kLo.mPhotoView.setVisibility(0);
        this.kLo.kKC.setVisibility(0);
        this.kLo.kKF.setVisibility(0);
        this.kLn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds501);
    }

    @Override // com.baidu.tieba.write.g
    public void cSU() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.kLv != null) {
                this.kLv.CI(this.mState);
            }
            clearAnimation();
            DW(0);
            this.gIn.start();
            this.kLl.start();
            cSW();
        }
    }

    private void cSW() {
        this.kLo.kKI.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.kLA != null && e.this.kLj == 0.0f && e.this.kLk == 0.0f) {
                    e.this.kLo.kKI.getGlobalVisibleRect(e.this.kLB);
                    e.this.kLj = e.this.kLA.centerX() - e.this.kLB.centerX();
                    e.this.kLk = e.this.kLA.centerY() - e.this.kLB.centerY();
                }
                e.this.kLo.kKI.setVisibility(0);
                e.this.kLo.kKI.setTranslationX(e.this.kLj);
                e.this.kLo.kKI.setTranslationY(e.this.kLk);
                if (e.this.cUu instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.cUu).a(e.this.kLo.kKI);
                }
                e.this.kLh.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.g
    public void startHideAnimation() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.kLv != null) {
                this.kLv.CI(this.mState);
            }
            clearAnimation();
            this.gIo.start();
            this.kLi.start();
            this.kLm.start();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cSV() {
        cST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cST() {
        if (this.cUu != null) {
            this.cUu.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        DW(8);
        this.kLo.kKI.setVisibility(4);
        if (this.cUu != null) {
            this.cUu.setVisibility(0);
            this.cUu.setAlpha(1.0f);
        }
        if (this.kLv != null) {
            this.kLv.CI(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.g
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.kLh.cancel();
        this.kLi.cancel();
        this.gIo.cancel();
        this.gIn.cancel();
    }

    private void DW(int i) {
        this.kLo.kKw.setVisibility(i);
        this.kLo.kKp.setVisibility(i);
        this.kLo.kKJ.setVisibility(i);
    }
}
