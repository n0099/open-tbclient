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
    private int eLS;
    private ValueAnimator hGA;
    private ValueAnimator idR;
    private ValueAnimator idS;
    private ValueAnimator mtR;
    private ValueAnimator mtS;
    private float mtT;
    private float mtU;
    private ValueAnimator mtV;
    private float mtW;
    private float mtX;
    private a.c mtY;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.mtY = cVar;
        this.eLS = l.getDimens(this.mContext, R.dimen.tbds9);
        init();
    }

    private void init() {
        this.mtR = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mtR.setDuration(450L);
        this.mtR.setInterpolator(new OvershootInterpolator());
        this.mtR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.mtT != 0.0f || e.this.mtU != 0.0f) && valueAnimator.isRunning()) {
                    e.this.mtY.mts.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.mtY.mts.setTranslationX(e.this.mtT - (e.this.mtT * valueAnimator.getAnimatedFraction()));
                    e.this.mtY.mts.setTranslationY(e.this.mtU - (e.this.mtU * valueAnimator.getAnimatedFraction()));
                    e.this.mtY.mts.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.mtR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.dZn != null) {
                    e.this.dZn.setVisibility(4);
                    e.this.dZn.setAlpha(0.0f);
                }
                e.this.mtY.mts.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eLS);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mtY.mts.setTranslationX(0.0f);
                e.this.mtY.mts.setTranslationY(0.0f);
                e.this.mtY.mts.setRotation(-135.0f);
                e.this.mtY.mts.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eLS);
                e.this.mtY.mts.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mtS = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mtS.setDuration(200L);
        this.mtS.setInterpolator(new AccelerateInterpolator());
        this.mtS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.mtT != 0.0f || e.this.mtU != 0.0f) && valueAnimator.isRunning()) {
                    e.this.mtY.mts.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.mtY.mts.setTranslationX(e.this.mtT * valueAnimator.getAnimatedFraction());
                    e.this.mtY.mts.setTranslationY(e.this.mtU * valueAnimator.getAnimatedFraction());
                    e.this.mtY.mts.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.mtS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mtY.mts.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eLS);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mtY.mts.setTranslationX(e.this.mtT);
                e.this.mtY.mts.setTranslationY(e.this.mtU);
                e.this.mtY.mts.setRotation(0.0f);
                e.this.mtY.mts.setEndIcon(0, 0);
                e.this.mtY.mts.setCrossFade(1.0f, true);
                if (e.this.dZn != null) {
                    e.this.dZn.setVisibility(0);
                    e.this.dZn.setAlpha(1.0f);
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
        this.idR = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.idR.setDuration(416L);
        this.idR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mtY.mtt.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mtY.msR.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mtY.mta.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.idR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mtY.mtt.setAlpha(1.0f);
                e.this.mtY.msR.setAlpha(1.0f);
                e.this.mtY.mta.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.idS = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.idS.setDuration(200L);
        this.idS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mtY.msR.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mtY.mta.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.idS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mtY.msR.setAlpha(0.0f);
                e.this.mtY.mta.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mtV = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mtV.setDuration(500L);
        this.mtV.setInterpolator(new OvershootInterpolator(1.0f));
        this.mtV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mtY.mtt.setTranslationY(e.this.mtW - (e.this.mtW * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.mtV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mtY.mtl.setClickable(false);
                e.this.mtY.mti.setClickable(false);
                e.this.mtY.mtf.setClickable(false);
                e.this.mtY.mtc.setClickable(false);
                e.this.mtY.mtn.setClickable(false);
                e.this.mtY.mtp.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mtY.mtt.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.mug != null) {
                    e.this.mug.FL(e.this.mState);
                }
                e.this.mtY.mtl.setClickable(true);
                e.this.mtY.mti.setClickable(true);
                e.this.mtY.mtf.setClickable(true);
                e.this.mtY.mtc.setClickable(true);
                e.this.mtY.mtn.setClickable(true);
                e.this.mtY.mtp.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hGA = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.hGA.setDuration(200L);
        this.hGA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mtY.mtt.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mtY.mtt.setTranslationY(e.this.mtX * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.hGA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mtY.mtl.setClickable(false);
                e.this.mtY.mti.setClickable(false);
                e.this.mtY.mtf.setClickable(false);
                e.this.mtY.mtc.setClickable(false);
                e.this.mtY.mtn.setClickable(false);
                e.this.mtY.mtp.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mtY.mtt.setAlpha(0.0f);
                e.this.mtY.mtt.setTranslationY(e.this.mtX);
                e.this.duf();
                e.this.mtY.mtl.setClickable(true);
                e.this.mtY.mti.setClickable(true);
                e.this.mtY.mtf.setClickable(true);
                e.this.mtY.mtc.setClickable(true);
                e.this.mtY.mtn.setClickable(true);
                e.this.mtY.mtp.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mtY.mte.setVisibility(0);
        this.mtY.mtb.setVisibility(0);
        this.mtY.mth.setVisibility(0);
        this.mtY.mtk.setVisibility(0);
        this.mtY.mtn.setVisibility(0);
        if (this.mtY.mtp.getVisibility() != 8) {
            this.mtY.mtp.setVisibility(0);
        }
        this.mtW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.mtX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
    }

    @Override // com.baidu.tieba.write.h
    public void dug() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.mug != null) {
                this.mug.FL(this.mState);
            }
            clearAnimation();
            GX(0);
            this.idR.start();
            this.mtV.start();
            dui();
        }
    }

    private void dui() {
        this.mtY.mts.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.mul != null && e.this.mtT == 0.0f && e.this.mtU == 0.0f) {
                    e.this.mtY.mts.getGlobalVisibleRect(e.this.mum);
                    e.this.mtT = e.this.mul.centerX() - e.this.mum.centerX();
                    e.this.mtU = e.this.mul.centerY() - e.this.mum.centerY();
                }
                e.this.mtY.mts.setVisibility(0);
                e.this.mtY.mts.setTranslationX(e.this.mtT);
                e.this.mtY.mts.setTranslationY(e.this.mtU);
                if (e.this.dZn instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.dZn).a(e.this.mtY.mts);
                }
                e.this.mtR.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void akZ() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.mug != null) {
                this.mug.FL(this.mState);
            }
            clearAnimation();
            this.idS.start();
            this.mtS.start();
            this.hGA.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void duh() {
        duf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duf() {
        if (this.dZn != null) {
            this.dZn.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        GX(8);
        this.mtY.mts.setVisibility(4);
        if (this.dZn != null) {
            this.dZn.setVisibility(0);
            this.dZn.setAlpha(1.0f);
        }
        if (this.mug != null) {
            this.mug.FL(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.mtR.cancel();
        this.mtS.cancel();
        this.idS.cancel();
        this.idR.cancel();
    }

    private void GX(int i) {
        this.mtY.mta.setVisibility(i);
        this.mtY.msR.setVisibility(i);
        this.mtY.mtt.setVisibility(i);
    }
}
