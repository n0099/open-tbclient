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
    private int eWC;
    private ValueAnimator hTW;
    private ValueAnimator isd;
    private ValueAnimator ise;
    private float mMA;
    private float mMB;
    private ValueAnimator mMC;
    private float mMD;
    private float mME;
    private a.c mMF;
    private ValueAnimator mMy;
    private ValueAnimator mMz;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.mMF = cVar;
        this.eWC = l.getDimens(this.mContext, R.dimen.tbds9);
        init();
    }

    private void init() {
        this.mMy = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mMy.setDuration(450L);
        this.mMy.setInterpolator(new OvershootInterpolator());
        this.mMy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.mMA != 0.0f || e.this.mMB != 0.0f) && valueAnimator.isRunning()) {
                    e.this.mMF.mLZ.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.mMF.mLZ.setTranslationX(e.this.mMA - (e.this.mMA * valueAnimator.getAnimatedFraction()));
                    e.this.mMF.mLZ.setTranslationY(e.this.mMB - (e.this.mMB * valueAnimator.getAnimatedFraction()));
                    e.this.mMF.mLZ.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.mMy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.eiX != null) {
                    e.this.eiX.setVisibility(4);
                    e.this.eiX.setAlpha(0.0f);
                }
                e.this.mMF.mLZ.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eWC);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mMF.mLZ.setTranslationX(0.0f);
                e.this.mMF.mLZ.setTranslationY(0.0f);
                e.this.mMF.mLZ.setRotation(-135.0f);
                e.this.mMF.mLZ.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eWC);
                e.this.mMF.mLZ.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mMz = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mMz.setDuration(200L);
        this.mMz.setInterpolator(new AccelerateInterpolator());
        this.mMz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.mMA != 0.0f || e.this.mMB != 0.0f) && valueAnimator.isRunning()) {
                    e.this.mMF.mLZ.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.mMF.mLZ.setTranslationX(e.this.mMA * valueAnimator.getAnimatedFraction());
                    e.this.mMF.mLZ.setTranslationY(e.this.mMB * valueAnimator.getAnimatedFraction());
                    e.this.mMF.mLZ.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.mMz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mMF.mLZ.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eWC);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mMF.mLZ.setTranslationX(e.this.mMA);
                e.this.mMF.mLZ.setTranslationY(e.this.mMB);
                e.this.mMF.mLZ.setRotation(0.0f);
                e.this.mMF.mLZ.setEndIcon(0, 0);
                e.this.mMF.mLZ.setCrossFade(1.0f, true);
                if (e.this.eiX != null) {
                    e.this.eiX.setVisibility(0);
                    e.this.eiX.setAlpha(1.0f);
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
        this.isd = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.isd.setDuration(416L);
        this.isd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mMF.mMa.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mMF.mLv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mMF.mLE.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.isd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mMF.mMa.setAlpha(1.0f);
                e.this.mMF.mLv.setAlpha(1.0f);
                e.this.mMF.mLE.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ise = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.ise.setDuration(200L);
        this.ise.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mMF.mLv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mMF.mLE.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.ise.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mMF.mLv.setAlpha(0.0f);
                e.this.mMF.mLE.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mMC = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mMC.setDuration(500L);
        this.mMC.setInterpolator(new OvershootInterpolator(1.0f));
        this.mMC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mMF.mMa.setTranslationY(e.this.mMD - (e.this.mMD * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.mMC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mMF.mLP.setClickable(false);
                e.this.mMF.mLM.setClickable(false);
                e.this.mMF.mLJ.setClickable(false);
                e.this.mMF.mLG.setClickable(false);
                e.this.mMF.mLR.setClickable(false);
                e.this.mMF.mLT.setClickable(false);
                e.this.mMF.mLW.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mMF.mMa.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.mMO != null) {
                    e.this.mMO.Jw(e.this.mState);
                }
                e.this.mMF.mLP.setClickable(true);
                e.this.mMF.mLM.setClickable(true);
                e.this.mMF.mLJ.setClickable(true);
                e.this.mMF.mLG.setClickable(true);
                e.this.mMF.mLR.setClickable(true);
                e.this.mMF.mLT.setClickable(true);
                e.this.mMF.mLW.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hTW = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.hTW.setDuration(200L);
        this.hTW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mMF.mMa.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mMF.mMa.setTranslationY(e.this.mME * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.hTW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mMF.mLP.setClickable(false);
                e.this.mMF.mLM.setClickable(false);
                e.this.mMF.mLJ.setClickable(false);
                e.this.mMF.mLG.setClickable(false);
                e.this.mMF.mLR.setClickable(false);
                e.this.mMF.mLT.setClickable(false);
                e.this.mMF.mLW.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mMF.mMa.setAlpha(0.0f);
                e.this.mMF.mMa.setTranslationY(e.this.mME);
                e.this.dFK();
                e.this.mMF.mLP.setClickable(true);
                e.this.mMF.mLM.setClickable(true);
                e.this.mMF.mLJ.setClickable(true);
                e.this.mMF.mLG.setClickable(true);
                e.this.mMF.mLR.setClickable(true);
                e.this.mMF.mLT.setClickable(true);
                e.this.mMF.mLW.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mMF.mLI.setVisibility(0);
        this.mMF.mLF.setVisibility(0);
        this.mMF.mLL.setVisibility(0);
        this.mMF.mLO.setVisibility(0);
        this.mMF.mLR.setVisibility(0);
        if (this.mMF.mLT.getVisibility() != 8) {
            this.mMF.mLT.setVisibility(0);
        }
        this.mMD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.mME = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
    }

    @Override // com.baidu.tieba.write.h
    public void dFL() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.mMO != null) {
                this.mMO.Jw(this.mState);
            }
            clearAnimation();
            Jt(0);
            this.isd.start();
            this.mMC.start();
            dFN();
        }
    }

    private void dFN() {
        this.mMF.mLZ.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.mMT != null && e.this.mMA == 0.0f && e.this.mMB == 0.0f) {
                    e.this.mMF.mLZ.getGlobalVisibleRect(e.this.mMU);
                    e.this.mMA = e.this.mMT.centerX() - e.this.mMU.centerX();
                    e.this.mMB = e.this.mMT.centerY() - e.this.mMU.centerY();
                }
                e.this.mMF.mLZ.setVisibility(0);
                e.this.mMF.mLZ.setTranslationX(e.this.mMA);
                e.this.mMF.mLZ.setTranslationY(e.this.mMB);
                if (e.this.eiX instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.eiX).a(e.this.mMF.mLZ);
                }
                e.this.mMy.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void asN() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.mMO != null) {
                this.mMO.Jw(this.mState);
            }
            clearAnimation();
            this.ise.start();
            this.mMz.start();
            this.hTW.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dFM() {
        dFK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFK() {
        if (this.eiX != null) {
            this.eiX.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        Jt(8);
        this.mMF.mLZ.setVisibility(4);
        if (this.eiX != null) {
            this.eiX.setVisibility(0);
            this.eiX.setAlpha(1.0f);
        }
        if (this.mMO != null) {
            this.mMO.Jw(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.mMy.cancel();
        this.mMz.cancel();
        this.ise.cancel();
        this.isd.cancel();
    }

    private void Jt(int i) {
        this.mMF.mLE.setVisibility(i);
        this.mMF.mLv.setVisibility(i);
        this.mMF.mMa.setVisibility(i);
    }
}
