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
    private ValueAnimator huX;
    private ValueAnimator huY;
    private ValueAnimator lxb;
    private ValueAnimator lxc;
    private float lxd;
    private float lxe;
    private ValueAnimator lxf;
    private ValueAnimator lxg;
    private float lxh;
    private a.b lxi;

    public e(Context context, a.b bVar) {
        super(context, bVar);
        this.lxi = bVar;
        init();
    }

    private void init() {
        this.lxb = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lxb.setDuration(450L);
        this.lxb.setInterpolator(new OvershootInterpolator());
        this.lxb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.lxd != 0.0f || e.this.lxe != 0.0f) && valueAnimator.isRunning()) {
                    e.this.lxi.lwC.setCrossFade(valueAnimator.getAnimatedFraction());
                    e.this.lxi.lwC.setTranslationX(e.this.lxd - (e.this.lxd * valueAnimator.getAnimatedFraction()));
                    e.this.lxi.lwC.setTranslationY(e.this.lxe - (e.this.lxe * valueAnimator.getAnimatedFraction()));
                    e.this.lxi.lwC.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.lxb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.dxV != null) {
                    e.this.dxV.setVisibility(4);
                    e.this.dxV.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lxi.lwC.setTranslationX(0.0f);
                e.this.lxi.lwC.setTranslationY(0.0f);
                e.this.lxi.lwC.setRotation(-135.0f);
                e.this.lxi.lwC.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lxc = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lxc.setDuration(300L);
        this.lxc.setInterpolator(new AccelerateInterpolator());
        this.lxc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.lxd != 0.0f || e.this.lxe != 0.0f) && valueAnimator.isRunning()) {
                    e.this.lxi.lwC.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    e.this.lxi.lwC.setTranslationX(e.this.lxd * valueAnimator.getAnimatedFraction());
                    e.this.lxi.lwC.setTranslationY(e.this.lxe * valueAnimator.getAnimatedFraction());
                    e.this.lxi.lwC.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.lxc.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lxi.lwC.setTranslationX(e.this.lxd);
                e.this.lxi.lwC.setTranslationY(e.this.lxe);
                e.this.lxi.lwC.setRotation(0.0f);
                e.this.lxi.lwC.setCrossFade(0.0f);
                if (e.this.dxV != null) {
                    e.this.dxV.setVisibility(0);
                    e.this.dxV.setAlpha(1.0f);
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
        this.huX = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.huX.setDuration(500L);
        this.huX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.lxi.lwg.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.lxi.lwp.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.huX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lxi.lwg.setAlpha(1.0f);
                e.this.lxi.lwp.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.huY = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.huY.setDuration(300L);
        this.huY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.lxi.lwg.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.lxi.lwp.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.huY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lxi.lwg.setAlpha(0.0f);
                e.this.lxi.lwp.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lxf = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lxf.setDuration(450L);
        this.lxf.setInterpolator(new OvershootInterpolator(1.0f));
        this.lxf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.lxi.lwD.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.lxi.lwD.setTranslationY(e.this.lxh - (e.this.lxh * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.lxf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.lxi.lwA.setClickable(false);
                e.this.lxi.lwx.setClickable(false);
                e.this.lxi.lwu.setClickable(false);
                e.this.lxi.lwr.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lxi.lwD.setAlpha(1.0f);
                e.this.lxi.lwD.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.lxp != null) {
                    e.this.lxp.DA(e.this.mState);
                }
                e.this.lxi.lwA.setClickable(true);
                e.this.lxi.lwx.setClickable(true);
                e.this.lxi.lwu.setClickable(true);
                e.this.lxi.lwr.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lxg = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.lxg.setDuration(300L);
        this.lxg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.lxi.lwD.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.lxi.lwD.setTranslationY(e.this.lxh * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.lxg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.lxi.lwA.setClickable(false);
                e.this.lxi.lwx.setClickable(false);
                e.this.lxi.lwu.setClickable(false);
                e.this.lxi.lwr.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lxi.lwD.setAlpha(0.0f);
                e.this.lxi.lwD.setTranslationY(e.this.lxh);
                e.this.deZ();
                e.this.lxi.lwA.setClickable(true);
                e.this.lxi.lwx.setClickable(true);
                e.this.lxi.lwu.setClickable(true);
                e.this.lxi.lwr.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lxi.lwt.setVisibility(0);
        this.lxi.lwq.setVisibility(0);
        this.lxi.lww.setVisibility(0);
        this.lxi.lwz.setVisibility(0);
        this.lxh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds501);
    }

    @Override // com.baidu.tieba.write.g
    public void dfa() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.lxp != null) {
                this.lxp.DA(this.mState);
            }
            clearAnimation();
            EK(0);
            this.huX.start();
            this.lxf.start();
            dfc();
        }
    }

    private void dfc() {
        this.lxi.lwC.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.lxu != null && e.this.lxd == 0.0f && e.this.lxe == 0.0f) {
                    e.this.lxi.lwC.getGlobalVisibleRect(e.this.lxv);
                    e.this.lxd = e.this.lxu.centerX() - e.this.lxv.centerX();
                    e.this.lxe = e.this.lxu.centerY() - e.this.lxv.centerY();
                }
                e.this.lxi.lwC.setVisibility(0);
                e.this.lxi.lwC.setTranslationX(e.this.lxd);
                e.this.lxi.lwC.setTranslationY(e.this.lxe);
                if (e.this.dxV instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.dxV).a(e.this.lxi.lwC);
                }
                e.this.lxb.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.g
    public void afp() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.lxp != null) {
                this.lxp.DA(this.mState);
            }
            clearAnimation();
            this.huY.start();
            this.lxc.start();
            this.lxg.start();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void dfb() {
        deZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deZ() {
        if (this.dxV != null) {
            this.dxV.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        EK(8);
        this.lxi.lwC.setVisibility(4);
        if (this.dxV != null) {
            this.dxV.setVisibility(0);
            this.dxV.setAlpha(1.0f);
        }
        if (this.lxp != null) {
            this.lxp.DA(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.g
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.lxb.cancel();
        this.lxc.cancel();
        this.huY.cancel();
        this.huX.cancel();
    }

    private void EK(int i) {
        this.lxi.lwp.setVisibility(i);
        this.lxi.lwg.setVisibility(i);
        this.lxi.lwD.setVisibility(i);
    }
}
