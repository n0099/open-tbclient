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
    private int fug;
    private ValueAnimator iCt;
    private ValueAnimator jaI;
    private ValueAnimator jaJ;
    private ValueAnimator nys;
    private ValueAnimator nyt;
    private float nyu;
    private float nyv;
    private ValueAnimator nyw;
    private float nyx;
    private float nyy;
    private a.c nyz;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.nyz = cVar;
        this.fug = l.getDimens(this.mContext, R.dimen.tbds9);
        init();
    }

    private void init() {
        this.nys = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nys.setDuration(450L);
        this.nys.setInterpolator(new OvershootInterpolator());
        this.nys.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nyu != 0.0f || e.this.nyv != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nyz.nxT.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.nyz.nxT.setTranslationX(e.this.nyu - (e.this.nyu * valueAnimator.getAnimatedFraction()));
                    e.this.nyz.nxT.setTranslationY(e.this.nyv - (e.this.nyv * valueAnimator.getAnimatedFraction()));
                    e.this.nyz.nxT.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nys.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.eFT != null) {
                    e.this.eFT.setVisibility(4);
                    e.this.eFT.setAlpha(0.0f);
                }
                e.this.nyz.nxT.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.fug);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nyz.nxT.setTranslationX(0.0f);
                e.this.nyz.nxT.setTranslationY(0.0f);
                e.this.nyz.nxT.setRotation(-135.0f);
                e.this.nyz.nxT.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.fug);
                e.this.nyz.nxT.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nyt = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nyt.setDuration(200L);
        this.nyt.setInterpolator(new AccelerateInterpolator());
        this.nyt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nyu != 0.0f || e.this.nyv != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nyz.nxT.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.nyz.nxT.setTranslationX(e.this.nyu * valueAnimator.getAnimatedFraction());
                    e.this.nyz.nxT.setTranslationY(e.this.nyv * valueAnimator.getAnimatedFraction());
                    e.this.nyz.nxT.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nyt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nyz.nxT.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.fug);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nyz.nxT.setTranslationX(e.this.nyu);
                e.this.nyz.nxT.setTranslationY(e.this.nyv);
                e.this.nyz.nxT.setRotation(0.0f);
                e.this.nyz.nxT.setEndIcon(0, 0);
                e.this.nyz.nxT.setCrossFade(1.0f, true);
                if (e.this.eFT != null) {
                    e.this.eFT.setVisibility(0);
                    e.this.eFT.setAlpha(1.0f);
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
        this.jaI = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jaI.setDuration(416L);
        this.jaI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nyz.nxU.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nyz.nxp.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nyz.nxy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jaI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nyz.nxU.setAlpha(1.0f);
                e.this.nyz.nxp.setAlpha(1.0f);
                e.this.nyz.nxy.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jaJ = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jaJ.setDuration(200L);
        this.jaJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nyz.nxp.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nyz.nxy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jaJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nyz.nxp.setAlpha(0.0f);
                e.this.nyz.nxy.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nyw = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nyw.setDuration(500L);
        this.nyw.setInterpolator(new OvershootInterpolator(1.0f));
        this.nyw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nyz.nxU.setTranslationY(e.this.nyx - (e.this.nyx * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nyw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nyz.nxJ.setClickable(false);
                e.this.nyz.nxG.setClickable(false);
                e.this.nyz.nxD.setClickable(false);
                e.this.nyz.nxA.setClickable(false);
                e.this.nyz.nxL.setClickable(false);
                e.this.nyz.nxN.setClickable(false);
                e.this.nyz.nxQ.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nyz.nxU.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.nyK != null) {
                    e.this.nyK.KY(e.this.mState);
                }
                e.this.nyz.nxJ.setClickable(true);
                e.this.nyz.nxG.setClickable(true);
                e.this.nyz.nxD.setClickable(true);
                e.this.nyz.nxA.setClickable(true);
                e.this.nyz.nxL.setClickable(true);
                e.this.nyz.nxN.setClickable(true);
                e.this.nyz.nxQ.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iCt = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.iCt.setDuration(200L);
        this.iCt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nyz.nxU.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nyz.nxU.setTranslationY(e.this.nyy * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.iCt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nyz.nxJ.setClickable(false);
                e.this.nyz.nxG.setClickable(false);
                e.this.nyz.nxD.setClickable(false);
                e.this.nyz.nxA.setClickable(false);
                e.this.nyz.nxL.setClickable(false);
                e.this.nyz.nxN.setClickable(false);
                e.this.nyz.nxQ.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nyz.nxU.setAlpha(0.0f);
                e.this.nyz.nxU.setTranslationY(e.this.nyy);
                e.this.dQy();
                e.this.nyz.nxJ.setClickable(true);
                e.this.nyz.nxG.setClickable(true);
                e.this.nyz.nxD.setClickable(true);
                e.this.nyz.nxA.setClickable(true);
                e.this.nyz.nxL.setClickable(true);
                e.this.nyz.nxN.setClickable(true);
                e.this.nyz.nxQ.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nyz.nxC.setVisibility(0);
        this.nyz.nxz.setVisibility(0);
        this.nyz.nxF.setVisibility(0);
        this.nyz.nxI.setVisibility(0);
        this.nyz.nxL.setVisibility(0);
        if (this.nyz.nxN.getVisibility() != 8) {
            this.nyz.nxN.setVisibility(0);
        }
        this.nyx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.nyy = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
    }

    @Override // com.baidu.tieba.write.h
    public void dQz() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nyK != null) {
                this.nyK.KY(this.mState);
            }
            clearAnimation();
            KV(0);
            this.jaI.start();
            this.nyw.start();
            dQB();
        }
    }

    private void dQB() {
        this.nyz.nxT.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.nyP != null && e.this.nyu == 0.0f && e.this.nyv == 0.0f) {
                    e.this.nyz.nxT.getGlobalVisibleRect(e.this.nyQ);
                    e.this.nyu = e.this.nyP.centerX() - e.this.nyQ.centerX();
                    e.this.nyv = e.this.nyP.centerY() - e.this.nyQ.centerY();
                }
                e.this.nyz.nxT.setVisibility(0);
                e.this.nyz.nxT.setTranslationX(e.this.nyu);
                e.this.nyz.nxT.setTranslationY(e.this.nyv);
                if (e.this.eFT instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.eFT).a(e.this.nyz.nxT);
                }
                e.this.nys.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void ayb() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nyK != null) {
                this.nyK.KY(this.mState);
            }
            clearAnimation();
            this.jaJ.start();
            this.nyt.start();
            this.iCt.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dQA() {
        dQy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQy() {
        if (this.eFT != null) {
            this.eFT.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        KV(8);
        this.nyz.nxT.setVisibility(4);
        if (this.eFT != null) {
            this.eFT.setVisibility(0);
            this.eFT.setAlpha(1.0f);
        }
        if (this.nyK != null) {
            this.nyK.KY(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.nys.cancel();
        this.nyt.cancel();
        this.jaJ.cancel();
        this.jaI.cancel();
    }

    private void KV(int i) {
        this.nyz.nxy.setVisibility(i);
        this.nyz.nxp.setVisibility(i);
        this.nyz.nxU.setVisibility(i);
    }
}
