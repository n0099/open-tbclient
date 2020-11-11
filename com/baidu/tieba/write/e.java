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
    private int fzW;
    private ValueAnimator iIq;
    private ValueAnimator jgF;
    private ValueAnimator jgG;
    private ValueAnimator nEm;
    private ValueAnimator nEn;
    private float nEo;
    private float nEp;
    private ValueAnimator nEq;
    private float nEr;
    private float nEs;
    private a.c nEt;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.nEt = cVar;
        this.fzW = l.getDimens(this.mContext, R.dimen.tbds9);
        init();
    }

    private void init() {
        this.nEm = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nEm.setDuration(450L);
        this.nEm.setInterpolator(new OvershootInterpolator());
        this.nEm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nEo != 0.0f || e.this.nEp != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nEt.nDN.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.nEt.nDN.setTranslationX(e.this.nEo - (e.this.nEo * valueAnimator.getAnimatedFraction()));
                    e.this.nEt.nDN.setTranslationY(e.this.nEp - (e.this.nEp * valueAnimator.getAnimatedFraction()));
                    e.this.nEt.nDN.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nEm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.eLI != null) {
                    e.this.eLI.setVisibility(4);
                    e.this.eLI.setAlpha(0.0f);
                }
                e.this.nEt.nDN.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.fzW);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nEt.nDN.setTranslationX(0.0f);
                e.this.nEt.nDN.setTranslationY(0.0f);
                e.this.nEt.nDN.setRotation(-135.0f);
                e.this.nEt.nDN.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.fzW);
                e.this.nEt.nDN.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nEn = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nEn.setDuration(200L);
        this.nEn.setInterpolator(new AccelerateInterpolator());
        this.nEn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.nEo != 0.0f || e.this.nEp != 0.0f) && valueAnimator.isRunning()) {
                    e.this.nEt.nDN.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.nEt.nDN.setTranslationX(e.this.nEo * valueAnimator.getAnimatedFraction());
                    e.this.nEt.nDN.setTranslationY(e.this.nEp * valueAnimator.getAnimatedFraction());
                    e.this.nEt.nDN.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nEn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nEt.nDN.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.fzW);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nEt.nDN.setTranslationX(e.this.nEo);
                e.this.nEt.nDN.setTranslationY(e.this.nEp);
                e.this.nEt.nDN.setRotation(0.0f);
                e.this.nEt.nDN.setEndIcon(0, 0);
                e.this.nEt.nDN.setCrossFade(1.0f, true);
                if (e.this.eLI != null) {
                    e.this.eLI.setVisibility(0);
                    e.this.eLI.setAlpha(1.0f);
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
        this.jgF = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jgF.setDuration(416L);
        this.jgF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nEt.nDO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nEt.nDj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nEt.nDs.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jgF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nEt.nDO.setAlpha(1.0f);
                e.this.nEt.nDj.setAlpha(1.0f);
                e.this.nEt.nDs.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jgG = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jgG.setDuration(200L);
        this.jgG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nEt.nDj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nEt.nDs.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jgG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nEt.nDj.setAlpha(0.0f);
                e.this.nEt.nDs.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nEq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nEq.setDuration(500L);
        this.nEq.setInterpolator(new OvershootInterpolator(1.0f));
        this.nEq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nEt.nDO.setTranslationY(e.this.nEr - (e.this.nEr * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.nEq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nEt.nDD.setClickable(false);
                e.this.nEt.nDA.setClickable(false);
                e.this.nEt.nDx.setClickable(false);
                e.this.nEt.nDu.setClickable(false);
                e.this.nEt.nDF.setClickable(false);
                e.this.nEt.nDH.setClickable(false);
                e.this.nEt.nDK.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nEt.nDO.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.nEE != null) {
                    e.this.nEE.Ll(e.this.mState);
                }
                e.this.nEt.nDD.setClickable(true);
                e.this.nEt.nDA.setClickable(true);
                e.this.nEt.nDx.setClickable(true);
                e.this.nEt.nDu.setClickable(true);
                e.this.nEt.nDF.setClickable(true);
                e.this.nEt.nDH.setClickable(true);
                e.this.nEt.nDK.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iIq = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.iIq.setDuration(200L);
        this.iIq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.nEt.nDO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.nEt.nDO.setTranslationY(e.this.nEs * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.iIq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.nEt.nDD.setClickable(false);
                e.this.nEt.nDA.setClickable(false);
                e.this.nEt.nDx.setClickable(false);
                e.this.nEt.nDu.setClickable(false);
                e.this.nEt.nDF.setClickable(false);
                e.this.nEt.nDH.setClickable(false);
                e.this.nEt.nDK.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.nEt.nDO.setAlpha(0.0f);
                e.this.nEt.nDO.setTranslationY(e.this.nEs);
                e.this.Rw();
                e.this.nEt.nDD.setClickable(true);
                e.this.nEt.nDA.setClickable(true);
                e.this.nEt.nDx.setClickable(true);
                e.this.nEt.nDu.setClickable(true);
                e.this.nEt.nDF.setClickable(true);
                e.this.nEt.nDH.setClickable(true);
                e.this.nEt.nDK.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nEt.nDw.setVisibility(0);
        this.nEt.nDt.setVisibility(0);
        this.nEt.nDz.setVisibility(0);
        this.nEt.nDC.setVisibility(0);
        this.nEt.nDF.setVisibility(0);
        if (this.nEt.nDH.getVisibility() != 8) {
            this.nEt.nDH.setVisibility(0);
        }
        this.nEr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.nEs = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
    }

    @Override // com.baidu.tieba.write.h
    public void dSZ() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nEE != null) {
                this.nEE.Ll(this.mState);
            }
            clearAnimation();
            Li(0);
            this.jgF.start();
            this.nEq.start();
            dTb();
        }
    }

    private void dTb() {
        this.nEt.nDN.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.nEJ != null && e.this.nEo == 0.0f && e.this.nEp == 0.0f) {
                    e.this.nEt.nDN.getGlobalVisibleRect(e.this.nEK);
                    e.this.nEo = e.this.nEJ.centerX() - e.this.nEK.centerX();
                    e.this.nEp = e.this.nEJ.centerY() - e.this.nEK.centerY();
                }
                e.this.nEt.nDN.setVisibility(0);
                e.this.nEt.nDN.setTranslationX(e.this.nEo);
                e.this.nEt.nDN.setTranslationY(e.this.nEp);
                if (e.this.eLI instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.eLI).a(e.this.nEt.nDN);
                }
                e.this.nEm.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void aAB() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nEE != null) {
                this.nEE.Ll(this.mState);
            }
            clearAnimation();
            this.jgG.start();
            this.nEn.start();
            this.iIq.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dTa() {
        Rw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rw() {
        if (this.eLI != null) {
            this.eLI.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        Li(8);
        this.nEt.nDN.setVisibility(4);
        if (this.eLI != null) {
            this.eLI.setVisibility(0);
            this.eLI.setAlpha(1.0f);
        }
        if (this.nEE != null) {
            this.nEE.Ll(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.nEm.cancel();
        this.nEn.cancel();
        this.jgG.cancel();
        this.jgF.cancel();
    }

    private void Li(int i) {
        this.nEt.nDs.setVisibility(i);
        this.nEt.nDj.setVisibility(i);
        this.nEt.nDO.setVisibility(i);
    }
}
