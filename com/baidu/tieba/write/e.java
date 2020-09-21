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
    private int eZt;
    private ValueAnimator iaW;
    private ValueAnimator izt;
    private ValueAnimator izu;
    private ValueAnimator mWs;
    private ValueAnimator mWt;
    private float mWu;
    private float mWv;
    private ValueAnimator mWw;
    private float mWx;
    private float mWy;
    private a.c mWz;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.mWz = cVar;
        this.eZt = l.getDimens(this.mContext, R.dimen.tbds9);
        init();
    }

    private void init() {
        this.mWs = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mWs.setDuration(450L);
        this.mWs.setInterpolator(new OvershootInterpolator());
        this.mWs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.mWu != 0.0f || e.this.mWv != 0.0f) && valueAnimator.isRunning()) {
                    e.this.mWz.mVT.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.mWz.mVT.setTranslationX(e.this.mWu - (e.this.mWu * valueAnimator.getAnimatedFraction()));
                    e.this.mWz.mVT.setTranslationY(e.this.mWv - (e.this.mWv * valueAnimator.getAnimatedFraction()));
                    e.this.mWz.mVT.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.mWs.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.elm != null) {
                    e.this.elm.setVisibility(4);
                    e.this.elm.setAlpha(0.0f);
                }
                e.this.mWz.mVT.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eZt);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mWz.mVT.setTranslationX(0.0f);
                e.this.mWz.mVT.setTranslationY(0.0f);
                e.this.mWz.mVT.setRotation(-135.0f);
                e.this.mWz.mVT.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eZt);
                e.this.mWz.mVT.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mWt = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mWt.setDuration(200L);
        this.mWt.setInterpolator(new AccelerateInterpolator());
        this.mWt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.mWu != 0.0f || e.this.mWv != 0.0f) && valueAnimator.isRunning()) {
                    e.this.mWz.mVT.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.mWz.mVT.setTranslationX(e.this.mWu * valueAnimator.getAnimatedFraction());
                    e.this.mWz.mVT.setTranslationY(e.this.mWv * valueAnimator.getAnimatedFraction());
                    e.this.mWz.mVT.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.mWt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mWz.mVT.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eZt);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mWz.mVT.setTranslationX(e.this.mWu);
                e.this.mWz.mVT.setTranslationY(e.this.mWv);
                e.this.mWz.mVT.setRotation(0.0f);
                e.this.mWz.mVT.setEndIcon(0, 0);
                e.this.mWz.mVT.setCrossFade(1.0f, true);
                if (e.this.elm != null) {
                    e.this.elm.setVisibility(0);
                    e.this.elm.setAlpha(1.0f);
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
        this.izt = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.izt.setDuration(416L);
        this.izt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mWz.mVU.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mWz.mVp.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mWz.mVy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.izt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mWz.mVU.setAlpha(1.0f);
                e.this.mWz.mVp.setAlpha(1.0f);
                e.this.mWz.mVy.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.izu = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.izu.setDuration(200L);
        this.izu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mWz.mVp.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mWz.mVy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.izu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mWz.mVp.setAlpha(0.0f);
                e.this.mWz.mVy.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mWw = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mWw.setDuration(500L);
        this.mWw.setInterpolator(new OvershootInterpolator(1.0f));
        this.mWw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mWz.mVU.setTranslationY(e.this.mWx - (e.this.mWx * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.mWw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mWz.mVJ.setClickable(false);
                e.this.mWz.mVG.setClickable(false);
                e.this.mWz.mVD.setClickable(false);
                e.this.mWz.mVA.setClickable(false);
                e.this.mWz.mVL.setClickable(false);
                e.this.mWz.mVN.setClickable(false);
                e.this.mWz.mVQ.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mWz.mVU.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.mWK != null) {
                    e.this.mWK.Ka(e.this.mState);
                }
                e.this.mWz.mVJ.setClickable(true);
                e.this.mWz.mVG.setClickable(true);
                e.this.mWz.mVD.setClickable(true);
                e.this.mWz.mVA.setClickable(true);
                e.this.mWz.mVL.setClickable(true);
                e.this.mWz.mVN.setClickable(true);
                e.this.mWz.mVQ.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iaW = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.iaW.setDuration(200L);
        this.iaW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mWz.mVU.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mWz.mVU.setTranslationY(e.this.mWy * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.iaW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mWz.mVJ.setClickable(false);
                e.this.mWz.mVG.setClickable(false);
                e.this.mWz.mVD.setClickable(false);
                e.this.mWz.mVA.setClickable(false);
                e.this.mWz.mVL.setClickable(false);
                e.this.mWz.mVN.setClickable(false);
                e.this.mWz.mVQ.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mWz.mVU.setAlpha(0.0f);
                e.this.mWz.mVU.setTranslationY(e.this.mWy);
                e.this.dJE();
                e.this.mWz.mVJ.setClickable(true);
                e.this.mWz.mVG.setClickable(true);
                e.this.mWz.mVD.setClickable(true);
                e.this.mWz.mVA.setClickable(true);
                e.this.mWz.mVL.setClickable(true);
                e.this.mWz.mVN.setClickable(true);
                e.this.mWz.mVQ.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mWz.mVC.setVisibility(0);
        this.mWz.mVz.setVisibility(0);
        this.mWz.mVF.setVisibility(0);
        this.mWz.mVI.setVisibility(0);
        this.mWz.mVL.setVisibility(0);
        if (this.mWz.mVN.getVisibility() != 8) {
            this.mWz.mVN.setVisibility(0);
        }
        this.mWx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.mWy = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
    }

    @Override // com.baidu.tieba.write.h
    public void dJF() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.mWK != null) {
                this.mWK.Ka(this.mState);
            }
            clearAnimation();
            JX(0);
            this.izt.start();
            this.mWw.start();
            dJH();
        }
    }

    private void dJH() {
        this.mWz.mVT.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.mWQ != null && e.this.mWu == 0.0f && e.this.mWv == 0.0f) {
                    e.this.mWz.mVT.getGlobalVisibleRect(e.this.mWR);
                    e.this.mWu = e.this.mWQ.centerX() - e.this.mWR.centerX();
                    e.this.mWv = e.this.mWQ.centerY() - e.this.mWR.centerY();
                }
                e.this.mWz.mVT.setVisibility(0);
                e.this.mWz.mVT.setTranslationX(e.this.mWu);
                e.this.mWz.mVT.setTranslationY(e.this.mWv);
                if (e.this.elm instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.elm).a(e.this.mWz.mVT);
                }
                e.this.mWs.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void atw() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.mWK != null) {
                this.mWK.Ka(this.mState);
            }
            clearAnimation();
            this.izu.start();
            this.mWt.start();
            this.iaW.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dJG() {
        dJE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJE() {
        if (this.elm != null) {
            this.elm.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        JX(8);
        this.mWz.mVT.setVisibility(4);
        if (this.elm != null) {
            this.elm.setVisibility(0);
            this.elm.setAlpha(1.0f);
        }
        if (this.mWK != null) {
            this.mWK.Ka(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.mWs.cancel();
        this.mWt.cancel();
        this.izu.cancel();
        this.izt.cancel();
    }

    private void JX(int i) {
        this.mWz.mVy.setVisibility(i);
        this.mWz.mVp.setVisibility(i);
        this.mWz.mVU.setVisibility(i);
    }
}
