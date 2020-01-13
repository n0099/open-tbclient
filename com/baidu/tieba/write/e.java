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
    private ValueAnimator kLc;
    private ValueAnimator kLd;
    private float kLe;
    private float kLf;
    private ValueAnimator kLg;
    private ValueAnimator kLh;
    private float kLi;
    private a.b kLj;

    public e(Context context, a.b bVar) {
        super(context, bVar);
        this.kLj = bVar;
        init();
    }

    private void init() {
        this.kLc = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kLc.setDuration(450L);
        this.kLc.setInterpolator(new OvershootInterpolator());
        this.kLc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.kLe != 0.0f || e.this.kLf != 0.0f) && valueAnimator.isRunning()) {
                    e.this.kLj.kKD.setCrossFade(valueAnimator.getAnimatedFraction());
                    e.this.kLj.kKD.setTranslationX(e.this.kLe - (e.this.kLe * valueAnimator.getAnimatedFraction()));
                    e.this.kLj.kKD.setTranslationY(e.this.kLf - (e.this.kLf * valueAnimator.getAnimatedFraction()));
                    e.this.kLj.kKD.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kLc.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.cUu != null) {
                    e.this.cUu.setVisibility(4);
                    e.this.cUu.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLj.kKD.setTranslationX(0.0f);
                e.this.kLj.kKD.setTranslationY(0.0f);
                e.this.kLj.kKD.setRotation(-135.0f);
                e.this.kLj.kKD.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLd = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kLd.setDuration(300L);
        this.kLd.setInterpolator(new AccelerateInterpolator());
        this.kLd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.kLe != 0.0f || e.this.kLf != 0.0f) && valueAnimator.isRunning()) {
                    e.this.kLj.kKD.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    e.this.kLj.kKD.setTranslationX(e.this.kLe * valueAnimator.getAnimatedFraction());
                    e.this.kLj.kKD.setTranslationY(e.this.kLf * valueAnimator.getAnimatedFraction());
                    e.this.kLj.kKD.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.kLd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLj.kKD.setTranslationX(e.this.kLe);
                e.this.kLj.kKD.setTranslationY(e.this.kLf);
                e.this.kLj.kKD.setRotation(0.0f);
                e.this.kLj.kKD.setCrossFade(0.0f);
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
                    e.this.kLj.kKk.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kLj.kKr.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gIn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLj.kKk.setAlpha(1.0f);
                e.this.kLj.kKr.setAlpha(1.0f);
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
                    e.this.kLj.kKk.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kLj.kKr.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gIo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLj.kKk.setAlpha(0.0f);
                e.this.kLj.kKr.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLg = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kLg.setDuration(450L);
        this.kLg.setInterpolator(new OvershootInterpolator(1.0f));
        this.kLg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kLj.kKE.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kLj.kKE.setTranslationY(e.this.kLi - (e.this.kLi * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.kLg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.kLj.kKB.setClickable(false);
                e.this.kLj.kKy.setClickable(false);
                e.this.kLj.kKv.setClickable(false);
                e.this.kLj.kKs.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLj.kKE.setAlpha(1.0f);
                e.this.kLj.kKE.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.kLq != null) {
                    e.this.kLq.CI(e.this.mState);
                }
                e.this.kLj.kKB.setClickable(true);
                e.this.kLj.kKy.setClickable(true);
                e.this.kLj.kKv.setClickable(true);
                e.this.kLj.kKs.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLh = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kLh.setDuration(300L);
        this.kLh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kLj.kKE.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kLj.kKE.setTranslationY(e.this.kLi * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kLh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.kLj.kKB.setClickable(false);
                e.this.kLj.kKy.setClickable(false);
                e.this.kLj.kKv.setClickable(false);
                e.this.kLj.kKs.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLj.kKE.setAlpha(0.0f);
                e.this.kLj.kKE.setTranslationY(e.this.kLi);
                e.this.cSR();
                e.this.kLj.kKB.setClickable(true);
                e.this.kLj.kKy.setClickable(true);
                e.this.kLj.kKv.setClickable(true);
                e.this.kLj.kKs.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLj.kKu.setVisibility(0);
        this.kLj.mPhotoView.setVisibility(0);
        this.kLj.kKx.setVisibility(0);
        this.kLj.kKA.setVisibility(0);
        this.kLi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds501);
    }

    @Override // com.baidu.tieba.write.g
    public void cSS() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.kLq != null) {
                this.kLq.CI(this.mState);
            }
            clearAnimation();
            DW(0);
            this.gIn.start();
            this.kLg.start();
            cSU();
        }
    }

    private void cSU() {
        this.kLj.kKD.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.kLv != null && e.this.kLe == 0.0f && e.this.kLf == 0.0f) {
                    e.this.kLj.kKD.getGlobalVisibleRect(e.this.kLw);
                    e.this.kLe = e.this.kLv.centerX() - e.this.kLw.centerX();
                    e.this.kLf = e.this.kLv.centerY() - e.this.kLw.centerY();
                }
                e.this.kLj.kKD.setVisibility(0);
                e.this.kLj.kKD.setTranslationX(e.this.kLe);
                e.this.kLj.kKD.setTranslationY(e.this.kLf);
                if (e.this.cUu instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.cUu).a(e.this.kLj.kKD);
                }
                e.this.kLc.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.g
    public void startHideAnimation() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.kLq != null) {
                this.kLq.CI(this.mState);
            }
            clearAnimation();
            this.gIo.start();
            this.kLd.start();
            this.kLh.start();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cST() {
        cSR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSR() {
        if (this.cUu != null) {
            this.cUu.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        DW(8);
        this.kLj.kKD.setVisibility(4);
        if (this.cUu != null) {
            this.cUu.setVisibility(0);
            this.cUu.setAlpha(1.0f);
        }
        if (this.kLq != null) {
            this.kLq.CI(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.g
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.kLc.cancel();
        this.kLd.cancel();
        this.gIo.cancel();
        this.gIn.cancel();
    }

    private void DW(int i) {
        this.kLj.kKr.setVisibility(i);
        this.kLj.kKk.setVisibility(i);
        this.kLj.kKE.setVisibility(i);
    }
}
