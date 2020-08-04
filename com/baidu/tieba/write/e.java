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
    private ValueAnimator idT;
    private ValueAnimator idU;
    private ValueAnimator mtT;
    private ValueAnimator mtU;
    private float mtV;
    private float mtW;
    private ValueAnimator mtX;
    private float mtY;
    private float mtZ;
    private a.c mua;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.mua = cVar;
        this.eLS = l.getDimens(this.mContext, R.dimen.tbds9);
        init();
    }

    private void init() {
        this.mtT = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mtT.setDuration(450L);
        this.mtT.setInterpolator(new OvershootInterpolator());
        this.mtT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.mtV != 0.0f || e.this.mtW != 0.0f) && valueAnimator.isRunning()) {
                    e.this.mua.mtu.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.mua.mtu.setTranslationX(e.this.mtV - (e.this.mtV * valueAnimator.getAnimatedFraction()));
                    e.this.mua.mtu.setTranslationY(e.this.mtW - (e.this.mtW * valueAnimator.getAnimatedFraction()));
                    e.this.mua.mtu.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.mtT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.dZn != null) {
                    e.this.dZn.setVisibility(4);
                    e.this.dZn.setAlpha(0.0f);
                }
                e.this.mua.mtu.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eLS);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mua.mtu.setTranslationX(0.0f);
                e.this.mua.mtu.setTranslationY(0.0f);
                e.this.mua.mtu.setRotation(-135.0f);
                e.this.mua.mtu.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eLS);
                e.this.mua.mtu.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mtU = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mtU.setDuration(200L);
        this.mtU.setInterpolator(new AccelerateInterpolator());
        this.mtU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.mtV != 0.0f || e.this.mtW != 0.0f) && valueAnimator.isRunning()) {
                    e.this.mua.mtu.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.mua.mtu.setTranslationX(e.this.mtV * valueAnimator.getAnimatedFraction());
                    e.this.mua.mtu.setTranslationY(e.this.mtW * valueAnimator.getAnimatedFraction());
                    e.this.mua.mtu.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.mtU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mua.mtu.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eLS);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mua.mtu.setTranslationX(e.this.mtV);
                e.this.mua.mtu.setTranslationY(e.this.mtW);
                e.this.mua.mtu.setRotation(0.0f);
                e.this.mua.mtu.setEndIcon(0, 0);
                e.this.mua.mtu.setCrossFade(1.0f, true);
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
        this.idT = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.idT.setDuration(416L);
        this.idT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mua.mtv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mua.msT.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mua.mtc.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.idT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mua.mtv.setAlpha(1.0f);
                e.this.mua.msT.setAlpha(1.0f);
                e.this.mua.mtc.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.idU = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.idU.setDuration(200L);
        this.idU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mua.msT.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mua.mtc.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.idU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mua.msT.setAlpha(0.0f);
                e.this.mua.mtc.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mtX = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mtX.setDuration(500L);
        this.mtX.setInterpolator(new OvershootInterpolator(1.0f));
        this.mtX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mua.mtv.setTranslationY(e.this.mtY - (e.this.mtY * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.mtX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mua.mtn.setClickable(false);
                e.this.mua.mtk.setClickable(false);
                e.this.mua.mth.setClickable(false);
                e.this.mua.mte.setClickable(false);
                e.this.mua.mtp.setClickable(false);
                e.this.mua.mtr.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mua.mtv.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.mui != null) {
                    e.this.mui.FL(e.this.mState);
                }
                e.this.mua.mtn.setClickable(true);
                e.this.mua.mtk.setClickable(true);
                e.this.mua.mth.setClickable(true);
                e.this.mua.mte.setClickable(true);
                e.this.mua.mtp.setClickable(true);
                e.this.mua.mtr.setClickable(true);
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
                    e.this.mua.mtv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mua.mtv.setTranslationY(e.this.mtZ * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.hGA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mua.mtn.setClickable(false);
                e.this.mua.mtk.setClickable(false);
                e.this.mua.mth.setClickable(false);
                e.this.mua.mte.setClickable(false);
                e.this.mua.mtp.setClickable(false);
                e.this.mua.mtr.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mua.mtv.setAlpha(0.0f);
                e.this.mua.mtv.setTranslationY(e.this.mtZ);
                e.this.dug();
                e.this.mua.mtn.setClickable(true);
                e.this.mua.mtk.setClickable(true);
                e.this.mua.mth.setClickable(true);
                e.this.mua.mte.setClickable(true);
                e.this.mua.mtp.setClickable(true);
                e.this.mua.mtr.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mua.mtg.setVisibility(0);
        this.mua.mtd.setVisibility(0);
        this.mua.mtj.setVisibility(0);
        this.mua.mtm.setVisibility(0);
        this.mua.mtp.setVisibility(0);
        if (this.mua.mtr.getVisibility() != 8) {
            this.mua.mtr.setVisibility(0);
        }
        this.mtY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.mtZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
    }

    @Override // com.baidu.tieba.write.h
    public void duh() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.mui != null) {
                this.mui.FL(this.mState);
            }
            clearAnimation();
            GX(0);
            this.idT.start();
            this.mtX.start();
            duj();
        }
    }

    private void duj() {
        this.mua.mtu.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.mun != null && e.this.mtV == 0.0f && e.this.mtW == 0.0f) {
                    e.this.mua.mtu.getGlobalVisibleRect(e.this.muo);
                    e.this.mtV = e.this.mun.centerX() - e.this.muo.centerX();
                    e.this.mtW = e.this.mun.centerY() - e.this.muo.centerY();
                }
                e.this.mua.mtu.setVisibility(0);
                e.this.mua.mtu.setTranslationX(e.this.mtV);
                e.this.mua.mtu.setTranslationY(e.this.mtW);
                if (e.this.dZn instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.dZn).a(e.this.mua.mtu);
                }
                e.this.mtT.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void akZ() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.mui != null) {
                this.mui.FL(this.mState);
            }
            clearAnimation();
            this.idU.start();
            this.mtU.start();
            this.hGA.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dui() {
        dug();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dug() {
        if (this.dZn != null) {
            this.dZn.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        GX(8);
        this.mua.mtu.setVisibility(4);
        if (this.dZn != null) {
            this.dZn.setVisibility(0);
            this.dZn.setAlpha(1.0f);
        }
        if (this.mui != null) {
            this.mui.FL(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.mtT.cancel();
        this.mtU.cancel();
        this.idU.cancel();
        this.idT.cancel();
    }

    private void GX(int i) {
        this.mua.mtc.setVisibility(i);
        this.mua.msT.setVisibility(i);
        this.mua.mtv.setVisibility(i);
    }
}
