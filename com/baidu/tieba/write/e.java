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
    private ValueAnimator hvd;
    private ValueAnimator hve;
    private ValueAnimator lxf;
    private ValueAnimator lxg;
    private float lxh;
    private float lxi;
    private ValueAnimator lxj;
    private ValueAnimator lxk;
    private float lxl;
    private a.b lxm;

    public e(Context context, a.b bVar) {
        super(context, bVar);
        this.lxm = bVar;
        init();
    }

    private void init() {
        this.lxf = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lxf.setDuration(450L);
        this.lxf.setInterpolator(new OvershootInterpolator());
        this.lxf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.lxh != 0.0f || e.this.lxi != 0.0f) && valueAnimator.isRunning()) {
                    e.this.lxm.lwG.setCrossFade(valueAnimator.getAnimatedFraction());
                    e.this.lxm.lwG.setTranslationX(e.this.lxh - (e.this.lxh * valueAnimator.getAnimatedFraction()));
                    e.this.lxm.lwG.setTranslationY(e.this.lxi - (e.this.lxi * valueAnimator.getAnimatedFraction()));
                    e.this.lxm.lwG.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.lxf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.dxZ != null) {
                    e.this.dxZ.setVisibility(4);
                    e.this.dxZ.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lxm.lwG.setTranslationX(0.0f);
                e.this.lxm.lwG.setTranslationY(0.0f);
                e.this.lxm.lwG.setRotation(-135.0f);
                e.this.lxm.lwG.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lxg = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lxg.setDuration(300L);
        this.lxg.setInterpolator(new AccelerateInterpolator());
        this.lxg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.lxh != 0.0f || e.this.lxi != 0.0f) && valueAnimator.isRunning()) {
                    e.this.lxm.lwG.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    e.this.lxm.lwG.setTranslationX(e.this.lxh * valueAnimator.getAnimatedFraction());
                    e.this.lxm.lwG.setTranslationY(e.this.lxi * valueAnimator.getAnimatedFraction());
                    e.this.lxm.lwG.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.lxg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lxm.lwG.setTranslationX(e.this.lxh);
                e.this.lxm.lwG.setTranslationY(e.this.lxi);
                e.this.lxm.lwG.setRotation(0.0f);
                e.this.lxm.lwG.setCrossFade(0.0f);
                if (e.this.dxZ != null) {
                    e.this.dxZ.setVisibility(0);
                    e.this.dxZ.setAlpha(1.0f);
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
        this.hvd = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.hvd.setDuration(500L);
        this.hvd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.lxm.lwk.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.lxm.lwt.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hvd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lxm.lwk.setAlpha(1.0f);
                e.this.lxm.lwt.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hve = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.hve.setDuration(300L);
        this.hve.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.lxm.lwk.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.lxm.lwt.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hve.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lxm.lwk.setAlpha(0.0f);
                e.this.lxm.lwt.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lxj = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lxj.setDuration(450L);
        this.lxj.setInterpolator(new OvershootInterpolator(1.0f));
        this.lxj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.lxm.lwH.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.lxm.lwH.setTranslationY(e.this.lxl - (e.this.lxl * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.lxj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.lxm.lwE.setClickable(false);
                e.this.lxm.lwB.setClickable(false);
                e.this.lxm.lwy.setClickable(false);
                e.this.lxm.lwv.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lxm.lwH.setAlpha(1.0f);
                e.this.lxm.lwH.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.lxt != null) {
                    e.this.lxt.DA(e.this.mState);
                }
                e.this.lxm.lwE.setClickable(true);
                e.this.lxm.lwB.setClickable(true);
                e.this.lxm.lwy.setClickable(true);
                e.this.lxm.lwv.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lxk = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.lxk.setDuration(300L);
        this.lxk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.lxm.lwH.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.lxm.lwH.setTranslationY(e.this.lxl * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.lxk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.lxm.lwE.setClickable(false);
                e.this.lxm.lwB.setClickable(false);
                e.this.lxm.lwy.setClickable(false);
                e.this.lxm.lwv.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.lxm.lwH.setAlpha(0.0f);
                e.this.lxm.lwH.setTranslationY(e.this.lxl);
                e.this.deX();
                e.this.lxm.lwE.setClickable(true);
                e.this.lxm.lwB.setClickable(true);
                e.this.lxm.lwy.setClickable(true);
                e.this.lxm.lwv.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lxm.lwx.setVisibility(0);
        this.lxm.lwu.setVisibility(0);
        this.lxm.lwA.setVisibility(0);
        this.lxm.lwD.setVisibility(0);
        this.lxl = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds501);
    }

    @Override // com.baidu.tieba.write.g
    public void deY() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.lxt != null) {
                this.lxt.DA(this.mState);
            }
            clearAnimation();
            EK(0);
            this.hvd.start();
            this.lxj.start();
            dfa();
        }
    }

    private void dfa() {
        this.lxm.lwG.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.lxy != null && e.this.lxh == 0.0f && e.this.lxi == 0.0f) {
                    e.this.lxm.lwG.getGlobalVisibleRect(e.this.lxz);
                    e.this.lxh = e.this.lxy.centerX() - e.this.lxz.centerX();
                    e.this.lxi = e.this.lxy.centerY() - e.this.lxz.centerY();
                }
                e.this.lxm.lwG.setVisibility(0);
                e.this.lxm.lwG.setTranslationX(e.this.lxh);
                e.this.lxm.lwG.setTranslationY(e.this.lxi);
                if (e.this.dxZ instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.dxZ).a(e.this.lxm.lwG);
                }
                e.this.lxf.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.g
    public void afo() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.lxt != null) {
                this.lxt.DA(this.mState);
            }
            clearAnimation();
            this.hve.start();
            this.lxg.start();
            this.lxk.start();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void deZ() {
        deX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deX() {
        if (this.dxZ != null) {
            this.dxZ.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        EK(8);
        this.lxm.lwG.setVisibility(4);
        if (this.dxZ != null) {
            this.dxZ.setVisibility(0);
            this.dxZ.setAlpha(1.0f);
        }
        if (this.lxt != null) {
            this.lxt.DA(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.g
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.lxf.cancel();
        this.lxg.cancel();
        this.hve.cancel();
        this.hvd.cancel();
    }

    private void EK(int i) {
        this.lxm.lwt.setVisibility(i);
        this.lxm.lwk.setVisibility(i);
        this.lxm.lwH.setVisibility(i);
    }
}
